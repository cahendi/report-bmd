package com.bmd.report.repositories;

import com.bmd.report.entities.LaporanTanah;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LaporanTanahRepository extends JpaRepository<LaporanTanah, Long> {
    public List<LaporanTanah> getLaporanTanahByIdopd(long idopd);
}
