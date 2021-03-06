/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Producto;

import CLASS.GENERAL_CLASS;
import CLASS.MySQL_Query;
import HOME.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @author JAVIER
 */
public class UNIDADMEDIDA extends javax.swing.JInternalFrame {

    /**
     * Creates new form Estadisticas1
     */
    public UNIDADMEDIDA(MySQL_Query Querys, boolean Activo) {
        initComponents();
        QuerysUnidad =Querys;
        inic= Activo;
        IniciarData();
    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Home = new javax.swing.JPanel();
        Panel_Ganancias = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btAdicionar = new javax.swing.JButton();
        btModificar = new javax.swing.JButton();
        btGuardar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        btActualizar = new javax.swing.JButton();
        Valor = new javax.swing.JTextField();
        EstadoPro = new javax.swing.JComboBox<>();
        Descripcion = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel15 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        logo_claro = new javax.swing.JLabel();
        logo_oscuro = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        HOJA_8 = new javax.swing.JLabel();
        HOJA_6 = new javax.swing.JLabel();
        ESTRELLA_8 = new javax.swing.JLabel();
        ESTRELLA_6 = new javax.swing.JLabel();
        ESTRELLA_5 = new javax.swing.JLabel();
        HOJA_5 = new javax.swing.JLabel();
        HOJA_11 = new javax.swing.JLabel();
        HOJA_10 = new javax.swing.JLabel();
        ESTRELLA_11 = new javax.swing.JLabel();
        ESTRELLA_10 = new javax.swing.JLabel();
        ESTRELLA_4 = new javax.swing.JLabel();
        HOJA_4 = new javax.swing.JLabel();
        idEstado = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(null);
        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);

        Home.setBackground(new java.awt.Color(10, 15, 42));
        Home.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Home.setMinimumSize(new java.awt.Dimension(770, 100));
        Home.setPreferredSize(new java.awt.Dimension(1080, 400));
        Home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeMouseClicked(evt);
            }
        });
        Home.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Panel_Ganancias.setBackground(new java.awt.Color(1, 1, 1));
        Panel_Ganancias.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTable1.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "CODIGO", "DESCRIPCION", "VALOR", "ESTADO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable1.setFocusable(false);
        jTable1.setGridColor(new java.awt.Color(0, 0, 0));
        jTable1.setOpaque(false);
        jTable1.setRowHeight(25);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTable1KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        Panel_Ganancias.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 400, 260));

        btAdicionar.setBackground(new java.awt.Color(255, 255, 255));
        btAdicionar.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        btAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/Agregar.png"))); // NOI18N
        btAdicionar.setText("ADICIONAR");
        btAdicionar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btAdicionar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btAdicionar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAdicionarActionPerformed(evt);
            }
        });
        btAdicionar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                btAdicionarKeyReleased(evt);
            }
        });
        Panel_Ganancias.add(btAdicionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 120, 60));

        btModificar.setBackground(new java.awt.Color(255, 255, 255));
        btModificar.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        btModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/Modificar.png"))); // NOI18N
        btModificar.setText("MODIFICAR");
        btModificar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btModificar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btModificar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btModificarActionPerformed(evt);
            }
        });
        btModificar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                btModificarKeyReleased(evt);
            }
        });
        Panel_Ganancias.add(btModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 360, 130, 60));

        btGuardar.setBackground(new java.awt.Color(255, 255, 255));
        btGuardar.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        btGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/Guardar.png"))); // NOI18N
        btGuardar.setText("GUARDAR");
        btGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btGuardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGuardarActionPerformed(evt);
            }
        });
        btGuardar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                btGuardarKeyReleased(evt);
            }
        });
        Panel_Ganancias.add(btGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 390, 110, 60));

        btCancelar.setBackground(new java.awt.Color(255, 255, 255));
        btCancelar.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/Cancelar.png"))); // NOI18N
        btCancelar.setText("CANCELAR");
        btCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btCancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });
        btCancelar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                btCancelarKeyReleased(evt);
            }
        });
        Panel_Ganancias.add(btCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 120, 60));

        btActualizar.setBackground(new java.awt.Color(255, 255, 255));
        btActualizar.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/Actualizar.png"))); // NOI18N
        btActualizar.setText("ACTUALIZAR");
        btActualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btActualizar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btActualizar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btActualizarActionPerformed(evt);
            }
        });
        btActualizar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                btActualizarKeyReleased(evt);
            }
        });
        Panel_Ganancias.add(btActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 400, 130, 60));

        Valor.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Valor.setText("1.0");
        Valor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ValorFocusLost(evt);
            }
        });
        Valor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ValorActionPerformed(evt);
            }
        });
        Valor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ValorKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ValorKeyTyped(evt);
            }
        });
        Panel_Ganancias.add(Valor, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 90, 30));

        EstadoPro.setEditable(true);
        EstadoPro.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        EstadoPro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));
        EstadoPro.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        org.jdesktop.swingx.autocomplete.AutoCompleteDecorator.decorate(EstadoPro);
        EstadoPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EstadoProActionPerformed(evt);
            }
        });
        EstadoPro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                EstadoProKeyReleased(evt);
            }
        });
        Panel_Ganancias.add(EstadoPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, 130, 30));

        Descripcion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Descripcion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(231, 231, 245), new java.awt.Color(231, 233, 240), new java.awt.Color(216, 215, 236), new java.awt.Color(228, 229, 243)));
        Descripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DescripcionActionPerformed(evt);
            }
        });
        Descripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                DescripcionKeyReleased(evt);
            }
        });
        Panel_Ganancias.add(Descripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 130, 30));
        Panel_Ganancias.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 90, 20));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Descripci??n");
        Panel_Ganancias.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Valor");
        Panel_Ganancias.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, -1, -1));
        Panel_Ganancias.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 90, 20));
        Panel_Ganancias.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 50, 90, 20));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Estados");
        Panel_Ganancias.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, -1, -1));

        Home.add(Panel_Ganancias, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 410, 490));

        jLabel3.setFont(new java.awt.Font("STXinwei", 1, 26)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Unidad de Medida");
        Home.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, 230, 50));

        logo_claro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/icons8_rocket_take_off_50px.png"))); // NOI18N
        Home.add(logo_claro, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 50, -1));

        logo_oscuro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/icons8_rocket_take_off_50px_1.png"))); // NOI18N
        Home.add(logo_oscuro, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, -1, -1));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("STLiti", 0, 26)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Jetxcel");
        Home.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 80, 50));

        HOJA_8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/icons8_cactus_10px.png"))); // NOI18N
        Home.add(HOJA_8, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 20, 20));

        HOJA_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/icons8_natural_food_20px.png"))); // NOI18N
        Home.add(HOJA_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 30, 30));

        ESTRELLA_8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/icons8_starfish_10px_1.png"))); // NOI18N
        Home.add(ESTRELLA_8, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 20, 20));

        ESTRELLA_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/icons8_starfish_20px.png"))); // NOI18N
        Home.add(ESTRELLA_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 30, 30));

        ESTRELLA_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/icons8_starfish_20px_2.png"))); // NOI18N
        Home.add(ESTRELLA_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 0, 30, 30));

        HOJA_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/icons8_snail_20px_1.png"))); // NOI18N
        Home.add(HOJA_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 0, 30, 30));

        HOJA_11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/icons8_tea_20px.png"))); // NOI18N
        Home.add(HOJA_11, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, 30, 30));

        HOJA_10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/icons8_koala_10px.png"))); // NOI18N
        Home.add(HOJA_10, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, -1, -1));

        ESTRELLA_11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/icons8_starfish_20px_2.png"))); // NOI18N
        Home.add(ESTRELLA_11, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, 30, 30));

        ESTRELLA_10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/icons8_starfish_10px.png"))); // NOI18N
        Home.add(ESTRELLA_10, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, -1, -1));

        ESTRELLA_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/icons8_starfish_32px.png"))); // NOI18N
        Home.add(ESTRELLA_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, -1, -1));

        HOJA_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/icons8_koala_32px.png"))); // NOI18N
        Home.add(HOJA_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, -1, -1));

        idEstado.setForeground(new java.awt.Color(255, 255, 255));
        Home.add(idEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, 20, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Home, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Home, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
        public   void  activa( Boolean x){
    //jTable1.setEnabled(x);
   // jButton3.setEnabled(x);
    Descripcion.setEnabled(x);
    idEstado.setEnabled(x);
    btGuardar.setEnabled(x);
   
    EstadoPro.setEnabled(x);
    Valor.setEnabled(x);
    btCancelar.setVisible(x);
    btActualizar.setVisible(x);
    btModificar.setVisible(!x);
     btAdicionar.setVisible(!x);
    }
    
    //Limpia 
    public void Limpiar(){
        JTextField text [] ={Descripcion};
        
        JComboBox com [] ={EstadoPro};
        idEstado.setText("");
        general.LimpiarTodo(text);
        Valor.setText("1.0");
        general.LimpiarTodo(com);
    }
    
    //Inicia los componentes 
    public  void IniciarData() {
        try {
                String[] Colum = {"idUnidadMedida","descripcion","valor","estado"}; 
                QuerysUnidad.GETAPI("/unidadmedida/all");
                general.AgregarTableAPI(jTable1, Colum, QuerysUnidad.GETAPI("/unidadmedida/all"));
                activa(inic);
        } catch (Exception e) {
            System.out.println("Error Inicios Unidad" +e.getMessage());
        }
       
  
    }
      
    public void Keys(java.awt.event.KeyEvent evt){
            //general.CerrarWindowsKey(evt, this);
            int  cerrar = evt.getKeyCode();
            if (116 == cerrar ){
                try {  
                    IniciarData();
                } catch (Exception ex) {
                    Logger.getLogger(FAMILIA2.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    private void GetTEXT(){
         Id =idEstado.getText();
        if (Id.length() !=0 ) {
            valor=Valor.getText();
            descripcion =Descripcion.getText();
            estado   =EstadoPro.getSelectedItem().toString();
            JSonUnidad = " {" +
                           "\"idUnidadMedida\":"+Id+"," +
                           "\"valor\":"+valor+"," +
                           "\"descripcion\":\""+descripcion+"\"," +
                           "\"estado\":\""+estado+"\"" +
                           "}" ;
        }else{
            valor=Valor.getText();
            descripcion =Descripcion.getText();
            estado   =EstadoPro.getSelectedItem().toString();
            JSonUnidad = " {" +
                           "\"idUnidadMedida\":"+Id+"," +
                           "\"valor\":"+valor+"," +
                           "\"descripcion\":\""+descripcion+"\"," +
                           "\"estado\":\""+estado+"\"" +
                           "}" ;
        }
            
        }
    private void HomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeMouseClicked

    }//GEN-LAST:event_HomeMouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        btModificar.setEnabled(true);
        String [] DatosTable =general.DatosJTable(jTable1);
        idEstado.setText(DatosTable[0]);
        Descripcion.setText(DatosTable[1]);
        Valor.setText(DatosTable[2]);
        EstadoPro.setSelectedItem(DatosTable[3]);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyReleased
        Keys(evt);          // TODO add your handling code here:
    }//GEN-LAST:event_jTable1KeyReleased

    private void btAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAdicionarActionPerformed
        try {
            activa(true);
            btActualizar.setVisible(false);
         
        } catch (Exception ex) {
            System.out.println("Error "+ ex.getMessage());
        }
    }//GEN-LAST:event_btAdicionarActionPerformed

    private void btAdicionarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btAdicionarKeyReleased
        Keys(evt);          // TODO add your handling code here:
    }//GEN-LAST:event_btAdicionarKeyReleased

    private void btModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btModificarActionPerformed
        activa(true);
    }//GEN-LAST:event_btModificarActionPerformed

    private void btModificarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btModificarKeyReleased
        Keys(evt);          // TODO add your handling code here:
    }//GEN-LAST:event_btModificarKeyReleased

    private void btGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGuardarActionPerformed
        try{
      
             GetTEXT();
               QuerysUnidad.POSTAPI("/unidadmedida/save",JSonUnidad);
            //QuerysUnidad.InsertUnidad(estado, valor, descripcion);
            Limpiar();
            IniciarData();
            activa(false);
            btModificar.setEnabled(false);
        }catch(Exception x){

        }

    }//GEN-LAST:event_btGuardarActionPerformed

    private void btGuardarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btGuardarKeyReleased
        Keys(evt);          // TODO add your handling code here:
    }//GEN-LAST:event_btGuardarKeyReleased

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        int conf = general.ValdarCerrar();
        if (conf == 0) {
            Limpiar();
            activa(false);
        }
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btCancelarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btCancelarKeyReleased
        Keys(evt);          // TODO add your handling code here:
    }//GEN-LAST:event_btCancelarKeyReleased

    private void btActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btActualizarActionPerformed
        try {
               GetTEXT();
               QuerysUnidad.POSTAPI("/unidadmedida/save",JSonUnidad);
           // QuerysUnidad.UpdateUnidad(idUnidadesMedida, estado, valores, descripcion);
            IniciarData();
            activa(false);
        } catch (Exception ex) {
//            Logger.getLogger(UNDMEDIDA.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btActualizarActionPerformed

    private void btActualizarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btActualizarKeyReleased
        Keys(evt);          // TODO add your handling code here:
    }//GEN-LAST:event_btActualizarKeyReleased

    private void ValorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ValorFocusLost
        if (Valor.getText().length()==0) {
            Valor.setText("1.0");
        }
    }//GEN-LAST:event_ValorFocusLost

    private void ValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ValorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ValorActionPerformed

    private void ValorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ValorKeyReleased
        general.Mayus(Valor);         // TODO add your handling code here:
        Keys(evt);
    }//GEN-LAST:event_ValorKeyReleased

    private void ValorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ValorKeyTyped
        general.SoloNumeros(evt, null);
    }//GEN-LAST:event_ValorKeyTyped

    private void EstadoProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EstadoProActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EstadoProActionPerformed

    private void EstadoProKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_EstadoProKeyReleased
        Keys(evt);          // TODO add your handling code here:
    }//GEN-LAST:event_EstadoProKeyReleased

    private void DescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DescripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DescripcionActionPerformed

    private void DescripcionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DescripcionKeyReleased
        general.Mayus(Descripcion);        // TODO add your handling code here:
        Keys(evt);
    }//GEN-LAST:event_DescripcionKeyReleased
    String Id ;
    String JSonUnidad ;
    String valor;
    String descripcion ;
    String estado  ;
    private MySQL_Query QuerysUnidad;
    private boolean inic =false;
    private  GENERAL_CLASS general = new GENERAL_CLASS() ;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Descripcion;
    public javax.swing.JLabel ESTRELLA_10;
    public javax.swing.JLabel ESTRELLA_11;
    public javax.swing.JLabel ESTRELLA_4;
    public javax.swing.JLabel ESTRELLA_5;
    public javax.swing.JLabel ESTRELLA_6;
    public javax.swing.JLabel ESTRELLA_8;
    private javax.swing.JComboBox<String> EstadoPro;
    public javax.swing.JLabel HOJA_10;
    public javax.swing.JLabel HOJA_11;
    public javax.swing.JLabel HOJA_4;
    public javax.swing.JLabel HOJA_5;
    public javax.swing.JLabel HOJA_6;
    public javax.swing.JLabel HOJA_8;
    public javax.swing.JPanel Home;
    public javax.swing.JPanel Panel_Ganancias;
    private javax.swing.JTextField Valor;
    private javax.swing.JButton btActualizar;
    private javax.swing.JButton btAdicionar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btGuardar;
    private javax.swing.JButton btModificar;
    private javax.swing.JLabel idEstado;
    public javax.swing.JLabel jLabel10;
    public javax.swing.JLabel jLabel13;
    public javax.swing.JLabel jLabel14;
    public javax.swing.JLabel jLabel15;
    public javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JSeparator jSeparator6;
    public javax.swing.JSeparator jSeparator7;
    public javax.swing.JSeparator jSeparator8;
    private javax.swing.JTable jTable1;
    public javax.swing.JLabel logo_claro;
    public javax.swing.JLabel logo_oscuro;
    // End of variables declaration//GEN-END:variables
}
