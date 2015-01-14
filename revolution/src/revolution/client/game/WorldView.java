/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package revolution.client.game;

import org.newdawn.slick.SlickException;
import revolution.client.game.Camera;
import revolution.client.game.map.Map;
import revolution.game.world.Region;
import revolution.game.world.Region.Portion;
import revolution.game.world.World;

/**
 * A wrapper class of a World, to help in getting the correct map to 
 * display based on zoom.
 * @author GeoYS_2
 */
public class WorldView {
    
    private Camera cam;
    private World world;
    private Region currentRegion;
    private Portion currentPortion;
    private Map currentMap;
    
    public WorldView (World world, Camera cam){
        this.world = world;
        currentMap = world.getMap();
        currentRegion = null;
        currentPortion = null;
        this.cam = cam;
    }
    
    public float screenToWorldX(float screenX){
        float newX = -cam.getX() + (screenX - cam.getWidth() / 2) / cam.getZoom() ;
        return newX;
    }
    
    public float screenToWorldY(float screenY){
        float newY = -cam.getY() + (screenY - cam.getHeight() / 2) / cam.getZoom() ;     
        return newY;
    }
    
    /**
     * Returns the current Map to be displayed.
     * @return 
     */
    public Map getCurrentMap(){
        return currentMap;
    }
    
    /**
     * Update the current map.
     * @param x
     * @param y
     * @param zoom
     */
    public void update() throws SlickException{
        if(currentRegion == null){
            if(cam.getZoom() > 5){
                System.out.println("Map changed");
                currentRegion = world.getRegion(-cam.getX(), -cam.getY());
                currentMap = currentRegion.getMap();
                cam.setZoom(1);
            }
        }
        else {
            if(currentPortion == null){
                if(cam.getZoom() > 5){           
                System.out.println("Map changed");         
                    currentPortion = currentRegion.getPortion(-cam.getX(), -cam.getY());
                    currentMap = currentPortion.getMap();
                    cam.setZoom(1);
                }
                else if(cam.getZoom() < 1){
                    System.out.println("Map changed");
                    currentRegion = null;
                    currentMap = world.getMap();
                    cam.setZoom(5);
                }
            }
            else{
                if(cam.getZoom() < 1){
                    System.out.println("Map changed");
                    currentPortion = null;
                    currentMap = currentRegion.getMap();
                    cam.setZoom(5);
                }
                else if(cam.getZoom() > 5){
                    cam.setZoom(5);
                }
            }
        }
    }
}
