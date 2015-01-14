/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package revolution.test.clientgame;

import org.newdawn.slick.SlickException;
import revolution.client.game.map.Map;
import revolution.game.world.World;

/**
 *
 * @author GeoYS_2
 */
public class TestWorld extends World{

    public TestWorld() throws SlickException {
        super(new Map("res/gamemaps/island.tmx"));
    }
    
}
