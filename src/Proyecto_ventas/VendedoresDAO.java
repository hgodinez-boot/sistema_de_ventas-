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

public class VendedoresDAO {
    
    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Conexion conectar = new Conexion();
    String nombres[];
    Object datos[][]; 
   
   public int filtro(String nombre, String pass ){
           String sql = "select * from vendedor where nombre= "+"'"+nombre+"'"+"and password ="+"'"+pass+"'"+";";
           try{
               con=conectar.Conectar();
               ps=con.prepareStatement(sql);
               rs=ps.executeQuery();
              
               if(rs.next()){
                   return rs.getInt(7);
               }   
           } catch (Exception e){
           } 
           return -1;
       }
   
   //METODO LISTAR LOS REGISTROS DE LA TABLA VENDEDORES
   public Object [][] listar_tabla(){
        String instruccion = "select * from vendedor";
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
                datos[x][3] = rs.getInt(4);
                datos[x][4] = rs.getString(5);
                datos[x][5] = rs.getString(6);
                datos[x][6] = rs.getInt(7);
                x++;    
            }
            
        } catch (Exception e){   
        }
        return datos;
    }
   //METODO CREAR VENDEDORES ---------------------------------------------------------------------------------------------------------------------- 
   public void crear(int codigo, String nombre, int caja, int ventas, String genero, String password, int rol){
        String sql = "insert into vendedor(codigo,nombre,caja,ventas,genero,password,rol) values (?,?,?,?,?,?,?)";
        try{
            con = conectar.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, codigo);
            ps.setString(2, nombre);
            ps.setInt(3, caja);
            ps.setInt(4, ventas);
            ps.setString(5,genero);
            ps.setString(6, password);
            ps.setInt(7, rol);
            ps.executeUpdate();
        }catch(Exception e){
            System.out.println(e);
        }
    }
   //METODO PARA PARA ACTUALIZAR REGISTRO DE LA TABLA CLIENTES 
   public void actualizar(int codigo, String nombre, int caja, int ventas, String genero, String password, int rol ){
    String sql = "update vendedor set nombre ='" + nombre + "', caja='" + caja + "', ventas='" + ventas + "', genero='" + genero + "', password='" + password + "', rol='" + rol + "' where codigo='" + codigo + "'";
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
        FileOutputStream gen = new FileOutputStream("Reporte-Vendedores.pdf");
        Document documento = new Document();
        PdfWriter.getInstance(documento, gen);
        documento.open();
        Paragraph parrafo = new Paragraph("Reporte de Vendedores Base de datos");
        parrafo.setAlignment(1);
        documento.add(parrafo);
        documento.add(new Paragraph("\n"));
        String sql = "select * from vendedor";
        try {
            con = conectar.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                 documento.add(new Paragraph("Código: "+rs.getInt(1)));
                 documento.add(new Paragraph("Nombre: "+rs.getString(2)));
                 documento.add(new Paragraph("Caja: "+rs.getInt(3)));
                 documento.add(new Paragraph("Ventas: "+rs.getInt(4)));
                 documento.add(new Paragraph("Género: "+rs.getString(5)));
                 documento.add(new Paragraph("Password: "+rs.getString(6)));
                 documento.add(new Paragraph("Rol: "+rs.getInt(7)));
                documento.add(new Paragraph("\n\n"));
            }
        } catch (Exception e) {
        }
        documento.close();
        JOptionPane.showMessageDialog(null, "EL ARCHIVO SE CREÓ CORRECTAMENTE");
        try {
            File sucursales_doc = new File("Reporte-Vendedores.pdf");
            Desktop.getDesktop().open(sucursales_doc);
        } catch (Exception e) {
        }
    }
   //METODO ELIMINAR REGISTRO EN LA TABLA DE VENDEDOR--------------------------------------------------------------------
   public void eliminar(int x){
   String sql = "delete from vendedor where codigo ="+x;
   try{
       con=conectar.Conectar();
       ps=con.prepareStatement(sql);
       ps.execute();
       
   }catch(Exception e){       
   }
   JOptionPane.showMessageDialog(null, "REGISTRO ELIMINADO CORRECTAMENTE");
   }      
}
