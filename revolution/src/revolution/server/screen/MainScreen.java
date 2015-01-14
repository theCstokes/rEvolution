/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package revolution.server.screen;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import revolution.server.screen.components.MainMenu;
import revolution.ui.Screen;
import revolution.ui.ScreenManager;

/**
 * Main screen that opens when server application is run.
 * Should have options to either view already created servers, or 
 * create a new server.
 *
 * @author GeoYS_2
 */
public class MainScreen extends Screen{
    
    public static final int ID = 0;
    
    private MainMenu menu;
    
    public MainScreen(ScreenManager sm){
        super(sm);
    }
    
    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        this.clearListeners(); // if this screen had been previously initialised.
        menu = new MainMenu(this.getScreenManager().getContainer(), this.getScreenManager());
        this.addListener(menu);
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics grphcs) throws SlickException {
        grphcs.setBackground(Color.blue);
        grphcs.drawString("MainScreen", 100, 100);
        menu.render(gc, grphcs);
        grphcs.drawString("New Server Screen", menu.NEW_X + 100, menu.NEW_Y);
        grphcs.drawString("Load Server Screen", menu.LOAD_X + 100, menu.LOAD_Y);
        grphcs.drawString("Save Servers", menu.EXIT_X + 100, menu.EXIT_Y);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        
    }

    @Override
    public int getID() {
        return ID;
    }
    
}
