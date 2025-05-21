/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logs;

import config.dbConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class logger {
     private static dbConnect db = new dbConnect();

    public static void logAction(int userID, String action) {
        String queryCheck = "SELECT UserID FROM user WHERE UserID = ?";
        String queryInsert = "INSERT INTO logs (user_id, action) VALUES (?, ?)";
        try (Connection con = db.getConnection()) {
            // Check if user exists
            try (PreparedStatement pstCheck = con.prepareStatement(queryCheck)) {
                pstCheck.setInt(1, userID);
                try (ResultSet rs = pstCheck.executeQuery()) {
                    if (!rs.next()) {
                        
                        System.err.println("Failed to log action: User ID " + userID + " does not exist.");
                        return;
                    }
                }
            }
            // Insert log
            try (PreparedStatement pstInsert = con.prepareStatement(queryInsert)) {
                pstInsert.setInt(1, userID);
                pstInsert.setString(2, action);
                pstInsert.executeUpdate();
            }
        } catch (SQLException e) {
            System.err.println("Failed to log action: " + e.getMessage());
        }
    }
}
