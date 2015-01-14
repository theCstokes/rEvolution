/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package revolution.server;

import java.io.IOException;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import revolution.net.ObjectPacket;
import revolution.net.Socket;

/**
 *
 * @author Chris
 */
public class Server {
    public static final int GROUP_PORT = 9899;
    public static final String GROUP_NAME = "235.2.2.2";
    
    /** Users online */
    private ArrayList<User> users = new ArrayList<>();
    /** Usernames mapped to the respective User objects */
    private static HashMap<String,User> accounts = new HashMap<>();
    
    private Socket socket;
    
    public Server(int port) throws UnknownHostException, SocketException, IOException{
        socket = new Socket(InetAddress.getLocalHost().getHostName(),
                port,
                GROUP_NAME,
                GROUP_PORT);                              
    }
    
    public Server(String pathToXML) throws UnknownHostException, SocketException, IOException{
        // when server is started from a saved session/game
    }
    
    public void update(long delta) throws IOException{
        receive();
        sendWorldInfo();
        sendInvitationBroadcast();
    }
    
    // public Info getInfo()
    // Returns information about the gameworld so that the Screen can output 
    // appropriate information
    
    public void receive() throws IOException{
        // recieves object from socket
        // decide what to do based on the type of the object
        ObjectPacket op = socket.receive();
        if(op == null){
            return;
        }
        Object o = op.object;
        System.out.println(users.size() + " " + accounts.size());
        if(o instanceof ClientRequest){
            ClientRequest cr = (ClientRequest) o;
            if(cr.newUser){
                if(!accounts.containsKey(cr.username)){
                    accounts.put(cr.username,
                            new User(op.port, op.address.getHostName(), cr.password, cr.creature));
                    users.add(accounts.get(cr.username));
                }
            }
            else{
                if(!users.contains(accounts.get(cr.username)) &&
                    isLoginValid(cr.username, cr.password)){
                    User u = accounts.get(cr.username);
                    u.setPort(op.port);
                    u.setHostName(op.address.getHostName());
                    users.add(u);
                }    
            }
        }
    }
    
    private boolean isLoginValid(String username, String password){
        return accounts.get(username).password.equals(password);
    }
    
    public void sendWorldInfo() throws IOException{
        // send to each address already connect info on the world
        for(User u : users){
            socket.send(new UserData(), u.hostName, u.port);
        }
    }
    
    public void sendInvitationBroadcast() throws IOException{
        // send lobby broadcast
        socket.sendMulticast(new ServerData(
                socket.getAddress().getHostName(),
                socket.getPort()));
    }
    
    public int getPort(){
        return GROUP_PORT;
    }
    
    public void save(){
        UserFactory.saveUser(accounts);
    }  
    
    public void load(){
        accounts = UserFactory.loadUser();
    } 
    
    public static HashMap<String, User> getAllUsers(){
        return accounts;
    }
}


