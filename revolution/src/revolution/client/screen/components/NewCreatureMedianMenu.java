/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package revolution.client.screen.components;

import org.newdawn.slick.gui.GUIContext;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
import revolution.client.game.entity.NewCreature;
import revolution.client.screen.LobbyScreen;
import revolution.client.screen.NewCreatureBrainScreen;
import revolution.client.screen.NewCreatureFamilyScreen;
import revolution.client.screen.NewCreatureLocationScreen;
import revolution.client.screen.NewCreatureScreen;
import revolution.res.ClientImages;
import revolution.ui.Button;
import revolution.ui.ComponentGroup;
import revolution.ui.ScreenManager;
import revolution.ui.TextField;
import revolution.ui.TypeFace;
import revolution.util.CSInfo;

/**
 *
 * @author Chris
 */
public class NewCreatureMedianMenu extends ComponentGroup{
    
    private Button connect, back, air, water, ground;
    
    public final int NEW_X = CSInfo.WIDTH / 10; 
    public final int NEW_Y = 9 * CSInfo.HEIGHT /10;
    public final int EXIT_X = 7 * CSInfo.WIDTH /10;
    public final int EXIT_Y = 9 * CSInfo.HEIGHT /10;
    private final int WIDTH = 64;
    private final int HEIGHT = 32;
    
    public final int AIR_X = (CSInfo.WIDTH / 10) + 300; 
    public final int AIR_Y = 2 * CSInfo.HEIGHT /10;
    public final int WATER_X = (CSInfo.WIDTH / 10) + 300; 
    public final int WATER_Y = 3 * CSInfo.HEIGHT /10;
    public final int GROUND_X = (CSInfo.WIDTH / 10) + 300; 
    public final int GROUND_Y = 4 * CSInfo.HEIGHT /10;
    private final int TXT_WIDTH = 250;
    private final int TXT_HEIGHT = 30;
    
    public static int median;

    public NewCreatureMedianMenu(GUIContext gc, final ScreenManager sm) {        
        super(gc, 0, 0);
        connect = new Button(gc, 
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_NORMAL),
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_HOVER),
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_PRESSED),
                NEW_X, NEW_Y, WIDTH, HEIGHT){
            @Override
            public void onClick() {
                sm.changeScreen(NewCreatureLocationScreen.ID, new FadeOutTransition(), new FadeInTransition());
            }
        };
        back = new Button(gc, 
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_NORMAL),
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_HOVER),
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_PRESSED),
                EXIT_X, EXIT_Y, WIDTH, HEIGHT){
            @Override
            public void onClick() {
                sm.changeScreen(NewCreatureFamilyScreen.ID, new FadeOutTransition(), new FadeInTransition());
            }
        };
        air = new Button(gc, 
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_NORMAL),
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_HOVER),
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_PRESSED),
                AIR_X, AIR_Y, WIDTH, HEIGHT){
            @Override
            public void onClick() {
                air.setAcceptingInput(true);
                water.setAcceptingInput(false);
                ground.setAcceptingInput(false);
                median = 0;
            }
        };
        water = new Button(gc, 
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_NORMAL),
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_HOVER),
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_PRESSED),
                WATER_X, WATER_Y, WIDTH, HEIGHT){
            @Override
            public void onClick() {
                air.setAcceptingInput(false);
                water.setAcceptingInput(true);
                air.setAcceptingInput(false);
                median = 1;
            }
        };
        ground = new Button(gc, 
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_NORMAL),
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_HOVER),
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_PRESSED),
                GROUND_X, GROUND_Y, WIDTH, HEIGHT){
            @Override
            public void onClick() {
                air.setAcceptingInput(false);
                water.setAcceptingInput(false);
                ground.setAcceptingInput(true);
                median = 2;
            }
        };        
        air.setText("Air");
        water.setText("Water");
        ground.setText("Ground");
        this.addComponent(air);
        this.addComponent(water);
        this.addComponent(ground);
        this.addComponent(connect);
        this.addComponent(back);
    }
}
