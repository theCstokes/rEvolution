/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package revolution.ui;

import java.util.ArrayList;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.InputListener;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.GUIContext;
import org.newdawn.slick.state.StateBasedGame;

/**
 * A grouping of AbstractComponent, eg buttons.
 * Useful, for example, for menus or sub-windows.
 * 
 * FYI:
 * - input events are fired from the GameContainer
 * @author GeoYS_2
 */
public abstract class ComponentGroup extends AbstractComponent{    
    
    private ArrayList<AbstractComponent> components = null;
    private float xOffset, yOffset;
    private int width, height;
    private GUIContext gc;
    
    /**
     * A new empty group of components.
     * @param gc
     * @param xOffset x-offset of all components
     * @param yOffset y-offset of all components
     */
    public ComponentGroup(GUIContext gc, int xOffset, int yOffset){
        super(gc);
        components = new ArrayList<>();
        this.xOffset = xOffset;
        this.yOffset = yOffset;
        this.width = this.height = 0;
        this.gc = gc;
        
        // PROBABLY BAD CONVENTION, BUT THIS IS NECESSARY FOR ALL (!) 
        // COMPONENTS SO THAT THEY WORK CORRECTLY WITH SCREENS AND 
        // TRANSITIONS. MAKE SURE THIS LINE OF CODE IS IN ANY CLASS THAT 
        // IMPLEMENTS THE SLICK ABSTRACTCOMPONENT CLASS!!!!!!
        // THE REASON IS BECAUSE COMPONENTS LIKE BUTTONS SHOULD
        // NOT BE PRIMARY LISTENERS TO INPUT; RATHER THEY SHOULD BE ADDED 
        // TO "SCREENS" (THAT'S HOW I SET IT UP).
        gc.getInput().removeListener(this);
    }

    /**
     * Gets the y offset.
     * @return 
     */
    @Override
    public int getY() {
        return (int)yOffset;
    }

    /**
     * Gets the x offset.
     * @return 
     */
    @Override
    public int getX() {
        return (int)xOffset;
    }
    
    /**
     * Gets the y offset.
     * @return 
     */
    public float getYf(){
        return yOffset;
    }

    /**
     * Gets the x offset.
     * @return 
     */
    public float getXf() {
        return xOffset;
    }

    /**
     * Sets the offset on all the components.
     * @param xOffset
     * @param yOffset 
     */
    @Override
    public void setLocation(int xOffset, int yOffset) {
        //int xDif = xOffset - this.xOffset, yDif = yOffset - this.yOffset;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
        /*if(this.components == null){
            return;
        }
        for(AbstractComponent c : this.components){
            c.setLocation(c.getX() + xDif, c.getY() + yDif);
        }*/
    }
    
    /**
     * Sets the offset on all the components.
     * @param xOffset
     * @param yOffset 
     */
    
    public void setLocation(float xOffset, float yOffset) {
        //int xDif = xOffset - this.xOffset, yDif = yOffset - this.yOffset;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
        /*if(this.components == null){
            return;
        }
        for(AbstractComponent c : this.components){
            c.setLocation(c.getX() + xDif, c.getY() + yDif);
        }*/
    }    
    
    @Override
    public void keyPressed(int key, char c) {
        super.keyPressed(key, c);
        for(InputListener il : this.getComponents()){
            il.keyPressed(key, c);
        }
    }

    @Override
    public void keyReleased(int key, char c) {
        super.keyReleased(key, c);        
        for(InputListener il : this.getComponents()){
            il.keyReleased(key, c);
        }
    }

    @Override
    public void mouseClicked(int button, int x, int y, int clickCount) {
        super.mouseClicked(button, x, y, clickCount);
        for(InputListener il : this.getComponents()){
            il.mouseClicked(button, x - this.getX(), y - this.getY(), clickCount);
        }        
    }

    @Override
    public void mouseDragged(int oldx, int oldy, int newx, int newy) {
        super.mouseDragged(oldx, oldy, newx, newy);
        for(InputListener il : this.getComponents()){
            il.mouseDragged(oldx - this.getX(), oldy - this.getY(),
                    newx - this.getX(), newy - this.getY());
        }        
    }

    @Override
    public void mouseMoved(int oldx, int oldy, int newx, int newy) {
        super.mouseMoved(oldx, oldy, newx, newy);
        for(InputListener il : this.getComponents()){
            il.mouseMoved(oldx - this.getX(), oldy - this.getY(),
                    newx - this.getX(), newy - this.getY());
        }        
    }

    @Override
    public void mousePressed(int button, int x, int y) {
        super.mousePressed(button, x, y);
        for(InputListener il : this.getComponents()){
            il.mousePressed(button, x - this.getX(), y - this.getY());
        }        
    }

    @Override
    public void mouseReleased(int button, int x, int y) {
        super.mouseReleased(button, x, y);
        for(InputListener il : this.getComponents()){
            il.mouseReleased(button, x - this.getX(), y - this.getY());
        }        
    }

    @Override
    public void mouseWheelMoved(int newValue) {
        super.mouseWheelMoved(newValue);
        for(InputListener il : this.getComponents()){
            il.mouseWheelMoved(newValue);
        }        
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }    
    
    public ArrayList<AbstractComponent> getComponents(){
        return components;
    }

    @Override
    public void render(GUIContext guic, Graphics grphcs) throws SlickException {
        for(AbstractComponent c : components){
            c.setLocation(this.getX() + c.getX(), this.getY() + c.getY());
            c.render(guic, grphcs);
            c.setLocation(c.getX() - this.getX(), c.getY() - this.getY());
        }
    }
    
    @Override
    public void setAcceptingInput(boolean acceptingInput) {
        for(AbstractComponent c : components){
            c.setAcceptingInput(acceptingInput);
        }
    }
    
    /**
     * Add a. AbstractComponent implementation, 
     * eg. buttons.
     * @param component 
     */
    public void addComponent(AbstractComponent component){
        //component.setLocation(component.getX() + xOffset, component.getY() + yOffset);
        components.add(component);
    }
    
    /**
     * Remove a. AbstractComponent implementation, 
     * eg. buttons.
     * @param component 
     */
    public void removeComponent(AbstractComponent component){
        components.remove(component);
    }
}
