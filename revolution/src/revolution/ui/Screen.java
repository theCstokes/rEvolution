/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package revolution.ui;

import com.sun.org.apache.bcel.internal.generic.GETFIELD;
import java.util.ArrayList;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.InputListener;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.Transition;

/**
 *
 * @author Chris
 */
public abstract class Screen extends BasicGameState{
    private ScreenManager screenManager;
    private ArrayList<InputListener> listeners;
    public Screen(ScreenManager sm){
        this.screenManager = sm;
        listeners = new ArrayList<>();
    }
    public ScreenManager getScreenManager(){
        return screenManager;
    }
    
    /**
     * Register that the component is attached to the screen.
     * @param c 
     */
    public void addListener(InputListener c){
        listeners.add(c);
    }
    
    public ArrayList<InputListener> getListeners(){
        return listeners;
    }
    public void clearListeners(){
        listeners.clear();
    }
    public void removeListener(InputListener il){
        if(listeners.contains(il)){
            listeners.remove(il);
        }
    }
    
    @Override
    public abstract void init(GameContainer gc, StateBasedGame sbg) throws SlickException;
    @Override
    public abstract void render(GameContainer gc, StateBasedGame sbg, Graphics grphcs) throws SlickException ;
    @Override
    public abstract void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException;
    @Override
    public abstract int getID();

    @Override
    public void keyPressed(int key, char c) {
        super.keyPressed(key, c);
        for(InputListener il : this.getListeners()){
            il.keyPressed(key, c);
        }
    }

    @Override
    public void keyReleased(int key, char c) {
        super.keyReleased(key, c);        
        for(InputListener il : this.getListeners()){
            il.keyReleased(key, c);
        }
    }

    @Override
    public void mouseClicked(int button, int x, int y, int clickCount) {
        super.mouseClicked(button, x, y, clickCount);
        for(InputListener il : this.getListeners()){
            il.mouseClicked(button, x, y, clickCount);
        }        
    }

    @Override
    public void mouseDragged(int oldx, int oldy, int newx, int newy) {
        super.mouseDragged(oldx, oldy, newx, newy);
        for(InputListener il : this.getListeners()){
            il.mouseDragged(oldx, oldy, newx, newy);
        }        
    }

    @Override
    public void mouseMoved(int oldx, int oldy, int newx, int newy) {
        super.mouseMoved(oldx, oldy, newx, newy);
        for(InputListener il : this.getListeners()){
            il.mouseMoved(oldx, oldy, newx, newy);
        }        
    }

    @Override
    public void mousePressed(int button, int x, int y) {
        super.mousePressed(button, x, y);
        for(InputListener il : this.getListeners()){
            il.mousePressed(button, x, y);
        }        
    }

    @Override
    public void mouseReleased(int button, int x, int y) {
        super.mouseReleased(button, x, y);
        for(InputListener il : this.getListeners()){
            il.mouseReleased(button, x, y);
        }        
    }

    @Override
    public void mouseWheelMoved(int newValue) {
        super.mouseWheelMoved(newValue);
        for(InputListener il : this.getListeners()){
            il.mouseWheelMoved(newValue);
        }        
    }
}
