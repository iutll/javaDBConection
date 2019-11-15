
package Interfas;
/*
 * @author jose-dasilva
 */
//import com.mysql.jdbc.Connection;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/*import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import javax.swing.JOptionPane;*/

public class Cons_General extends JPanel implements ActionListener{
    
    //--------Atributos Globales----------
   private JButton BBg;
   private JTextField txtBg;
   private JTextArea AreaImpr;
    //------------------------------------
    
  /*  public static final String URL = "jdbc:mysql://localhost:3306/miniproyecto";
   public static final String USERNAME = "root";
   public static final String PASSWORD = "";
   PreparedStatement ps;
   ResultSet rs;
   
   public  Connection getConnection(){
          Connection con = null;
     try {
    
            Class.forName("com.mysql.jdbc.Driver");
             
            con=(Connection) DriverManager.getConnection(URL,USERNAME,PASSWORD);
              JOptionPane.showMessageDialog(this,"Conectado a la base de datos...");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Error:" + e);
        }
      
     return con;
    }*/
   
    //Metodo Constructor
    public Cons_General(){
        
      setLayout(null); //Desactivamos el diseño por Defecto del panel
      setBackground(Color.CYAN);//Agregamos Color Al Panel
        initComponents();
    }
    
    private void initComponents(){
    
        //----------->>>>>>>>>Etiquetas<<<<<<<<<<<------------
      JLabel title=new JLabel("¡¡Busque En Registros YA!!", SwingConstants.CENTER);
      title.setForeground(Color.DARK_GRAY);
      title.setBounds(170, 5, 250, 50);
      title.setFont(new Font("Dyuthi",Font.ITALIC, 20));
      add(title);
      
      
      JLabel Pub=new JLabel("C.I o Nombre", SwingConstants.CENTER);
      Pub.setForeground(Color.BLACK);
      Pub.setBounds(220, 40, 150, 50);
      Pub.setFont(new Font("Dyuthi",Font.ITALIC, 17));
      add(Pub);
      
        //----------->>>>>>>>>Cajas de Texto<<<<<<<<<<<------------ 
      txtBg = new JTextField();
      txtBg.setBounds(230, 75, 130, 20);
      add(txtBg);
      
        //----------->>>>>>>>>Botones<<<<<<<<<<<------------
      
      BBg = new JButton("Buscar");
      BBg.setBounds(245, 100, 100, 30);
      BBg.setEnabled(true);
      BBg.addActionListener(this);
      add(BBg);

      
        //----------->>>>>>>>>Area de Texto<<<<<<<<<<<------------
      AreaImpr=new JTextArea();
      AreaImpr.setBounds(0, 150, 600, 300);
      AreaImpr.setBackground(Color.LIGHT_GRAY);
      AreaImpr.setForeground(Color.BLACK);
      AreaImpr.setEditable(false);
      add(AreaImpr);
        
    }

        //--------------->>>>>>>Metodo de Acciones<<<<<<--------------
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if (ae.getSource()==BBg){
           JOptionPane.showMessageDialog(this,"Encontrando Resultados... "+txtBg.getText());
           txtBg.setText(" "); AreaImpr.setText("\t\tEncontrando Resultado Busqueda..... ");
           
        }
    }
    
}
