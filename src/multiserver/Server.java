/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiserver;

import java.util.ArrayList;

/**
 *
 * @author chris
 */
public class Server {
    ArrayList<SocketThread> threads;
    
    public Server(){
        threads = new ArrayList<>();
        //start();
    }
    
//    public void start(){
//        
//    }
    
    public void addSocket(SocketThread st){
        threads.add(st);
    }
    
    public void acceptInput(String in, SocketThread t){
        for(SocketThread thread : threads){
            if(!(thread.equals(t))){
                thread.write(in);
            }
        }
    }
}
