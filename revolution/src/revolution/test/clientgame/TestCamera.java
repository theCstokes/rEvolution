/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package revolution.test.clientgame;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.MouseListener;
import org.newdawn.slick.geom.Vector2f;
import revolution.client.game.Camera;

/**
 *
 * @author GeoYS_2
 */
public class TestCamera extends Camera implements MouseListener{

    private static final float MAX_ZOOM = 5;
    private float cx, cy, 
            scale;
    
    public TestCamera(GameContainer gc, 
            float x, // centre x
            float y  // centre y
            ){
        super(gc);
        this.cx = x;
        this.cy = y;
        scale = 1;
    }    

    @Override
    public void setLocation(float x, float y) {
        cx = x;
        cy = y;
    }
    
    @Override
    public float getZoom(){
        return scale;
    }

    @Override
    public void setZoom(float zoom){
        scale = zoom;
    }
    
    @Override
    public float getX(){
        return cx;
    }
    
    @Override
    public float getY(){
        return cy;
    }
    
    @Override
    public void applyTranslation(Graphics graphics) {
        graphics.translate(cx + this.getWidth() / 2,
                cy + this.getHeight() / 2);
    }

    @Override
    public void applyRotation(Graphics graphics) {
    }

    @Override
    public void applyZoom(Graphics graphics) {
        graphics.translate(cx * scale  - cx, cy * scale  - cy);
        graphics.scale(scale, scale);
    }

    @Override
    public void applyParallax(Graphics graphics, float parallax) {
    }

    @Override
    public void resetParallax(Graphics graphics, float parallax) {
    }
    
    @Override
    public void mouseWheelMoved(int i) {
        //System.out.println("Mouse wheel moved: " + i);
        scale *=  Math.pow(2.0, (float) i / 720);
        /*if (scale > 2f) {
            scale = 2f;
        }*/
    }

    @Override
    public void mouseClicked(int i, int i1, int i2, int i3) {
    }

    @Override
    public void mousePressed(int i, int i1, int i2) {
    }

    @Override
    public void mouseReleased(int i, int i1, int i2) {
    }

    @Override
    public void mouseMoved(int i, int i1, int i2, int i3) {
    }

    @Override
    public void mouseDragged(int i, int i1, int i2, int i3) {
        float deltaX = i2 - i, deltaY = i3 - i1;
        cx += deltaX / scale;
        cy += deltaY / scale;
    }

    @Override
    public void setInput(Input input) {
    }

    @Override
    public boolean isAcceptingInput() {
        return true; // always accepting
    }

    @Override
    public void inputEnded() {
    }

    @Override
    public void inputStarted() {
    }
    
}
