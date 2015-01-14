/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package revolution.client.screen;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import revolution.client.Client;
import revolution.client.screen.components.LobbyMenu;
import revolution.net.Socket;
import revolution.server.ServerData;
import static revolution.server.ServerFactory.servers;
import revolution.server.UserData;
import revolution.ui.Screen;
import revolution.ui.ScreenManager;

/**
 *
 * @author Chris
 */
public class LobbyScreen extends Screen{

    public static int ID = 2;
    
    private LobbyMenu menu;
    
    private ArrayList<ServerData> servers = new ArrayList<ServerData>();
    
    private int count;
    
    //private Client client;
    
    private String conAdd;
    
    private int conPort;
    
    private String out = "add user";
    
    public LobbyScreen(ScreenManager sm) {
        super(sm);
        
        //client = Client.session;
    }

    @Override
    public void init(GameContainer gc, final StateBasedGame sbg) throws SlickException {
        this.clearListeners(); // if this screen had been previously initialised.
        menu = new LobbyMenu(this.getScreenManager().getContainer(), this.getScreenManager());
        this.addListener(menu);
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics grphcs) throws SlickException {
        grphcs.setBackground(Color.darkGray);
        grphcs.drawString("LobbyScreen", 100, 100);
        menu.render(gc, grphcs);      
        grphcs.drawString("Add New User", menu.NEW_X + 100, menu.NEW_Y);
        grphcs.drawString("Log in", menu.LOAD_X + 100, menu.LOAD_Y);
        grphcs.drawString("Exit", menu.EXIT_X + 100, menu.EXIT_Y);
        int i = 0;
        System.out.println(servers.size());
        for(ServerData s : servers) {
            grphcs.drawString(s.hostName, 200 + 100, 200 + (100 * i));
            i++;
            count++;
        }
        System.out.println(count);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {  
        try {
            menu.createList(servers, this.getScreenManager().getContainer(),
                    this.getScreenManager());
        } catch (IOException ex) {
            Logger.getLogger(LobbyScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            servers.clear();
            servers = Client.session.receiveServerBroadcasts();
            System.out.println(servers.size());
            
            // consider these loops as update/render loops
//         if(!client.isConnected()){
//             // receiving server information for lobby
//             ArrayList<ServerData> servers = null;
//             try {
//                 servers = client.receiveServerBroadcasts();
//             } catch (IOException ex) {
//                 Logger.getLogger(LobbyScreen.class.getName()).log(Level.SEVERE, null, ex);
//             }
//             for(ServerData si : servers){
//                 System.out.println("Host name: " + si.hostName + " Port: " + si.port);
//                 System.out.println("Attempting to connect/log in.");
//                 
//                 try {
//                     // attempt to connect to server
//                     client.connect(si.port, si.hostName, "", "", true);
//                 } catch (IOException ex) {
//                     Logger.getLogger(LobbyScreen.class.getName()).log(Level.SEVERE, null, ex);
//                 }
//                 try {
//                     // if userdata is received, than client has connected
//                     client.receiveUserData();
//                 } catch (IOException ex) {
//                     Logger.getLogger(LobbyScreen.class.getName()).log(Level.SEVERE, null, ex);
//                 }
//                 if(client.isConnected()){
//                     conAdd = si.hostName;
//                     conPort = si.port;
//                     break;
//                 }
//             }
//         }
//         //System.out.println("Connected!");
//         if(client.isConnected()){
//             if(menu.addUser){
//                menu.addUser = false;
//             
//             // receiving game world data from server
//             UserData ud = null;
//             try {
//                 ud = client.receiveUserData();
//             } catch (IOException ex) {
//                 Logger.getLogger(LobbyScreen.class.getName()).log(Level.SEVERE, null, ex);
//             }
//             if(ud != null){
//                 System.out.println(ud.message);
//             }
//             }
//         }
//         //System.out.println("Disconnected");
        } catch (IOException ex) {
            Logger.getLogger(LobbyScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public int getID() {
        return ID;
    }
    
}
