/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.primerproyecto.Interfaz;

import com.mycompany.primerproyecto.Funciones.Datos;
import com.mycompany.primerproyecto.Funciones.Funciones;

/**
 *
 * @author deyla
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form VentanaPrincipal
     */
    

    public VentanaPrincipal() {
        Funciones.cargarQuinielas();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtfUsuario = new javax.swing.JTextField();
        txtfNombre = new javax.swing.JTextField();
        txtfContraseña = new javax.swing.JTextField();
        btIngresar = new javax.swing.JButton();
        lbIngresaUsuario = new javax.swing.JLabel();
        lbIngresaNombre = new javax.swing.JLabel();
        lbIngresaContraseña = new javax.swing.JLabel();
        lbAdvertencia = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtfUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfUsuarioActionPerformed(evt);
            }
        });

        txtfNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfNombreActionPerformed(evt);
            }
        });

        btIngresar.setText("Ingresar");
        btIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIngresarActionPerformed(evt);
            }
        });

        lbIngresaUsuario.setText("Ingresa tu usuario");

        lbIngresaNombre.setText("Ingresa tu Nombre");

        lbIngresaContraseña.setText("Ingresa tu Contraseña");

        lbAdvertencia.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtfNombre)
                    .addComponent(lbIngresaUsuario)
                    .addComponent(txtfUsuario)
                    .addComponent(txtfContraseña)
                    .addComponent(lbIngresaNombre)
                    .addComponent(lbIngresaContraseña)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(btIngresar)))
                .addContainerGap(177, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(lbAdvertencia)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lbIngresaUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtfUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbIngresaNombre)
                .addGap(2, 2, 2)
                .addComponent(txtfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbIngresaContraseña)
                .addGap(1, 1, 1)
                .addComponent(txtfContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btIngresar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbAdvertencia)
                .addContainerGap(77, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIngresarActionPerformed
        if(txtfContraseña.getText().length() != 0 && txtfNombre.getText().length() != 0 && txtfUsuario.getText().length() != 0){
            int verificacion = Funciones.verificaUsuario(txtfUsuario.getText(),txtfNombre.getText(),txtfContraseña.getText());
            if(txtfContraseña.getText().equals("Admin") && txtfNombre.getText().equals("Admin") && txtfUsuario.getText().equals("Admin")){
                this.lbAdvertencia.setText("Ingresando como adminstrador");
                Datos.Admin = true;
                new VentanaAdmin().setVisible(true);
            }else if(verificacion >= 0){
                    this.lbAdvertencia.setText("Ingresando");
                    new VentanaQuiniela().setVisible(true);
                }else if(verificacion == -1){
                    this.lbAdvertencia.setText("Creando Usuario");
                    new VentanaQuiniela().setVisible(true);
                }else if(verificacion == -2){
                this.lbAdvertencia.setText("Datos Incorrectos");
            }
        }
        else{
            this.lbAdvertencia.setText("Porfavor llene todos los ");
            System.out.println("Porfavor llene todos los ");
        }
        

        
    }//GEN-LAST:event_btIngresarActionPerformed

    private void txtfNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfNombreActionPerformed

    private void txtfUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfUsuarioActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btIngresar;
    private javax.swing.JLabel lbAdvertencia;
    private javax.swing.JLabel lbIngresaContraseña;
    private javax.swing.JLabel lbIngresaNombre;
    private javax.swing.JLabel lbIngresaUsuario;
    private javax.swing.JTextField txtfContraseña;
    private javax.swing.JTextField txtfNombre;
    private javax.swing.JTextField txtfUsuario;
    // End of variables declaration//GEN-END:variables
}
