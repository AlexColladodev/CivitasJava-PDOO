/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import civitas.Jugador;

public class JugadorPanel extends javax.swing.JPanel {

    /**
     * Creates new form JugadorPanel
     */
    
    private Jugador jugador;
    
    public void setJugador(Jugador jugador){
        this.jugador = jugador;
        
        this.especuladorTextField.setText(this.jugador.getEspeculador());
        this.nombreTextField.setText(this.jugador.getNombre());
        this.saldoTextField.setText(this.jugador.getSaldoTexto());
        
        //Verificar si debo poner algun if necesario aqui
        this.repaint();
        this.revalidate();
    }
    
    public JugadorPanel() {
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

        nombreLabel = new javax.swing.JLabel();
        nombreTextField = new javax.swing.JTextField();
        saldoLabel = new javax.swing.JLabel();
        saldoTextField = new javax.swing.JTextField();
        especuladorLabel = new javax.swing.JLabel();
        especuladorTextField = new javax.swing.JTextField();

        nombreLabel.setText("Nombre:");
        add(nombreLabel);

        nombreTextField.setEditable(false);
        nombreTextField.setText("jTextField1");
        nombreTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreTextFieldActionPerformed(evt);
            }
        });
        add(nombreTextField);

        saldoLabel.setText("Saldo:");
        add(saldoLabel);

        saldoTextField.setEditable(false);
        saldoTextField.setText("jTextField2");
        add(saldoTextField);

        especuladorLabel.setText("Especulador:");
        add(especuladorLabel);

        especuladorTextField.setEditable(false);
        especuladorTextField.setText("jTextField3");
        add(especuladorTextField);
    }// </editor-fold>//GEN-END:initComponents

    private void nombreTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreTextFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel especuladorLabel;
    private javax.swing.JTextField especuladorTextField;
    private javax.swing.JLabel nombreLabel;
    private javax.swing.JTextField nombreTextField;
    private javax.swing.JLabel saldoLabel;
    private javax.swing.JTextField saldoTextField;
    // End of variables declaration//GEN-END:variables
}
