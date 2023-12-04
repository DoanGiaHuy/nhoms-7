/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.HoaDon;
import model.KhachHang;
import model.KhuyenMai;
import utility.DBContext;

/**
 *
 * @author Dell
 */
public class KhuyenMaiService {
     public ArrayList<KhuyenMai> getAllSanPham(){
        ArrayList<KhuyenMai> lst = new ArrayList<>();
        String sql = "SELECT * FROM VOUCHERCT";
        Connection cn = DBContext.getConnection();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {                
                KhuyenMai km = new KhuyenMai();
                km.setMaKM(rs.getString("MAKM"));
                km.setSoLuong(rs.getInt("SOLUONG"));
                km.setTenKM(rs.getString("TENKHUYENMAI"));
                km.setNgayBatDau(rs.getString("NGAYBATDAU"));
                km.setNgayKetThuc(rs.getString("NGAYKETTHUC"));
                km.setLoaiSP(rs.getString("LOAISP"));
                km.setGiamGia(rs.getInt("GIAMGIA"));
                km.setTrangThai(rs.getString("TRANGTHAI"));
                km.setIDHoaDon(rs.getInt("IDHOADON"));
                
                lst.add(km);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return lst;
    }
     
     public Integer addKhuyenMai(KhuyenMai km){
        Integer row = null;
        String sql = "insert into VOUCHERCT(MAKM, SOLUONG, TENKHUYENMAI, NGAYBATDAU, NGAYKETTHUC, LOAISP, GIAMGIA, TRANGTHAI, IDHOADON)  values (?,?,?,?,?,?,?,?,?)";
        Connection cn = DBContext.getConnection();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setString(1, km.getMaKM());
            pstm.setInt(2, km.getSoLuong());
            pstm.setString(3, km.getTenKM());
            pstm.setString(4, km.getNgayBatDau());
            pstm.setString(5, km.getNgayKetThuc());
            pstm.setString(6, km.getLoaiSP());
            pstm.setInt(7, km.getGiamGia());
            pstm.setString(8, km.getTrangThai());
            pstm.setInt(9, km.getIDHoaDon());
            row = pstm.executeUpdate();
        } catch (Exception e) {
            System.err.println(e);
        }
        return row;
    }
     
     public Integer updateKhuyenMai(KhuyenMai km){
        Integer row = null;
        String sql = "update VOUCHERCT set SOLUONG = ?,TENKHUYENMAI = ?,NGAYBATDAU = ?,NGAYKETTHUC = ?,LOAISP = ?,GIAMGIA =?,TRANGTHAI = ?,IDHOADON = ? \n" +
                        "where MAKM like ?";
        Connection cn = DBContext.getConnection();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setString(9, km.getMaKM());
            pstm.setInt(1, km.getSoLuong());
            pstm.setString(2, km.getTenKM());
            pstm.setString(3, km.getNgayBatDau());
            pstm.setString(4, km.getNgayKetThuc());
            pstm.setString(5, km.getLoaiSP());
            pstm.setInt(6, km.getGiamGia());
            pstm.setString(7, km.getTrangThai());
            pstm.setInt(8, km.getIDHoaDon());
            row = pstm.executeUpdate();
        } catch (Exception e) {
            System.err.println(e);
        }
        return row;
    }
     
     public Integer deleteKhuyenMai(KhuyenMai km){
        Integer row = null;
        String sql = "delete from VOUCHERCT where MAKM like ?";
        Connection cn = DBContext.getConnection();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setString(1, km.getMaKM());    
            row = pstm.executeUpdate();
        } catch (Exception e) {
            System.err.println(e);
        }
        return row;
    }
}
