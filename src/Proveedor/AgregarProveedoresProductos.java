/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Proveedor;

/**
 *
 * @author JAVIER
 */
public class AgregarProveedoresProductos extends javax.swing.JFrame {

    /**
     * Creates new form CrearProducto
     */
    public AgregarProveedoresProductos() {
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
        Bodegas = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        idProveedor1 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        Bodegas1 = new javax.swing.JComboBox<>();
        BusSubCodPro1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setTitle("CREAR PRODUCTO");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 153));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Bodegas.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Bodegas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bodegas" }));
        Bodegas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Bodegas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        org.jdesktop.swingx.autocomplete.AutoCompleteDecorator.decorate(Bodegas);
        jPanel1.add(Bodegas, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 300, 230, 30));

        jLabel3.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ID PROVEEDOR");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 307, -1, 20));

        jLabel5.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("____________________");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, -1, 40));

        jButton4.setBackground(new java.awt.Color(204, 204, 204));
        jButton4.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/Agregar.png"))); // NOI18N
        jButton4.setText("AGREGAR");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 140, 50));

        jButton5.setBackground(new java.awt.Color(204, 204, 204));
        jButton5.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/Buscar.png"))); // NOI18N
        jButton5.setText("BUSCAR");
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 350, 150, 50));

        jPanel5.setBackground(new java.awt.Color(0, 204, 255));
        jPanel5.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setText("ASOCIAR Y BUSCAR");
        jPanel5.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/Linea_Completa.png"))); // NOI18N
        jLabel41.setText("ASOCIAR");
        jPanel5.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(-240, 0, 810, -1));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 50));

        idProveedor1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        idProveedor1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nombre Proveedor" }));
        idProveedor1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        idProveedor1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idProveedor1ActionPerformed(evt);
            }
        });
        jPanel1.add(idProveedor1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 250, 230, 30));

        jLabel6.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("VISTA PRODUCTOS");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 250, 130, 20));

        Bodegas1.setEditable(true);
        Bodegas1.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        Bodegas1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Unidad", "Mostrar todos" }));
        Bodegas1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Bodegas1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        org.jdesktop.swingx.autocomplete.AutoCompleteDecorator.decorate(Bodegas);
        jPanel1.add(Bodegas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 280, 110, 30));

        BusSubCodPro1.setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N
        BusSubCodPro1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BusSubCodPro1ActionPerformed(evt);
            }
        });
        jPanel1.add(BusSubCodPro1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 510, 60));

        jLabel7.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("PRECIO PUBLICO");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 210, -1, -1));

        jLabel8.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("NOMBRE PROEVEEDOR");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 257, -1, 20));

        jLabel9.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("DESCRIPCION PRODUCTO");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, -1));

        jLabel10.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("COSTO BS");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 210, -1, -1));

        jLabel11.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("DESCRIPCION PRODUCTO");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        jLabel12.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("COSTO BS");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 180, -1, -1));

        jLabel13.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("PRECIO PUBLICO");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 180, -1, -1));

        jLabel14.setFont(new java.awt.Font("Georgia", 0, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("C??digo Producto");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, -1, 30));

        jScrollPane5.setViewportView(jPanel1);

        getContentPane().add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void idProveedor1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idProveedor1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idProveedor1ActionPerformed

    private void BusSubCodPro1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BusSubCodPro1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BusSubCodPro1ActionPerformed

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
            java.util.logging.Logger.getLogger(AgregarProveedoresProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarProveedoresProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarProveedoresProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarProveedoresProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgregarProveedoresProductos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Bodegas;
    private javax.swing.JComboBox<String> Bodegas1;
    private javax.swing.JTextField BusSubCodPro1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> idProveedor1;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane5;
    // End of variables declaration//GEN-END:variables
}
