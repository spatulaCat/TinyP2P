
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

class TCPClient {
    //String name="";
    String host = "146.231.123.43";
    int port = 6789;
    Socket socket = null;
//    public static void main(String args[]) throws Exception{
//       // TCPClient client = new TCPClient();
//       // client.SendToServer("");
//        System.out.println("Server Said(1): "+client.RecieveFromServer());
//        client.SendToServer("Hey dude 2");
//        System.out.println("Server Said(2): "+client.RecieveFromServer());
//       // client.close();
//        
//        //request("tiny.png",255);
//        
//        
//    }
    
    public static void request(String filename, int size) throws Exception{
         TCPClient client = new TCPClient();
        client.SendToServer(filename + size);
         client.close();
    }

    TCPClient(String _host, int _port) throws Exception{
        host = _host;
        port = _port;
        socket = new Socket(host, port);
    }
    TCPClient() throws Exception{
        socket = new Socket(host, port);
    }
    void SendToServer(String msg) throws Exception{
        //create output stream attached to socket
        PrintWriter outToServer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        //send msg to server
        outToServer.print(msg + '\n');
        outToServer.flush();
    }
    String RecieveFromServer() throws Exception{
        //create input stream attached to socket
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader (socket.getInputStream()));
        //read line from server
        String res = inFromServer.readLine(); // if connection closes on server end, this throws java.net.SocketException 
        return res;
    }
    void close() throws IOException{
        socket.close();
    }
}