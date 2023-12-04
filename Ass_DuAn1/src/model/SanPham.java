
package model;

public class SanPham {
    private String ma;
    private String ten;
    private Double gia;
    private String loaiSP;
    private int soLuong;

    public SanPham() {
    }

    public SanPham(String ma, String ten, Double gia, String loaiSP, int soLuong) {
        this.ma = ma;
        this.ten = ten;
        this.gia = gia;
        this.loaiSP = loaiSP;
        this.soLuong = soLuong;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Double getGia() {
        return gia;
    }

    public void setGia(Double gia) {
        this.gia = gia;
    }

    public String getLoaiSP() {
        return loaiSP;
    }

    public void setLoaiSP(String loaiSP) {
        this.loaiSP = loaiSP;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    @Override
    public String toString() {
        return "SanPham{" + "ma=" + ma + ", ten=" + ten + ", gia=" + gia + ", loaiSP=" + loaiSP + ", soLuong=" + soLuong + '}';
    }

    
    
}
