
package Interfas;
/*
 * @author jose-dasilva
 */
//import com.mysql.jdbc.Connection;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Cons_General extends JPanel implements ActionListener{
    
    //--------Atributos Globales----------
   private JButton BUsu,BPub,BPag;
   private JTextField txtCI;
   private JTable AreaImpr;
    //------------------------------------
    
   public static final String URL = "jdbc:mysql://localhost:3306/prueba";
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
    }
   
   /*
   ================================================================================
   
   
   
   ================================================================================
   */
   
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
      
      JLabel CI=new JLabel("Ingrese Cedula", SwingConstants.CENTER);
      CI.setForeground(Color.BLACK);
      CI.setBounds(220, 30, 150, 50);
      CI.setFont(new Font("Dyuthi",Font.ITALIC, 17));
      add(CI);
      
      JLabel Usu=new JLabel("Tabla Usuario", SwingConstants.CENTER);
      Usu.setForeground(Color.BLACK);
      Usu.setBounds(0, 70, 150, 50);
      Usu.setFont(new Font("Dyuthi",Font.ITALIC, 17));
      add(Usu);
      
      JLabel Pub=new JLabel("Tabla Publicación", SwingConstants.CENTER);
      Pub.setForeground(Color.BLACK);
      Pub.setBounds(220, 70, 150, 50);
      Pub.setFont(new Font("Dyuthi",Font.ITALIC, 17));
      add(Pub);
      
      JLabel Pag=new JLabel("Tabla Redes", SwingConstants.CENTER);
      Pag.setForeground(Color.BLACK);
      Pag.setBounds(450, 70, 150, 50);
      Pag.setFont(new Font("Dyuthi",Font.ITALIC, 17));
      add(Pag);
      
        //----------->>>>>>>>>Cajas de Texto<<<<<<<<<<<------------  
      txtCI = new JTextField();
      txtCI.setBounds(230, 65, 130, 20);
      add(txtCI);

      
        //----------->>>>>>>>>Botones<<<<<<<<<<<------------
      BUsu = new JButton("Buscar");
      BUsu.setBounds(25, 110, 100, 30);
      BUsu.setEnabled(true);
      BUsu.addActionListener(this);
      add(BUsu);
      
      BPub = new JButton("Buscar");
      BPub.setBounds(245, 110, 100, 30);
      BPub.setEnabled(true);
      BPub.addActionListener(this);
      add(BPub);
      
      BPag = new JButton("Buscar");
      BPag.setBounds(480, 110, 100, 30);
      BPag.setEnabled(true);
      BPag.addActionListener(this);
      add(BPag);
      
        //----------->>>>>>>>>Area de Texto<<<<<<<<<<<------------
      AreaImpr=new JTable();
      JScrollPane scrollPane= new  JScrollPane(AreaImpr);
      scrollPane.setBounds(0, 150, 600, 300);
      scrollPane.setBackground(Color.LIGHT_GRAY);
      scrollPane.setForeground(Color.BLACK);
      add(scrollPane);
        
    }

        //--------------->>>>>>>Metodo de Acciones<<<<<<--------------
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if (ae.getSource()==BUsu){
            JOptionPane.showMessageDialog(this,"Buscando Usuario "+txtCI.getText());
            //txtUsu.setText(" "); AreaImpr.setText("\t\tResultado Busqueda Por Usuario.... ");
            buscarUsuario();

        }
        if (ae.getSource()==BPub){
           JOptionPane.showMessageDialog(this,"Buscando Publicación "+txtCI.getText());
           //txtPub.setText(" "); AreaImpr.setText("\t\tResultado Busqueda Por Publicación..... ");
           buscarPublicaciones();
           
        }
        if (ae.getSource()==BPag){
           JOptionPane.showMessageDialog(this,"Buscando Redes "+txtCI.getText());
           //txtPag.setText(" "); AreaImpr.setText("\t\tResultado Busqueda Por Pagina.... ");
           buscarRedes();
           
        }
    }
    
    /*
    ===================================================================================
    
    
    
    =====================================================================================
    */
    
    
    // buscar usuario
    private void buscarUsuario(){
        com.mysql.jdbc.Connection con = null;
       
       try{
      con = (com.mysql.jdbc.Connection) getConnection();
      ps = con.prepareStatement("SELECT * FROM usuario WHERE cedula = ?" );
      ps.setString(1,txtCI.getText());
      rs = ps.executeQuery();
      
      // hacer modelo para visualizar la tabla
      DefaultTableModel tableModel = new DefaultTableModel();
      // valores del header
      String[] valores = {"id", "usuario", "clave", "rango", "email"};
      // ageregar dichos valores a el header la tabla
      agregarHeaders(AreaImpr, tableModel, valores);
      
      
           System.out.println("Base de datos de usuario");
    // si existe un registro por lo menos 
    if(rs.first()){
          // repetir hasta que no haya mas usuarios
          do{
            
              System.out.println(rs.getInt("id_usuario") +" "  + rs.getString("usuario") +" " + rs.getString("clave") +" "+ rs.getString("cedula") +" "+ rs.getString("correo") + " " + rs.getString("nivel") );
              // valores de la fila
              String[] row = {
                  Integer.toString(rs.getInt("id_usuario")),
                  rs.getString("usuario"),
                  rs.getString("clave"),
                  rs.getString("nivel"),
                  rs.getString("correo")
              };
              // agregar fila a la tabla
              agregarFilas(tableModel, row);
          
          }while(rs.next());
           
      }else{
        JOptionPane.showMessageDialog(null,"No existe usuario asociado a esa cedula");
      }
       }catch(Exception e){
       
       }
    }
    
    // buscar prublicaciones
    private void buscarPublicaciones() {                                                     
        // TODO add your handling code here:
        com.mysql.jdbc.Connection con = null;
       try{
      con = (com.mysql.jdbc.Connection) getConnection();
      ps = con.prepareStatement("SELECT * FROM publicacion WHERE cedulauser=?");
            ps.setString(1,txtCI.getText());
      rs = ps.executeQuery();
      
           System.out.println("Base de datos de Publicacion");
           System.out.println("");
           System.out.println("id_publicacion" +" "  + "Titulo" +" " + "cedula " + "Texto" +" " + "Fecha " +" "  );
           // crear nuevo modelo de tabla
           DefaultTableModel tableModel = new DefaultTableModel();
           String[] columnNames = {"id_publicacion", "Titulo", "cedula ", "Texto", "Fecha"};
           // agregar los headers
           agregarHeaders(AreaImpr, tableModel, columnNames);
           
           // ver si existe un registro al menos
           if(rs.first()){
               do{
                    System.out.println(rs.getInt("id_publicacion") +" " + rs.getString("titulo") + rs.getString("cedulauser") + rs.getString("contenido") +" " +rs.getDate("fecha") );
                    String[] valoresRow = {
                        Integer.toString(rs.getInt("id_publicacion")),
                        rs.getString("titulo"),
                        rs.getString("cedulauser"),
                        rs.getString("contenido"),
                        rs.getDate("fecha").toString()
                    };
                    // agregar una fila a la tabla
                    agregarFilas(tableModel, valoresRow);
               }while(rs.next());
      }else{
      
      JOptionPane.showMessageDialog(null,"No existe publicacion asociado a esa cedula");
      }
       }catch(Exception e){
       
       }
    }  
    
    // buscar redes
    private void buscarRedes() {                                                
    com.mysql.jdbc.Connection con = null;
       try{
      con = (com.mysql.jdbc.Connection) getConnection();
     
      ps = con.prepareStatement("SELECT * FROM redessociales WHERE cedula = ?");
        ps.setString(1,txtCI.getText());
      rs = ps.executeQuery();
      // modelo de tabla nuevo
      DefaultTableModel tableModel = new DefaultTableModel();
      // valores del header de la tabla
      String[] valores = {"id_redes", "twitter", "instagram", "facebook", "cedula"};
      // agregar header con valores a la tabla
      agregarHeaders(AreaImpr, tableModel, valores);
      
      
           System.out.println("Base de datos de pagina");
           System.out.println("");
           System.out.println("id_pagina" +" " + "footer" +" "+ "enlace facebook" +" "+ "enlace instagram" +" "+ "enlace_twitter" + " " + "parrafo_pagina" + " " + "archivo_encabezado" + " " + "Titulo_encabezado");
      if(rs.first()){
          do{
               System.out.println(rs.getInt("id_redes") +" " + rs.getString("twitter") + rs.getString("instagram") + rs.getString("facebook") + rs.getString("cedula") );
               String[] row = {
                   Integer.toString(rs.getInt("id_redes")),
                   rs.getString("twitter"),
                   rs.getString("instagram"),
                   rs.getString("facebook"),
                   rs.getString("cedula")
               };
               // agregar nueva fila a la tabla
               agregarFilas(tableModel, row);
          }while(rs.next()); 
      }else{
      
        JOptionPane.showMessageDialog(null,"No existen redes asociados a esa cedula");
      }
       }catch(Exception e){
       System.out.println("error " + e);
       }
       
    }
    
    
    /*
    agregrar filas y clomnas a la tabla
    */
    
    void agregarHeaders( JTable AreaImpr , DefaultTableModel tableModel, String[] valores){
        // agregar columnas y su valor a el modelo
        System.out.println("entro en agregar headers #########################");
           for(String columnName : valores){
                tableModel.addColumn(columnName);
            }
           // setear modelo en la tabla
           AreaImpr.setModel(tableModel);
    }
    
    void agregarFilas(DefaultTableModel tableModel, String[] valores){
        tableModel.addRow(valores);
    }
    
}
