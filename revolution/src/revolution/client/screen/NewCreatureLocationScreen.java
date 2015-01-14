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
import revolution.client.screen.components.MainMenu;
import revolution.client.screen.components.NewCreatureFamilyMenu;
import revolution.client.screen.components.NewCreatureFoodMenu;
import revolution.client.screen.components.NewCreatureLocationMenu;
import revolution.client.screen.components.NewCreatureMenu;
import revolution.ui.Screen;
import revolution.ui.ScreenManager;

/**
 *
 * @author Chris
 */
public class NewCreatureLocationScreen extends Screen {
    
    public static final int ID = 10;
    
    private NewCreatureLocationMenu menu;

    public NewCreatureLocationScreen(ScreenManager sm) {
        super(sm);
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        this.clearListeners(); // if this screen had been previously initialised.
        menu = new NewCreatureLocationMenu(this.getScreenManager().getContainer(), this.getScreenManager());
        this.addListener(menu);
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics grphcs) throws SlickException {
        grphcs.setBackground(Color.darkGray);
        grphcs.drawString("NewCreatureFoodScreen", 100, 25);
        menu.render(gc, grphcs);
        grphcs.drawString("Water Source", menu.ONE_X - 300, menu.ONE_Y);
        grphcs.drawString("Sleeping Area", menu.THREE_X - 300, menu.THREE_Y);
        grphcs.drawString("Feeding Area", menu.FIVE_X - 300, menu.FIVE_Y);
        grphcs.drawString("Nesting Area", menu.SEVEN_X - 300, menu.SEVEN_Y);
        grphcs.drawString("Migration Area Start", menu.NINE_X - 300, menu.NINE_Y);
        grphcs.drawString("Migration Area Through", menu.ELEVEN_X - 300, menu.ELEVEN_Y);
        grphcs.drawString("Migration Area End", menu.THERTEEN_X - 300, menu.THERTEEN_Y);
        grphcs.drawString("Continue", menu.NEW_X + 100, menu.NEW_Y);
        grphcs.drawString("Back", menu.EXIT_X + 100, menu.EXIT_Y);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        
    }

    @Override
    public int getID() {
        return ID;
    }
    
}
