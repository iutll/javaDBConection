
package Interfas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * @author jose-dasilva
 */
public class Pagina extends JPanel implements ActionListener {
    
    //--------Atributos Globales----------
   private JButton BB,BAnadir,BGuardar,BModificar,BLimpiar,BEliminar;
   private JTextField txtBr,txtUsu,txtInst,txtFace,txtTwi;
   private JTextArea ACont;
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
      
      JLabel BP=new JLabel("C.I o Nombre", SwingConstants.CENTER);
      BP.setForeground(Color.BLACK);
      BP.setBounds(440, 30, 150, 40);
      BP.setFont(new Font("Dyuthi",Font.ITALIC, 16));
      add(BP);
      
      JLabel Usuario=new JLabel("Usuario:", SwingConstants.CENTER);
      Usuario.setForeground(Color.BLACK);
      Usuario.setBounds(0, 90, 100, 40);
      Usuario.setFont(new Font("Dyuthi",Font.ITALIC, 18));
      add(Usuario);
      
      JLabel Face =new JLabel(new ImageIcon("facebook.png"));
      Face.setBounds(10,150,50,50);
      add(Face);
      
      JLabel Inst =new JLabel(new ImageIcon("Instagram.png"));
      Inst.setBounds(10,210,50,50);
      add(Inst);
      
      JLabel Twit =new JLabel(new ImageIcon("twitter.png"));
      Twit.setBounds(10,270,50,50);
      add(Twit);
      
      //----------->>>>>>>>>Cajas de Texto<<<<<<<<<<<------------ 
      txtBr = new JTextField();
      txtBr.setBounds(450, 60, 130, 20);
      add(txtBr);
      
      txtUsu = new JTextField();
      txtUsu.setBounds(90, 95, 315, 20);
      txtUsu.setEditable(false);
      add(txtUsu);
      
      txtFace = new JTextField();
      txtFace.setBounds(90, 160, 315, 30);
      txtFace.setEditable(false);
      add(txtFace);
      
      txtInst = new JTextField();
      txtInst.setBounds(90, 220, 315, 30);
      txtInst.setEditable(false);
      add(txtInst);
      
      txtTwi = new JTextField();
      txtTwi.setBounds(90, 280, 315, 30);
      txtTwi.setEditable(false);
      add(txtTwi);
    
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
      BEliminar.setBounds(490, 410, 100, 30);
      BEliminar.setEnabled(true);
      BEliminar.addActionListener(this);
      add(BEliminar);
      
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
    
        if (ae.getSource()==BB){
           JOptionPane.showMessageDialog(this,"Encontrando Resultados... "+txtBr.getText());

       }
       
       if (ae.getSource()==BAnadir){
            JOptionPane.showMessageDialog(this,"Agrega tus Datos... ");

            
       }
       
       if (ae.getSource()==BGuardar){
            JOptionPane.showMessageDialog(this,"Guardando... ");           
    
        }
        if (ae.getSource()==BModificar){
            JOptionPane.showMessageDialog(this,"Modifica la Publicación... ");

       
        }
        if (ae.getSource()==BLimpiar){
            JOptionPane.showMessageDialog(this,"Limpiando... ");

            
        }
        if (ae.getSource()==BEliminar){
            JOptionPane.showMessageDialog(this,"Eliminando... ");

        }
    
    }
    
}
