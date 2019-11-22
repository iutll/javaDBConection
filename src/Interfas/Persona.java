
package Interfas;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

/*
 * @authors jose-dasilva
*           Carlos Martínez
 */
public class Persona extends JPanel implements ActionListener {
    
        //--------Atributos Globales----------
   private JButton BUsu,BGuardar,BModificar,BLimpiar,BEliminar;
   private JTextField txtUsu,txtMail,txtClv,txtCI;
   public int ID_user;
   private JComboBox ListNivel;
   public static final String URL = "jdbc:mysql://localhost:3306/Mini-Gestor";
   public static final String USERNAME = "root";
   public static final String PASSWORD = "";
   PreparedStatement ps;
   ResultSet rs;
   //------------------------------------
   public  Connection getConnection(){
        Connection con = null;
        try {
    
            Class.forName("java.sql.Driver");
             
            con=(Connection) DriverManager.getConnection(URL,USERNAME,PASSWORD);
            JOptionPane.showMessageDialog(null,"Conectado a la base de datos :D");
        } catch (Exception e) {
            System.err.println("Error:" + e);
        }
      
     return con;
    }
    

    public Persona(){
        
      setLayout(null); //Desactivamos el diseño por Defecto del panel
      setBackground(Color.CYAN);//Agregamos Color Al Panel
        initComponents();
    }
    
    private void initComponents(){
    
  //----------->>>>>>>>>Etiquetas<<<<<<<<<<<------------
      JLabel title=new JLabel("¡¡Registro de Usuarios!!", SwingConstants.CENTER);
      title.setForeground(Color.DARK_GRAY);
      title.setBounds(170, 5, 250, 50);
      title.setFont(new Font("Dyuthi",Font.ITALIC, 20));
      add(title);
    
      JLabel Usu=new JLabel("-> Usuario:");
      Usu.setForeground(Color.BLACK);
      Usu.setBounds(20, 50, 150, 50);
      Usu.setFont(new Font("Dyuthi",Font.ITALIC, 17));
      add(Usu);
      
      JLabel Mail=new JLabel("-> E-Mail:");
      Mail.setForeground(Color.BLACK);
      Mail.setBounds(20, 100, 100, 50);
      Mail.setFont(new Font("Dyuthi",Font.ITALIC, 17));
      add(Mail);
      
      JLabel Clv=new JLabel("-> Clave:");
      Clv.setForeground(Color.BLACK);
      Clv.setBounds(20, 150, 100, 50);
      Clv.setFont(new Font("Dyuthi",Font.ITALIC, 17));
      add(Clv);
      
      JLabel Nivel=new JLabel("-> Nivel:");
      Nivel.setForeground(Color.BLACK);
      Nivel.setBounds(20, 200, 60, 50);
      Nivel.setFont(new Font("Dyuthi",Font.ITALIC, 17));
      add(Nivel);
      
      JLabel CI=new JLabel("-> Cedula:");
      CI.setForeground(Color.BLACK);
      CI.setBounds(20, 250, 100, 50);
      CI.setFont(new Font("Dyuthi",Font.ITALIC, 17));
      add(CI);
      
      //----------->>>>>>>>>Cajas de Texto<<<<<<<<<<<------------  
      txtUsu = new JTextField();
      txtUsu.setBounds(100, 65, 300, 20);
      add(txtUsu);
      
      txtMail = new JTextField();
      txtMail.setBounds(100, 110, 300, 20);
      add(txtMail);
      
      txtClv = new JTextField();
      txtClv.setBounds(100, 160, 140, 20);
      add(txtClv);
      
      txtCI = new JTextField();
      txtCI.setBounds(100, 260, 140, 20);
      add(txtCI);
      
      //----------->>>>>>>>>Lista Desplegable<<<<<<<<<<<------------
      String[] Niveles= {"Seleccione","1","2","3","4"};
      
      ListNivel=new JComboBox(Niveles);
      ListNivel.setBounds(100, 210, 140, 20);
      ListNivel.setSelectedItem("Seleccione"); //Selecciona el Primer Obj Mostrado
      add(ListNivel);
      
      //----------->>>>>>>>>Botones<<<<<<<<<<<------------
      BUsu = new JButton("Buscar CI");
      BUsu.setBounds(450, 250, 100, 30);
      BUsu.setEnabled(true);
      BUsu.addActionListener(this);
      add(BUsu);
      
      BGuardar = new JButton("Guardar");
      BGuardar.setBounds(30, 410, 100, 30);
      BGuardar.setEnabled(true);
      BGuardar.addActionListener(this);
      add(BGuardar);
      
      BModificar = new JButton("Modificar");
      BModificar.setBounds(170, 410, 100, 30);
      BModificar.setEnabled(true);
      BModificar.addActionListener(this);
      add(BModificar);
      
      BLimpiar = new JButton("Limpiar");
      BLimpiar.setBounds(320, 410, 100, 30);
      BLimpiar.setEnabled(true);
      BLimpiar.addActionListener(this);
      add(BLimpiar);
      
      BEliminar = new JButton("Eliminar");
      BEliminar.setBounds(490, 410, 100, 30);
      BEliminar.setEnabled(true);
      BEliminar.addActionListener(this);
      add(BEliminar);
      
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
       
    if (ae.getSource()==BUsu){
            JOptionPane.showMessageDialog(this,"Buscando... ");
            buscarUsuario();

        }
    if (ae.getSource()==BGuardar){
            JOptionPane.showMessageDialog(this,"Guardando... ");
            guardarUsuario();
            ListNivel.setSelectedItem("seleccione");
    
    }
    if (ae.getSource()==BModificar){
            JOptionPane.showMessageDialog(this,"Modificando... ");
            actualizarUsuario();
            
    }
    if (ae.getSource()==BLimpiar){
            JOptionPane.showMessageDialog(this,"Limpiando... ");
            LimpiarCajas();
            ListNivel.setSelectedItem("seleccione");
    }
    if (ae.getSource()==BEliminar){
            JOptionPane.showMessageDialog(this,"Eliminando... ");
            borrarUsuario();
    }
    

    }


    /* ====================================================================================
     *  
     *      acciones crud para usuario
     *
     * ====================================================================================*/


    // *****************  guardar usuario ***************
    private void guardarUsuario() {                                           
        Connection con = null;
    
        try{
            con = getConnection();
    
            ps = con.prepareStatement("INSERT INTO usuario (usuario,clave,cedula,correo,nivel) VALUES(?,?,?,?,?) ");
            ps.setString(1,txtUsu.getText());
            ps.setString(2,txtClv.getText());
            ps.setString(3,txtCI.getText());
            ps.setString(4,txtMail.getText());
            ps.setString(5,ListNivel.getSelectedItem().toString());
            
            int res =  ps.executeUpdate();
   
        if(res > 0){

          JOptionPane.showMessageDialog(null,"Usuario Registrado");
          LimpiarCajas();
        }else{

             JOptionPane.showMessageDialog(null,"Error al Registrar");
             LimpiarCajas();
        }

         con.close();

         }catch(SQLException e){    
           if (e.getErrorCode() == 1062){
                     JOptionPane.showMessageDialog (null, "¡Correo y Cedula ya existente!", "Campo Duplicado", 
                            JOptionPane.ERROR_MESSAGE);        
           } 
             else{
                 System.out.println("error " + e);   
               }  

         }

    }
    
    // ******************** buscar usuario ********************
    private void buscarUsuario() {                                          
       Connection con = null;
       
       try{
        con = getConnection();
        ps = con.prepareStatement("SELECT * FROM usuario WHERE cedula = ?");
        ps.setString(1,txtCI.getText());
        rs = ps.executeQuery();

        if(rs.first()){
            txtUsu.setText(rs.getString("usuario"));
            txtClv.setText(rs.getString("clave"));
            txtCI.setText(rs.getString("cedula"));
            txtMail.setText(rs.getString("correo"));
            ListNivel.setSelectedItem( Integer.toString(rs.getInt("nivel")));
            ID_user = rs.getInt("id_usuario");

        }else{
        JOptionPane.showMessageDialog(null,"Error,no existe un usuario con esa cedula");

        }
       }catch(Exception e){}
       
    }
    
    // *********************** actualizar usuario   ***************************
    private void actualizarUsuario() {                                             
       Connection con = null;
    
            try{
            con = getConnection();

            ps = con.prepareStatement("UPDATE usuario SET usuario=?, clave=?, cedula=?, correo=?, nivel=? WHERE id_usuario=?");
            ps.setString(1,txtUsu.getText());
            ps.setString(2,txtClv.getText());
            ps.setString(3,txtCI.getText());
            ps.setString(4,txtMail.getText());
            ps.setString(5,ListNivel.getSelectedItem().toString());
            ps.setString(6, Integer.toString(ID_user));
            
            int res =  ps.executeUpdate();

           if(res > 0){

             JOptionPane.showMessageDialog(null,"Usuario modificado");
             LimpiarCajas();
             ListNivel.setSelectedItem("seleccione");
           }else{

            JOptionPane.showMessageDialog(null,"Error al modificar");
             LimpiarCajas();
           }
           con.close();
            }catch(SQLException e){
               if(e.getErrorCode() == 1062){
               JOptionPane.showMessageDialog (null, "¡Correo y Usuario ya existente! ¡Coloca otra cosa!", "Campo Duplicado", JOptionPane.ERROR_MESSAGE);
               }else{
                 JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

               }
            }
    }
    
    // ************************  borrar datos  ***********************
    
    private void borrarUsuario() {                                            
         Connection con = null;
    
        try{
            con = getConnection();

            ps = con.prepareStatement("DELETE FROM usuario WHERE id_usuario=?");
            ps.setInt(1,ID_user );
           int res =  ps.executeUpdate();

           if(res > 0){
             JOptionPane.showMessageDialog(null,"Usuario eliminado");
             LimpiarCajas();
           }else{

            JOptionPane.showMessageDialog(null,"Error al eliminar");
             LimpiarCajas();
            }
       
           con.close();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    
    // limpiar campos
    void LimpiarCajas(){
            txtUsu.setText("");
            txtClv.setText("");
            txtMail.setText("");
            txtCI.setText("");
    }

}
