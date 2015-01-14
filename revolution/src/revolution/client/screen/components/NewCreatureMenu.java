/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package revolution.client.screen.components;

import org.newdawn.slick.gui.GUIContext;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
import revolution.client.screen.LobbyScreen;
import revolution.client.screen.NewCreatureFamilyScreen;
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
public class NewCreatureMenu extends ComponentGroup{
    
    private Button next, exit;
    
    private TextField name, height, length, weight;
    
    public final int NEW_X = CSInfo.WIDTH / 10; 
    public final int NEW_Y = 9 * CSInfo.HEIGHT /10;
    public final int EXIT_X = 7 * CSInfo.WIDTH /10;
    public final int EXIT_Y = 9 * CSInfo.HEIGHT /10;
    private final int WIDTH = 64;
    private final int HEIGHT = 32;
    
    public final int NAME_X = (CSInfo.WIDTH / 10) + 200; 
    public final int NAME_Y = 2 * CSInfo.HEIGHT /10;
    public final int HEIGHT_X = (CSInfo.WIDTH / 10) + 200; 
    public final int HEIGHT_Y = 3 * CSInfo.HEIGHT /10;
    public final int LENGHT_X = (CSInfo.WIDTH / 10) + 200; 
    public final int LENGHT_Y = 4 * CSInfo.HEIGHT /10;
    public final int WEIGHT_X = (CSInfo.WIDTH / 10) + 200; 
    public final int WEIGHT_Y = 5 * CSInfo.HEIGHT /10;
    private final int TXT_WIDTH = 250;
    private final int TXT_HEIGHT = 30;

    public static String creatureName;
    public static int creatureHeight, creatureLength, creatureWeight;
    
    
    public NewCreatureMenu(GUIContext gc, final ScreenManager sm) {        
        super(gc, 0, 0);
        next = new Button(gc, 
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_NORMAL),
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_HOVER),
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_PRESSED),
                NEW_X, NEW_Y, WIDTH, HEIGHT){
            @Override
            public void onClick() {
                creatureName = name.getText();
                try{
                    creatureHeight = Integer.valueOf(height.getHeight());
                    creatureLength = Integer.valueOf(length.getText());
                    creatureWeight = Integer.valueOf(weight.getText());
                } catch(NumberFormatException e){
                    System.out.println("Bad Input");
                }
                sm.changeScreen(NewCreatureFamilyScreen.ID, new FadeOutTransition(), new FadeInTransition());
            }
        };
        exit = new Button(gc, 
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_NORMAL),
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_HOVER),
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_PRESSED),
                EXIT_X, EXIT_Y, WIDTH, HEIGHT){
            @Override
            public void onClick() {
                sm.changeScreen(LobbyScreen.ID, new FadeOutTransition(), new FadeInTransition());
            }
        };
        name = new TextField(gc, TypeFace.uni(TypeFace.ARIAL, TypeFace.BOLD, 25) , NAME_X, NAME_Y, TXT_WIDTH, TXT_HEIGHT);
        height = new TextField(gc, TypeFace.uni(TypeFace.ARIAL, TypeFace.BOLD, 25) , HEIGHT_X, HEIGHT_Y, TXT_WIDTH, TXT_HEIGHT);
        length = new TextField(gc, TypeFace.uni(TypeFace.ARIAL, TypeFace.BOLD, 25) , LENGHT_X, LENGHT_Y, TXT_WIDTH, TXT_HEIGHT);
        weight = new TextField(gc, TypeFace.uni(TypeFace.ARIAL, TypeFace.BOLD, 25) , WEIGHT_X, WEIGHT_Y, TXT_WIDTH, TXT_HEIGHT);
        this.addComponent(name);
        this.addComponent(height);
        this.addComponent(length);
        this.addComponent(weight);
        this.addComponent(next);
        this.addComponent(exit);
    }
}
