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
import revolution.client.screen.components.NewCreatureMenu;
import revolution.ui.Screen;
import revolution.ui.ScreenManager;

/**
 *
 * @author Chris
 */
public class NewCreatureScreen extends Screen {
    
    public static final int ID = 5;
    
    private NewCreatureMenu menu;

    public NewCreatureScreen(ScreenManager sm) {
        super(sm);
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        this.clearListeners(); // if this screen had been previously initialised.
        menu = new NewCreatureMenu(this.getScreenManager().getContainer(), this.getScreenManager());
        this.addListener(menu);
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics grphcs) throws SlickException {
        grphcs.setBackground(Color.darkGray);
        grphcs.drawString("NewCreatureScreen", 100, 25);
        menu.render(gc, grphcs);
        grphcs.drawString("Creature Name", menu.NAME_X - 200, menu.NAME_Y);
        grphcs.drawString("Creature Height (1-10)", menu.HEIGHT_X - 200, menu.HEIGHT_Y);
        grphcs.drawString("Creature Lenght (1-10)", menu.LENGHT_X - 200, menu.LENGHT_Y);
        grphcs.drawString("Creature Weight (1-10)", menu.WEIGHT_X - 200, menu.WEIGHT_Y);
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
