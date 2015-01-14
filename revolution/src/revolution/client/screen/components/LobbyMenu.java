/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package revolution.client.screen.components;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.GUIContext;
import org.newdawn.slick.state.transition.EmptyTransition;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
import org.newdawn.slick.state.transition.HorizontalSplitTransition;
import revolution.client.Client;
import revolution.client.screen.LobbyScreen;
import revolution.client.screen.LogInScreen;
import revolution.client.screen.MainMenuScreen;
import revolution.client.screen.NewCreatureScreen;
import revolution.client.screen.NewUserScreen;
import revolution.res.ClientImages;
import revolution.server.ServerData;
import revolution.ui.Button;
import revolution.ui.ComponentGroup;
import revolution.ui.ScreenManager;
import revolution.util.CSInfo;

/**
 *
 * @author geshe9243
 */
public class LobbyMenu extends ComponentGroup{
    
    private Button add, load, exit;
    
    private ArrayList<Button> btn = new ArrayList<Button>();
    
    private ArrayList<ServerData> servers = new ArrayList<ServerData>();
    
    private int place = 0;
    
    public final int BTN_X = 7 * CSInfo.WIDTH /10;
    public final int BTN_Y = CSInfo.HEIGHT /10;
    public final int NEW_X = CSInfo.WIDTH / 10; 
    public final int NEW_Y = 9 * CSInfo.HEIGHT /10;
    public final int LOAD_X = 3 * CSInfo.WIDTH / 10; 
    public final int LOAD_Y = 9 * CSInfo.HEIGHT /10;
    public final int EXIT_X = 7 * CSInfo.WIDTH /10;
    public final int EXIT_Y = 9 * CSInfo.HEIGHT /10;
    private final int WIDTH = 64;
    private final int HEIGHT = 32;
    
    public boolean addUser = false;
    public LobbyMenu(GUIContext context, final ScreenManager sm) {
        super(context, 0, 0);
        add = new Button(context, 
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_NORMAL),
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_HOVER),
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_PRESSED),
                NEW_X, NEW_Y, WIDTH, HEIGHT){
            @Override
            public void onClick() {
                addUser = true;
                try {
                    Client.session.setServerData(Client.session.receiveServerBroadcasts().get(0));
                } catch (IOException ex) {
                    Logger.getLogger(LobbyMenu.class.getName()).log(Level.SEVERE, null, ex);
                }
                sm.changeScreen(NewCreatureScreen.ID, new FadeOutTransition(), new FadeInTransition());
            }
        };
        load = new Button(context, 
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_NORMAL),
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_HOVER),
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_PRESSED),
                LOAD_X, LOAD_Y, WIDTH, HEIGHT){
            @Override
            public void onClick() {
                try {
                    Client.session.setServerData(Client.session.receiveServerBroadcasts().get(0));
                } catch (IOException ex) {
                    Logger.getLogger(LobbyMenu.class.getName()).log(Level.SEVERE, null, ex);
                }
                sm.changeScreen(LogInScreen.ID, new FadeOutTransition(), new FadeInTransition());
            }
        };
        exit = new Button(context, 
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_NORMAL),
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_HOVER),
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_PRESSED),
                EXIT_X, EXIT_Y, WIDTH, HEIGHT){
            @Override
            public void onClick() {
                sm.changeScreen(LogInScreen.ID, new FadeOutTransition(), new FadeInTransition());
            }
        };
        this.addComponent(add);
        this.addComponent(load);
        this.addComponent(exit);
    }
    
    public void createList(ArrayList<ServerData> servers, GUIContext gc, final ScreenManager sm) throws IOException{
        
        if(servers.isEmpty()){
            return;
        }

        //servers = Client.session.receiveServerBroadcasts();
        for(int i = 0; i < btn.size(); i++){
            this.removeComponent(btn.get(i));
        }
        btn.clear();
        for(ServerData s : servers) {
            System.out.println("Number of servers: " + servers.size());
            btn.add(new Button(gc,
                    ClientImages.getImage(ClientImages.SAMPLE_BUTTON_NORMAL),
                    ClientImages.getImage(ClientImages.SAMPLE_BUTTON_HOVER),
                    ClientImages.getImage(ClientImages.SAMPLE_BUTTON_PRESSED),
                    200, (200 + (place * 100)), WIDTH, HEIGHT){
                @Override
                public void onClick() {
                    
                };
                }
            );
            this.addComponent(btn.get(place));
            place ++;
        }
        place = 0;
        //System.out.println("out");
    }
}
