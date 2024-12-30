/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author LENOVO
 */
public class DatabaseConnection {
    // Menyediakan koneksi ke database
    public static Connection koneksiDB() throws SQLException {
        // Informasi koneksi
        String url = "jdbc:mysql://localhost:3306/kedai_nongs?useSSL=false";
        String user = "root";
        String password = "";

        // Mencoba membuat koneksi
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            // Melemparkan eksepsi jika gagal membuat koneksi
            throw new SQLException("Gagal terhubung ke database", e);
        }
    }
    
}
