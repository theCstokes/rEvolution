/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package revolution.server.screen;

import java.util.Map;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import revolution.server.Server;
import revolution.server.ServerData;
import revolution.server.ServerFactory;
import revolution.server.User;
import revolution.server.screen.components.LoadServerMenu;
import revolution.ui.Screen;
import revolution.ui.ScreenManager;

/**
 * Screen that lists all previously created servers. 
 * Should have options to start running one of the server
 *
 * @author GeoYS_2
 */
public class SavedServerScreen extends Screen{
    
    public static final int ID = 2;
    
    private LoadServerMenu menu;
    
    public SavedServerScreen(ScreenManager sm){
        super(sm);
    }
    
    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        this.clearListeners(); // if this screen had been previously initialised.
        menu = new LoadServerMenu(this.getScreenManager().getContainer(), this.getScreenManager());
        this.addListener(menu);
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics grphcs) throws SlickException {
        grphcs.setBackground(Color.blue);
        grphcs.drawString("SavedServerScreen", 100, 100);
        menu.render(gc, grphcs);
        grphcs.drawString("Continue", menu.START_X + 100, menu.START_Y);
        grphcs.drawString("Back", menu.BACK_X + 100, menu.BACK_Y);
        int i = 0;
        for(Map.Entry<String, Server> entry : ServerFactory.servers.entrySet()) {
            grphcs.drawString(entry.getKey(), 200 + 100, 200 + (100 * i));
            i++;
        }
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        //System.out.println("Server List Size : " + ServerInfo.names.size());
        menu.createList(this.getScreenManager().getContainer(), 
                this.getScreenManager(), 
                ServerFactory.servers.size());
    }

    @Override
    public int getID() {
        return ID;
    }
    
}
