/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package revolution.client.game;

import java.util.ArrayList;
import org.newdawn.slick.Input;
import org.newdawn.slick.MouseListener;
import org.newdawn.slick.geom.Vector2f;
import revolution.client.game.entity.Entity;

/**
 *
 * @author geshe9243
 */
public class EntitySelector implements MouseListener{
    private Entity selected = null;
    private ArrayList<Entity> entities;
    private boolean isDragging;
    private WorldView view;
    
    public EntitySelector(ArrayList<Entity> entities, WorldView view){
        this.entities = entities;
        isDragging = false;
        this.view = view;
    }
    
    public Entity getSelected(){
        return selected;
    }

    @Override
    public void mouseWheelMoved(int i) {
    }

    @Override
    public void mouseClicked(int i, int i1, int i2, int i3) {        
        float x = view.screenToWorldX(i1),
                y = view.screenToWorldY(i2);
        System.out.println("Selector mouse released");
        if(isDragging){
            isDragging = false;
        }
        else{
            selected = null;
            for(Entity e : entities){
                /*System.out.println("Ent pos: " + e.getX() + "," + e.getX() + 
                        "Mouse pos: " + x + "," + y);*/
                if(e.getX() <= x && x <= e.getX() + e.getWidth() &&
                        e.getY() <= y && y <= e.getY() + e.getHeight()){
                    selected = e;
                    System.out.println("Entity selected!");
                    return;
                }
            }
        }
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
        isDragging = isDragging ? isDragging : new Vector2f(i, i1).distanceSquared(new Vector2f(i2, i3)) > 9;
        //System.out.print("Selector dragging: " + isDragging);
    }

    @Override
    public void setInput(Input input) {
    }

    @Override
    public boolean isAcceptingInput() {
        return true;
    }

    @Override
    public void inputEnded() {
    }

    @Override
    public void inputStarted() {
    }
    
}
