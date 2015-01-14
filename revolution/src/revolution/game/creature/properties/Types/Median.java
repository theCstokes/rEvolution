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
public class Median {
    private Medians median;
    
    public void setMedian(Medians median){
        this.median = median;
    }
    
    public Medians getMedian(){
        return median;
    }
    
    public enum Medians {
        AIR, GROUND, WATER;
    }
}
