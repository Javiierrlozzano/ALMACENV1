/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ALMACEN;

/**
 *
 * @author JAVIER
 */
public class PlanAquisicion extends javax.swing.JFrame {

    /**
     * Creates new form CrearProducto
     */
    public PlanAquisicion() {
        initComponents();
         
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane5 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        idProveedor = new javax.swing.JComboBox<>();
        UnidadMedida1 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        DepCorta = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        ExistBG = new javax.swing.JTextField();
        BusSubCodPro = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        BuscarSud = new javax.swing.JButton();
        MarcaText = new javax.swing.JComboBox<>();
        CLASE = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        Tipo1 = new javax.swing.JComboBox<>();
        EstadoPro1 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();

        setTitle("CREAR PRODUCTO");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        idProveedor.setBackground(new java.awt.Color(204, 204, 204));
        idProveedor.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        idProveedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sucursal" }));
        idProveedor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        org.jdesktop.swingx.autocomplete.AutoCompleteDecorator.decorate(idProveedor);
        jPanel1.add(idProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 240, 30));

        UnidadMedida1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        UnidadMedida1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bodegas" }));
        UnidadMedida1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        UnidadMedida1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(UnidadMedida1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 240, 30));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("Sucursal");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText("Bodegas");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setText("Descripcion Corta");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, -1));

        DepCorta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DepCortaActionPerformed(evt);
            }
        });
        jPanel1.add(DepCorta, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 240, 30));

        jLabel9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel9.setText("Existencias BG");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, -1, -1));

        ExistBG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExistBGActionPerformed(evt);
            }
        });
        jPanel1.add(ExistBG, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 240, 30));

        BusSubCodPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BusSubCodProActionPerformed(evt);
            }
        });
        jPanel1.add(BusSubCodPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 240, 30));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Total Existencia");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 570, -1, -1));

        BuscarSud.setBackground(new java.awt.Color(255, 255, 255));
        BuscarSud.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        BuscarSud.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/Buscar.png"))); // NOI18N
        BuscarSud.setText("BUSCAR");
        BuscarSud.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BuscarSud.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BuscarSud.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jPanel1.add(BuscarSud, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 430, 130, 40));

        MarcaText.setBackground(new java.awt.Color(204, 204, 204));
        MarcaText.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        MarcaText.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Marca" }));
        MarcaText.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MarcaText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MarcaTextActionPerformed(evt);
            }
        });
        org.jdesktop.swingx.autocomplete.AutoCompleteDecorator.decorate(MarcaText);
        jPanel1.add(MarcaText, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 380, 70, 30));

        CLASE.setBackground(new java.awt.Color(204, 204, 204));
        CLASE.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        CLASE.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CLASE" }));
        CLASE.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        org.jdesktop.swingx.autocomplete.AutoCompleteDecorator.decorate(CLASE);
        CLASE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CLASEActionPerformed(evt);
            }
        });
        jPanel1.add(CLASE, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 80, 30));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/Crear_Inventario.png"))); // NOI18N
        jButton2.setText("CREAR INVENTRARIO");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, 240, 60));

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/Filtrar.png"))); // NOI18N
        jButton3.setText("        FILTRAR");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 550, 240, 60));

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/Buscar.png"))); // NOI18N
        jButton5.setText("BUSCAR");
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 530, 130, 60));

        jPanel5.setBackground(new java.awt.Color(0, 0, 204));
        jPanel5.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setText("Inventario General");
        jPanel5.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        jLabel41.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/Linea_Completa.png"))); // NOI18N
        jPanel5.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 0, -1, -1));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1300, -1));

        Tipo1.setBackground(new java.awt.Color(204, 204, 204));
        Tipo1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Tipo1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tipo" }));
        Tipo1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        org.jdesktop.swingx.autocomplete.AutoCompleteDecorator.decorate(UnidadMedida1);
        Tipo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tipo1ActionPerformed(evt);
            }
        });
        jPanel1.add(Tipo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 380, 70, 30));

        EstadoPro1.setBackground(new java.awt.Color(204, 204, 204));
        EstadoPro1.setEditable(true);
        EstadoPro1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        EstadoPro1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Innactivo", "Agotado" }));
        EstadoPro1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        org.jdesktop.swingx.autocomplete.AutoCompleteDecorator.decorate(UnidadMedida1);
        EstadoPro1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EstadoPro1ActionPerformed(evt);
            }
        });
        jPanel1.add(EstadoPro1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 100, 40));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Descripcion", "Costo base %", "Precio Publico %", "Valor Utilidad", "Existencia BG", "Estado", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, 1030, 440));

        jLabel11.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel11.setText("Codigo Producto");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("Valor Bodega");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 570, -1, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setText("Total Existencia");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 530, -1, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setText("Valor a Ganar");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 570, -1, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel15.setText("Valor Bodega");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 530, -1, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel17.setText("Valor a Ganar");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 530, -1, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel16.setText("Valor Total");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 530, -1, -1));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel18.setText("Valor Total");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 570, -1, -1));

        jScrollPane5.setViewportView(jPanel1);

        getContentPane().add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1310, 620));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Tipo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Tipo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Tipo1ActionPerformed

    private void CLASEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CLASEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CLASEActionPerformed

    private void MarcaTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MarcaTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MarcaTextActionPerformed

    private void BusSubCodProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BusSubCodProActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BusSubCodProActionPerformed

    private void ExistBGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExistBGActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ExistBGActionPerformed

    private void DepCortaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DepCortaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DepCortaActionPerformed

    private void EstadoPro1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EstadoPro1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EstadoPro1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        CrearInventario win = new CrearInventario();
        win.setVisible(true);
        win.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(PlanAquisicion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PlanAquisicion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PlanAquisicion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PlanAquisicion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PlanAquisicion().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField BusSubCodPro;
    private javax.swing.JButton BuscarSud;
    private javax.swing.JComboBox<String> CLASE;
    private javax.swing.JTextField DepCorta;
    private javax.swing.JComboBox<String> EstadoPro1;
    private javax.swing.JTextField ExistBG;
    private javax.swing.JComboBox<String> MarcaText;
    private javax.swing.JComboBox<String> Tipo1;
    private javax.swing.JComboBox<String> UnidadMedida1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> idProveedor;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
