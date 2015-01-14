/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package revolution.client.screen.components;

import org.newdawn.slick.gui.GUIContext;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
import revolution.client.screen.LogInScreen;
import revolution.client.screen.NewCreatureLocationScreen;
import revolution.client.screen.NewCreatureScreen;
import revolution.client.screen.NewUserScreen;
import revolution.res.ClientImages;
import revolution.ui.Button;
import revolution.ui.ComponentGroup;
import revolution.ui.ScreenManager;
import revolution.util.CSInfo;

/**
 *
 * @author Chris
 */
public class NewCreatureLocationMenu extends ComponentGroup{
    
    private Button connect, exit, one, two, three, four, five, six, seven, eight, nine, ten, eleven, twelve, therteen, fourteen;
    
    public final int NEW_X = CSInfo.WIDTH / 10; 
    public final int NEW_Y = 9 * CSInfo.HEIGHT /10;
    public final int EXIT_X = 7 * CSInfo.WIDTH /10;
    public final int EXIT_Y = 9 * CSInfo.HEIGHT /10;
    private final int WIDTH = 64;
    private final int HEIGHT = 32;
    
    public final int ONE_X = (CSInfo.WIDTH / 10) + 300; 
    public final int ONE_Y = (2 * CSInfo.HEIGHT /10);
    public final int TWO_X = (CSInfo.WIDTH / 10) + 500; 
    public final int TWO_Y = (2 * CSInfo.HEIGHT /10);
    public final int THREE_X = (CSInfo.WIDTH / 10) + 300; 
    public final int THREE_Y = (3 * CSInfo.HEIGHT /10);
    public final int FOUR_X = (CSInfo.WIDTH / 10) + 500; 
    public final int FOUR_Y = (3 * CSInfo.HEIGHT /10);
    public final int FIVE_X = (CSInfo.WIDTH / 10) + 300; 
    public final int FIVE_Y = (4 * CSInfo.HEIGHT /10);
    public final int SIX_X = (CSInfo.WIDTH / 10) + 500; 
    public final int SIX_Y = (4 * CSInfo.HEIGHT /10);
    public final int SEVEN_X = (CSInfo.WIDTH / 10) + 300; 
    public final int SEVEN_Y = (5 * CSInfo.HEIGHT /10);
    public final int EIGHT_X = (CSInfo.WIDTH / 10) + 500; 
    public final int EIGTH_Y = (5 * CSInfo.HEIGHT /10);
    public final int NINE_X = (CSInfo.WIDTH / 10) + 300; 
    public final int NINE_Y = (6 * CSInfo.HEIGHT /10);
    public final int TEN_X = (CSInfo.WIDTH / 10) + 500; 
    public final int TEN_Y = (6 * CSInfo.HEIGHT /10);
    public final int ELEVEN_X = (CSInfo.WIDTH / 10) + 300; 
    public final int ELEVEN_Y = (7 * CSInfo.HEIGHT /10);
    public final int TWELEVE_X = (CSInfo.WIDTH / 10) + 500; 
    public final int TWELEVE_Y = (7 * CSInfo.HEIGHT /10);
    public final int THERTEEN_X = (CSInfo.WIDTH / 10) + 300; 
    public final int THERTEEN_Y = (8 * CSInfo.HEIGHT /10);
    public final int FOURTEEN_X = (CSInfo.WIDTH / 10) + 500; 
    public final int FOURTEEN_Y = (8 * CSInfo.HEIGHT /10) ;
    
    public static int waterSource, sleepingArea, feedingArea, nestingArea, migrationStart, migrationThrough, migrationEnd;

    public NewCreatureLocationMenu(GUIContext gc, final ScreenManager sm) {        
        super(gc, 0, 0);
        connect = new Button(gc, 
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_NORMAL),
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_HOVER),
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_PRESSED),
                NEW_X, NEW_Y, WIDTH, HEIGHT){
            @Override
            public void onClick() {
                try{
                } catch(NumberFormatException e){
                    System.out.println("Bad Input");
                }
                sm.changeScreen(NewUserScreen.ID, new FadeOutTransition(), new FadeInTransition());
            }
        };
        exit = new Button(gc, 
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_NORMAL),
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_HOVER),
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_PRESSED),
                EXIT_X, EXIT_Y, WIDTH, HEIGHT){
            @Override
            public void onClick() {
                sm.changeScreen(NewCreatureScreen.ID, new FadeOutTransition(), new FadeInTransition());
            }
        };
        one = new Button(gc, 
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_NORMAL),
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_HOVER),
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_PRESSED),
                ONE_X, ONE_Y, WIDTH, HEIGHT){
            @Override
            public void onClick() {
                one.setAcceptingInput(false);
                two.setAcceptingInput(false);
                waterSource = 0;
            }
        };
        two = new Button(gc, 
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_NORMAL),
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_HOVER),
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_PRESSED),
                TWO_X, TWO_Y, WIDTH, HEIGHT){
            @Override
            public void onClick() {
                one.setAcceptingInput(false);
                two.setAcceptingInput(false);
                waterSource = 1;
            }
        };
        three = new Button(gc, 
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_NORMAL),
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_HOVER),
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_PRESSED),
                THREE_X, THREE_Y, WIDTH, HEIGHT){
            @Override
            public void onClick() {
                three.setAcceptingInput(false);
                four.setAcceptingInput(false);
                sleepingArea = 0;
            }
        };
        four = new Button(gc, 
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_NORMAL),
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_HOVER),
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_PRESSED),
                FOUR_X, FOUR_Y, WIDTH, HEIGHT){
            @Override
            public void onClick() {
                three.setAcceptingInput(false);
                four.setAcceptingInput(false);
                sleepingArea = 1;
            }
        };
        five = new Button(gc, 
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_NORMAL),
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_HOVER),
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_PRESSED),
                FIVE_X, FIVE_Y, WIDTH, HEIGHT){
            @Override
            public void onClick() {
                five.setAcceptingInput(false);
                six.setAcceptingInput(false);
                feedingArea = 0;
            }
        };
        six = new Button(gc, 
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_NORMAL),
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_HOVER),
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_PRESSED),
                SIX_X, SIX_Y, WIDTH, HEIGHT){
            @Override
            public void onClick() {
                five.setAcceptingInput(false);
                six.setAcceptingInput(false);
                feedingArea = 1;
            }
        };
        seven = new Button(gc, 
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_NORMAL),
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_HOVER),
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_PRESSED),
                SEVEN_X, SEVEN_Y, WIDTH, HEIGHT){
            @Override
            public void onClick() {
                seven.setAcceptingInput(false);
                eight.setAcceptingInput(false);
                nestingArea = 0;
            }
        };
        eight = new Button(gc, 
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_NORMAL),
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_HOVER),
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_PRESSED),
                EIGHT_X, EIGTH_Y, WIDTH, HEIGHT){
            @Override
            public void onClick() {
                seven.setAcceptingInput(false);
                eight.setAcceptingInput(false);
                nestingArea = 1;
            }
        };
        nine = new Button(gc, 
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_NORMAL),
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_HOVER),
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_PRESSED),
                NINE_X, NINE_Y, WIDTH, HEIGHT){
            @Override
            public void onClick() {
                nine.setAcceptingInput(false);
                ten.setAcceptingInput(false);
                migrationStart = 0;
            }
        };
        ten = new Button(gc, 
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_NORMAL),
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_HOVER),
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_PRESSED),
                TEN_X, TEN_Y, WIDTH, HEIGHT){
            @Override
            public void onClick() {
                nine.setAcceptingInput(false);
                ten.setAcceptingInput(false);
                migrationStart = 1;
            }
        };
        eleven = new Button(gc, 
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_NORMAL),
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_HOVER),
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_PRESSED),
                ELEVEN_X, ELEVEN_Y, WIDTH, HEIGHT){
            @Override
            public void onClick() {
                eleven.setAcceptingInput(false);
                twelve.setAcceptingInput(false);
                migrationThrough = 0;
            }
        };
        twelve = new Button(gc, 
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_NORMAL),
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_HOVER),
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_PRESSED),
                TWELEVE_X, TWELEVE_Y, WIDTH, HEIGHT){
            @Override
            public void onClick() {
                eleven.setAcceptingInput(false);
                twelve.setAcceptingInput(false);
                migrationThrough = 1;
            }
        };
        therteen = new Button(gc, 
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_NORMAL),
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_HOVER),
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_PRESSED),
                THERTEEN_X, THERTEEN_Y, WIDTH, HEIGHT){
            @Override
            public void onClick() {
                therteen.setAcceptingInput(false);
                fourteen.setAcceptingInput(false);
                migrationEnd = 0;
            }
        };
        fourteen = new Button(gc, 
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_NORMAL),
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_HOVER),
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_PRESSED),
                FOURTEEN_X, FOURTEEN_Y, WIDTH, HEIGHT){
            @Override
            public void onClick() {
                therteen.setAcceptingInput(false);
                fourteen.setAcceptingInput(false);
                migrationEnd = 1;
            }
        };        
        one.setText("Lake");
        two.setText("Waterfall");
        three.setText("FOREST");
        four.setText("SAVAHNNA");
        five.setText("FOREST");
        six.setText("SAVAHNNA");
        seven.setText("FOREST");
        eight.setText("SAVAHNNA");
        nine.setText("FOREST");
        ten.setText("SAVAHNNA");
        eleven.setText("FOREST");
        twelve.setText("SAVAHNNA");
        therteen.setText("FOREST");
        fourteen.setText("SAVAHNNA");
        this.addComponent(connect);
        this.addComponent(exit);
        this.addComponent(one);
        this.addComponent(two);
        this.addComponent(three);
        this.addComponent(four);
        this.addComponent(five);
        this.addComponent(six);
        this.addComponent(seven);
        this.addComponent(eight);
        this.addComponent(nine);
        this.addComponent(ten);
        this.addComponent(eleven);
        this.addComponent(twelve);
        this.addComponent(therteen);
        this.addComponent(fourteen);
    }
}
