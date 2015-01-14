/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package revolution.client.screen.components;

import java.util.ArrayList;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;
import revolution.client.game.Camera;
import revolution.client.game.EntitySelector;
import revolution.client.game.WorldView;
import revolution.client.game.entity.EntityManager;
import revolution.client.game.map.Map;
import revolution.client.game.map.MapObject;
import revolution.client.screen.components.InGameInfoBox;
import revolution.client.screen.components.InGameMenu;
import revolution.client.screen.running.RunningCamera;
import revolution.client.screen.running.RunningEntity;
import revolution.client.screen.running.RunningWorld;
import revolution.res.ClientImages;
import revolution.test.clientgame.*;
import revolution.ui.Screen;
import revolution.ui.ScreenManager;

/**
 *
 * @author GeoYS_2
 */
public class GameScreen extends Screen {
    
    public static final int ID = 100;

    private EntitySelector selector;
    private EntityManager entityManager;
    private RunningCamera cam;
    private InGameMenu menu;
    private InGameInfoBox infobox;
    private RunningWorld testWorld;
    private WorldView view;
    //private Map map;
    
    public GameScreen(ScreenManager sm){
        super(sm);
    }
    
    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        cam = new RunningCamera(gc, 0, 0);
        gc.getInput().addMouseListener(cam);
        menu = new InGameMenu(gc);
        gc.getInput().addMouseListener(menu);
        infobox = new InGameInfoBox(gc);
        gc.getInput().addMouseListener(infobox);
        testWorld = new RunningWorld();
        view = new WorldView(testWorld, cam);
        entityManager = new EntityManager();
        for(int i = 0; i < 10; i ++){
            entityManager.addEntity(
                    new RunningEntity(90 + 10 * (float)Math.random(),
                        90 + 10 * (float)Math.random(), i, view.getCurrentMap())
                    );
        }
        selector = new EntitySelector(entityManager.getEntities(),view);
        gc.getInput().addMouseListener(selector);
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics grphcs) throws SlickException {
        cam.applyTranslation(grphcs);
        cam.applyZoom(grphcs);
        
        //if(cam.getZoom() > 10){
            grphcs.setAntiAlias(true);
        //}
        
        view.getCurrentMap().render(0, 0);
        
        //map.render(0, 0);
        grphcs.setColor(Color.yellow);
        entityManager.render(grphcs, cam);
        grphcs.drawOval(-5, -5, 10, 10); // origin
        grphcs.resetTransform();
        
        //cross hair
        grphcs.setColor(Color.white);
        grphcs.drawRect(gc.getWidth() / 2 - 10,
                gc.getHeight() / 2 - 10,
                20, 20);
        grphcs.drawOval(gc.getWidth() / 2 - 1, gc.getHeight() / 2 - 1,
                2, 2);
        grphcs.drawString((int)-cam.getX() + " " + (int)-cam.getY() + " Zoom: " + cam.getZoom(), gc.getWidth() / 2 + 20, gc.getHeight() / 2 - 10);
        
        grphcs.resetTransform();
        menu.render(gc, grphcs);
        infobox.render(gc, grphcs);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        view.update();
        entityManager.update(i);
        if(selector.getSelected() != null){
            infobox.setInfo(selector.getSelected().getInfo());
        }
    }
    
    @Override
    public int getID() {
        return ID;
    }
}
