/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package revolution.client.screen;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import revolution.client.screen.components.LogInMenu;
import revolution.client.screen.components.NewCreatureLocationMenu;
import revolution.client.screen.components.NewUserMenu;
import revolution.ui.Screen;
import revolution.ui.ScreenManager;

/**
 *
 * @author Christopher Stokes
 */
public class LogInScreen extends Screen{
    public static int ID = 12;

    private LogInMenu menu;
    
    public LogInScreen(ScreenManager sm) {
        super(sm);
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        this.clearListeners(); // if this screen had been previously initialised.
        menu = new LogInMenu(this.getScreenManager().getContainer(), this.getScreenManager());
        this.addListener(menu);
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics grphcs) throws SlickException {
        grphcs.setBackground(Color.darkGray);
        grphcs.drawString("LogInScreen", 100, 25);
        menu.render(gc, grphcs);
        grphcs.drawString("User Name", menu.USER_X - 300, menu.USER_Y);
        grphcs.drawString("User Password", menu.PASS_X - 300, menu.START_Y);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        
    }

    @Override
    public int getID() {
        return ID;
    }
    
    
}
