/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;
import com.Interface.ChatServer;
import com.Interface.ChatClient;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Marco
 */
public class Servidor extends Observable implements Runnable {
    
    private int puerto;
            
         
    
    public Servidor(int puerto){
    
        this.puerto = puerto;
    }
    
    public static void main(String[] args){
       
    }
    @Override
    public void run() {
        ServerSocket Server = null;
        Socket Client = null;
        
        DataInputStream in;
        DataOutputStream out;

       try{
            Server = new ServerSocket(puerto);
            System.out.println("Servidor iniciado");

            while (true) {

                Client = Server.accept();

                System.out.println("Cliente Conectado!");

                in = new DataInputStream(Client.getInputStream());
                //out = new DataOutputStream(Client.getOutputStream());
                
                String Message = in.readUTF();
                
                this.setChanged();
                this.notifyObservers(Message);
                this.clearChanged();
                
                Client.close();
                System.out.println("Cliente Desconectado!");

            }
        } 
        catch (IOException ex){
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }

        }
    }
    

