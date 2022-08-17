package Proyecto_ventas;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class ventas_realizadas {
    
    JPanel ventas_general = new JPanel();
    JTable tabla;
    JScrollPane sp;
    
    JTextField factura = new JTextField();
    JTextField nit = new JTextField();
    JTextField nombre = new JTextField();
    JTextField fecha = new JTextField();
    
    private void inicio(){
        ventas_general.setLayout(null);
        
        JButton salir = new JButton("SALIR");
        salir.setBounds(700, 0, 100, 30);
        salir.setBackground(Color.red);
        ventas_general.add(salir);
        
        JLabel l1 = new JLabel("No. FACTURA");
        l1.setBounds(30, 30, 100, 30);
        JLabel l2 = new JLabel("NIT");
        l2.setBounds(390, 30, 75, 30);
        JLabel l3 = new JLabel("NOMBRE");
        l3.setBounds(30, 90, 75, 30);
        JLabel l4 = new JLabel("FECHA");
        l4.setBounds(390, 90, 75, 30);

        factura.setBounds(120, 30, 250, 30);
        nit.setBounds(450, 30, 120, 30);
        nombre.setBounds(120, 90, 250, 30);
        fecha.setBounds(450, 90, 120, 30);

        JButton b1 = new JButton("BUSCAR");
        b1.setBounds(620, 60, 150, 30);
        b1.setBackground(Color.YELLOW);    
        ventas_general.add(l1);
        ventas_general.add(l2);
        ventas_general.add(l3);
        ventas_general.add(l4);

        ventas_general.add(factura);
        ventas_general.add(nit);
        ventas_general.add(nombre);
        ventas_general.add(fecha);
        ventas_general.add(b1);

        ActionListener verificar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                int factura_uso;
                if (factura.getText().trim().equals("")) {
                    factura_uso = 0;
                } else {
                    factura_uso = Integer.parseInt(factura.getText().trim());
                }
                
                int nit_uso;
                if (nit.getText().trim().equals("")) {
                    nit_uso = 0;
                } else {
                    nit_uso = Integer.parseInt(nit.getText().trim());
                }

                String nombre_uso;
                if (nombre.getText().trim().equals("")) {
                    nombre_uso = null;
                } else {
                    nombre_uso = nombre.getText().trim();

                }
                String fecha_uso;
                if (fecha.getText().trim().equals("")) {
                    fecha_uso = null;
                } else {
                    fecha_uso = fecha.getText().trim();
                }
                
                VentasDAO vd = new VentasDAO();
                Object resultado [][] = vd.filtro_ventas(factura_uso, nit_uso, nombre_uso, fecha_uso);
                
                if(resultado == null){
                    sp.setVisible(false);
                    tabla();
                } else{
                    sp.setVisible(false);
                    resultados(resultado);
                }   
            }
        };
        b1.addActionListener(verificar);  
    }
    
    private void resultados(Object result [][]){
        String columnas []= {"No. FACTURA","NIT","NOMBRE","FECHA","TOTAL"};
        
        tabla = new JTable(result,columnas);
        sp = new JScrollPane(tabla);
        sp.setBounds(50, 350, 800, 300);
        ventas_general.add(sp); 
    }
    
    private void tabla(){
        String columnas []= {"No. FACTURA","NIT","NOMBRE","FECHA","TOTAL"};
        VentasDAO vd = new VentasDAO();
        Object filas [][] = vd.listar_tabla();
        tabla = new JTable(filas,columnas);
        sp = new JScrollPane(tabla);
        sp.setBounds(50, 350, 800, 300);
        ventas_general.add(sp); 
    }
    
    public void ejecutar(){
        inicio();
        tabla();
    } 
    
}
