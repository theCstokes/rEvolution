/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package revolution.game.creature.properties;

import revolution.game.creature.properties.PropertySet.Body;
import revolution.game.creature.properties.PropertySet.Personality;
import revolution.game.creature.properties.PropertySet.Environment;

/**
 *
 * @author Chris
 */
public class Property {
    private Object value;
    public Property(Object value){
        this.value = value;
    }
            
    public void set(Object value){
        this.value = value;
    }
    
    public Object get(){
        return value;
    }
}
