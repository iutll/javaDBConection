//Programa Grafico Para Manejar Datos En la BDD.
//Login para ingresar al Sistema.

/*
 *@author Jose-DaSilva
 *@author Edsel Rengifo
 */
package miniproyect;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

//Creamos una Clase "Login" Y Hacemos que Herede Atributos
//y metodos "Frame"
public class Login extends JFrame {
    //Atributos
     private final JPanel panel1; //Creamos un Paneles
     private final String u= "Admin"; //Usuario por Default
     private final String c= "Admin"; //Clave Por Default
     private String usu;
     private String clv;
     private int intentos=0;
     private boolean v=false;
     private Ventana v1;
    
    //Metodo Constructor
   public Login(){
    
        //Ventana Loggin
        this.setSize(250, 250); //Estabrecemos su Tamaño
      setTitle("LOGIN"); //Nombre de la ventana
      setLocationRelativeTo(null); //Ejecuta la Ventana Justo en El centro de la Pantalla
      //getContentPane().setBackground(Color.gray); //Agregamos un Color a ventana
        
      //Panel de Loggin
      panel1 = new JPanel(); //Instanciamos Panel
      panel1.setLayout(null); //Desactivamos el diseño por Defecto del panel
      panel1.setBackground(Color.lightGray);//Agregamos Color Al Panel
      this.getContentPane().add(panel1); //Añadimos nuestro panel a la ventana
      
      //Creamos Etiqueta de Nuestro Loggin
      JLabel etiqueta =new JLabel("¡¡¡BIENVENIDO!!!", SwingConstants.CENTER); //Damos el Nombre y Ubicación 
      etiqueta.setForeground(Color.MAGENTA); //Damos color al Texto
      etiqueta.setBounds(5, 5, 250, 20); //Posicion X,Y y Ancho,Alto
      etiqueta.setFont(new Font("Dyuthi",Font.ITALIC, 20) ); //Establesemos la fuente del Texto
      panel1.add(etiqueta); //Agregamos etiqueta al panel
      
      JLabel indatos =new JLabel("Ingrese Usuario/Clave", SwingConstants.CENTER); //Damos el Nombre y Ubicación 
      indatos.setForeground(Color.BLACK); //Damos color al Texto
      indatos.setBounds(5, 20, 250, 20); //Posicion X,Y y Ancho,Alto
      indatos.setFont(new Font("Dyuthi",Font.ITALIC, 15) ); //Establesemos la fuente del Texto
      panel1.add(indatos); //Agregamos etiqueta al panel
      
      JLabel usuario =new JLabel("Usuario", SwingConstants.CENTER); //Damos el Nombre y Ubicación 
      usuario.setForeground(Color.BLACK); //Damos color al Texto
      usuario.setBounds(0, 45, 250, 20); //Posicion X,Y y Ancho,Alto
      usuario.setFont(new Font("Dyuthi",Font.ITALIC, 15) ); //Establesemos la fuente del Texto
      panel1.add(usuario); //Agregamos etiqueta al panel
      
      JLabel clave =new JLabel("Clave", SwingConstants.CENTER); //Damos el Nombre y Ubicación 
      clave.setForeground(Color.BLACK); //Damos color al Texto
      clave.setBounds(0, 100, 250, 20); //Posicion X,Y y Ancho,Alto
      clave.setFont(new Font("Dyuthi",Font.ITALIC, 15) ); //Establesemos la fuente del Texto
      panel1.add(clave); //Agregamos etiqueta al panel
      
      //Creamos los Botones
       JButton acceder = new JButton("Acceder"); //creamos y nombramos
       acceder.setBounds(75, 180, 100, 25); //establecemos el lugar
       acceder.setForeground(Color.BLACK); //de letra
       acceder.setBackground(Color.GREEN); //del Boton
       acceder.setFont(new Font("kavoon", Font.BOLD, 15));//establecer fuente de letra
       panel1.add(acceder); //colocamos boton en panel
       
       // Caja de Texto
       JTextField usuari = new JTextField();
       usuari.setBounds(80, 70, 100, 20);
       panel1.add(usuari);
       
       JTextField clav = new JTextField();
       clav.setBounds(80, 120, 100, 20);
       panel1.add(clav);
      
       //Accion del Boton
       ActionListener Ac =(ActionEvent ae) -> {
         
         usu = usuari.getText();
         clv = clav.getText();
         
    if(u.equals(usu) && c.equals(clv)){
        v=false;
        setExtendedState(ICONIFIED); // Minimisa Ventana
        Ventana Vp =new Ventana();
      Vp.setVisible(true);
    
    }else if(usu.equals("") && clv.equals("")){
        JOptionPane.showMessageDialog(this,"Usuario y/o Contraseña estan vacios\nIngrese los por favor.");
        intentos++; v=true;
        
    }else if(usu.equals("")){
        JOptionPane.showMessageDialog(this,"Usuario está vacio\nIngrese lo por favor.");
        intentos++; v=true;
        
    }else if(clv.equals("")){
        JOptionPane.showMessageDialog(this,"Contraseña está vacio\nIngrese lo por favor.");
        intentos++; v=true;
        
    }else if(usu.compareTo(u)!=0 && clv.compareTo(c)!=0){
        JOptionPane.showMessageDialog(this,"Usuario y/o Contraseña no válidos\nIngrese nuevamente.");
        intentos++; v=true;

    }else if(usu.compareTo(u)!=0){
        JOptionPane.showMessageDialog(this,"Usuario no válido\nIngrese nuevamente.");
        intentos++; v=true;
        
    }else if(clv.compareTo(c)!=0){
        JOptionPane.showMessageDialog(this,"Contraseña no válida\nIngrese nuevamente."); 
        intentos++; v=true; }
         
    if (intentos==3 && v==true){ 
         JOptionPane.showMessageDialog(this,"Ha Superado el Limite de Intentos Fallidos(3/3).\nCerraremos Automaticamente Nuestro Sistema.");
        System.exit(0); }
      
       };
       acceder.addActionListener(Ac);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

   //Clase Ventana del Menu Con herencia de Login
public class Ventana extends Login{
    //Atributo
    private JPanel panel; //Creamos un Paneles
    public int opc; //variable Opcion del Menu
   
   //Metodo Constructor
   public Ventana(){ 
       
       //Ventana Menu
      this.setSize(400, 500); //Estabrecemos su Tamaño
      setTitle("Mini-Proyecto Paragdima"); //Nombre de la ventana
      setLocationRelativeTo(null); //Ejecuta la Ventana Justo en El centro de la Pantalla
      //getContentPane().setBackground(Color.gray); //Agregamos un Color a ventana
      
      //Iniciamos los Componentes de Nuestra Ventana del Menu.
    colocarpaneles();
    colocaretiquetas();
    colocarbotones();
      
     setDefaultCloseOperation(EXIT_ON_CLOSE); //Permite Cerrar ventana y Programa
   }
   
   //Metodo de Paneles
   private void colocarpaneles(){
       
   panel = new JPanel(); //Instanciamos Panel
      panel.setLayout(null); //Desactivamos el diseño por Defecto del panel
      panel.setBackground(Color.CYAN);//Agregamos Color Al Panel
      this.getContentPane().add(panel); //Añadimos nuestro panel a la ventana
   }
   
   //Metodo Para las Etiquetas 
   private void colocaretiquetas(){
   
            //Creamos Dos Etiqueta para nuestro Menu
      JLabel etiqueta =new JLabel("¡¡Maneje Ya Sus Datos!!", SwingConstants.CENTER); //Damos el Nombre y Ubicación 
      etiqueta.setForeground(Color.BLACK); //Damos color al Texto
      etiqueta.setBounds(80, 5, 250, 50); //Posicion X,Y y Ancho,Alto
      etiqueta.setFont(new Font("Dyuthi",Font.ITALIC, 20) ); //Establesemos la fuente del Texto
      panel.add(etiqueta); //Agregamos etiqueta al panel
      }
   
   //Metodo de Botones
   private void colocarbotones() {
   
       //Creamos los Botones
       JButton boton1 = new JButton("Consulta General"); 
       JButton  boton2 = new JButton("Operaciones Basicas (Usuario)"); 
       JButton boton3 = new JButton("Operaciones Basicas (Publicacion)"); 
       JButton boton4 = new JButton("Operaciones Basicas (Pagina)");
     
      JButton credi = new JButton("Creditos");
       JButton cerrar = new JButton("Salir");
       
       //Damos el Tamaño 
       boton1.setBounds(110, 120, 190, 30); 
       boton2.setBounds(110, 170, 190, 30); 
       boton3.setBounds(110, 220, 190, 30); 
       boton4.setBounds(110, 270, 190, 30); 
 
       credi.setBounds(110, 400, 100, 30);
       cerrar.setBounds(220, 400, 70, 30);
       
       //Color y Fuentes de Boton
       
       cerrar.setForeground(Color.BLACK); //de letra
       cerrar.setBackground(Color.RED); //del Boton
       cerrar.setFont(new Font("kavoon", Font.ITALIC, 15));//establecer fuente de letra
       
       credi.setForeground(Color.BLACK); //de letra
       credi.setBackground(Color.GREEN); //del Boton
       credi.setFont(new Font("kavoon", Font.ITALIC, 15));//establecer fuente de letra
       
       //habilitar o desabilitar botones
       boton1.setEnabled(true);
       boton2.setEnabled(true);
       boton3.setEnabled(true);
       boton4.setEnabled(true);
  
       credi.setEnabled(true);
       cerrar.setEnabled(true);
       
       //Agregamos Botones al Panel
       panel.add(boton1); 
       panel.add(boton2);
       panel.add(boton3);
       panel.add(boton4);
   
       panel.add(credi);
       panel.add(cerrar);
       
       //agregamos Evento para Accion de Botones
       ActionListener ODABoton1 = (ActionEvent ae) -> {
    ConsultaGeneral llamado = new ConsultaGeneral();
    llamado.setVisible(true);
       };
       
       ActionListener ODABoton2 = (ActionEvent ae) -> {
      
       persona llamado = new persona();
       llamado.setVisible(true);
       };

       ActionListener ODABoton3 = (ActionEvent ae) -> {
           publicacion llamado = new publicacion();
           llamado.setVisible(true);
       };
       
       ActionListener ODABoton4 = (ActionEvent ae) -> {
        pagina llamado = new pagina();
        llamado.setVisible(true);
       };
       
       ActionListener ODABoton5 = (ActionEvent ae) -> {
          
       };
    
       ActionListener ODAcredit = (ActionEvent ae) -> {
       JOptionPane.showMessageDialog(this,"--->>>Creditos<<<---"
       + "\n\n@José Angel Da Silva 27.541.303 \n@Edsel Rengifo 26.846.962");
       };
       
       ActionListener ODAexit = (ActionEvent ae) -> {
           
           System.exit(0);
       };
       
       //agrego acciones a botones  
       boton1.addActionListener(ODABoton1);
       boton2.addActionListener(ODABoton2);
       boton3.addActionListener(ODABoton3);
       boton4.addActionListener(ODABoton4);
   
       credi.addActionListener(ODAcredit);
       cerrar.addActionListener(ODAexit);
   }}      

    //Metodo Main
    public static void main(String[] args) {
        Login Vp =new Login(); //Intanciamos la Clase Login
    Vp.setVisible(true); //Hacemos Visible su Ventana
    }
    
}