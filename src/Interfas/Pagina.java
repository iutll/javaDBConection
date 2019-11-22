
package Interfas;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

/**
 * @author jose-dasilva
 */
public class Pagina extends JPanel implements ActionListener {
    
    //--------Atributos Globales----------
   private JButton BB,BAnadir,BGuardar,BModificar,BLimpiar,BEliminar;
   private JTextField txtBr,txtUsu,txtInst,txtFace,txtTwi;
   public static final String URL = "jdbc:mysql://localhost:3306/Mini-Gestor";
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
      
      JLabel Face =new JLabel(new ImageIcon("Redes.png"));
      Face.setBounds(400,190,200,130);
      add(Face);
      
      //----------->>>>>>>>>Cajas de Texto<<<<<<<<<<<------------ 
      txtBr = new JTextField();
      txtBr.setBounds(450, 60, 130, 20);
      add(txtBr);
      
      txtUsu = new JTextField();
      txtUsu.setBounds(90, 95, 315, 20);
      txtUsu.setEditable(false);
      add(txtUsu);
      
    
      //----------->>>>>>>>>Botones<<<<<<<<<<<------------
      BB = new JButton("Buscar");
      BB.setBounds(470, 90, 100, 25);
      BB.setEnabled(true);
      BB.addActionListener(this);
      add(BB);
      
       BAnadir = new JButton("Nueva");
      BAnadir.setBounds(10, 410, 100, 30);
      BAnadir.setEnabled(true);
      BAnadir.addActionListener(this);
      add(BAnadir);
      
      BGuardar = new JButton("Guardar");
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
           JOptionPane.showMessageDialog(this,"Encontrando Resultados... "+txtBr.getText());
            hacerEditable(false);
            // traer datos
           buscarRedes();

       }
        if (ae.getSource()==BAnadir){
            JOptionPane.showMessageDialog(this,"Añadiendo Red... ");
    
        }
       
       if (ae.getSource()==BGuardar){
            JOptionPane.showMessageDialog(this,"Guardando... ");
            actualizarOCrearRedes();
    
        }
        if (ae.getSource()==BModificar){
            JOptionPane.showMessageDialog(this,"Modifica la Publicación... ");
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
      
      if(rs.first()){
          
                   txtFace.setText(rs.getString("facebook"));
                   txtInst.setText(rs.getString("instagram"));
                   txtTwi.setText(rs.getString("twitter"));
                   // asignar el id de redes
                   ID_redes = rs.getInt("id_redes");
                   // buscar nombre de usuario con la cedula
                   ps = con.prepareStatement("SELECT * FROM usuario WHERE cedula = ?");
                   ps.setString(1,txtBr.getText());
                   rs = ps.executeQuery();
                   if(rs.next()) txtUsu.setText(rs.getString("usuario"));
      }else{
      
        JOptionPane.showMessageDialog(null,"No existen redes asociadas a esa cedula \n puedes agregarlas");
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
        // si existe comprobar si tiene un registro de redes sociales, si no, registrar uno nuevo
        if(rs.first()){
            // ver si tiene registro de redes sociales
            ps = con.prepareStatement("SELECT * FROM redessociales WHERE cedula = ?");
            ps.setString(1,txtBr.getText());
            rs = ps.executeQuery();
            // tiene registro, actualizar
            if(rs.first()){
                ps = con.prepareStatement("UPDATE redessociales SET twitter=?, instagram=?, facebook=? WHERE id_redes=?");
                ps.setString(1,txtTwi.getText());
                ps.setString(2,txtInst.getText());
                ps.setString(3,txtFace.getText());
                ps.setString(4,Integer.toString(ID_redes) );
               // respuesta del servidor
               int res =  ps.executeUpdate();

               if(res > 0){
                    JOptionPane.showMessageDialog(null,"Red modificada");
                    LimpiarCajas();
               }else{
                    JOptionPane.showMessageDialog(null,"Error al modificar");
                    LimpiarCajas();
                }
            }
            // no tiene registro, insertar
            else{
                
                ps = con.prepareStatement("INSERT INTO redessociales (cedula, twitter, facebook, instagram) VALUES(?,?,?,?) ");
                ps.setString(1,txtBr.getText());
                ps.setString(2,txtTwi.getText());
                ps.setString(3,txtFace.getText());
                ps.setString(4,txtInst.getText());
                
                int res =  ps.executeUpdate();

                if(res > 0){
                  JOptionPane.showMessageDialog(null,"Usuario Registrado");
                  LimpiarCajas();
                }else{
                 JOptionPane.showMessageDialog(null,"Error al Registrar");
                  LimpiarCajas();
                }
                
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

           try{
           con = (java.sql.Connection) getConnection();
           ps = con.prepareStatement("DELETE FROM redessociales WHERE cedula=?");
           ps.setString(1,(txtBr.getText()));

          int res =  ps.executeUpdate();

          if(res > 0){
            JOptionPane.showMessageDialog(null,"Usuario eliminado");
            LimpiarCajas();
              hacerEditable(false);
          }else{
           JOptionPane.showMessageDialog(null,"Error al eliminar");
            LimpiarCajas();
            hacerEditable(false);
          }
          
            con.close();
            }catch(SQLException e){
               System.out.println(e);
            }
    }
    
    
    

    // ==========================================================================================
    
    // limpiar cajas de texto
    void LimpiarCajas(){
        txtBr.setText("");
        txtUsu.setText("");
        txtTwi.setText("");
        txtInst.setText("");
        txtFace.setText("");
    }
    
    // hacer editable las redes
    void hacerEditable(boolean visible){
        txtTwi.setEditable(visible);
        txtInst.setEditable(visible);
        txtFace.setEditable(visible);
    }
}
