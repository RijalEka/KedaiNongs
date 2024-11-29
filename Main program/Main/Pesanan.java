/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Main;

import javax.swing.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import pro.DatabaseConnection;
import java.sql.*;
/**
 *
 * @author LENOVO
 */
public class Pesanan extends javax.swing.JFrame {

/**
     * Creates new form Pesanan
     */
    private int loggedInKasirId;
    
    private DefaultTableModel model1;
    
    public Pesanan(int loggedInKasirId) {
       initComponents();
       this.loggedInKasirId = loggedInKasirId; // Simpan ID Kasir
       System.out.println("Pesanan diinstansiasi dengan loggedInKasirId: " + loggedInKasirId);
       initializeTable();
        
    }
    
     private void initializeTable() {
        model1 = new DefaultTableModel();
        this.pesanTable.setModel(model1);
        model1.addColumn("ID Menu");
        model1.addColumn("Nama Menu");
        model1.addColumn("Harga");
        model1.addColumn("Jumlah");
     }
    
    // Metode untuk menambahkan data ke pesanTable
    public void addRowToTable(int idMenu, String namaMenu, int harga, int jumlah) {
        model1.addRow(new Object[]{idMenu, namaMenu, harga, jumlah});
    }
    public JTable getPesanTable() {
        return pesanTable; // pesanTable adalah JTable di halaman Pesanan
    }
    // Metode untuk memuat data dari database
    public void loadDataFromDatabase() {
        System.out.println("Memulai memuat data ke tabel Pesanan...");
        DefaultTableModel model = (DefaultTableModel) pesanTable.getModel();
        model.setRowCount(0); // Bersihkan tabel

        try (Connection conn = DatabaseConnection.koneksiDB();
             PreparedStatement pstmt = conn.prepareStatement(
                     "SELECT tabel_order.id_Menu, tabel_menu.Nama_Menu, tabel_menu.harga, tabel_order.Jumlah_Pesanan " +
                     "FROM tabel_order " +
                     "JOIN tabel_menu ON tabel_order.id_Menu = tabel_menu.id_Menu " +
                     "WHERE tabel_order.id_Kasir = ?")) {
            pstmt.setInt(1, loggedInKasirId);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    int idMenu = rs.getInt("id_Menu");
                    String namaMenu = rs.getString("Nama_Menu");
                    int harga = rs.getInt("harga");
                    int jumlah = rs.getInt("Jumlah_Pesanan");

                    System.out.println("Memuat data: ID Menu = " + idMenu + ", Nama Menu = " + namaMenu +
                                       ", Harga = " + harga + ", Jumlah = " + jumlah);

                    model.addRow(new Object[]{idMenu, namaMenu, harga, jumlah});
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error saat memuat data tabel: " + ex.getMessage());
        }
        System.out.println("Selesai memuat data ke tabel Pesanan.");
        System.out.println("loggedInKasirId saat memuat data tabel: " + loggedInKasirId);
        pesanTable.repaint();
        pesanTable.revalidate();
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
        jPanel2 = new javax.swing.JPanel();
        roundedPanel1 = new warna.RoundedPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        pesananpanel = new javax.swing.JPanel();
        roundedPanel3 = new warna.RoundedPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pesanTable = new javax.swing.JTable();
        HapusButton = new javax.swing.JButton();
        TambahButton = new javax.swing.JButton();
        BayarButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(243, 202, 82));

        roundedPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo_2.png"))); // NOI18N

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Dashboard");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(252, 82, 48));
        jLabel3.setText("Pesanan");

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Pembayaran");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Riwayat");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout roundedPanel1Layout = new javax.swing.GroupLayout(roundedPanel1);
        roundedPanel1.setLayout(roundedPanel1Layout);
        roundedPanel1Layout.setHorizontalGroup(
            roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(258, 258, 258)
                .addComponent(jLabel2)
                .addGap(27, 27, 27)
                .addComponent(jLabel3)
                .addGap(28, 28, 28)
                .addComponent(jLabel5)
                .addGap(26, 26, 26)
                .addComponent(jLabel4)
                .addContainerGap(206, Short.MAX_VALUE))
        );
        roundedPanel1Layout.setVerticalGroup(
            roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel1Layout.createSequentialGroup()
                .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundedPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel1))
                    .addGroup(roundedPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(roundedPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(61, Short.MAX_VALUE)
                .addComponent(roundedPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 210));

        jPanel3.setBackground(new java.awt.Color(243, 202, 82));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pesananpanel.setBackground(new java.awt.Color(243, 202, 82));

        roundedPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(252, 82, 48));
        jLabel6.setText("Pesanan");

        javax.swing.GroupLayout roundedPanel3Layout = new javax.swing.GroupLayout(roundedPanel3);
        roundedPanel3.setLayout(roundedPanel3Layout);
        roundedPanel3Layout.setHorizontalGroup(
            roundedPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundedPanel3Layout.createSequentialGroup()
                .addContainerGap(149, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(149, 149, 149))
        );
        roundedPanel3Layout.setVerticalGroup(
            roundedPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundedPanel3Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(15, 15, 15))
        );

        pesanTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Menu", "Nama Menu", "Harga", "Jumlah"
            }
        ));
        jScrollPane1.setViewportView(pesanTable);

        HapusButton.setBackground(new java.awt.Color(255, 0, 0));
        HapusButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        HapusButton.setText("Hapus");
        HapusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HapusButtonActionPerformed(evt);
            }
        });

        TambahButton.setBackground(new java.awt.Color(255, 255, 255));
        TambahButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TambahButton.setForeground(new java.awt.Color(0, 0, 0));
        TambahButton.setText("Tambah");
        TambahButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TambahButtonActionPerformed(evt);
            }
        });

        BayarButton.setBackground(new java.awt.Color(0, 160, 51));
        BayarButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        BayarButton.setText("Bayar");
        BayarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BayarButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pesananpanelLayout = new javax.swing.GroupLayout(pesananpanel);
        pesananpanel.setLayout(pesananpanelLayout);
        pesananpanelLayout.setHorizontalGroup(
            pesananpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pesananpanelLayout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addGroup(pesananpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pesananpanelLayout.createSequentialGroup()
                        .addComponent(roundedPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(321, 321, 321))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pesananpanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 892, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60))))
            .addGroup(pesananpanelLayout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(TambahButton, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(HapusButton, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BayarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78))
        );
        pesananpanelLayout.setVerticalGroup(
            pesananpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pesananpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(roundedPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addGroup(pesananpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(HapusButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TambahButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BayarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(75, Short.MAX_VALUE))
        );

        jPanel3.add(pesananpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 470));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 1000, 470));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 675, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 675, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        setSize(new java.awt.Dimension(1014, 682));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void TambahButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TambahButtonActionPerformed
        // TODO add your handling code here:
        // Pastikan ada data yang dipilih di JTable
        int selectedRow = pesanTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Pilih data pesanan yang ingin ditambah.");
            return;
        }

        // Ambil ID Menu, Jumlah Pesanan, dan Harga dari JTable
        int idMenu = (int) pesanTable.getValueAt(selectedRow, 0); // ID Menu ada di kolom 0
        int jumlahPesanan = (int) pesanTable.getValueAt(selectedRow, 3); // Jumlah Pesanan ada di kolom 3
        int harga = (int) pesanTable.getValueAt(selectedRow, 2); // Harga ada di kolom 2

        // Tambahkan jumlah pesanan
        jumlahPesanan++;
        int totalHarga = jumlahPesanan * harga;

        // Update database
        try (Connection conn = DatabaseConnection.koneksiDB();
             PreparedStatement pstmt = conn.prepareStatement(
                     "UPDATE tabel_order SET Jumlah_Pesanan = ?, Total_Harga = ? WHERE id_Menu = ? AND id_Kasir = ?")) {
            pstmt.setInt(1, jumlahPesanan);
            pstmt.setInt(2, totalHarga);
            pstmt.setInt(3, idMenu);
            pstmt.setInt(4, loggedInKasirId);

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                // Update JTable
                pesanTable.setValueAt(jumlahPesanan, selectedRow, 3); // Update Jumlah Pesanan di kolom 3
                JOptionPane.showMessageDialog(this, "Pesanan berhasil ditambahkan!");
            } else {
                JOptionPane.showMessageDialog(this, "Gagal memperbarui data di database.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }//GEN-LAST:event_TambahButtonActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        Pesanan pesanan = new Pesanan(loggedInKasirId);
        new Dashboard(loggedInKasirId, pesanan).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        new Riwayat().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
        new Pembayaran().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void HapusButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HapusButtonActionPerformed
        // TODO add your handling code here:
        // Pastikan ada data yang dipilih di JTable
        int selectedRow = pesanTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Pilih data pesanan yang ingin dikurangi.");
            return;
        }

        // Ambil ID Menu, Jumlah Pesanan, dan Harga dari JTable
        int idMenu = (int) pesanTable.getValueAt(selectedRow, 0); // ID Menu ada di kolom 0
        int jumlahPesanan = (int) pesanTable.getValueAt(selectedRow, 3); // Jumlah Pesanan ada di kolom 3

        if (jumlahPesanan == 1) {
            // Jika jumlah pesanan tinggal 1, hapus data dari database
            try (Connection conn = DatabaseConnection.koneksiDB();
                 PreparedStatement pstmt = conn.prepareStatement(
                         "DELETE FROM tabel_order WHERE id_Menu = ? AND id_Kasir = ?")) {
                pstmt.setInt(1, idMenu);
                pstmt.setInt(2, loggedInKasirId);

                int affectedRows = pstmt.executeUpdate();
                if (affectedRows > 0) {
                    // Hapus data dari JTable
                    ((DefaultTableModel) pesanTable.getModel()).removeRow(selectedRow);
                    JOptionPane.showMessageDialog(this, "Pesanan berhasil dihapus!");
                } else {
                    JOptionPane.showMessageDialog(this, "Gagal menghapus data dari database.");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        } else {
            // Jika jumlah pesanan lebih dari 1, kurangi jumlah pesanan
            jumlahPesanan--;
            int harga = (int) pesanTable.getValueAt(selectedRow, 2); // Harga ada di kolom 2
            int totalHarga = jumlahPesanan * harga;

            try (Connection conn = DatabaseConnection.koneksiDB();
                 PreparedStatement pstmt = conn.prepareStatement(
                         "UPDATE tabel_order SET Jumlah_Pesanan = ?, Total_Harga = ? WHERE id_Menu = ? AND id_Kasir = ?")) {
                pstmt.setInt(1, jumlahPesanan);
                pstmt.setInt(2, totalHarga);
                pstmt.setInt(3, idMenu);
                pstmt.setInt(4, loggedInKasirId);

                int affectedRows = pstmt.executeUpdate();
                if (affectedRows > 0) {
                    // Update JTable
                    pesanTable.setValueAt(jumlahPesanan, selectedRow, 3); // Update Jumlah Pesanan di kolom 3
                    JOptionPane.showMessageDialog(this, "Pesanan berhasil dikurangi!");
                } else {
                    JOptionPane.showMessageDialog(this, "Gagal memperbarui data di database.");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_HapusButtonActionPerformed

    private void BayarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BayarButtonActionPerformed
        // TODO add your handling code here:
        // Pastikan pesananTable tidak kosong
        if (pesanTable.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Tidak ada pesanan untuk dibayar.");
            return;
        }

        // Ambil data dari pesananTable
        DefaultTableModel pesananModel = (DefaultTableModel) pesanTable.getModel();
        DefaultTableModel dataPesanan = new DefaultTableModel();
        dataPesanan.setColumnIdentifiers(new Object[]{"ID Menu", "Nama Menu", "Harga", "Jumlah"});

        int totalHarga = 0;

        for (int i = 0; i < pesananModel.getRowCount(); i++) {
            int idMenu = (int) pesananModel.getValueAt(i, 0);
            String namaMenu = (String) pesananModel.getValueAt(i, 1);
            int harga = (int) pesananModel.getValueAt(i, 2);
            int jumlah = (int) pesananModel.getValueAt(i, 3);

            // Hitung total harga
            int totalPerItem = harga * jumlah;
            totalHarga += totalPerItem;

            // Tambahkan data ke model baru
            dataPesanan.addRow(new Object[]{idMenu, namaMenu, harga, jumlah});
        }

        // Buka halaman Pembayaran dengan data pesanan
        Pembayaran pembayaranPage = new Pembayaran(dataPesanan, totalHarga);
        pembayaranPage.setVisible(true);

        // Tutup halaman Pesanan
        this.dispose();
    }//GEN-LAST:event_BayarButtonActionPerformed

    /**
     * @param args the command line arguments
     */
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BayarButton;
    private javax.swing.JButton HapusButton;
    private javax.swing.JButton TambahButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable pesanTable;
    private javax.swing.JPanel pesananpanel;
    private warna.RoundedPanel roundedPanel1;
    private warna.RoundedPanel roundedPanel3;
    // End of variables declaration//GEN-END:variables
}