 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package revolution.game.world;

import java.util.ArrayList;
import org.newdawn.slick.SlickException;
import revolution.client.game.map.Map;
import revolution.client.game.map.MapObject;
import revolution.game.AI.Interact;
import revolution.game.creature.Creature;

/**
 *
 * @author Chris
 */
public class World {
    
    //list of all the different types of creatures
    public ArrayList<Creature> populations;    
    
    private ArrayList<Region> regions;
    
    private transient Map map;
    private String mapPath;
    
    public World(Map map) throws SlickException{
        this.populations = new ArrayList<>();
        this.map = map;
        mapPath = map != null ? map.getPath() : "Bad map";
        regions = new ArrayList<>();
        for(MapObject mo : map.getAreas()){
             regions.add(new Region(mo));
        }
    }    
    
    public void initMap() throws SlickException{
        map = new Map(mapPath);
    }
    
    public Region getRegion(float x, float y) throws SlickException{
        for(MapObject mo : map.getAreas()){
            if(mo.contains(x, y)){
                return new Region(mo);
            }
        }
        return null;
    }
    
    public Map getMap(){
        return map;
    }
    
    // other methods to get information from or add to the world
    
    public void update(long delta){
        // update everything in the world
        // eg. call area.update(); for every area
        
        for(int c1 = 0; c1 < populations.size(); c1++){
            for(int c2 = 0; c2 < populations.size(); c2++){
                Interact.interact(populations.get(c1), populations.get(c2));   
            }
        }
    }
}
