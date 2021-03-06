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
@Entity
@Table(name = "jalan")
@ToString
public class LaporanJalan {
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
    private String konstruksi;
    private double panjang;
    private double lebar;
    private double tebal;
    private double luas;
    private String alamat;
    private String status;
    private String keterangan;
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
