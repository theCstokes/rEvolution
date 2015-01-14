/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package revolution.game.creature;

import java.io.Serializable;
import revolution.game.creature.properties.Property;
import java.util.ArrayList;
import java.util.HashMap;
import revolution.game.creature.properties.Population;
import revolution.game.creature.properties.PropertySet;

/**
 *
 * @author Chris
 */
public class Creature implements Serializable {
    //  public History history = new History();
    public transient PropertySet properies = new PropertySet();
    public transient Population population = new Population();
    private int populationSize = 0;
    private boolean isAnimal;
    private boolean isVulnerable;
    //not final solution
    private String createdBy, speciesName;
    public Creature(String createdBy, String speciesName, boolean isAnimal){
        this.createdBy = createdBy;
        this.speciesName = speciesName;
        this.isAnimal = isAnimal;
    }
    
    /**
     * Returns true if the creature is an animal
     * @return 
     */
    public boolean checkAnimal(){
        return isAnimal;
    }
    
    /**
     * Returns the username of the creatures creator
     * @return createdBy
     */
    public String getCreator(){
        return createdBy;
    }
    
    /**
     * Returns the name of the creature species
     * @return speciesName
     */
    public String getSpeciesName(){
        return speciesName;
    }
    
}