/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package revolution.game.creature.properties.Types;

/**
 *
 * @author Christopher Stokes
 */
public class Brain {
    private int aggression;
    private int intelligence;
    
    public Brain(int aggression, int intelligence){
        this.aggression = aggression;
        this.intelligence = intelligence;
    }
    
    public void setAggression(int aggression){
        this.aggression = aggression;
    }
    
    public int getAggression(){
        return aggression;
    }
    
    public void setIntelligence(int intelligence){
        this.intelligence = intelligence;
    }
    
    public int getIntelligence(){
        return intelligence;
    }
    
}
