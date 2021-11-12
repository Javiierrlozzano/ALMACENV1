/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CLASS;


import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;

import java.util.Map;
import java.util.Vector;

import javax.swing.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;


/**
 *
 * @author JAVIER
 */
public class GENERAL_CLASS {
    //Funcion para agregar nueva fila en JTable con Enter
    public void AgregarDatosJTableArry(JTable table,Object arry[] ){
        DefaultTableModel  modelo ;
        modelo =(DefaultTableModel) table.getModel();
        modelo.addRow(arry);
    }//probandos
    public void  newRowJTable(JTable table,java.awt.event.KeyEvent evt){
        DefaultTableModel  modelo =(DefaultTableModel) table.getModel();
        try {
            if (evt.getKeyCode() ==127) {
                int rows = table.getSelectedRow();
           modelo.removeRow(rows);
        }
        }catch(Exception ex ){
            System.out.println(ex.getMessage());
        }
    }
    //Funcion para abrir ventanas 
    public void OpenWindows(JFrame win, JPanel x){
        try{
      if( win.isVisible() ==false){
        win.setVisible(true);
       win.setLocationRelativeTo(null);
      }else{
          JOptionPane.showMessageDialog(x, "La ventana Esta Abierta");
      }
        }catch(Exception ex){
           JOptionPane.showMessageDialog(null,ex.getMessage());
        }
   
    }
    //Actualizar Table con select 
    public void ActualizarTableSelect(  JTable table){
         DefaultTableModel  modelo ;
        try{
         modelo =(DefaultTableModel) table.getModel();
         table.changeSelection(DISPOSE_ON_CLOSE, DISPOSE_ON_CLOSE, true, true);
         
        }
        catch(Exception x){
            System.out.print("Error al llenar "+x.getMessage());
        }
    }
    //Informes
    public void Informes(String path,Map hm ){
        try{
           
        CONEXION_MySQL conn = new CONEXION_MySQL();
        JasperReport reporte = null;
        reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
        JasperPrint jprint = JasperFillManager.fillReport(path, hm,conn.Conexion());
        JasperViewer view = new JasperViewer(jprint,false);
        view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        view.setVisible(true);
        }catch(JRException ex)
        {JOptionPane.showMessageDialog(null,"Error Crear Informe" + ex.getMessage());}
    
    
    }
    //Cambio de colores Claro
    public void CambiarColoresClaro(JPanel panelesColor[],Color ColorJPanel[],JTextField Text[],JPanel CabeceraVenta,JLabel ex[], Color JPanelColores,Color CabeceraCabesera){
    int Pabe =panelesColor.length;
        for (int i = 0; i < Pabe; i++) {
            panelesColor[i].setBackground(ColorJPanel[i]);
        }
    }
     //Cambio de colores Oscuro
    public void CambiarColoresOscuro(JPanel panelesColor[],JTextField Text[],JPanel CabeceraVenta,JLabel ex[], Color JPanelColores,Color CabeceraCabesera,Color JLabel){
    
    }
     //Funcion para limpiar las casillas de textos 

 public void LimpiarTodo(Object todo[]	){
     for (int i = 0; i < todo.length; i++) {
         if (todo[i].getClass() ==JTextField.class) {
             JTextField ex = (JTextField) todo[i];
             ex.setText("");
         }if (todo[i].getClass() ==JCheckBox.class) {
             JCheckBox chk= (JCheckBox)todo[i];
             chk.setSelected(false);
         }if (todo[i].getClass() ==JTable .class) {
             JTable Table = (JTable) todo[i];
            DefaultTableModel modelo =(DefaultTableModel) Table.getModel();
            modelo.setRowCount(0);
         }if (todo[i].getClass() ==JComboBox .class) {
             JComboBox com = (JComboBox) todo[i];
             com.setSelectedIndex(0);//
         }
     }
     
 }

     //Permitir Solo numeros
    public void  SoloNumeros(java.awt.event.KeyEvent evt,JPanel x){
    char validar = evt.getKeyChar();
       if ( Character.isLetter(validar)){
        evt.consume();
       JOptionPane.showMessageDialog(x, "Ingresar solo Numero");
       } 
    }
     //Cerrar con la text ESC
    public void CerrarWindowsKey(java.awt.event.KeyEvent evt ,JFrame x){
    int  cerrar = evt.getKeyCode();
   
        if (27 == cerrar ){
           int close =  ValdarCerrar();
                if(close == 0){
                    x.setVisible(false);
                }
        }
    }
       //Agregar datos JFieldText de MySQL
    public void TextLlenarSQL(ResultSet resultado,JTextField Text[]){
    int in = Text.length;
        try { while(resultado.next()){
                for (int i = 0; i < in; i++) {
                    Text[i].setText(resultado.getString(i+1));
                }
            }
        }catch(Exception ex ){
            System.out.println(ex.getMessage());
        }
        
    }
        public void AgregarDatosComboboxMysql(JComboBox [] Combobox,ResultSet rs,int indicador){
        try {
            int TotalCombox = Combobox.length;
            for (int i = 0; i < TotalCombox; i++) {
                Combobox[i].removeAllItems(); 
                Combobox[i].addItem("Seleccionar");
                Combobox[i].setSelectedIndex(0);
            }
            while(rs.next()){
                for (int j = 0; j < TotalCombox;j++) {
                    Combobox[j].addItem(rs.getString(j+indicador));
                }
            }
        }
        catch(Exception ex){
        
        }
        }
      //Agregar datos ComboBox de MySQL
    public void AgregarDatosCombobox(JComboBox Combobox,ResultSet rs, int enteros){
        try {
            Combobox.removeAllItems();
            Combobox.addItem("Seleccionar");
            Combobox.setSelectedIndex(0);
            while(rs.next()){
                Combobox.addItem(rs.getString(enteros));
            }
        }
        catch(Exception ex){
        
        }
        
    }
 
    //Insertar Imagenes a un Label 
      public void InsertarImagenLabel(byte[] imagen, JLabel Label){
            if (imagen.length != 0 || imagen !=null ) {
            try{
                BufferedImage image = null;
                InputStream in = new ByteArrayInputStream(imagen);
                image = ImageIO.read(in);
                ImageIcon imgi = new ImageIcon(image.getScaledInstance(60, 60, 0));
                
                Label.setIcon(imgi);
            }catch(IOException ex){ 
                JOptionPane.showMessageDialog(null,"Error insertar Imagen "+ ex.getMessage()); 
            }
        }else{
            Label.setText("No hay Foto");
        }
    } 
    
      //Agregar Resultados en Tablas de MySQL
    public void AgregarTable(JTable Table , int Colum[], ResultSet rs ){
         DefaultTableModel  modelo ;
        try{
         modelo =(DefaultTableModel) Table.getModel();
         modelo.setRowCount(0);
         while(rs.next()){
            Vector v = new Vector();
            for (int i = 0; i < Colum.length; i++) {
              v.add(rs.getString(Colum[i]));
                 } 
            modelo.addRow(v);
            }
        }
        catch(Exception x){
            System.out.print("Error al llenar "+x.getMessage());
        }
    }
    //Solo mayusculas
    public void Mayus(JTextField text){
     text.setText (text.getText().toUpperCase());
    }
    //Valir cerrar
    public int ValdarCerrar(){
        int conf = JOptionPane.showConfirmDialog(null, "¿Realmente quiere cancelar?", 
                "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        return conf ;
    }
    //Validar Vacios Text
    public boolean VaciosText(JTextField Text[]){
       boolean Valirdat = true;
        int in = Text.length;
        for (int i = 0; i < in; i++) {
            if (Text[i].getText().length()==0) {
                 Valirdat=false;
                break;
            }
        }
        return Valirdat;
    }
     //Validar Vacios Combobox
    public boolean VaciosCombobox(JComboBox[] ListComx){
       boolean Valirdar = true;
        int in = ListComx.length;
        for (int i = 0; i < in; i++) {
            if (ListComx[i].getSelectedIndex() ==0) {
                 Valirdar=false;
                break;
            }
        }
        return Valirdar;
    }
    //Buscar datos JTable
    public String[] DatosJTable(JTable table ){
        String valor[] = new String [table.getColumnCount()];
        if(table.isEnabled()){
        int seleccion =   table.getSelectedRow()  ;
        for (int i = 0; i < table.getColumnCount(); i++) {
            valor[i] = table.getValueAt(seleccion, i).toString();
            }
        }
        return valor;
       
    }
    //Funciones para IMAGENES
    public File  Exan(JPanel x){
            File rutas =null;
        try {
        JFileChooser j = new JFileChooser();
        FileNameExtensionFilter fil = new FileNameExtensionFilter("JPG, PNG & GIF","jpg","png","gif");
        j.setFileFilter(fil);
        
        int s = j.showOpenDialog(x);
        if(s == JFileChooser.APPROVE_OPTION){
            String ruta = j.getSelectedFile().getAbsolutePath();
             rutas = new File(ruta);
              return rutas;
              
        }
        
        }catch(Exception e ){
            System.out.println(e.getMessage());
        }
    
        
        return rutas; 
    }
    public byte[] AgregarImagenBit(File ruta){
       byte [] icono =null;
         try{
             if(ruta != null){
                 icono = new byte[(int) ruta.length()];
            InputStream input = new FileInputStream(ruta);
            input.read(icono);
             System.out.print(icono);
              System.out.print(" ");
             }
        }catch(Exception ex){
             System.out.print("Error en Convertir ");
        }
         return icono;
    }
}

