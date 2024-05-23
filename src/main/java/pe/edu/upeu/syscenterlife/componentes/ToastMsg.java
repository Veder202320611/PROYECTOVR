
package pe.edu.upeu.syscenterlife.componentes;



import pe.edu.upeu.syscenterlife.util.UtilsX;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;


public class ToastMsg extends javax.swing.JPanel {

    private static ImageIcon icono = null;
    private static ImageIcon iconoError = null;
    UtilsX obj = new UtilsX();

    /**
     * Creates new form ToastMsg
     */
    public ToastMsg() {
        initComponents();
        icono = new ImageIcon(obj.getFile("img/correcto.png"));
        iconoError = new ImageIcon(obj.getFile("img/error.png"));
        this.setOpaque(false);
    }

    public void error(String msgText) {
        error(msgText, false);
    }

    public void error(String msgText, boolean type) {
        msg.setText(msgText);
        msg.setForeground(new Color(255, 0, 0));
        if (type) {
            jLabel1.setIcon(iconoError);
            this.setBackground(Color.BLACK);
        } else {
            jLabel1.setIcon(icono);
            this.setBackground(Color.WHITE);
        }
    }

    public void mostarComponentes() {
        jLabel1.setVisible(true);
        msg.setVisible(true);
    }

    public void ocultarComponentes() {
        jLabel1.setVisible(false);
        msg.setVisible(false);
    }

    public void success(String msgText) {
        mostarComponentes();
        jLabel1.setIcon(icono);
        msg.setText(msgText);
        msg.setForeground(new Color(0, 0, 100));
        setOpaque(false);
        temporizador(2);
    }

    public void temporizador(int time) {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            int i = time;

            public void run() {
                i--;
                if (i < 0) {
                    timer.cancel();
                    ocultarComponentes();
                }
            }
        }, 0, 1000);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        msg = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(msg, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(msg, javax.swing.GroupLayout.DEFAULT_SIZE, 16, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel msg;
    // End of variables declaration//GEN-END:variables
}
