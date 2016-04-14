/*
 * The MIT License
 *
 * Copyright 2015 Nicky.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package tinyp2p;

import java.awt.Rectangle;
import org.hive2hive.core.api.interfaces.IH2HNode;

/**
 *
 * @author Nicky
 */
public class ConnectInternal extends javax.swing.JFrame {
    private String[] ips;
    private IH2HNode node;
    
    /**
     * Creates new form ConnectInternal
     */
    
    public ConnectInternal( ) {
        initComponents();
    }
    
    public ConnectInternal(Rectangle bounds, String ips[]) {
        this.ips = ips;
        initComponents();
        this.setBounds(bounds);
        //this.setSize(504, 321);
        tinyButt.setOpaque(false);
        tinyButt.setContentAreaFilled(false); //to make the content area transparent
        tinyButt.setBorderPainted(false);
    }
    
     private void toLogin(){
        ChooseUsername lm = new ChooseUsername(node,this.getBounds(),ips);
        lm.setVisible(true);
        this.dispose();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel15 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        tinyButt = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        help = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        jLabel15.setText("IP:");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 270, 20, 10));

        jLabel3.setText("With this address you can still connect with peers on your local network, ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, -1, -1));

        jLabel5.setText("Internal Mnemonic: ");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, 150, -1));

        jTextField1.setEditable(false);
        jTextField1.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 240, 140, 30));

        jButton1.setBackground(new java.awt.Color(255, 224, 193));
        jButton1.setText("OK");
        jButton1.setMargin(new java.awt.Insets(2, 10, 2, 10));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 310, 70, 30));

        tinyButt.setBackground(new java.awt.Color(204, 255, 204));
        tinyButt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/tinyhelp.png"))); // NOI18N
        tinyButt.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tinyButt.setMaximumSize(new java.awt.Dimension(33, 53));
        tinyButt.setMinimumSize(new java.awt.Dimension(33, 53));
        tinyButt.setPreferredSize(new java.awt.Dimension(33, 53));
        tinyButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tinyButtActionPerformed(evt);
            }
        });
        getContentPane().add(tinyButt, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 10, 40, 60));

        jLabel6.setText("them with your internal Mnemonic.");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, -1, -1));

        help.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        help.setForeground(new java.awt.Color(0, 51, 204));
        help.setText(" ? ");
        help.setToolTipText("<html>Some routers do network address translation (NAT).  </br>Your external IP is what is seen by the outside world, your internal IP is used to identify you among others in your network.</html>");
        help.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 51)));
        getContentPane().add(help, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 130, -1, -1));

        jLabel8.setText("If you are on the same home or office network as your peer, you may need to provide");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, -1, -1));

        jLabel2.setText("even if your internet connection is down. ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, -1, -1));

        jLabel10.setFont(new java.awt.Font("Courier New", 0, 9)); // NOI18N
        jLabel10.setText("jLabel8");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 270, 100, 10));

        jLabel7.setFont(new java.awt.Font("Aharoni", 1, 36)); // NOI18N
        jLabel7.setText("TinyP2P");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, 150, 60));

        jLabel1.setText("Click on the cat for help.");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, 180, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bg3.png"))); // NOI18N
        jLabel9.setText("jLabel9");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 360));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       toLogin();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
       jTextField1.setText(Mnemonics.getMnemonics(ips[1]));
       jLabel10.setText(ips[1]);
    }//GEN-LAST:event_formWindowOpened

    private void tinyButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tinyButtActionPerformed
       Help h = new Help(this.getBounds(),ips);
       h.setVisible(true);
    }//GEN-LAST:event_tinyButtActionPerformed

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
            java.util.logging.Logger.getLogger(ConnectInternal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConnectInternal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConnectInternal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConnectInternal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConnectInternal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel help;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton tinyButt;
    // End of variables declaration//GEN-END:variables
}
