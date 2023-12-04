
package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.SanPham;
import utility.DBContext;

public class SanPhamService {

    private Object loaisp;
    public ArrayList<SanPham> getAllSanPham(){
        ArrayList<SanPham> lst = new ArrayList<>();
        String sql = "select *  from SANPHAM";
        Connection cn = DBContext.getConnection();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {                
                SanPham sp = new SanPham();
                sp.setMa(rs.getString("MASP"));
                sp.setTen(rs.getString("TENSP"));
                sp.setGia(rs.getDouble("GIA"));
                sp.setLoaiSP(rs.getString("LOAISP"));
                sp.setSoLuong(rs.getInt("SOLUONG"));
                lst.add(sp);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return lst;
    }
    
    public Integer addSanPham(SanPham sp){
        Integer row = null;
        String sql = "insert into SANPHAM (MASP,TENSP,GIA,LOAISP,SOLUONG) values (?,?,?,?,?)";
        Connection cn = DBContext.getConnection();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setString(1, sp.getMa());
            pstm.setString(2, sp.getTen());
            pstm.setDouble(3, sp.getGia());
            pstm.setString(4, sp.getLoaiSP());
            pstm.setInt(5, sp.getSoLuong());
            row = pstm.executeUpdate();
        } catch (Exception e) {
            System.err.println(e);
        }
        return row;
    }
    
    public Integer updateSanPham(SanPham sp){
        Integer row = null;
        String sql = "update SANPHAM set TENSP = ?, GIA = ?, LOAISP = ?, SOLUONG = ? where MASP like ?";
        Connection cn = DBContext.getConnection();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setString(5, sp.getMa());
            pstm.setString(1, sp.getTen());
            pstm.setDouble(2, sp.getGia());
            pstm.setString(3, sp.getLoaiSP());
            pstm.setInt(4, sp.getSoLuong());
            row = pstm.executeUpdate();
        } catch (Exception e) {
            System.err.println(e);
        }
        return row;
    }
    
    public Integer deleteSanPham(SanPham sp){
        Integer row = null;
        String sql = "delete from SANPHAM where MASP like ?";
        Connection cn = DBContext.getConnection();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setString(1, sp.getMa());    
            row = pstm.executeUpdate();
        } catch (Exception e) {
            System.err.println(e);
        }
        return row;
    }
    public List<SanPham> search(String loaisp) {
        List<SanPham> list = new ArrayList<>();
        String sql = "Select MASP,TENSP,GIA,LOAISP,SOLUONG from  SANPHAM where LOAISP like ?";
        try {
            Connection con = DBContext.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setObject(1, loaisp);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                SanPham sp = new SanPham(rs.getString(1), rs.getString(2), rs.getDouble(3),rs.getString(4), rs.getInt(5));
                list.add(sp);
            }
            return list;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
