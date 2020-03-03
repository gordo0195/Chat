/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;
import com.Interface.ChatWin;
import com.Interface.StartWin;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Marco
 */
public class Servidor {
    
    public static void main(String[] args){
        ServerSocket server = null;
        Socket client = null;
        DataInputStream in;
        DataOutputStream out;

        final int PORT = 5000;

        try{
            server = new ServerSocket(PORT);
            System.out.println("Servidor iniciado");

            while (true) {

                client = server.accept();

                System.out.println("Cliente Conectado!");

                in = new DataInputStream(client.getInputStream());
                out = new DataOutputStream(client.getOutputStream());
                
                String mensaje = in.readUTF();

                System.out.println(mensaje);
                out.writeUTF("Hola Mundo desde el Servidor");
                client.close();
                System.out.println("Cliente Desconectado!");

            }
        } 
        catch (IOException ex){
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }

        }
    
}
