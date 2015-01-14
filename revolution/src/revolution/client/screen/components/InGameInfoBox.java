/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package revolution.client.screen.components;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.GUIContext;
import revolution.client.game.entity.Info;
import revolution.client.game.entity.Info.Fact;
import revolution.res.ClientImages;
import revolution.ui.AnimatedComponentGroup;
import revolution.ui.Button;

/**
 *
 * @author geshe9243
 */
public class InGameInfoBox extends AnimatedComponentGroup{
    
    /**
     * -1 means the menu is closing
     * 0 means the menu is stationary
     * 1 means the menu is opening
     */
    private int state;
    private boolean isClosed, isClickedOpen;
    
    private GUIContext gc;
    
    private Info info = null;
    
    private static final int WIDTH = 250, OPENWIDTH = 10;
    
    public InGameInfoBox(GUIContext gc) {
        super(gc, gc.getWidth() - WIDTH, 0);
        
        this.gc = gc;
        
        this.state = 0;
        this.isClosed = false;     
        this.isClickedOpen = false;
        
        this.setWidth(WIDTH);
        this.setHeight(gc.getHeight());
        
        Image normal = ClientImages.getImage(ClientImages.SAMPLE_BUTTON_NORMAL)
                    .getScaledCopy(this.getWidth(), this.getHeight() / 5),
                hover = ClientImages.getImage(ClientImages.SAMPLE_BUTTON_HOVER)
                    .getScaledCopy(this.getWidth(), this.getHeight() / 5),
                pressed = ClientImages.getImage(ClientImages.SAMPLE_BUTTON_PRESSED)
                    .getScaledCopy(this.getWidth(), this.getHeight() / 5);
        
        Button openClose = new Button(gc, 
                normal.getScaledCopy(10, this.getHeight()),
                hover.getScaledCopy(10, this.getHeight()),
                pressed.getScaledCopy(10, this.getHeight()),
                - OPENWIDTH, 0, OPENWIDTH, this.getHeight()){
            @Override
            public void onClick() {
                if(isClosed){
                    state = 1;
                    isClosed = false;
                    isClickedOpen = true;
                }
                else{
                    state = -1;
                    isClickedOpen = false;
                }
            }
        };
        
        this.addComponent(openClose);
    }

    public void setInfo(Info info){
        this.info = info;
    }
    
    @Override
    public void render(GUIContext guic, Graphics grphcs) throws SlickException {
        this.update(this.delta());
        grphcs.setColor(isClickedOpen ? Color.white : Color.lightGray);
        grphcs.fillRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
        super.render(guic, grphcs); //To change body of generated methods, choose Tools | Templates.
        if(info != null){
            //System.out.println("Entity selected...");
            
            // draw name of entity
            grphcs.setColor(Color.black);
            grphcs.drawString(info.getName(), this.getX() + 20, 10);
            
            // draw image of entity
            Image image = info.getImage();            
            int imageW = info.getImage().getWidth(),
                    imageH = info.getImage().getHeight(),
                    boxW = this.getWidth() - 50, boxH = boxW;
            float scale = boxH / imageH > boxW / imageW  ? boxW / imageW : boxH / imageH;
            grphcs.translate(this.getX() + 20, 40);
            grphcs.setColor(Color.yellow);
            grphcs.fillRect(0, 0, boxW, boxH);
            grphcs.translate(boxW/2 - imageW * scale / 2, boxH/2 - imageH * scale / 2);
            grphcs.scale(scale, scale);
            grphcs.drawImage(image,
                    0, 0);
            /* grphcs.setClip(0, 0, boxW, boxH);
            grphcs.drawImage(info.getImage(),
                    (boxW - this.getWidth()) / 2,
                    (boxH - this.getHeight()) / 2);
            grphcs.resetTransform();
            grphcs.clearClip();*/
            grphcs.resetTransform();
           
            // draw facts
            grphcs.setColor(Color.black);
            int i = 1;
            for(Fact f : info.getFacts()){
                grphcs.drawString(f.title + ": " + f.data, this.getX() + 20, boxH + 60 * i);
                i++;
            }
        }
    }
    
    @Override
    protected void update(long delta) {
        float SPEED = 1600; // pix/s
        
        if(state == -1){
            if(this.getX() >= gc.getWidth()){
                this.setLocation(gc.getWidth(), this.getY());
                state = 0;
                isClosed = true;
            }
            else{
                isClosed = false;
                float dSeconds= (float) delta / 1000f;
                this.setLocation(this.getXf() + dSeconds * SPEED, this.getY());
                if(this.getX() >= gc.getWidth()){
                    this.setLocation(gc.getWidth(), this.getY());
                    state = 0;
                    isClosed = true;
                }
            }
        }
        else if(state == 1){
            isClosed = false;
            if(this.getX() <= gc.getWidth() - WIDTH){
                this.setLocation(gc.getWidth() - WIDTH, this.getY());
                state = 0;
            }
            else{
                float dSeconds= (float) delta / 1000f;
                this.setLocation(this.getXf() - dSeconds * SPEED, this.getY());
                if(this.getX() <= gc.getWidth() - WIDTH){
                    this.setLocation(gc.getWidth() - WIDTH, this.getY());
                    state = 0;
                }
            }
        }
    }

    @Override
    public void mouseMoved(int oldx, int oldy, int newx, int newy) {
        super.mouseMoved(oldx, oldy, newx, newy);
        if(isClickedOpen){
            return;
        }
        if(gc.getWidth() - OPENWIDTH <= newx && newx <= gc.getWidth() &&
                0 <= newy && newy <= this.getHeight()){
            state = 1;
        }
        else {
            if(gc.getWidth() - WIDTH <= newx && newx <= gc.getWidth() &&
                0 <= newy && newy <= this.getHeight()){
            }
            else{
                state = -1;
            }
        }
    }

    @Override
    public void mouseClicked(int button, int x, int y, int clickCount) {
        super.mouseClicked(button, x, y, clickCount); //To change body of generated methods, choose Tools | Templates.
        if(gc.getWidth() - WIDTH <= x && x <= gc.getWidth() &&
            0 <= y && y <= this.getHeight() && !this.isClosed){
            this.isClickedOpen = true;
        }
    }
}
