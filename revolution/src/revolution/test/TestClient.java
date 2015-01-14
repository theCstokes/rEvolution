/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package revolution.test;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import revolution.client.Client;
import revolution.net.ObjectPacket;
import revolution.net.Socket;
import revolution.server.ServerData;
import revolution.server.UserData;

/**
 *
 * @author GeoYS_2
 */
public class TestClient {
    private static Client client;
    
    public static void main(String[] args) throws UnknownHostException, IOException{
         client = new Client(/* port */ 9901);
         
         // consider these loops as update/render loops
         while(!client.isConnected()){
             // receiving server information for lobby
             ArrayList<ServerData> servers = client.receiveServerBroadcasts();
             for(ServerData si : servers){
                 System.out.println("Host name: " + si.hostName + " Port: " + si.port);
                 System.out.println("Attempting to connect/log in.");
                 
                 // attempt to connect to server
                 client.connect(si.port, si.hostName, "", "", null, true);
                 // if userdata is received, than client has connected
                 client.receiveUserData();
                 if(client.isConnected()){
                     break;
                 }
             }
         }
         System.out.println("Connected!");
         while(client.isConnected()){
             // receiving game world data from server
             UserData ud = client.receiveUserData();
             if(ud != null){
                 System.out.println(ud.message);
             }
         }
         System.out.println("Disconnected");
    }
}
