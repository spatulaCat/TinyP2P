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

public class TCPServer {
//    public static void main (String args[]) throws Exception{
//        new TCPServer();
//    }
    
    String reqUser;
    String reqIP;
    String reqFile;
    
    public TCPServer() throws Exception{
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
                //PrintWriter outToClient = new PrintWriter(new OutputStreamWriter(connectionSocket.getOutputStream()));
                //read in line from the socket
                String clientSentence;
                while ((clientSentence = inFromClient.readLine()) != null) {
                    String[] parts = clientSentence.split(",");
                    reqUser = parts[0].substring(1) ;
                    reqIP = connectionSocket.getInetAddress().toString();
                    reqFile = parts[1];
                    
                    String[] parts2 = reqFile.split("\\|");
                   // System.out.println(Arrays.toString(parts2));
                    String fileSize = parts2[1].substring(0,parts2[1].length()-1);
                    int fs = Integer.parseInt(fileSize.trim());
                    reqFile = parts2[0];
                    
                     
                   // System.out.println(connectionSocket.getInetAddress());
                  //  System.out.println("Client sent: "+clientSentence+"\n");
                    System.out.println("user: " + reqUser);
                    System.out.println("ip: " + reqIP);
                    System.out.println("filename: " + reqFile);
                    System.out.println("file size: " + fs);        

                     ServerSocket serverSocket = new ServerSocket(15123);
                     Socket sendSocket = serverSocket.accept();
                     File transferFile = new File (reqFile);
                     
                     byte [] bytearray = new byte [(int)transferFile.length()];
                     FileInputStream fin = new FileInputStream(transferFile);
                     BufferedInputStream bin = new BufferedInputStream(fin);
                     bin.read(bytearray,0,bytearray.length);
                     OutputStream os = sendSocket.getOutputStream();
                     
                     os.write(bytearray,0,bytearray.length);
                     os.flush();
                     sendSocket.close();
                     
                     
                     
                     
                    //process
                   // String capitalizedSentence = clientSentence.toUpperCase() + '\n';
                    //write out line to socket
                    //outToClient.print(capitalizedSentence);
                    //outToClient.flush();
                }
            }catch(Exception e){}
        }
    }
}