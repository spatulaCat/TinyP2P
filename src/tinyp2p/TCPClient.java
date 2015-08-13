
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

class TCPClient {
    //String name="";
    String host = "localhost";
    int port = 6789;
    Socket socket = null;
    String fname;
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
    
//    public static void request(String filename, int size) throws Exception{
//         TCPClient client = new TCPClient();
//         String[] d = {filename,};
//        client.SendToServer(new String d= {filename, size};
//         client.close();
//    }
    
    TCPClient(String _host, int _port, String fname) throws Exception{
        host = _host;
        port = _port;
        socket = new Socket(host, port);
        this.fname = fname;
    }
    TCPClient() throws Exception{
        socket = new Socket(host, port);
    }
    void SendToServer(String[] msg) throws Exception{
        //create output stream attached to socket
        PrintWriter outToServer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        //send msg to server
        outToServer.print(Arrays.toString(msg) + '\n');
        outToServer.flush();
    }
    String RecieveFromServer() throws Exception{
        //create input stream attached to socket
//        BufferedReader inFromServer = new BufferedReader(new InputStreamReader (socket.getInputStream()));
//        //read line from server
//        String res = inFromServer.readLine(); // if connection closes on server end, this throws java.net.SocketException
//
       // int bytesRead;
       // int currentTot = 0;
       // int filesize = 483329;
      
        
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
       // int byteToBeRead = -1;
        //byte [] bytearray = new byte [filesize];
        InputStream is = socket.getInputStream();
        System.out.println(fname);
        FileOutputStream fos = new FileOutputStream(fname);
        System.out.println("opening stream");
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        
        int count;
        byte[] buffer = new byte[8192];
        while ((count = is.read(buffer)) > 0)
        {
            bos.write(buffer, 0, count);
             bos.flush();
        }
       
            socket.close();
        
//        try (BufferedOutputStream bos = new BufferedOutputStream(fos)) {
//            System.out.println("reading bytes");
//            bytesRead = is.read(bytearray,0,bytearray.length);
//            System.out.println("update total");
//            currentTot = bytesRead;
//            System.out.println("Listening for the file");
//            do { bytesRead = is.read(bytearray, currentTot, (bytearray.length-currentTot));
//            if(bytesRead >= 0) currentTot += bytesRead;
//            }
//            
//            int count;
//            byte[] buffer = new byte[8192];
//            while ((count = in.read(buffer)) > 0)
//            {
//                out.write(buffer, 0, count);
//            }
//            
//            while(bytesRead > -1);
//            bos.write(bytearray, 0 , currentTot);
//            bos.flush();
//            socket.close();
 //       }
       
        System.out.println("file successfully transferred");
        
        
        return "success";
    }
    void close() throws IOException{
        socket.close();
    }
}