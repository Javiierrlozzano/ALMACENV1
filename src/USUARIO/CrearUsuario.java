/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package USUARIO;

import CLASS.GENERAL_CLASS;
import CLASS.MySQL_Query;
import CLASS.TextPrompt;
import HOME.Generar_Informes;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JAVIER
 */
public class CrearUsuario extends javax.swing.JInternalFrame {

    /**
     * Creates new form CrearUsuario
     */
    public CrearUsuario(MySQL_Query BodegasInicio, boolean ini) {
        initComponents();
         Querys=BodegasInicio;
             ini= inic;
             activa(inic); 
             ProveedoreAction(ini);
             JTextField TextUB1[] ={NDocumento,Nombre_1};
             JTextField TextProveedor1[]={RazonSocial,Direccion,Telefono,EMails};
             JComboBox ComboboxUB1[]={EstadoPro,TipoDocumento};
             JTextField TextEm1[]={Ciudad,Departamento,Barrio,Long,Lat,CodPos};
             JTextField DatosCredito[]={};
             ComboboxUB=ComboboxUB1;
             TextUB=TextUB1;
             TextProveedor=TextProveedor1;
             TextEm =TextEm1;
             InciosUsuario();
    }
    public void ModificarProveedor(){
     DatosProveedor();
     Querys.ModicarProveedor(RazonSocialNom, DirrecionPro, Tel, EmailFactura, ResponsableIVA, AutoRetenedor, id);   
 }
//Funcion Para modificar los datos Basicos de Usuario
    public void GetTextUsuarioBD(){
        ChecKPro =Proveedor.isSelected(); 
        ChecKCli =sCliente.isSelected(); 
        ChecKEm =Empleado.isSelected(); 
        TipoDoc= TipoDocumento.getSelectedItem().toString();
        NumeroDocumento= NDocumento.getText();
        NombreCompleto = Nombre_1.getText();
        Emailusuario= Email.getText();
        NombreBanco = NBanco.getSelectedItem().toString();
        NCuentaBancaria = NCuenta.getText();
        Estado = EstadoPro.getSelectedItem().toString();
        id =CODIGOS.getText();
        CheakBanco =Cuenta.isSelected();
        ChecKCorriente =Corriente.isSelected();
        ChecKAhorro   =Ahorros.isSelected();
    }
    public void ModificarUsuarioBD(){
           GetTextUsuarioBD();
           Querys.ModificarUsuarioBD(TipoDoc, NumeroDocumento, NombreCompleto, Emailusuario,NCuentaBancaria , NombreBanco, Estado, ChecKPro, ChecKCli, ChecKEm,id,CheakBanco,ChecKCorriente,ChecKAhorro,imagen);
        }
    private void Actualizar(){
            try {
            
         ModificarUsuarioBD();
         ModificarProveedor();
         activa(false);
         LimbiarUB();
        btGuardar.setVisible(true);
        } catch (Exception ex) {
        }
     
    }
    private void Informe(){
       Map hm1 =new HashMap ();
       hm1.put("IdValor",NDocumento.getText());
        Generar_Informes inf = new Generar_Informes("src\\Informes\\report2.jasper",hm1);
        general.OpenWindows(inf, null);

}
    public void DatosProveedor(){
                         RazonSocialNom = RazonSocial.getText();
                     DirrecionPro= Direccion.getText();
                     Tel =Telefono.getText();
                     EmailFactura = EMails.getText();
                     ResponsableIVA = ReIVA.isSelected();
                     AutoRetenedor = AutRete.isSelected();
                     id = CODIGOS.getText();
    }
    private void ProovedoresMySQL(){                         
                    DatosProveedor();
                    Querys.InsertarProveedor(RazonSocialNom, DirrecionPro, Tel, EmailFactura, ResponsableIVA, AutoRetenedor, id);   
      
   }
    private void EmpleadoMySQL(){
        System.out.print("Ingresado Empleado ");    
   }
    private void ClienteMySQL(){
     System.out.print("Ingresado Empleado ");    

     }
     //Valirdar Check de Proveedor 
    private void InsertarUsuario(){
  
          boolean ValidarVacioPRO = general.VaciosText(TextProveedor);
          boolean ValidarVacioEm= true;
          boolean ValidarVacioCli = true;

        // Proveedor
        if (! Empleado.isSelected() && !sCliente.isSelected() && Proveedor.isSelected() ) {
        if (ValidarVacioPRO ) { 
            InsertarUsuarioBasicoMysql();
            ProovedoresMySQL();
            LimbiarUB();
        }else {
        JOptionPane.showMessageDialog(null, "Llenar todos los datos de datos Proveedor");
        }
        }
        //Empleado 
        if ( Empleado.isSelected() && !sCliente.isSelected() && !Proveedor.isSelected() ) {
            if (ValidarVacioEm ) { 
                InsertarUsuarioBasicoMysql();
                EmpleadoMySQL();
                LimbiarUB();
                
            }else {
            JOptionPane.showMessageDialog(null, "Llenar todos los datos de datos Proveedor");
            }
        }
        //Cliente
        if ( !Empleado.isSelected() && sCliente.isSelected() && !Proveedor.isSelected() ) {
            if (ValidarVacioCli ) { 
                InsertarUsuarioBasicoMysql();
                ClienteMySQL();
                    LimbiarUB();
            }else {
            JOptionPane.showMessageDialog(null, "Llenar todos los datos de datos Proveedor");
            }
        
        }

        //Todos Empleado cliente y proveedor
        if ( Empleado.isSelected() && sCliente.isSelected() && Proveedor.isSelected() ) {
            
            if (ValidarVacioPRO && ValidarVacioCli && ValidarVacioEm ) { 
                InsertarUsuarioBasicoMysql();
                EmpleadoMySQL();
                ProovedoresMySQL();
                ClienteMySQL();
                    LimbiarUB();
            }else {
            JOptionPane.showMessageDialog(null, "Llenar todos los datos de datos Proveedor");
            }
          
        }
        //Cliente 
        if ( !Empleado.isSelected() && sCliente.isSelected() && Proveedor.isSelected() ) {
            if (ValidarVacioPRO && ValidarVacioCli ) { 
                InsertarUsuarioBasicoMysql();
                 ProovedoresMySQL();
                ClienteMySQL();
                    LimbiarUB();
            }else {
            JOptionPane.showMessageDialog(null, "Llenar todos los datos de datos Proveedor");
            }
         
        }
        //Empleado y cliente
        if ( Empleado.isSelected() && sCliente.isSelected() && !Proveedor.isSelected() ) {
            if (ValidarVacioEm && ValidarVacioCli) { 
                InsertarUsuarioBasicoMysql();
                EmpleadoMySQL();
                ClienteMySQL();
                    LimbiarUB();
            }else {
            JOptionPane.showMessageDialog(null, "Llenar todos los datos de datos Proveedor");
            }
            
        }
        //Empleado y proveedor
        if ( Empleado.isSelected() && !sCliente.isSelected() && Proveedor.isSelected() ) {
            if (ValidarVacioPRO && ValidarVacioEm ) { 
                InsertarUsuarioBasicoMysql();
                EmpleadoMySQL();
                ProovedoresMySQL();
                    LimbiarUB();
            }else {
            JOptionPane.showMessageDialog(null, "Llenar todos los datos de datos Proveedor");
            }
        }

    }
    public boolean ValirdarBancos(){
        boolean Valir = false;
      
        
        
        if (Cuenta.isSelected()) {
    if (NBanco.getSelectedIndex()==0 || NCuenta.getText().length()==0  || (! Ahorros.isSelected()&&!Corriente.isSelected()) ) {
        JOptionPane.showMessageDialog(null, "Llenar Todos los campos");
   }else{Valir = true;}
        }else{
            Valir= true;
        }
        return Valir;
    }
    private void InsertarUsuarioBasicoMysql(){
                 GetTextUsuarioBD();
                Querys.InsertarUsuarioBC(id,TipoDoc, NumeroDocumento, NombreCompleto, Emailusuario,NCuentaBancaria , NombreBanco, Estado, ChecKPro, ChecKCli, ChecKEm,CheakBanco,ChecKCorriente,ChecKAhorro,imagen);
                              
    }
    private void Teclas  (java.awt.event.KeyEvent evt){
      if (evt.getKeyCode()==112){
          Adicionar();
      }
      if (evt.getKeyCode()==112){
          Actualizar();
      }
      if (evt.getKeyCode()==112){
          Informe();
      }
      if (evt.getKeyCode()==112){
          Guardar();
      }
      if (evt.getKeyCode()==112){
          Cancelar();
      }
      if (evt.getKeyCode()==112){
          Buscar();
      }
     
  }
    private void Adicionar (){

    
          activa(true); 
    
     ResultSet resultado=   Querys.InicioUsuario() ;
     try     {
    int entero=0;
    while(resultado.next()){
    entero = resultado.getInt(1);
     }
      CODIGOS.setText((entero+1)+"");
     }catch(Exception ex){
      
     }
    
 btActualizar.setVisible(false);   
 btModificar.setVisible(false);
    
    
}
    private void Cancelar (){
             
        int conf = general.ValdarCerrar();
        if (conf == 0) {
            LimbiarUB();
            activa(false);
            btGuardar.setVisible(true);
}
}
    private void Buscar (){
    general.OpenWindows(usuario, null);
    
}
    public void BuscarUser( ResultSet resultado){
        try{
            //Usuario Basico
            CODIGOS.setText(resultado.getString(1));
            NDocumento.setText(resultado.getString(2));
            TipoDocumento.setSelectedItem(resultado.getString(3));
            Nombre_1.setText(resultado.getString(4));
            Email.setText(resultado.getString(5));
            NBanco.setSelectedItem(resultado.getString(7));
            NCuenta.setText(resultado.getString(6));
            EstadoPro.setSelectedItem(resultado.getString(8));
            Proveedor.setSelected(resultado.getBoolean(9));
            Empleado.setSelected(resultado.getBoolean(10));
            sCliente.setSelected(resultado.getBoolean(11));
            Cuenta.setSelected(resultado.getBoolean(12));
            Corriente.setSelected(resultado.getBoolean(13));
            Ahorros.setSelected(resultado.getBoolean(14));

            //PROVEEDOR
            RazonSocial.setText(resultado.getString(15));
            Direccion.setText(resultado.getString(16));
            Telefono.setText(resultado.getString(17));
            EMails.setText(resultado.getString(18));
            ReIVA.setSelected(resultado.getBoolean(19));
            AutRete.setSelected(resultado.getBoolean(20));
            //Imagenes
            general.InsertarImagenLabel(resultado.getBytes(21), jLabel1);
            
            //EMPLEADO
            //
       
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
       

    }
    public void BuscarUsuarios(int indicado[],String Indicador,String GetText ,JTable Table){   
    try {
          // ResultSet   rs =Querys.BuscarUsuario("IdUsuario",idUsuarioBuscar.getText() );
           ResultSet   rs =Querys.BuscarUsuario(Indicador,GetText );
          general.AgregarTable(Table, indicado, rs);
            // TODO add your handling code here:
        } catch (SQLException ex) {
          
        }}      
    public String GetTables(JTable table){
                String Resultado ="";
                DefaultTableModel  modelo ;
                modelo =(DefaultTableModel) table.getModel();
                int Rows = table.getSelectedRow();
                Resultado = modelo.getValueAt(Rows,0).toString();
        return Resultado;
        }
    public void UsuarioBs (String IdUsuario,String Where,String Mensaje,JFrame BuscarUsuario){
    String Idusuario =IdUsuario;
            try{
            ResultSet resultado =  Querys.UsuarioDocBC(Idusuario,Where);
            if (resultado.next()) {
                   int conf = JOptionPane.showConfirmDialog(null,Mensaje, 
                  "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (conf == 0) {
                  activa(true); 
                  btGuardar.setVisible(false);
                  BuscarUser(resultado);
                  BuscarUsuario.setVisible(false);


                }else{
                  activa(false); 
                  btGuardar.setVisible(true);
                    LimbiarUB();
                }
            }else{    
                try{
                     int conf = JOptionPane.showConfirmDialog(null,"Deseas Buscarlo en BD-DIAN", 
                            "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    
                     if (conf ==0 && IdUsuario.length()!=0 &&IdUsuario !="") {
                        
                         
                        
                        String Personas[]=  general.BuscarNITDian(IdUsuario);
                          TipoDocumento.setSelectedItem("NIT");
                          DVC.setText(Personas[1]);
                          Nombre_1.setText(Personas[2]);
                          Nombre_2.setText(Personas[3]);
                          Apellido_1.setText(Personas[4]);
                          Apellido_2.setText(Personas[5]);
                          Nombre_Completo.setText(Personas[2]+" "+ Personas[3]+" "+Personas[4]+" "+Personas[5]);
                        
                    }
                  }catch(Exception ex){
                      JOptionPane.showMessageDialog(null,"Error web Dian "+ ex.getMessage());  
                  }
            }
            
               }catch(Exception ex){
                System.out.println(ex.getMessage());
            }

    }
    private void Guardar (){
     boolean ValidarVacioUB = general.VaciosText(TextUB);
        boolean ValirdarVacioUBC= general.VaciosCombobox(ComboboxUB);
       
        if (ValidarVacioUB&&ValirdarVacioUBC&& ValirdarBancos()) { 
           if (Proveedor.isSelected()||Empleado.isSelected()||sCliente.isSelected()) {
          InsertarUsuario();
        }else  {
            JOptionPane.showMessageDialog(null, "Seleccionar un tipo de Usuario");
        }
        }else{
                JOptionPane.showMessageDialog(null, "Llenar todos los datos de datos Usuario Basicos");
        }
     
}
    private void InciosUsuario (){
             DVC.setVisible(false);
            TextPrompt Tx ;
            JTextField TxtField[] ={NDocumento,Nombre_1,Nombre_2,Apellido_1,Apellido_2,Nombre_Completo,Email};
            String PropText[]={"N?? Documento","Primer Nombre","Segundo Nombre","Primer Apellido","Segundo Apellido","Nombre Completo","Email"};
            general.TextProp(TxtField, PropText);
    }
    private void ProveedoreAction(Boolean x){
        RazonSocial.setEnabled(x);
        Direccion.setEnabled(x); 
        Telefono.setEnabled(x);
        EMails.setEnabled(x);
        ReIVA.setEnabled(x);
        AutRete.setEnabled(x);
//pruebas
    }
    public  void  activa( Boolean x){
    NDocumento.setEnabled(x);
    Nombre_1.setEnabled(x);
    Email.setEnabled(x);
    jPanel5.setEnabled(x);
        if (x==false) {
           Cuenta.setSelected(false);
           Proveedor.setSelected(false);
           Empleado.setSelected(false);
           sCliente.setSelected(false);
        }
  //  ClienteDo.setEnabled(x);
    //ClienteBan.setEnabled(x);
    Proveedor.setEnabled(x);
    Empleado.setEnabled(x);
    sCliente.setEnabled(x);
    TipoDocumento.setEnabled(x);
    btGuardar.setEnabled(x);
    btAdicionar.setVisible(!x);
    EstadoPro.setEnabled(x);
    btCancelar.setVisible(x);
    btActualizar.setVisible(x);
    Cuenta.setEnabled(x);
    btModificar.setVisible(x);
 //   PanelProveedor.setVisible(x);
    }
    public void LimbiarUB(){
        JTextField text [] ={NDocumento,Nombre_1,Email,NCuenta};
        JComboBox com [] ={TipoDocumento,NBanco,EstadoPro};
        general.LimpiarTodo(text);
        general.LimpiarTodo(com);
        activa(false);
        Ahorros.setSelected(false);
        Corriente.setSelected(false);
        btActualizar.setSelected(false);
        btModificar.setSelected(false);
      Icon  Imagenes = new ImageIcon(getClass().getResource("/IMAGENES/Usuario5.png"));                       
                    jLabel1.setIcon(Imagenes);
    }
    private void LimpiarPro(){
       JTextField text [] ={RazonSocial,Direccion,Telefono,EMails};
       general.LimpiarTodo(text);
       ReIVA.setSelected(false);
       AutRete.setSelected(false);
       
      }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        MenuCPE = new javax.swing.JTabbedPane();
        jPanel13 = new javax.swing.JPanel();
        jTabbedPane5 = new javax.swing.JTabbedPane();
        jPanel16 = new javax.swing.JPanel();
        ClienteBan = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        idProveedor7 = new javax.swing.JComboBox<>();
        TarjetaCredito = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        InteresCorriente = new javax.swing.JTextField();
        DiasCorriente = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jCheckBox8 = new javax.swing.JCheckBox();
        TarjetaPuntos = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        TotalPuntos = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        EstadoCivil1 = new javax.swing.JTextField();
        DiasGracias = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        DiasCredito = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        CupoCredito = new javax.swing.JTextField();
        FechaRadicacion = new org.jdatepicker.JDatePicker();
        jLabel62 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        ClienteDo = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        Barrio = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        Ciudad = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        Departamento = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        Long = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        Lat = new javax.swing.JTextField();
        CodPos = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel49 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jTabbedPane6 = new javax.swing.JTabbedPane();
        jPanel18 = new javax.swing.JPanel();
        jLabel67 = new javax.swing.JLabel();
        NCuenta1 = new javax.swing.JTextField();
        jLabel68 = new javax.swing.JLabel();
        NCuenta2 = new javax.swing.JTextField();
        jLabel69 = new javax.swing.JLabel();
        NCuenta3 = new javax.swing.JTextField();
        Proveedor1 = new javax.swing.JCheckBox();
        jLabel15 = new javax.swing.JLabel();
        jButton20 = new javax.swing.JButton();
        jPanel20 = new javax.swing.JPanel();
        Empleado1 = new javax.swing.JCheckBox();
        jLabel16 = new javax.swing.JLabel();
        idEmpleados = new javax.swing.JCheckBox();
        Empleado3 = new javax.swing.JCheckBox();
        SalarioNominal = new javax.swing.JCheckBox();
        CheckVentas = new javax.swing.JCheckBox();
        ValorVentas = new javax.swing.JTextField();
        ValorSalarioNominal = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        ProveedorPanel = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        RazonSocial = new javax.swing.JTextField();
        Direccion = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        Telefono = new javax.swing.JTextField();
        EMails = new javax.swing.JTextField();
        AutRete = new javax.swing.JCheckBox();
        ReIVA = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        CODIGOS = new javax.swing.JTextField();
        NBanco = new javax.swing.JComboBox<>();
        Nombre_1 = new javax.swing.JTextField();
        Proveedor = new javax.swing.JCheckBox();
        Empleado = new javax.swing.JCheckBox();
        NDocumento = new javax.swing.JTextField();
        sCliente = new javax.swing.JCheckBox();
        NCuenta = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Email = new javax.swing.JTextField();
        btAdicionar = new javax.swing.JButton();
        btModificar = new javax.swing.JButton();
        btGuardar = new javax.swing.JButton();
        btActualizar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        EstadoPro = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        btModificar1 = new javax.swing.JButton();
        Cuenta = new javax.swing.JCheckBox();
        Ahorros = new javax.swing.JRadioButton();
        Corriente = new javax.swing.JRadioButton();
        Nombre_Completo = new javax.swing.JTextField();
        Apellido_1 = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jLabel54 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        Apellido_2 = new javax.swing.JTextField();
        Nombre_2 = new javax.swing.JTextField();
        DVC = new javax.swing.JTextField();
        try {
            TipoDocumento =(javax.swing.JComboBox)java.beans.Beans.instantiate(getClass().getClassLoader(), "USUARIO.Usuario_jComboBox1");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        jLabel64 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        logo_claro = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();

        setBorder(null);
        setClosable(true);
        setIconifiable(true);
        setResizable(true);

        Panel.setBackground(new java.awt.Color(10, 15, 42));
        Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("STLiti", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Crear Usuario");
        Panel.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 10, 170, 50));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("STLiti", 0, 48)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Jetxcel");
        Panel.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 130, 50));

        jLabel61.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/icons8_rocket_40px.png"))); // NOI18N
        Panel.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 300, 50, 50));

        jLabel52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/icons8_starfish_32px.png"))); // NOI18N
        Panel.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, -1, -1));

        jLabel63.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/icons8_starfish_20px_2.png"))); // NOI18N
        Panel.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 260, 30, 40));

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/icons8_starfish_10px.png"))); // NOI18N
        Panel.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 130, -1, -1));

        jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/icons8_starfish_20px.png"))); // NOI18N
        Panel.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 20, 30, 30));

        jLabel66.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/icons8_launch_30px_3.png"))); // NOI18N
        Panel.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 210, 40, 40));

        MenuCPE.setBackground(new java.awt.Color(16, 34, 43));
        MenuCPE.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)), "Menu_CEP", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Light", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        MenuCPE.setForeground(new java.awt.Color(255, 255, 255));
        MenuCPE.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        MenuCPE.setToolTipText("sdgg");
        MenuCPE.setFocusable(false);
        MenuCPE.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        MenuCPE.setMinimumSize(new java.awt.Dimension(303, 26));
        MenuCPE.setRequestFocusEnabled(false);

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane5.setBackground(new java.awt.Color(1, 1, 1));
        jTabbedPane5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTabbedPane5.setForeground(new java.awt.Color(255, 255, 255));
        jTabbedPane5.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);
        jTabbedPane5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTabbedPane5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTabbedPane5.setOpaque(true);

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel16.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ClienteBan.setBackground(new java.awt.Color(1, 1, 1));
        ClienteBan.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ClienteBan.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        ClienteBan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Tarjeta Credito");
        ClienteBan.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, 20));

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/Billetera.png"))); // NOI18N
        ClienteBan.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 0, 100, 90));

        idProveedor7.setBackground(new java.awt.Color(204, 204, 204));
        idProveedor7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        idProveedor7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ACTIVO", "INNACTIVO", "REPORTADO" }));
        org.jdesktop.swingx.autocomplete.AutoCompleteDecorator.decorate(TipoDocumento);
        idProveedor7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idProveedor7ActionPerformed(evt);
            }
        });
        ClienteBan.add(idProveedor7, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, 120, 30));

        TarjetaCredito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TarjetaCreditoActionPerformed(evt);
            }
        });
        ClienteBan.add(TarjetaCredito, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 150, 30));

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Interes Corriente %");
        ClienteBan.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, 20));

        InteresCorriente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InteresCorrienteActionPerformed(evt);
            }
        });
        ClienteBan.add(InteresCorriente, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 70, 30));

        DiasCorriente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DiasCorrienteActionPerformed(evt);
            }
        });
        ClienteBan.add(DiasCorriente, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, 50, 30));

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("Dias de gracias");
        ClienteBan.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, 20));

        jCheckBox8.setBackground(new java.awt.Color(204, 255, 255));
        jCheckBox8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox8.setText("GANAS PUNTOS");
        jCheckBox8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox8ActionPerformed(evt);
            }
        });
        ClienteBan.add(jCheckBox8, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 80, -1, -1));

        TarjetaPuntos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TarjetaPuntosActionPerformed(evt);
            }
        });
        ClienteBan.add(TarjetaPuntos, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 120, 120, 30));

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("Tarjeta Puntos");
        ClienteBan.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, -1, 20));

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("DIAS");
        ClienteBan.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, -1, 20));

        TotalPuntos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TotalPuntosActionPerformed(evt);
            }
        });
        ClienteBan.add(TotalPuntos, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 150, 120, 30));

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("Total Puntos");
        ClienteBan.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 160, -1, 20));

        jLabel57.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(255, 255, 255));
        jLabel57.setText("Fecha Radicaci??n");
        ClienteBan.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, 20));

        jLabel8.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Datos Creditos");
        ClienteBan.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 230, -1));
        ClienteBan.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 190, 10));

        EstadoCivil1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EstadoCivil1ActionPerformed(evt);
            }
        });
        ClienteBan.add(EstadoCivil1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 150, 30));

        DiasGracias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DiasGraciasActionPerformed(evt);
            }
        });
        ClienteBan.add(DiasGracias, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 150, 30));

        jLabel50.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setText("Estado");
        ClienteBan.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, -1, 20));

        jLabel51.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(255, 255, 255));
        jLabel51.setText("Dias Credito");
        ClienteBan.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, 20));

        DiasCredito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DiasCreditoActionPerformed(evt);
            }
        });
        ClienteBan.add(DiasCredito, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, 150, 30));

        jLabel56.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(255, 255, 255));
        jLabel56.setText("Cupo Credito");
        ClienteBan.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, 20));

        CupoCredito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CupoCreditoActionPerformed(evt);
            }
        });
        ClienteBan.add(CupoCredito, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 150, 30));

        FechaRadicacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FechaRadicacionActionPerformed(evt);
            }
        });
        ClienteBan.add(FechaRadicacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 200, -1, -1));

        jLabel62.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/icons8_asteroid_50px_4.png"))); // NOI18N
        ClienteBan.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 60, 60, -1));

        jLabel65.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/icons8_starfish_32px.png"))); // NOI18N
        ClienteBan.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, -1, -1));

        jPanel16.add(ClienteBan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 247));

        jTabbedPane5.addTab("Datos de Creditos Y Fiadores", jPanel16);

        ClienteDo.setBackground(new java.awt.Color(1, 1, 1));
        ClienteDo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ClienteDo.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        ClienteDo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("Barrio");
        ClienteDo.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        Barrio.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        Barrio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BarrioActionPerformed(evt);
            }
        });
        ClienteDo.add(Barrio, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, 160, 20));

        jLabel37.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/Satelite2.png"))); // NOI18N
        jLabel37.setText(" ");
        jLabel37.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ClienteDo.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 30, 40, 60));

        jLabel39.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("Ciudad");
        ClienteDo.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        Ciudad.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        Ciudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CiudadActionPerformed(evt);
            }
        });
        ClienteDo.add(Ciudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 160, 20));

        jLabel40.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("Departamento");
        ClienteDo.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        Departamento.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        Departamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DepartamentoActionPerformed(evt);
            }
        });
        ClienteDo.add(Departamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 160, 20));

        jLabel42.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setText("Longitud");
        ClienteDo.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 130, -1, -1));

        Long.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        Long.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LongActionPerformed(evt);
            }
        });
        ClienteDo.add(Long, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 130, 160, 20));

        jLabel43.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setText("Latitud");
        ClienteDo.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 160, -1, -1));

        Lat.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        Lat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LatActionPerformed(evt);
            }
        });
        ClienteDo.add(Lat, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 160, 160, 20));

        CodPos.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        CodPos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CodPosActionPerformed(evt);
            }
        });
        ClienteDo.add(CodPos, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 190, 160, 20));

        jLabel44.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setText("Cod.Postal");
        ClienteDo.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 190, -1, -1));

        jLabel41.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/Mundo2.png"))); // NOI18N
        jLabel41.setText(" ");
        jLabel41.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ClienteDo.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, 100, 100));

        jSeparator2.setToolTipText("");
        ClienteDo.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 160, 10));

        jLabel49.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setText("DOMICILIO");
        ClienteDo.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 160, -1));

        jTabbedPane5.addTab("Datos Dominicilio", ClienteDo);

        jPanel13.add(jTabbedPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 280));

        MenuCPE.addTab("", jPanel13);

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));
        jPanel17.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane6.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTabbedPane6.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);
        jTabbedPane6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jPanel18.setBackground(new java.awt.Color(204, 255, 255));
        jPanel18.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel18.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel67.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel67.setText("Nombre Usuario");
        jPanel18.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, 20));

        NCuenta1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NCuenta1ActionPerformed(evt);
            }
        });
        jPanel18.add(NCuenta1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, 200, 30));

        jLabel68.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel68.setText("Contrase??a");
        jPanel18.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, 20));

        NCuenta2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NCuenta2ActionPerformed(evt);
            }
        });
        jPanel18.add(NCuenta2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 200, 30));

        jLabel69.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel69.setText("Confirmar Contrase??a");
        jPanel18.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, 20));

        NCuenta3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NCuenta3ActionPerformed(evt);
            }
        });
        jPanel18.add(NCuenta3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 170, 200, 30));

        Proveedor1.setBackground(new java.awt.Color(255, 255, 255));
        Proveedor1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        Proveedor1.setText("Usuario Sistema ");
        Proveedor1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Proveedor1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                Proveedor1ItemStateChanged(evt);
            }
        });
        Proveedor1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                Proveedor1StateChanged(evt);
            }
        });
        jPanel18.add(Proveedor1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 130, 30));

        jLabel15.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel15.setText("Agregar Usuario de sistema");
        jPanel18.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, 200, -1));

        jButton20.setText("PERMISOS");
        jPanel18.add(jButton20, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 170, -1, 30));

        jTabbedPane6.addTab("Usuario de Sistema", jPanel18);

        jPanel20.setBackground(new java.awt.Color(1, 1, 1));
        jPanel20.setForeground(new java.awt.Color(255, 255, 255));
        jPanel20.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel20.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jPanel20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Empleado1.setBackground(new java.awt.Color(1, 1, 1));
        Empleado1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        Empleado1.setForeground(new java.awt.Color(255, 255, 255));
        Empleado1.setText("SALARIO %VENTAS DE PRODUCTO");
        Empleado1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Empleado1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                Empleado1ItemStateChanged(evt);
            }
        });
        jPanel20.add(Empleado1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 280, -1));

        jLabel16.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("y el % ventas producto, es sobre la utilidad de cada producto vendido ");
        jPanel20.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 460, -1));

        idEmpleados.setBackground(new java.awt.Color(1, 1, 1));
        idEmpleados.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        idEmpleados.setForeground(new java.awt.Color(255, 255, 255));
        idEmpleados.setText("EMPLEADO");
        idEmpleados.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        idEmpleados.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                idEmpleadosItemStateChanged(evt);
            }
        });
        jPanel20.add(idEmpleados, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 110, -1));

        Empleado3.setBackground(new java.awt.Color(1, 1, 1));
        Empleado3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        Empleado3.setForeground(new java.awt.Color(255, 255, 255));
        Empleado3.setText("INGRESADO NOMINA ");
        Empleado3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Empleado3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                Empleado3ItemStateChanged(evt);
            }
        });
        jPanel20.add(Empleado3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, 160, -1));

        SalarioNominal.setBackground(new java.awt.Color(1, 1, 1));
        SalarioNominal.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        SalarioNominal.setForeground(new java.awt.Color(255, 255, 255));
        SalarioNominal.setText("SALARIO NOMINAL");
        SalarioNominal.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        SalarioNominal.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                SalarioNominalItemStateChanged(evt);
            }
        });
        jPanel20.add(SalarioNominal, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 40, 160, -1));

        CheckVentas.setBackground(new java.awt.Color(1, 1, 1));
        CheckVentas.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        CheckVentas.setForeground(new java.awt.Color(255, 255, 255));
        CheckVentas.setText("SALARIO %VENTAS ");
        CheckVentas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        CheckVentas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CheckVentasItemStateChanged(evt);
            }
        });
        jPanel20.add(CheckVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 280, -1));

        ValorVentas.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        ValorVentas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ValorVentas.setEnabled(false);
        ValorVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ValorVentasActionPerformed(evt);
            }
        });
        jPanel20.add(ValorVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 120, 150, 30));

        ValorSalarioNominal.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        ValorSalarioNominal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ValorSalarioNominal.setEnabled(false);
        ValorSalarioNominal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ValorSalarioNominalActionPerformed(evt);
            }
        });
        jPanel20.add(ValorSalarioNominal, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 70, 160, 30));

        jLabel17.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("CONFIGURACIONES BASICAS DE EMPLEADO ");
        jPanel20.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 310, -1));

        jLabel18.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("CONFIGURACIONES VENDEDOR ");
        jPanel20.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 310, -1));

        jLabel19.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Nota: el % de ventas  es sobre la utilidad de cada ventas ");
        jPanel20.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 390, -1));

        jTabbedPane6.addTab("Empleados ", jPanel20);

        jPanel17.add(jTabbedPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 280));

        MenuCPE.addTab("", null, jPanel17, "");

        ProveedorPanel.setBackground(new java.awt.Color(1, 1, 1));
        ProveedorPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ProveedorPanel.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        ProveedorPanel.setEnabled(false);
        ProveedorPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel45.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setText("Razon social");
        ProveedorPanel.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, 20));

        RazonSocial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RazonSocialActionPerformed(evt);
            }
        });
        ProveedorPanel.add(RazonSocial, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 180, 30));

        Direccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DireccionActionPerformed(evt);
            }
        });
        ProveedorPanel.add(Direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 70, 160, 30));

        jLabel47.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setText("Telefono");
        ProveedorPanel.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 70, 20));

        Telefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TelefonoActionPerformed(evt);
            }
        });
        ProveedorPanel.add(Telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, 180, 30));

        EMails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EMailsActionPerformed(evt);
            }
        });
        ProveedorPanel.add(EMails, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 120, 160, 30));

        AutRete.setBackground(new java.awt.Color(1, 1, 1));
        AutRete.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        AutRete.setForeground(new java.awt.Color(255, 255, 255));
        AutRete.setText("AUTO RETENEDOR");
        AutRete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AutReteActionPerformed(evt);
            }
        });
        ProveedorPanel.add(AutRete, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 210, -1, 20));

        ReIVA.setBackground(new java.awt.Color(1, 1, 1));
        ReIVA.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        ReIVA.setForeground(new java.awt.Color(255, 255, 255));
        ReIVA.setText("RESPONSABLE DE IVA");
        ReIVA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReIVAActionPerformed(evt);
            }
        });
        ProveedorPanel.add(ReIVA, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, -1, 20));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("PROVEEDOR");
        ProveedorPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 160, 30));
        ProveedorPanel.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 170, 10));

        jLabel59.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(255, 255, 255));
        jLabel59.setText("Direccion");
        ProveedorPanel.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 80, -1, 20));

        jLabel60.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(255, 255, 255));
        jLabel60.setText("E-mail");
        ProveedorPanel.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, 50, 20));

        MenuCPE.addTab("", ProveedorPanel);

        Panel.add(MenuCPE, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 670, 310));

        CODIGOS.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        CODIGOS.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        CODIGOS.setToolTipText("");
        CODIGOS.setEnabled(false);
        CODIGOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CODIGOSActionPerformed(evt);
            }
        });
        Panel.add(CODIGOS, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 200, 20));

        NBanco.setBackground(new java.awt.Color(204, 204, 204));
        NBanco.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        NBanco.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONAR", "BANCO AGRARIO", "NEQUI", "BANCO AV VILLAS", "BANCO CAJA SOCIAL", "SCOTIABANK COLPATRIA", "BANCO COOPERATIVO COOPCETRAL", "BANCO DAVIVIENDA", "BANCO DE BOGOTA", "BANCO DE OCCIDENTE", "BANCO FALABELLA", "BANCO PICHINCHA S.A.", "BANCO BBVA COLOMBIA S.A.", "CITIBANK", "BANCO ITAU", "CONFIAR COOPERATIVA FINANCIERA", "DAVIPLATA", "BANCO DE LAS MICROFINANZAS BANCAMIA", "COLTEFINANCIERA", "CFA COOPERATIVA FINANCIERA", "BANCO CREDIFINANCIERA", "RAPPIPAY", "COTRAFA", "BANCO SANTANDER COLOMBIA", "BANCO SERFINANZA", "GIROS Y FINANZAS" }));
        NBanco.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        NBanco.setEnabled(false);
        org.jdesktop.swingx.autocomplete.AutoCompleteDecorator.decorate(NBanco);
        Panel.add(NBanco, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 260, 200, 30));

        Nombre_1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                Nombre_1FocusGained(evt);
            }
        });
        Nombre_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Nombre_1ActionPerformed(evt);
            }
        });
        Panel.add(Nombre_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 200, 30));

        Proveedor.setBackground(new java.awt.Color(10, 15, 42));
        Proveedor.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        Proveedor.setForeground(new java.awt.Color(255, 255, 255));
        Proveedor.setText("PROVEEDOR");
        Proveedor.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Proveedor.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ProveedorItemStateChanged(evt);
            }
        });
        Proveedor.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                ProveedorStateChanged(evt);
            }
        });
        Panel.add(Proveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 130, 110, 20));

        Empleado.setBackground(new java.awt.Color(10, 15, 42));
        Empleado.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        Empleado.setForeground(new java.awt.Color(255, 255, 255));
        Empleado.setText("EMPLEADO");
        Empleado.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Empleado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                EmpleadoItemStateChanged(evt);
            }
        });
        Empleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmpleadoActionPerformed(evt);
            }
        });
        Panel.add(Empleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 150, -1, 20));

        NDocumento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                NDocumentoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                NDocumentoFocusLost(evt);
            }
        });
        NDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NDocumentoActionPerformed(evt);
            }
        });
        NDocumento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                NDocumentoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                NDocumentoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                NDocumentoKeyTyped(evt);
            }
        });
        Panel.add(NDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 200, 30));

        sCliente.setBackground(new java.awt.Color(10, 15, 42));
        sCliente.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        sCliente.setForeground(new java.awt.Color(255, 255, 255));
        sCliente.setText("CLIENTE");
        sCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        sCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sClienteActionPerformed(evt);
            }
        });
        Panel.add(sCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 170, -1, 20));

        NCuenta.setEnabled(false);
        NCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NCuentaActionPerformed(evt);
            }
        });
        Panel.add(NCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 290, 200, 30));

        jPanel5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel5.setOpaque(false);
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel5MouseClicked(evt);
            }
        });
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/Usuario5.png"))); // NOI18N
        jLabel1.setToolTipText("");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel1.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel5.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 130));

        Panel.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 70, 150, 130));

        Email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmailActionPerformed(evt);
            }
        });
        Panel.add(Email, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 410, 30));

        btAdicionar.setBackground(new java.awt.Color(255, 255, 255));
        btAdicionar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/Agregar.png"))); // NOI18N
        btAdicionar.setText("ADICIONAR");
        btAdicionar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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
        Panel.add(btAdicionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 670, 150, 40));

        btModificar.setBackground(new java.awt.Color(255, 255, 255));
        btModificar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/Modificar.png"))); // NOI18N
        btModificar.setText("INFORME");
        btModificar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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
        Panel.add(btModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 640, 150, 50));

        btGuardar.setBackground(new java.awt.Color(255, 255, 255));
        btGuardar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/Guardar.png"))); // NOI18N
        btGuardar.setText("GUARDAR");
        btGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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
        Panel.add(btGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 630, 140, 50));

        btActualizar.setBackground(new java.awt.Color(255, 255, 255));
        btActualizar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/Actualizar.png"))); // NOI18N
        btActualizar.setText("ACTUALIZAR");
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
        Panel.add(btActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 639, 150, -1));

        btCancelar.setBackground(new java.awt.Color(255, 255, 255));
        btCancelar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/Cancelar.png"))); // NOI18N
        btCancelar.setText("CANCELAR");
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
        Panel.add(btCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 630, 150, 50));

        EstadoPro.setBackground(new java.awt.Color(204, 204, 204));
        EstadoPro.setEditable(true);
        EstadoPro.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        EstadoPro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Activo", "Inactivo", "Agotado" }));
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
        Panel.add(EstadoPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 80, 110, 30));

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("ESTADO");
        Panel.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 60, 70, -1));

        btModificar1.setBackground(new java.awt.Color(255, 255, 255));
        btModificar1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btModificar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/Buscar2.png"))); // NOI18N
        btModificar1.setText("BUSCAR");
        btModificar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btModificar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btModificar1ActionPerformed(evt);
            }
        });
        btModificar1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                btModificar1KeyReleased(evt);
            }
        });
        Panel.add(btModificar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 630, 140, 50));

        Cuenta.setBackground(new java.awt.Color(10, 15, 42));
        Cuenta.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        Cuenta.setForeground(new java.awt.Color(255, 255, 255));
        Cuenta.setText("CUENTA BANCARIA");
        Cuenta.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Cuenta.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CuentaItemStateChanged(evt);
            }
        });
        Cuenta.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                CuentaStateChanged(evt);
            }
        });
        Cuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CuentaActionPerformed(evt);
            }
        });
        Panel.add(Cuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 220, -1, 20));

        Ahorros.setText("AHORROS");
        Ahorros.setEnabled(false);
        Ahorros.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                AhorrosItemStateChanged(evt);
            }
        });
        Panel.add(Ahorros, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 240, -1, -1));

        Corriente.setText("CORRIENTE");
        Corriente.setEnabled(false);
        Corriente.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CorrienteItemStateChanged(evt);
            }
        });
        Panel.add(Corriente, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 240, -1, -1));

        Nombre_Completo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                Nombre_CompletoFocusGained(evt);
            }
        });
        Nombre_Completo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Nombre_CompletoActionPerformed(evt);
            }
        });
        Panel.add(Nombre_Completo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 410, 30));

        Apellido_1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                Apellido_1FocusGained(evt);
            }
        });
        Apellido_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Apellido_1ActionPerformed(evt);
            }
        });
        Panel.add(Apellido_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 200, 30));
        Panel.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 210, 200, 10));

        jPanel2.setBackground(new java.awt.Color(10, 15, 42));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "Datos Basicos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Light", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel54.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(255, 255, 255));
        jLabel54.setText("Codigo Sistema");
        jPanel2.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jLabel53.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel53.setText("Tipo Documento");
        jPanel2.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 270, -1, -1));

        jLabel55.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(255, 255, 255));
        jLabel55.setText("Tipo Documento");
        jPanel2.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, -1, -1));

        Apellido_2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                Apellido_2FocusGained(evt);
            }
        });
        Apellido_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Apellido_2ActionPerformed(evt);
            }
        });
        jPanel2.add(Apellido_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 150, 200, 30));

        Nombre_2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                Nombre_2FocusGained(evt);
            }
        });
        Nombre_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Nombre_2ActionPerformed(evt);
            }
        });
        jPanel2.add(Nombre_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, 200, 30));

        DVC.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                DVCFocusGained(evt);
            }
        });
        DVC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DVCActionPerformed(evt);
            }
        });
        jPanel2.add(DVC, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, 50, 30));

        TipoDocumento.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                TipoDocumentoItemStateChanged(evt);
            }
        });
        TipoDocumento.addHierarchyListener(new java.awt.event.HierarchyListener() {
            public void hierarchyChanged(java.awt.event.HierarchyEvent evt) {
                TipoDocumentoHierarchyChanged(evt);
            }
        });
        TipoDocumento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TipoDocumentoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                TipoDocumentoFocusLost(evt);
            }
        });
        TipoDocumento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TipoDocumentoMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TipoDocumentoMousePressed(evt);
            }
        });
        TipoDocumento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TipoDocumentoKeyPressed(evt);
            }
        });
        jPanel2.add(TipoDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, 120, 30));

        jLabel64.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/icons8_starfish_20px_2.png"))); // NOI18N
        jPanel2.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 80, 30, 30));

        jLabel58.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/icons8_astronaut_40px_1.png"))); // NOI18N
        jPanel2.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 30, 50, 50));

        Panel.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 430, 260));

        logo_claro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/icons8_rocket_take_off_50px.png"))); // NOI18N
        Panel.add(logo_claro, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, -1, -1));

        jLabel70.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/icons8_rocket_40px.png"))); // NOI18N
        Panel.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 50, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Panel, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void idProveedor7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idProveedor7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idProveedor7ActionPerformed

    private void TarjetaCreditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TarjetaCreditoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TarjetaCreditoActionPerformed

    private void InteresCorrienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InteresCorrienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InteresCorrienteActionPerformed

    private void DiasCorrienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DiasCorrienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DiasCorrienteActionPerformed

    private void jCheckBox8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox8ActionPerformed

    private void TarjetaPuntosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TarjetaPuntosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TarjetaPuntosActionPerformed

    private void TotalPuntosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TotalPuntosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TotalPuntosActionPerformed

    private void EstadoCivil1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EstadoCivil1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EstadoCivil1ActionPerformed

    private void DiasGraciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DiasGraciasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DiasGraciasActionPerformed

    private void DiasCreditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DiasCreditoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DiasCreditoActionPerformed

    private void CupoCreditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CupoCreditoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CupoCreditoActionPerformed

    private void FechaRadicacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FechaRadicacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FechaRadicacionActionPerformed

    private void BarrioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BarrioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BarrioActionPerformed

    private void CiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CiudadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CiudadActionPerformed

    private void DepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DepartamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DepartamentoActionPerformed

    private void LongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LongActionPerformed

    private void LatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LatActionPerformed

    private void CodPosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CodPosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CodPosActionPerformed

    private void NCuenta1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NCuenta1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NCuenta1ActionPerformed

    private void NCuenta2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NCuenta2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NCuenta2ActionPerformed

    private void NCuenta3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NCuenta3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NCuenta3ActionPerformed

    private void Proveedor1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_Proveedor1ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_Proveedor1ItemStateChanged

    private void Proveedor1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_Proveedor1StateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_Proveedor1StateChanged

    private void Empleado1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_Empleado1ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_Empleado1ItemStateChanged

    private void idEmpleadosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_idEmpleadosItemStateChanged
        if (idEmpleados.isSelected()) {

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_idEmpleadosItemStateChanged

    private void Empleado3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_Empleado3ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_Empleado3ItemStateChanged

    private void SalarioNominalItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_SalarioNominalItemStateChanged
        if (SalarioNominal.isSelected()==true) {
            ValorSalarioNominal.setEnabled(true);
        }else{
            ValorSalarioNominal.setEnabled(false);
            ValorSalarioNominal.setText("");
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_SalarioNominalItemStateChanged

    private void CheckVentasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CheckVentasItemStateChanged
        if (CheckVentas.isSelected()==true) {
            ValorVentas.setEnabled(true);
        }else{
            ValorVentas.setText("");
            ValorVentas.setEnabled(false);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_CheckVentasItemStateChanged

    private void ValorVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ValorVentasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ValorVentasActionPerformed

    private void ValorSalarioNominalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ValorSalarioNominalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ValorSalarioNominalActionPerformed

    private void RazonSocialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RazonSocialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RazonSocialActionPerformed

    private void DireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DireccionActionPerformed

    private void TelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TelefonoActionPerformed

    private void EMailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EMailsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EMailsActionPerformed

    private void AutReteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AutReteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AutReteActionPerformed

    private void ReIVAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReIVAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ReIVAActionPerformed

    private void CODIGOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CODIGOSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CODIGOSActionPerformed

    private void Nombre_1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Nombre_1FocusGained

        // TODO add your handling code here:
    }//GEN-LAST:event_Nombre_1FocusGained

    private void Nombre_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Nombre_1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Nombre_1ActionPerformed

    private void ProveedorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ProveedorItemStateChanged
        Boolean ac =Proveedor.isSelected();
        if ( ac) {
            ProveedoreAction(ac);
            MenuCPE.setSelectedIndex(2);
        }else{
            ProveedoreAction(ac);
            LimpiarPro();
        }
        //ProveedoreAction(true);
        //System.out.println("  action  ");      // TODO add your handling code here:
    }//GEN-LAST:event_ProveedorItemStateChanged

    private void ProveedorStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_ProveedorStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_ProveedorStateChanged

    private void EmpleadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_EmpleadoItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_EmpleadoItemStateChanged

    private void EmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmpleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EmpleadoActionPerformed

    private void NDocumentoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_NDocumentoFocusGained

        // TODO add your handling code here:
    }//GEN-LAST:event_NDocumentoFocusGained

    private void NDocumentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_NDocumentoFocusLost
        //        System.out.println(NDocumento.getText().length());

        if (NDocumento.getText().length()!=0) {
            UsuarioBs(NDocumento.getText(),"NDocumento","Este usuario ya fue creado en la BD,??Desea Modificarlo?",null);
            TipoDocumento.setFocusable(true);
        }

    }//GEN-LAST:event_NDocumentoFocusLost

    private void NDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NDocumentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NDocumentoActionPerformed

    private void NDocumentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NDocumentoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_NDocumentoKeyPressed

    private void NDocumentoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NDocumentoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_NDocumentoKeyReleased

    private void NDocumentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NDocumentoKeyTyped

    }//GEN-LAST:event_NDocumentoKeyTyped

    private void sClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sClienteActionPerformed

    private void NCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NCuentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NCuentaActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        try {
            //imagen =general.AgregarImagenBit(general.Exan(jPanel1)).toString();
            imagen= general.AgregarImagenBit(general.Exan(Panel));
            general.InsertarImagenLabel(imagen, jLabel1);
        }catch(Exception ex){

        }        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jPanel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseClicked
        try {
            //imagen =general.AgregarImagenBit(general.Exan(jPanel1)).toString();
            imagen= general.AgregarImagenBit(general.Exan(Panel));
            general.InsertarImagenLabel(imagen, jLabel1);
        }catch(Exception ex){

        }        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel5MouseClicked

    private void EmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EmailActionPerformed

    private void btAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAdicionarActionPerformed

        //PanelProveedor.setEnabled(false);
        Adicionar();
    }//GEN-LAST:event_btAdicionarActionPerformed

    private void btAdicionarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btAdicionarKeyReleased
        Teclas(evt);         // TODO add your handling code here:
    }//GEN-LAST:event_btAdicionarKeyReleased

    private void btModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btModificarActionPerformed
        Informe();
    }//GEN-LAST:event_btModificarActionPerformed

    private void btModificarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btModificarKeyReleased
        Teclas(evt);             // TODO add your handling code here:
    }//GEN-LAST:event_btModificarKeyReleased

    private void btGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGuardarActionPerformed
        Guardar();
    }//GEN-LAST:event_btGuardarActionPerformed

    private void btGuardarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btGuardarKeyReleased
        Teclas(evt);        // TODO add your handling code here:
    }//GEN-LAST:event_btGuardarKeyReleased

    private void btActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btActualizarActionPerformed
        Actualizar();
    }//GEN-LAST:event_btActualizarActionPerformed

    private void btActualizarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btActualizarKeyReleased
        Teclas(evt);         // TODO add your handling code here:
    }//GEN-LAST:event_btActualizarKeyReleased

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed

        Cancelar();

    }//GEN-LAST:event_btCancelarActionPerformed

    private void btCancelarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btCancelarKeyReleased
        Teclas(evt);          // TODO add your handling code here:
    }//GEN-LAST:event_btCancelarKeyReleased

    private void EstadoProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EstadoProActionPerformed

    }//GEN-LAST:event_EstadoProActionPerformed

    private void EstadoProKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_EstadoProKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_EstadoProKeyReleased

    private void btModificar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btModificar1ActionPerformed
        Buscar();
        // TODO add your handling code here:
    }//GEN-LAST:event_btModificar1ActionPerformed

    private void btModificar1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btModificar1KeyReleased
        Teclas(evt);        // TODO add your handling code here:
    }//GEN-LAST:event_btModificar1KeyReleased

    private void CuentaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CuentaItemStateChanged

        if (Cuenta.isSelected()) {
            Ahorros.setEnabled(true);
            Corriente.setEnabled(true);
            NBanco.setEnabled(true);
            NCuenta.setEnabled(true);
        }else{
            NCuenta.setEnabled(false);
            NCuenta.setText("");
            NBanco.setEnabled(false);
            NBanco.setSelectedIndex(0);

            Ahorros.setSelected(false);
            Corriente.setSelected(false);

            Ahorros.setEnabled(false);
            Corriente.setEnabled(false);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_CuentaItemStateChanged

    private void CuentaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_CuentaStateChanged

        // TODO add your handling code here:
    }//GEN-LAST:event_CuentaStateChanged

    private void CuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CuentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CuentaActionPerformed

    private void AhorrosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_AhorrosItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_AhorrosItemStateChanged

    private void CorrienteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CorrienteItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_CorrienteItemStateChanged

    private void Nombre_CompletoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Nombre_CompletoFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_Nombre_CompletoFocusGained

    private void Nombre_CompletoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Nombre_CompletoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Nombre_CompletoActionPerformed

    private void Apellido_1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Apellido_1FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_Apellido_1FocusGained

    private void Apellido_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Apellido_1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Apellido_1ActionPerformed

    private void Apellido_2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Apellido_2FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_Apellido_2FocusGained

    private void Apellido_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Apellido_2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Apellido_2ActionPerformed

    private void Nombre_2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Nombre_2FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_Nombre_2FocusGained

    private void Nombre_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Nombre_2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Nombre_2ActionPerformed

    private void DVCFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_DVCFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_DVCFocusGained

    private void DVCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DVCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DVCActionPerformed

    private void TipoDocumentoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_TipoDocumentoItemStateChanged
        if (TipoDocumento.getSelectedIndex()==2|| TipoDocumento.getSelectedItem().toString()=="NIT") {
            DVC.setVisible(true);
        }else{DVC.setVisible(false);}
        // TODO add your handling code here:
    }//GEN-LAST:event_TipoDocumentoItemStateChanged

    private void TipoDocumentoHierarchyChanged(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_TipoDocumentoHierarchyChanged

        // TODO add your handling code here:
    }//GEN-LAST:event_TipoDocumentoHierarchyChanged

    private void TipoDocumentoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TipoDocumentoFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_TipoDocumentoFocusGained

    private void TipoDocumentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TipoDocumentoFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_TipoDocumentoFocusLost

    private void TipoDocumentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TipoDocumentoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TipoDocumentoMouseClicked

    private void TipoDocumentoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TipoDocumentoMousePressed

        // TODO add your handling code here:
    }//GEN-LAST:event_TipoDocumentoMousePressed

    private void TipoDocumentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TipoDocumentoKeyPressed

        // TODO add your handling code here:
    }//GEN-LAST:event_TipoDocumentoKeyPressed
     private JTextField TextEm [];
    private JComboBox ComboboxUB[];
    private JTextField TextUB[];
    private JTextField TextProveedor[];
    private int XY []={0,0};
    private byte[] imagen =null;
     Boolean CheakBanco ;
    Boolean ChecKAhorro ;
    Boolean ChecKCorriente;
    String RazonSocialNom;
    String DirrecionPro;
    String Tel ;
    String EmailFactura;
    boolean ResponsableIVA ;
    boolean AutoRetenedor;
    Boolean ChecKPro ;
    Boolean ChecKCli ;
    Boolean ChecKEm;
    String TipoDoc;
    String NumeroDocumento;
    String NombreCompleto;
    String Emailusuario;
    String NombreBanco ;
    String NCuentaBancaria ;
    String Estado ;
    String id;
    BuscarUsuario usuario= new BuscarUsuario( this);
    public MySQL_Query Querys;
    private boolean inic =false;
    private  GENERAL_CLASS general = new GENERAL_CLASS() ;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton Ahorros;
    private javax.swing.JTextField Apellido_1;
    private javax.swing.JTextField Apellido_2;
    private javax.swing.JCheckBox AutRete;
    private javax.swing.JTextField Barrio;
    private javax.swing.JTextField CODIGOS;
    private javax.swing.JCheckBox CheckVentas;
    private javax.swing.JTextField Ciudad;
    private javax.swing.JPanel ClienteBan;
    private javax.swing.JPanel ClienteDo;
    private javax.swing.JTextField CodPos;
    private javax.swing.JRadioButton Corriente;
    private javax.swing.JCheckBox Cuenta;
    private javax.swing.JTextField CupoCredito;
    private javax.swing.JTextField DVC;
    private javax.swing.JTextField Departamento;
    private javax.swing.JTextField DiasCorriente;
    private javax.swing.JTextField DiasCredito;
    private javax.swing.JTextField DiasGracias;
    private javax.swing.JTextField Direccion;
    private javax.swing.JTextField EMails;
    private javax.swing.JTextField Email;
    private javax.swing.JCheckBox Empleado;
    private javax.swing.JCheckBox Empleado1;
    private javax.swing.JCheckBox Empleado3;
    private javax.swing.JTextField EstadoCivil1;
    private javax.swing.JComboBox<String> EstadoPro;
    private org.jdatepicker.JDatePicker FechaRadicacion;
    private javax.swing.JTextField InteresCorriente;
    private javax.swing.JTextField Lat;
    private javax.swing.JTextField Long;
    private javax.swing.JTabbedPane MenuCPE;
    private javax.swing.JComboBox<String> NBanco;
    private javax.swing.JTextField NCuenta;
    private javax.swing.JTextField NCuenta1;
    private javax.swing.JTextField NCuenta2;
    private javax.swing.JTextField NCuenta3;
    private javax.swing.JTextField NDocumento;
    private javax.swing.JTextField Nombre_1;
    private javax.swing.JTextField Nombre_2;
    private javax.swing.JTextField Nombre_Completo;
    public javax.swing.JPanel Panel;
    private javax.swing.JCheckBox Proveedor;
    private javax.swing.JCheckBox Proveedor1;
    private javax.swing.JPanel ProveedorPanel;
    private javax.swing.JTextField RazonSocial;
    private javax.swing.JCheckBox ReIVA;
    private javax.swing.JCheckBox SalarioNominal;
    private javax.swing.JTextField TarjetaCredito;
    private javax.swing.JTextField TarjetaPuntos;
    private javax.swing.JTextField Telefono;
    private javax.swing.JComboBox<String> TipoDocumento;
    private javax.swing.JTextField TotalPuntos;
    private javax.swing.JTextField ValorSalarioNominal;
    private javax.swing.JTextField ValorVentas;
    private javax.swing.JButton btActualizar;
    private javax.swing.JButton btAdicionar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btGuardar;
    private javax.swing.JButton btModificar;
    private javax.swing.JButton btModificar1;
    private javax.swing.JCheckBox idEmpleados;
    private javax.swing.JComboBox<String> idProveedor7;
    private javax.swing.JButton jButton20;
    private javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTabbedPane jTabbedPane5;
    private javax.swing.JTabbedPane jTabbedPane6;
    private javax.swing.JLabel logo_claro;
    private javax.swing.JCheckBox sCliente;
    // End of variables declaration//GEN-END:variables
}
