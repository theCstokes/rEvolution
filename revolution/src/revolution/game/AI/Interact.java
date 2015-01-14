/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package revolution.game.AI;

import java.util.HashMap;
import java.util.Map.Entry;
import revolution.game.creature.Creature;
import revolution.game.creature.properties.Types.Location;
import revolution.game.creature.properties.Types.Size;

/**
 *
 * @author Christopher Stokes
 */
public class Interact {
    
    private static HashMap<Action, Integer> actionOrder = new HashMap<>();
    
    /**
     * Decides what should happen when 2 animals interact
     * @param creature1
     * @param creature2 
     */
    public static void interact(Creature creature1, Creature creature2){
        actionOrder.clear();
        
        if(wouldInteract(creature1, creature2)){
            if(checkSameSpecies(creature1, creature2)){
                if(!creature1.checkAnimal() && !creature2.checkAnimal()){
                    if(checkMate(creature1, creature2) != 0){
                        actionOrder.put(Action.MATE, ToMate.decisionRating);
                    }
                } else if(genGender()){
                    if(checkMate(creature1, creature2) != 0){
                        actionOrder.put(Action.MATE, ToMate.decisionRating);
                    }
                }
            } else {
                if(creature1.checkAnimal() && checkEat(creature1, creature2) != 0){
                    actionOrder.put(Action.EAT, ToEat.decisionRating);
                } else {
                    
                }
            }
            if(getFirstAction(actionOrder) == Action.MATE){
                Run.mate(creature1, ToMate.mater, creature2, ToMate.matie);
            } else if(getFirstAction(actionOrder) == Action.EAT){
                Run.eat(creature1, ToEat.eater, creature2);
            }
            
        }
    }
    
    /**
     * Returns if 2 animals should interact
     * @param creature1
     * @param creature2
     * @return shouldInteract
     */
    private static boolean wouldInteract(Creature creature1, Creature creature2){        
        Location location1 = creature1.properies.environment.location;
        Location location2  = creature2.properies.environment.location;
        if((Math.random() * (location1.size() + location2.size())) <= location1.shares(location2)){
            return true;
        } else {
            return false;
        }        
    }
    
    /**
     * Returns if the creatures are the same species
     * @param creature1
     * @param creature2
     * @return sameSpecies
     */
    private static boolean checkSameSpecies(Creature creature1, Creature creature2){
            if(creature1.equals(creature2)){
                return true;
            } else {
                return false;
            }
    }
    
    /**
     * Decides if 2 creatures should mate
     * @param creature1
     * @param creature2
     * @return shouldMate
     */
    private static int checkMate(Creature creature1, Creature creature2){
        return ToMate.getDecision(creature1, creature2);
    }
    
    /**
     * Decides if the creature should be eaten
     * @param creature1
     * @param creature2
     * @return shouldEat
     */
    private static int checkEat(Creature creature1, Creature creature2){
        return ToEat.getDecision(creature1, creature2);
    }

    /**
     * Decides if the creatures are the same gender
     * @return sameGen
     */
    private static boolean genGender(){
        double ran;
        ran = Math.random();
        if (ran <= 0.5){
            return true;
        }
        else {
            return false;
        }
    }
    
    /**
     * Returns what the creature should do first
     * @param actionOrder
     * @return firstAction
     */
    private static Action getFirstAction(HashMap<Action, Integer> actionOrder){
        Action maxAction = null;
        Integer maxOrder = null;
        for(Entry<Action,Integer> entry : actionOrder.entrySet()) {
            if(maxOrder == null || entry.getValue() > maxOrder){
                maxAction = entry.getKey();
                maxOrder = entry.getValue();
            }
        }
        return maxAction;
    }
    
    private enum Action{
        EAT, MATE, SLEEP;
    }
}
