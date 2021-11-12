/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CLASS;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.*;



/**
 *
 * @author JAVIER
 */
public class CONEXION_MySQL  {
    
    public CONEXION_MySQL(){
            LeerXML();
        }
    //Colocar los datos de la Conexion en un JTextField 
    public void SetLabel(JTextField usuarios,JTextField Pass,JTextField Host,JTextField NomBD){
            LeerXML();
            usuarios.setText(usuario);
            Pass.setText(contraseña);
            Host.setText(DirecionBD);
            NomBD.setText(NombreBD);
    }
    //Llamar los datos del XML para la Conexion BD
    private void LeerXML(){
         try  {
            File archivoConn = new File(LocalFichero);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder bulder = dbFactory.newDocumentBuilder();
            Document documentoXML = bulder.parse(archivoConn);
            documentoXML.getDocumentElement().normalize();
            NodeList us =  documentoXML.getElementsByTagName("ConexionMySQL");
             for (int i = 0; i < us.getLength(); i++) {
                 Node use = us.item(i);
                 if (use.getNodeType() == Node.ELEMENT_NODE) {
                    Element ele = (Element) use;
               
                    NombreBD=ele.getElementsByTagName("NameBD").item(0).getTextContent();
                    DirecionBD =ele.getElementsByTagName("NameHost").item(0).getTextContent();
                    contraseña =ele.getElementsByTagName("Password").item(0).getTextContent();
                    usuario=ele.getElementsByTagName("NameUser").item(0).getTextContent();
                 }
             }
             }catch (Exception ex ){
              JOptionPane.showMessageDialog(null, "Error "+ex.getMessage());  
         }
     }
    //Agregar Datos Al XML para la Conexion a BD
    public void EscribirXML(String Usuario ,String Contraseña ,String NameBD,String IP){
        
         PrintWriter pw = null;
         try{
            FileWriter fichero = new FileWriter(LocalFichero);
            pw = new PrintWriter(fichero);
            pw.write("");
            pw.print("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
            "<!--\n" +
            "To change this license header, choose License Headers in Project Properties.\n" +
            "To change this template file, choose Tools |the properties is of @InputSystem\n" +
            "-->");
            pw.print("<Document>");
             pw.print("<ConexionMySQL>");
                pw.print("<NameBD >"+NameBD+" </NameBD>");
                pw.print("<NameHost>"+ IP+"</NameHost >");
                pw.print("<Password>"+Contraseña+"</Password>");
                pw.print("<NameUser>"+ Usuario+"</NameUser>");
             pw.print("</ConexionMySQL>");
            pw.print("</Document>");
         pw.close();
          
         }
         catch(Exception ex){
          JOptionPane.showConfirmDialog(null, "Error "+ex.getMessage());  
         }
     }
    //Crear Conexcion a MySQL
    public Connection Conexion(){
    LeerXML();
    try{
        con = DriverManager.getConnection("jdbc:mysql://"+DirecionBD+"/"+NombreBD,usuario,contraseña);
        //JOptionPane.showMessageDialog(null, "Conexion Exitosa");
    }
   catch(SQLException e ){
        JOptionPane.showMessageDialog(null, "Error "+e.getMessage());
    }
        return con;
    }
    //Ingresar Actualizar o Eliminar en la MySQLBD
   public void Ingresar (String x) throws SQLException{
        
            Statement smt =  con.createStatement();
            smt.executeUpdate(x);

    }
    //Buscar En MySQL
    public ResultSet Buscar (String x) throws SQLException{
        try { s = con.createStatement();
        rs = s.executeQuery (x);
       // JOptionPane.showMessageDialog(null, "Listo");
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error "+ex.getMessage());  }
        return rs;
   }
  
    
    //Declaracion de Variables
    private  DefaultTableModel  modelo ;
    private String  LocalFichero ="src\\CLASS\\ConfigConnectorMySQL.xml";
    private String usuario;
    private String contraseña;
    private String NombreBD;
    private String DirecionBD;
    private ResultSet rs=null;
    private Statement s;
    public Connection con = null;
}
