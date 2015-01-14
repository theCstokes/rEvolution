/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package revolution.client.game.map;

import java.util.ArrayList;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.GroupObject;
import org.newdawn.slick.tiled.ObjectGroup;
import org.newdawn.slick.tiled.TiledMap;

/**
 * A map that will be drawn using Tiled. Can either be the map of the 
 * world overview, or zoomed in, where creatures can be controlled.
 * @author GeoYS_2
 */
public class Map extends TiledMap{
    private final ArrayList<MapObject> mapObjects;
    private String path;
    public Map(String path) throws SlickException{
        super(path);
        this.path = path;
        mapObjects = new ArrayList<>();
        for(ObjectGroup og : objectGroups){
            for(GroupObject go : og.getObjects()){
                mapObjects.add(new MapObject(go));
            }
        }
    }
    
    public String getPath(){
        return path;
    }
    
    public ArrayList<MapObject> getAreas(){
        ArrayList<MapObject> areas = new ArrayList<>();
        for(MapObject mo : mapObjects){
            if(mo.getProperty("type").equals("area")){
                areas.add(mo);
            }
        }
        return areas;
    }
    
    public ArrayList<MapObject> getMapObjects(){
        return mapObjects;
    }
}
