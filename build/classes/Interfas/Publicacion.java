
package Interfas;

import static Interfas.Pagina.PASSWORD;
import static Interfas.Pagina.URL;
import static Interfas.Pagina.USERNAME;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author jose-dasilva
 */
public class Publicacion extends JPanel implements ActionListener {
    
    //--------Atributos Globales----------
   private JButton BB,BID,BAnadir,BGuardar,BModificar,BLimpiar,BEliminar;
   private JTextField txtBp,txtID,txtUsu,txtTitle,txtFecha;
   private JTextArea ACont; 
   private JComboBox Red=new JComboBox();
   private PreparedStatement ps;
   private ResultSet rs;
    //------------------------------------
   
   public  Connection getConnection(){
          Connection con = null;
     try {
    
            Class.forName("java.sql.Driver");
             
            con=(Connection) DriverManager.getConnection(URL,USERNAME,PASSWORD);
              JOptionPane.showMessageDialog(this,"Conectado a la base de datos...");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Error:" + e);
        }
      
     return con;
    }
    
     public Publicacion(){
        
      setLayout(null); //Desactivamos el diseño por Defecto del panel
      setBackground(Color.CYAN);//Agregamos Color Al Panel
        initComponents();
    }
    
    private void initComponents(){
    
      //----------->>>>>>>>>Etiquetas<<<<<<<<<<<------------
      JLabel title=new JLabel("¡¡Registro de Publicaciónes!!", SwingConstants.CENTER);
      title.setForeground(Color.DARK_GRAY);
      title.setBounds(170, 5, 250, 50);
      title.setFont(new Font("Dyuthi",Font.ITALIC, 20));
      add(title);
      
      JLabel BP=new JLabel("Ingrese Cedula", SwingConstants.CENTER);
      BP.setForeground(Color.BLACK);
      BP.setBounds(440, 30, 150, 40);
      BP.setFont(new Font("Dyuthi",Font.ITALIC, 16));
      add(BP);
      
      JLabel ID=new JLabel("Ingrese ID", SwingConstants.CENTER);
      ID.setForeground(Color.BLACK);
      ID.setBounds(440, 210, 150, 40);
      ID.setFont(new Font("Dyuthi",Font.ITALIC, 16));
      add(ID);
      
      JLabel Usuario=new JLabel("Usuario:", SwingConstants.CENTER);
      Usuario.setForeground(Color.BLACK);
      Usuario.setBounds(5, 45, 100, 40);
      Usuario.setFont(new Font("Dyuthi",Font.ITALIC, 17));
      add(Usuario);
      
      JLabel Title=new JLabel("Titulo:", SwingConstants.CENTER);
      Title.setForeground(Color.BLACK);
      Title.setBounds(5, 75, 100, 40);
      Title.setFont(new Font("Dyuthi",Font.ITALIC, 17));
      add(Title);
      
      JLabel Cont=new JLabel("Contenido:", SwingConstants.CENTER);
      Cont.setForeground(Color.BLACK);
      Cont.setBounds(5, 115, 100, 40);
      Cont.setFont(new Font("Dyuthi",Font.ITALIC, 17));
      add(Cont);
      
      JLabel Publi=new JLabel("Publicar en:", SwingConstants.CENTER);
      Publi.setForeground(Color.BLACK);
      Publi.setBounds(5, 250, 100, 40);
      Publi.setFont(new Font("Dyuthi",Font.ITALIC, 17));
      add(Publi);
      
      JLabel Fecha=new JLabel("Fecha:", SwingConstants.CENTER);
      Fecha.setForeground(Color.BLACK);
      Fecha.setBounds(5, 360, 100, 40);
      Fecha.setFont(new Font("Dyuthi",Font.ITALIC, 17));
      add(Fecha);
      
      //----------->>>>>>>>>Cajas de Texto<<<<<<<<<<<------------ 
      txtBp = new JTextField();
      txtBp.setBounds(450, 60, 130, 20);
      add(txtBp);
      
      txtID = new JTextField();
      txtID.setBounds(450, 250, 130, 20);
      add(txtID);
      
      txtUsu = new JTextField();
      txtUsu.setBounds(90, 55, 315, 20);
      txtUsu.setEditable(false);
      add(txtUsu);
      
      txtTitle = new JTextField();
      txtTitle.setBounds(90, 85, 315, 20);
      txtTitle.setEditable(false);
      add(txtTitle);
      
      txtFecha = new JTextField();
      txtFecha.setBounds(90, 370, 315, 20);
      txtFecha.setEditable(false);
      add(txtFecha);
      
      //----------->>>>>>>>>Area de Texto<<<<<<<<<<<------------
      ACont=new JTextArea();
      ACont.setBounds(100, 110, 300, 100);
      ACont.setBackground(Color.WHITE);
      ACont.setForeground(Color.BLACK);
      ACont.setEditable(false);
      add(ACont);
      
      //----------->>>>>>>>>Lista Desplegable<<<<<<<<<<<------------
      String[] Redes= {"Seleccione","Facebook","Instagram","Twitter"};
      
      Red=new JComboBox(Redes);
      Red.setBounds(120, 260, 140, 30);
      Red.setSelectedItem("Seleccione"); //Selecciona el Primer Obj Mostrado
      
      add(Red);
      
      //----------->>>>>>>>>Botones<<<<<<<<<<<------------
      BB = new JButton("Buscar");
      BB.setBounds(470, 90, 100, 25);
      BB.setEnabled(true);
      BB.addActionListener(this);
      add(BB);
      
      BID = new JButton("Buscar");
      BID.setBounds(470, 280, 100, 25);
      BID.setEnabled(true);
      BID.addActionListener(this);
      add(BID);
      
      BAnadir = new JButton("Nueva");
      BAnadir.setBounds(10, 410, 100, 30);
      BAnadir.setEnabled(true);
      BAnadir.addActionListener(this);
      add(BAnadir);
      
      BGuardar = new JButton("Publicar");
      BGuardar.setBounds(130, 410, 100, 30);
      BGuardar.setEnabled(true);
      BGuardar.addActionListener(this);
      add(BGuardar);
      
      BModificar = new JButton("Modificar");
      BModificar.setBounds(250, 410, 100, 30);
      BModificar.setEnabled(true);
      BModificar.addActionListener(this);
      add(BModificar);
      
      BLimpiar = new JButton("Limpiar");
      BLimpiar.setBounds(370, 410, 100, 30);
      BLimpiar.setEnabled(true);
      BLimpiar.addActionListener(this);
      add(BLimpiar);
      
      BEliminar = new JButton("Eliminar");
      BEliminar.setBounds(480, 410, 100, 30);
      BEliminar.setEnabled(true);
      BEliminar.addActionListener(this);
      add(BEliminar);
    
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
       if (ae.getSource()==BB){
           JOptionPane.showMessageDialog(this,"Encontrando Resultados de CI... "+txtBp.getText());
           txtBp.setText("");
           buscarPorCedula();
       }
       
       if (ae.getSource()==BID){
           JOptionPane.showMessageDialog(this,"Encontrando Resultados de ID... "+txtBp.getText());
           txtID.setText("");
           //buscarPorId(txtID.getText());
       }
       
       if (ae.getSource()==BAnadir){
            JOptionPane.showMessageDialog(this,"Agrega Tus Datos... ");
            ACont.setEditable(true);
            txtTitle.setEditable(true);
            txtFecha.setEditable(true);
       }
       
       if (ae.getSource()==BGuardar){
            JOptionPane.showMessageDialog(this,"Guardando... ");
            ACont.setEditable(false);
            txtTitle.setEditable(false);
            txtFecha.setEditable(false);
            
    
        }
        if (ae.getSource()==BModificar){
            JOptionPane.showMessageDialog(this,"Modifica la Publicación... ");
            ACont.setEditable(true);
            txtTitle.setEditable(true);
            txtFecha.setEditable(true);
            
            
        }
        if (ae.getSource()==BLimpiar){
            JOptionPane.showMessageDialog(this,"Limpiando... ");
            txtUsu.setText(" ");
            txtTitle.setText(" ");
            ACont.setText(" ");
            txtFecha.setText(" ");
            ACont.setEditable(false);
            txtTitle.setEditable(false);
            txtFecha.setEditable(false);
            
        }
        if (ae.getSource()==BEliminar){
            JOptionPane.showMessageDialog(this,"Eliminando... ");
            ACont.setEditable(false);
            txtTitle.setEditable(false);
            txtFecha.setEditable(false);
            
        }
           
        
    }
    
    // ***********************  acciones crud  ****************************
    private void buscarPorCedula(){
        java.sql.Connection con = null;
        try{
            con = (java.sql.Connection) getConnection();
            ps = con.prepareStatement("SELECT * FROM pu WHERE cedula = ?");
            ps.setString(1,txtBp.getText() );
            rs = ps.executeQuery();
        
      if(rs.first()){
          do{
              String[] valores = {
                  rs.getString("Nombre_red"),
                  rs.getString("Url"),
              };
          }while(rs.next());
          // mostrar usuario
          //mostrarUsuario(txtUsu, txtBr.getText(), false);
          hacerEditable(true);
      }else{
      
        JOptionPane.showMessageDialog(null,"No existen redes asociadas a esa cedula \n puedes agregarlas");
        // mostrar usuario
        //mostrarUsuario(txtUsu, txtBr.getText(), false);
        // hacer editable para agregar redes a usuario
        hacerEditable(true);
      }
       }catch(Exception e){
       System.out.println("error " + e);
       }
    
    }
    
    
    
    // hacer campos editables
    private boolean hacerEditable(boolean visible){
        return true;
    }
    
    
}
