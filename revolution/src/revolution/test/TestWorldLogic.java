z/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package revolution.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import javax.print.attribute.standard.MediaName;
import org.w3c.dom.Element;
import revolution.game.creature.Creature;
import revolution.game.creature.History;
import revolution.game.creature.properties.PropertySet;
import revolution.game.creature.properties.Types.Brain;
import revolution.game.creature.properties.Types.Family;
import revolution.game.creature.properties.Types.Food;
import revolution.game.creature.properties.Types.Location;
import revolution.game.creature.properties.Types.Median;
import revolution.game.creature.properties.Types.Size;
import revolution.game.world.Region;
import revolution.game.world.World;
import revolution.server.SerializeObject;
import revolution.server.Server;
import revolution.server.User;

/**
 *
 * @author Christopher Stokes
 */
public class TestWorldLogic {    
    
    private static World world;
    
    private static void initializeWorld(){
        world = new World(null);
        Creature cow = new Creature("Christopher Stokes", "cow", true);
        Creature grass = new Creature("Christopher Stokes", "grass",false);
        Creature wolf = new Creature("Christopher Stokes", "wolf",true);
        
        cow.properies.body.size = new Size(5, 5, 6);
        cow.properies.personality.brain = new Brain(1, 1);
        cow.properies.personality.food = new Food(new Size(1, 1, 1), 9, 1, 10);
        cow.properies.relation.family = new Family(3, 8, 1, 1);
        cow.properies.environment.median.setMedian(Median.Medians.GROUND);
        cow.properies.environment.location.setWaterSource(Location.WaterSources.LAKE);
        cow.properies.environment.location.setFeedingArea(Location.FeedingArea.SAVAHNNA);
        cow.properies.environment.location.setNestingArea(Location.NestingArea.SAVAHNNA);
        cow.properies.environment.location.setSleepingArea(Location.SleepingArea.SAVAHNNA);
        cow.properies.environment.location.setMigrationStart(null);
        cow.properies.environment.location.setMigrationThrough(null);
        cow.properies.environment.location. setMigrationStart(null);
        cow.population.addToPopulation(100, System.currentTimeMillis());
        
        grass.properies.body.size = new Size(1, 1, 1);
        grass.properies.relation.family = new Family(0, 7, 1, 2);
        grass.properies.environment.median.setMedian(Median.Medians.GROUND);
        grass.properies.environment.location.fillUnspecializedArea(Location.FeedingArea.SAVAHNNA);
        grass.population.addUnitsToCount(1_000_000_000);
        System.out.println("test num " + grass.population.getCount());
        
        wolf.properies.body.size = new Size(3, 3, 4);
        wolf.properies.personality.brain = new Brain(7, 4);
        wolf.properies.personality.food = new Food(new Size(6, 6, 6), 3, 10, 1);
        wolf.properies.relation.family = new Family(8, 5, 2, 5);
        wolf.properies.environment.median.setMedian(Median.Medians.GROUND);
        wolf.properies.environment.location.setWaterSource(Location.WaterSources.LAKE);
        wolf.properies.environment.location.setFeedingArea(Location.FeedingArea.SAVAHNNA);
        wolf.properies.environment.location.setNestingArea(Location.NestingArea.SAVAHNNA);
        wolf.properies.environment.location.setSleepingArea(Location.SleepingArea.SAVAHNNA);
        wolf.properies.environment.location.setMigrationStart(Location.MigrationArea.SAVAHNNA);
        wolf.properies.environment.location.setMigrationThrough(null);
        wolf.properies.environment.location. setMigrationStart(Location.MigrationArea.FORREST);
        wolf.population.addToPopulation(50, System.currentTimeMillis());

        world.populations.add(cow);
        world.populations.add(grass);
        world.populations.add(wolf);
    }
    
    
    public static void main(String[] args){
        
        initializeWorld();
        
        long lastUpdate = System.currentTimeMillis();
        while(true){
            long newUpdate = System.currentTimeMillis();
            world.update(newUpdate - lastUpdate);
            // Output to console key info about the world
            lastUpdate = newUpdate;
        }
    }
}
