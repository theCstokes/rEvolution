/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package revolution.client.screen.components;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.gui.GUIContext;
import org.newdawn.slick.state.transition.EmptyTransition;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
import revolution.client.Client;
import revolution.client.game.entity.NewCreature;
import revolution.client.screen.NewConnectionInProgression;
import revolution.client.screen.LobbyScreen;
import revolution.game.creature.Creature;
import revolution.game.creature.properties.Types.Brain;
import revolution.game.creature.properties.Types.Family;
import revolution.game.creature.properties.Types.Food;
import revolution.game.creature.properties.Types.Location;
import revolution.game.creature.properties.Types.Median;
import revolution.game.creature.properties.Types.Size;
import revolution.res.ClientImages;
import revolution.server.ServerFactory;
import revolution.server.screen.MainScreen;
import revolution.server.screen.RunningServerScreen;
import revolution.server.screen.components.NewServerMenu;
import revolution.ui.Button;
import revolution.ui.ComponentGroup;
import revolution.ui.ScreenManager;
import revolution.ui.TextField;
import revolution.ui.TypeFace;
import revolution.util.CSInfo;
import revolution.util.SSInfo;

/**
 *
 * @author Christopher Stokes
 */
public class NewUserMenu extends ComponentGroup{
    private Button add, btn2;
    public boolean addUser = false;
    private Button submit, back;
    
    private TextField userName, password;
    
    private String user, pass;
    
    private Creature creature;
    
    public String serverName;
    
    public final int START_X = CSInfo.WIDTH / 10; 
    public final int START_Y = 9 * CSInfo.HEIGHT /10;
    public final int BACK_X = 4 * CSInfo.WIDTH /10;
    public final int BACK_Y = 9 * CSInfo.HEIGHT /10;
    public final int USER_X = (CSInfo.WIDTH / 10) + 200; 
    public final int USER_Y = 2 * CSInfo.HEIGHT /10;
    public final int PASS_X = (CSInfo.WIDTH / 10) + 200; 
    public final int PASS_Y = 3 * CSInfo.HEIGHT /10;
    private final int WIDTH = 64;
    private final int HEIGHT = 32;
    private final int TXT_WIDTH = 250;
    private final int TXT_HEIGHT = 30;
    
    public NewUserMenu(GUIContext gc, final ScreenManager sm) {
        super(gc, 0, 0);
        
        submit = new Button(gc,
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_NORMAL),
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_HOVER),
                ClientImages.getImage(ClientImages.SAMPLE_BUTTON_PRESSED),
                START_X, START_Y, WIDTH, HEIGHT){
            @Override
            public void onClick() {
                user = userName.getText();
                pass = password.getText();
                newCreature();
                NewConnectionInProgression.setLogin(user, pass, creature, true);
                sm.changeScreen(NewConnectionInProgression.ID, new EmptyTransition(), new FadeInTransition());
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

        userName = new TextField(gc, TypeFace.uni(TypeFace.ARIAL, TypeFace.BOLD, 25) , USER_X, USER_Y, TXT_WIDTH, TXT_HEIGHT);
        password = new TextField(gc, TypeFace.uni(TypeFace.ARIAL, TypeFace.BOLD, 25) , PASS_X, PASS_Y, TXT_WIDTH, TXT_HEIGHT);
        this.addComponent(userName);
        this.addComponent(password);
        this.addComponent(submit);
        this.addComponent(back);
    }    
    
    private void newCreature(){
        creature = new Creature(user, NewCreatureMenu.creatureName, true);
        creature.properies.body.size = new Size(5, 5, 6);
        creature.properies.personality.brain = new Brain(1, 1);
        creature.properies.personality.food = new Food(new Size(1, 1, 1), 9, 1, 10);
        creature.properies.relation.family = new Family(3, 8, 1, 1);
        creature.properies.environment.median.setMedian(Median.Medians.GROUND);
        creature.properies.environment.location.setWaterSource(waterSource(NewCreatureLocationMenu.waterSource));
        creature.properies.environment.location.setFeedingArea(feedingArea(NewCreatureLocationMenu.feedingArea));
        creature.properies.environment.location.setNestingArea(nestingArea(NewCreatureLocationMenu.nestingArea));
        creature.properies.environment.location.setSleepingArea(sleepingArea(NewCreatureLocationMenu.sleepingArea));
        creature.properies.environment.location.setMigrationStart(migrationArea(NewCreatureLocationMenu.migrationStart));
        creature.properies.environment.location.setMigrationThrough(migrationArea(NewCreatureLocationMenu.migrationThrough));
        creature.properies.environment.location. setMigrationStart(migrationArea(NewCreatureLocationMenu.migrationEnd));
        creature.population.addToPopulation(100, System.currentTimeMillis()); 
    }
    
    
    public Location.WaterSources waterSource(int option){
        if(option == 0){
            return Location.WaterSources.LAKE;
        } else {
            return Location.WaterSources.WATERFALL;
        }
    }
    
    public Location.SleepingArea sleepingArea(int option){
        if(option == 0){
            return Location.SleepingArea.FORREST;
        } else {
            return Location.SleepingArea.SAVAHNNA;
        }
    }
    
    public Location.NestingArea nestingArea(int option){
        if(option == 0){
            return Location.NestingArea.FORREST;
        } else {
            return Location.NestingArea.SAVAHNNA;
        }
    }
    
    public Location.MigrationArea migrationArea(int option){
        if(option == 0){
            return Location.MigrationArea.FORREST;
        } else {
            return Location.MigrationArea.SAVAHNNA;
        }
    }
    
    public Location.FeedingArea feedingArea(int option){
        if(option == 0){
            return Location.FeedingArea.FORREST;
        } else {
            return Location.FeedingArea.SAVAHNNA;
        }
    }
}
