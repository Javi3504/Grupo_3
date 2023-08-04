/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author javie
 */
public class RegisTaller extends javax.swing.JFrame {
    
    Conexion.conexion con = new Conexion.conexion();
    Connection cn = con.conectar();
    /**
     * Creates new form RegisTaller
     */
    public RegisTaller() {
        initComponents();
        setTitle("Gimnasio (Instructor)");
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

        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        Descripcion = new javax.swing.JTextField();
        nNivel = new javax.swing.JTextField();
        nDuracion = new javax.swing.JTextField();
        nInstructor = new javax.swing.JTextField();
        nZona = new javax.swing.JTextField();
        nHorario = new javax.swing.JTextField();
        nTaller = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setText("Volver");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 20, 100, 30));

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton1.setText("Registrar");
        jButton1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 500, 260, 70));

        Descripcion.setBorder(javax.swing.BorderFactory.createTitledBorder("Descripción"));
        jPanel1.add(Descripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 400, 880, 70));

        nNivel.setBorder(javax.swing.BorderFactory.createTitledBorder("Nivel"));
        jPanel1.add(nNivel, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 300, 300, 60));

        nDuracion.setBorder(javax.swing.BorderFactory.createTitledBorder("Duración"));
        jPanel1.add(nDuracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 200, 300, 60));

        nInstructor.setBorder(javax.swing.BorderFactory.createTitledBorder("Nombre del Instructor"));
        jPanel1.add(nInstructor, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 100, 300, 60));

        nZona.setBorder(javax.swing.BorderFactory.createTitledBorder("Zona"));
        jPanel1.add(nZona, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 300, 300, 60));

        nHorario.setBorder(javax.swing.BorderFactory.createTitledBorder("Horario del Taller"));
        jPanel1.add(nHorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, 300, 60));

        nTaller.setBorder(javax.swing.BorderFactory.createTitledBorder("Nombre del Taller"));
        jPanel1.add(nTaller, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 300, 60));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Deco1.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, 600));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String NombreTaller   = nTaller.getText();
        String Horario        = nHorario.getText();
        String Zona           = nZona.getText();
        String NombreInstruct = nInstructor.getText();
        String Duracion       = nDuracion.getText();
        String Nivel          = nNivel.getText();
        String Descrip        = Descripcion.getText();

        if (NombreTaller.isEmpty() || Horario.isEmpty() || Zona.isEmpty() || NombreInstruct.isEmpty() || Duracion.isEmpty() || Nivel.isEmpty() || Descrip.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error, Debe llenar todos los campos...");
        } else {
            try {
                String consulta = " insert into taller (nombreTaller, nombreInstructor, horarioTaller, duracion, zona, nivel, descripcion) values('" 
                        + NombreTaller + "', '" + NombreInstruct + "', '" + Horario + "', '" + Duracion + "', '" + Zona + "', '" + Nivel + "',  '" + Descrip + "' )";
                
                PreparedStatement ps = cn.prepareStatement(consulta);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Registro exitoso!");
                con.desconectar();
                
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "No Se Pudo Registrar En La Base...");
                e.printStackTrace();
            }
            
            dispose(); // Cerrar la ventana actual (registro)
            new GimnasioInstructor().setVisible(true);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        dispose(); // Cerrar la ventana actual (registro)
        new GimnasioInstructor().setVisible(true);

    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RegisTaller.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisTaller.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisTaller.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisTaller.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisTaller().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Descripcion;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nDuracion;
    private javax.swing.JTextField nHorario;
    private javax.swing.JTextField nInstructor;
    private javax.swing.JTextField nNivel;
    private javax.swing.JTextField nTaller;
    private javax.swing.JTextField nZona;
    // End of variables declaration//GEN-END:variables
}
