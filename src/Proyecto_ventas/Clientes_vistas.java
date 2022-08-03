
package Proyecto_ventas;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Clientes_vistas {
    JPanel sucursales = new JPanel();
    JTable tabla = new JTable();
    JScrollPane sp = new JScrollPane ();
   
    
    private void botones(){
        
        sucursales.setLayout(null);
        JButton crear = new JButton("CREAR"); 
        crear.setBounds(600,100,150,50);
        sucursales.add(crear);
        
        JButton carga = new JButton("CARGA MASIVA"); 
        carga.setBounds(790,100,150,50);
        sucursales.add(carga);
        
        JButton actualizar = new JButton("ACTUALIZAR"); 
        actualizar.setBounds(600,180,150,50);
        sucursales.add(actualizar);
        
        JButton eliminar = new JButton("ELIMINAR"); 
        eliminar.setBounds(790,180,150,50);
        sucursales.add(eliminar);
        
        JButton exportar = new JButton("EXPORTA A PDF"); 
        exportar.setBounds(600,300,340,50);
        sucursales.add(exportar);
        
        
       
    }
    
    private void tabla(){
        
        String columnas []= {"CÓDIGO","NOMBRE","NIT","CORREO","GENERO"};
        Object filas [][]={{"1","Juan","998877","j@gmail.com","M"}};
        tabla = new JTable(filas,columnas);
        sp=new JScrollPane(tabla);
        sp.setBounds(60,35,450,60);
        sucursales.add(sp);
    }
    
    
    public void ejecutar(){
        botones();
        tabla();
    } 
}