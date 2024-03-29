/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import Conexion.conexion;
import Control.GimnasioUsuarioControl;
import Control.talleresControl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author javie
 */
public class IniciarSesionUI extends javax.swing.JFrame {
    
    conexion con=new conexion();
    Connection cn =con.conectarBaseDatos();
    /**
     * Creates new form InciarSesionUI
    */
    public IniciarSesionUI() {
        initComponents();
        setTitle("Ingresar al Gimnasio");
        setResizable(false);
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Ingresar1 = new javax.swing.JTextPane();
        jLabel6 = new javax.swing.JLabel();
        Ingresar2 = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        jLabel4.setText("Correo electronico");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 130, -1));

        jScrollPane1.setBackground(new java.awt.Color(153, 153, 153));
        jScrollPane1.setViewportView(Ingresar1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 400, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        jLabel6.setText("Contraseña");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, 120, -1));
        getContentPane().add(Ingresar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 400, -1));

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Ingresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 240, 180, 50));

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Regresar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 240, 180, 50));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/trasparencia.png"))); // NOI18N
        jLabel3.setText("jLabel2");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 440, 260));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/trasparencia.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 500, 300));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/registro6.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String correoElectronico = Ingresar1.getText();
        String contrasena = Ingresar2.getText();

        try {
            // Verificar si el usuario es un cliente
            PreparedStatement psCliente = cn.prepareStatement("SELECT * FROM registroCliente WHERE Correo = ? AND Contraseña = ?");
            psCliente.setString(1, correoElectronico);
            psCliente.setString(2, contrasena);
            ResultSet rsCliente = psCliente.executeQuery();

            if (rsCliente.next()) {
                // El inicio de sesión es exitoso como cliente
                JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso");
                dispose();
                //
                 GimnasioUsuario vista = new GimnasioUsuario();
                GimnasioUsuarioControl controlador = new GimnasioUsuarioControl(vista);
            } else {
                // Si no es cliente, verificar si es un instructor
                PreparedStatement psInstructor = cn.prepareStatement("SELECT * FROM registroInstructor WHERE Correo = ? AND Contraseña = ?");
                psInstructor.setString(1, correoElectronico);
                psInstructor.setString(2, contrasena);
                ResultSet rsInstructor = psInstructor.executeQuery();

                if (rsInstructor.next()) {
                    // El inicio de sesión es exitoso como instructor
                    JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso");
                    dispose();
                    //
                    GimnasioInstructor vista = new GimnasioInstructor();
                    talleresControl controlador = new talleresControl(vista);
                } else {
                    // Si no es instructor, mostrar mensaje de error
                    JOptionPane.showMessageDialog(null, "Usuario o Contraseña Incorrecto");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR AL INICIAR SESION: " + e.getMessage());
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        dispose();
        new PantallaPrincipal().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane Ingresar1;
    private javax.swing.JPasswordField Ingresar2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
