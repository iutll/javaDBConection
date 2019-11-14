
package Interfas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/*
 * @author jose-dasilva
 */
public class Persona extends JPanel implements ActionListener {
    
        //--------Atributos Globales----------
   private JButton BUsu,BGuardar,BModificar,BLimpiar,BEliminar;
   private JTextField txtUsu,txtMail,txtClv,txtCI;
   private JComboBox ListNivel;
   private JTextArea AreaImpr;
    //------------------------------------

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
    
      JLabel Usu=new JLabel("-> Nombre Completo:");
      Usu.setForeground(Color.BLACK);
      Usu.setBounds(20, 50, 150, 50);
      Usu.setFont(new Font("Dyuthi",Font.ITALIC, 17));
      add(Usu);
      
      JLabel Mail=new JLabel("-> E-Mail:");
      Mail.setForeground(Color.BLACK);
      Mail.setBounds(20, 80, 100, 50);
      Mail.setFont(new Font("Dyuthi",Font.ITALIC, 17));
      add(Mail);
      
      JLabel Clv=new JLabel("-> Clave:");
      Clv.setForeground(Color.BLACK);
      Clv.setBounds(350, 50, 100, 50);
      Clv.setFont(new Font("Dyuthi",Font.ITALIC, 17));
      add(Clv);
      
      JLabel Nivel=new JLabel("-> Nivel:");
      Nivel.setForeground(Color.BLACK);
      Nivel.setBounds(350, 80, 60, 50);
      Nivel.setFont(new Font("Dyuthi",Font.ITALIC, 17));
      add(Nivel);
      
      JLabel CI=new JLabel("-> Cedula:");
      CI.setForeground(Color.BLACK);
      CI.setBounds(20, 110, 100, 50);
      CI.setFont(new Font("Dyuthi",Font.ITALIC, 17));
      add(CI);
      
      //----------->>>>>>>>>Cajas de Texto<<<<<<<<<<<------------  
      txtUsu = new JTextField();
      txtUsu.setBounds(175, 65, 165, 20);
      add(txtUsu);
      
      txtMail = new JTextField();
      txtMail.setBounds(90, 95, 250, 20);
      add(txtMail);
      
      txtClv = new JTextField();
      txtClv.setBounds(420, 65, 140, 20);
      add(txtClv);
      
      txtCI = new JTextField();
      txtCI.setBounds(100, 125, 140, 20);
      add(txtCI);
      
      //----------->>>>>>>>>Lista Desplegable<<<<<<<<<<<------------
      String[] Niveles= {"Seleccione","1","2","3","4"};
      
      ListNivel=new JComboBox(Niveles);
      ListNivel.setBounds(420, 95, 140, 20);
      ListNivel.setSelectedItem("Seleccione"); //Selecciona el Primer Obj Mostrado
      add(ListNivel);
      
      //----------->>>>>>>>>Botones<<<<<<<<<<<------------
      BUsu = new JButton("Buscar");
      BUsu.setBounds(450, 120, 100, 30);
      BUsu.setEnabled(true);
      BUsu.addActionListener(this);
      add(BUsu);
      
      BGuardar = new JButton("Guardar");
      BGuardar.setBounds(10, 240, 100, 30);
      BGuardar.setEnabled(true);
      BGuardar.addActionListener(this);
      add(BGuardar);
      
      BModificar = new JButton("Modificar");
      BModificar.setBounds(10, 280, 100, 30);
      BModificar.setEnabled(true);
      BModificar.addActionListener(this);
      add(BModificar);
      
      BLimpiar = new JButton("Limpiar");
      BLimpiar.setBounds(10, 320, 100, 30);
      BLimpiar.setEnabled(true);
      BLimpiar.addActionListener(this);
      add(BLimpiar);
      
      BEliminar = new JButton("Eliminar");
      BEliminar.setBounds(10, 360, 100, 30);
      BEliminar.setEnabled(true);
      BEliminar.addActionListener(this);
      add(BEliminar);
      
      //----------->>>>>>>>>Area de Texto<<<<<<<<<<<------------
      AreaImpr=new JTextArea();
      AreaImpr.setBounds(120, 170, 500, 300);
      AreaImpr.setBackground(Color.LIGHT_GRAY);
      AreaImpr.setForeground(Color.BLACK);
      AreaImpr.setEditable(false);
      add(AreaImpr);
      
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
       
    if (ae.getSource()==BUsu){
            JOptionPane.showMessageDialog(this,"Buscando... ");
            AreaImpr.setText("\t\tResultado De Busqueda.... ");

        }
    if (ae.getSource()==BGuardar){
            JOptionPane.showMessageDialog(this,"Guardando... ");
            AreaImpr.setText(" ");
            txtUsu.setText(" ");
            txtClv.setText(" ");
            txtMail.setText(" ");
    
    }
    if (ae.getSource()==BModificar){
            JOptionPane.showMessageDialog(this,"Modificando... ");
            AreaImpr.setText(" ");
            
    }
    if (ae.getSource()==BLimpiar){
            JOptionPane.showMessageDialog(this,"Limpiando... ");
            ListNivel.setSelectedItem("Seleccione");
            AreaImpr.setText(" ");
            txtUsu.setText(" ");
            txtClv.setText(" ");
            txtMail.setText(" ");
            
    }
    if (ae.getSource()==BEliminar){
            JOptionPane.showMessageDialog(this,"Eliminando... ");
            AreaImpr.setText(" ");
            
    }
}}
