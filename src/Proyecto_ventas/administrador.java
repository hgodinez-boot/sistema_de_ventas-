
package Proyecto_ventas;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;
public class administrador extends JFrame{
    
    JTabbedPane pestañas = new JTabbedPane();
    
    //JPanel sucursales = new JPanel();
    
//    JPanel vendedores = new JPanel();
//    JPanel clientes = new JPanel();
//    JPanel productos = new JPanel();
    
    private void inicio(){
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
            String[] a={"Salir","Cerrar Sesion","Cancelar"} ;
            int b=JOptionPane.showOptionDialog(null,"¿Que deseas hacer?","Administrador",JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,a,a[0]);
                switch (b) {
                    case 0:
                        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        break;
                    case 1:
                        login l = new login();
                        l.ejecutar();
                        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        break;
                    case 2:
                        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                        break;
                    default:
                        break;
                }
            };
        });
        
        setTitle("ADMINISTRADOR");
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            setBounds(250,45,1000,750);
            setVisible(true);
            
            
            //setBackground(Color.LIGHT_GRAY);
            //p1.setLayout(null);
            //add(p1);
            //sucursales.setLayout(null);
            //productos.setLayout(null);
            //clientes.setLayout(null);
            //vendedores.setLayout(null);
            
            Sucursales_vistas sv = new Sucursales_vistas();
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
            pestañas.addTab("VENDEDORES", vv.vendedores);
            pestañas.setBackground(Color.YELLOW);
            
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
