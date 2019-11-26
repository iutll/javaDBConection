//Ventana y Login para ingresar al Sistema.

/*
 *@author Jose-DaSilva
 */
package Interfas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Arrays;
import javax.swing.*;

//Creamos una Clase "Login" Y Hacemos que Herede Atributos
//y metodos "Frame"
public class Login extends JFrame implements ActionListener{
   
    //-------------------->>>>>>>Atributos Globales<<<<<<<<<--------------------------------
     private final JPanel panel; //Creamos un Paneles
     public static JScrollPane GrupoPaneles; //Contenedor de Paneles
     private final JButton acceder;
     private final JTextField usuari;
     private final JPasswordField clav;
     private final String u= "Admin", c= "Admin"; //Usuario-clave por Default
     private String usu,clv;
     private JMenuBar mb; // Una barra de Menu
     private JMenuItem Busq_G,Man_Usu,Man_Publi,Man_Pag,cred,exit,Principio; //Accion de Barra Menu
     private int intentos=0;
     private boolean v=false;
   public static final String URL = "jdbc:mysql://localhost:3306/Mini-Gestor";
   public static final String USERNAME = "root";
   public static final String PASSWORD = "";
        //-------------------->>>>>>>Instancias de Clases<<<<<<<<<--------------------------------
    public static Menu Mp =new Menu();
    public static Cons_General Cg=new Cons_General();
    public static Persona Usu=new Persona();
    public static Publicacion Publi=new Publicacion();
    public static Pagina Pag=new Pagina();
   PreparedStatement ps;
   ResultSet rs;
     
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

    
   //-------------------->>>>>>>Metodo Constructor<<<<<<<<<--------------------------------
   public Login(){

       //Ventana Loggin
      this.setSize(250, 250); //Estabrecemos su Tamaño
      setTitle("LOGIN"); //Nombre de la ventana
      setLocationRelativeTo(null); //Ejecuta la Ventana Justo en El centro de la Pantalla
      //getContentPane().setBackground(Color.gray); //Agregamos un Color a ventana
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      
      //Panel
      panel = new JPanel(); //Instanciamos Panel
      panel.setLayout(null); //Desactivamos el diseño por Defecto del panel
      panel.setBackground(Color.lightGray);//Agregamos Color Al Panel
      this.getContentPane().add(panel); //Añadimos nuestro panel a la ventana
      
      //Etiquetas
      JLabel etiqueta =new JLabel("¡¡¡BIENVENIDO!!!", SwingConstants.CENTER); //Damos el Nombre y Ubicación 
      etiqueta.setForeground(Color.MAGENTA); //Damos color al Texto
      etiqueta.setBounds(5, 5, 250, 20); //Posicion X,Y y Ancho,Alto
      etiqueta.setFont(new Font("Dyuthi",Font.ITALIC, 20) ); //Establesemos la fuente del Texto
      panel.add(etiqueta); //Agregamos etiqueta al panel
      
      JLabel indatos =new JLabel("Ingrese Usuario/Clave", SwingConstants.CENTER); //Damos el Nombre y Ubicación 
      indatos.setForeground(Color.BLACK); //Damos color al Texto
      indatos.setBounds(5, 20, 250, 20); //Posicion X,Y y Ancho,Alto
      indatos.setFont(new Font("Dyuthi",Font.ITALIC, 15) ); //Establesemos la fuente del Texto
      panel.add(indatos); //Agregamos etiqueta al panel
      
      JLabel usuario =new JLabel("Usuario", SwingConstants.CENTER); //Damos el Nombre y Ubicación 
      usuario.setForeground(Color.BLACK); //Damos color al Texto
      usuario.setBounds(0, 45, 250, 20); //Posicion X,Y y Ancho,Alto
      usuario.setFont(new Font("Dyuthi",Font.ITALIC, 15) ); //Establesemos la fuente del Texto
      panel.add(usuario); //Agregamos etiqueta al panel
      
      JLabel clave =new JLabel("Clave", SwingConstants.CENTER); //Damos el Nombre y Ubicación 
      clave.setForeground(Color.BLACK); //Damos color al Texto
      clave.setBounds(0, 100, 250, 20); //Posicion X,Y y Ancho,Alto
      clave.setFont(new Font("Dyuthi",Font.ITALIC, 15) ); //Establesemos la fuente del Texto
      panel.add(clave); //Agregamos etiqueta al panel
      
      //Botones
       acceder = new JButton("Acceder"); //creamos y nombramos
       acceder.setBounds(75, 180, 100, 25); //establecemos el lugar
       acceder.setForeground(Color.BLACK); //de letra
       acceder.setBackground(Color.GREEN); //del Boton
       acceder.setFont(new Font("kavoon", Font.BOLD, 15));//establecer fuente de letra
       acceder.addActionListener(this);
       panel.add(acceder); //colocamos boton en panel
       
       //Cajas de Texto
       usuari = new JTextField();
       usuari.setBounds(80, 70, 100, 20);
       panel.add(usuari);
       
       clav = new JPasswordField();
       clav.setBounds(80, 120, 100, 20);
       panel.add(clav);
       
    } 
   
   //-------------------->>>>>>> Metodo barra del Menu<<<<<<<<<--------------------------------
   private void colocarbarram(){
       JMenu menu1,menu2,menu3;
       
       mb= new JMenuBar(); //Instanciamos Barra Menu
       //mb.setLayout(null); //Desactivamos el diseño por Defecto de La Barra
       mb.setBackground(Color.orange);
       setJMenuBar(mb); //Añadimos nuestra Barra al Panel
       
       //Inicio
       menu1 = new JMenu("Inicio");
           mb.add(menu1);
           Principio=new JMenuItem("Menu Principal");
           //Principio.setBackground(Color.GREEN);
           Principio.addActionListener(this);
           menu1.add(Principio);
           menu1.add(new JSeparator());
           cred=new JMenuItem("Creditos");
           cred.setBackground(Color.GREEN);
           cred.addActionListener(this);
           menu1.add(cred);
           menu1.add(new JSeparator());
           exit = new JMenuItem("Salir");
           exit.setBackground(Color.RED);
           exit.addActionListener(this);
           menu1.add(exit);
           menu1.add(new JSeparator());
     
       //Consultas
       menu2 = new JMenu("Consultas");
       mb.add(menu2);
           Busq_G = new JMenuItem("Busqueda...");
           //exit.setBackground(Color.RED);
           Busq_G.addActionListener(this);
           menu2.add(Busq_G);
           menu2.add(new JSeparator());
       
       //Gestor de Datos
       menu3 = new JMenu("Gestor de Operaciones");
       mb.add(menu3);
            Man_Usu = new JMenuItem("Usuario");
            //exit.setBackground(Color.RED);
            Man_Usu.addActionListener(this);
            menu3.add(Man_Usu);
            menu3.add(new JSeparator());
            Man_Publi = new JMenuItem("Publicaciones");
            //exit.setBackground(Color.RED);
            Man_Publi.addActionListener(this);
            menu3.add(Man_Publi);
            menu3.add(new JSeparator());
            Man_Pag = new JMenuItem("Redes");
            //exit.setBackground(Color.RED);
            Man_Pag.addActionListener(this);
            menu3.add(Man_Pag);
            menu3.add(new JSeparator());
   }
   
   //-------------------->>>>>>>Metodo de Eventos de Acción<<<<<<<<<--------------------------------
    @Override
    public void actionPerformed(ActionEvent ae) {
        
       
  if (ae.getSource()==acceder){
           
         usu = usuari.getText();
         clv = clav.getText();
         clv = Arrays.toString(clav.getPassword());
            
      
    if(usu.equals("") && clv.equals("")){
        JOptionPane.showMessageDialog(this,"Usuario y/o Contraseña estan vacios\nIngrese los por favor.");
        intentos++; v=true;}
      
    else if(usu.equals("")){
        JOptionPane.showMessageDialog(this,"Usuario está vacio\nIngrese lo por favor.");
        intentos++; v=true;
        
    }else if(clv.equals("")){
        JOptionPane.showMessageDialog(this,"Contraseña está vacio\nIngrese lo por favor.");
        intentos++; v=true;
    
    }
    else if(ComprobarAcceso(usuari.getText(),clav.getText())){
      v=false;
        
      panel.setVisible(false);
      this.setSize(600, 500); //Estabrecemos su Tamaño de Ventana del Programa
      setTitle("Mini Gestor de Datos"); //Nombre de la ventana
      colocarbarram(); 
      //Configuro El Contenedor de Paneles
      GrupoPaneles=new JScrollPane();
      GrupoPaneles.setBounds(0, 0, 600, 500);
      GrupoPaneles.setVisible(false);
      this.add(GrupoPaneles);
      GrupoPaneles.setVisible(true);
      definirpaneles(Mp);
     
      } else {
        System.out.println("");
        JOptionPane.showMessageDialog(this,"Usuario y/o Contraseña no válidos\\nIngrese nuevamente.");
    
    }
    
    if (intentos==3 && v==true){ 
         JOptionPane.showMessageDialog(this,"Ha Superado el Limite de Intentos Fallidos(3/3).\nCerraremos Automaticamente Nuestro Sistema.");
        System.exit(0); }
    }

  //--------Acciones de Menu----------
       if (ae.getSource()==Principio){
            GrupoPaneles.setVisible(true);
            definirpaneles(Mp);
        }
            
        if (ae.getSource()==Busq_G){   BG(this);   }
        
        if (ae.getSource()==Man_Usu){  USU(this);  }
            
        if (ae.getSource()==Man_Publi){ PB(this);  }
        
        if (ae.getSource()==Man_Pag){ PG(this);    }
        
         if ((ae.getSource()==cred)||(ae.getSource()==Mp.credi)){
        JOptionPane.showMessageDialog(this,"--->>>Creditos<<<---"
       + "\n\n@José Angel Da Silva 27.541.303 \n@Edsel Rengifo 26.846.962");
        }
        
        if ((ae.getSource()==exit)||(ae.getSource()==Mp.cerrar)){
        System.exit(0);
        }
    }
    //Busqueda General
  public void BG(Login fr){  
      fr.GrupoPaneles.setVisible(true);
      fr.definirpaneles(Cg); 
  }
    //Registro Usuario
  public void USU(Login fr){  
      fr.GrupoPaneles.setVisible(true); 
      fr.definirpaneles(Usu); }
    //Registro Publicaciones
  public void PB(Login fr){   
      fr.GrupoPaneles.setVisible(true);
      fr.definirpaneles(Publi);
  }
    //Registro Pagina
  public void PG(Login fr){   
      fr.GrupoPaneles.setVisible(true); 
      fr.definirpaneles(Pag);  }
    
  //-------------------->>>>>>>Sobrecarga de Metodos<<<<<<<<<--------------------------------
    public void definirpaneles(Menu Mp){
    
        GrupoPaneles.setViewportView(Mp);
    }             
    public void definirpaneles(Cons_General Cg){
    
        GrupoPaneles.setViewportView(Cg);
    }
    public void definirpaneles(Persona Usu){
    
        GrupoPaneles.setViewportView(Usu);
    }
    public void definirpaneles(Publicacion Publi){
    
        GrupoPaneles.setViewportView(Publi);
    }
    public void definirpaneles(Pagina Pag){
    
        GrupoPaneles.setViewportView(Pag);
    }
    
    //Metodo para Comprobar Acceso de Usuario Administrador BDD
    private boolean ComprobarAcceso(String usu,String clv){
        Connection con = null;
       int sw=0;
        
        try{
            con = getConnection();
            ps = con.prepareStatement("SELECT * FROM usuario WHERE usuario='"+usu+"'and clave='"+clv+"'");
            rs = ps.executeQuery();
            while(rs.next()){
                if(rs.getString(1)==null) sw=0;
                else sw=1;
            
            }
        }catch(SQLException e){
        JOptionPane.showMessageDialog(null, "Error SQL"+e);
        
        } if(sw==1) return true;
        else return false;
    }
  
            //-------------------->>>>>>>Metodo Main<<<<<<<<<--------------------------------
    public static void main(String[] args) {
        Login L =new Login(); //Intanciamos la Clase Login
        L.setVisible(true); //Hacemos Visible su Ventana
    }
  }