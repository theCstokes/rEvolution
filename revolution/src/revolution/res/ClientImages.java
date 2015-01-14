/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package revolution.res;

import java.util.HashMap;
import java.util.Stack;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 *
 * @author GeoYS_2
 */
public class ClientImages {
    
    // List of image names for later referencing.
    // Make sure they are all unique.
    // Add to this list whenever we add a new image to load.
    public static String SAMPLE_BUTTON_HOVER = "sampleButtonHover"; // example
    public static String SAMPLE_BUTTON_NORMAL = "sampleButtonNormal"; // example
    public static String SAMPLE_BUTTON_PRESSED = "sampleButtonPressed"; // example
    public static String RABBIT_SPRITESHEET = "rabbitspritesheet";
    public static String SHARK_SPRITESHEET = "SHARK_SPRITESHEET";
    public static String MOOSE_SPRITESHEET = "MOOSE_SPRITESHEET";
    public static String WOLF_SPRITESHEET = "WOLF_SPRITESHEET";
    public static String FOX_SPRITESHEET = "FOX_SPRITESHEET";
    public static String STINGRAY_SPRITESHEET = "STINGRAY_SPRITESHEET";
    public static String GRIZZLY_SPRITESHEET = "GRIZZLY_SPRITESHEET";
    public static String POLAR_SPRITESHEET = "POLAR_SPRITESHEET";
    public static String HAWK_SPRITESHEET = "HAWK_SPRITESHEET";
    public static String PENGUIN_SPRITESHEET = "PENGUIN_SPRITESHEET";
    public static String FISH_SPRITESHEET = "FISH_SPRITESHEET";
    public static String GOAT_SPRITESHEET = "GOAT_SPRITESHEET";
    
    private static HashMap<String, Image> images = new HashMap<>();    
    private static Stack<DeferredImage> toLoad = new Stack<>();
    private static double totalImages;
    
    public static Image getImage(String name){
        return images.get(name);
    }
    
    /**
     * Call before calling loadNext.
     * Add images that you need to be loaded here.
     */
    public static void initiateLoading(){
        toLoad.add(new DeferredImage(SAMPLE_BUTTON_HOVER, "res/sampleButtonHover.png")); // example
        toLoad.add(new DeferredImage(SAMPLE_BUTTON_PRESSED, "res/sampleButtonPressed.png")); // example
        toLoad.add(new DeferredImage(SAMPLE_BUTTON_NORMAL, "res/sampleButtonNormal.png")); // example
        toLoad.add(new DeferredImage(RABBIT_SPRITESHEET, "res/samplespritesheet.png")); // example
        toLoad.add(new DeferredImage(MOOSE_SPRITESHEET, "res/spritesheets/moose.png")); // example
        toLoad.add(new DeferredImage(SHARK_SPRITESHEET, "res/spritesheets/shark.png")); // example
        toLoad.add(new DeferredImage(PENGUIN_SPRITESHEET, "res/spritesheets/penguin.png")); // example
        toLoad.add(new DeferredImage(FISH_SPRITESHEET, "res/spritesheets/fish.png")); // example
        toLoad.add(new DeferredImage(FOX_SPRITESHEET, "res/spritesheets/fox.png")); // example
        toLoad.add(new DeferredImage(POLAR_SPRITESHEET, "res/spritesheets/polarbear.png")); // example
        toLoad.add(new DeferredImage(GRIZZLY_SPRITESHEET, "res/spritesheets/grizzlybear.png")); // example
        toLoad.add(new DeferredImage(GOAT_SPRITESHEET, "res/spritesheets/goat.png")); // example
        toLoad.add(new DeferredImage(HAWK_SPRITESHEET, "res/spritesheets/hawk.png")); // example
        toLoad.add(new DeferredImage(STINGRAY_SPRITESHEET, "res/spritesheets/stingray.png")); // example
        toLoad.add(new DeferredImage(WOLF_SPRITESHEET, "res/spritesheets/wolf.png")); // example
        totalImages = toLoad.size();
    }
    
    /**
     * Loads next image.
     * @return whether or not all images have been loaded
     * @throws SlickException 
     */
    public static boolean loadNext() throws SlickException{
        DeferredImage img = toLoad.pop();
        images.put(img.name, img.load());
        return toLoad.isEmpty();
    }
    
    /**
     * 
     * @return percent of the images that are loaded.
     */
    public static double percentDone(){
        return (toLoad.size() - totalImages) / totalImages;
    }    
}
