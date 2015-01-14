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
import revolution.server.screen.components.NewServerMenu;
import revolution.ui.Screen;
import revolution.ui.ScreenManager;

/**
 * Screen with settings of the new server.
 * Should have options to save right away to an xml, and 
 * to run server.
 *
 * @author GeoYS_2
 */
public class NewServerScreen extends Screen{
    
    public static final int ID = 1;
    
    private NewServerMenu menu;
    
    public NewServerScreen(ScreenManager sm){
        super(sm);
    }
    
    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        this.clearListeners(); // if this screen had been previously initialised.
        menu = new NewServerMenu(this.getScreenManager().getContainer(), this.getScreenManager());        
        this.addListener(menu);
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics grphcs) throws SlickException {
        grphcs.setBackground(Color.blue);
        grphcs.drawString("NewServerScreen", menu.START_X, 100);
        menu.render(gc, grphcs);
        grphcs.drawString("Server Name", menu.TXT_X - 200, menu.TXT_Y);
        grphcs.drawString("Continue", menu.START_X + 100, menu.START_Y);
        grphcs.drawString("Back", menu.BACK_X + 100, menu.BACK_Y);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        
    }

    @Override
    public int getID() {
        return ID;
    }
    
}
