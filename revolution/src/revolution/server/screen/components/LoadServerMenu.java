/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package revolution.server.screen.components;

import java.nio.file.StandardWatchEventKinds;
import java.util.ArrayList;
import java.util.Map;
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
import revolution.util.SSInfo;

/**
 *
 * @author Chris
 */
public class LoadServerMenu extends ComponentGroup{
    private Button btn1, back;
    
    private ArrayList<Button> serverList = new ArrayList<>();

    public final int START_X = SSInfo.WIDTH / 10; 
    public final int START_Y = 9 * SSInfo.HEIGHT /10;
    public final int BACK_X = 4 * SSInfo.WIDTH /10;
    public final int BACK_Y = 9 * SSInfo.HEIGHT /10;
    private final int WIDTH = 64;
    private final int HEIGHT = 32;
    
    private int place = 0;
    
    public LoadServerMenu(GUIContext gc, final ScreenManager sm) {
        super(gc, 0, 0);
        
        btn1 = new Button(gc,
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_NORMAL),
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_HOVER),
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_PRESSED),
                START_X, START_Y, WIDTH, HEIGHT){
            @Override
            public void onClick() {
                sm.changeScreen(MainScreen.ID, new EmptyTransition(), new FadeInTransition());
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
        
        for(int i = 0; i < 4; i++){
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
        }
        
        
        
        this.addComponent(btn1);
        this.addComponent(back);
    }
    
    public void createList(GUIContext gc, final ScreenManager sm, int size){
        for(int i = 0; i < serverList.size(); i++){
        this.removeComponent(serverList.get(i));
        }
        serverList.clear();
        for(Map.Entry<String, Server> entry : ServerFactory.servers.entrySet()) {
            final String serverName = entry.getKey();
            serverList.add(new Button(gc,
                    ClientImages.getImage(ClientImages.SAMPLE_BUTTON_NORMAL),
                    ClientImages.getImage(ClientImages.SAMPLE_BUTTON_HOVER),
                    ClientImages.getImage(ClientImages.SAMPLE_BUTTON_PRESSED),
                    200, (200 + (place * 100)), WIDTH, HEIGHT){
                @Override
                public void onClick() {
                    ServerFactory.currentServer = serverName;
                    System.out.println("Button number : " + serverName);
                    RunningServerScreen.serverOverride();
                    sm.changeScreen(RunningServerScreen.ID, new EmptyTransition(), new FadeInTransition());
                };
                }
            );
            this.addComponent(serverList.get(place));
            place ++;
        }
        place = 0;
        //System.out.println("out");
    }
}
