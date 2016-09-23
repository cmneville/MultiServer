/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiserver;

/**
 *
 * @author chris
 */
public class MultiServer {
    public static void main(String[] args){
        Server server = new Server();
        ServerEndpoint end = new ServerEndpoint(server);
        end.start();
    }
}
