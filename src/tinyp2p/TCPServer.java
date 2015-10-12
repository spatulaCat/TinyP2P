/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package tinyp2p;

/**
 *
 * @author Nicky
 */
import java.io.*;
import java.net.*;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import org.apache.commons.io.IOUtils;

public class TCPServer {
//    public static void main (String args[]) throws Exception{
//        new TCPServer();
//    }
    
    String reqUser;
    String reqIP;
    String reqFile;
    String myDir;
    MainMenu sw;
    
    public  TCPServer() throws Exception{
        //this.myDir = myDir;
        
        //create welcoming socket at port 6789
        ServerSocket welcomeSocket = new ServerSocket(6789);
        
        System.out.println("server listening");
        while (true) {
            //block on welcoming socket for contact by a client
            Socket connectionSocket = welcomeSocket.accept();
            
            // create thread for client
            Connection c = new Connection(connectionSocket);
        }
    }

    TCPServer(MainMenu aThis) throws IOException {
        sw = aThis;
        ServerSocket welcomeSocket = new ServerSocket(6789);
        
        System.out.println("server listening");
        while (true) {
            //block on welcoming socket for contact by a client
            Socket connectionSocket = welcomeSocket.accept();
            
            // create thread for client
            Connection c = new Connection(connectionSocket);
        }
    }

   
    
    public void setMyDir() throws FileNotFoundException, IOException{
        List<String> lines =IOUtils.readLines(new FileInputStream("TinyP2PSettings.txt"));
        myDir = lines.get(0);

//        BufferedReader br = new BufferedReader(new FileReader("TinP2PSettings.txt"));
//        try {
//            StringBuilder sb = new StringBuilder();
//            String line = br.readLine();
//            
//            while (line != null) {
//                sb.append(line);
//                sb.append(System.lineSeparator());
//                line = br.readLine();
//            }
//            String everything = sb.toString();
//        } finally {
//            br.close();
//        }
    }
    
//    class Send extends Thread{
//        public void run(){
//            while(true){
//                // try (Socket sendSocket = serverSocket.accept()) {
//                try {
//                    ServerSocket serverSocket = new ServerSocket(15123);
//                    System.out.println("server listening again");
//                    Socket socket = serverSocket.accept();
//                    File transferFile = new File (reqFile);
//                    System.out.println("Accepted connection : " + socket);
//                    byte [] bytearray = new byte [(int)transferFile.length()];
//                    FileInputStream fin = new FileInputStream(transferFile);
//                    BufferedInputStream bin = new BufferedInputStream(fin);
//                    bin.read(bytearray,0,bytearray.length);
//                    OutputStream os = socket.getOutputStream();
//                    System.out.println("Sending Files...");
//                    os.write(bytearray,0,bytearray.length);
//                    os.flush();
//                    socket.close();
//                    System.out.println("File transfer complete");
//                } catch (IOException ex) {
//                    Logger.getLogger(TCPServer.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        }
//        
//    }
    class Connection extends Thread{
        Socket connectionSocket;
        Connection(Socket _connectionSocket){
            connectionSocket = _connectionSocket;
            this.start();
        }
        
        public void send(File path) throws IOException{
            File[] listOfFiles = path.listFiles();
            if(listOfFiles==null){
                 return;
             }
            for (File f : listOfFiles){
                 
                 if(f.isFile() && !f.isHidden()){
                     sendFile(f);
                 }
                 else if(f.isDirectory()&& !f.isHidden()) { 
                     File[] ff =  f.listFiles();
                     if(ff != null){
                         for (File fff : ff){
                             send(fff);
                         }
                     }
                    
                 }   
             }
        }
        
        public void sendFile(File transferFile) throws FileNotFoundException, IOException{
             byte [] bytearray = new byte [(int)transferFile.length()];
                     System.out.println("File input stream");
                     System.out.println("File size " + transferFile.length());
                    FileInputStream fin = new FileInputStream(transferFile);
                   //   System.out.println(fin.toString());
                   // System.out.println("buffered input stream");
                    BufferedInputStream bin = new BufferedInputStream(fin);
                   // System.out.println("read in file");
                    bin.read(bytearray,0,bytearray.length);
                  //  System.out.println("outputsocket");
                    OutputStream os = connectionSocket.getOutputStream();
                    System.out.println("Sending Files...");
                    os.write(bytearray,0,bytearray.length);
                    
                    os.flush();
                    connectionSocket.close();
                    System.out.println("File transfer complete");
        }
        
        public void run(){
            try{
                //create input stream attached to socket
                BufferedReader inFromClient = new BufferedReader(new InputStreamReader (connectionSocket.getInputStream()));
                //create output stream attached to socket
                // PrintWriter outToClient = new PrintWriter(new OutputStreamWriter(connectionSocket.getOutputStream()));
                //read in line from the socket
                String clientSentence;
                while ((clientSentence = inFromClient.readLine()) != null) {                
                   if(clientSentence.endsWith("SNDRQ")){
                       System.out.println("request: "+clientSentence);
                       
                       String[] parts = clientSentence.split(",");
                       String sender = parts[0].substring(1);
                       System.out.println("Sender " +  sender);
                       String reqFile = parts[1].substring(0,parts[1].length()-6);
                       System.out.println("reqFile " +  reqFile);
                       reqIP = connectionSocket.getInetAddress().toString();
                       System.out.println("reqIP" + reqIP);
                       int yn = JOptionPane.showConfirmDialog(null, sender + " wants to send you the file \"" + reqFile +"\"\nDo you want to recieve it?");
                    //  connectionSocket.close(); 
                    // if(yn==0){
                           sw.beginDownloadFromSender(reqFile, reqIP);
                      // }
                            
                   
                   }     
                   else if(clientSentence.endsWith("CHTMSG]")){
                        System.out.println("message recieved: " + clientSentence);
                        connectionSocket.close();                  
                        sw.updateChat(clientSentence);
                    }
                    else{
                       
                    setMyDir();
                    System.out.println("my shared dir: " + myDir );
                    
                    String[] parts = clientSentence.split(",");
                    reqUser = parts[0].substring(1) ;
                    reqIP = connectionSocket.getInetAddress().toString();
                    reqFile = parts[1].substring(0,parts[1].length()-1);
                    
                    //String[] parts2 = reqFile.split("\\|");
                    // System.out.println(Arrays.toString(parts2));
                    //String fileSize = parts2[1].substring(0,parts2[1].length()-1);
                    //int fs = Integer.parseInt(fileSize.trim());
                   // reqFile = parts2[0];
                    
                 //   System.out.println("user: " + reqUser);
                  //  System.out.println("ip: " + reqIP);
                    System.out.println("filename: " + reqFile);
                    // System.out.println("file size: " + fs);
                    
                   // String[] sdf = reqFile.split("\\\\");
                   // String[] dsf = new String[sdf.length-3];
                    String[] dsf ;
                    
                    String[] xcvxcv = myDir.split("\\\\");
                    String[] qweqwe = reqFile.split("\\\\");
                 //   String[] dsf = new String[qweqwe.length-3];
                      System.out.println("is " + xcvxcv[xcvxcv.length-1] + " = " + qweqwe[0]);
                    if(xcvxcv[xcvxcv.length-1].equalsIgnoreCase(qweqwe[0])){
                       // System.out.println("is " + xcvxcv[xcvxcv.length-1] + " = " + qweqwe[0]);
                        String[] newp = Arrays.copyOf(qweqwe, qweqwe.length-2);
                        //new String[reqFile.length-2];
                        System.arraycopy( qweqwe, 1, newp, 0, qweqwe.length-2 );
                         dsf = new String[newp.length-3];
                    }
                    
                  // sdf = reqFile.split("\\\\");
                    
                    else{
                    dsf = new String[qweqwe.length-3];
                    
                    }
                    
                    System.arraycopy(qweqwe, 3, dsf,0 , qweqwe.length-3); 
                    System.out.println(Arrays.toString(dsf));
                    
                    StringBuilder sb = new StringBuilder();
                    Object[] nodes = dsf;
                    for(int i=0;i<nodes.length;i++) {
                        sb.append(File.separatorChar).append(nodes[i].toString());
                    }
                    
                    
                    reqFile = sb.toString().substring(1);
                    
                    
                    
                    
                    
                    
                    System.out.println("complete path = " + myDir + "\\" + reqFile);
                    String fullpath = myDir + "\\" + reqFile;
                    String newpath = fullpath.replaceAll("\\\\","/");  
                    System.out.println(newpath);
                    
                    File transferFile = new File (newpath);
                    byte [] bytearray = new byte [(int)transferFile.length()];
                     System.out.println("File input stream");
                     System.out.println("File size " + transferFile.length());
                    FileInputStream fin = new FileInputStream(transferFile);
                   //   System.out.println(fin.toString());
                   // System.out.println("buffered input stream");
                    BufferedInputStream bin = new BufferedInputStream(fin);
                   // System.out.println("read in file");
                    bin.read(bytearray,0,bytearray.length);
                  //  System.out.println("outputsocket");
                    OutputStream os = connectionSocket.getOutputStream();
                    System.out.println("Sending Files...");
                    os.write(bytearray,0,bytearray.length);
                    
                    os.flush();
                    connectionSocket.close();
                    System.out.println("File transfer complete");
                    }
                }
//                   
       
            }catch(IOException e){} catch (Exception ex) {
                Logger.getLogger(TCPServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

