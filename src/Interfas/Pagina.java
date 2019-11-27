
package Interfas;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * @author jose-dasilva
 */
public class Pagina extends JPanel implements ActionListener {
    
    //--------Atributos Globales----------
   private JButton BB,BAnadir,BGuardar,BModificar,BLimpiar,BEliminar;
   private JTextField txtBr,txtUsu,txtRed, txtUrl;
   private JTable AreaImpr;
   public static final String URL = "jdbc:mysql://localhost:3306/mini-Gestor";
   public static final String USERNAME = "root";
   public static final String PASSWORD = "";
   // id de la publicacion
   public int ID_redes;
   PreparedStatement ps;
   ResultSet rs;
   
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
   
   
   
    //------------------------------------
   
     public Pagina(){
        
      setLayout(null); //Desactivamos el diseño por Defecto del panel
      setBackground(Color.CYAN);//Agregamos Color Al Panel
        initComponents();
    }
    
    private void initComponents(){
    
      //----------->>>>>>>>>Etiquetas<<<<<<<<<<<------------
      JLabel title=new JLabel("¡¡Registro de Redes!!", SwingConstants.CENTER);
      title.setForeground(Color.DARK_GRAY);
      title.setBounds(170, 5, 250, 50);
      title.setFont(new Font("Dyuthi",Font.ITALIC, 20));
      add(title);
      
      JLabel BP=new JLabel("Ingrese Cedula", SwingConstants.CENTER);
      BP.setForeground(Color.BLACK);
      BP.setBounds(440, 30, 150, 40);
      BP.setFont(new Font("Dyuthi",Font.ITALIC, 16));
      add(BP);
      
      JLabel Usuario=new JLabel("Usuario:", SwingConstants.CENTER);
      Usuario.setForeground(Color.BLACK);
      Usuario.setBounds(0, 90, 100, 40);
      Usuario.setFont(new Font("Dyuthi",Font.ITALIC, 18));
      add(Usuario);
      
      JLabel nombreRed=new JLabel("nombre red:", SwingConstants.CENTER);
      nombreRed.setForeground(Color.BLACK);
      nombreRed.setBounds(0, 135, 100, 40);
      nombreRed.setFont(new Font("Dyuthi",Font.ITALIC, 18));
      add(nombreRed);
      
      JLabel url=new JLabel("Url:", SwingConstants.CENTER);
      url.setForeground(Color.BLACK);
      url.setBounds(0, 175, 100, 40);
      url.setFont(new Font("Dyuthi",Font.ITALIC, 18));
      add(url);
      
      JLabel Face =new JLabel(new ImageIcon("Redes.png"));
      Face.setBounds(400,190,200,130);
      add(Face);
      
      //----------->>>>>>>>>Cajas de Texto<<<<<<<<<<<------------ 
      txtBr = new JTextField();
      txtBr.setBounds(450, 60, 130, 20);
      add(txtBr);
      
      txtUsu = new JTextField();
      txtUsu.setBounds(100, 95, 315, 20);
      txtUsu.setEditable(false);
      add(txtUsu);
      
      txtRed = new JTextField();
      txtRed.setBounds(100, 145, 315, 20);
      txtRed.setEditable(false);
      add(txtRed);
      
      txtUrl = new JTextField();
      txtUrl.setBounds(100, 185, 315, 20);
      txtUrl.setEditable(false);
      add(txtUrl);
      
      // ----------->>>>>>>>>>>>>>JTable para ver las redes sociales del usuario<<<<<<<<<<<<<<<<--------------
      AreaImpr=new JTable();
      JScrollPane scrollPane= new  JScrollPane(AreaImpr);
      scrollPane.setBounds(50, 220, 250, 120);
      scrollPane.setBackground(Color.LIGHT_GRAY);
      scrollPane.setForeground(Color.BLACK);
      add(scrollPane);
      
    
      //----------->>>>>>>>>Botones<<<<<<<<<<<------------
      BB = new JButton("Buscar");
      BB.setBounds(470, 90, 100, 25);
      BB.setEnabled(true);
      BB.addActionListener(this);
      add(BB);
      
       BAnadir = new JButton("Agregar");
      BAnadir.setBounds(5, 410, 100, 30);
      BAnadir.setEnabled(true);
      BAnadir.addActionListener(this);
      add(BAnadir);
      
      BGuardar = new JButton("Actualizar");
      BGuardar.setBounds(115, 410, 100, 30);
      BGuardar.setEnabled(true);
      BGuardar.addActionListener(this);
      add(BGuardar);
      
      BModificar = new JButton("Modificar una red");
      BModificar.setBounds(220, 410, 145, 30);
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
           JOptionPane.showMessageDialog(this,"Encontrando Resultados... "+txtBr.getText());
            hacerEditable(false);
            // traer datos
           buscarRedes();

       }
        if (ae.getSource()==BAnadir){
            JOptionPane.showMessageDialog(this,"Añadiendo Red... ");
            actualizarOCrearRedes();
        }
       
       if (ae.getSource()==BGuardar){
            JOptionPane.showMessageDialog(this,"Guardando... ");
            actualizarOCrearRedes();
    
        }
        if (ae.getSource()==BModificar){
            JOptionPane.showMessageDialog(this,"escribe el nombre de la red y luego su nueva url");
            hacerEditable(true);
        }
        if (ae.getSource()==BLimpiar){
            LimpiarCajas();
        }
        if (ae.getSource()==BEliminar){
            JOptionPane.showMessageDialog(this,"Eliminando... ");
            eliminarRed();

        }
    
    }
    
    /*
    ============================================================================
    
    Metodos para  acciones crud de 'redes'
    
    ============================================================================
    */
    
    
    // **********  buscar redes  **********
    private void buscarRedes() {                                                
    java.sql.Connection con = null;
       try{
      con = (java.sql.Connection) getConnection();
     
      ps = con.prepareStatement("SELECT * FROM redessociales WHERE cedula = ?");
      ps.setString(1,txtBr.getText());
      rs = ps.executeQuery();
        // agregar headers
        String[] titulos = {"Nombre red","Url"};
        DefaultTableModel tableModel = new DefaultTableModel();
        agregarHeaders(AreaImpr, tableModel, titulos);
        
      if(rs.first()){
          do{
              String[] valores = {
                  rs.getString("Nombre_red"),
                  rs.getString("Url"),
              };
              agregarFilas(tableModel, valores);
          }while(rs.next());
          // mostrar usuario
          mostrarUsuario(txtUsu, txtBr.getText(), false);
          hacerEditable(true);
      }else{
      
        JOptionPane.showMessageDialog(null,"No existen redes asociadas a esa cedula \n puedes agregarlas");
        // mostrar usuario
        mostrarUsuario(txtUsu, txtBr.getText(), false);
        // hacer editable para agregar redes a usuario
        hacerEditable(true);
      }
       }catch(Exception e){
       System.out.println("error " + e);
       }
       
    }
    
    // **********  actualizar o crear redes **********
    private void actualizarOCrearRedes() {                                             
       java.sql.Connection con = null;
    
        try{
        con = (java.sql.Connection) getConnection();
        
        // ver si el usuario existe 
        ps = con.prepareStatement("SELECT * FROM usuario WHERE cedula = ?");
        ps.setString(1,txtBr.getText());
        rs = ps.executeQuery();
        // si el usuario existe
        if(rs.first()){
            // redes sociales aceptadas
            String[] allAceptedSocialNetworks = {
                "snapchat",
                "linkedin",
                "twitter",
                "facebook",
                "Instagram",
                "youtube",
                "tiktok",
                "yahoo"
            };
            // comprobar que la red que quiere agregar o modificar esta entre las redes acetadas
            String redActual = txtRed.getText(); // texto en JTextField
            boolean aceptada = false;
            for( String red : allAceptedSocialNetworks){
                if(redActual.equals(red)){ 
                    aceptada = true;
                    break;
                }
            }
            // si es una red aceptada
            if(aceptada){
                // comprobar si el usuario ya tiene una de estas redes o va a agregar una nueva
                try{
                    // query para ver si ya tiene esa red social agregada y de ser asi, modificarla, si no, agregarla
                    ps = con.prepareStatement("SELECT * FROM redessociales WHERE cedula = ? AND Nombre_red = ?");
                    ps.setString(1,txtBr.getText());
                    ps.setString(2,redActual);
                    rs = ps.executeQuery();
                    // si existe la red, actualizarla
                    if(rs.first()){
                        int ID_REDES = rs.getInt("id_redes"); // id del registro red que se esta actualizando
                        ps = con.prepareStatement("UPDATE redessociales SET Nombre_red = ?, Url = ? WHERE id_redes = ?");
                        ps.setString(1,redActual);
                        ps.setString(2,txtUrl.getText() );
                        ps.setString(3, Integer.toString(ID_REDES) );
                        ps.executeUpdate();
                        JOptionPane.showMessageDialog(null,"red "+ redActual +" actualizada");
                    }
                    // no existe, agregarla
                    else{
                        // valores del usuario
                        String[] valoresUser = mostrarUsuario(txtUsu, txtBr.getText(), true);
                        
                        ps = con.prepareStatement("INSERT INTO redessociales (Nombre_red, Url, usuario, cedula, correo, nivel_user) VALUES (?,?,?,?,?,?)");
                        ps.setString(1,redActual );
                        ps.setString(2, txtUrl.getText() );
                        ps.setString(3, valoresUser[0]);
                        ps.setString(4, txtBr.getText());
                        ps.setString(5, valoresUser[1]);
                        ps.setString(6, valoresUser[2]);
                        
                        ps.executeUpdate();
                        JOptionPane.showMessageDialog(null,"red "+ redActual +" agregada");
                    }
                }
                catch(SQLException err){
                    System.out.println(err);
                }
            }
            // no es una red aceptada
            else{
                JOptionPane.showMessageDialog(null, "la red "+redActual+" no es una red aceptada, las redes aceptadas son: "+Arrays.toString(allAceptedSocialNetworks));
            }
             
        }
        // no existe el usuario
        else{
            JOptionPane.showMessageDialog(null, "no hay usuario con esa cedula");
        }

        
        // cerrar conexión
         con.close();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    // **********  borrar registro de red **********
    private void eliminarRed() {                                            
           java.sql.Connection con = null;
           
            // obtener valor de red en la fila de la tabla
            int row = AreaImpr.getSelectedRow();
            String nombreRed;
            if(row >= 0){
               nombreRed = AreaImpr.getModel().getValueAt(row, 0).toString();
               
               try{
                    con = (java.sql.Connection) getConnection();
                    ps = con.prepareStatement("DELETE FROM redessociales WHERE cedula=? AND Nombre_red = ?");
                    ps.setString(1, txtBr.getText() );
                    ps.setString(2,nombreRed);

                    int res =  ps.executeUpdate();

                    if(res > 0){
                        JOptionPane.showMessageDialog(null,"red "+ nombreRed +" eliminada del registro");
                        LimpiarCajas();
                        hacerEditable(false);
                    }else{
                        JOptionPane.showMessageDialog(null,"Error al eliminar");
                        LimpiarCajas();
                        hacerEditable(false);
                    }
                    con.close();
                }
                catch(SQLException e){
                    System.out.println(e);
                }
               
            }
            // no ha seleccionado tabla aun
            else{
                JOptionPane.showMessageDialog(null,"selecciona una red haciendo clic en ella, luego oprime eliminar");
            }
           
    }
    
    
    

    // ==========================================================================================
    
    // limpiar cajas de texto
    void LimpiarCajas(){
        txtBr.setText("");
        txtUsu.setText("");
        txtRed.setText("");
        txtUrl.setText("");
        AreaImpr.removeAll();
    }
    
    // hacer editable las redes
    void hacerEditable(boolean visible){
        txtRed.setEditable(visible);
        txtUrl.setEditable(visible);
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
    
    // ************** mostrar usuario en JTextField ******************
    private String[] mostrarUsuario(JTextField campoUsuario, String cedula, boolean nombreSolamente){
       java.sql.Connection con = null;
       try{
            con = (java.sql.Connection) getConnection();
            ps = con.prepareStatement("SELECT * FROM usuario WHERE cedula = ?");
            ps.setString(1,cedula);
            rs = ps.executeQuery();
            System.out.println("la cedula!!!!!!!!!!!!!!!  " + cedula);
        
      if(rs.first()){
          if(!nombreSolamente){
            // mostrar nombre de usuario
            campoUsuario.setText(rs.getString("usuario"));
          }
          else{
              String[] valores = {
                  rs.getString("usuario"),
                  rs.getString("correo"),
                  rs.getString("nivel")
              };
              return valores;
          }
          
      }else{
        JOptionPane.showMessageDialog(null,"No existe usuario con esa cedula");
      }
       }catch(Exception e){
            System.out.println("error " + e);
       }
       return null;
    }
}
