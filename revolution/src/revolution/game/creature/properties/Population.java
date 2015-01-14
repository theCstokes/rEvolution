/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package revolution.game.creature.properties;

import java.util.ArrayList;
import static revolution.game.AI.ToMate.mater;
import revolution.game.creature.Creature;
import revolution.game.creature.History;

/**
 *
 * @author Chris
 */
public class Population {
    private int count = 0;
    private long pollinate = 0;
    public ArrayList<History> Instances = new ArrayList<>();
    
    public int getPopulationSize(){
        return Instances.size();
    }
    
    public void addToPopulation(int addAmount, long bornTime){
        for(int i = 0; i < addAmount; i++){
            Instances.add(new History(bornTime));
        }
    }
    
    public void removeFromPopulation(int removeAmount){
        if(removeAmount < Instances.size()){
            for(int i = 0; i < removeAmount; i++){
                System.out.println("in");
                Instances.remove(i);
            }
        }
    }
    
    public void removeInstance(History history){
        Instances.remove(history);
    }
    
    public void addUnitsToCount(int addAmount){
        count += addAmount;
    }
    
    public void removeUnitsFromCount(int removeAmount){
        count -= removeAmount;
    }
    
    public int getCount(){
        return count;
    }
    
    public void setPollinate(long gameTime){
        pollinate = gameTime;
    }
    
    public long getPollinate(){
        return pollinate;
    }
}
