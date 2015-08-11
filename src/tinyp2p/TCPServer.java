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

public class TCPServer {
//    public static void main (String args[]) throws Exception{
//        new TCPServer();
//    }
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
                PrintWriter outToClient = new PrintWriter(new OutputStreamWriter(connectionSocket.getOutputStream()));
                //read in line from the socket
                String clientSentence;
                while ((clientSentence = inFromClient.readLine()) != null) {
                    System.out.println("Client sent: "+clientSentence);
                    //process
                    String capitalizedSentence = clientSentence.toUpperCase() + '\n';
                    //write out line to socket
                    outToClient.print(capitalizedSentence);
                    outToClient.flush();
                }
            }catch(Exception e){}
        }
    }
}