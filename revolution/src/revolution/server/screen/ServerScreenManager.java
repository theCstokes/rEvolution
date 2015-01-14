/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package revolution.server.screen;

import org.newdawn.slick.GameContainer;
import revolution.ui.ScreenManager;

/**
 *
 * @author GeoYS_2
 */
public class ServerScreenManager extends ScreenManager{

    public ServerScreenManager(){
        super("rEvolution Server");
    }
    
    @Override
    public void initStatesList(GameContainer gc) {
        this.addScreen(new MainScreen(this));
        this.addScreen(new NewServerScreen(this));
        this.addScreen(new SavedServerScreen(this));
        this.addScreen(new RunningServerScreen(this));
        
        this.enterState(MainScreen.ID);
    }
    
}
