package com.bmd.report.services;

import com.bmd.report.entities.LaporanTanah;

import java.util.List;

public interface LaporanTanahService {
    public List<LaporanTanah> getLaporanTanah();
    public List<LaporanTanah> getLaporanTanahSKPD(long idopd);
}
