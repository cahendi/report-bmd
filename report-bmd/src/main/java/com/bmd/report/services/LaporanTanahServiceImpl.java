package com.bmd.report.services;

import com.bmd.report.entities.LaporanTanah;
import com.bmd.report.repositories.LaporanTanahRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaporanTanahServiceImpl implements LaporanTanahService{

    @Autowired
    private LaporanTanahRepository repository;

    @Override
    public List<LaporanTanah> getLaporanTanah() {
        return repository.findAll();
    }

    @Override
    public List<LaporanTanah> getLaporanTanahSKPD(long idopd) {
        return repository.getLaporanTanahByIdopd(idopd);
    }
}
