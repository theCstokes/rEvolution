/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package revolution.client.game.entity;

import java.util.ArrayList;
import org.newdawn.slick.Image;
import revolution.client.game.entity.Info.Fact;
import revolution.game.creature.Creature;

/**
 *
 * @author geshe9243
 */
public class CreatureEntity extends Entity{

    public CreatureEntity(Creature creature){
        // TODO 
    }
    
    @Override
    public float getX() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public float getY() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public float getWidth() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public float getHeight() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void interact(Entity e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Image getCurrentImage() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(long delta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Info getInfo() {
        return new Info(){

            @Override
            public Image getImage() {
                return getCurrentImage();
            }

            @Override
            public ArrayList<Fact> getFacts() {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public String getName() {
                throw new UnsupportedOperationException("Not supported yet.");
            }
            
        };
    }
    
}
