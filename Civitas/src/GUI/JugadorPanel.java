/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import civitas.CasillaCalle;
import civitas.Jugador;
import java.util.ArrayList;

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
        
        //Punto 4 del punto 4
        this.rellenaPropiedades(this.jugador.getPropiedades());
        
        //Verificar si debo poner algun if necesario aqui
        this.repaint();
        this.revalidate();
    }
    
    private void rellenaPropiedades(ArrayList<CasillaCalle> lista){
        //Se elimina info antigua
        this.panelPropiedades.removeAll();
        
        //Se recorre la lista de propeidades para ir creando cada una de sus vistas
        for(CasillaCalle t: lista){
            PropiedadPanel vistaPropiedad = new PropiedadPanel();
            vistaPropiedad.setPropiedad(t);
            
            this.panelPropiedades.add(vistaPropiedad);
            vistaPropiedad.setVisible(true);
        }
        
        //Se fuerza a la actualizacion visual del panel propiedades del panel jugador
        this.repaint();
        this.revalidate();
    }
    
    /**
     * Creates new form JugadorPanel
     */
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

        jLabel1 = new javax.swing.JLabel();
        nombreLabel = new javax.swing.JLabel();
        saldoLabel = new javax.swing.JLabel();
        especuladorLabel = new javax.swing.JLabel();
        nombreTextField = new javax.swing.JTextField();
        saldoTextField = new javax.swing.JTextField();
        especuladorTextField = new javax.swing.JTextField();
        panelPropiedades = new javax.swing.JPanel();

        jLabel1.setText("JUGADOR");

        nombreLabel.setText("Nombre:");

        saldoLabel.setText("Saldo:");

        especuladorLabel.setText("Especulador:");

        nombreTextField.setEditable(false);
        nombreTextField.setText("jTextField1");

        saldoTextField.setEditable(false);
        saldoTextField.setText("jTextField2");

        especuladorTextField.setEditable(false);
        especuladorTextField.setText("jTextField3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(especuladorLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(especuladorTextField))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(nombreLabel)
                                .addComponent(saldoLabel))
                            .addGap(43, 43, 43)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(nombreTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                                .addComponent(saldoTextField))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jLabel1)))
                .addGap(28, 28, 28)
                .addComponent(panelPropiedades, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelPropiedades, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nombreLabel)
                            .addComponent(nombreTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(saldoLabel)
                            .addComponent(saldoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(especuladorLabel)
                            .addComponent(especuladorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 5, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel especuladorLabel;
    private javax.swing.JTextField especuladorTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel nombreLabel;
    private javax.swing.JTextField nombreTextField;
    private javax.swing.JPanel panelPropiedades;
    private javax.swing.JLabel saldoLabel;
    private javax.swing.JTextField saldoTextField;
    // End of variables declaration//GEN-END:variables
}
