/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ub.prog2.OrdonezVivancosHector.vista;

import edu.ub.prog2.OrdonezVivancosHector.controlador.CtrlVisorUB;
import edu.ub.prog2.OrdonezVivancosHector.model.FitxerImatge;
import edu.ub.prog2.utils.model.IFitxer;
import java.io.File;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;
import javax.swing.JFileChooser;

/**
 *
 * @author Héctor Ordóñez
 */
public class FrmAfegirFitxer extends javax.swing.JDialog {
    CtrlVisorUB controlador;
    /**
     * Constructor de FrmAfegirFitxer
     */
    public FrmAfegirFitxer(java.awt.Frame parent, boolean modal, CtrlVisorUB control) {
        super(parent, modal);
        controlador = control;
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

        jLabel1 = new javax.swing.JLabel();
        txtCami = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnSelecciona = new javax.swing.JButton();
        txtAutor = new javax.swing.JTextField();
        txtLongitud = new javax.swing.JTextField();
        jComboTipus = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtLatitud = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtResolucio = new javax.swing.JTextField();
        btnAccepta = new javax.swing.JButton();
        btnCancela = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(20, 201, 108));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Afegir Imatge a la Biblioteca");

        txtCami.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCamiActionPerformed(evt);
            }
        });

        jLabel2.setText("Selecciona la Imatge a afegir:");

        btnSelecciona.setText("Selecciona");
        btnSelecciona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionaActionPerformed(evt);
            }
        });

        txtLongitud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLongitudActionPerformed(evt);
            }
        });

        jComboTipus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ASCII", "BINARY" }));
        jComboTipus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboTipusActionPerformed(evt);
            }
        });

        jLabel3.setText("Tipus de Fitxer:");

        jLabel4.setText("Autor:");

        jLabel5.setText("Longitud:");

        jLabel6.setText("Latitud:");

        jLabel7.setText("Resolució:");

        btnAccepta.setText("Accepta");
        btnAccepta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcceptaActionPerformed(evt);
            }
        });

        btnCancela.setText("Cancel·la");
        btnCancela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtCami, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSelecciona))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel6))))
                                .addGap(16, 16, 16)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jComboTipus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 138, Short.MAX_VALUE))
                                    .addComponent(txtLongitud)
                                    .addComponent(txtLatitud)
                                    .addComponent(txtResolucio)
                                    .addComponent(txtAutor)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(btnAccepta, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancela, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCami, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSelecciona))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboTipus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLongitud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtLatitud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtResolucio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAccepta)
                    .addComponent(btnCancela))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
                         /**
    * Action Performed del boto que serveix per seleccionar el cami amb un FileChooser
    * 
    */
    private void btnSeleccionaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionaActionPerformed
        File fitxer;
        //Creació del selector de fitxer
        JFileChooser seleccio = new JFileChooser();
        //Mostrem la finestra de dialeg
        //Resultat emmagazema una constant que indica si s’ha
        //seleccionat o no un fitxer
        int resultat = seleccio.showOpenDialog(this);
        //Assegurem que hi hagi un fitxer seleccionat
        if (resultat == JFileChooser.APPROVE_OPTION) {
        //Obtenim el fitxer
        fitxer=seleccio.getSelectedFile();
        //Posem la ruta del fitxer al quadre de text
        txtCami.setText(fitxer.toString());
        }
    }//GEN-LAST:event_btnSeleccionaActionPerformed
                         /**
    * Action Performed del TextField on s'introdueix el cami
    * 
    */
    private void txtCamiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCamiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCamiActionPerformed
                         /**
    * Action Performed del Boto Accepta que guarda tot el que hi ha en els textField i en el combobox en un nou fitxer
    * 
    */
    private void btnAcceptaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcceptaActionPerformed

        File file  = new File(txtCami.getText());
        FitxerImatge fitxer = new FitxerImatge(file);
        IFitxer.FileType tipus = null;
        fitxer.setDataInsercio(Calendar.getInstance().getTime());         
        //Actualitza les dades del fitxer
        if ( (String)jComboTipus.getSelectedItem() == "ASCII"){
            fitxer.setTipus(tipus.ASCII);
        }
        else{
            fitxer.setTipus(tipus.BINARY);
        }
        fitxer.setAutor(txtAutor.getText());
        boolean comproAutor = false;
        boolean comproPos = false;
        boolean comproResol = false;
        try{
            fitxer.setAutor(txtAutor.getText());
            comproAutor = true;
            try{
                fitxer.setPosicio(Double.valueOf(txtLatitud.getText()).doubleValue(),Double.valueOf(txtLongitud.getText()).doubleValue());
                comproPos = true;
                    try{
                        fitxer.setResolucio(Double.valueOf(txtResolucio.getText()).doubleValue());
                        comproResol = true;
                    } catch (Exception ex){
                        txtResolucio.setEnabled(true);
                        txtResolucio.setText("");
                        txtLatitud.setEnabled(false);
                        txtLongitud.setEnabled(false);
                        txtAutor.setEnabled(false);
                        txtCami.setEnabled(false);
                        jComboTipus.setEnabled(false);
                        btnSelecciona.setEnabled(false);
                    }
            } catch (Exception ex){
                txtLatitud.setEnabled(true);
                txtLongitud.setEnabled(true);
                txtLatitud.setText("");
                txtLongitud.setText("");
                txtCami.setEnabled(false);
                txtAutor.setEnabled(false);
                txtResolucio.setEnabled(false);
                jComboTipus.setEnabled(false);
                btnSelecciona.setEnabled(false);
            }
            } catch (Exception ex){
                        txtResolucio.setEnabled(false);
                        txtResolucio.setEnabled(false);
                        txtLatitud.setEnabled(false);
                        txtLongitud.setEnabled(false);
                        txtAutor.setText("");
                        txtCami.setEnabled(false);
                        jComboTipus.setEnabled(false);
                        btnSelecciona.setEnabled(false);
                    }
            if(comproPos && comproResol && comproAutor){
                controlador.addFitxer(fitxer);
                this.dispose();
            }
    }//GEN-LAST:event_btnAcceptaActionPerformed
                         /**
    * Action Performed del boto Cancela que tanca la finestra
    * 
    */
    private void btnCancelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelaActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelaActionPerformed
                         /**
    * Action Performed del TextField on s'introdueix la Longitud
    * 
    */
    private void txtLongitudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLongitudActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLongitudActionPerformed
                         /**
    * Action Performed del JComboBox que s'utilitza per escollir el tipus de fitxer
    * 
    */
    private void jComboTipusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboTipusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboTipusActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAccepta;
    private javax.swing.JButton btnCancela;
    private javax.swing.JButton btnSelecciona;
    private javax.swing.JComboBox jComboTipus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField txtAutor;
    private javax.swing.JTextField txtCami;
    private javax.swing.JTextField txtLatitud;
    private javax.swing.JTextField txtLongitud;
    private javax.swing.JTextField txtResolucio;
    // End of variables declaration//GEN-END:variables
}
