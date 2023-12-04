
package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.HoaDon;
import utility.DBContext;


public class HoaDonService {
    public ArrayList<HoaDon> getAllSanPham(){
        ArrayList<HoaDon> lst = new ArrayList<>();
        String sql = "SELECT * FROM HOADONCHITIET";
        Connection cn = DBContext.getConnection();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {                
                HoaDon sp = new HoaDon();
                sp.setMaHD(rs.getString("MAHD"));
                sp.setMaSP(rs.getString("MASP"));
                sp.setTenSP(rs.getString("TENSP"));
                sp.setSoLuong(rs.getInt("SOLUONG"));
                sp.setGia(rs.getDouble("GIA"));
                lst.add(sp);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return lst;
    }
    
    public Integer addHoaDon(HoaDon hd){
        Integer row = null;
        String sql = "insert into HOADONCHITIET(MAHD, MASP, TENSP, SOLUONG, GIA)  values (?,?,?,?,?)";
        Connection cn = DBContext.getConnection();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setString(1, hd.getMaHD());
            pstm.setString(2, hd.getMaSP());
            pstm.setString(3, hd.getTenSP());
            pstm.setInt(4, hd.getSoLuong());
            pstm.setDouble(5, hd.getGia());
            row = pstm.executeUpdate();
        } catch (Exception e) {
            System.err.println(e);
        }
        return row;
    }
    
    public Integer deleteHoaDon(HoaDon hd){
        Integer row = null;
        String sql = "delete from HOADONCHITIET where MAHD like ?";
        Connection cn = DBContext.getConnection();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setString(1, hd.getMaHD());    
            row = pstm.executeUpdate();
        } catch (Exception e) {
            System.err.println(e);
        }
        return row;
    }
}
