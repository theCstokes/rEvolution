/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package revolution.client.screen.components;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.GUIContext;
import revolution.res.ClientImages;
import revolution.ui.AnimatedComponentGroup;
import revolution.ui.Button;
import revolution.ui.ComponentGroup;

/**
 *
 * @author geshe9243
 */
public class InGameMenu extends AnimatedComponentGroup{

    /**
     * -1 means the menu is closing
     * 0 means the menu is stationary
     * 1 means the menu is opening
     */
    private int state;
    private boolean isClosed;
    
    private static final int WIDTH = 100, OPENWIDTH = 10;
    
    public InGameMenu(GUIContext gc) {
        super(gc, 0, 0);
        
        this.state = 0;
        this.isClosed = false;
        
        this.setWidth(WIDTH);
        this.setHeight(gc.getHeight());
        
        Image normal = ClientImages.getImage(ClientImages.SAMPLE_BUTTON_NORMAL)
                    .getScaledCopy(this.getWidth(), this.getHeight() / 5),
                hover = ClientImages.getImage(ClientImages.SAMPLE_BUTTON_HOVER)
                    .getScaledCopy(this.getWidth(), this.getHeight() / 5),
                pressed = ClientImages.getImage(ClientImages.SAMPLE_BUTTON_PRESSED)
                    .getScaledCopy(this.getWidth(), this.getHeight() / 5);
        
        Button logoutExit = new Button(gc, 
                normal,
                hover,
                pressed,
                0, this.getHeight()  * 4 / 5, this.getWidth(), this.getHeight() / 5){
            @Override
            public void onClick() {
                // TODO implement logout and exit
                System.err.println("Logout and exit not implemented");
                System.exit(123456789);
            }
        };
        logoutExit.setText("Logout/Exit");
        Button accountInfo = new Button(gc, 
                normal,
                hover,
                pressed,
                0, this.getHeight()  * 3 / 5, this.getWidth(), this.getHeight() / 5){
            @Override
            public void onClick() {
                //sm.changeScreen(LobbyScreen.ID, new FadeOutTransition(), new FadeInTransition());
            }
        };
        Button leaderboard = new Button(gc, 
                normal,
                hover,
                pressed,
                0, this.getHeight() * 2 / 5, this.getWidth(), this.getHeight() / 5){
            @Override
            public void onClick() {
                //sm.changeScreen(LobbyScreen.ID, new FadeOutTransition(), new FadeInTransition());
            }
        };
        Button worldStatus = new Button(gc, 
                normal,
                hover,
                pressed,
                0, this.getHeight() * 1 / 5, this.getWidth(), this.getHeight() / 5){
            @Override
            public void onClick() {
                //sm.changeScreen(LobbyScreen.ID, new FadeOutTransition(), new FadeInTransition());
            }
        };
        Button myCreatures = new Button(gc, 
                normal,
                hover,
                pressed,
                0, this.getHeight() * 0 / 5, this.getWidth(), this.getHeight() / 5){
            @Override
            public void onClick() {
                //sm.changeScreen(LobbyScreen.ID, new FadeOutTransition(), new FadeInTransition());
            }
        };
        this.addComponent(logoutExit);
        this.addComponent(accountInfo);
        this.addComponent(leaderboard);        
        this.addComponent(worldStatus);
        this.addComponent(myCreatures);
        
        Button openClose = new Button(gc, 
                normal.getScaledCopy(10, this.getHeight()),
                hover.getScaledCopy(10, this.getHeight()),
                pressed.getScaledCopy(10, this.getHeight()),
                WIDTH, 0, 10, this.getHeight()){
            @Override
            public void onClick() {
                System.out.println("Clicked");
                if(isClosed){
                System.out.println("Opened");
                    state = 1;
                    isClosed = false;
                }
            }
        };
        
        this.addComponent(openClose);
    }

    @Override
    public void render(GUIContext guic, Graphics grphcs) throws SlickException {
        this.update(this.delta());
        //grphcs.fillRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
        super.render(guic, grphcs);
    }
    
    @Override
    protected void update(long delta) {
        float SPEED = 800; // pix/s
        
        if(state == -1){
            if(this.getX() <= -WIDTH){
                this.setLocation(-WIDTH, this.getY());
                state = 0;
                isClosed = true;
            }
            else{
                isClosed = false;
                float dSeconds= (float) delta / 1000f;
                this.setLocation(this.getXf() - dSeconds * SPEED, this.getY());
                if(this.getX() <= -WIDTH){
                    this.setLocation(-WIDTH, this.getY());
                    state = 0;
                    isClosed = true;
                }
            }
        }
        else if(state == 1){
            isClosed = false;
            if(this.getX() >= 0){
                this.setLocation(0, this.getY());
                state = 0;
            }
            else{
                float dSeconds= (float) delta / 1000f;
                this.setLocation(this.getXf() + dSeconds * SPEED, this.getY());
                if(this.getX() >= 0){
                    this.setLocation(0, this.getY());
                    state = 0;
                }
            }
        }
    }

    @Override
    public void mouseMoved(int oldx, int oldy, int newx, int newy) {
        super.mouseMoved(oldx, oldy, newx, newy);
        if(0 <= newx && newx <= OPENWIDTH &&
                0 <= newy && newy <= this.getHeight()){
            state = 1;
        }
        else if(0 <= newx && newx <= this.getWidth() &&
                0 <= newy && newy <= this.getHeight()){
        }
        else{
            state = -1;
        }
    }
}
