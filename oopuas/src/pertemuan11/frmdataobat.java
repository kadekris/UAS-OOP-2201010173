package pertemuan11;

import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static pertemuan11.koneksi.getConnection;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author INSTIKI
 * TGL: 2024-06-28
 * 
 */
public class frmdataobat extends javax.swing.JFrame {
    DefaultTableModel tm = new DefaultTableModel();
    /**
     * Creates new form frmdataobat
     * @throws java.sql.SQLException
     */
    public frmdataobat() throws SQLException {
        initComponents();
        jtb.setModel(tm);
        tm.addColumn("ID");
        tm.addColumn("Nama");
        tm.addColumn("Jenis");
        tm.addColumn("Kode");
        list_all();
    }

    private void list_all() throws SQLException{
        Connection cnn = getConnection();
        
        tm.getDataVector().removeAllElements();
        tm.fireTableDataChanged();
        
        if(cnn.isClosed()){
            System.out.println("Koneksi tertutup");
        }else{
            String sql = "Select * from dataobat order by nama;";
            PreparedStatement ps = cnn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while( rs.next() ){
                Object[] dta = new Object[4];
                dta[0] = rs.getInt("idobat");
                dta[1] = rs.getString("nama");
                dta[2] = rs.getString("jenis");
                dta[3] = rs.getString("kode");
                tm.addRow(dta);
            }
            cnn.close();
        }
    }
    private void StoreData() throws SQLException{
        Connection cnn = getConnection();
        String NM = txNAMA.getText();
        String JE = txJENIS.getText();
        String KO = txKODE.getText();
        if(!cnn.isClosed()){
            PreparedStatement ps = cnn.prepareStatement("INSERT INTO dataobat(nama,jenis,kode)VALUES(?,?,?);");
            ps.setString(1, NM);
            ps.setString(2, JE);
            ps.setString(3, KO);
            ps.executeUpdate();
        }
    }
    private void UpdateData() throws SQLException{
        Connection cnn = getConnection();
        if(!cnn.isClosed()){
            String IDOBAT = LBIDOBAT.getText();
            String NM = txNAMA.getText();
            String JE = txJENIS.getText();
            String KO = txKODE.getText();
            PreparedStatement ps = cnn.prepareStatement("UPDATE dataobat SET nama=?, jenis=?, kode=? WHERE idobat=?;");
            ps.setString(1, NM);
            ps.setString(2, JE);
            ps.setString(3, KO);
            ps.setString(4, IDOBAT);
            ps.executeUpdate();
            
            cnn.close();
        }
    }
    private void DestroyData() throws SQLException{
        Connection cnn = getConnection();
        if(!cnn.isClosed()){
            PreparedStatement ps = cnn.prepareStatement("DELETE FROM dataobat WHERE idobat=?;");
            ps.setString(1, LBIDOBAT.getText() );
            ps.executeUpdate();
            cnn.close();
        }
    }
    private void loadphoto(String idobat){
        String pas0 = "img/gambar.jpg";
        String pas = "img/gambar"+idobat+".jpg";
        
        BufferedImage bimg = loadIMG.loadImage(pas);
        if(bimg == null){
            bimg = loadIMG.loadImage(pas0);
        }
        ImageIcon icoimg = new ImageIcon(bimg);
        pasphoto.setIcon(icoimg);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtb = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txNAMA = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txJENIS = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txKODE = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        LBIDOBAT = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cmdHapus = new javax.swing.JButton();
        cmdBaru = new javax.swing.JButton();
        cmdTutup = new javax.swing.JButton();
        cmdUbah = new javax.swing.JButton();
        pasphoto = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jtb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtb);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Data Obat");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Nama");

        txNAMA.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txNAMA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txNAMAActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Jenis");

        txJENIS.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txJENIS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txJENISActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Kode");

        txKODE.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txKODE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txKODEActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Record:");

        LBIDOBAT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        LBIDOBAT.setText("888");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("/");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("888");

        cmdHapus.setText("Hapus");
        cmdHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdHapusActionPerformed(evt);
            }
        });

        cmdBaru.setText("Baru");
        cmdBaru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdBaruActionPerformed(evt);
            }
        });

        cmdTutup.setText("Tutup");
        cmdTutup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdTutupActionPerformed(evt);
            }
        });

        cmdUbah.setText("Ubah");
        cmdUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdUbahActionPerformed(evt);
            }
        });

        pasphoto.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cmdBaru)
                                .addGap(54, 54, 54)
                                .addComponent(cmdUbah)
                                .addGap(43, 43, 43)
                                .addComponent(cmdHapus)
                                .addGap(55, 55, 55)
                                .addComponent(cmdTutup))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txKODE)
                                        .addComponent(txJENIS)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel4)
                                                .addComponent(jLabel3)
                                                .addComponent(jLabel2))
                                            .addGap(0, 0, Short.MAX_VALUE))
                                        .addComponent(txNAMA))
                                    .addGap(12, 12, 12)
                                    .addComponent(pasphoto, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(LBIDOBAT)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8))
                            .addComponent(jLabel1))))
                .addGap(0, 18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(LBIDOBAT)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txNAMA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txJENIS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txKODE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pasphoto, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmdBaru, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmdTutup)
                        .addComponent(cmdHapus)
                        .addComponent(cmdUbah)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cmdTutupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdTutupActionPerformed
        if(cmdTutup.getText().equals("Tutup")){
            int jtp = JOptionPane.showOptionDialog(this, 
                    "Yakin akan Menutup Form?", 
                    "Konfirmasi Tutup Form", 
                    JOptionPane.YES_NO_OPTION, 
                    JOptionPane.QUESTION_MESSAGE, 
                    null, 
                    null, 
                    null);
            if(jtp == JOptionPane.YES_OPTION){
                dispose();
            }
        }else{
            cmdTutup.setText("Tutup");
            cmdBaru.setText("Baru");
            cmdHapus.setEnabled(true);
        }
    }//GEN-LAST:event_cmdTutupActionPerformed

    private void jtbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbMouseClicked
        LBIDOBAT.setText(jtb.getValueAt(jtb.getSelectedRow(), 0).toString());
        txNAMA.setText(jtb.getValueAt(jtb.getSelectedRow(), 1).toString());
        txJENIS.setText(jtb.getValueAt(jtb.getSelectedRow(), 2).toString());
        txKODE.setText(jtb.getValueAt(jtb.getSelectedRow(), 3).toString());
        loadphoto(LBIDOBAT.getText());
    }//GEN-LAST:event_jtbMouseClicked

    private void cmdBaruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdBaruActionPerformed
        if( cmdBaru.getText().equals("Baru") ){
            cmdBaru.setText("Simpan");
            cmdTutup.setText("Batal");
            cmdHapus.setEnabled(false);
            
            txNAMA.setText("");
            txJENIS.setText("");
            txKODE.setText("");
            
        }else{
            try {
                StoreData();
                list_all();
            } catch (SQLException ex) {
                Logger.getLogger(frmdataobat.class.getName()).log(Level.SEVERE, null, ex);
            }
            cmdBaru.setText("Baru");
            cmdTutup.setText("Tutup");
            cmdHapus.setEnabled(true);
        }
    }//GEN-LAST:event_cmdBaruActionPerformed

    private void cmdUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdUbahActionPerformed
        try {
            UpdateData();
            list_all();
        } catch (SQLException ex) {
            Logger.getLogger(frmdataobat.class.getName()).log(Level.SEVERE, null, ex);
            System.out.print("Terjadi error");
        }
        
    }//GEN-LAST:event_cmdUbahActionPerformed

    private void cmdHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdHapusActionPerformed
        
        try {
            int jtp = JOptionPane.showOptionDialog(this, 
                    "Yakin akan Menghapus data teman: "+txNAMA.getText()+"?", 
                    "Konfirmasi Hapus Data", 
                    JOptionPane.YES_NO_OPTION, 
                    JOptionPane.ERROR_MESSAGE, 
                    null, 
                    null, 
                    null);
            if(jtp == JOptionPane.YES_OPTION){
                DestroyData();
                list_all();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(frmdataobat.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_cmdHapusActionPerformed

    private void txNAMAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txNAMAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txNAMAActionPerformed

    private void txKODEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txKODEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txKODEActionPerformed

    private void txJENISActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txJENISActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txJENISActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmdataobat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmdataobat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmdataobat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmdataobat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new frmdataobat().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(frmdataobat.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LBIDOBAT;
    private javax.swing.JButton cmdBaru;
    private javax.swing.JButton cmdHapus;
    private javax.swing.JButton cmdTutup;
    private javax.swing.JButton cmdUbah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtb;
    private javax.swing.JLabel pasphoto;
    private javax.swing.JTextField txJENIS;
    private javax.swing.JTextField txKODE;
    private javax.swing.JTextField txNAMA;
    // End of variables declaration//GEN-END:variables
}
