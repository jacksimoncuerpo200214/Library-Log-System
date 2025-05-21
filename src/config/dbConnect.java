package config;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Base64;


public class dbConnect {
    
    public dbConnect(){
        // Constructor can be empty or used for other initialization if needed
    }
    
    public static Connection getConnection() {
        Connection connect = null;
        try {
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
        } catch (SQLException ex) {
            System.out.println("Can't connect to database: " + ex.getMessage());
        }
        return connect;
    }
    
    public ResultSet getData(String sql) throws SQLException {
        Connection connect = getConnection();
        Statement stmt = connect.createStatement();
        return stmt.executeQuery(sql);
    }
    
    public int InsertData(String sql){
        int result;
        try(Connection connect = getConnection()){
            PreparedStatement pst = connect.prepareStatement(sql);
            pst.executeUpdate();
            System.out.println("Inserted Successfully! ");
            pst.close();
            result = 1;
        }catch(SQLException ex){
            System.out.println("Connection Error: "+ex);
            result = 0;
        }
        return result;
    }
 
    public static boolean updateDatabase(String sql) {
         try(Connection connect = getConnection()){
            PreparedStatement pst = connect.prepareStatement(sql);
            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Error in Updating: " + e.getMessage());
            return false;
        }
    }
    public static String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hashBytes = md.digest(password.getBytes());
        String encoded = Base64.getEncoder().encodeToString(hashBytes);
        return encoded;
    }    
}
