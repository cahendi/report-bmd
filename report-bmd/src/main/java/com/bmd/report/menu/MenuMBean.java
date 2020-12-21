package com.bmd.report.menu;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;

@Component
@ManagedBean(name = "menuMBean")
@ViewScoped
public class MenuMBean implements Serializable {
    private MenuModel model = new DefaultMenuModel();

    @PostConstruct
    void init(){
        try{
            String url = "http://localhost/";
            model.getElements().add(daftar_barang_pemda("Daftar Barang Pemda", url + "daftar_barang_pemda/"));
            model.getElements().add(daftar_barang_skpd("Daftar Barang SKPD", url + "daftar_barang_skpd/"));
            model.getElements().add(neraca_pemda("Neraca PEMDA", url + "neraca_pemda/"));
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private DefaultSubMenu daftar_barang_skpd(String menuName, String url){
        DefaultSubMenu datamaster = new DefaultSubMenu();
        datamaster.setLabel(menuName);
        addMenuItem(datamaster, "Tanah", url);
        addMenuItem(datamaster, "Peralatan dan Mesin", url);
        addMenuItem(datamaster, "Bangunan dan Gedung", url);
        addMenuItem(datamaster, "Jalan Irigasi dan Jembatan", url);
        addMenuItem(datamaster, "Asset Tetap Lainnya", url);
        addMenuItem(datamaster, "Konstruksi Dalam Pengerjaan", url);
        return datamaster;
    }

    private DefaultSubMenu daftar_barang_pemda(String menuName, String url){
        DefaultSubMenu datamaster = new DefaultSubMenu();
        datamaster.setLabel(menuName);
        addMenuItem(datamaster, "Tanah", url);
        addMenuItem(datamaster, "Peralatan dan Mesin", url);
        addMenuItem(datamaster, "Bangunan dan Gedung", url);
        addMenuItem(datamaster, "Jalan Irigasi dan Jembatan", url);
        addMenuItem(datamaster, "Asset Tetap Lainnya", url);
        addMenuItem(datamaster, "Konstruksi Dalam Pengerjaan", url);
        return datamaster;
    }

    private DefaultSubMenu neraca_pemda(String menuName, String url){
        DefaultSubMenu datamaster = new DefaultSubMenu();
        datamaster.setLabel(menuName);
        addMenuItem(datamaster, "Neraca Aset Pemda", url);
        addMenuItem(datamaster, "Neraca Aset SKPD", url);
        return datamaster;
    }

    private void addMenuItem(DefaultSubMenu parentMenu, String name, String url) {
        DefaultMenuItem menuItem = new DefaultMenuItem();
        menuItem.setValue(name);
        menuItem.setIcon("");
        menuItem.setUrl(url+name.replace(' ', '-') + ".xhtml");
        parentMenu.getElements().add(menuItem);
    }

    public MenuModel getModel() {
        return model;
    }

    public void setModel(MenuModel model) {
        this.model = model;
    }
}
