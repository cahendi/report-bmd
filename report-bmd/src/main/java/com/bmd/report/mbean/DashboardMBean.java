package com.bmd.report.mbean;

import com.bmd.report.entities.LaporanTanah;
import com.bmd.report.services.LaporanTanahService;
import org.primefaces.model.FilterMeta;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortMeta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import static java.lang.Integer.getInteger;

@Component
@ManagedBean
@Scope("view")
public class DashboardMBean implements Serializable {

    @Autowired
    private LaporanTanahService service;

    private LazyDataModel<LaporanTanah> lazyDataModel;

    private List<LaporanTanah> list = new ArrayList<>();
    private List<LaporanTanah> listFilter = new ArrayList<>();
    private LaporanTanah selectedTanah;

    @PostConstruct
    public void init(){
        System.out.println("Test");
        list = service.getLaporanTanah();
        System.out.println("List "+list.size());
    }

    private void onLoadData(){
        lazyDataModel = new LazyDataModel<LaporanTanah>() {
            @Override
            public List<LaporanTanah> load(int first, int pageSize, Map<String, SortMeta> sortBy, Map<String, FilterMeta> filterBy) {
                List<LaporanTanah> result = new ArrayList<>();

                return result;
            }
        };
    }

    public boolean globalFilterFunction(Object value, Object filter, Locale locale) {
        String filterText = (filter == null) ? null : filter.toString().trim().toLowerCase();
        if (filterText == null || filterText.equals("")) {
            return true;
        }
        int filterInt = getInteger(filterText);
        LaporanTanah obj = (LaporanTanah) value;
        return obj.getKodebarang().toLowerCase().contains(filterText)
                ||obj.getNamabarang().toLowerCase().contains(filterText)
                ||obj.getAlamat().toLowerCase().contains(filterText);
    }

    private int getInteger(String string) {
        try {
            return Integer.valueOf(string);
        }
        catch (NumberFormatException ex) {
            return 0;
        }
    }

    public List<LaporanTanah> getList() {
        return list;
    }

    public void setList(List<LaporanTanah> list) {
        this.list = list;
    }

    public List<LaporanTanah> getListFilter() {
        return listFilter;
    }

    public void setListFilter(List<LaporanTanah> listFilter) {
        this.listFilter = listFilter;
    }

    public LaporanTanah getSelectedTanah() {
        return selectedTanah;
    }

    public void setSelectedTanah(LaporanTanah selectedTanah) {
        this.selectedTanah = selectedTanah;
    }
}
