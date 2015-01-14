/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package revolution.server.screen.components;

import java.io.IOException;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.gui.GUIContext;
import org.newdawn.slick.state.transition.EmptyTransition;
import org.newdawn.slick.state.transition.FadeInTransition;
import revolution.res.ClientImages;
import revolution.server.Server;
import revolution.server.ServerData;
import revolution.server.ServerFactory;
import revolution.server.screen.MainScreen;
import revolution.server.screen.RunningServerScreen;
import revolution.ui.Button;
import revolution.ui.ComponentGroup;
import revolution.ui.ScreenManager;
import revolution.ui.TextField;
import revolution.ui.TypeFace;
import revolution.util.SSInfo;

/**
 *
 * @author Chris
 */
public class NewServerMenu extends ComponentGroup{
    
    private Button start, back;
    
    private TextField txt;
    
    public String serverName;
    
    public final int START_X = SSInfo.WIDTH / 10; 
    public final int START_Y = 9 * SSInfo.HEIGHT /10;
    public final int BACK_X = 4 * SSInfo.WIDTH /10;
    public final int BACK_Y = 9 * SSInfo.HEIGHT /10;
    public final int TXT_X = (SSInfo.WIDTH / 10) + 200; 
    public final int TXT_Y = 2 * SSInfo.HEIGHT /10;
    private final int WIDTH = 64;
    private final int HEIGHT = 32;
    private final int TXT_WIDTH = 250;
    private final int TXT_HEIGHT = 30;
    
    public NewServerMenu(GUIContext gc, final ScreenManager sm) {
        super(gc, 0, 0);
        
        start = new Button(gc,
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_NORMAL),
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_HOVER),
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_PRESSED),
                START_X, START_Y, WIDTH, HEIGHT){
            @Override
            public void onClick() {
                try {
                    ServerFactory.add(txt.getText(), /* port */ 7999);
                } catch (IOException ex) {
                    Logger.getLogger(NewServerMenu.class.getName()).log(Level.SEVERE, null, ex);
                }  
                RunningServerScreen.serverOverride();
                sm.changeScreen(RunningServerScreen.ID, new EmptyTransition(), new FadeInTransition());
            }
            
        };
        
        back = new Button(gc,
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_NORMAL),
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_HOVER),
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_PRESSED),
                BACK_X, BACK_Y, WIDTH, HEIGHT){
            @Override
            public void onClick() {
                sm.changeScreen(MainScreen.ID, new EmptyTransition(), new FadeInTransition());
            }
            
        };

        txt = new TextField(gc, TypeFace.uni(TypeFace.ARIAL, TypeFace.BOLD, 25) , TXT_X, TXT_Y, TXT_WIDTH, TXT_HEIGHT);
        this.addComponent(txt);
        this.addComponent(start);
        this.addComponent(back);
    }    
}
