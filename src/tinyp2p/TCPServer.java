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
import org.apache.commons.io.IOUtils;

public class TCPServer {
//    public static void main (String args[]) throws Exception{
//        new TCPServer();
//    }
    
    String reqUser;
    String reqIP;
    String reqFile;
    String myDir;
    
    public TCPServer() throws Exception{
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
        public void run(){
            try{
                //create input stream attached to socket
                BufferedReader inFromClient = new BufferedReader(new InputStreamReader (connectionSocket.getInputStream()));
                //create output stream attached to socket
                // PrintWriter outToClient = new PrintWriter(new OutputStreamWriter(connectionSocket.getOutputStream()));
                //read in line from the socket
                String clientSentence;
                while ((clientSentence = inFromClient.readLine()) != null) {
                    String[] parts = clientSentence.split(",");
                    reqUser = parts[0].substring(1) ;
                    reqIP = connectionSocket.getInetAddress().toString();
                    reqFile = parts[1].substring(0,parts[1].length()-1);
                    
                    //String[] parts2 = reqFile.split("\\|");
                    // System.out.println(Arrays.toString(parts2));
                    //String fileSize = parts2[1].substring(0,parts2[1].length()-1);
                    //int fs = Integer.parseInt(fileSize.trim());
                   // reqFile = parts2[0];
                    
                    System.out.println("user: " + reqUser);
                    System.out.println("ip: " + reqIP);
                    System.out.println("filename: " + reqFile);
                   // System.out.println("file size: " + fs);
                    
                    setMyDir();
                    System.out.println("File located: " + myDir );
                    
                    System.out.println("complete path = " + myDir + "\\" + reqFile.substring(1));
                    String fullpath = myDir + "\\" + reqFile.substring(1);
                    String newpath = fullpath.replaceAll("\\\\","/");
                    System.out.println(newpath);
                 //   File transferFile = new File (reqFile);
                    File transferFile = new File (newpath);
                    byte [] bytearray = new byte [(int)transferFile.length()];
                     System.out.println("File input stream");
                     System.out.println("File size " + transferFile.length());
                    FileInputStream fin = new FileInputStream(transferFile);
                   //   System.out.println(fin.toString());
                    System.out.println("buffered input stream");
                    BufferedInputStream bin = new BufferedInputStream(fin);
                    System.out.println("read in file");
                    bin.read(bytearray,0,bytearray.length);
                    System.out.println("outputsocket");
                    OutputStream os = connectionSocket.getOutputStream();
                    System.out.println("Sending Files...");
                    os.write(bytearray,0,bytearray.length);
                    
                    os.flush();
                    connectionSocket.close();
                    System.out.println("File transfer complete");
                    
                
                
                
                    // System.out.println(connectionSocket.getInetAddress());
                    //  System.out.println("Client sent: "+clientSentence+"\n");
                
                }
                // connectionSocket.close();
                
                //  Send s = new Send();
                
//                     ServerSocket serverSocket = new ServerSocket(15123);
//        Socket socket = serverSocket.accept();
//        System.out.println("Accepted connection : " + socket);
      
               
                
                
                //process
                // PrintWriter outToClient = new PrintWriter(new OutputStreamWriter(connectionSocket.getOutputStream()));
                // String capitalizedSentence = clientSentence.toUpperCase() + '\n';
                //write out line to socket
                
                
                //outToClient.print(capitalizedSentence);
                //outToClient.flush();
                
                
                
                
                
                
            }catch(Exception e){}
        }
    }
}

