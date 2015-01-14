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
import revolution.client.screen.components.NewCreatureMenu;
import revolution.ui.Screen;
import revolution.ui.ScreenManager;

/**
 *
 * @author Chris
 */
public class NewCreatureFoodScreen extends Screen {
    
    public static final int ID = 7;
    
    private NewCreatureFoodMenu menu;

    public NewCreatureFoodScreen(ScreenManager sm) {
        super(sm);
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        this.clearListeners(); // if this screen had been previously initialised.
        menu = new NewCreatureFoodMenu(this.getScreenManager().getContainer(), this.getScreenManager());
        this.addListener(menu);
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics grphcs) throws SlickException {
        grphcs.setBackground(Color.darkGray);
        grphcs.drawString("NewCreatureFoodScreen", 100, 25);
        menu.render(gc, grphcs);
        grphcs.drawString("Creature Food Heigth(1-10)", menu.HEIGHT_X - 300, menu.HEIGTH_Y);
        grphcs.drawString("Creature Food Length (1-10)", menu.LENGTH_X - 300, menu.LENGTH_Y);
        grphcs.drawString("Creature Food Weight (1-10)", menu.WEIGHT_X - 300, menu.WEIGHT_Y);
        grphcs.drawString("Creature Feed Frequency (1-10)", menu.FREQUENCY_X - 300, menu.FREQUENCY_Y);
        grphcs.drawString("Creature Meat Tolerance (1-10)", menu.MEAT_X - 300, menu.MEAT_Y);
        grphcs.drawString("Creature Veg Tolerance (1-10)", menu.VEG_X - 300, menu.VEG_Y);
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
