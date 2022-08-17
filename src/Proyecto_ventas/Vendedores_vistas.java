package Proyecto_ventas;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.itextpdf.text.DocumentException;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Vendedores_vistas {
    JPanel vendedores = new JPanel();
    JTable tabla = new JTable();
    JScrollPane sp = new JScrollPane ();  
//    //METODO DE BOOTONES -----------------------------------------------------------------------------------------------------------------------    
    private void botones(){        
        JLabel lop = new JLabel("¿QUÉ DESEA HACER?");
        lop.setBounds(730, 50, 250, 50);
        vendedores.add(lop);
        vendedores.setLayout(null);
        vendedores.setBackground(Color.WHITE);
//BOTON CREAR ----------------------------------------------------------------------------------------------------------------------------        
        JButton crear = new JButton("CREAR");
        crear.setBounds(640, 120, 130, 50);
        crear.setBackground(Color.YELLOW);
        vendedores.add(crear);
        ActionListener funcion_crear = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crear();
            }
        };
        crear.addActionListener(funcion_crear);         
//BOTON CARGA MASIVA----------------------------------------------------------------------------------------------------------------------------
        JButton carga = new JButton("CARGA MASIVA");
        carga.setBounds(810, 120, 130, 50);
        carga.setBackground(Color.YELLOW);
        vendedores.add(carga);
        ActionListener funcion_carga = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    carga_masiva();
                } catch (IOException ex) {

                    Logger.getLogger(Sucursales_vistas.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(Sucursales_vistas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        carga.addActionListener(funcion_carga);
//BOTON ACTUALIZAR ----------------------------------------------------------------------------------------------------------------------------
        JButton actualizar = new JButton("ACTUALIZAR");
        actualizar.setBounds(640, 210, 130, 50);
        actualizar.setBackground(Color.YELLOW);
        vendedores.add(actualizar);
        ActionListener funcion_actualizar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizar();
            }
        };
        actualizar.addActionListener(funcion_actualizar);                
//BOTON ELIMINAR ----------------------------------------------------------------------------------------------------------------------------
        JButton eliminar = new JButton("ELIMINAR");
        eliminar.setBounds(810, 210, 130, 50);
        eliminar.setBackground(Color.YELLOW);
        vendedores.add(eliminar);       
         ActionListener funcion_eliminar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminar_opcion();
            }
        };
        eliminar.addActionListener(funcion_eliminar);
//BOTON EXPORTA A PDF----------------------------------------------------------------------------------------------------------------------------      
        JButton exportar = new JButton("EXPORTA A PDF");
        exportar.setBounds(640, 300, 300, 50);
        exportar.setBackground(Color.YELLOW);
        vendedores.add(exportar);
         ActionListener funcion_pdf = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VendedoresDAO vd = new VendedoresDAO();
                try {
                    vd.pdf();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Productos_vistas.class.getName()).log(Level.SEVERE, null, ex);
                } catch (DocumentException ex) {
                    Logger.getLogger(Productos_vistas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        exportar.addActionListener(funcion_pdf);       
    }
     //METODO CREAR --------------------------------------------------------------------------------------------------------------- 
    public void crear() {
        JFrame frame_cliente = new JFrame();
        frame_cliente.setTitle("NUEVO VENDEDOR");
        frame_cliente.setLocationRelativeTo(null);
        frame_cliente.setBounds(400, 250, 350, 535);     
        frame_cliente.setVisible(true);
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(Color.WHITE);
        frame_cliente.add(p1);
        //LABEL Y TEXTFIELD--------------------------------------------------------------------------------------------------------
        JLabel l1 = new JLabel("CÓDIGO:");
        l1.setBounds(50, 20, 80, 50);
        p1.add(l1);
        JTextField t1 = new JTextField();
        t1.setBounds(150, 35, 135, 25);
        p1.add(t1);
        JLabel l2 = new JLabel("NOMBRE:");
        l2.setBounds(50, 80, 80, 50);
        p1.add(l2);
        JTextField t2 = new JTextField();
        t2.setBounds(150, 95, 135, 25);
        p1.add(t2);
        JLabel l3 = new JLabel("CAJA:");
        l3.setBounds(50, 140, 80, 50);
        p1.add(l3);
        JTextField t3 = new JTextField();
        t3.setBounds(150, 155, 135, 25);
        p1.add(t3);
        JLabel l4 = new JLabel("VENTAS:");
        l4.setBounds(50, 200, 80, 50);
        p1.add(l4);
        JTextField t4 = new JTextField();
        t4.setBounds(150, 215, 135, 25);
        p1.add(t4);
        JLabel l5 = new JLabel("GÉNERO:");
        l5.setBounds(50, 260, 80, 50);
        p1.add(l5);
        JTextField t5 = new JTextField();
        t5.setBounds(150, 275, 135, 25);
        p1.add(t5);
        JLabel l6 = new JLabel("PASSWORD:");
        l6.setBounds(50, 320, 80, 50);
        p1.add(l6);
        JPasswordField t6 = new JPasswordField(); 
        t6.setBounds(150, 335, 135, 25);
        p1.add(t6);
        JLabel l7 = new JLabel("ROL:");
        l7.setBounds(50, 380, 80, 50);
        p1.add(l7);
        JTextField t7 = new JTextField();
        t7.setBounds(150, 395, 135, 25);
        p1.add(t7);
            
        JButton b1 = new JButton("GUARDAR");
        b1.setBounds(150, 455, 135, 30);
        b1.setBackground(Color.YELLOW);
        p1.add(b1);
        ActionListener gaurdar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VendedoresDAO vd = new VendedoresDAO();
                vd.crear(Integer.parseInt(t1.getText()), t2.getText(), Integer.parseInt(t3.getText()), Integer.parseInt(t4.getText()), t5.getText(), t6.getText(),Integer.parseInt(t7.getText()));
                frame_cliente.setVisible(false);
            }
        };
        b1.addActionListener(gaurdar);
    }
//     //METODO LEER ARCHIVO ---------------------------------------------------------------------------------------------------------
    private String leerarchivo() {
        JPanel c1 = new JPanel();
        JFileChooser fc = new JFileChooser();
        int op = fc.showOpenDialog(c1);
        String content = "";
        if (op == JFileChooser.APPROVE_OPTION) {
            File pRuta = fc.getSelectedFile();
            String ruta = pRuta.getAbsolutePath();
            File archivo = null;
            FileReader fr = null;
            BufferedReader br = null;
            try {
                archivo = new File(ruta);
                fr = new FileReader(archivo);
                br = new BufferedReader(fr);
                String linea = "";
                while ((linea = br.readLine()) != null) {
                    content += linea + "\n";
                }
                return content;
            } catch (FileNotFoundException ex) {
                String resp = (String) JOptionPane.showInputDialog(null, "No se encontro el archivo");
            } catch (IOException ex) {
                String resp = (String) JOptionPane.showInputDialog(null, "No se pudo abrir el archivo");
            } finally {
                try {
                    if (null != fr) {
                        fr.close();
                    }
                } catch (Exception e2) {
                    String resp = (String) JOptionPane.showInputDialog(null, "No se encontro el archivo");
                    return "";
                }
            }
            return content;
        }
        return null;
    }
//    //METODO CARGA MASIVA -----------------------------------------------------------------------------------------------
    private void carga_masiva() throws FileNotFoundException, IOException, ParseException {
        String archivo_retorno = leerarchivo();
        JsonParser parse = new JsonParser();
        JsonArray matriz = parse.parse(archivo_retorno).getAsJsonArray();
        for (int i = 0; i < matriz.size(); i++) {
            JsonObject objeto = matriz.get(i).getAsJsonObject();
            VendedoresDAO vd = new VendedoresDAO();
            vd.crear(objeto.get("codigo").getAsInt(), objeto.get("nombre").getAsString(), objeto.get("caja").getAsInt(), objeto.get("ventas").getAsInt(), objeto.get("genero").getAsString(), objeto.get("password").getAsString(), objeto.get("rol").getAsInt());
        }
    }
//    //METODO ACTUALIZAR ----------------------------------------------------------------------------------------------------------------
    public void actualizar() {
        JFrame frame_acualizar = new JFrame();
        frame_acualizar.setTitle("ACTUALIZAR VENDEDOR");
        frame_acualizar.setLocationRelativeTo(null);
        frame_acualizar.setBounds(400, 250, 350, 535);     
        frame_acualizar.setVisible(true);
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(Color.WHITE);
        frame_acualizar.add(p1);
        //LABEL Y TEXTFIELD--------------------------------------------------------------------------------------------------------
        JLabel l1 = new JLabel("CÓDIGO:");
        l1.setBounds(50, 20, 80, 50);
        p1.add(l1);
        JTextField t1 = new JTextField();
        t1.setBounds(150, 35, 135, 25);
        t1.setText(tabla.getValueAt(tabla.getSelectedRow(), 0)+"");
        t1.setEditable(false);
        p1.add(t1);
        JLabel l2 = new JLabel("NOMBRE:");
        l2.setBounds(50, 80, 80, 50);
        p1.add(l2);
        JTextField t2 = new JTextField();
        t2.setBounds(150, 95, 135, 25);
        t2.setText(tabla.getValueAt(tabla.getSelectedRow(), 1)+"");
        p1.add(t2);
        JLabel l3 = new JLabel("CAJA:");
        l3.setBounds(50, 140, 80, 50);
        p1.add(l3);
        JTextField t3 = new JTextField();
        t3.setBounds(150, 155, 135, 25);
        t3.setText(tabla.getValueAt(tabla.getSelectedRow(), 2)+"");
        p1.add(t3);
        JLabel l4 = new JLabel("VENTAS:");
        l4.setBounds(50, 200, 80, 50);
        p1.add(l4);
        JTextField t4 = new JTextField();
        t4.setBounds(150, 215, 135, 25);
        t4.setText(tabla.getValueAt(tabla.getSelectedRow(), 3)+"");
        p1.add(t4);
        JLabel l5 = new JLabel("GÉNERO:");
        l5.setBounds(50, 260, 80, 50);
        p1.add(l5);
        JTextField t5 = new JTextField();
        t5.setBounds(150, 275, 135, 25);
        t5.setText(tabla.getValueAt(tabla.getSelectedRow(), 4)+"");
        p1.add(t5);
        JLabel l6 = new JLabel("PASSWORD:");
        l6.setBounds(50, 320, 80, 50);
        p1.add(l6);
        JPasswordField t6 = new JPasswordField(); 
        t6.setBounds(150, 335, 135, 25);
        t6.setText(tabla.getValueAt(tabla.getSelectedRow(), 5)+"");
        p1.add(t6);
        JLabel l7 = new JLabel("ROL:");
        l7.setBounds(50, 380, 80, 50);
        p1.add(l7);
        JTextField t7 = new JTextField();
        t7.setBounds(150, 395, 135, 25);
        t7.setText(tabla.getValueAt(tabla.getSelectedRow(), 6)+"");
        p1.add(t7);
            
        JButton b1 = new JButton("GUARDAR");
        b1.setBounds(150, 455, 135, 30);
        b1.setBackground(Color.YELLOW);
        p1.add(b1);
        ActionListener actualizar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VendedoresDAO vd = new VendedoresDAO();
                vd.actualizar(Integer.parseInt(t1.getText()), t2.getText(), Integer.parseInt(t3.getText()), Integer.parseInt(t4.getText()), t5.getText(), t6.getText(), Integer.parseInt(t7.getText()));
                frame_acualizar.setVisible(false);
            }
        };
        b1.addActionListener(actualizar);
    }
//    //COMIENZO DE LOS METODOS-------------------------------------------------------------------------------------------------------    
    private void eliminar_opcion(){
        VendedoresDAO vf = new VendedoresDAO();
        vf.eliminar(Integer.parseInt(tabla.getValueAt(tabla.getSelectedRow(),0)+""));
    }    
//    //METODO TABLA ---------------------------------------------------------------------------------------------------------------------------------    
    private void tabla(){ 
        String columnas[] = {"CÓDIGO", "NOMBRE", "CAJA", "VENTAS", "GÉNERO","PASSWORD","ROL"};
        VendedoresDAO vd = new VendedoresDAO();
        Object filas[][] = vd.listar_tabla();
        tabla = new JTable(filas, columnas);
        sp = new JScrollPane(tabla);
        sp.setBounds(30, 30, 560, 600);
        vendedores.add(sp);
    }  
    public void ejecutar(){
        botones();
        tabla();
    }     
}
