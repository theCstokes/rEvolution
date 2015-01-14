/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package revolution.game.creature.properties;

import java.util.HashMap;
import javax.print.attribute.standard.MediaName;
import revolution.game.creature.Creature;
import revolution.game.creature.properties.Types.Brain;
import revolution.game.creature.properties.Types.Family;
import revolution.game.creature.properties.Types.Food;
import revolution.game.creature.properties.Types.Location;
import revolution.game.creature.properties.Types.Median;
import revolution.game.creature.properties.Types.Size;

/**
 *
 * @author Christopher Stokes
 */
public class PropertySet {
          
    HashMap<String, Property> properties = new HashMap<>();
    public Body body;
    public Personality personality;
    public Environment environment;
    public Relation relation;
    
    public class Body {
        public Size size;
    }

    public class Personality {
        public Brain brain;
        public Food food;
        public Relation family;
    }
    
    public class Environment {
        public Median median = new Median();
        public Location location = new Location();
    }
    
    public class Relation {
        public Family family;
    }
    
    public PropertySet(){
        this.body = new Body();
        this.personality = new Personality();
        this.environment = new Environment();
        this.relation = new Relation();
    }
}
