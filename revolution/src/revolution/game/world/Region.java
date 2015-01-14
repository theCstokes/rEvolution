/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package revolution.game.world;

import org.newdawn.slick.SlickException;
import revolution.client.game.map.Map;
import revolution.client.game.map.MapObject;

/**
 *
 * @author Chris
 */
public class Region {
    
    private Map map;
    
    public Region(MapObject area) throws SlickException{
        // from the mapObject (ie. area), decide what map to use
        //if(area.getProperty("environment").equals("grass")){
            map = new Map("res/samplemap/samplegrassregion.tmx");
        //}
        
    }    
    
    public Map getMap(){
        return map;
    }
    
    public void update(long delta){
        // update everything in this area, eg. for each population
        // population.update(delta) or something
    }
    
    public Portion getPortion(float x, float y) throws SlickException{
        for(MapObject mo : map.getAreas()){
            if(mo.contains(x, y)){
                return new Portion(mo);
            }
        }
        return null;
    }
    
    public class Portion{
        private Map map;
        public Portion(MapObject mapObject) throws SlickException{
            // from the mapObject (ie. area), decide what map to use
            //if(area.getProperty("environment").equals("grass")){
                map = new Map("res/samplemap/samplegrassportion.tmx");
            //}
        }
        public Map getMap(){
            return map;
        }
    }
}
