/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package revolution.ui;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.GUIContext;

/**
 *
 * @author GeoYS_2
 */
public abstract class AnimatedComponentGroup extends ComponentGroup{

    private long lastRender;
    
    public AnimatedComponentGroup(GUIContext gc, int xOffset, int yOffset) {
        super(gc, xOffset, yOffset);
    }

    /**
     * Call update in implemented classes in the render method.
     * @param guic
     * @param grphcs
     * @throws SlickException 
     */
    @Override
    public void render(GUIContext guic, Graphics grphcs) throws SlickException {
        super.render(guic, grphcs);
    }
    
    public long delta(){
        long thisRender = System.currentTimeMillis();
        long delta = thisRender - lastRender;
        lastRender = thisRender;
        return delta;
    }
    
    protected abstract void update(long delta);
    
}
