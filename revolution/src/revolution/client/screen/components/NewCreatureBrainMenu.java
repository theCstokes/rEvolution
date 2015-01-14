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
import revolution.client.screen.NewCreatureFoodScreen;
import revolution.client.screen.NewCreatureLocationScreen;
import revolution.client.screen.NewCreatureMedianScreen;
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
public class NewCreatureBrainMenu extends ComponentGroup{
    
    private Button start, back;
    
    private TextField intelligence, aggression;
    
    public final int NEW_X = CSInfo.WIDTH / 10; 
    public final int NEW_Y = 9 * CSInfo.HEIGHT /10;
    public final int EXIT_X = 7 * CSInfo.WIDTH /10;
    public final int EXIT_Y = 9 * CSInfo.HEIGHT /10;
    private final int WIDTH = 64;
    private final int HEIGHT = 32;
    
    public final int INTELLIGENCE_X = (CSInfo.WIDTH / 10) + 300; 
    public final int INTELLIGENCE_Y = 2 * CSInfo.HEIGHT /10;
    public final int AGGRESSION_X = (CSInfo.WIDTH / 10) + 300; 
    public final int AGGRESSION_Y = 3 * CSInfo.HEIGHT /10;
    private final int TXT_WIDTH = 250;
    private final int TXT_HEIGHT = 30;
    
    public static int creatureIntelligence, creatureAggression;

    public NewCreatureBrainMenu(GUIContext gc, final ScreenManager sm) {        
        super(gc, 0, 0);
        start = new Button(gc, 
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_NORMAL),
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_HOVER),
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_PRESSED),
                NEW_X, NEW_Y, WIDTH, HEIGHT){
            @Override
            public void onClick() {
                try {
                creatureIntelligence = Integer.valueOf(intelligence.getText());
                creatureAggression = Integer.valueOf(aggression.getText());
                } catch(NumberFormatException e) {
                    System.out.println("Bad Input");
                }
                sm.changeScreen(NewCreatureMedianScreen.ID, new FadeOutTransition(), new FadeInTransition());
            }
        };
        back = new Button(gc, 
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_NORMAL),
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_HOVER),
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_PRESSED),
                EXIT_X, EXIT_Y, WIDTH, HEIGHT){
            @Override
            public void onClick() {
                sm.changeScreen(NewCreatureFoodScreen.ID, new FadeOutTransition(), new FadeInTransition());
            }
        };
        intelligence = new TextField(gc, TypeFace.uni(TypeFace.ARIAL, TypeFace.BOLD, 25) , INTELLIGENCE_X, INTELLIGENCE_Y, TXT_WIDTH, TXT_HEIGHT);
        aggression = new TextField(gc, TypeFace.uni(TypeFace.ARIAL, TypeFace.BOLD, 25) , AGGRESSION_X, AGGRESSION_Y, TXT_WIDTH, TXT_HEIGHT);
        this.addComponent(intelligence);
        this.addComponent(aggression);
        this.addComponent(start);
        this.addComponent(back);
    }
}
