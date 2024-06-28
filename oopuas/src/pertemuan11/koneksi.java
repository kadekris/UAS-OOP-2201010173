package pertemuan11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author INSTIKI
 * TGL: 2024-06-28
 */
public class koneksi {
    public static Connection getConnection() throws SQLException{
       Connection cnn = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/databaseobat","root","");
        } catch (ClassNotFoundException ex) {
            System.out.println("Koneksi ke database gagal");
        }
       
       return cnn;
    }
}
