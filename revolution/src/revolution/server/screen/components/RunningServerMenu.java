/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package revolution.server.screen.components;

import org.newdawn.slick.gui.GUIContext;
import org.newdawn.slick.state.transition.EmptyTransition;
import org.newdawn.slick.state.transition.FadeInTransition;
import revolution.res.ClientImages;
import revolution.server.screen.MainScreen;
import revolution.server.screen.NewServerScreen;
import revolution.ui.Button;
import revolution.ui.ComponentGroup;
import revolution.ui.ScreenManager;
import revolution.util.SSInfo;

/**
 *
 * @author Chris
 */
public class RunningServerMenu extends ComponentGroup{
    
    private Button stats, stop;
    
    public final int STATS_X = SSInfo.WIDTH / 10; 
    public final int STATS_Y = 9 * SSInfo.HEIGHT /10;
    public final int STOP_X = 4 * SSInfo.WIDTH /10;
    public final int STOP_Y = 9 * SSInfo.HEIGHT /10;
    private final int WIDTH = 64;
    private final int HEIGHT = 32;

    public RunningServerMenu(GUIContext gc, final ScreenManager sm) {
        super(gc, 0, 0);
        
        stats = new Button(gc,
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_NORMAL),
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_HOVER),
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_PRESSED),
                STATS_X, STATS_Y, WIDTH, HEIGHT){
            @Override
            public void onClick() {
                sm.changeScreen(MainScreen.ID, new EmptyTransition(), new FadeInTransition());
            }
            
        };
        
        stop = new Button(gc,
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_NORMAL),
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_HOVER),
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_PRESSED),
                STOP_X, STOP_Y, WIDTH, HEIGHT){
            @Override
            public void onClick() {
                sm.changeScreen(MainScreen.ID, new EmptyTransition(), new FadeInTransition());
            }
            
        };
        this.addComponent(stats);
        this.addComponent(stop);
    }  
}
