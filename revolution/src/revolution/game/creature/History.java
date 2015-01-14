/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package revolution.game.creature;

import java.io.Serializable;

/**
 *
 * @author Christopher Stokes
 */
public class History implements Serializable{
    
    public Eat eat = new Eat();
    public Mate mate = new Mate();
    
    private long bornTime = 0;
    
    public History(long bornTime){
        this.bornTime = bornTime;
    }
    
    
    public class Eat {
        private long lastEat = 0;
    
        /**
         * Sets the time the creature last eat
         * @param gameTime 
         */
        public void setEat(long gameTime){
            lastEat = gameTime;
        }
    
        /**
         * Returns when the creature last eat
         * @return lastEat
         */
        public long lastEat(){
            return lastEat;
        }
    }
    
    public class Mate {
        
        public Mate(){
            
        }
        
        public Mate(long Pollinate){
            lastMate = Pollinate;
        }
        
        private long lastMate = 0;
        
        /**
         * Sets the time when creature reproduced
         * @param gameTime 
         */
        public void setMate(long gameTime){
            lastMate = gameTime;
        }
        
        /**
         * Returns when the creature last reproduced
         * @return lastMate
         */
        public long lastMate(){
            return lastMate;
        }
    }
    
    /**
     * Returns when the creature was born
     * @return bornTime
     */
    public long getBornTime(){
        return bornTime;
    }
}
