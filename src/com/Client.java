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
import com.Interface.ChatWin;
import com.Interface.StartWin;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Client {
    
    
    private static final Class<Client> CLASS = Client.class;

    public static void main(String[] Args) {

        final String HOST = "127.0.0.1";
        final int PORT = 5000;
        DataInputStream in;
        DataOutputStream out;
        try {
            Socket client = new Socket(HOST, PORT);

            in = new DataInputStream(client.getInputStream());
            out = new DataOutputStream(client.getOutputStream());

            out.writeUTF("Hola mundo desde el cliente");
            String mensaje = in.readUTF();
            System.out.println(mensaje);

            client.close();

        } catch (IOException ex) {
            Logger.getLogger(CLASS.getName()).log(Level.SEVERE, null, ex);

        }

    }
}
