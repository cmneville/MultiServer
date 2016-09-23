/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiserver;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author chris
 */
public class ServerEndpoint extends Thread{
    ServerSocket ss;
    Server serv;
    
    public ServerEndpoint(Server s1){
        serv = s1;
    }
    
    public void run(){
        try{
            ss = new ServerSocket();
            ss.bind(new InetSocketAddress("localhost",75));
            
            while(true){
                System.out.println("Accepting Connection");
                Socket s = ss.accept();
                SocketThread st = new SocketThread(s,serv);
                System.out.println("Connection Detected");
                st.start();
                System.out.println("Thread Started");
                serv.addSocket(st);
            }
        }catch(Exception e){System.out.println("Exception");}
    }
}
