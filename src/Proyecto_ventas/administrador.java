
package Proyecto_ventas;
import javax.swing.*;
public class administrador extends JFrame{
    
    JTabbedPane pestañas = new JTabbedPane();
    JPanel sucursales = new JPanel();
    JPanel vendedores = new JPanel();
    JPanel clientes = new JPanel();
    JPanel productos = new JPanel();
    
    private void inicio(){
        
        setTitle("SISTEMA DE VENTAS");
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            setBounds(250,45,1000,750);
            setVisible(true);
            
            
            //setBackground(Color.LIGHT_GRAY);
            //p1.setLayout(null);
            //add(p1);
            sucursales.setLayout(null);
            productos.setLayout(null);
            clientes.setLayout(null);
            vendedores.setLayout(null);
            
            sucursales_vistas sv = new sucursales_vistas();
            sv.ejecutar();
            Productos_vistas pv = new Productos_vistas();
            pv.ejecutar();
            Clientes_vistas cv = new Clientes_vistas();
            cv.ejecutar();
            Vendedores_vistas vv = new Vendedores_vistas();
            vv.ejecutar();
            
            
            
            
            
            pestañas.addTab("SUCURSALES", sv.sucursales);
            pestañas.addTab("PRODUCTOS", pv.sucursales);
            pestañas.addTab("CLIENTES", cv.sucursales);
            pestañas.addTab("VENDEDORES", vv.sucursales);
            
            add(pestañas);
            
            
            
            
            
            
        
    }
    public void ejecutar(){
        inicio();
    }
    
    public static void main(String[] args){
        administrador admin= new administrador();
        admin.ejecutar();
    } 
    
    
    
}
