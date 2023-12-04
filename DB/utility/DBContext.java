
package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DBContext {
    public static String USERNAME = "sa";
    public static String PASSWORD= "DGH1192004";
    public static String URL = "jdbc:sqlserver://localhost:1433;databaseName=CONGNGHE123456;encrypt=true;trustServerCertificate=true;";
    static {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Connection getConnection() {
        Connection cn = null;
        try {
            cn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cn;
    }

    public static void main(String[] args) {
        Connection  cn = getConnection();
        if (cn!=null) {
            System.out.println("Kết nối thành công");
        } else {
            System.out.println("Lỗi kết nối");
        }
    }

}
