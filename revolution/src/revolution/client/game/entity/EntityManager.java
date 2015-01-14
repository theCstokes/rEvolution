/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package revolution.client.game.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import org.newdawn.slick.Graphics;
import revolution.client.game.Camera;

/**
 * This manages interactions between entities and the ordering in which they
 * are drawn. Non-map Entities should be placed in here so that they will be drawn
 * correctly (ie. so no weird overlapping happens). 
 * 
 * No support for background or foreground entities (yet).
 * @author GeoYS_2
 */
public class EntityManager {
    private ArrayList<Entity> entities;
    public EntityManager(){
        entities = new ArrayList<>();
    }
    
    /**
     * Adds an entity to this manager, and reorders the list based on their 
     * y values (so that no weird overlapping occurs when drawing).
     * @param e 
     */
    public void addEntity(Entity e){
        entities.add(e);
        Collections.sort(entities, new Comparator<Entity>(){
            @Override
            public int compare(Entity e1, Entity e2){
                return (int)e2.getY() - (int)e1.getY();
            }
            public boolean equal(Entity e1, Entity e2){
                return false;
            }
        });
    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }
    
    /**
     * Render all the entities.
     * @param g
     * @param c 
     */
    public void render(Graphics g, Camera c){
        for(Entity e : entities){
            g.translate(e.getX(),e.getY());
            e.render(g);            
            g.translate(-e.getX(),-e.getY());
        }
    }
    
    /**
     * Update all the entities.
     * @param delta Delta time in ms
     */
    public void update(long delta){        
        for(Entity e : entities){
            e.update(delta);
        }
    }
}
