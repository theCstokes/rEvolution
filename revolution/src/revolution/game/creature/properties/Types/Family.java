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
public class Family {
    private int familyStrength;
    private int reproduceRate;
    private int minBirthSize, maxBirthSize;
    
    public Family(int familyStrength, int reproduceRate, int minBirthSize, int maxBirthSize){
        this.familyStrength = familyStrength;
        this.reproduceRate = reproduceRate;
        this.minBirthSize = minBirthSize;
        this.maxBirthSize = maxBirthSize;
    }
    
    public void setFamilyStrength(int familyStrength){
        this.familyStrength = familyStrength;
    }
    
    public int getFamilyStrength(){
        return familyStrength;
    }
    
    public void setReproduceRate(int reproduceRate){
        this.reproduceRate = reproduceRate;
    }
    
    public int getReproduceRate(){
        return reproduceRate;
    }
    
    public void setMaxBirthSize(int maxBirthSize){
        this.maxBirthSize = maxBirthSize;
    }
    
    public int getMaxBirthSize(){
        return maxBirthSize;
    }
    
    public void setMinBirthSize(int minBirthSize){
        this.minBirthSize = minBirthSize;
    }
    
    public int getMinBirthSize(){
        return minBirthSize;
    }
}
