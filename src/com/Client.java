/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

/**
 *
 * @author Marco
 */
import com.Interface.ChatServer;
import com.Interface.ChatClient;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Client implements Runnable{
    
    private int port;
    private String message;
    
    public Client(int port, String message){
        
        this.port = port;
        this.message = message;
    }

    @Override
    public void run() {
        
       final String HOST = "127.0.0.1";
      
        //DataInputStream in;
        DataOutputStream out;
        try {
            Socket client = new Socket(HOST, port);

           // in = new DataInputStream(client.getInputStream());
            out = new DataOutputStream(client.getOutputStream());

            out.writeUTF(message);
           

            client.close();

        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);

        }

    }
    
    public static void main(String[] Args) {

    
    }
}
