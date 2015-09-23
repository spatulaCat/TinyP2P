package tinyp2p;

import java.io.*;
import java.net.*;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.IOUtils;

public class ChatServer {
//    public static void main (String args[]) throws Exception{
//        new TCPServer();
//    }
    
    String reqUser;
    String reqIP;
    String reqFile;
    String myDir;
    
    public ChatServer() throws Exception{
        //create welcoming socket at port 6788
        ServerSocket welcomeSocket = new ServerSocket(6788);
        
        System.out.println("chat server listening");
        while (true) {
            //block on welcoming socket for contact by a client
            Socket connectionSocket = welcomeSocket.accept();
            
            // create thread for client
            Connection c = new Connection(connectionSocket);
        }
    }
    
//    public void setMyDir() throws FileNotFoundException, IOException{
//        List<String> lines =IOUtils.readLines(new FileInputStream("TinyP2PSettings.txt"));
//        myDir = lines.get(0);

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
  //  }
    
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
                System.out.println(clientSentence);
                }

            }catch(IOException e){}
        }
    }
}

