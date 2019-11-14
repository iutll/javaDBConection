/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniproyect;

import java.sql.Connection;
import java.net.URL;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.swing.JOptionPane;

/**
 *
 * @author Jhosen
 */
public class ConsultaGeneral extends javax.swing.JFrame {

    public static final String URL = "jdbc:mysql://localhost:3306/miniproyecto";
   public static final String USERNAME = "root";
   public static final String PASSWORD = "";
   PreparedStatement ps;
   ResultSet rs;
      public  Connection getConnection(){
          Connection con = null;
     try {
    
            Class.forName("com.mysql.jdbc.Driver");
             
            con=(Connection) DriverManager.getConnection(URL,USERNAME,PASSWORD);
              System.out.println("Conectado a la base de datos");
        } catch (Exception e) {
            System.err.println("Error:" + e);
        }
      
     return con;
    }
      
      
    public ConsultaGeneral() {
        initComponents();
        txtID.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        txtID = new javax.swing.JTextField();
        btnBuscarPublicacion = new javax.swing.JButton();
        btnbuscarPagina = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        AreaConsulta = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Tabla_usuario:");

        jLabel2.setText("Tabla_publicacion:");

        jLabel3.setText("tabla_pagina:");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        txtID.setEnabled(false);
        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });

        btnBuscarPublicacion.setText("buscar");
        btnBuscarPublicacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPublicacionActionPerformed(evt);
            }
        });

        btnbuscarPagina.setText("buscar");
        btnbuscarPagina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarPaginaActionPerformed(evt);
            }
        });

        AreaConsulta.setColumns(20);
        AreaConsulta.setRows(5);
        jScrollPane1.setViewportView(AreaConsulta);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscar))
                        .addGap(91, 91, 91)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBuscarPublicacion)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnbuscarPagina)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar)
                    .addComponent(btnbuscarPagina)
                    .addComponent(btnBuscarPublicacion))
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(197, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
       Connection con = null;
       
       try{
      con = getConnection();
      JOptionPane.showMessageDialog(null,"Ve la consola");
      ps = con.prepareStatement("SELECT * FROM usuario");
  
      rs = ps.executeQuery();
      
           System.out.println("Base de datos de usuario");
           System.out.println("");
           System.out.println("id" +" " + "usuario" +" "+ "clave" +" "+ "rango" +" "+ "email");
      while(rs.next()){
     System.out.println(rs.getInt("id_usuario") +" "  + rs.getString("Cedula") +" " + rs.getString("nombre_usuario") +" "+ rs.getString("clave_usuario") +" "+ rs.getInt("nivel_usuario") + " " + rs.getString("Email") + " " +rs.getString("enlace_facebook") + " " + rs.getString("enlace_instagram") + " " + rs.getString("enlace_twitter"));
 
      }
       }catch(Exception e){
       
       }
       
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnBuscarPublicacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPublicacionActionPerformed
        // TODO add your handling code here:
        Connection con = null;
       JOptionPane.showMessageDialog(null,"Ve la consola");
       try{
      con = getConnection();
      ps = con.prepareStatement("SELECT * FROM publicacion");
  
      rs = ps.executeQuery();
      
           System.out.println("Base de datos de Publicacion");
           System.out.println("");
           System.out.println("id_publicacion" +" "  + "Titulo" +" " + "Texto" +" " + "Fecha " +" "  );
      while(rs.next()){
        System.out.println(rs.getInt("id_publicacion") +" " + rs.getString("nombre_usuario") + rs.getString("publicacion_titulo") + rs.getString("publicacion_texto") +" " +rs.getDate("publicacion_fecha")  +" " + rs.getString("Cedula") );
      }
       }catch(Exception e){
       
       }
    }//GEN-LAST:event_btnBuscarPublicacionActionPerformed

    private void btnbuscarPaginaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarPaginaActionPerformed
    Connection con = null;
        JOptionPane.showMessageDialog(null,"Ve la consola");
       try{
      con = getConnection();
     
      ps = con.prepareStatement("SELECT * FROM pagina");
  
      rs = ps.executeQuery();
      
           System.out.println("Base de datos de pagina");
           System.out.println("");
           System.out.println("id_pagina" +" " + "footer" +" "+ "enlace facebook" +" "+ "enlace instagram" +" "+ "enlace_twitter" + " " + "parrafo_pagina" + " " + "archivo_encabezado" + " " + "Titulo_encabezado");
      while(rs.next()){
 System.out.println(rs.getInt("id_pagina") +" " +  rs.getString("footer_pagina") +" " + rs.getString("enlace_facebook") + rs.getString("enlace_instagram") + rs.getString("enlace_twitter") + rs.getString("parrafo_pagina") + rs.getString("archivo_encabezado") + rs.getString("titulo_encabezado") + rs.getString("Cedula") );
 
      }
       }catch(Exception e){
       
       }
       
    }//GEN-LAST:event_btnbuscarPaginaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
      
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ConsultaGeneral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultaGeneral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultaGeneral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultaGeneral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultaGeneral().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea AreaConsulta;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscarPublicacion;
    private javax.swing.JButton btnbuscarPagina;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtID;
    // End of variables declaration//GEN-END:variables
}