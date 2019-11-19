
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
   private JButton BUsu,BPub,BPag;
   private JTextField txtUsu,txtPub,txtPag;
   private JTable AreaImpr;
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
      
      JLabel Usu=new JLabel("Tabla Usuario", SwingConstants.CENTER);
      Usu.setForeground(Color.BLACK);
      Usu.setBounds(0, 40, 150, 50);
      Usu.setFont(new Font("Dyuthi",Font.ITALIC, 17));
      add(Usu);
      
      JLabel Pub=new JLabel("Tabla Publicación", SwingConstants.CENTER);
      Pub.setForeground(Color.BLACK);
      Pub.setBounds(220, 40, 150, 50);
      Pub.setFont(new Font("Dyuthi",Font.ITALIC, 17));
      add(Pub);
      
      JLabel Pag=new JLabel("Tabla Pagina", SwingConstants.CENTER);
      Pag.setForeground(Color.BLACK);
      Pag.setBounds(450, 40, 150, 50);
      Pag.setFont(new Font("Dyuthi",Font.ITALIC, 17));
      add(Pag);
      
        //----------->>>>>>>>>Cajas de Texto<<<<<<<<<<<------------  
      txtUsu = new JTextField();
      txtUsu.setBounds(15, 75, 130, 20);
      add(txtUsu);
      
      txtPub = new JTextField();
      txtPub.setBounds(230, 75, 130, 20);
      add(txtPub);
      
      txtPag = new JTextField();
      txtPag.setBounds(460, 75, 130, 20);
      add(txtPag);
      
        //----------->>>>>>>>>Botones<<<<<<<<<<<------------
      BUsu = new JButton("Buscar");
      BUsu.setBounds(25, 100, 100, 30);
      BUsu.setEnabled(true);
      BUsu.addActionListener(this);
      add(BUsu);
      
      BPub = new JButton("Buscar");
      BPub.setBounds(245, 100, 100, 30);
      BPub.setEnabled(true);
      BPub.addActionListener(this);
      add(BPub);
      
      BPag = new JButton("Buscar");
      BPag.setBounds(480, 100, 100, 30);
      BPag.setEnabled(true);
      BPag.addActionListener(this);
      add(BPag);
      
        //----------->>>>>>>>>Area de Texto<<<<<<<<<<<------------
      AreaImpr=new JTable();
      AreaImpr.setBounds(0, 150, 600, 300);
      AreaImpr.setBackground(Color.LIGHT_GRAY);
      AreaImpr.setForeground(Color.BLACK);
      add(AreaImpr);
        
    }

        //--------------->>>>>>>Metodo de Acciones<<<<<<--------------
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if (ae.getSource()==BUsu){
            JOptionPane.showMessageDialog(this,"Buscando Usuario "+txtUsu.getText());
            //txtUsu.setText(" "); AreaImpr.setText("\t\tResultado Busqueda Por Usuario.... ");

        }
        if (ae.getSource()==BPub){
           JOptionPane.showMessageDialog(this,"Buscando Publicación "+txtPub.getText());
           //txtPub.setText(" "); AreaImpr.setText("\t\tResultado Busqueda Por Publicación..... ");
           
        }
        if (ae.getSource()==BPag){
           JOptionPane.showMessageDialog(this,"Buscando Pagina "+txtPag.getText());
           //txtPag.setText(" "); AreaImpr.setText("\t\tResultado Busqueda Por Pagina.... ");
           
        }
    }
    
}
