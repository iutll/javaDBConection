
package Interfas;

import static Interfas.Pagina.PASSWORD;
import static Interfas.Pagina.URL;
import static Interfas.Pagina.USERNAME;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
 
/**
 * @author jose-dasilva
 * @author Carlos Martínez
 */
public class Publicacion extends JPanel implements ActionListener {
    
    //--------Atributos Globales----------
   private JButton BB,BID,BAnadir,BGuardar,BModificar,BLimpiar,BEliminar;
   private JTextField txtBp,txtID,txtUsu,txtTitle,txtFecha;
   private JTextArea ACont; 
   private JComboBox Red=new JComboBox();
   private PreparedStatement ps;
   private ResultSet rs;
   int ID_Publicacion;
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
      String[] Redes= {"busque su usuario primero"};
      
      Red=new JComboBox(Redes);
      Red.setBounds(120, 260, 140, 30);
      Red.setSelectedItem("busque su usuario primero"); //Selecciona el Primer Obj Mostrado
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
           buscarPorCedula(false, txtBp.getText());
           //txtBp.setText("");
       }
       
       if (ae.getSource()==BID){
           JOptionPane.showMessageDialog(this,"Encontrando Resultados de ID... "+txtBp.getText());
           buscarPorId();
           //txtID.setText("");
       }
       
       
       if (ae.getSource()==BAnadir){
            JOptionPane.showMessageDialog(this,"Agrega Tus Datos... ");
            hacerEditable(false);
            crearPublicacion();
       }
       
       
       if (ae.getSource()==BGuardar){
            JOptionPane.showMessageDialog(this,"Guardando... ");
            modificarPublicacion();
            hacerEditable(false);
        }
        if (ae.getSource()==BModificar){
            JOptionPane.showMessageDialog(this,"Modifica la Publicación... ");
            hacerEditable(true);
        }
        if (ae.getSource()==BLimpiar){
            JOptionPane.showMessageDialog(this,"Limpiando... ");
            txtUsu.setText("");
            txtTitle.setText("");
            ACont.setText("");
            txtFecha.setText("");
            txtBp.setText("");
            txtID.setText("");
            hacerEditable(false);
            Red.removeAllItems();
            Red.addItem("seleccione red");
            
        }
        if (ae.getSource()==BEliminar){
            JOptionPane.showMessageDialog(this,"Eliminando... ");
            hacerEditable(false);   
            borrarPublicacion();
        }
           
        
    }
    
    // ***********************  acciones crud  ****************************
    // buscar por cedula las redes sociales que estan asociadas a ese usuario
    // se necesitan al menos 1 red social para hacer publicaciones
    private ArrayList<String> buscarPorCedula(boolean justGetValues, String cedula){
        java.sql.Connection con = null;
        try{
            // buscar que tenga redes sociales agregadas
            con = (java.sql.Connection) getConnection();
            ps = con.prepareStatement("SELECT * FROM redessociales WHERE cedula = ?");            
            ps.setString(1, cedula );
            rs = ps.executeQuery();
      
      // tiene redes sociales
      if(rs.first()){
          // valores predeterminados del JComboBox
          Red.removeAllItems();
          Red.addItem("seleccione red");
          Red.setSelectedItem("seleccione red");
          // hacer nombre de usuario visible 
         if(!justGetValues) {
             txtUsu.setText(rs.getString("usuario"));
             hacerEditable(true);
         }
         // array para guardar redes
          ArrayList<String> redesUser = new ArrayList<>();
          do{
              // añadir redes registradas
              Red.addItem( rs.getString("Nombre_red") );
              redesUser.add(rs.getString("Nombre_red"));
          }while(rs.next());
          
          return redesUser;
      }else{
      
        if(!cedula.equals("")) JOptionPane.showMessageDialog(null,"No existen redes asociadas a esa cedula \n debe agregar al menos una \n para poder hacer una publicación");
        else JOptionPane.showMessageDialog(null,"ingrese una cedula por favor");
      }
       }catch(Exception e){
       System.out.println("error " + e);
       }
       return null;
    
    }
    
    // buscar publicacion por id
    private void buscarPorId(){
        java.sql.Connection con = null;
        try{
            con = (java.sql.Connection) getConnection();
            ps = con.prepareStatement("SELECT * FROM publicacion WHERE id_publicacion = ?");            
            ps.setString(1,txtID.getText() );
            rs = ps.executeQuery();
      
      // existe dicha publicacion
      if(rs.first()){
          txtBp.setText(rs.getString("cedulauser"));
          txtUsu.setText(rs.getString("usuario"));
          txtFecha.setText(rs.getDate("fecha").toString() );
          ACont.setText(rs.getString("contenido"));
          txtTitle.setText(rs.getString("titulo"));
          ID_Publicacion = rs.getInt("id_publicacion");
          
          // opciones dinamicas
          makeJComboBoxDinamic(rs.getString("cedulauser"), rs.getString("red_publicada") );
          hacerEditable(false);
          
      }else{
      
        JOptionPane.showMessageDialog(null,"No existe publicación asociada a ese id");
      }
       }catch(Exception e){
       System.out.println("error " + e);
       }
    }
    
    // crear publicacion
    private void crearPublicacion(){
        java.sql.Connection con = null;
        // no ha seleccionado una red donde publicar, necesita seleccionar una
        if(Red.getSelectedItem().toString().equals("seleccione red") || Red.getSelectedItem().toString().equals("busque su usuario primero") ){
           JOptionPane.showMessageDialog(null,"no ha seleccionado una red donde publicar, necesita seleccionar una");
        }
        // selecciono una red
        else{
                try{
                    con = (java.sql.Connection) getConnection();
                    ps = con.prepareStatement("INSERT INTO publicacion (titulo, cedulauser, contenido, fecha, usuario, red_publicada) VALUES (?,?,?,?,?,?)");            
                    ps.setString(1,txtTitle.getText() );
                    ps.setString(2,txtBp.getText() );
                    ps.setString(3,ACont.getText() );
                    ps.setString(4, txtFecha.getText()  );
                    ps.setString(5,txtUsu.getText() );
                    ps.setString(6, Red.getSelectedItem().toString() );
                    int creado = ps.executeUpdate();

                    // existe dicha publicacion
                    if(creado > 0 ){
                        JOptionPane.showMessageDialog(null,"publicacion creada");

                    }else{

                      JOptionPane.showMessageDialog(null,"No se ha podido crear la publicacion");
                    }
                     }catch(Exception e){
                     System.out.println("error " + e);
                     }
        }
        
    }
    
    // modificar
    private void modificarPublicacion(){
        java.sql.Connection con = null;
        // no ha seleccionado una red donde publicar, necesita seleccionar una
        if(Red.getSelectedItem().toString().equals("seleccione red") || Red.getSelectedItem().toString().equals("busque su usuario primero") ){
           JOptionPane.showMessageDialog(null,"no ha seleccionado una red donde publicar, necesita seleccionar una");
        }
        // selecciono una red
        else{
                try{
                    con = (java.sql.Connection) getConnection();
                    ps = con.prepareStatement("UPDATE publicacion SET titulo = ?, contenido = ?, fecha = ?, red_publicada = ? WHERE id_publicacion = ?");            
                    ps.setString(1,txtTitle.getText() );
                    ps.setString(2,ACont.getText() );
                    ps.setString(3, txtFecha.getText()  );
                    ps.setString(4, Red.getSelectedItem().toString() );
                    ps.setInt(5, ID_Publicacion );
                    int creado = ps.executeUpdate();
                    
                    System.out.println("el pinche id de publicacion " + Integer.toString(ID_Publicacion) );

                    // existe dicha publicacion
                    if(creado > 0 ){
                        JOptionPane.showMessageDialog(null,"publicacion actualizada");

                    }else{

                      JOptionPane.showMessageDialog(null,"No se ha podido actualizar la publicacion");
                    }
                     }catch(Exception e){
                     System.out.println("error " + e);
                     }
        }
        
    }
    
    // borrar publicacion
    private void borrarPublicacion(){
        java.sql.Connection con = null;
        
    try{
        con = (java.sql.Connection) getConnection();
        ps = con.prepareStatement("DELETE FROM publicacion WHERE id_publicacion = ?");            
        ps.setString(1, Integer.toString(ID_Publicacion) );
        int borrado = ps.executeUpdate();

        // existe dicha publicacion
        if(borrado > 0 ){
            JOptionPane.showMessageDialog(null,"publicacion eliminada");

        }else{
          JOptionPane.showMessageDialog(null,"No se ha podido eliminar la publicacion");
        }
         }catch(Exception e){
         System.out.println("error " + e);
         }

    }
    
    
    // ############### makeJComboBoxDinamic, hacer que el JComboBox tenga opciones dependiendo de ciertos parametros ##########
    private void makeJComboBoxDinamic(String cedula, String redUsada){
        // valores predeterminados del JComboBox
          
          ArrayList<String> redesUser = buscarPorCedula(true, cedula);
          Red.removeAllItems();
          Red.addItem("seleccione red");
          
          for(String s : redesUser){
              Red.addItem(s);
          }
          
          Red.setSelectedItem(redUsada);
      
    }
    
    
    // hacer campos editables
    private void hacerEditable(boolean editable){
        txtTitle.setEditable(editable);
        txtFecha.setEditable(editable);
        ACont.setEditable(editable);
    }
    
    
}
