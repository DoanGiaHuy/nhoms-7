/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Dell
 */
public class KhuyenMai {
    private String MaKM;
    private int SoLuong;
    private String TenKM;
    private String NgayBatDau;
    private String NgayKetThuc;
    private String LoaiSP;
    private int GiamGia;
    private String TrangThai;
    private int IDHoaDon;

    public KhuyenMai() {
    }

    public KhuyenMai(String MaKM, int SoLuong, String TenKM, String NgayBatDau, String NgayKetThuc, String LoaiSP, int GiamGia, String TrangThai, int IDHoaDon) {
        this.MaKM = MaKM;
        this.SoLuong = SoLuong;
        this.TenKM = TenKM;
        this.NgayBatDau = NgayBatDau;
        this.NgayKetThuc = NgayKetThuc;
        this.LoaiSP = LoaiSP;
        this.GiamGia = GiamGia;
        this.TrangThai = TrangThai;
        this.IDHoaDon = IDHoaDon;
    }

    public String getMaKM() {
        return MaKM;
    }

    public void setMaKM(String MaKM) {
        this.MaKM = MaKM;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public String getTenKM() {
        return TenKM;
    }

    public void setTenKM(String TenKM) {
        this.TenKM = TenKM;
    }

    public String getNgayBatDau() {
        return NgayBatDau;
    }

    public void setNgayBatDau(String NgayBatDau) {
        this.NgayBatDau = NgayBatDau;
    }

    public String getNgayKetThuc() {
        return NgayKetThuc;
    }

    public void setNgayKetThuc(String NgayKetThuc) {
        this.NgayKetThuc = NgayKetThuc;
    }

    public String getLoaiSP() {
        return LoaiSP;
    }

    public void setLoaiSP(String LoaiSP) {
        this.LoaiSP = LoaiSP;
    }

    public int getGiamGia() {
        return GiamGia;
    }

    public void setGiamGia(int GiamGia) {
        this.GiamGia = GiamGia;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }

    public int getIDHoaDon() {
        return IDHoaDon;
    }

    public void setIDHoaDon(int IDHoaDon) {
        this.IDHoaDon = IDHoaDon;
    }

    @Override
    public String toString() {
        return "KhuyenMai{" + "MaKM=" + MaKM + ", SoLuong=" + SoLuong + ", TenKM=" + TenKM + ", NgayBatDau=" + NgayBatDau + ", NgayKetThuc=" + NgayKetThuc + ", LoaiSP=" + LoaiSP + ", GiamGia=" + GiamGia + ", TrangThai=" + TrangThai + ", IDHoaDon=" + IDHoaDon + '}';
    }

  
}
