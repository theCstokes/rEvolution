/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package revolution.client.game.map;

import java.util.HashMap;
import org.newdawn.slick.tiled.GroupObject;

/**
 *
 * @author geshe9243
 */
public class MapObject {
    private HashMap<String, String> properties;
    
    // TODO, initialise these 
    //          v  v  v      v
    private int x, y, width, height;
    
    public MapObject(){
        properties = new HashMap<>();
    }
    
    public MapObject(GroupObject groupObject){
        this.x = groupObject.x;
        this.y = groupObject.y;
        this.width = groupObject.width;
        this.height = groupObject.height;
        properties = new HashMap<>();
        for(Object key : groupObject.props.keySet()){
            properties.put((String)key, groupObject.props.getProperty((String)key));
        }
    }
    
    public void addProperties(String propertyName, String propertyValue){
        properties.put(propertyName, propertyValue);
    }
    
    public String getProperty(String propertyName){
        return properties.get(propertyName);
    }
    
    public boolean contains(float x, float y){
        return this.x <= x && x <= this.x + width && this.y <= y && y <= this.y + height;
    }
    
    public boolean containsProperty(String name){
        return properties.containsKey(name);
    }
}
