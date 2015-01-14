/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package revolution.test;

import org.newdawn.slick.Animation;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

/**
 *
 * @author GeoYS_2
 */
public class TestSprite extends BasicGame{
    
    private SpriteSheet spritesheet;
    private Animation animation;

    public TestSprite(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gc) throws SlickException {        
        spritesheet = new SpriteSheet("res/samplespritesheet.png", 32, 32);
        animation = new Animation(spritesheet,
                new int[]{0,1,   1,1,    2,1,   1,1}, 
                new int[]{300, 300, 300, 300});
    }

    @Override
    public void update(GameContainer gc, int i) throws SlickException {
    }

    @Override
    public void render(GameContainer gc, Graphics grphcs) throws SlickException {
        for(int i = 0; i < spritesheet.getVerticalCount(); i ++){
            for(int j = 0; j < spritesheet.getHorizontalCount(); j ++){
                grphcs.drawImage(spritesheet.getSprite(j, i), 100 * j, 100 * i);
            }
        }
        animation.draw(150, 150);
    }
    
    public static void main(String[] args) throws SlickException{
        AppGameContainer app = new AppGameContainer(new TestSprite("Test Sprite"));
        app.start();
    }
    
}
