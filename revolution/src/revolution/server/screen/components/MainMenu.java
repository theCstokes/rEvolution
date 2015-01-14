/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package revolution.server.screen.components;

import org.newdawn.slick.gui.GUIContext;
import org.newdawn.slick.state.transition.EmptyTransition;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
import revolution.game.creature.Creature;
import revolution.res.ClientImages;
import revolution.server.Server;
import revolution.server.ServerFactory;
import revolution.server.screen.NewServerScreen;
import revolution.server.screen.SavedServerScreen;
import revolution.ui.Button;
import revolution.ui.ComponentGroup;
import revolution.ui.ScreenManager;
import revolution.util.SSInfo;

/**
 *
 * @author geshe9243
 */
public class MainMenu extends ComponentGroup{
    
    private Button newServer, loadServer, exit;
    
    public final int NEW_X = SSInfo.WIDTH / 10; 
    public final int NEW_Y = 9 * SSInfo.HEIGHT /10;
    public final int LOAD_X = 4 * SSInfo.WIDTH /10;
    public final int LOAD_Y = 9 * SSInfo.HEIGHT /10;
    public final int EXIT_X = 7 * SSInfo.WIDTH /10;
    public final int EXIT_Y = 9 * SSInfo.HEIGHT /10;
    private final int WIDTH = 64;
    private final int HEIGHT = 32;
    
    public MainMenu(GUIContext gc, final ScreenManager sm){
        super(gc, 0, 0);
        newServer = new Button(gc, 
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_NORMAL),
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_HOVER),
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_PRESSED),
                NEW_X, NEW_Y, WIDTH, HEIGHT){
            @Override
            public void onClick() {
                sm.changeScreen(NewServerScreen.ID, new EmptyTransition(), new FadeInTransition());
            }
        };
        loadServer = new Button(gc, 
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_NORMAL),
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_HOVER),
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_PRESSED),
                LOAD_X, LOAD_Y, WIDTH, HEIGHT){
            @Override
            public void onClick() {
                sm.changeScreen(SavedServerScreen.ID, new EmptyTransition(), new FadeInTransition());
            }
        };
        exit = new Button(gc, 
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_NORMAL),
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_HOVER),
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_PRESSED),
                EXIT_X, EXIT_Y, WIDTH, HEIGHT){
            @Override
            public void onClick() {
                ServerFactory.saveServer(ServerFactory.servers);
            }
        };
        this.addComponent(exit);
        this.addComponent(newServer);
        this.addComponent(loadServer);
    }
}
