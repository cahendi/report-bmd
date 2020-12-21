package com.bmd.report.controller;

import com.bmd.report.entities.LaporanTanah;
import com.bmd.report.services.LaporanTanahService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tanah")
public class LaporanTanahController {
    @Autowired
    private LaporanTanahService service;

    @GetMapping("/")
    public List<LaporanTanah> getListTanah(){
        return service.getLaporanTanah();
    }
}
