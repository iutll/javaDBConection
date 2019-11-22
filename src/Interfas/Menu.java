//Programa Grafico Para Manejar Datos En la BDD.

package Interfas;
/*
 *@author Jose-DaSilva
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

 //Clase Ventana del Menu Con herencia de Login
public class Menu extends JPanel implements ActionListener {
    //Atributo
   public JButton BBusq_G,BMan_Usu,BMan_Publi,BMan_Pag,cerrar,credi; // Accion de Botones Principales
    
   //Metodo Constructor
   public Menu(){ 
       
      setLayout(null); //Desactivamos el diseño por Defecto del panel
      setBackground(Color.CYAN);//Agregamos Color Al Panel
      
      //Iniciamos los Componentes de Nuestra Ventana.  
    colocaretiquetas();
    colocarbotones();
   }
   
   //Metodo Para las Etiquetas 
   private void colocaretiquetas(){
   
            //Creamos Dos Etiqueta para nuestro Menu
      JLabel etiqueta =new JLabel("¡¡Maneje Ya Sus Datos!!", SwingConstants.CENTER); //Damos el Nombre y Ubicación 
      etiqueta.setForeground(Color.BLACK); //Damos color al Texto
      etiqueta.setBounds(170, 5, 250, 50); //Posicion X,Y y Ancho,Alto
      etiqueta.setFont(new Font("Dyuthi",Font.ITALIC, 20) ); //Establesemos la fuente del Texto
      add(etiqueta); //Agregamos etiqueta al panel
      
      JLabel BDD =new JLabel(new ImageIcon("database-icon.png"));
      BDD.setBounds(20,130,150,150);
      add(BDD);
      
      JLabel BDD0 =new JLabel(new ImageIcon("database-icon.png"));
      BDD0.setBounds(430,130,150,150);
      add(BDD0);
      }
   
   //Metodo de Botones
   private void colocarbotones() {
   
       //Creamos los Botones con su nombre
       BBusq_G = new JButton("Consultar"); 
       BMan_Usu = new JButton("Gestionar Usuarios"); 
       BMan_Publi = new JButton("Gestionar Publicaciones"); 
       BMan_Pag = new JButton("Gestionar Redes");
     
       credi = new JButton("Creditos");
       cerrar = new JButton("Salir");
       
       //Damos el Tamaño y Posicion (X,Y y Ancho,Alto)
       BBusq_G.setBounds(200, 120, 200, 30); 
       BMan_Usu.setBounds(200, 170, 200, 30); 
       BMan_Publi.setBounds(200, 220, 200, 30); 
       BMan_Pag.setBounds(200, 270, 200, 30); 
 
       credi.setBounds(170, 400, 100, 30);
       cerrar.setBounds(350, 400, 70, 30);
       
       //Color y Fuentes de Boton
       
       cerrar.setForeground(Color.BLACK); //de letra
       cerrar.setBackground(Color.RED); //del Boton
       cerrar.setFont(new Font("kavoon", Font.ITALIC, 15));//establecer fuente de letra
       
       credi.setForeground(Color.BLACK); //de letra
       credi.setBackground(Color.GREEN); //del Boton
       credi.setFont(new Font("kavoon", Font.ITALIC, 15));//establecer fuente de letra
       
       //habilitar o desabilitar botones
       BBusq_G.setEnabled(true);
       BMan_Usu.setEnabled(true);
       BMan_Publi.setEnabled(true);
       BMan_Pag.setEnabled(true);
  
       credi.setEnabled(true);
       cerrar.setEnabled(true);
       
       //agrego acciones a botones  
       BBusq_G.addActionListener(this);
       BMan_Usu.addActionListener(this);
       BMan_Publi.addActionListener(this);
       BMan_Pag.addActionListener(this);
   
       credi.addActionListener(this);
       cerrar.addActionListener(this);
       
       //Agregamos Botones al Panel
       add(BBusq_G); 
       add(BMan_Usu);
       add(BMan_Publi);
       add(BMan_Pag);
   
       add(credi);
       add(cerrar);
       
   }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Login L=new Login();    
        
        if (ae.getSource()==BBusq_G){ L.BG(L);  }
        
        if (ae.getSource()==BMan_Usu){ L.USU(L);}
        
        if (ae.getSource()==BMan_Publi){ L.PB(L);}
        
        if (ae.getSource()==BMan_Pag){ L.PG(L);}
        
        if (ae.getSource()==credi){
             JOptionPane.showMessageDialog(this,"--->>>Creditos<<<---"
       + "\n\n@José Angel Da Silva 27.541.303 \n@Edsel Rengifo 26.846.962");
        }
        
        if (ae.getSource()==cerrar){
        System.exit(0);
        }
    }

   
}