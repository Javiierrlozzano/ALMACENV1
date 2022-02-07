/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CLASS;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
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
    public void SetLabel(JTextField usuarios,JTextField Pass,JTextField Host,JTextField NomBD,JTextField Puerto){
            LeerXML();
            usuarios.setText(usuario);
            Pass.setText(contraseña);
            Host.setText(DirecionBD);
            NomBD.setText(NombreBD);
            Puerto.setText(Puert);
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
                    Puert = ele.getElementsByTagName("Port").item(0).getTextContent();
                 }
             }
             }catch (Exception ex ){
              JOptionPane.showMessageDialog(null, "Error Leer XML"+ex.getMessage());  
         }
     }
    //Agregar Datos Al XML para la Conexion a BD
    public void EscribirXML(String Usuario ,String Contraseña ,String NameBD,String IP,String Puertos){
        
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
                pw.print("<Port>"+ Puertos+"</Port>");
             pw.print("</ConexionMySQL>");
            pw.print("</Document>");
         pw.close();
          
         }
         catch(Exception ex){
          JOptionPane.showConfirmDialog(null, "Error Crear XML"+ex.getMessage());  
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
    
    //
  
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
    
public void POSTAPI(String URL, String jsonBodyStr) throws IOException  {
  URL url = new URL("http://"+DirecionBD+":"+Puert+URL);
  HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
  httpURLConnection.setDoOutput(true);
  httpURLConnection.setRequestMethod("POST");
  httpURLConnection.setRequestProperty("Content-Type", "application/json");
  
  try (OutputStream outputStream = httpURLConnection.getOutputStream()) { 
    outputStream.write(jsonBodyStr.getBytes());
    outputStream.flush();
  }catch(Exception ex){
      System.out.println("Error POST : " +ex.getMessage());
  }
  if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
    try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()))) {
      String line;
       
      while ((line = bufferedReader.readLine()) != null) {
        // ... do something with line
      }
    }
  } else {
     
      System.out.println("Correcto" + httpURLConnection.getResponseCode());
    // ... do something with unsuccessful response
  }
}
 
  
    // ... do something with unsuccessful response
  
   public String GETAPI (String URL){
               String line ="";
               try {
                     URL url = new URL("http://"+DirecionBD+":"+Puert+URL);
                     HttpURLConnection c_api = (HttpURLConnection) url.openConnection();
                     c_api.setRequestMethod("GET");
                    // c_api.addRequestProperty(URL, line);
                     c_api.setRequestProperty("Accept", "application/json");
                     
                     if (c_api.getResponseCode() ==200) {
                            InputStreamReader entrada =  new InputStreamReader(c_api.getInputStream());
                            BufferedReader lectura = new BufferedReader(entrada);
                            line = lectura.readLine();
                          //  c_api.disconnect();
                            return line;
                    }else{
                        System.out.println("No se pudo conectar la api : " +c_api.getResponseCode());
                    }
            } catch (Exception e) {
                System.out.println("error HTTPs "+ e.getMessage());
            }
       return line;
    }
    //Declaracion de Variables
    private  DefaultTableModel  modelo ;
    private String  LocalFichero ="src\\CLASS\\ConfigConnectorMySQL.xml";
   
    private String usuario;
    private String contraseña;
    private String NombreBD;
    private ResultSet rs=null;
    private Statement s;
    public Connection con = null;
    //API 
     //API
    public  String Puert;
    public  String DirecionBD;
  
}
