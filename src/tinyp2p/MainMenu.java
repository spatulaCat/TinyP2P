package tinyp2p;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.Timer;
import javax.swing.filechooser.FileSystemView;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import net.tomp2p.dht.FutureGet;
import net.tomp2p.dht.FuturePut;
import net.tomp2p.dht.PutBuilder;
import net.tomp2p.futures.BaseFuture;
import net.tomp2p.futures.BaseFutureListener;
import net.tomp2p.peers.Number160;
import net.tomp2p.peers.Number640;
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



public class MainMenu extends javax.swing.JFrame {
    public String username;
    private String password;
    private IH2HNode node;
    private UserCredentials userCredentials;
    private String[] ips;
    private DefaultListModel lm;
    private FileWriter fw ;
    private String chosenDir;
    private ArrayList<String> chosenDirs = null;
    private String chosenDirFolderName;
    private JTree tree;
    private String selectedUser;
    private ConcurrentHashMap<String, String> userIPs;
    public TCPServer server;
    private boolean filefound;
    private String searchTerm;
    ArrayList<String> badExts = new ArrayList();
    private boolean viewingMine;
    
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
        userIPs = new ConcurrentHashMap();
        viewingMine = false;
//        try{
//            List<String> lines =IOUtils.readLines(new FileInputStream("TinyP2PSettings.txt"));
//            chosenDir =  lines.get(0);
//        }catch(IndexOutOfBoundsException | FileNotFoundException  e){}
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser = new javax.swing.JFrame();
        fileChooser = new javax.swing.JFileChooser();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jScrollBar1 = new javax.swing.JScrollBar();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        online = new javax.swing.JList();
        jTextField2 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        tinyButt = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

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
        setMinimumSize(new java.awt.Dimension(600, 383));
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

        jScrollPane2.setBackground(new java.awt.Color(255, 215, 197));

        jTextArea2.setEditable(false);
        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jTextArea2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextArea2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTextArea2);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 210, 200));

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane3.setToolTipText("");

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(255, 253, 221));
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane3.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 60, 190, 220));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton3.setText("View my shared folder");
        jButton3.setMargin(new java.awt.Insets(2, 9, 2, 9));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 250, 210, 30));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jButton1.setText("Send");
        jButton1.setPreferredSize(new java.awt.Dimension(50, 30));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 280, 70, 30));

        jLabel1.setFont(new java.awt.Font("Aharoni", 1, 18)); // NOI18N
        jLabel1.setText("Welcome");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 295, -1));

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel2.setText("Online users");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel5.setText("Files");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, -1, -1));

        jButton2.setFont(new java.awt.Font("sansserif", 0, 10)); // NOI18N
        jButton2.setText("Go");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 280, -1, 30));

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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 130, 250));

        jTextField2.setText("Search...");
        jTextField2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField2MouseClicked(evt);
            }
        });
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 280, 200, 30));

        jTextField1.setBackground(new java.awt.Color(255, 253, 221));
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 280, 190, 30));

        tinyButt.setBackground(new java.awt.Color(204, 255, 204));
        tinyButt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/tiny7.png"))); // NOI18N
        tinyButt.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tinyButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tinyButtActionPerformed(evt);
            }
        });
        getContentPane().add(tinyButt, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 0, 40, 40));

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel4.setText("Chat");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 40, -1, -1));

        jLabel3.setText(" ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 570, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bg3.png"))); // NOI18N
        jLabel7.setText("jLabel7");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 0, 600, 370));

        jMenuBar1.setBorder(null);

        jMenu1.setText("Settings");

        jMenuItem1.setText("Change shared directory");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Add shared directory");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Remove shared directory");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    MouseAdapter n = new MouseAdapter(){//click on user name
        @Override
        public void mousePressed ( MouseEvent e )
        {
            try{
                jTextArea2.setText("");
                jScrollPane2.getViewport().remove(jTextArea2);
                jScrollPane2.getViewport().add(tree);
                selectedUser = lm.elementAt(online.getSelectedIndex()).toString();
                showFiles();
            }catch(ArrayIndexOutOfBoundsException ex){}
        }
    };
    
    MouseAdapter m = new MouseAdapter ()
    {
        String p;
        TreePath path;
        @Override
        public void mousePressed ( MouseEvent e )
        {
            if ( SwingUtilities.isRightMouseButton ( e ))// || e.getClickCount() == 2
            {
                path = tree.getPathForLocation ( e.getX (), e.getY () );
                Rectangle pathBounds = tree.getUI ().getPathBounds ( tree, path );
                if ( pathBounds != null && pathBounds.contains ( e.getX (), e.getY () ) )
                {
                    JPopupMenu menu = new JPopupMenu ();
                    p = path.getLastPathComponent().toString();
                    if(viewingMine){//my dir
                        JMenuItem jm = new JMenuItem("Send " + p);
                        MouseListener popupListener = new ULPopupListener();
                        jm.addMouseListener(popupListener);
                        menu.add(jm);
                        menu.show ( tree, pathBounds.x, pathBounds.y + pathBounds.height );
                    }
                    else{//their dir
                        JMenuItem jm = new JMenuItem("Download " + p);
                        MouseListener popupListener = new DLPopupListener();
                        jm.addMouseListener(popupListener);
                        menu.add(jm);
                        menu.show ( tree, pathBounds.x, pathBounds.y + pathBounds.height );
                    }
                    
                    
                }
            }
        }
        
        class ULPopupListener extends MouseAdapter {
            @Override
            public void mousePressed(MouseEvent e) {
                new uploadWorkerClass(path).execute();
            }
        }
  
        class DLPopupListener extends MouseAdapter {
            @Override
            public void mousePressed(MouseEvent e) {
                new downloadWorkerClass(path).execute();
            }
        }
    };
    
    
    public void beginDownloadFromSender( String file, String IP) throws Exception
    {
        TreePath t = new TreePath(file);
        new downloadWorkerClass(t).execute();
        
//        String fname = extractFname(file);
//        String[] request = {username,file};
//       
//        System.out.println("Requesting yo " + Arrays.toString(request));
//       
//        TCPClient client = new TCPClient(IP,6789,fname);
//        
//        client.SendToServer(request);
//        
//        System.out.println(client.RecieveFromServer());
//        client.close();
//        
        //  System.out.println("Requesting yo " + Arrays.toString(request));
    }
    
//    String[] request = {username,sb.toString()};
//
//    TCPClient client = new TCPClient(userIPs.get(selectedUser).substring(1),6789,fname);
    
    
    class uploadWorkerClass extends SwingWorker<Void, TreePath>{
      
        private TreePath tp;
        public uploadWorkerClass(TreePath t){
            this.tp = t;
        }
        public void ads(){
            
        }
        @Override
        public Void doInBackground(){
            String fname;
            Object[] nodes;
            try {
                if(tp==null){
                    fname  = tree.getSelectionPath().getLastPathComponent().toString();     
                    nodes = tree.getSelectionPath().getPath();
                }
                else{
                    fname = tp.getLastPathComponent().toString();
                    nodes = tp.getPath();
                }
                
                StringBuilder sb = new StringBuilder();
                
                for(int i=0;i<nodes.length;i++) {
                    sb.append(File.separatorChar).append(nodes[i].toString());
                }
                
                String[] request = {username,sb.toString()};
                selectedUser = JOptionPane.showInputDialog(null,"");
                System.out.println("I am " + username + " sending a file to " + selectedUser + " at " + userIPs.get(selectedUser));

                TCPClient client = new TCPClient(userIPs.get(selectedUser).substring(1),6789,fname);
                
                //client.SendToServer(request);
                client.UploadRequest(request);
              
                //System.out.println(client.RecieveFromServer());
              //  client.close();
                
            } catch (Exception ex) {
                System.out.println(ex);
            }
            return null;
        }
    }
   
    
    
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        loginWorker.execute();
        jLabel1.setText("Welcome, "+ username+"!");
        listenWorker.execute();
        
        displayUsers du = new displayUsers();                      //set up timer
        Timer tmr = new javax.swing.Timer(10000, du);
        
        tmr.setInitialDelay(0);
        tmr.setRepeats(true);
        tmr.start();
        
        online.addMouseListener(n);   
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
    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       viewingMine = true;
        try {
            List<String> lines =IOUtils.readLines(new FileInputStream("dirList.txt"));
            
            DefaultMutableTreeNode root = new DefaultMutableTreeNode("Shared");
            
            DefaultTreeModel model = new DefaultTreeModel(root);
            tree = new JTree(model);
            tree.setCellRenderer(new FileTreeCellRenderer());
            tree.addMouseListener ( m );
            
            for (String line : lines){
                buildTreeFromString(model, line);
            }
            
            jScrollPane2.getViewport().add(tree);
            
        } catch ( NullPointerException | IOException ex) {
            
        }      
    }//GEN-LAST:event_jButton3ActionPerformed
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
       String chDirTemp = "";
        try {
            chDirTemp = getDir();
            
        } catch (IOException ex) {
      
        }
        if(chDirTemp != null){
            chosenDir = chDirTemp;
          //  chosenDirs.add(chosenDir);
        createDirListSwingWorker();
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

                

    private void showFiles(){
      viewingMine = false;
        try{
            Number160 dirlistHash2 = Number160.createHash(selectedUser + "dirlist");
            FutureGet futureGet = node.getPeer().get(dirlistHash2).start();
            futureGet.awaitUninterruptibly();
            if (!futureGet.isEmpty()){
                Object result = futureGet.data().object();
                String[] fs = result.toString().split(",");
                fs[0] = fs[0].substring(1);
                fs[fs.length-1] =  fs[fs.length-1].substring(0,fs[fs.length-1].length()-1);
                //Remove "[" and "]"   
                            
                DefaultMutableTreeNode root = new DefaultMutableTreeNode(selectedUser + "'s shared directory");
                
                DefaultTreeModel model = new DefaultTreeModel(root);
                tree = new JTree(model);
                tree.addMouseListener ( m );
                try{
                for (String line : fs){
                    if(line.substring(0,1).equalsIgnoreCase(" ")){
                        line = line.substring(1,line.length());
                    }
                    buildTreeFromString(model, line);
                }
                jScrollPane2.getViewport().add(tree);
                }catch(StringIndexOutOfBoundsException e){
                    
                }
                tree.setCellRenderer(new FileTreeCellRenderer());
            }
              
        }catch(NullPointerException e){
        } catch (ClassNotFoundException | IOException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String mess = username +": "+ jTextField1.getText();
        jTextArea1.append(mess+"\n");
        jTextField1.setText("");
        
        for (String  userip : userIPs.values()){
            try{
            TCPClient cClient = new TCPClient(userip.substring(1),6789,"CHTMSG");
            mess+="CHTMSG";
            System.out.println("I sent: " + mess );
            String[] a = {mess};
            
            cClient.SendToServer(a);

            cClient.close();
            }catch(Exception e){ System.err.println(e);}         
        }
          
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField2MouseClicked
         jTextField2.setText("");
    }//GEN-LAST:event_jTextField2MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            fileSearch(jTextField2.getText());
        } catch (ClassNotFoundException | IOException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        try {
            fileSearch(jTextField2.getText());
        } catch (ClassNotFoundException | IOException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
   if (evt.getKeyCode()==KeyEvent.VK_ENTER){
            jButton1.doClick();
        }          
    }//GEN-LAST:event_jTextField1KeyPressed

    private TreePath find(DefaultMutableTreeNode root, String s) {
        @SuppressWarnings("unchecked")
                Enumeration<DefaultMutableTreeNode> e = root.depthFirstEnumeration();
        while (e.hasMoreElements()) {
            DefaultMutableTreeNode node = e.nextElement();
            if (extractExtension(node.toString())[0].equalsIgnoreCase(s)) {
                System.out.println(node.toString());
                return new TreePath(node.getPath());
            }
        }
        return null;
}
    
    private void jTextArea2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextArea2MouseClicked
        if(filefound){
            showFiles();
            DefaultMutableTreeNode nnode = (DefaultMutableTreeNode)tree.getModel().getRoot();
            TreePath path = find(nnode, searchTerm);
            tree.setSelectionPath(path);
            tree.scrollPathToVisible(path);
        }
    }//GEN-LAST:event_jTextArea2MouseClicked

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem3ActionPerformed
          
   public void fileSearch(String srch) throws ClassNotFoundException, IOException{
     searchTerm = srch;
       final String pooky = extractFname(srch);
       Number160 myHash =  Number160.createHash(pooky);
        jTextArea2.setText("");
        FutureGet futureGet = node.getPeer().get(myHash).all().start();
        futureGet.awaitUninterruptibly();
        futureGet.addListener(new BaseFutureListener<FutureGet>() {
         @Override
         public void operationComplete(FutureGet f) throws Exception {
            filefound = true;
            for (Map.Entry<Number640, Data> entry : f.dataMap().entrySet()) {
                Object nn = entry.getValue().object();
                selectedUser = nn.toString();
                jTextArea2.append(nn.toString() + " has " + pooky + "\n");
       //     jScrollPane2.getViewport().remove(tree);
                jScrollPane2.getViewport().add(jTextArea2);
            }
         }

         @Override
         public void exceptionCaught(Throwable thrwbl) throws Exception {
             throw new UnsupportedOperationException("YOLO");
         }
            
        });
/*        
        if (!futureGet.isEmpty()){
            filefound = true;
            Map<Number640, Data> results = futureGet.dataMap();
            jTextArea2.setText("");
            for (Map.Entry<Number640, Data> entry : results.entrySet()) {
                Object nn = entry.getValue().object();
                selectedUser = nn.toString();
                jTextArea2.append(nn.toString() + " has " + srch + "\n");
       //     jScrollPane2.getViewport().remove(tree);
                jScrollPane2.getViewport().add(jTextArea2);
            }
        }
        else{
            filefound = false;
            jTextArea2.setText(srch + " not found");
//            jScrollPane2.getViewport().remove(tree);
            jScrollPane2.getViewport().add(jTextArea2);
        }    
*/
   } 
   
    
   public void updateChat(String ms){
       while(ms.endsWith("]")){
           ms = ms.substring(0, ms.length()-1);
       }
        while(ms.substring(0,1).equalsIgnoreCase("[")){
           ms = ms.substring(1, ms.length());
       }
       while(ms.endsWith("CHTMSG")){
           ms = ms.substring(0, ms.length()-6);
       }
       jTextArea1.append(ms + "\n");  
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
                            Object n = futureGet.data().object();
                            lm.addElement(n);
                            userIPs.putIfAbsent(n.toString(),pa.inetAddress().toString());

                        } catch (ClassNotFoundException | IOException ex) {
                        }
                    }        
             }
            online.setModel(lm);
            }catch(NullPointerException e){            
            }  
        }
    }
    
     public String[] extractExtension(String n){
      String[] parts = n.split("\\.(?=[^\\.]+$)");
      if(parts.length<2){
          String[] parts2 = {parts[0], ".file"};
          return parts2;
      }
         
      else return parts; 
    }
    
//    public String removeExtension(String n){
//         String[] parts2 = n.split("\\.(?=[^\\.]+$)");
//        return parts2[0];
//    }
    
   public String extractFname(String path){
        String[] parts = path.split("\\\\");
        String fname = parts[parts.length-1];
        return fname.toLowerCase();
    }
   
    public String checkUp(String file){
        String[] bads = {"DOC","PDF","DOCX","XLS","DBX","DOCM", "DOTM", "XLSM", "XLTM", "XLAM", "PPTM", "POTM", "PPAM", "PPSM", "SLDM", "DBX"};
        if(Arrays.asList(bads).contains(file.toUpperCase())){
            return file;
        }
        return null;
    }
    
    class downloadWorkerClass extends SwingWorker<Void, TreePath>{
      
        private TreePath tp;
        public downloadWorkerClass(TreePath t){
            this.tp = t;
        }
        
        @Override
        public Void doInBackground(){
            String fname;
         Object[] nodes;
        try {
            if(tp==null){
                fname  = tree.getSelectionPath().getLastPathComponent().toString();
               
                nodes = tree.getSelectionPath().getPath();       
            }
            else{
                fname = tp.getLastPathComponent().toString();
               nodes = tp.getPath();          
            }
            System.out.println("NODES " + Arrays.toString(nodes));
            int dlExe = 0;
            
            if (fname.substring(fname.length()-4,fname.length()).equalsIgnoreCase(".exe")){
                JCheckBox checkbox = new JCheckBox("Do not show this warning again.");
                String message1 = "This file is an executable and may be malicious or harmful.\n";
                String message2 = "Are you sure you want to download " + fname + "?";
                Object[] params = {message1, message2, checkbox};
                dlExe = JOptionPane.showConfirmDialog(null, params, "Disconnect Products", JOptionPane.YES_NO_OPTION);
                boolean dontShow = checkbox.isSelected();
            }

            if(dlExe == 0){
            
             StringBuilder sb = new StringBuilder();
                
                for(int i=0;i<nodes.length;i++) {
                    sb.append(File.separatorChar).append(nodes[i].toString());
                }
                String pt = sb.toString();
                
                if(pt.substring(0,3).equalsIgnoreCase("\\ \\")){
                    pt = pt.substring(3,pt.length());
                }
            
            System.out.println("path "+pt);        
            String[] request = {username,pt};
            System.out.println("dl request" + Arrays.toString(request));
            TCPClient client = new TCPClient(userIPs.get(selectedUser).substring(1),6789,fname);
            
            client.SendToServer(request);
   
            System.out.println(client.RecieveFromServer());
            client.close();
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }           
            return null;
        }
    }
    
    private void createDirListSwingWorker()
    {
     SwingWorker createDirList = new SwingWorker<String, Void>() {
        @Override
        public String doInBackground() {
            try {
                jLabel3.setText("Saving directory list");
                makeFile(chosenDir);
                jLabel3.setText("Directory list saved");
            } catch (IOException ex) {
            }
            uploadDirList();
            return null;
        }
        
        private void uploadDirList(){
            jLabel3.setText("Uploading directory list");
            try{
                List<String> lines =IOUtils.readLines(new FileInputStream("dirList.txt"));
                Number160 dirlistHash = Number160.createHash(username + "dirlist");
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
            File chd = new File(chosenDir);
            if (!dirList.exists()) {
                dirList.createNewFile();
            }
             writeStuff(chd);
            
             if(badExts!=null && !badExts.isEmpty()){ 
                 String list ="";
                 for(String a : badExts){
                     list = list+extractFname(a)+"\n";
                 }
              String msg = "The following files may contain personal information!\n\n" + list +  "\nAre you sure you still want to share?";
              JCheckBox checkbox = new JCheckBox("Do not show this warning again.");
              JTextArea textArea = new JTextArea(msg);            
              JScrollPane scrollPane = new JScrollPane(textArea);
              Object[] params = {scrollPane, checkbox};
              textArea.setLineWrap(true);
              textArea.setWrapStyleWord(true);
              scrollPane.setPreferredSize( new Dimension( 300, 250 ) );
                

              int yn = JOptionPane.showConfirmDialog(null, params, "Warning!",  JOptionPane.YES_NO_OPTION);
              if(yn == 0){
                  for(String b : badExts){
                     fw.write(b+"\n");
                  //   String fileName = ;
                     FuturePut futurePut = node.getPeer().put(Number160.createHash(extractExtension(extractFname(b))[0])).data(new Data(username)).start();
                     futurePut.awaitUninterruptibly();
                  }
                badExts.clear();
               // unverified.clear();
              }
              
             }
              fw.close();
         }
//         
        // ArrayList<String> unverified = new ArrayList();
         public void writeStuff(File dir) throws IOException{
             File[] listOfFiles = dir.listFiles();
             if(listOfFiles!=null  ){
             for (File f : listOfFiles){        
                 if(f.isFile() && !f.isHidden()){                
                     // fw.write(f.toString().substring(chosenDir.length()-chosenDirFolderName.length()) +" |"+ f.length()+"\n");
                     String leFile = f.toString().substring(chosenDir.length()-chosenDirFolderName.length());
                    
                     if(checkUp(extractExtension(leFile)[1]) != null){
                         if(  !badExts.contains(leFile)){
                             badExts.add(leFile);
                         }
                     }   
                     
                     else{
                     fw.write(leFile+"\n");
                     FuturePut futurePut = node.getPeer().put(Number160.createHash(extractExtension(extractFname(leFile))[0])).data(new Data(username)).start();
                     futurePut.awaitUninterruptibly();
                     }
                 }
                 else if(f.isDirectory() && !f.isHidden()) {
                    //  System.out.println("dir "+f);
                      
//                               System.out.println(f.canWrite());
//                     if(f.listFiles().length==0){
//                             fw.write(f.toString().substring(chosenDir.length()-chosenDirFolderName.length())+"\n");
//                         
//                     }
//                     else{
                         fw.write(f.toString().substring(chosenDir.length()-chosenDirFolderName.length())+"\n");
//                     }
                     writeStuff(f);
                
                 }    
              //  System.out.println(f.toString());
                   fw.flush(); 
             }
            
             }}};   
     createDirList.execute();
    }
    
    private void createServer() throws IOException{
         server = new TCPServer(this); //port 6789
    }
    
    SwingWorker listenWorker = new SwingWorker<String, Void>() {
        @Override
        public String doInBackground() throws Exception {
           createServer();
             return null;        
        }      
    };
    
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
                FuturePut futurePut = node.getPeer().put(node.getPeer().peer().peerID()).data(new Data(username)).start();
                futurePut.awaitUninterruptibly();
            }catch(IOException e){System.out.println(e);}
            return null;
        }
    };
        

    public String getDir() throws IOException{
        String dir="";
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnVal = fileChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            dir =  fileChooser.getSelectedFile().getAbsolutePath();
            
            File settings = new File("TinyP2PSettings.txt");
            try (FileWriter fw2 = new FileWriter(settings)) {
                fw2.write(dir);
            }
        }
        else if(returnVal == JFileChooser.CANCEL_OPTION || returnVal == JFileChooser.ABORT){
            dir = null;
        }
            
         return dir;
    }
    
     private void buildTreeFromString(final DefaultTreeModel model, final String str) {
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
        String [] strings = str.split("\\\\");
        DefaultMutableTreeNode node = root;
        for (String s: strings) {
            try{
            if(s.substring(0,11).equalsIgnoreCase("desktop.ini")){
                 return;
             }
            }catch(StringIndexOutOfBoundsException dsdf){}  
                 
                 
//            String[] fname = s.split("\\|");
//            if(fname.length > 1){
//                double size = Double.parseDouble(fname[1].trim());
//                String prettySize;
//                if(size>1000000){
//                    size = size/1000000;
//                    size =  (double) Math.round(size * 100) / 100;
//                     prettySize = "(" + size + " Mb)";
//                }
//                else if(size>1000){
//                    size = size/1000;
//                     prettySize = "(" + size + " Kb)";
//                }    
//                
//                else{
//                 prettySize = "(" + size + " b)";
//                }   
//                fname[1] = prettySize;
//                s = fname[0] + fname[1];
//                           }
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
    private javax.swing.JFrame jFileChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JList online;
    private javax.swing.JButton tinyButt;
    // End of variables declaration//GEN-END:variables
  
    
    
    class FileTreeCellRenderer extends DefaultTreeCellRenderer {

    private FileSystemView fileSystemView;

    private JLabel label;

    FileTreeCellRenderer() {
        label = new JLabel();
        label.setOpaque(true);
        fileSystemView = FileSystemView.getFileSystemView();
    }

    @Override
    public Component getTreeCellRendererComponent(
        JTree tree,
        Object value,
        boolean selected,
        boolean expanded,
        boolean leaf,
        int row,
        boolean hasFocus) {
        
        DefaultMutableTreeNode node = (DefaultMutableTreeNode)value;
        
        File file =  new File(node.getUserObject().toString());     
 
        label.setIcon(fileSystemView.getSystemIcon(file));
        label.setText(fileSystemView.getSystemDisplayName(file));
        label.setToolTipText(file.getPath());

        if (selected) {
            label.setBackground(backgroundSelectionColor);
            label.setForeground(textSelectionColor);
        } else {
            label.setBackground(backgroundNonSelectionColor);
            label.setForeground(textNonSelectionColor);
        }
        return label;
    }
    }
}
