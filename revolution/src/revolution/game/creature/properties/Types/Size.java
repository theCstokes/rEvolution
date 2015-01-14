/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package revolution.game.creature.properties.Types;

import revolution.game.creature.properties.Property;

/**
 *
 * @author Christopher Stokes
 */
public class Size {
    private int Height;
    private int Length;
    private int Weight;
    public Size(int Height, int Length, int Weight){
        this.Height = Height;
        this.Length = Length;
        this.Weight = Weight;
    }
    
    public int getHeight(){
        return Height;
    }
    
    public int getLength(){
        return Length;
    }
    
    public int getWeight(){
        return Weight;
    }
}
