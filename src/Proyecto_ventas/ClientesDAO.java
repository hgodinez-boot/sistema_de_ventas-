package Proyecto_ventas;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class ClientesDAO {       
    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Conexion conectar = new Conexion();
    String nombres[];
    Object datos[][]; 
   
   public String[] filtro(String nombre, int nit, String correo, String genero ){
       String sql = "select * from clientes where nombre = '" + nombre + "'" + " or nit = " + "'" + nit + "'" + " or correo = " + "'" + correo + "'" + " or genero = " + "'" + genero + "'" + ";";       
           try{
               con=conectar.Conectar();
               ps=con.prepareStatement(sql);
               rs=ps.executeQuery();
               int x = 0;
                   while(rs.next()){
                       x++;
                   }
               con=conectar.Conectar();
               ps=con.prepareStatement(sql);
               rs=ps.executeQuery();
               nombres = new String [x];
               x = 0;
               while(rs.next()){
                   nombres[x]= rs.getString(2);
                   x++;
               }     
           } catch (Exception e){    
           } 
           return nombres;
       }
//METODO FILTRO DEL NIT-----------------------------------------------------------------------------------------------------------------------
   public int filtro_nit(String nombre){
       String sql = "select * from clientes where nombre = '" + nombre + "'" +" ;";
        try {
            con = conectar.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt(3);
            }
        } catch (Exception e) {
        }
        return 0;    
   }
//METODO LISTAR LOS REGISTROS DE LA TABLA CLIENTES
   public Object [][] listar_tabla(){
        String instruccion = "select * from clientes";
        try{
            int x = 0;
            con = conectar.Conectar();
            ps = con.prepareStatement(instruccion);
            rs = ps.executeQuery();
            while (rs.next()){
                x++;
            }
            datos = new Object[x][5];
            x = 0;
            con = conectar.Conectar();
            ps = con.prepareStatement(instruccion);
            rs = ps.executeQuery();   
            while(rs.next()){
                datos[x][0] = rs.getInt(1);
                datos[x][1] = rs.getString(2);
                datos[x][2] = rs.getInt(3);
                datos[x][3] = rs.getString(4);
                datos[x][4] = rs.getString(5);
                x++;    
            }            
        } catch (Exception e){   
        }
        return datos;
    }
//METODO CREAR CLIENTES ---------------------------------------------------------------------------------------------------------------------- 
   public void crear(int codigo, String nombre, int nit, String correo, String genero){
        String sql = "insert into clientes(codigo,nombre,nit,correo,genero) values (?,?,?,?,?)";
        try{
            con = conectar.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, codigo);
            ps.setString(2, nombre);
            ps.setInt(3, nit);
            ps.setString(4, correo);
            ps.setString(5,genero);
            ps.executeUpdate();
        }catch(Exception e){
            System.out.println(e);
        }
    }
   //METODO PARA PARA ACTUALIZAR REGISTRO DE LA TABLA CLIENTES 
   public void actualizar(int codigo, String nombre, int nit, String correo, String genero ){
    String sql = "update clientes set nombre ='" + nombre + "', nit='" + nit + "', correo='" + correo + "' , genero='" + genero + "' where codigo='" + codigo + "'";
        try {
            con = conectar.Conectar();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
   //MÉTODO EXPORTAR REGISTO DE LA TABLA CLIENTES A FORMATO PDF
   public void pdf() throws FileNotFoundException, DocumentException {
        FileOutputStream gen = new FileOutputStream("Reporte-Clientes.pdf");
        Document documento = new Document();
        PdfWriter.getInstance(documento, gen);
        documento.open();
        Paragraph parrafo = new Paragraph("Reporte de Clientes Base de datos");
        parrafo.setAlignment(1);
        documento.add(parrafo);
        documento.add(new Paragraph("\n"));
        String sql = "select * from clientes";
        try {
            con = conectar.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                 documento.add(new Paragraph("Código: "+rs.getInt(1)));
                 documento.add(new Paragraph("Nombre: "+rs.getString(2)));
                 documento.add(new Paragraph("NIT: "+rs.getInt(3)));
                 documento.add(new Paragraph("Correo: "+rs.getString(4)));
                 documento.add(new Paragraph("Género: "+rs.getString(5)));
                documento.add(new Paragraph("\n\n"));
            }
        } catch (Exception e) {
        }
        documento.close();
        JOptionPane.showMessageDialog(null, "EL ARCHIVO SE CREÓ CORRECTAMENTE");
        try {
            File sucursales_doc = new File("Reporte-Clientes.pdf");
            Desktop.getDesktop().open(sucursales_doc);
        } catch (Exception e) {
        }
    }
   //METODO ELIMINAR REGISTRO EN LA TABLA DE CLIENTES--------------------------------------------------------------------
   public void eliminar(int x){
   String sql = "delete from clientes where codigo ="+x;
   try{
       con=conectar.Conectar();
       ps=con.prepareStatement(sql);
       ps.execute();
       
   }catch(Exception e){       
   }
   JOptionPane.showMessageDialog(null, "REGISTRO ELIMINADO CORRECTAMENTE");
   }   
}
