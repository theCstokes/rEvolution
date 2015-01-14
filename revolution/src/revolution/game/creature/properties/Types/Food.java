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
public class Food {
    private Size size;
    private int frequency;
    private int meat;
    private int veg;
    
    public Food(Size size, int frequency, int meat, int plants){
        this.size = size;
        this.frequency = frequency;
        this.meat = meat;
        this.veg = plants;
    }
    
    public Size getFoodSize(){
        return size;
    }
    
    public int getFoodFrequency(){
        return frequency;
    }
    
    public int getEatMeat(){
        return meat;
    }
    
    public int getEatVeg(){
        return veg;
    }
    
}
