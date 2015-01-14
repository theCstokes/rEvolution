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
import revolution.client.screen.components.NewCreatureMedianMenu;
import revolution.client.screen.components.NewCreatureMenu;
import revolution.ui.Screen;
import revolution.ui.ScreenManager;

/**
 *
 * @author Chris
 */
public class NewCreatureMedianScreen extends Screen {
    
    public static final int ID = 9;
    
    private NewCreatureMedianMenu menu;

    public NewCreatureMedianScreen(ScreenManager sm) {
        super(sm);
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        this.clearListeners(); // if this screen had been previously initialised.
        menu = new NewCreatureMedianMenu(this.getScreenManager().getContainer(), this.getScreenManager());
        this.addListener(menu);
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics grphcs) throws SlickException {
        grphcs.setBackground(Color.darkGray);
        grphcs.drawString("NewCreatureMedianScreen", 100, 25);
        menu.render(gc, grphcs);
        grphcs.drawString("Median", menu.AIR_X - 300, menu.AIR_Y);
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
