/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package revolution.ui;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.MouseListener;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.GUIContext;
import org.newdawn.slick.gui.MouseOverArea;

/**
 * A simple definition of a GUI (click-able) button 
 * that can be added to a screen and rendered.
 * Be careful of overlapping buttons.
 * @author geshe9243
 */
public abstract class Button extends MouseOverArea{
    
    /**
     * Text displayed in button
     */
    private String text = "";
    
    private Color textColor = Color.red;
    
    public Button(GUIContext gc, Image normal,
            Image pressed, Image hover,
            Shape shape){
        super(gc, normal, shape);
        this.setNormalImage(normal);
        this.setMouseDownImage(pressed);
        this.setMouseOverImage(hover);
                
        // PROBABLY BAD CONVENTION, BUT THIS IS NECESSARY FOR ALL (!) 
        // COMPONENTS SO THAT THEY WORK CORRECTLY WITH SCREENS AND 
        // TRANSITIONS. MAKE SURE THIS LINE OF CODE IS IN ANY CLASS THAT 
        // IMPLEMENTS THE SLICK ABSTRACTCOMPONENT CLASS!!!!!!
        gc.getInput().removeListener(this);
    }
    
    public Button(GUIContext gc, Image normal,
            Image pressed, Image hover, int x, int y, int width, int height){
        super(gc, normal, x, y, width, height);
        this.setNormalImage(normal);
        this.setMouseDownImage(pressed);
        this.setMouseOverImage(hover);
                
        // PROBABLY BAD CONVENTION, BUT THIS IS NECESSARY FOR ALL (!) 
        // COMPONENTS SO THAT THEY WORK CORRECTLY WITH SCREENS AND 
        // TRANSITIONS. MAKE SURE THIS LINE OF CODE IS IN ANY CLASS THAT 
        // IMPLEMENTS THE SLICK ABSTRACTCOMPONENT CLASS!!!!!!
        gc.getInput().removeListener(this);
    }

    @Override
    public void mouseClicked(int button, int x, int y, int clickCount) {   
        super.mouseClicked(button, x, y, clickCount);
        if(this.isMouseOver()){
            onClick();
        }
    }
    
    public void setText(String text){
        this.text = text;
    }
    
    public String getText(String text){
        return this.text;
    }

    public void setTextColor(Color textColor) {
        this.textColor = textColor;
    }

    @Override
    public void render(GUIContext container, Graphics g) {
        super.render(container, g); //To change body of generated methods, choose Tools | Templates.
        Color prevColor = g.getColor();
        g.setColor(textColor);
        g.drawString(text, this.getX() + this.getWidth() / 2 - 5 * text.length() / 2,
                this.getY() + this.getHeight() / 2);
        g.setColor(prevColor);
    }
    
    public abstract void onClick();
}
