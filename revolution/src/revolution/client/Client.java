/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package revolution.client;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import revolution.client.screen.ClientScreenManager;
import revolution.game.creature.Creature;
import revolution.net.ObjectPacket;
import revolution.net.Socket;
import revolution.server.ClientRequest;
import static revolution.server.Server.GROUP_NAME;
import static revolution.server.Server.GROUP_PORT;
import revolution.server.ServerData;
import revolution.server.UserData;
import revolution.ui.ScreenManager;
import revolution.util.Stopwatch;

/**
 * Represents the client connection portal to the server.
 * Contains methods to communicate with a "Server."
 * @author Chris
 */
public class Client {
    
    /**
     * Initialized when program, in REvolutionClient main method.
     */
    public static Client session;
    
    private static final long RECEIVE_BROADCAST_TIMEOUT = 200, // for lobby info
            CONNECTION_TIMEOUT = 10000; // milliseconds
    
    private Socket socket;
    private boolean connected = false, disconnected = false;
    private Stopwatch lastData = new Stopwatch(), connectionStart = new Stopwatch();
    
    private ServerData serverData;
    
    public Client(int port) throws UnknownHostException, IOException{
        socket = new Socket(InetAddress.getLocalHost().getHostName(),
            port,
            GROUP_NAME,
            GROUP_PORT);
        lastData.start();
    }
    
    public void setServerData(ServerData server){
        this.serverData = server;
    }

    public ServerData getServerData() {
        return serverData;
    }
    
    public int getPort(){
        return socket.getPort();
    }
    
    public String getHostName(){
        return socket.getAddress().getHostName();
    }
    
    /**
     * Receives any broadcasts that are sent out for duration of 0.5 seconds.
     * @return ArrayList of all ServerInfo's it receives
     */
    public ArrayList<ServerData> receiveServerBroadcasts() throws IOException{
        long last = System.currentTimeMillis();
        ArrayList<ServerData> servers = new ArrayList<>();
        do{
            ObjectPacket o = socket.receiveMulticast();
            if(o != null && o.object instanceof ServerData){
                boolean alreadyContains = false;
                serverLoop : for(ServerData s : servers){
                    if(s.hostName.equals(((ServerData) o.object).hostName)){
                        alreadyContains = true;
                        break serverLoop;
                    }
                }
                if(!alreadyContains){
                    servers.add((ServerData)o.object);
                }
            }
        }while(System.currentTimeMillis() - last< RECEIVE_BROADCAST_TIMEOUT);
        return servers;//socket.receiveMulticast();
    }
    
    /**
     * Receive data about the user and the gameworld, so that the client 
     * can output appropriately.
     * @return
     * @throws IOException 
     */
    public UserData receiveUserData() throws IOException{
        ObjectPacket o = socket.receive();
        if(o == null){
            return null;
        }
        if(o.object instanceof UserData){
            connected = true;
            lastData.restart();
            return (UserData) o.object;
        }
        return null;
    }
    
    /**
     * Whether or not this client is connected to a server (ie. currently in
     * a game). Connection is inferred to be connected by receiving a 
     * UserData packet; it is inferred to be disconnected if 
     * @return 
     */
    public boolean isConnected(){    
        if(connected && lastData.time() >= Client.CONNECTION_TIMEOUT){
            disconnected = true;
        }
        return !disconnected && connected && lastData.time() < Client.CONNECTION_TIMEOUT;
    }
    
    /**
     * Whether or not this client has disconnected from a server.
     * Returns true only if at some point it was connected, and is
     * now disconnected.
     * @return 
     */
    public boolean isDisconnected(){
        return disconnected;
    }
    
    /**
     * Sends a request to specified server to join that game.
     * Returns whether or not it sent the request (false being a timeout).
     * @param port
     * @param hostName
     * @param username
     * @param password
     * @param newUser whether or not logging in or new user
     * @throws IOException 
     * @return requestSent
     */
    public boolean connect(int port, String hostName,
            String username, String password, Creature creature, boolean newUser) throws IOException{
        if(connectionStart.isRunning()){
            if(connectionStart.time() > CONNECTION_TIMEOUT){
                connectionStart.stop();
                return false;
            }
        }
        else{
            connectionStart.start();
        }
        socket.send(
                new ClientRequest(
                    username,
                    password, 
                    creature, // for user created creature
                    newUser),
                hostName,
                port);
        return true;
    }
    
    /**
     * Sends a request to specified server to join that game.
     * Returns whether or not it sent the request (false being a timeout).
     * @param port
     * @param hostName
     * @param username
     * @param password
     * @param newUser whether or not logging in or new user
     * @throws IOException 
     * @return requestSent
     */
    public boolean connect(int port, String hostName,
            String username, String password, boolean newUser) throws IOException{
        if(connectionStart.isRunning()){
            if(connectionStart.time() > CONNECTION_TIMEOUT){
                connectionStart.stop();
                return false;
            }
        }
        else{
            connectionStart.start();
        }
        socket.send(
                new ClientRequest(
                    username,
                    password, 
                    newUser),
                hostName,
                port);
        return true;
    }
    
    /**
     * Reset all connection related variables.
     */
    public void reset(){        
        connected = false;
        disconnected = false;
        lastData = new Stopwatch();
        lastData.start();
        connectionStart = new Stopwatch();
    }
}
