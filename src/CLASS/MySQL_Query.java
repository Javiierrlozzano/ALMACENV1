/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CLASS;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;


/**
 *
 * @author JAVIER
 */
//Generador Querys de Busqueda y modificacion de datos 
public class MySQL_Query extends CONEXION_MySQL  {
    public String  ServidorAPI= "caja02";
    public String PuertoAPI ="8080";
    
    
    
    
    private JLabel  TextCarga;
    
     // Abrir Conexion y heredar de la clase Conexion, se realiza para llamar los datos de MySQL
    public MySQL_Query(JLabel TextCarga1 ){
        Conexion();
        TextCarga= TextCarga1;
        TextCarga.setText("Abriendo Conexion...");
    }
    public void InsertarBodegas(String Estado,String Descip,String DrBg,String Ciudad,String Suc){
     
      String Empresa = null;
        try {
            ResultSet empresa = Buscar(" SELECT   `idEmpresa` FROM `almacen.pos`.`empresa` WHERE  NombreEmpresa ='"+Suc+"'  LIMIT 1000 ;");
            while(empresa.next()){
                Empresa = empresa.getString(1);
            };
            /* 
              String idEstados = null ; 
               ResultSet  resultado  =Buscar("SELECT idEstado   FROM estados  WHERE  NombreEstado = '"+Estado+"' LIMIT 1");
                while (resultado.next()){
                   idEstados =  resultado.getString(1);}
            */
         
                   Ingresar("INSERT INTO `almacen.pos`.`bodegas` "
                           + "(`DescripcionBodega`, `DireccionBodega`, `Ciudad`, `Sucursal`, `Estado`) "
                           + "VALUES ('"+Descip+"', '"+DrBg+"', '"+Ciudad+"', '"+Empresa+"', '"+Estado+"');");
            }catch(Exception ex){
                System.out.println( ex.getMessage());
        JOptionPane.showMessageDialog(null,"Error" + ex.getMessage());
        }
    }
    
    public void InsertarCosto(String id,String  ImpuestoQuerys ,String  ValorImpuestoQuerys ,String  CostoBaseQuerys ,String  UtilidaProQuerys ,String  UtilidadValorQuerys , String  CantUnitariaQuerys ,String  CantidadPaqueteQuerys ,String  CantidadTotalQuerys ,String  CostoCantidadTotalQuerys ,String  PrecioPublicoQuerys ,String  ComisionProQuerys , String  ComisionValorQuerys ,String  ValorGanarQuerys ,String  ValorFleteQuerys ,String  PesoKGQuerys ,String ProveedorQuerys){
    String Impuestos = null ;
    String Proveedor = null;
     try{
         try{if (ImpuestoQuerys !="Seleccionar") {
            ResultSet Impus = Buscar(" SELECT idImpuestos FROM `almacen.pos`.`impuestos` WHERE   Descripcion ='"+ImpuestoQuerys+"'  LIMIT 1;");
            while(Impus.next()){
                Impuestos = Impus.getString(1);
            }  
             }else{Impuestos = "";}
 
            ResultSet Proveedors = Buscar("SELECT proveedors.idProveedor FROM `almacen.pos`.`proveedor` \n" +
                "AS proveedors INNER JOIN  `almacen.pos`.`usuariobasico`\n" +
                "AS Id	ON proveedors.UsuarioBasico_IdUsuario = Id.IdUsuario \n" +
                "WHERE id.NDocumento = '"+ProveedorQuerys+"'\n" +
                "LIMIT 1;");
            while(Proveedors.next()){
                Proveedor = Proveedors.getString(1);
            }
         
         }catch(Exception ex){}

    String Valor[] ={id,Impuestos ,ValorImpuestoQuerys ,CostoBaseQuerys ,
                        UtilidaProQuerys ,UtilidadValorQuerys , CantUnitariaQuerys ,
                        CantidadPaqueteQuerys ,CantidadTotalQuerys ,CostoCantidadTotalQuerys ,
                        PrecioPublicoQuerys ,ComisionProQuerys , ComisionValorQuerys ,ValorGanarQuerys ,
                        ValorFleteQuerys , PesoKGQuerys ,Proveedor};
    String sql ="INSERT INTO `almacen.pos`.`preciosproducto` (`Producto`, `Impuesto`, `ValorImpuesto`, `CostoBase`, `UtilidaPro`, `UtilidadValor`, `CantUnitaria`, `CantidadPaquete`, `CantidadTotal`, `CostoCantidadTotal`, `PrecioPublico`, `ComisionPro`, `ComisionValor`, `ValorGanar`, `ValorFlete`, `PesoKG`, `Proveedor`) VALUES\n" +
"     ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);" ;
    PreparedStatement ps = con.prepareStatement(sql);
     for (int i = 0; i < Valor.length   ; i++) {
       
         if (Valor[i].length() ==0 || Valor[i] == null) {
             Valor[i] =null;
         }
         ps.setString(i+1,Valor[i]);
         System.out.println(Valor[i]);
     }
    ps.execute();

 }catch(Exception ex){ 
     JOptionPane.showMessageDialog(null,"Error al ingresar Ajuste Precio" +ex.getMessage());}

}
    //Buscar Impuestos Producto
    public  ResultSet Impuestos(String Impuesto){
        ResultSet resultado = null;
        try{
            /* 
             resultado = Buscar("SELECT im.`Valor%Impuesto`  FROM `almacen.pos`.`impuestos` AS im\n" +
            "INNER JOIN `almacen.pos`.`estados` as es \n" +
            "ON es.idEstado = im.Estado  WHERE Descripcion ='"+Impuesto+"' AND es.NombreEstado  ='Activo' LIMIT 1;");
            */
            resultado = Buscar("SELECT `Valor%Impuesto`  FROM `almacen.pos`.`impuestos` " +
            " WHERE Descripcion ='"+Impuesto+"' AND Estado  ='Activo' LIMIT 1;");
        return resultado ;
        }catch(Exception ex){
        
        JOptionPane.showMessageDialog(null,"Error impuestos "+ex.getMessage());
        }
        return resultado ;

    }
  
    //Buscar Proveedor Nombre y Nit 
    public ResultSet BuscarUsuarioNit(){
         ResultSet resultado = null ;
         try{
 
         resultado = Buscar ("SELECT us.NombreUsuari , us.NDocumento FROM `almacen.pos`.`proveedor`  AS pro   \n" +
        "INNER JOIN `almacen.pos`.`usuariobasico` AS us ON us.IdUsuario = pro.UsuarioBasico_IdUsuario \n" +
        "WHERE  us.Estado ='Activo' ORDER BY `NombreUsuari` DESC, `UsuarioBasico_IdUsuario` ASC LIMIT 1000;");
         }catch(Exception ex ){}
        return resultado;
    }
    //Inicio Bodega
    
    public ResultSet BodegasInicio(){
        ResultSet resultado ;
        
        try {
            /*
               resultado  =Buscar("SELECT idBodegas , DescripcionBodega,DireccionBodega, Ciudad,em.NombreEmpresa  ,es.NombreEstado\n" +
" FROM `almacen.pos`.`bodegas`  \n" +
" INNER JOIN `almacen.pos`.`estados` AS es ON  Estado = es.IdEstado \n" +
" INNER JOIN `almacen.pos`.`empresa` AS em ON  Sucursal =em.idEmpresa   LIMIT 1000");
            */
            resultado  =Buscar("SELECT idBodegas , DescripcionBodega,DireccionBodega, Ciudad,em.NombreEmpresa  ,Estado\n" +
" FROM `almacen.pos`.`bodegas`  \n" +
" INNER JOIN `almacen.pos`.`empresa` AS em ON  Sucursal =em.idEmpresa   LIMIT 1000");
             TextCarga.setText("Iniciando Bodegas...");
            return resultado;
        }catch(Exception ex){
        JOptionPane.showMessageDialog(null,"Error" + ex.getMessage());
        }
        return resultado = null;
    }
    public void UpdateBodega(String Estado,String Descripcions,String DireccionBodega,String Ciudad,String Sucursals,String Id){
         String Sucursales= null;
        try {
            /*
             ResultSet  resultado  =Buscar("SELECT idEstado   FROM estados  WHERE  NombreEstado = '"+Estado+"' LIMIT 1");
                while (resultado.next()){
                   idEstados =  resultado.getString(1);
                }
            */
            ResultSet  Sucursal  =Buscar("SELECT  `idEmpresa`FROM `almacen.pos`.`empresa` WHERE `NombreEmpresa` ='"+Sucursals+"';");
                while (Sucursal.next()){
                   Sucursales =  Sucursal.getString(1);
                }
            Ingresar("UPDATE `almacen.pos`.`bodegas`"
                    + "SET `DescripcionBodega`='"+Descripcions+"', `DireccionBodega`='"+DireccionBodega+"', "
                    + "`Ciudad`='"+Ciudad+"', `Sucursal`='"+Sucursales+"' ,`Estado`='"+Estado+"'"
                    + " WHERE  `idBodegas`="+Id+";");
            }catch(Exception ex){
        JOptionPane.showMessageDialog(null,"Error" + ex.getMessage());
        }
    }
    
    
    public ResultSet IniImpuesto(){
            ResultSet resultado ;
        try {
            resultado  =Buscar("SELECT `idImpuestos`, `Descripcion`, `Valor%Impuesto`, Estado FROM `almacen.pos`.`impuestos`");
            
           TextCarga.setText("Iniciando Unidad de Impuesto....");
            return resultado;
        }catch(Exception ex){
        JOptionPane.showMessageDialog(null,"Error" + ex.getMessage());
        }
        return resultado = null;
    }
    //Parametros Unidad
    //iniciar datos

    //ingresar datos 
    public void InsertUnidad(String Estado,String Valor,String Descripcion){
             
        try {
            /*  ResultSet  resultado  =Buscar("SELECT idEstado   FROM estados  WHERE  NombreEstado = '"+Estado+"' LIMIT 1");
                while (resultado.next()){
                   idEstados =  resultado.getString(1);}*/
          
            Ingresar("INSERT INTO unidadmedida(Descripcion, Valor, Estado) VALUES ('"+Descripcion+"', '"+Valor+"', '"+Estado+"');");
            }catch(Exception ex){
                System.out.println( ex.getMessage());
        JOptionPane.showMessageDialog(null,"Error" + ex.getMessage());
        }
    }
       public void InsertarImpuesto(String Estado,String Valor,String Descripcion){
            
        try {
            /*  ResultSet  resultado  =Buscar("SELECT idEstado   FROM estados  WHERE  NombreEstado = '"+Estado+"' LIMIT 1");
                while (resultado.next()){
                   idEstados =  resultado.getString(1);}*/
          
            Ingresar("INSERT INTO `almacen.pos`.`impuestos` (`Descripcion`, `Valor%Impuesto`, `Estado`) VALUES  ('"+Descripcion+"', '"+Valor+"', '"+Estado+"');");
            }catch(Exception ex){
                System.out.println( ex.getMessage());
        JOptionPane.showMessageDialog(null,"Error" + ex.getMessage());
        }
    }
        public void UpdateImpuestos(String id,String Estado,String Valor,String Descripcion){
     String idEstados = null ;    
        try {
          
            Ingresar("UPDATE `almacen.pos`.`impuestos` SET " +
                        "`Descripcion`='"+Descripcion+"' ," +
                        "`Valor%Impuesto` = '"+Valor+"' ," +
                        "Estado = '"+Estado+"' " +
                        "WHERE `idImpuestos`="+id+";");
            }catch(Exception ex){
        JOptionPane.showMessageDialog(null,"Error" + ex.getMessage());
        }}   


    //Inicios Agregar Producto
    //Insertar codigos;
    public void InsertarCodigos(String codig ,String Cantidad,String Valor ,String id){
        try {
        Ingresar("INSERT INTO `almacen.pos`.`codigosalternosproducto` "
                + "( `Codigo`, `Cantidad`, `Select`, `producto_idProducto`) "
                + "VALUES ( '"+codig+"', '"+Cantidad+"', '"+Valor+"', '"+id+"');");
        }catch(Exception ex ){
        JOptionPane.showMessageDialog(null, "Error ingresar Sub Codigos "+ ex.getMessage());
        }
    }
    public ResultSet InicioDescuento(){
         ResultSet  resultado= null;
         try{
             resultado = Buscar("SELECT IdDescuento FROM  `almacen.pos`.`descuentos`  ORDER by IdDescuento DESC  LIMIT 1");
         }catch(Exception ex ){}
    return resultado;
    }
    //Buscar SubCodes
    public ResultSet BuscarSubCodeInicio(String codigo){
    ResultSet resultado ;
    try {
        resultado = Buscar("SELECT ProductosBD.ProductoDescripcionCorta  \n" +
"FROM `almacen.pos`.`producto` as ProductosBD LEFT JOIN  \n" +
"`almacen.pos`.`codigosalternosproducto` AS SubCods \n" +
"ON  SubCods.producto_idProducto = ProductosBD.idProducto\n" +
"WHERE ProductosBD.idProducto ='"+codigo+"' OR  SubCods.Codigo='"+codigo+"' LIMIT 1");
       return resultado;
    }catch(Exception ex){
        JOptionPane.showMessageDialog(null,"Error sub codes "+ ex.getMessage());
    }
    return resultado=null;
    }
    public ResultSet InicioProductoAgregar(){
    ResultSet resultado = null;
            try{
                resultado = Buscar("SELECT idProducto\n" +
                "FROM `almacen.pos`.`producto` \n" +
                "ORDER by idProducto DESC\n" +
                "LIMIT 1");}
            catch(Exception ex)
    {JOptionPane.showMessageDialog(null, ex.getMessage());}
    return resultado;
    }
    //Se inserta descripciones basicas de Productos
    public void AgregarDescripcionProductos(
     String id,String ProductoDescripcionLarga  ,String ProductoDescripcionCorta  ,String ExistenciaBG   ,String StockMaX  ,String StockMin  ,String
     VenderNegativos  ,String VenderPeso,String Pertenece_terceros  ,String VenderRemision  ,String NumeroSerie  ,String Color  ,String
     DescontarInventario  ,String ColocarDecimales  ,String Talla  ,String Largo  ,String Ancho,String
     Alto   ,String Familia1  ,String Familia2  ,String Familia3  ,String UndiadMedida ,String Estados ){

        try{
         String Fami1="SELECT  idFamilia1 FROM `almacen.pos`.`familia1` WHERE Descripcion ='"+Familia1+"' LIMIT 1;";
         String Fami2 ="SELECT idFamilia2 FROM `almacen.pos`.`familia2` WHERE Descripcion ='"+Familia2+"' LIMIT 1;";
         String Fami3="SELECT  idFamilia1 FROM `almacen.pos`.`familia3` WHERE Descripcion ='"+Familia3+"' LIMIT 1;";
         String Estado =Estados;
         String UnidadMedida ="SELECT  idUnidadMedida FROM `almacen.pos`.`unidadmedida` WHERE  `Descripcion` ='"+UndiadMedida+"' LIMIT 1;";
         String Querys []={Fami1,Fami2,Fami3,UnidadMedida,Estado};
   
        String Valor[]={id,ProductoDescripcionLarga  ,ProductoDescripcionCorta,ExistenciaBG,StockMaX,StockMin  , 
            VenderNegativos,VenderPeso  ,Pertenece_terceros,  VenderRemision,NumeroSerie,Color, 
            DescontarInventario,ColocarDecimales  ,Talla,Largo,Ancho, 
            Alto,Familia1,Familia2,Familia3,UndiadMedida,Estados};
        
            for (int i = 0; i < Querys.length; i++) {
                try {
                ResultSet busqueda = Buscar(Querys[i]);
                while(busqueda.next()){
                    Valor[i+18] =busqueda.getString(1);
                }
                }catch(Exception ex ){}
            }
            for (int i = 0; i < Valor.length; i++) {
              
            }
            String sql ="INSERT INTO `almacen.pos`.`producto` (\n" +
                "    `idProducto`,`ProductoDescripcionLarga`, `ProductoDescripcionCorta`, `ExistenciaBG`, \n" +
                "     `StockMaX`, `StockMin`, \n" +
                "    `VenderNegativos`, `VenderPeso`, `Pertenece A terceros`,`VenderRemision`, `NumeroSerie`, `Color`, \n" +
                "    `DescontarInventario`, `ColocarDecimales`, `Talla`, `Largo`, `Ancho`, \n" +
                "    `Alto`,`Familia1`, `Familia2`, `Familia3`, `UndiadMedida`,`Estados`) VALUES \n" +
                "    (?,?, ?, ?, ?,?, ?, ?, ?, ?, ?,?, ?, \n" +
                "    ?, ?, ?, ?, ?, ?, ?,?, ?, ?);" ;
        PreparedStatement  ps = con.prepareStatement(sql);
            for (int i = 0; i < 23; i++) {
    
                if (Valor[i].length() ==0) {
                    Valor[i] =null;
                }
                ps.setString(i+1,Valor[i]);
              
            }
  ps.execute();
   
       }catch(Exception ex){
            System.out.println(ex.getMessage());
        
        }
        
    }
    //Familia3 
    public ResultSet Familia3(){
      ResultSet resultado ;
        try {
            resultado  =Buscar("SELECT Descripcion FROM `almacen.pos`.`familia1`  LIMIT 1000");
             TextCarga.setText("Iniciando Unidad de Familia 3 ....");
            return resultado;
        }catch(Exception ex){
        JOptionPane.showMessageDialog(null,"Error" + ex.getMessage());
        }
        return resultado = null;
    } 
    //Familia2
      public ResultSet Familia2(){
      ResultSet resultado ;
        try {
            resultado  =Buscar("SELECT Descripcion FROM `almacen.pos`.`familia2` LIMIT 1000;");
             TextCarga.setText("Iniciando Unidad de Familia 2 ....");
            return resultado;
            
        }catch(Exception ex){
        JOptionPane.showMessageDialog(null,"Error" + ex.getMessage());
        }
        return resultado = null;
    } 
    //Iniciar datos
    public ResultSet InicioFamilia3(){
        ResultSet resultado ;
        try {
            resultado  =Buscar("SELECT * FROM `almacen.pos`.`familia1` LIMIT 1000;");
                         TextCarga.setText("Iniciando  Familia 3 ....");
            return resultado;
        }catch(Exception ex){
        JOptionPane.showMessageDialog(null,"Error" + ex.getMessage());
        }
        return resultado = null;
    }
    //Insertar datos
    public void InsertarFamilia3(String Descripcion,String Estado){
      String idEstados = null ;    
        try {
         
                   Ingresar("INSERT INTO `almacen.pos`.`familia1` (`Descripcion`, `Estado`) "
                           + "VALUES "
                           + "('"+Descripcion+"', '"+Estado+"');");
            }catch(Exception ex){
                System.out.println( ex.getMessage());
        JOptionPane.showMessageDialog(null,"Error" + ex.getMessage());
        }
   }
    //Actualizar Datos
    public void UpdateFamilia3(String id,String Descripcion, String Estado){

        try {
            
            Ingresar("UPDATE `almacen.pos`.`familia1` SET `Descripcion`='"+Descripcion+"', `Estado`='"+Estado+"' WHERE  `idFamilia1`="+id+";");
            }catch(Exception ex){
        System.out.println( ex.getMessage());
        JOptionPane.showMessageDialog(null,"Error" + ex.getMessage());
        }
   }
    //Familia2
    //Iniciar datos
    public  ResultSet InicioFamilia2(){
       ResultSet resultado ;
        try {
            resultado  =Buscar("SELECT fami2.idFamilia2, \n" +
                                "fami2.Descripcion,fami2.Estado,\n" +
                                "fami1.Descripcion\n" +
                                "FROM familia2\n" +
                                "AS fami2 INNER JOIN familia1\n" +
                                "AS fami1 ON fami1.idFamilia1 =fami2.Familia1_Familia2\n" +
                                "LIMIT 1000;");
             TextCarga.setText("Iniciando Unidad de Familia 2 ....");
            return resultado;
        }catch(Exception ex){
        JOptionPane.showMessageDialog(null,"Error" + ex.getMessage());
        }
        return resultado = null;
        
    }
    //Update Familia2
    public void UpdateFamilia2(String id,String Estado,String Descripcion,String Tipo){
     String idEstados = null ;
     String Tipo1 = null ;   
        try {
            ResultSet  resultado1  =Buscar("SELECT idFamilia1 FROM `almacen.pos`.`familia1` WHERE Descripcion ='"+Tipo+"' LIMIT 1");
                while (resultado1.next()){
                   Tipo1 =  resultado1.getString(1);
                }
                
      
            Ingresar("UPDATE `almacen.pos`.`familia2` SET "
                    + "`Descripcion`='"+Descripcion+"', "
                    + "`Estado`='"+Estado+"', "
                    + "`Familia1_Familia2`='"+Tipo1 +"' "
                    + "WHERE  `idFamilia2`="+id+";");
            }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Error" + ex.getMessage());
        }
    }
    //Familia 2 Buscar 
    public ResultSet BuscarFamilia2 (String Familia1){
   ResultSet  resultado= null;
        try{
                resultado =     Buscar ("SELECT fm2.Descripcion \n" +
"from `almacen.pos`.`familia2` AS fm2\n" +
"INNER JOIN `almacen.pos`.`familia1` AS fm1  \n" +
"ON fm2.Familia1_Familia2 = fm1.idFamilia1\n" +
"WHERE  fm1.Descripcion = '"+Familia1+"' AND fm2.Estado ='Activo'"); 
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Error" + ex.getMessage());
        }
return resultado;
    
    }
    //buscar Familia 3
        public ResultSet BuscarFamilia3 (String Familia1){
   ResultSet  resultado= null;
        try{
                resultado =     Buscar ("SELECT fm3.Descripcion \n" +
"from `almacen.pos`.`familia3` AS fm3\n" +
"INNER JOIN `almacen.pos`.`familia2` AS fm1  \n" +
"ON fm3.Familia2_idFamilia2 = fm1.idFamilia2\n" +
"WHERE  fm1.Descripcion = '"+Familia1+"' AND fm3.Estado='Activo'"); 
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Error" + ex.getMessage());
        }
return resultado;
    
    }
    //Insertar familia2
    public void InsertFamilia2(String Estado,String Tipo,String Descripcion){
      String idEstados = null ;
      String Tipo1 = null ; 
    try {
            ResultSet  resultado1  =Buscar("SELECT idFamilia1 FROM `almacen.pos`.`familia1` WHERE Descripcion ='"+Tipo+"' LIMIT 1");
                while (resultado1.next()){
                   Tipo1 =  resultado1.getString(1);
                }
    
                Ingresar("INSERT INTO `almacen.pos`.`familia2` "
                        + "(`Descripcion`, `Estado`, `Familia1_Familia2`) "
                        + "VALUES ('"+Descripcion+"', '"+Estado+"', '"+Tipo1+"');"
                        );
        }catch(Exception ex){
            System.out.println( ex.getMessage());
    JOptionPane.showMessageDialog(null,"Error" + ex.getMessage());
    }
    }
    //Familia1
    //inicioFamilia1
    public  ResultSet InicioFamilia1(){
       ResultSet resultado ;
        try {
            resultado  =Buscar("SELECT Fami3.`idFamilia1`, Fami3.`Descripcion`, Fami3.`Estado`, fami2.Descripcion\n" +
"FROM `almacen.pos`.`familia3` AS Fami3 INNER JOIN familia2 \n" +
"AS fami2 ON Fami3.Familia2_idFamilia2 =fami2.idFamilia2 ");
               TextCarga.setText("Iniciando Familia 1....");
            return resultado;
        }catch(Exception ex){
        JOptionPane.showMessageDialog(null,"Error Inicio Familia 1" + ex.getMessage());
        }
        return resultado = null;
        
    }
    //Update Familia1
    public void UpdateFamilia1(String id,String Estado,String Descripcion,String Clase){
     String idEstados = null ;
     String Tipo1 = null ;   
        try {
            ResultSet  resultado1  =Buscar("SELECT idFamilia2 FROM `almacen.pos`.`familia2` WHERE Descripcion ='"+Clase+"' LIMIT 1");
                while (resultado1.next()){
                   Tipo1 =  resultado1.getString(1);
                }
          
            Ingresar("UPDATE `almacen.pos`.`familia3` SET "
                    + "`Descripcion`='"+Descripcion+"', "
                    + "`Estado`='"+Estado+"',"
                    + "`Familia2_idFamilia2`='"+Tipo1+"' "
                    + "WHERE  `idFamilia1`="+id+";");
            }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Error" + ex.getMessage());
        }
    }
    //Insertar Familia1
    public void InsertFamilia1(String Estado,String Clase ,String Descripcion){
    String idEstados = null ;
    String Tipo1 = null ; 
    try {
            ResultSet  resultado1  =Buscar("SELECT idFamilia2 FROM `almacen.pos`.`familia2` WHERE Descripcion ='"+Clase+"' LIMIT 1");
                while (resultado1.next()){
                   Tipo1 =  resultado1.getString(1);
                }
           
                Ingresar("INSERT INTO `almacen.pos`.`familia3` "
                        + "(`Descripcion`, `Estado`, `Familia2_idFamilia2`)"

                        + "VALUES ('"+Descripcion+"', '"+Estado+"', '"+Tipo1+"');"
                        );
        }catch(Exception ex){
            System.out.println( ex.getMessage());
    JOptionPane.showMessageDialog(null,"Error" + ex.getMessage());
    }
    }
   
    public void InsetEmpresa(String Nombre,String Nit,String inticado,String Regimen,String Reprecentante ,String Telefono, String Email, String Direccion ,byte[] Foto ){
    String sql="INSERT INTO `almacen.pos`.`empresa` "
            + "(`NombreEmpresa`, `NIT_CC`, `Indicador`, `Regimen`, `NombreReprecentateLegal`, `Telefono`, `Email`, `Direccion`, `Logo`) VALUES "
            + "('"+Nombre+"', '"+Nit+"', '"+inticado+"', '"+Regimen+"', '"+Reprecentante+"', '"+Telefono+"', '"+Email+"', '"+Direccion+"', ?);";
     PreparedStatement ps = null;
    try{
        ps = con.prepareStatement(sql);
        ps.setBytes(1, Foto);
     ps.execute();
    }catch(Exception ex){
    
        System.out.println("    Eroor"+ ex);}
    //Configuraciones;
    }
    public ResultSet InicioEmpresa(){
        ResultSet resultado ;
        String sql = "SELECT  `NombreEmpresa`, `NIT_CC`, `Indicador`, `NombreReprecentateLegal`, `Telefono`, `Email`, `Direccion`, `Logo` , `Regimen` FROM `almacen.pos`.`empresa`";
        try{
            resultado = Buscar(sql);
             TextCarga.setText("Iniciando Empresa....");
             return resultado;
        }catch(Exception ex){
        
        }
         return resultado = null;
    }
    //USUARIO BASIC
    //InicarDataInser 
    public ResultSet InicioUsuario(){
          ResultSet resultado ;
        try {
            resultado  =Buscar("SELECT IdUsuario\n" +
                                "FROM usuariobasico\n" +
                                "ORDER by IdUsuario DESC\n" +
                                "LIMIT 1");
              TextCarga.setText("Iniciando Usuario....");
            return resultado;
        }catch(Exception ex){
        JOptionPane.showMessageDialog(null,"Error" + ex.getMessage());
        }
        return resultado = null;
        
    }
    
    public void InsertarUsuarioBC(String id,String TipoDOC,String NDocumento,String NombreUsuario,String Email,String NumeroCuenta,String NomCuenta,String Estado,Boolean Pro,Boolean Cli,Boolean Em,Boolean Banco,Boolean Corrien,Boolean Ahorro,byte[] Foto ){
              
        try {
                   String sql="INSERT INTO `almacen.pos`.`usuariobasico` "
        + "(`IdUsuario`,`TipoDoc`, `NDocumento`, `NombreUsuari`, `Email`, `NCuentaBancaria`, `NombreCuenta`, `Estado`, `Proveedor`, `Cliente`, `Empleado`, `Banco`, `Corriente`, `Ahorro`,`Foto`) VALUES "
        + "('"+id+"','"+TipoDOC+"', '"+ NDocumento+"', '"+NombreUsuario+"', '"+ Email+"', '"+ NumeroCuenta+"', '"+NomCuenta+"', '"+Estado+"', '"+Pro+"', '"+Cli+"', '"+Em+"', '"+Banco+"', '"+Corrien+"', '"+Ahorro+"',?);";
 PreparedStatement ps = null;
    try{
        ps = con.prepareStatement(sql);
        ps.setBytes(1, Foto);
        ps.execute();
        }catch(Exception ex){
            System.out.println("Eroor "+ ex);}}
            catch(Exception ex){
            System.out.println( ex.getMessage());
        JOptionPane.showMessageDialog(null,"Error" + ex.getMessage());
     }
   }
    //Insertar Usuario-Proveedor
    public void InsertarProveedor(String RazonSocial,String Direcion,String Telefono,String EmailFactura,boolean ResponsableIVA,boolean AutoRetenedor,String Id){
   
        try {
            Ingresar("INSERT INTO `almacen.pos`.`proveedor` (`RazonSocial`, `Direccion`, `Telefono`, `CorreoFactura`, `ResponsableIva`, `AutoRenedor`, `UsuarioBasico_IdUsuario`) VALUES "
                    + "('"+RazonSocial+"', '"+ Direcion+"', '"+Telefono+"', '"+EmailFactura+"', '"+ResponsableIVA+"', '"+AutoRetenedor+"', '"+Id+"');");
            }catch(Exception ex){
                System.out.println( ex.getMessage());
        JOptionPane.showMessageDialog(null,"Error" + ex.getMessage());
        }
   } 
    //Buscar usuario por Documento
    public ResultSet UsuarioDocBC(String idBusqueda,String Id ) throws SQLException{
    ResultSet  resultado  =Buscar("SELECT  BC.IdUsuario, \n" +
        "BC.NDocumento, BC.TipoDoc,BC.NombreUsuari,\n" +
        "BC.Email,BC.NCuentaBancaria,\n" +
        "BC.NombreCuenta, BC.Estado\n" +
        ",BC.Proveedor,BC.Empleado,BC.Cliente,BC.Banco,BC.Corriente,BC.Ahorro,\n" +
        "PRO.RazonSocial,PRO.Direccion,\n" +
        "PRO.Telefono,PRO.CorreoFactura,\n" +
        "PRO.ResponsableIva,PRO.AutoRenedor , BC.Foto\n" +
        "FROM `almacen.pos`.`usuariobasico` AS BC \n" +
        "LEFT JOIN `almacen.pos`.`proveedor` AS PRO ON PRO.UsuarioBasico_IdUsuario=BC.IdUsuario \n" +
        "WHERE  `"+Id+"`='"+idBusqueda+"';");
    return resultado;
    } 
    //Buscar Usuario
     public ResultSet BuscarUsuario(String idBusqueda,String Where ) throws SQLException{
    ResultSet  resultado  =Buscar("SELECT  BC.IdUsuario, \n" +
        "BC.NDocumento,BC.NombreUsuari,\n" +
        "BC.Email,BC.NCuentaBancaria,\n" +
        "BC.NombreCuenta, BC.Estado\n" +
        ",if(BC.Proveedor = 'true','Proveedor',null) AS `Proveedor` ,\n" +
"if(BC.Empleado = 'true','Empleado',null) AS `Empleado`, if(BC.Cliente  = 'true','Cliente',null) AS `Cliente`" +
        "FROM `almacen.pos`.`usuariobasico` AS BC \n" +
        
        "WHERE  "+idBusqueda+" REGEXP  '^"+Where+"' ;");
    return resultado;
    } 
     //Modicicar Usuario
        public void ModificarUsuarioBD(String TipoDOC,String NDocumento,
                String NombreUsuario,String Email,String NumeroCuenta,
                String NomCuenta,String Estado,Boolean Pro,Boolean Cli,Boolean Em,String id,
                Boolean CheakBanco, Boolean ChecKCorriente,Boolean ChecKAhorro,byte[] Foto){
      
        try {
        
                String SQL=
                   "UPDATE `almacen.pos`.`usuariobasico` SET `TipoDoc`='"+TipoDOC+"', "
                           + "`NDocumento`='"+NDocumento+"', `NombreUsuari`='"+NombreUsuario+"', "
                           + "`Email`='"+Email+"', `NCuentaBancaria`='"+NumeroCuenta+"', "
                           + "`NombreCuenta`='"+NomCuenta+"', `Estado`='"+Estado+"', "
                           + "`Proveedor`='"+Pro+"', `Cliente`='"+Cli+"', `Empleado`='"+Em+"' ,`Banco`='"+CheakBanco+"', `Corriente`='"+ChecKCorriente+"', `Ahorro`='"+ChecKAhorro+"',`Foto` = ? "
                           + " WHERE  `IdUsuario`="+id+";";
                PreparedStatement ps = null;
                 
                ps = con.prepareStatement(SQL);
                ps.setBytes(1, Foto);
  

                ps.execute();
                
            }catch(Exception ex){
                System.out.println( ex.getMessage());
        JOptionPane.showMessageDialog(null,"Error" + ex.getMessage());
        }
   }
    //Modicar Proveedor
    public void ModicarProveedor(String RazonSocial,String Direcion,String Telefono,String EmailFactura,boolean ResponsableIVA,boolean AutoRetenedor,String Id){
        try {
            ResultSet  resultado  =Buscar("SELECT `UsuarioBasico_IdUsuario` from `almacen.pos`.`proveedor`   WHERE `UsuarioBasico_IdUsuario`='"+Id+"' LIMIT 1");
           if(resultado.next()){
           Ingresar("UPDATE `almacen.pos`.`proveedor` SET `RazonSocial`='"+RazonSocial+"', `Direccion`='"+ Direcion+"', `Telefono`='"+Telefono+"',"
                   + " `CorreoFactura`='"+EmailFactura+"', `ResponsableIva`='"+ResponsableIVA+"', `AutoRenedor`='"+AutoRetenedor+"' WHERE  `UsuarioBasico_IdUsuario`='"+Id+"';");
           }else{
            Ingresar("INSERT INTO `almacen.pos`.`proveedor` (`RazonSocial`, `Direccion`, `Telefono`, `CorreoFactura`, `ResponsableIva`, `AutoRenedor`, `UsuarioBasico_IdUsuario`) VALUES "
                    + "('"+RazonSocial+"', '"+ Direcion+"', '"+Telefono+"', '"+EmailFactura+"', '"+ResponsableIVA+"', '"+AutoRetenedor+"', '"+Id+"');");
           }
           
            }catch(Exception ex){
                System.out.println( ex.getMessage());
        JOptionPane.showMessageDialog(null,"Error" + ex.getMessage());
        }
   }   
        
      
}
