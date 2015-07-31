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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JTree;
import javax.swing.SwingWorker;
import javax.swing.Timer;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import net.tomp2p.dht.FutureGet;
import net.tomp2p.dht.FuturePut;
import net.tomp2p.dht.PutBuilder;
import net.tomp2p.peers.PeerAddress;
import net.tomp2p.storage.Data;
import org.apache.commons.io.IOUtils;
import org.hive2hive.core.api.interfaces.IH2HNode;
import org.hive2hive.core.api.interfaces.IUserManager;
import org.hive2hive.core.exceptions.NoPeerConnectionException;
import org.hive2hive.core.security.UserCredentials;
import org.hive2hive.processframework.exceptions.InvalidProcessStateException;
import org.hive2hive.processframework.exceptions.ProcessExecutionException;
import util.ConsoleFileAgent;
import net.tomp2p.peers.Number160;

/**
 *
 * @author Nicky
 */
public class MainMenu extends javax.swing.JFrame {
    private String username;
    private String password;
    private IH2HNode node;
    private UserCredentials userCredentials;
    private String[] ips;
    private DefaultListModel lm;
    private FileWriter fw ;
    private String chosenDir;
    private String chosenDirFolderName;
    private JTree tree;
    private String selectedUser;
    private boolean stillPopulating;
    
    public MainMenu() {
        initComponents();
    }
    
    public MainMenu(String User, String pw, IH2HNode node, Rectangle bounds, String[] ips) throws IOException {
        this.username = User;
        this.password = pw;
        this.node = node;
        this.ips = ips;
        
        initComponents();
        
        this.setBounds(bounds);
        tinyButt.setOpaque(false);
        tinyButt.setContentAreaFilled(false); //to make the content area transparent
        tinyButt.setBorderPainted(false);
        
        fw = new FileWriter("dirList.txt");
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser = new javax.swing.JFrame();
        fileChooser = new javax.swing.JFileChooser();
        jScrollPane2 = new javax.swing.JScrollPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        online = new javax.swing.JList();
        tinyButt = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        fileChooser.setCurrentDirectory(new java.io.File("C:\\Users\\(._.)\\.ssh"));

        javax.swing.GroupLayout jFileChooserLayout = new javax.swing.GroupLayout(jFileChooser.getContentPane());
        jFileChooser.getContentPane().setLayout(jFileChooserLayout);
        jFileChooserLayout.setHorizontalGroup(
            jFileChooserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fileChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jFileChooserLayout.setVerticalGroup(
            jFileChooserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jFileChooserLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(fileChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(600, 383));
        setMinimumSize(new java.awt.Dimension(600, 383));
        setPreferredSize(new java.awt.Dimension(600, 383));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 60, 230, 240));

        jLabel1.setFont(new java.awt.Font("Aharoni", 1, 18)); // NOI18N
        jLabel1.setText("Welcome");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 295, -1));

        jLabel2.setText("Online users");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        online.setBackground(new java.awt.Color(222, 255, 204));
        online.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(online);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 130, 240));

        tinyButt.setBackground(new java.awt.Color(204, 255, 204));
        tinyButt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/tiny7.png"))); // NOI18N
        tinyButt.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tinyButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tinyButtActionPerformed(evt);
            }
        });
        getContentPane().add(tinyButt, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 0, 40, 40));

        jTextField1.setText("jTextField1");
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 190, 80, -1));

        jTextField2.setText("jTextField2");
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 220, 80, -1));

        jLabel4.setText("message ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 190, -1, -1));

        jLabel5.setText("User");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 220, -1, -1));

        jButton1.setText("rec");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 260, -1, -1));

        jButton2.setText("send");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 260, 60, -1));

        jTextField3.setText("jTextField3");
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 160, 80, -1));

        jLabel6.setText("dir");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 160, -1, -1));

        jButton3.setText("View my shared folder");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 30, 150, -1));

        jButton5.setText("get dir");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, -1, -1));

        jLabel3.setText(" ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 570, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bg3.png"))); // NOI18N
        jLabel7.setText("jLabel7");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 0, 600, 360));

        jMenuBar1.setBorder(null);

        jMenu1.setText("Settings");

        jMenuItem1.setText("Change shared directory");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        loginWorker.execute();
        jLabel1.setText("Welcome, "+ username+"!");
        
        displayUsers du = new displayUsers();                      //set up timer
        Timer tmr = new javax.swing.Timer(10000, du);
        
        tmr.addActionListener(du);
        tmr.setInitialDelay(0);
        tmr.setRepeats(true);
        tmr.start();
        
//        try {
//            ServerSocket serverSocket = new ServerSocket(15123);
//            Socket socket = serverSocket.accept();
//
//        } catch (IOException ex) {
//            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
    }//GEN-LAST:event_formWindowOpened
    
    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        this.dispose();
        shutdown();
        System.exit(0);
    }//GEN-LAST:event_formWindowClosed
    
    private void tinyButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tinyButtActionPerformed
        Help h = new Help(this.getBounds(),ips);
        h.setVisible(true);       
    }//GEN-LAST:event_tinyButtActionPerformed
    
    public void sendToPort(String ip, String msg) throws IOException {
        Socket socket = null;
        OutputStreamWriter osw;
        //String str = "Hello World";
        try {
            socket = new Socket(ip, 4014);
            osw =new OutputStreamWriter(socket.getOutputStream(), "UTF-8");
            osw.write(msg, 0, msg.length());
            osw.flush();
        } catch (IOException e) {
            System.err.print(e);
        } finally {
            socket.close();
        }
        
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String f = jTextField1.getText();
        
        //  jTextField2.setText(lm.elementAt(online.getSelectedIndex()).toString());
        //  String user = jTextField2.getText();
        System.out.println("Requesting file");
        
        int filesize=1022386;
        int bytesRead;
        int currentTot = 0;
        Socket socket;
        try {
            socket = new Socket("146.231.133.148",15123);
            
            byte [] bytearray = new byte [filesize];
            InputStream is = socket.getInputStream();
            FileOutputStream fos = new FileOutputStream("bg1copy.png");
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            bytesRead = is.read(bytearray,0,bytearray.length);
            currentTot = bytesRead;
            System.out.println("Listening for the file");
            do { bytesRead = is.read(bytearray, currentTot, (bytearray.length-currentTot));
            if(bytesRead >= 0) currentTot += bytesRead;
            }
            while(bytesRead > -1);
            bos.write(bytearray, 0 , currentTot);
            bos.flush();
            bos.close();
            socket.close();
            System.out.println("file successfully transferred");
        } catch (IOException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
//        try {
//            sendToPort(f,user);
//
//        } catch (IOException ex) {
//            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//      Socket socket = new Socket("ip address", 4014);
//       //OutputStream outstream = socket .getOutputStream();
//      // PrintWriter out = new PrintWriter(outstream);
//
//       String toSend = "String to send";
//
//       out.print(toSend );
//
//
        
        
    }//GEN-LAST:event_jButton1ActionPerformed
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // listener.execute();
        try {
            ServerSocket serverSocket = new ServerSocket(15123);
            Socket socket = serverSocket.accept();
            File transferFile = new File ("tiny6.png");
            byte [] bytearray = new byte [(int)transferFile.length()];
            FileInputStream fin = new FileInputStream(transferFile);
            BufferedInputStream bin = new BufferedInputStream(fin);
            bin.read(bytearray,0,bytearray.length);
            OutputStream os = socket.getOutputStream();
            System.out.println("Sending Files...");
            os.write(bytearray,0,bytearray.length);
            os.flush();
            socket.close();
            System.out.println("File transfer complete");
        } catch (IOException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
//        try {
//            int bytesRead;
//            Socket socket = new Socket("146.231.133.148",15123);
//            InputStream is = socket.getInputStream();
//            // bytesRead = is.read(bytearray,0,bytearray.length);
//        } catch (IOException ex) {
//            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_jButton2ActionPerformed
    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            List<String> lines =IOUtils.readLines(new FileInputStream("dirList.txt"));
            
            DefaultMutableTreeNode root = new DefaultMutableTreeNode("Shared");
            
            DefaultTreeModel model = new DefaultTreeModel(root);
            tree = new JTree(model);
            
            for (String line : lines){
                buildTreeFromString(model, line);
            }
            jScrollPane2.getViewport().add(tree);
            
//            jTextField3.setText(tree.getLastSelectedPathComponent().toString());
            
        } catch ( NullPointerException | IOException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        }      
    }//GEN-LAST:event_jButton3ActionPerformed
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
       
        try {
            chosenDir = getDir();
        } catch (IOException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        createDirListSwingWorker();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        selectedUser = lm.elementAt(online.getSelectedIndex()).toString();
        List<String> results = null;
        
        try{
            Number160 dirlistHash2 = Number160.createHash(selectedUser + "dirlist");
            System.out.println("hash = " + dirlistHash2);
            System.out.println("user = " + selectedUser);
            FutureGet futureGet = node.getPeer().get(dirlistHash2).start();
            futureGet.awaitUninterruptibly();
            if (!futureGet.isEmpty()){
                Object result = futureGet.data().object();
               // System.out.println(result.toString());
                
                String[] fs = result.toString().split(",");
                fs[0] = fs[0].substring(1);
                fs[fs.length-1] =  fs[fs.length-1].substring(0,fs[fs.length-1].length()-1);
                //Remove "[" and "]"   
                
//
//                FileWriter bbb = new FileWriter("oy.txt");
//
//                for (String f : fs){
//                     if(f.substring(0,1).equalsIgnoreCase(" ")){
//                        f = f.substring(1,f.length());
//                    }
//                     bbb.write(f+"\n");
//                }
//                bbb.close();
                
                DefaultMutableTreeNode root = new DefaultMutableTreeNode(selectedUser + "'s shared directory");
                
                DefaultTreeModel model = new DefaultTreeModel(root);
                tree = new JTree(model);
                
                for (String line : fs){
                    if(line.substring(0,1).equalsIgnoreCase(" ")){
                        line = line.substring(1,line.length());
                    }
                    buildTreeFromString(model, line);
                }
                jScrollPane2.getViewport().add(tree);
                
            }
        }catch(NullPointerException e){
        } catch (ClassNotFoundException | IOException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        }

//        DefaultMutableTreeNode root = new DefaultMutableTreeNode(selectedUser +"'s Shared directory");
//        
//        DefaultTreeModel model = new DefaultTreeModel(root);
//        tree = new JTree(model);
        
//        for (String line : results){
//            buildTreeFromString(model, line);
//        }
//        jScrollPane2.getViewport().add(tree);
        
        
        
    }//GEN-LAST:event_jButton5ActionPerformed
          
   

    public void valueChanged(TreeSelectionEvent e) {
        //Returns the last path element of the selection.
        //This method is useful only when the selection model allows a single selection.
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
        
        if (node == null)
            //Nothing is selected.
            return;
        
        //Object nodeInfo = node.getUserObject();
        
        if (node.isLeaf()) {
            jTextField3.setText(node.toString());
        } else {
            //displayURL(helpURL);
        }
        
    }
    
        //returns whether or not a person is registered or not
    private boolean registered(UserCredentials userCredentials) throws NoPeerConnectionException, InvalidProcessStateException, InterruptedException {    
        IUserManager userManager = node.getUserManager();
        return userManager.isRegistered(userCredentials.getUserId());
    }
   
    class displayUsers implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent evt){
            lm = new DefaultListModel();
            online.setModel(lm);
            try{
             List<PeerAddress> peerMap = node.getPeer().peerBean().peerMap().all();
             for (PeerAddress pa : peerMap){                 
                    FutureGet futureGet = node.getPeer().get(pa.peerId()).start();
                    futureGet.awaitUninterruptibly();                   
                    if (!futureGet.isEmpty()){
                        try {                 
                            lm.addElement(futureGet.data().object());
                            online.setModel(lm);
                        } catch (ClassNotFoundException | IOException ex) {
                        }
                    }                    
                     futureGet.cancel();
             }
            online.setModel(lm);
            }catch(NullPointerException e){            
            }  
        }
    }
    
    private void createDirListSwingWorker()
    {
     SwingWorker createDirList = new SwingWorker<String, Void>() {
        @Override
        public String doInBackground() {
            try {
               // chosenDir = getDir();
                //System.out.println("writing directory list");
                jLabel3.setText("Saving directory list");
                makeFile(chosenDir);
             //   System.out.println("directory list written");
                jLabel3.setText("Directory list saved");
            } catch (IOException ex) {
                Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
            uploadDirList();
            return null;
        }
        
         private void uploadDirList(){
        jLabel3.setText("Uploading directory list");
        try{
            List<String> lines =IOUtils.readLines(new FileInputStream("dirList.txt"));
            Number160 dirlistHash = Number160.createHash(username + "dirlist");
            //System.out.println("this hash = " + dirlistHash);
            FuturePut futurePut = node.getPeer().put(dirlistHash).data(new Data(lines)).start();
            futurePut.awaitUninterruptibly();
        }catch(IOException e){System.out.println(e);}
        jLabel3.setText("directory list uploaded");
         }
         public void makeFile(String dir) throws IOException{
             File dirList = new File("dirList.txt");
             fw = new FileWriter(dirList.getAbsoluteFile());
             String[] s = chosenDir.split("\\\\");
             String ss = s[s.length-1];
             chosenDirFolderName = ss;
             if (!dirList.exists()) {
                 dirList.createNewFile();
             }
             writeStuff(dir);
             fw.close();
         }
         
         public void writeStuff(String dir) throws IOException{
             File folder = new File(dir);
             File[] listOfFiles = folder.listFiles();
             
             if(listOfFiles==null){
                 return;
             }
             
             for (File f : listOfFiles){
                 
                 if(f.isFile() && !f.isHidden()){
                         fw.write(f.toString().substring(chosenDir.length()-chosenDirFolderName.length()) +" |"+ f.length()+"\n");       
                 }
                 else if(f.isDirectory()&& !f.isHidden()) { 
                     File[] ff =  f.listFiles();
                     if(ff != null){
                     fw.write(f.toString().substring(chosenDir.length()-chosenDirFolderName.length())+"\n");
                     }
                    writeStuff(f.toString());
                 }
                 
                 
             }
             fw.flush();
         }
         
     };
     
     createDirList.execute();
    }
    
    SwingWorker loginWorker = new SwingWorker<String, Void>() {
        @Override
        public String doInBackground() {
            userCredentials = new UserCredentials(username, password, "12345");
            try{
                File f = new File ("");
                if( registered(userCredentials)){
                    ConsoleFileAgent fileAgent = new ConsoleFileAgent(f);
                    node.getUserManager().createLoginProcess(userCredentials, fileAgent).execute();
                }
                else{      
                    node.getUserManager().createRegisterProcess(userCredentials).execute();
                    ConsoleFileAgent fileAgent = new ConsoleFileAgent(f);
                    node.getUserManager().createLoginProcess(userCredentials, fileAgent).execute();
                }
            }catch(NoPeerConnectionException | InvalidProcessStateException | ProcessExecutionException | InterruptedException e ){System.out.println(e);};
            
            PutBuilder f  = new PutBuilder(node.getPeer(),node.getPeer().peerID());
            try{
//                Data d = new Data(username);
//                f.data(d);
                FuturePut futurePut = node.getPeer().put(node.getPeer().peer().peerID()).data(new Data(username)).start();
                futurePut.awaitUninterruptibly();
            }catch(IOException e){System.out.println(e);}
            return null;
        }
//        @Override
//        public void done() {  
//        }
    };
        
    SwingWorker listener = new SwingWorker<String, Void>() {
        @Override
        public String doInBackground() throws IOException {
            ServerSocket serverSocket = new ServerSocket(15123);
            Socket socket = serverSocket.accept();
            File transferFile = new File ("tiny6.png");
            byte [] bytearray = new byte [(int)transferFile.length()];
            FileInputStream fin = new FileInputStream(transferFile);
            BufferedInputStream bin = new BufferedInputStream(fin);
            bin.read(bytearray,0,bytearray.length);
            OutputStream os = socket.getOutputStream();
            System.out.println("Sending Files...");
            os.write(bytearray,0,bytearray.length);
            os.flush();
            //socket.close();
            System.out.println("File transfer complete");
            return null;
        }
//        @Override
//         public void done() {   
//         }
    };

    public String getDir() throws IOException{
        String dir="";
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnVal = fileChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            dir =  fileChooser.getSelectedFile().getAbsolutePath();     
        }
        return dir;
    }
    
     private void buildTreeFromString(final DefaultTreeModel model, final String str) {
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
        String [] strings = str.split("\\\\");
        DefaultMutableTreeNode node = root;
        int z = 1; 
        for (String s: strings) {
            
           // System.out.println(Arrays.toString(s.split("\\|")));
            try{
            if(s.substring(0,11).equalsIgnoreCase("desktop.ini")){
                 return;
             }
            }catch(StringIndexOutOfBoundsException dsdf){}  
                 
                 
            String[] fname = s.split("\\|");
            if(fname.length > 1){
                double size = Double.parseDouble(fname[1].trim());
                String prettySize;
                if(size>1000000){
                    size = size/1000000;
                    size =  (double) Math.round(size * 100) / 100;
                     prettySize = "(" + size + " Mb)";
                }
                else if(size>1000){
                    size = size/1000;
                     prettySize = "(" + size + " Kb)";
                }    
                
                else{
                 prettySize = "(" + size + " b)";
                }   
                fname[1] = prettySize;
                s = fname[0] + fname[1];
                           }
           //System.out.println(getName().substring(1,12));
//            if(s.substring(1,12)){
//                
//            }
            
            
            
            // Look for the index of a node at the current level that
            // has a value equal to the current string
            int index = childIndex(node, s);
            // Index less than 0, this is a new node not currently present on the tree
            if (index < 0) {
                // Add the new node
                DefaultMutableTreeNode newChild = new DefaultMutableTreeNode(s);
                node.insert(newChild, node.getChildCount());
                node = newChild;
            }
            // Else, existing node, skip to the next string
            else {
                node = (DefaultMutableTreeNode) node.getChildAt(index);
            }
        }
    }
    
    private int childIndex(final DefaultMutableTreeNode node, final String childValue) {
        Enumeration<DefaultMutableTreeNode> children = node.children();
        DefaultMutableTreeNode child = null;
        int index = -1;
        while (children.hasMoreElements() && index < 0) {
            child = children.nextElement();
            if (child.getUserObject() != null && childValue.equals(child.getUserObject())) {
                index = node.getIndex(child);
            }
        }
        return index;
    }
    
    
    public void shutdown()  {
        if (node != null && node.isConnected()) {
            node.disconnect();
        }
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
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                    new MainMenu().setVisible(true);
            }
        });   
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JFrame jFileChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JList online;
    private javax.swing.JButton tinyButt;
    // End of variables declaration//GEN-END:variables
  
}

//    private DefaultMutableTreeNode addNodes(DefaultMutableTreeNode curTop, File dir) {
//        String curPath = dir.getPath();
//        DefaultMutableTreeNode curDir = new DefaultMutableTreeNode(curPath);
//        if (curTop != null) { // should only be null at root
//            curTop.add(curDir);
//        }
//        Vector ol = new Vector();
//        String[] tmp = dir.list();
//        for (String tmp1 : tmp) {
//            ol.addElement(tmp1);
//        }
//        Collections.sort(ol, String.CASE_INSENSITIVE_ORDER);
//        File f;
//        Vector files = new Vector();
//        // Make two passes, one for Dirs and one for Files. This is #1.
//        for (int i = 0; i < ol.size(); i++) {
//            String thisObject = (String) ol.elementAt(i);
//            String newPath;
//            if (curPath.equals("."))
//                newPath = thisObject;
//            else
//                newPath = curPath + File.separator + thisObject;
//            if ((f = new File(newPath)).isDirectory())
//                addNodes(curDir, f);
//            else
//                files.addElement(thisObject);
//        }
//        // Pass two: for files.
//        for (int fnum = 0; fnum < files.size(); fnum++)
//            curDir.add(new DefaultMutableTreeNode(files.elementAt(fnum)));
//        return curDir;
//    }