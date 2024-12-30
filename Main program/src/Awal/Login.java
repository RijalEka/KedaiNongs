/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Awal;
import Main.Dashboard;
import Main.Pesanan;
import java.sql.*;
import javax.swing.JOptionPane;
import pro.DatabaseConnection;

/**
 *
 * @author LENOVO
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
    }
    private int loggedInKasirId = -1; // Variabel untuk menyimpan ID Kasir yang sedang login
    
    
    public boolean login(String username, String password) {
        // Contoh logika login
        if (username == null || password == null || username.isEmpty() || password.isEmpty()) {
            return false; // Gagal jika username atau password kosong
        }
        // Simulasi login berhasil untuk kombinasi username/password tertentu
        return username.equals("user_valid") && password.equals("password_valid");
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Pass = new javax.swing.JPasswordField();
        Usn = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        reg = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        logbutton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/login.jpeg"))); // NOI18N
        jPanel1.add(jLabel2, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 453, 680));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, -20, -1, 206));

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Courier New", 1, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(252, 82, 48));
        jLabel3.setText("LOGIN");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 160, -1, 90));
        jPanel2.add(Pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 410, 340, 50));
        jPanel2.add(Usn, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 310, 340, 50));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("User Name");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Password");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, -1, -1));

        reg.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        reg.setForeground(new java.awt.Color(255, 0, 51));
        reg.setText("Register");
        reg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                regMouseClicked(evt);
            }
        });
        jPanel2.add(reg, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 580, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Belum Punya Akun?");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 580, -1, -1));

        logbutton.setBackground(new java.awt.Color(51, 255, 51));
        logbutton.setForeground(new java.awt.Color(0, 0, 0));
        logbutton.setText("LOGIN");
        logbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logbuttonActionPerformed(evt);
            }
        });
        jPanel2.add(logbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 480, 130, 40));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 0, 550, 680));

        setSize(new java.awt.Dimension(1014, 682));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void regMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_regMouseClicked
        // TODO add your handling code here:
        new Register().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_regMouseClicked

    private void logbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logbuttonActionPerformed
        // TODO add your handling code here:
        String username = Usn.getText();
        String password = new String(Pass.getPassword());

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Username atau Password tidak boleh kosong");
            return;
        }

        try (Connection conn = DatabaseConnection.koneksiDB();
             PreparedStatement pstmt = conn.prepareStatement(
                     "SELECT id_Kasir, username FROM tabel_kasir WHERE username=? AND password=?")) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    loggedInKasirId = rs.getInt("id_Kasir"); // Simpan ID Kasir
                    JOptionPane.showMessageDialog(this, "Login Berhasil, Selamat Datang " + username);

                    // Buat instance Pesanan
                    Pesanan pesanan = new Pesanan(loggedInKasirId); // Buat hanya satu instance

                    // Buka frame Dashboard dan kirimkan loggedInKasirId serta instance Pesanan
                    Dashboard dashboard = new Dashboard(loggedInKasirId, pesanan);
                    dashboard.setVisible(true);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Username atau Password salah");
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }       
    }//GEN-LAST:event_logbuttonActionPerformed

    /**
     * @param args the command line arguments
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField Pass;
    private javax.swing.JTextField Usn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton logbutton;
    private javax.swing.JLabel reg;
    // End of variables declaration//GEN-END:variables
}
