
package Proyecto_ventas;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;


public class login extends JFrame {
        JPanel p1= new JPanel();
        JTextField t1 = new JTextField();
        JPasswordField t2 = new JPasswordField(); 
        
        
        //metodos
        private void inicio(){
            setTitle("SISTEMA DE VENTAS");
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            setBounds(600,250,400,400);
            setVisible(true);
            setBackground(Color.LIGHT_GRAY);
            p1.setLayout(null);
            add(p1);
        
            JLabel l1 = new JLabel("INICIAR SESION");
            l1.setBounds(120,20,200,50);
            p1.add(l1);
            
            JLabel l2 = new JLabel("NOMBRE:");
            l2.setBounds(40,90,100,25);
            p1.add(l2);
       
            t1.setBounds(135,90,100,25);
            p1.add(t1);
            
            JLabel l3 = new JLabel("CONTRASEÑA:");
            l3.setBounds(40,130,100,25);
            p1.add(l3);
       
            t2.setBounds(135,130,100,25);
            p1.add(t2);
            
            JButton b1 = new JButton("INICIAR SESION");
            b1.setBounds(135,200,130,30);
            p1.add(b1);
        
            ActionListener verificar = new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    VendedoresDAO vd = new VendedoresDAO();
                    int respuesta = vd.filtro(t1.getText(), t2.getText());
                    
                    
                    switch(respuesta){
                        case 1:
                            
                                administrador ad = new administrador();
                                ad.ejecutar();
                            break;
                        case 0:
                            JOptionPane.showMessageDialog(null, "USUARIO VENDEDOR");
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "DATOS INCORRECTOS");
                            break;           
                    }
                }
            };
            b1.addActionListener(verificar);
        }
        
        
        public void ejecutar(){
            inicio();
        }
        
           
        
        
        public static void main(String[] args){
        login log= new login();
        log.ejecutar();
    } 
 
    
}
