/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.NhanVien;
import utility.DBContext;

/**
 *
 * @author Dell
 */
public class NhanVienService {
     public ArrayList<NhanVien> getAllSanPham(){
        ArrayList<NhanVien> lst = new ArrayList<>();
        String sql = "SELECT * FROM NHANVIEN";
        Connection cn = DBContext.getConnection();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {                
                NhanVien nv = new NhanVien();
                nv.setMaNV(rs.getString("MANV"));
                nv.setTenNV(rs.getString("TENNV"));
                nv.setNgaySinh(rs.getString("NGAYSINH"));
                nv.setGioiTinh(rs.getBoolean("GIOITINH"));
                nv.setEmail(rs.getString("EMAIL"));
                nv.setDiaChi(rs.getString("DIACHI"));
                nv.setSDT(rs.getString("SDT"));
                nv.setMatKhau(rs.getString("MATKHAU"));
                nv.setVaiTro(rs.getString("VAITRO"));
                
                lst.add(nv);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return lst;
    }
    
     public Integer addNhanVien(NhanVien nv){
        Integer row = null;
        String sql = "insert into NHANVIEN(MANV, TENNV, NGAYSINH, GIOITINH, EMAIL, DIACHI, SDT, MATKHAU, VAITRO)  values (?,?,?,?,?,?,?,?,?)";
        Connection cn = DBContext.getConnection();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setString(1, nv.getMaNV());
            pstm.setString(2, nv.getTenNV());
            pstm.setString(3, nv.getNgaySinh());
            pstm.setBoolean(4, nv.isGioiTinh());
            pstm.setString(5, nv.getEmail());
            pstm.setString(6, nv.getDiaChi());
            pstm.setString(7, nv.getSDT());
            pstm.setString(8, nv.getMatKhau());
            pstm.setString(9, nv.getVaiTro());
            row = pstm.executeUpdate();
        } catch (Exception e) {
            System.err.println(e);
        }
        return row;    
    }
     
     public Integer updateNhanVien(NhanVien nv){
        Integer row = null;
        String sql = "update NHANVIEN set TENNV = ?, NGAYSINH = ?,GIOITINH = ?,EMAIL =?, DIACHI =?, SDT =? ,MATKHAU =?, VAITRO = ?\n" +
                    "where MANV like ?";
        Connection cn = DBContext.getConnection();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setString(9, nv.getMaNV());
            pstm.setString(1, nv.getTenNV());
            pstm.setString(2, nv.getNgaySinh());
            pstm.setBoolean(3, nv.isGioiTinh());
            pstm.setString(4, nv.getEmail());
            pstm.setString(5, nv.getDiaChi());
            pstm.setString(6, nv.getSDT());
            pstm.setString(7, nv.getMatKhau());
            pstm.setString(8, nv.getVaiTro());
            row = pstm.executeUpdate();
        } catch (Exception e) {
            System.err.println(e);
        }
        return row;
    }
     
    public Integer deleteNhanVien(NhanVien nv){
        Integer row = null;
        String sql = "delete from NHANVIEN where MANV like ?";
        Connection cn = DBContext.getConnection();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setString(1, nv.getMaNV());    
            row = pstm.executeUpdate();
        } catch (Exception e) {
            System.err.println(e);
        }
        return row;
    }
}
