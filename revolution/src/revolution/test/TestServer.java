/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package revolution.test;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import revolution.net.Socket;
import revolution.server.Server;
import revolution.server.ServerData;

/**
 *
 * @author GeoYS_2
 */
public class TestServer {
    private static Server server;
    
    public static void main(String[] args) throws UnknownHostException, SocketException, IOException{
         server = new Server(/* port */ 7999);
         
         // Simulate an update and render loop in an application
         while(true){
             // update
             server.update(0);
             // render
             System.out.println("Server running");
         }
    }
}
