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

public class ConnectInfo extends javax.swing.JFrame {
    
    /**
     * Creates new form ConnectInfo
     */
    
    private IH2HNode node;
    private String[] ips;
   // private boolean err = false;
    private boolean NATDetected;
    
    //private boolean created; //flags whether the user has created or joined the network

    public ConnectInfo() {
        initComponents();
    }
    
    public ConnectInfo(IH2HNode n, String[] i, Rectangle lwl, boolean cr){
        this.node = n;
        this.ips = i;
        initComponents();
   
        this.setBounds(lwl);
        tinyButt.setOpaque(false);
        tinyButt.setContentAreaFilled(false); //to make the content area transparent
        tinyButt.setBorderPainted(false);
        
        NATDetected =(!ips[0].equalsIgnoreCase(ips[1]));
        
        jLabel9.setVisible(NATDetected);
        jLabel6.setVisible(NATDetected);
        jLabel10.setVisible(false);
     
        jLabel7.setVisible(!cr);
        jLabel11.setVisible(cr);
//        if(!cr){
//          jLabel7.setVisible(true);
//          jLabel11.setVisible(false);
//        }
//       
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        help = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        tinyButt = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(604, 383));
        setMinimumSize(new java.awt.Dimension(604, 383));
        setPreferredSize(new java.awt.Dimension(604, 383));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Aharoni", 1, 24)); // NOI18N
        jLabel1.setText("TinyP2P");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, 100, 40));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        jLabel3.setText("IP:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, 20, 10));

        jLabel4.setText("Your TinyP2P Mnemonic is:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, 170, -1));

        jButton1.setBackground(new java.awt.Color(255, 224, 193));
        jButton1.setText("OK");
        jButton1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton1.setMargin(new java.awt.Insets(4, 14, 4, 14));
        jButton1.setMaximumSize(new java.awt.Dimension(65, 32));
        jButton1.setMinimumSize(new java.awt.Dimension(65, 32));
        jButton1.setPreferredSize(new java.awt.Dimension(65, 32));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 330, 50, 20));

        help.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        help.setForeground(new java.awt.Color(0, 51, 204));
        help.setText(" ? ");
        help.setToolTipText("A TinyP2P mnemonic is an easy way to remember your IP");
        help.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 51)));
        getContentPane().add(help, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 160, -1, -1));

        jTextField2.setEditable(false);
        jTextField2.setBackground(new java.awt.Color(204, 255, 204));
        jTextField2.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jTextField2.setText("one one one one");
        jTextField2.setToolTipText("");
        jTextField2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField2.setOpaque(true);
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, 130, 30));

        tinyButt.setBackground(new java.awt.Color(204, 255, 204));
        tinyButt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/tiny7.png"))); // NOI18N
        tinyButt.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tinyButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tinyButtActionPerformed(evt);
            }
        });
        getContentPane().add(tinyButt, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, 40, 40));

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 0));
        jLabel5.setText("Give this to a peer who wants to join your TinyNet to begin sharing");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, 480, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("You have joined aTinyNet!");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, -1, -1));

        jLabel8.setFont(new java.awt.Font("Courier New", 0, 9)); // NOI18N
        jLabel8.setText("jLabel8");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 180, 170, 10));

        jLabel9.setBackground(new java.awt.Color(255, 102, 0));
        jLabel9.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 0, 0));
        jLabel9.setText("You may be behind a NAT router. Click here to connect with peers who are on ");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, 440, -1));

        jLabel6.setBackground(new java.awt.Color(255, 102, 0));
        jLabel6.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 0, 0));
        jLabel6.setText("the same local (LAN) network");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 290, 220, -1));

        jLabel10.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 0, 51));
        jLabel10.setText("No internet connection. Please click here to connect with peers on your LAN");
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, 430, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("You have created a new TinyNet!");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bg3.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 360));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        toLogin();
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed
    
    private void toLogin(){
        ChooseUsername lm = new ChooseUsername(node,this.getBounds(),ips);
        lm.setVisible(true);
        this.dispose();
    }
    
    private void toConnectInternal(){
       // err = true;
        ConnectInternal ci = new ConnectInternal(this.getBounds(),ips);
        ci.setVisible(true);
        this.dispose();
    }
    
    
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
//        if (created){
//            jLabel2.setText("You have successfully created a TinyP2P network");
//        }
//        else{
//            jLabel2.setText("You have successfully joined a TinyP2P network");
//        }
        
       
        if(!ips[0].equalsIgnoreCase("F")){
            jTextField2.setText(Mnemonics.getMnemonics(ips[0]));       
        }else{ 
            ips[0] = "No Internet Connection";
            jLabel10.setVisible(true);
            //jTextField2.setText("No Internet Connection");
            
            jLabel3.setVisible(false);
            jLabel5.setVisible(false);
            jLabel9.setVisible(false);
            jLabel6.setVisible(false);
            
        }
         jLabel8.setText(ips[0]);
        
        
       
        
    }//GEN-LAST:event_formWindowOpened
    
    private void tinyButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tinyButtActionPerformed
        Help h = new Help(this.getBounds(),ips);
        h.setVisible(true);
   
    }//GEN-LAST:event_tinyButtActionPerformed
    
    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
       toConnectInternal();
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        toConnectInternal();
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
       toConnectInternal();
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed
                
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
            java.util.logging.Logger.getLogger(ConnectInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConnectInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConnectInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConnectInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConnectInfo().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel help;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JButton tinyButt;
    // End of variables declaration//GEN-END:variables
}
