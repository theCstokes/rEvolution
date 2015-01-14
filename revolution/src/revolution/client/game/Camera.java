/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package revolution.client.game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Vector2f;

/**
 * A class that hold transformation information for the graphics context
 * so that the right area of the world is drawn (ie. represents 
 * the view).
 * @author GeoYS_2
 */
public abstract class Camera {
    
    private GameContainer gc;
    
    /**
     * Game container serves the purpose of having a reference to the window's
     * width and height.
     * @param gc 
     */
    public Camera(GameContainer gc){
        this.gc = gc;
    }
    
    /**
     * Get width of the window.
     * @return width
     */
    public float getWidth(){
        return gc.getWidth();
    }
    
    /**
     * Get height of the window.
     * @return height
     */
    public float getHeight(){
        return gc.getHeight();
    }
    
    /**
     * Get zoom.
     * @return 
     */
    public abstract float getZoom();
    
    /**
     * Set zoom.
     * @return 
     */
    public abstract void setZoom(float zoom);
    
    /**
     * Set camera location (centre).
     * @param x
     * @param y 
     */
    public abstract void setLocation(float x, float y);
    
    /**
     * Get location of camera (centre).
     * @return 
     */
    public abstract float getX();
    public abstract float getY();
    
    /**
     * Translate the graphics context to the camera's position.
     * @param graphics 
     */
    public abstract void applyTranslation(Graphics graphics);
    
    /**
     * Rotate the camera/view.
     * @param graphics 
     */
    public abstract void applyRotation(Graphics graphics);
    
    /**
     * Apply a scale factor to simulate zooming in and out.
     * @param graphics 
     */
    public abstract void applyZoom(Graphics graphics);
    
    /**
     * Apply transformations to create a feeling of depth.
     * If parallax < 1, less scrolling speed (ie. background).
     * If parallax == 1, no change (ie. middleground).
     * If parallax > 1, faster scrolling speed (ie. foreground).
     * @param graphics
     * @param parallax 
     */
    public abstract void applyParallax(Graphics graphics, float parallax);
    
    /**
     * Reset any previously applied parallax.
     * @param graphics
     * @param parallax 
     */
    public abstract void resetParallax(Graphics graphics, float parallax);
}
