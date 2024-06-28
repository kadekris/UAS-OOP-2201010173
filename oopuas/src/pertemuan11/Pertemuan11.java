package pertemuan11;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author INSTIKI
 * TGL: 2024-06-28
 * 
 */
public class Pertemuan11 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {        
       //list_all();
       
       //loadformteman
        frmdataobat FTeman = new frmdataobat();
        FTeman.setResizable(false);
        FTeman.setVisible(true);
    }
    
    public static void list_all() throws SQLException{
        Connection cnn = koneksi.getConnection();
        if(cnn.isClosed()){
            System.out.println("Koneksi gagal");
        }else{
            String sqlvd = "SELECT nama, jenis, kode FROM dataobat;";
            PreparedStatement PS=cnn.prepareStatement(sqlvd);
            ResultSet rs= PS.executeQuery();
            while(rs.next()){
                System.out.println("Nama   : "+rs.getString("nama"));
                System.out.println("Jenis : "+rs.getString("jenis"));
                System.out.println("Kode   : "+rs.getString("kode"));
            }
            cnn.close();
        }
    }
    
}
