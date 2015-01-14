/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package revolution.client.screen;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import revolution.client.screen.components.MainMenu;
import revolution.res.ClientImages;
import revolution.ui.Screen;
import revolution.ui.ScreenManager;

/**
 *
 * @author GeoYS_2
 */
public class MainMenuScreen extends Screen{
    
    public static final int ID = 1;
    
    private MainMenu menu;
        
    public MainMenuScreen(ScreenManager sm) {
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
        grphcs.setBackground(Color.darkGray);
        grphcs.drawString("MainScreen", 100, 100);
        menu.render(gc, grphcs);
        grphcs.drawString("Got To Lobby", menu.NEW_X + 100, menu.NEW_Y);
        grphcs.drawString("(Not Implemented)", menu.EXIT_X + 100, menu.EXIT_Y);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
    }

    @Override
    public int getID() {
        return ID;
    }
    
}
