/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package revolution.client.game.entity;

import java.util.ArrayList;
import org.newdawn.slick.Image;

/**
 *  A class to hold the information to display in the InGameInfoBox.
 * @author GeoYS_2
 */
public interface Info {
    
    /**
     * Get image of the selected entity.
     * @return 
     */
    public Image getImage();
    
    /**
     * Get facts about the entity (eg. size, population, whatever...)
     * @return 
     */
    public ArrayList<Fact> getFacts();
    
    /**
     * Get the name of the entity.
     * @return 
     */
    public String getName();
    
    public class Fact{
        public String title, data;
        public Fact (String title, String data){
            this.title = title;
            this.data = data;
        }
    }
}
