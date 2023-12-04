/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.KhachHang;
import utility.DBContext;

/**
 *
 * @author Dell
 */
public class KhachHangService {
    public ArrayList<KhachHang> getAllKhachHang(){
        ArrayList<KhachHang> lst = new ArrayList<>();
        String sql = "SELECT * FROM KHACHHANG";
        Connection cn = DBContext.getConnection();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {                
                KhachHang kh = new KhachHang();
                kh.setMaKH(rs.getString("MAKH"));
                kh.setTenKH(rs.getString("TENKH"));
                kh.setNgaySinh(rs.getString("NGAYSINH"));
                kh.setDiaChi(rs.getString("DIACHI"));
                kh.setSDT(rs.getString("SDT"));
                lst.add(kh);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return lst;
    }
    
    public Integer addKhachHang(KhachHang kh){
        Integer row = null;
        String sql = "insert into KHACHHANG(MAKH, TENKH, NGAYSINH, DIACHI, SDT)  values (?,?,?,?,?)";
        Connection cn = DBContext.getConnection();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setString(1, kh.getMaKH());
            pstm.setString(2, kh.getTenKH());
            pstm.setString(3, kh.getNgaySinh());
            pstm.setString(4, kh.getDiaChi());
            pstm.setString(5, kh.getSDT());
            row = pstm.executeUpdate();
        } catch (Exception e) {
            System.err.println(e);
        }
        return row;
    }
    
    public Integer updateKhachHang(KhachHang kh){
        Integer row = null;
        String sql = "update KHACHHANG set TENKH = ?, NGAYSINH = ?,DIACHI = ?, SDT = ? where MAKH like ?";
        Connection cn = DBContext.getConnection();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setString(5, kh.getMaKH());
            pstm.setString(1, kh.getTenKH());
            pstm.setString(2, kh.getNgaySinh());
            pstm.setString(3, kh.getDiaChi());
            pstm.setString(4, kh.getSDT());
            row = pstm.executeUpdate();
        } catch (Exception e) {
            System.err.println(e);
        }
        return row;
    }
    
    public Integer deleteKhachHang(KhachHang kh){
        Integer row = null;
        String sql = "delete from KHACHHANG where MAKH like ?";
        Connection cn = DBContext.getConnection();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setString(1, kh.getMaKH());    
            row = pstm.executeUpdate();
        } catch (Exception e) {
            System.err.println(e);
        }
        return row;
    }
    
}
