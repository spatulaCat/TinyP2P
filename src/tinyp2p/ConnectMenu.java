/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package tinyp2p;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hive2hive.core.api.interfaces.IH2HNode;
import org.hive2hive.core.api.configs.NetworkConfiguration;


/**
 *
 * @author Nicky
 */
public class ConnectMenu extends javax.swing.JFrame {
    
    setupConnection sc = new setupConnection();
    String[] ips = new String[2];
    //Rectangle bounds;
    /**
     * Creates new form ConnectMenu
     */
    public ConnectMenu() {
        initComponents();
        
        
        //this.config = ConfigFactory.load("client.conf");
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
        createNet = new javax.swing.JButton();
        joinNet = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Aharoni", 1, 22)); // NOI18N
        jLabel1.setText("Welcome to TinyP2P!");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 222, 39));

        createNet.setBackground(new java.awt.Color(255, 224, 193));
        createNet.setText("Create new TinyNet");
        createNet.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        createNet.setMargin(new java.awt.Insets(4, 14, 4, 14));
        createNet.setMaximumSize(new java.awt.Dimension(131, 23));
        createNet.setMinimumSize(new java.awt.Dimension(131, 23));
        createNet.setPreferredSize(new java.awt.Dimension(131, 25));
        createNet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createNetActionPerformed(evt);
            }
        });
        getContentPane().add(createNet, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 210, -1, -1));

        joinNet.setBackground(new java.awt.Color(255, 224, 193));
        joinNet.setText("Join a TinyNet");
        joinNet.setBorder(null);
        joinNet.setMargin(new java.awt.Insets(4, 14, 4, 14));
        joinNet.setMaximumSize(new java.awt.Dimension(131, 23));
        joinNet.setMinimumSize(new java.awt.Dimension(131, 23));
        joinNet.setPreferredSize(new java.awt.Dimension(131, 25));
        joinNet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                joinNetActionPerformed(evt);
            }
        });
        getContentPane().add(joinNet, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 250, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/tiny4.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bg1.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 300));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    private void createNetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createNetActionPerformed
        sc.buildNode();
        sc.connectNode(NetworkConfiguration.createInitial(createNodeID()));
        
        
        
        try {
            String myExIP;
            myExIP = getExternalIP();
            
            String myInIp = getInternalIP(sc.node);
            
            ips[0] = myExIP;
            ips[1] = myInIp;
            
        } catch (IOException ex) {
            Logger.getLogger(ConnectMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ConnectInfo ci = new ConnectInfo(sc.node, ips, this.getBounds());
       
        ci.setVisible(true);
        
        
        
        this.dispose();
    }//GEN-LAST:event_createNetActionPerformed
    
    
    public static String QueryIPServer(String url) throws MalformedURLException, IOException{
        URL data = new URL(url);
        HttpURLConnection con = (HttpURLConnection) data.openConnection();
        if(con.getContentLength() == -1){
            return "F";
        }
        else{
            String ip;
            try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
                ip= in.readLine();
            }
            con.disconnect();
            return ip;
        }
    }
    
    public static String getInternalIP(org.hive2hive.core.api.interfaces.IH2HNode node) throws UnknownHostException{    
        InetAddress i =InetAddress.getLocalHost();
        String thisIp = ""+i;
        return thisIp.substring(5, thisIp.length());

//return node.getPeer().peerAddress().peerSocketAddress().toString().substring(2).split(",")[0];
    }
    
//    //queries whatismyipaddress.com for external IP
    public static String getExternalIP() throws IOException{
        String generate_URL1 = "http://bot.whatismyipaddress.com/";
        String generate_URL2 = "http://checkip.amazonaws.com/";
        String generate_URL3 = "http://myexternalip.com/raw";
        
        if(!QueryIPServer(generate_URL1).equalsIgnoreCase("F")){
            return QueryIPServer(generate_URL1);
        }
        else if (!QueryIPServer(generate_URL2).equalsIgnoreCase("F")){
            return QueryIPServer(generate_URL2);
        }
        else if (!QueryIPServer(generate_URL3).equalsIgnoreCase("F")){
            return QueryIPServer(generate_URL3);
        }
        
        else{return "F";}
//
//
//        String ip ="";
//
//        try {
//
//            URL data = new URL(generate_URL3);
//
//            HttpURLConnection con = (HttpURLConnection) data.openConnection();
//
//            if(con.getContentLength() == -1){
//                return "F";
//            }
//
//
//
//            try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
//                ip= in.readLine();
//            }
//            con.disconnect();
//        } catch (Exception e) {
//        }
//        return ip;
    }
//
//     public String getInternalIP(){
//        String ip="";
//        String myIP="";
//        int f = 0;
//        try {
//            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
//            while (interfaces.hasMoreElements()) {
//                NetworkInterface iface = interfaces.nextElement();
//                // filters out 127.0.0.1 and inactive interfaces
//                if (iface.isLoopback() || !iface.isUp())
//                    continue;
//
//                Enumeration<InetAddress> addresses = iface.getInetAddresses();
//                while(addresses.hasMoreElements()) {
//                    InetAddress addr = addresses.nextElement();
//                    ip = addr.getHostAddress();
//                    if (f<1){
//                        myIP = ip;
//                        f++;
//                    }
//                   // System.out.println(iface.getDisplayName() + " " + ip);
//                }
//            }
//        } catch (SocketException e) {
//            throw new RuntimeException(e);
//        }
//
//        return myIP;
//    }
    
    public static boolean validIP (String ip) {
        
        try {
            if (ip == null || ip.isEmpty()) {
                return false;
            }
            
            String[] parts = ip.split( "\\." );
            if ( parts.length != 4 ) {
                return false;
            }
            
            for ( String s : parts ) {
                int i = Integer.parseInt( s );
                if ( (i < 0) || (i > 255) ) {
                    return false;
                }
            }
            return !ip.endsWith(".");
            
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
    
    private void joinNetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_joinNetActionPerformed
       
        JoinNet jn = new JoinNet(this.getBounds(),ips);
        jn.setVisible(true);
        this.dispose();
        //        try {
        //            String nodeID = createNodeID();
        //            String inet = JOptionPane.showInputDialog("Enter the IP address of anyone currently connected:");
        //            InetAddress bootstrapAddress = InetAddress.getByName(inet);
        //            buildNode();
        //            NetworkConfiguration config = NetworkConfiguration.create(nodeID, bootstrapAddress);
        //            connectNode(config);
        //        } catch (UnknownHostException e) {
        //            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
        //        }
    }//GEN-LAST:event_joinNetActionPerformed
    
    
//    private void connectNode(NetworkConfiguration networkConfig) {
//        if (node.connect(networkConfig)) {
//            node.getFileManager().subscribeFileEvents(new FileEventListener(node.getFileManager()));
//
//            if ( config.getBoolean("Relay.enabled")) {
//                String authenticationKey = config.getString("Relay.GCM.api-key");
//                long bufferAge = config.getDuration("Relay.GCM.buffer-age-limit", TimeUnit.MILLISECONDS);
//
//                MessageBufferConfiguration bufferConfiguration = new MessageBufferConfiguration().bufferAgeLimit(bufferAge);
//                AndroidRelayServerConfig androidServer = new AndroidRelayServerConfig(authenticationKey, 5,
//                        bufferConfiguration);
//                BufferedTCPRelayServerConfig tcpServer = new BufferedTCPRelayServerConfig(bufferConfiguration);
//
//                new PeerBuilderNAT(node.getPeer().peer()).addRelayServerConfiguration(RelayType.ANDROID, androidServer)
//                        .addRelayServerConfiguration(RelayType.BUFFERED_OPENTCP, tcpServer).start();
//            }
//            //toLogin();
//        } else {
//            JOptionPane.showMessageDialog(null, "Network connection could not be established.", "Error", JOptionPane.ERROR_MESSAGE);
//        }
//
//    }
//
//
//
//
//    private void buildNode() {
//        IFileConfiguration fileConfig = FileConfiguration.createCustom(maxFileSize, maxNumOfVersions, maxSizeAllVersions,
//                chunkSize);
//        IH2HSerialize serializer;
//        if ("java".equalsIgnoreCase(config.getString("Serializer.mode"))) {
//            serializer = new JavaSerializer();
//        } else {
//            serializer = new FSTSerializer(config.getBoolean("Serializer.FST.unsafe"), new BCSecurityClassProvider());
//        }
//        fileConfiguration = fileConfig;
//        node = H2HNode.createNode(fileConfig, new H2HDefaultEncryption(serializer), serializer);
//
//    }
//
    
    //creates a random node ID
    private String createNodeID() {
        return UUID.randomUUID().toString();
    }
    
    public void shutdown() {
        sc.shutdown();
    }
    
    public IH2HNode getNode(){
        return sc.node;
    }
    
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConnectMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ConnectMenu().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createNet;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton joinNet;
    // End of variables declaration//GEN-END:variables
}
