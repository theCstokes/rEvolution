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
import revolution.client.screen.components.NewCreatureMenu;
import revolution.ui.Screen;
import revolution.ui.ScreenManager;

/**
 *
 * @author Chris
 */
public class NewCreatureFamilyScreen extends Screen {
    
    public static final int ID = 6;
    
    private NewCreatureFamilyMenu menu;

    public NewCreatureFamilyScreen(ScreenManager sm) {
        super(sm);
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        this.clearListeners(); // if this screen had been previously initialised.
        menu = new NewCreatureFamilyMenu(this.getScreenManager().getContainer(), this.getScreenManager());
        this.addListener(menu);
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics grphcs) throws SlickException {
        grphcs.setBackground(Color.darkGray);
        grphcs.drawString("NewCreatureFamilyScreen", 100, 25);
        menu.render(gc, grphcs);
        grphcs.drawString("Creature Family Strength (1-10)", menu.FAM_STRENGHT_X - 300, menu.FAM_STRENGHT_Y);
        grphcs.drawString("Creature Reproduction Rate (1-10)", menu.REP_RATE_X - 300, menu.REP_RATE_Y);
        grphcs.drawString("Creature Min Birth Size", menu.MIN_BIRTH_X - 300, menu.MIN_BIRTH_Y);
        grphcs.drawString("Creature Max Birth Size", menu.MAX_BIRTH_X - 300, menu.MAX_BIRTH_Y);
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
