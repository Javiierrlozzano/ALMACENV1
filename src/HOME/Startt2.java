/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HOME;

import ALMACEN.CrearBodegas;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.plaf.basic.BasicButtonUI;
import AppPackage.AnimationClass;//Acá importé la librería para los nombres desplazables de los botones
import CLASS.GENERAL_CLASS;
import CLASS.MySQL_Query;
import HOME.*;
import Producto.CrearProducto;
import Producto.FAMILIA1;
import Producto.FAMILIA1_1;
import Producto.FAMILIA2;
import Producto.FAMILIA2_2;

import Producto.UNIDADMEDIDA;
import USUARIO.CrearUsuario;

import java.awt.Dimension;
import desplazable.Desface;//ACÁ IMPORTÉ LA LIBRERÍA PARA EL MENÚ DESPLAZABLE DE LA DERECHA
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

/**
 *
 * @author Edwin
 */
public class Startt2 extends javax.swing.JFrame {

    Desface desplace;// ACÁ INSTANCIÉ EL COMPONENTE de la libreria desplazable

    /**
     * Creates new form Startt
     *
     * @param WinFm1 
     * @param WinFm2
     * @param WinFm3
     * @param WindFnidad
     * @param WinCrearBG
     * @param WinUser
     * @param WinConf
     */
    public Startt2(FAMILIA1_1 WinFm1, FAMILIA2_2 WinFm2, UNIDADMEDIDA WindFnidad, CrearBodegas WinCrearBG,  
            Configuracion WinConf, CrearProducto win, Estadisticas es1,MySQL_Query Querys1 ) {
        Querys =Querys1;
            initComponents();
            //api
            UnidadMedidas = WindFnidad;
            Estadistica =es1;
       // JScrollBar barra  = new ScrollBar( );
            ScrollDesktop.getVerticalScrollBar().setUnitIncrement(15);
            ScrollDesktop.getHorizontalScrollBar().setUnitIncrement(15);
            Familia1 = WinFm1;
            Familia2 = WinFm2;
           // WinFm3_1 = WinFm3;
           
            WinCrearBG_1 = WinCrearBG;
        
            WinConf_1 = WinConf;
            CrearProducto = win;
          JLabel txtEstadisticas1[]={
            jLabel6,jLabel5,Estadistica.jLabel10,
            Estadistica.jLabel13,Estadistica.jLabel4,Estadistica.jLabel17,
            Estadistica.jLabel18,Estadistica.jLabel25,Estadistica.
            jLabel15,Estadistica.jLabel29,Estadistica.jLabel33,
            Estadistica.jLabel34,Estadistica.jLabel28,Estadistica.jLabel26,
            Estadistica.jLabel38,Estadistica.jLabel37,Estadistica.jLabel42
            ,Estadistica.jLabel39, Estadistica.jLabel11,Estadistica.jLabel24,Estadistica.jLabel22,
            Estadistica.jLabel12,Estadistica.jLabel36,Estadistica.jLabel30,Estadistica.jLabel3
        };
        txtEstadisticas=txtEstadisticas1;
        JSeparator Separador1[]={
            jSeparator3,jSeparator1,
            Estadistica.jSeparator6,Estadistica.jSeparator7,
            Estadistica.jSeparator5,Estadistica.jSeparator8,
            Estadistica.jSeparator9,Estadistica.jSeparator10
        };
          Separador=Separador1;
                
            JLabel Estrellas1[]={Estadistica.ESTRELLA_4,Estadistica.ESTRELLAS_1,
            Estadistica.ESTRELLA_2,Estadistica.ESTRELLA_3,Estadistica.ESTRELLA_4,
            Estadistica.ESTRELLA_5,Estadistica.ESTRELLA_6,Estadistica. ESTRELLA_7,
            Estadistica.ESTRELLA_8, Estadistica.ESTRELLA_9,Estadistica.ESTRELLA_10,Estadistica. ESTRELLA_11,
            Estadistica.ESTRELLA_12,Estadistica.ESTRELLA_13,Estadistica.ESTRELLA_14,Estadistica.
            ESTRELLA_15, Estadistica.ESTRELLA_16, Estadistica.ESTRELLA_17,
            estrella_1,estrella_2,estrella_3,
            estrella4, estrella_5,estrella_6,
            estrella_7, estrella_8, estrella_9};
            Extrellas=Estrellas1;
            JLabel Hojas1[]={Estadistica.HOJA_3,Estadistica.HOJA_4,Estadistica.HOJA_5,Estadistica.HOJA_6,
            Estadistica.HOJA_7, Estadistica.HOJA_8,Estadistica.HOJA_9,Estadistica.HOJA_10,Estadistica.HOJA_11,Estadistica.
            HOJA_12,Estadistica. HOJA_13,Estadistica.HOJA_14,
            Estadistica.HOJA_15,Estadistica.HOJA_16,Estadistica.HOJA_17,
            hoja_1,hoja_2, hoja_3,
            hoja_4, hoja_5, hoja_6,
            hoja_7,hoja_8,hoja_9,
            estrella_10,Estadistica.HOJA_1,Estadistica.HOJA_2,};
            Hojas =Hojas1;
            
            JButton BTN1[]={
            Estadistica.BTN_HOY,
            Estadistica.BTN_AYER,
            Estadistica.BTN_SEMANA,
            Estadistica.BTN_MES,
            Estadistica.BTN_TODO,
            Estadistica.BTN_USUARIOS,
            Estadistica.BTN_FECHA,
            Estadistica.BTN_BUSCAR};
            BTN=BTN1;
           
            JLabel Text1[]={
            Estadistica.jLabel14,
            Estadistica.jLabel4,
            Estadistica.jLabel1,
            Estadistica.jLabel20,
            Estadistica.jLabel23,
            Estadistica.jLabel21,
            Estadistica.jLabel16,
            Estadistica.jLabel15,
            Estadistica.jLabel31,
            Estadistica.jLabel32,
            Estadistica.jLabel35,
            Estadistica.jLabel34
        };
             Text=Text1;
            JButton Botones_Panel1[]={
            BtLicencia,
            jButton2,
            BTN_CLIENTES,
            BTN_VENTAS,
            BTN_ALMACEN,
            BTN_PRODUCTOS,
            jButton7,
           // txt_CONFIGURACION,
            //txt_CHATBOT,
            //txt_BUSQUEDA
            };
        Botones_Panel=Botones_Panel1;
            JPanel PanelEstadisticas1[]={
            Estadistica.Panel_Ganancias,
            Estadistica.jPanel10,
            Estadistica.jPanel8,
            Estadistica.jPanel9,
            Estadistica.jPanel8,
            Estadistica.jPanel7,
            Estadistica.jPanel12,
            Estadistica.jPanel13,
            Estadistica.jPanel11,
            Estadistica.jPanel14,
            Estadistica.jPanel15
        };
        PanelEstadisticas=PanelEstadisticas1;
        JPanel Lateal1[]={
            Menu_deslizable_Panel_Contenedor_Botones,
            Menu_Lateral_Izquierdo,
            jPanel3
        };
        Lateal=Lateal1;
        
        ActivarHojas(false);
        Iconos_Off.setVisible(true);
        Iconos_True.setVisible(false);
        //////////////
  
        desplace = new Desface();// ESTA TAMBIÉN ES DEL MENÚ DESPLAZABLE
        setExtendedState(MAXIMIZED_BOTH);//ACÁ MAXIMIZA LA VENTANA PRINCIPAL
        
    
        for (JButton btn : Botones_Panel) {
            btn.setBackground(new Color(21, 25, 28));
            btn.setUI(new BasicButtonUI());
            btn.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent me) {
                }

                @Override
                public void mousePressed(MouseEvent me) {

                }

                @Override
                public void mouseReleased(MouseEvent me) {

                }

                @Override
                public void mouseEntered(MouseEvent me) {
                    //btn.setBackground(new Color(54, 81, 207));
                }

                @Override
                public void mouseExited(MouseEvent me) {
                    //btn.setBackground(new Color(21, 25, 28));

                }
            });
        }
        CambiarModo(false, BTN, Text, Botones_Panel, PanelEstadisticas, txtEstadisticas, Estadistica.Home, Lateal,Separador);
    }
    
    //Funcion para ModoClaro_Oscuro
       public void CambiarModo(boolean Activador,JButton BTN [],JLabel Text[],JButton Botones_Panel[],
        JPanel PanelEstadisticas[],JLabel txtEstadisticas[],JPanel Fondo,JPanel Lateal[],JSeparator Separador[])
       {
            for(int i=0; i< Botones_Panel.length;i++){
                Botones_Panel[i].setBackground(null);
            }
            if (Iconos_True.isVisible()) {
               ActivarHojas(true);
            ActivarEstrellas(false);
           }else{
                     ActivarHojas(false);
                    ActivarEstrellas(false);
                }
            
               BTN_MODO_NOCHE.setVisible(Activador);//OCULTA EL BOTON MODO OSCURO
               TXT_NOCHE.setVisible(Activador);//OCULTA EL TEXTO MODO OSCURO
               BTN_MODO_DIA.setVisible(!Activador);//OCULTA EL BOTON MODO OSCURO
               TXT_DIA.setVisible(!Activador);//OCULTA EL TEXTO MODO OSCURO
               Estadistica.logo_oscuro.setVisible(Activador);
              Estadistica. logo_claro.setVisible(!Activador);
            if(Activador ==true){
                IconosModo=true;
                for (int i = 0; i < BTN.length ; i++) {
                    BTN[i].setBackground(new Color(153, 153, 153));
                    BTN[i].setForeground(Color.black);
                }
                for(int i =0;i<Text.length ;i++){
                    Text[i].setForeground(new Color(255, 255, 7));
                }for(int i =0;i<PanelEstadisticas.length ;i++){
                    PanelEstadisticas[i].setBackground(Color.lightGray);
                }for(int i =0;i<txtEstadisticas.length ;i++){
                    txtEstadisticas[i].setForeground(Color.BLACK);
                }
                HomePrincipal.setBackground(Color.white);
                Estadistica.Home.setBackground(Color.white);
                for (int i = 0; i < Lateal.length ; i++) {
                    Lateal[i].setBackground(Color.GRAY);
                }for(int i = 0; i < Separador.length ; i++){
                     Separador[i].setBackground(Color.BLACK);
                     Separador[i].setForeground(Color.BLACK);
                }

            }else{
                if (Iconos_True.isVisible()) {
                    ActivarHojas(false);
                    ActivarEstrellas(true);}else{
                     ActivarHojas(false);
                    ActivarEstrellas(false);
                }
                    IconosModo=false;
                for (int i = 0; i < BTN.length ; i++) {
                    BTN[i].setBackground(new Color(11, 24, 29));
                    BTN[i].setForeground(Color.WHITE);
                }
                for(int i =0;i<Text.length ;i++){
                    Text[i].setForeground(new Color(255, 255, 7));
                }for(int i =0;i<PanelEstadisticas.length ;i++){
                    PanelEstadisticas[i].setBackground(new Color(1, 1, 1));
                }for(int i =0;i<txtEstadisticas.length ;i++){
                    txtEstadisticas[i].setForeground(Color.WHITE);
                }
                HomePrincipal.setBackground(new Color(10, 15, 42));
                Estadistica.Home.setBackground(new Color(10, 15, 42));
                for (int i = 0; i < Lateal.length ; i++) {
                    Lateal[i].setBackground(new Color(7, 16, 19));
                }for(int i = 0; i < Separador.length ; i++){
                     Separador[i].setBackground(Color.WHITE);
                     Separador[i].setForeground(Color.WHITE);
                }
            }
        }
    //ActivarHojas
    public void ActivarHojas(boolean x){
        for (int i = 0; i < Hojas.length ; i++) {
            Hojas[i].setVisible(x);
        }
    }
    //Activar Estrellas
    public void ActivarEstrellas(boolean x){
    for (int i = 0; i < Extrellas.length ; i++) {
            Extrellas[i].setVisible(x);
        }
    }
    //Activar Modo Oscuro
       
    private Startt2() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        HomePrincipal = new javax.swing.JPanel();
        Menu_Lateral_Izquierdo = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        BTN_CLIENTES = new javax.swing.JButton();
        BTN_VENTAS = new javax.swing.JButton();
        BTN_ALMACEN = new javax.swing.JButton();
        BTN_PRODUCTOS = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        BTN_MODO_NOCHE = new javax.swing.JLabel();
        BTN_MODO_DIA = new javax.swing.JLabel();
        TXT_NOCHE = new javax.swing.JLabel();
        TXT_DIA = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        estrella_6 = new javax.swing.JLabel();
        estrella_2 = new javax.swing.JLabel();
        estrella_5 = new javax.swing.JLabel();
        estrella_9 = new javax.swing.JLabel();
        estrella_8 = new javax.swing.JLabel();
        BtLicencia = new javax.swing.JButton();
        estrella_1 = new javax.swing.JLabel();
        estrella_3 = new javax.swing.JLabel();
        estrella4 = new javax.swing.JLabel();
        estrella_7 = new javax.swing.JLabel();
        hoja_1 = new javax.swing.JLabel();
        hoja_2 = new javax.swing.JLabel();
        hoja_3 = new javax.swing.JLabel();
        hoja_4 = new javax.swing.JLabel();
        hoja_5 = new javax.swing.JLabel();
        hoja_6 = new javax.swing.JLabel();
        hoja_7 = new javax.swing.JLabel();
        hoja_8 = new javax.swing.JLabel();
        hoja_9 = new javax.swing.JLabel();
        estrella_10 = new javax.swing.JLabel();
        Iconos_True = new javax.swing.JLabel();
        Iconos_Off = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        BTN_MENU = new javax.swing.JLabel();
        Menu_deslizable_Panel_Contenedor_Botones = new javax.swing.JPanel();
        txt_CONFIGURACION = new javax.swing.JLabel();
        txt_CHATBOT = new javax.swing.JLabel();
        txt_BUSQUEDA = new javax.swing.JLabel();
        ScrollDesktop = new javax.swing.JScrollPane();
        DeskPanel = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.BorderLayout());

        HomePrincipal.setBackground(new java.awt.Color(10, 15, 42));

        Menu_Lateral_Izquierdo.setBackground(new java.awt.Color(7, 16, 19));
        Menu_Lateral_Izquierdo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setBackground(new java.awt.Color(7, 16, 19));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/Estadisticos_42px.png"))); // NOI18N
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton2.setPreferredSize(new java.awt.Dimension(40, 40));
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        Menu_Lateral_Izquierdo.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 20, 40, 40));

        BTN_CLIENTES.setBackground(new java.awt.Color(7, 16, 19));
        BTN_CLIENTES.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/AAgregar_Usuario.png"))); // NOI18N
        BTN_CLIENTES.setMnemonic('C');
        BTN_CLIENTES.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BTN_CLIENTES.setPreferredSize(new java.awt.Dimension(40, 40));
        BTN_CLIENTES.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BTN_CLIENTESMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BTN_CLIENTESMouseExited(evt);
            }
        });
        BTN_CLIENTES.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_CLIENTESActionPerformed(evt);
            }
        });
        Menu_Lateral_Izquierdo.add(BTN_CLIENTES, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 140, 40, 40));

        BTN_VENTAS.setBackground(new java.awt.Color(7, 16, 19));
        BTN_VENTAS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/Money_42PX.png"))); // NOI18N
        BTN_VENTAS.setMnemonic('V');
        BTN_VENTAS.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BTN_VENTAS.setPreferredSize(new java.awt.Dimension(40, 40));
        BTN_VENTAS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BTN_VENTASMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BTN_VENTASMouseExited(evt);
            }
        });
        BTN_VENTAS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_VENTASActionPerformed(evt);
            }
        });
        Menu_Lateral_Izquierdo.add(BTN_VENTAS, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 190, 40, 40));

        BTN_ALMACEN.setBackground(new java.awt.Color(7, 16, 19));
        BTN_ALMACEN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/Bodega_42Px.png"))); // NOI18N
        BTN_ALMACEN.setMnemonic('A');
        BTN_ALMACEN.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BTN_ALMACEN.setPreferredSize(new java.awt.Dimension(40, 40));
        BTN_ALMACEN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BTN_ALMACENMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BTN_ALMACENMouseExited(evt);
            }
        });
        BTN_ALMACEN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_ALMACENActionPerformed(evt);
            }
        });
        Menu_Lateral_Izquierdo.add(BTN_ALMACEN, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 240, 40, 40));

        BTN_PRODUCTOS.setBackground(new java.awt.Color(7, 16, 19));
        BTN_PRODUCTOS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/Producto_New_32Px.png"))); // NOI18N
        BTN_PRODUCTOS.setMnemonic('P');
        BTN_PRODUCTOS.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BTN_PRODUCTOS.setPreferredSize(new java.awt.Dimension(40, 40));
        BTN_PRODUCTOS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BTN_PRODUCTOSMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BTN_PRODUCTOSMouseExited(evt);
            }
        });
        BTN_PRODUCTOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_PRODUCTOSActionPerformed(evt);
            }
        });
        Menu_Lateral_Izquierdo.add(BTN_PRODUCTOS, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 290, 40, 40));

        jButton7.setBackground(new java.awt.Color(7, 16, 19));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/Resumen.png"))); // NOI18N
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton7.setPreferredSize(new java.awt.Dimension(40, 40));
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton7MouseExited(evt);
            }
        });
        Menu_Lateral_Izquierdo.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 340, 40, 40));
        Menu_Lateral_Izquierdo.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 50, 10));
        Menu_Lateral_Izquierdo.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 50, 10));
        Menu_Lateral_Izquierdo.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 50, 10));

        BTN_MODO_NOCHE.setBackground(new java.awt.Color(7, 16, 19));
        BTN_MODO_NOCHE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/icons8_toggle_on_32px.png"))); // NOI18N
        BTN_MODO_NOCHE.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BTN_MODO_NOCHE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BTN_MODO_NOCHEMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BTN_MODO_NOCHEMouseEntered(evt);
            }
        });
        Menu_Lateral_Izquierdo.add(BTN_MODO_NOCHE, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 40, 40));

        BTN_MODO_DIA.setBackground(new java.awt.Color(21, 25, 28));
        BTN_MODO_DIA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/icons8_toggle_off_32px.png"))); // NOI18N
        BTN_MODO_DIA.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BTN_MODO_DIA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BTN_MODO_DIAMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BTN_MODO_DIAMouseEntered(evt);
            }
        });
        Menu_Lateral_Izquierdo.add(BTN_MODO_DIA, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 40, 40));

        TXT_NOCHE.setBackground(new java.awt.Color(21, 25, 28));
        TXT_NOCHE.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        TXT_NOCHE.setForeground(new java.awt.Color(255, 255, 255));
        TXT_NOCHE.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TXT_NOCHE.setText("A NOCHE");
        Menu_Lateral_Izquierdo.add(TXT_NOCHE, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, 60, 20));

        TXT_DIA.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        TXT_DIA.setForeground(new java.awt.Color(255, 255, 255));
        TXT_DIA.setText(" A DIA");
        Menu_Lateral_Izquierdo.add(TXT_DIA, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, 40, 20));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("CAMBIAR");
        Menu_Lateral_Izquierdo.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, -1, -1));

        estrella_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/icons8_star_filled_15px.png"))); // NOI18N
        Menu_Lateral_Izquierdo.add(estrella_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 550, 20, 40));

        estrella_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/icons8_comet_15px.png"))); // NOI18N
        Menu_Lateral_Izquierdo.add(estrella_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 20, 40));

        estrella_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/icons8_comet_15px.png"))); // NOI18N
        Menu_Lateral_Izquierdo.add(estrella_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, 20, 40));

        estrella_9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/icons8_comet_15px_1.png"))); // NOI18N
        Menu_Lateral_Izquierdo.add(estrella_9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 680, 20, 40));

        estrella_8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/icons8_comet_15px_1.png"))); // NOI18N
        Menu_Lateral_Izquierdo.add(estrella_8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 630, 20, 40));

        BtLicencia.setBackground(new java.awt.Color(7, 16, 19));
        BtLicencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/Licencia_32PX.png"))); // NOI18N
        BtLicencia.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BtLicencia.setPreferredSize(new java.awt.Dimension(40, 40));
        BtLicencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtLicenciaActionPerformed(evt);
            }
        });
        Menu_Lateral_Izquierdo.add(BtLicencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 570, 40, 50));

        estrella_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/icons8_star_filled_15px.png"))); // NOI18N
        Menu_Lateral_Izquierdo.add(estrella_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 20, 40));

        estrella_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/icons8_star_filled_15px.png"))); // NOI18N
        Menu_Lateral_Izquierdo.add(estrella_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 20, 40));

        estrella4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/icons8_star_filled_15px.png"))); // NOI18N
        Menu_Lateral_Izquierdo.add(estrella4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, 20, 40));

        estrella_7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/icons8_star_filled_15px.png"))); // NOI18N
        Menu_Lateral_Izquierdo.add(estrella_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 610, 20, 40));

        hoja_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/icons8_bug_15px.png"))); // NOI18N
        Menu_Lateral_Izquierdo.add(hoja_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 20, 40));

        hoja_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/icons8_cactus_15px.png"))); // NOI18N
        Menu_Lateral_Izquierdo.add(hoja_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 20, 40));

        hoja_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/icons8_bug_15px.png"))); // NOI18N
        Menu_Lateral_Izquierdo.add(hoja_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 20, 40));

        hoja_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/icons8_bug_15px.png"))); // NOI18N
        Menu_Lateral_Izquierdo.add(hoja_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, 20, 40));

        hoja_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/icons8_cactus_15px.png"))); // NOI18N
        Menu_Lateral_Izquierdo.add(hoja_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, 20, 40));
        Menu_Lateral_Izquierdo.add(hoja_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 570, 20, 40));

        hoja_7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/icons8_bug_15px.png"))); // NOI18N
        Menu_Lateral_Izquierdo.add(hoja_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 610, 20, 40));

        hoja_8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/icons8_bug_15px.png"))); // NOI18N
        Menu_Lateral_Izquierdo.add(hoja_8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 670, 20, 40));

        hoja_9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/icons8_bug_15px.png"))); // NOI18N
        Menu_Lateral_Izquierdo.add(hoja_9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 870, 20, 40));

        estrella_10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/icons8_cactus_15px.png"))); // NOI18N
        Menu_Lateral_Izquierdo.add(estrella_10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 910, 20, 40));

        Iconos_True.setForeground(new java.awt.Color(255, 255, 255));
        Iconos_True.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Iconos_True.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/icons8_checked_checkbox_32px.png"))); // NOI18N
        Iconos_True.setToolTipText("APAGAR ICONOS");
        Iconos_True.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Iconos_True.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        Iconos_True.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Iconos_TrueMouseClicked(evt);
            }
        });
        Menu_Lateral_Izquierdo.add(Iconos_True, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 500, 40, 40));

        Iconos_Off.setForeground(new java.awt.Color(255, 255, 255));
        Iconos_Off.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Iconos_Off.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/icons8_unchecked_checkbox_32px.png"))); // NOI18N
        Iconos_Off.setToolTipText("ENCENDER ICONOS");
        Iconos_Off.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Iconos_Off.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        Iconos_Off.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Iconos_OffMouseClicked(evt);
            }
        });
        Menu_Lateral_Izquierdo.add(Iconos_Off, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 500, 40, 40));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("ICONOS");
        Menu_Lateral_Izquierdo.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 540, -1, -1));

        jPanel3.setBackground(new java.awt.Color(51, 0, 51));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BTN_MENU.setForeground(new java.awt.Color(255, 255, 255));
        BTN_MENU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/Menu_tres_lineas.png"))); // NOI18N
        BTN_MENU.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BTN_MENU.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BTN_MENUMouseClicked(evt);
            }
        });
        jPanel3.add(BTN_MENU, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        Menu_deslizable_Panel_Contenedor_Botones.setBackground(new java.awt.Color(51, 0, 51));
        Menu_deslizable_Panel_Contenedor_Botones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_CONFIGURACION.setBackground(new java.awt.Color(51, 0, 51));
        txt_CONFIGURACION.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_CONFIGURACION.setForeground(new java.awt.Color(255, 255, 255));
        txt_CONFIGURACION.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_CONFIGURACION.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/Configuraciones_42Px.png"))); // NOI18N
        txt_CONFIGURACION.setText("AJUSTES");
        txt_CONFIGURACION.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txt_CONFIGURACION.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        txt_CONFIGURACION.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        txt_CONFIGURACION.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_CONFIGURACIONMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_CONFIGURACIONMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txt_CONFIGURACIONMouseExited(evt);
            }
        });
        Menu_deslizable_Panel_Contenedor_Botones.add(txt_CONFIGURACION, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 30, 70, -1));

        txt_CHATBOT.setBackground(new java.awt.Color(51, 0, 51));
        txt_CHATBOT.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_CHATBOT.setForeground(new java.awt.Color(255, 255, 255));
        txt_CHATBOT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_CHATBOT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/Chat_Bot.png"))); // NOI18N
        txt_CHATBOT.setText("CHAT BOT");
        txt_CHATBOT.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txt_CHATBOT.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        txt_CHATBOT.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        txt_CHATBOT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_CHATBOTMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txt_CHATBOTMouseExited(evt);
            }
        });
        Menu_deslizable_Panel_Contenedor_Botones.add(txt_CHATBOT, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 180, 70, 70));

        txt_BUSQUEDA.setBackground(new java.awt.Color(51, 0, 51));
        txt_BUSQUEDA.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_BUSQUEDA.setForeground(new java.awt.Color(255, 255, 255));
        txt_BUSQUEDA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_BUSQUEDA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/Buscar_32px.png"))); // NOI18N
        txt_BUSQUEDA.setText("BUSCAR");
        txt_BUSQUEDA.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txt_BUSQUEDA.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        txt_BUSQUEDA.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        txt_BUSQUEDA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_BUSQUEDAMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txt_BUSQUEDAMouseExited(evt);
            }
        });
        Menu_deslizable_Panel_Contenedor_Botones.add(txt_BUSQUEDA, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 310, 70, 60));

        jPanel3.add(Menu_deslizable_Panel_Contenedor_Botones, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 76, 460));

        ScrollDesktop.setMinimumSize(new java.awt.Dimension(0, 0));

        DeskPanel.setBackground(new java.awt.Color(0, 0, 0));
        DeskPanel.setPreferredSize(new java.awt.Dimension(1157, 687));

        javax.swing.GroupLayout DeskPanelLayout = new javax.swing.GroupLayout(DeskPanel);
        DeskPanel.setLayout(DeskPanelLayout);
        DeskPanelLayout.setHorizontalGroup(
            DeskPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        DeskPanelLayout.setVerticalGroup(
            DeskPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        ScrollDesktop.setViewportView(DeskPanel);

        javax.swing.GroupLayout HomePrincipalLayout = new javax.swing.GroupLayout(HomePrincipal);
        HomePrincipal.setLayout(HomePrincipalLayout);
        HomePrincipalLayout.setHorizontalGroup(
            HomePrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HomePrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Menu_Lateral_Izquierdo, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1187, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(HomePrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(HomePrincipalLayout.createSequentialGroup()
                    .addGap(103, 103, 103)
                    .addComponent(ScrollDesktop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(98, 98, 98)))
        );
        HomePrincipalLayout.setVerticalGroup(
            HomePrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HomePrincipalLayout.createSequentialGroup()
                .addComponent(Menu_Lateral_Izquierdo, javax.swing.GroupLayout.PREFERRED_SIZE, 730, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(HomePrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 722, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
            .addGroup(HomePrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(HomePrincipalLayout.createSequentialGroup()
                    .addComponent(ScrollDesktop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 91, Short.MAX_VALUE)))
        );

        jPanel1.add(HomePrincipal, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(1376, 819));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BTN_CLIENTESMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN_CLIENTESMouseEntered
        //-----> SALIDA HACIA LA DERECHA EL TEXTO DE AGREGAR USUARIO
        Color AG_USUARIOS_AZUL = new Color(54, 81, 207);
        BTN_CLIENTES.setBackground(AG_USUARIOS_AZUL);
        
    }//GEN-LAST:event_BTN_CLIENTESMouseEntered

    private void BTN_CLIENTESMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN_CLIENTESMouseExited
        //<----- ENTRADA HACIA LA IZQUIERDA EL TEXTO DE AGREGAR USUARIO
        BTN_CLIENTES.setBackground(null);
        AnimationClass AG_USUARIOSS = new AnimationClass();//ESTADISTICOS
    }//GEN-LAST:event_BTN_CLIENTESMouseExited

    private void Contenedor_LicenciaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Contenedor_LicenciaMouseExited

    }//GEN-LAST:event_Contenedor_LicenciaMouseExited

    private void Contenedor_LicenciaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Contenedor_LicenciaMouseEntered

    }//GEN-LAST:event_Contenedor_LicenciaMouseEntered

    private void BTN_MENUMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN_MENUMouseClicked
        //SALE EL MENÚ PRUEBA LATERAL HACIA LA IZQUIERDA 
        if (Menu_deslizable_Panel_Contenedor_Botones.getX() == 110) {
            desplace.desplazarIzquierda(Menu_deslizable_Panel_Contenedor_Botones, Menu_deslizable_Panel_Contenedor_Botones.getX(), 0, 10, 10);
        } else if (Menu_deslizable_Panel_Contenedor_Botones.getX() == 0) {
            desplace.desplazarDerecha(Menu_deslizable_Panel_Contenedor_Botones, Menu_deslizable_Panel_Contenedor_Botones.getX(), 110, 10, 10);
        }

    }//GEN-LAST:event_BTN_MENUMouseClicked

    private void txt_CONFIGURACIONMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_CONFIGURACIONMouseEntered
        Color COLOR_AZUL_OSCURO = new Color(0, 0, 102);
        txt_CONFIGURACION.setBackground(COLOR_AZUL_OSCURO);

    }//GEN-LAST:event_txt_CONFIGURACIONMouseEntered

    private void txt_CONFIGURACIONMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_CONFIGURACIONMouseExited
        txt_CONFIGURACION.setBackground(null);

    }//GEN-LAST:event_txt_CONFIGURACIONMouseExited

    private void txt_BUSQUEDAMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_BUSQUEDAMouseEntered
        Color COLOR_AZUL_OSCURO = new Color(0, 0, 102);
        txt_BUSQUEDA.setBackground(COLOR_AZUL_OSCURO);
    }//GEN-LAST:event_txt_BUSQUEDAMouseEntered

    private void txt_CHATBOTMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_CHATBOTMouseExited
        txt_CHATBOT.setBackground(null);
    }//GEN-LAST:event_txt_CHATBOTMouseExited

    private void txt_BUSQUEDAMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_BUSQUEDAMouseExited
        txt_BUSQUEDA.setBackground(null);
    }//GEN-LAST:event_txt_BUSQUEDAMouseExited

  
    private void BTN_MODO_NOCHEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN_MODO_NOCHEMouseClicked
CambiarModo(false, BTN, Text, Botones_Panel, PanelEstadisticas, txtEstadisticas, Estadistica.Home, Lateal,Separador);
    
    }//GEN-LAST:event_BTN_MODO_NOCHEMouseClicked

    private void BTN_MODO_DIAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN_MODO_DIAMouseClicked
        CambiarModo(true, BTN, Text, Botones_Panel, PanelEstadisticas, txtEstadisticas, Estadistica.Home, Lateal,Separador);

    }//GEN-LAST:event_BTN_MODO_DIAMouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        setState(ICONIFIED);//MINIMIZA LA VENTANA PRINCIPAL
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        this.dispose();// CIERRA LA VENTANA
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        Dimension d = new Dimension(1350, 675);//REDIMENSIONA LA VENTANA
        this.setSize(d);//PARTE DE LA ACCIÓN DE REDIMENSIONAR
        this.setLocationRelativeTo(null);//CENTRA LA VENTANA
    }//GEN-LAST:event_jLabel9MouseClicked

    private void txt_CHATBOTMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_CHATBOTMouseEntered
        Color COLOR_AZUL_OSCURO = new Color(0, 0, 102);
        txt_CHATBOT.setBackground(COLOR_AZUL_OSCURO);
    }//GEN-LAST:event_txt_CHATBOTMouseEntered

    private void txt_CONFIGURACIONMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_CONFIGURACIONMouseClicked
        general.OpenWindows(WinConf_1, null);        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CONFIGURACIONMouseClicked
   
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
     general.AbrirJInternalFrame(Estadistica, DeskPanel, null, true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void BTN_CLIENTESActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_CLIENTESActionPerformed


    }//GEN-LAST:event_BTN_CLIENTESActionPerformed

    private void Iconos_TrueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Iconos_TrueMouseClicked
        Iconos_Off.setVisible(true);
        Iconos_True.setVisible(false);
        ////////////////
        ActivarEstrellas(false);
        ActivarHojas(false);        
    
        
    }//GEN-LAST:event_Iconos_TrueMouseClicked

    private void Iconos_OffMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Iconos_OffMouseClicked
        Iconos_Off.setVisible(false);
        Iconos_True.setVisible(true);
        if (IconosModo) {
             ActivarHojas(true);
        }else{
            ActivarEstrellas(true);
        }

       
    }//GEN-LAST:event_Iconos_OffMouseClicked

    private void BtLicenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtLicenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtLicenciaActionPerformed

    private void BTN_VENTASActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_VENTASActionPerformed
    
        general.AbrirJInternalFrame(UnidadMedidas, DeskPanel, Querys, false);
       
//general.OpenWindows(WinUser_1, jPanel1);
    }//GEN-LAST:event_BTN_VENTASActionPerformed

    private void BTN_VENTASMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN_VENTASMouseEntered
        //-----> SALIDA HACIA LA DERECHA DE EL TEXTO DE VENTAS
        Color Color_Ventas_Azul = new Color(54, 81, 207);
        BTN_VENTAS.setBackground(Color_Ventas_Azul);
        AnimationClass VENTAS = new AnimationClass();//VENTAS
    }//GEN-LAST:event_BTN_VENTASMouseEntered

    private void BTN_VENTASMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN_VENTASMouseExited
        //<----- ENTRADA HACIA LA IZQUIERDA DE EL TEXTO DE VENTAS
        BTN_VENTAS.setBackground(null);
        AnimationClass VENTASS = new AnimationClass();//VENTAS
    }//GEN-LAST:event_BTN_VENTASMouseExited

    private void BTN_ALMACENMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN_ALMACENMouseExited
        //<----- ENTRADA HACIA LA IZQUIERDA DE EL TEXTO DE BODEGA
        BTN_ALMACEN.setBackground(null);
        AnimationClass BODEGAA = new AnimationClass();//BODEGA
        //(Posición Actual, Posición futura, velocidad, velocidad, nombre del objeto)// MUESTRA EL TEXTO DE ESTADISTICOS// */
    }//GEN-LAST:event_BTN_ALMACENMouseExited

    private void BTN_ALMACENMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN_ALMACENMouseEntered
        //-----> SALIDA HACIA LA DERECHA DE EL TEXTO DE BODEGA
        Color BODE_COLOR_AZUL = new Color(54, 81, 207);
        BTN_ALMACEN.setBackground(BODE_COLOR_AZUL);
        AnimationClass BODEGA = new AnimationClass();//BODEGA
        //(Posición Actual, Posición futura, velocidad, velocidad, nombre del objeto)// MUESTRA EL TEXTO DE ESTADISTICOS// */
    }//GEN-LAST:event_BTN_ALMACENMouseEntered

    private void jButton7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseExited
        //<----- SALIDA HACIA LA IZQUIERDA DE EL TEXTO INFORMES
        jButton7.setBackground(null);
        AnimationClass INFORMEE = new AnimationClass();//INFORMES
    }//GEN-LAST:event_jButton7MouseExited

    private void jButton7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseEntered
        //-----> SALIDA HACIA LA DERECHA DE EL TEXTO INFORMES
        Color INFORMES_COLOR_AZUL = new Color(54, 81, 207);
        jButton7.setBackground(INFORMES_COLOR_AZUL);
        AnimationClass INFORME = new AnimationClass();//INFORMES

    }//GEN-LAST:event_jButton7MouseEntered

    private void BTN_PRODUCTOSMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN_PRODUCTOSMouseExited
        //<----- SALIDA HACIA LA IZQUIERDA DE EL TEXTO DE PRODUCTO
        BTN_PRODUCTOS.setBackground(null);
        AnimationClass PRODUCTOO = new AnimationClass();//PRODUCTO
        ;//(Posición Actual, Posición futura, velocidad, velocidad, nombre del objeto)// MUESTRA EL TEXTO DE ESTADISTICOS//
    }//GEN-LAST:event_BTN_PRODUCTOSMouseExited

    private void BTN_PRODUCTOSMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN_PRODUCTOSMouseEntered
        //-----> SALIDA HACIA LA DERECHA DE EL TEXTO PRODUCTO
        Color PRODUCTO_COLOR_AZUL = new Color(54, 81, 207);
        BTN_PRODUCTOS.setBackground(PRODUCTO_COLOR_AZUL);
        AnimationClass PRODUCTO = new AnimationClass();//PRODUCTO
        //(Posición Actual, Posición futura, velocidad, velocidad, nombre del objeto)// MUESTRA EL TEXTO DE ESTADISTICOS// */
    }//GEN-LAST:event_BTN_PRODUCTOSMouseEntered

    private void BTN_MODO_DIAMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN_MODO_DIAMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_BTN_MODO_DIAMouseEntered

    private void BTN_MODO_NOCHEMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN_MODO_NOCHEMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_BTN_MODO_NOCHEMouseEntered

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        
                // TODO add your handling code here:
    }//GEN-LAST:event_jButton2MouseClicked

    private void BTN_ALMACENActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_ALMACENActionPerformed
        general.AbrirJInternalFrame(Familia1, DeskPanel, Querys, false);
        // TODO add your handling code here:
    }//GEN-LAST:event_BTN_ALMACENActionPerformed

    private void BTN_PRODUCTOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_PRODUCTOSActionPerformed
      general.AbrirJInternalFrame(Familia2, DeskPanel, Querys, false);
    }//GEN-LAST:event_BTN_PRODUCTOSActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Startt2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Startt2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Startt2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Startt2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
   
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Startt2().setVisible(true);
            }
        });
    }
      public FAMILIA1_1 Familia1;
    public FAMILIA2_2 Familia2;
    
    public Estadisticas Estadistica;
    CrearUsuario CrearUser=null; 
    public JSeparator Separador[];
    public  JLabel txtEstadisticas[];
    public JPanel Lateal[];
    public JPanel PanelEstadisticas[];
    public JButton Botones_Panel[];
    public JLabel Text[];
    public JButton BTN[]={};
    private  MySQL_Query Querys;   
    public boolean IconosModo = false;
    public JLabel[] Hojas={};
    public JLabel [] Extrellas={};
    public GENERAL_CLASS general = new GENERAL_CLASS();

//    public FAMILIA3 WinFm3_1;
    public UNIDADMEDIDA UnidadMedidas;
    public CrearBodegas WinCrearBG_1;
    public Configuracion WinConf_1;
    public CrearProducto CrearProducto;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_ALMACEN;
    private javax.swing.JButton BTN_CLIENTES;
    private javax.swing.JLabel BTN_MENU;
    private javax.swing.JLabel BTN_MODO_DIA;
    private javax.swing.JLabel BTN_MODO_NOCHE;
    private javax.swing.JButton BTN_PRODUCTOS;
    private javax.swing.JButton BTN_VENTAS;
    private javax.swing.JButton BtLicencia;
    private javax.swing.JDesktopPane DeskPanel;
    private javax.swing.JPanel HomePrincipal;
    private javax.swing.JLabel Iconos_Off;
    private javax.swing.JLabel Iconos_True;
    private javax.swing.JPanel Menu_Lateral_Izquierdo;
    private javax.swing.JPanel Menu_deslizable_Panel_Contenedor_Botones;
    private javax.swing.JScrollPane ScrollDesktop;
    private javax.swing.JLabel TXT_DIA;
    private javax.swing.JLabel TXT_NOCHE;
    private javax.swing.JLabel estrella4;
    private javax.swing.JLabel estrella_1;
    private javax.swing.JLabel estrella_10;
    private javax.swing.JLabel estrella_2;
    private javax.swing.JLabel estrella_3;
    private javax.swing.JLabel estrella_5;
    private javax.swing.JLabel estrella_6;
    private javax.swing.JLabel estrella_7;
    private javax.swing.JLabel estrella_8;
    private javax.swing.JLabel estrella_9;
    private javax.swing.JLabel hoja_1;
    private javax.swing.JLabel hoja_2;
    private javax.swing.JLabel hoja_3;
    private javax.swing.JLabel hoja_4;
    private javax.swing.JLabel hoja_5;
    private javax.swing.JLabel hoja_6;
    private javax.swing.JLabel hoja_7;
    private javax.swing.JLabel hoja_8;
    private javax.swing.JLabel hoja_9;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel txt_BUSQUEDA;
    private javax.swing.JLabel txt_CHATBOT;
    private javax.swing.JLabel txt_CONFIGURACION;
    // End of variables declaration//GEN-END:variables
}
