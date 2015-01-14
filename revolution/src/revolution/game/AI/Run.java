/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package revolution.game.AI;

import revolution.game.creature.Creature;
import revolution.game.creature.History;

/**
 *
 * @author Christopher Stokes
 */
public class Run {
    
    /**
     * Runs the mating procedure
     * @param creature1
     * @param history1
     * @param creature2
     * @param history2 
     */
    public static void mate(Creature creature1, History history1, Creature creature2, History history2){
        System.out.println(creature1.getSpeciesName() + " is frothing at the gash for " + creature2.getSpeciesName());
        if(creature1.checkAnimal() && creature2.checkAnimal()){
            System.out.println(creature1.population.Instances.size());
            int minBirthSize = creature1.properies.relation.family.getMinBirthSize();
            int maxBirthSize = creature1.properies.relation.family.getMaxBirthSize();
            int birthSize = minBirthSize + (int) (Math.random() * maxBirthSize);
            creature1.population.addToPopulation(birthSize, System.currentTimeMillis());
            int mater = creature1.population.Instances.indexOf(history1);
            int matie = creature2.population.Instances.indexOf(history2);
            history1.mate.setMate(System.currentTimeMillis());
            history2.mate.setMate(System.currentTimeMillis());
            creature1.population.Instances.set(mater, history1);
            creature2.population.Instances.set(mater, history2);
            System.out.println(creature1.population.Instances.size());
        } else {
            System.out.println(creature1.population.getCount());
            int minBirthSize = creature1.properies.relation.family.getMinBirthSize();
            int maxBirthSize = creature1.properies.relation.family.getMaxBirthSize();
            int birthSize = minBirthSize + (int) (Math.random() * maxBirthSize);
            creature1.population.addUnitsToCount(birthSize);
            creature1.population.setPollinate(System.currentTimeMillis());
            System.out.println(creature1.population.getCount());
        }
    }
    
    /**
     * Runs the eating procedure
     * @param creature1
     * @param history1
     * @param creature2 
     */
    public static void eat(Creature creature1, History history1, Creature creature2){
        System.out.println("eaten");
        System.out.println(creature2.population.Instances.size());
        int eater = creature1.population.Instances.indexOf(history1);
        history1.eat.setEat(System.currentTimeMillis());
        creature1.population.Instances.set(eater, history1);
        if(creature2.checkAnimal()){
            creature2.population.removeFromPopulation(1);
        }else {
            creature2.population.removeUnitsFromCount(1);
        }
    }
    
    /**
     * Runs the dieing procedure
     * @param creature1
     * @param history1 
     */
    public static void die(Creature creature1, History history1){
        System.out.println("Oh Shit a " + creature1.getSpeciesName() + " has died. Probably deserved it!");
        creature1.population.Instances.remove(history1);
    }
}
