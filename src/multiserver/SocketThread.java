/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiserver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author chris
 */
public class SocketThread extends Thread{
    Socket s;
    BufferedReader in;
    PrintWriter out;
    Server serv;
    public SocketThread(Socket sock, Server se){
        try{
        s = sock;
        serv = se;
        out = new PrintWriter(s.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        }catch(Exception e){}
        
    }
    
    @Override
    public void run(){
        String input;
        String output;
        while(true){
            try{
                if((input = in.readLine()) != null){
                    serv.acceptInput(input, this);
                }
                
            }catch(Exception e){}
        }
    }
    
    public void write(String s){
        out.println(s);
    }
}
