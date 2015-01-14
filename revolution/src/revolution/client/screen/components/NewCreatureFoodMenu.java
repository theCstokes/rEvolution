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
import revolution.client.screen.NewCreatureBrainScreen;
import revolution.client.screen.NewCreatureFamilyScreen;
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
public class NewCreatureFoodMenu extends ComponentGroup{
    
    private Button connect, back;
    
    private TextField height, length, weight, frequency, meat, veg;
    
    public final int NEW_X = CSInfo.WIDTH / 10; 
    public final int NEW_Y = 9 * CSInfo.HEIGHT /10;
    public final int EXIT_X = 7 * CSInfo.WIDTH /10;
    public final int EXIT_Y = 9 * CSInfo.HEIGHT /10;
    private final int WIDTH = 64;
    private final int HEIGHT = 32;
    
    public final int HEIGHT_X = (CSInfo.WIDTH / 10) + 300; 
    public final int HEIGTH_Y = 2 * CSInfo.HEIGHT /10;
    public final int LENGTH_X = (CSInfo.WIDTH / 10) + 300; 
    public final int LENGTH_Y = 3 * CSInfo.HEIGHT /10;
    public final int WEIGHT_X = (CSInfo.WIDTH / 10) + 300; 
    public final int WEIGHT_Y = 4 * CSInfo.HEIGHT /10;
    public final int MEAT_X = (CSInfo.WIDTH / 10) + 300; 
    public final int MEAT_Y = 5 * CSInfo.HEIGHT /10;
    public final int VEG_X = (CSInfo.WIDTH / 10) + 300; 
    public final int VEG_Y = 6 * CSInfo.HEIGHT /10;
    public final int FREQUENCY_X = (CSInfo.WIDTH / 10) + 300; 
    public final int FREQUENCY_Y = 7 * CSInfo.HEIGHT /10;
    private final int TXT_WIDTH = 250;
    private final int TXT_HEIGHT = 30;
    
    public static int foodHeight, foodLength, foodWeight, feedFrequency, feedMeat, feedVeg;

    public NewCreatureFoodMenu(GUIContext gc, final ScreenManager sm) {        
        super(gc, 0, 0);
        connect = new Button(gc, 
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_NORMAL),
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_HOVER),
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_PRESSED),
                NEW_X, NEW_Y, WIDTH, HEIGHT){
            @Override
            public void onClick() {
                try {
                foodHeight = Integer.valueOf(height.getText());
                foodLength = Integer.valueOf(length.getText());
                foodWeight = Integer.valueOf(weight.getText());
                feedFrequency = Integer.valueOf(frequency.getText());
                feedMeat = Integer.valueOf(meat.getText());
                feedVeg = Integer.valueOf(veg.getText());
                } catch(NumberFormatException e) {
                    System.out.println("Bad Input");
                }
                sm.changeScreen(NewCreatureBrainScreen.ID, new FadeOutTransition(), new FadeInTransition());
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
        height = new TextField(gc, TypeFace.uni(TypeFace.ARIAL, TypeFace.BOLD, 25) , HEIGHT_X, HEIGTH_Y, TXT_WIDTH, TXT_HEIGHT);
        length = new TextField(gc, TypeFace.uni(TypeFace.ARIAL, TypeFace.BOLD, 25) , LENGTH_X, LENGTH_Y, TXT_WIDTH, TXT_HEIGHT);
        weight = new TextField(gc, TypeFace.uni(TypeFace.ARIAL, TypeFace.BOLD, 25) , WEIGHT_X, WEIGHT_Y, TXT_WIDTH, TXT_HEIGHT);
        frequency = new TextField(gc, TypeFace.uni(TypeFace.ARIAL, TypeFace.BOLD, 25) , FREQUENCY_X, FREQUENCY_Y, TXT_WIDTH, TXT_HEIGHT);
        meat = new TextField(gc, TypeFace.uni(TypeFace.ARIAL, TypeFace.BOLD, 25) , MEAT_X, MEAT_Y, TXT_WIDTH, TXT_HEIGHT);
        veg = new TextField(gc, TypeFace.uni(TypeFace.ARIAL, TypeFace.BOLD, 25) , VEG_X, VEG_Y, TXT_WIDTH, TXT_HEIGHT);
        this.addComponent(height);
        this.addComponent(length);
        this.addComponent(weight);
        this.addComponent(frequency);
        this.addComponent(meat);
        this.addComponent(veg);
        this.addComponent(connect);
        this.addComponent(back);
    }
}
