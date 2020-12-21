package com.bmd.report.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "mesin")
@Entity
@ToString
public class LaporanMesin {
    @Id
    private long masterkey;
    private long idopd;
    private String kodelokasi;
    private String kodebarang;
    private String namabarang;
    private String nomorregister;
    private short kondisi;
    private Date tanggalperolehan;
    private short tahunperolehan;
    private String asalusul;
    private int quantity;
    private String satuan;
    private String namaspesifik;
    private String merk;
    private String tipe;
    private String cc;
    private String bahan;
    private String nomorpabrik;
    private String nomorrangka;
    private String nomormesin;
    private String nomorpolisi;
    private String nomorbpkb;
    private double hargaperolehan;
    private short ueb;
    private double akumulasipenyusutansebelumnya;
    private double nilaibukusebelumnya;
    private short sisauebsebelumnya;
    private double bebanpenyusutan;
    private double akumulasipenyusutan;
    private double nilaibuku;
    private short sisaueb;
}
