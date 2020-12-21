package com.bmd.report.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tanah")
@ToString
public class LaporanTanah {
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
    private Date tanggalsertifikat;
    private String nomorsertifikat;
    private double luas;
    private String alamat;
    private String penggunaan;
    private String haktanah;
    private String keterangan;
    private double hargaperolehan;

    public long getMasterkey() {
        return masterkey;
    }

    public void setMasterkey(long masterkey) {
        this.masterkey = masterkey;
    }

    public long getIdopd() {
        return idopd;
    }

    public void setIdopd(long idopd) {
        this.idopd = idopd;
    }

    public String getKodelokasi() {
        return kodelokasi;
    }

    public void setKodelokasi(String kodelokasi) {
        this.kodelokasi = kodelokasi;
    }

    public String getKodebarang() {
        return kodebarang;
    }

    public void setKodebarang(String kodebarang) {
        this.kodebarang = kodebarang;
    }

    public String getNamabarang() {
        return namabarang;
    }

    public void setNamabarang(String namabarang) {
        this.namabarang = namabarang;
    }

    public String getNomorregister() {
        return nomorregister;
    }

    public void setNomorregister(String nomorregister) {
        this.nomorregister = nomorregister;
    }

    public short getKondisi() {
        return kondisi;
    }

    public void setKondisi(short kondisi) {
        this.kondisi = kondisi;
    }

    public Date getTanggalperolehan() {
        return tanggalperolehan;
    }

    public void setTanggalperolehan(Date tanggalperolehan) {
        this.tanggalperolehan = tanggalperolehan;
    }

    public short getTahunperolehan() {
        return tahunperolehan;
    }

    public void setTahunperolehan(short tahunperolehan) {
        this.tahunperolehan = tahunperolehan;
    }

    public String getAsalusul() {
        return asalusul;
    }

    public void setAsalusul(String asalusul) {
        this.asalusul = asalusul;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSatuan() {
        return satuan;
    }

    public void setSatuan(String satuan) {
        this.satuan = satuan;
    }

    public Date getTanggalsertifikat() {
        return tanggalsertifikat;
    }

    public void setTanggalsertifikat(Date tanggalsertifikat) {
        this.tanggalsertifikat = tanggalsertifikat;
    }

    public String getNomorsertifikat() {
        return nomorsertifikat;
    }

    public void setNomorsertifikat(String nomorsertifikat) {
        this.nomorsertifikat = nomorsertifikat;
    }

    public double getLuas() {
        return luas;
    }

    public void setLuas(double luas) {
        this.luas = luas;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getPenggunaan() {
        return penggunaan;
    }

    public void setPenggunaan(String penggunaan) {
        this.penggunaan = penggunaan;
    }

    public String getHaktanah() {
        return haktanah;
    }

    public void setHaktanah(String haktanah) {
        this.haktanah = haktanah;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public double getHargaperolehan() {
        return hargaperolehan;
    }

    public void setHargaperolehan(double hargaperolehan) {
        this.hargaperolehan = hargaperolehan;
    }
}
