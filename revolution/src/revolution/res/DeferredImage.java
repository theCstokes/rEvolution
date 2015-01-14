/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package revolution.res;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


/**
 * A wrapper class that allows an image to be loaded individually,
 * thus allowing drawing in between images, therefor allowing 
 * a loading bar.
 */
public class DeferredImage{
    public String name, path;
    public DeferredImage(String name, String path){
        this.name = name;
        this.path = path;
    }
    public Image load() throws SlickException{
        return new Image(path);
    }
}
