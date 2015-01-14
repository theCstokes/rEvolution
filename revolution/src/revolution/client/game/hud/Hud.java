/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package revolution.client.game.hud;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Heads up display class (ie. stuff that is drawn on top of
 * the game).
 * @author GeoYS_2
 */
public abstract class Hud {
    public abstract void render(GameContainer gc, StateBasedGame sbg, Graphics grphcs);
}
