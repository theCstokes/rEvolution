/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package revolution.test.clientgame;

import java.util.ArrayList;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Vector2f;
import revolution.client.game.entity.Entity;
import revolution.client.game.entity.Info;
import revolution.client.game.entity.Info.Fact;
import revolution.client.game.map.Map;
import revolution.res.ClientImages;

/**
 *
 * @author GeoYS_2
 */
public class TestEntity extends Entity{
    
    private int id;
    private float x, y, 
            vx, vy; // pixels per second
    private float width, height;
    private SpriteSheet spritesheet;
    private Animation up, down, left, right, currentAnimation;
    private boolean isMoving;
    private Circle target; 
    private Map map;
    
    public TestEntity(float x, float y, int id, Map map) throws SlickException{
        this.map = map;
        this.id = id;
        this.x = x; 
        this.y = y;
        vx = -5 + 10 * (float)Math.random();
        vy = -5 + 10 * (float)Math.random();
        width = 32;
        height = 32;
        Image image = Math.random() > 0.5 ? ClientImages.getImage(ClientImages.RABBIT_SPRITESHEET)
                : ClientImages.getImage(ClientImages.WOLF_SPRITESHEET);
        spritesheet = new SpriteSheet(image,
                image.getWidth() / 3,
                image.getHeight() / 4);
        int spritespeed = 200;
        down = new Animation(spritesheet, 
                new int[]{1,0,   0,0,    1,0,   2,0}, 
                new int[]{spritespeed, spritespeed, spritespeed, spritespeed});
        left = new Animation(spritesheet,
                new int[]{1,1,   0,1,    1,1,   2,1}, 
                new int[]{spritespeed, spritespeed, spritespeed, spritespeed});
        right = new Animation(spritesheet, 
                new int[]{1,2,   0,2,    1,2,   2,2}, 
                new int[]{spritespeed, spritespeed, spritespeed, spritespeed});
        up = new Animation(spritesheet, 
                new int[]{1,3,   0,3,    1,3,   2,3}, 
                new int[]{spritespeed, spritespeed, spritespeed, spritespeed});
        isMoving = false;
        currentAnimation = down;
    }

    @Override
    public Info getInfo() {
        return new Info(){

            @Override
            public Image getImage() {
                return getCurrentImage();
            }

            @Override
            public ArrayList<Fact> getFacts() {
                ArrayList<Fact> facts = new ArrayList<>();
                facts.add(new Fact("Position", (int)getX() + "," + (int)getY()));
                return facts;
            }

            @Override
            public String getName() {
                return "Dummy Entity #" + id;
            }
            
        };
    }

    @Override
    public float getX() {
        return x;
    }

    @Override
    public float getY() {
        return y;
    }

    @Override
    public float getWidth() {
        return width;
    }

    @Override
    public float getHeight() {
        return height;
    }

    @Override
    public void interact(Entity e) {
    }

    @Override
    public Image getCurrentImage() {
        return currentAnimation.getCurrentFrame();
    }

    @Override
    public void update(long delta) {
        if(isMoving){
            currentAnimation.update(delta);
            this.x += vx * delta / 1000;
            this.y += vy * delta / 1000;
            if(new Vector2f(this.x, this.y)
                    .distance(new Vector2f(target.getCenterX(), target.getCenterY())) 
                    < 2){
                this.x = target.getCenterX();
                this.y = target.getCenterY();
                isMoving = false;
                currentAnimation.setCurrentFrame(0);
            }
        }
        else{
            if(Math.random() < 0.01){
                isMoving = true;
                float x,y;
                do{
                    x = (float)Math.random() * 100 - 50;
                    y = (float)Math.random() * 100 - 50;
                }while(!(0 < this.x + x && this.x + x < map.getWidth() * map.getTileWidth() &&
                        0 < this.y + y && this.y + y < map.getHeight() * map.getTileHeight()));
                target = new Circle(this.x + x, this.y + y, this.width / 2);
                vx = (target.getCenterX() - this.x);
                vy = (target.getCenterY() - this.y);
                
                if(Math.abs(x) > Math.abs(y)){
                    if(x > 0){
                        currentAnimation = right;
                    }
                    else{
                        currentAnimation = left;
                    }
                }
                else{
                    if(y > 0){
                        currentAnimation = down;
                    }
                    else{
                        currentAnimation = up;
                    }
                }
            }
        }
        /*x += vx * ((double)delta / 1000);
        y += vy * ((double)delta / 1000);*/
        /*if(this.y < 0 ){
            this.y = 0;
        }
        else if(this.y > map.getHeight() * map.getTileHeight()){
            this.y = map.getHeight() * map.getTileHeight();
        }
        if(this.x < 0 ){
            this.x = 0;
        }
        else if(this.x > map.getWidth() * map.getTileWidth()){
            this.x = map.getWidth() * map.getTileWidth();
        }*/
    }
    
}
