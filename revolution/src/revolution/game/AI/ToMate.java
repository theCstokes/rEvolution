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
public class ToMate {
    public static History mater;
    public static History matie;
    public static int decisionRating;
    
    /**
     * Determines if the creature should mate with the other creature. Instatnces based on time.
     * @param creature1
     * @param creature2
     * @return DecigionRating
     */
    public static int getDecision(Creature creature1, Creature creature2){
        int re = 0;
        if(creature1.checkAnimal() && creature2.checkAnimal()){
            outer : for(History c1 : creature1.population.Instances){
                inner : for(History c2 : creature2.population.Instances){
                    long age = creature2.properies.body.size.getHeight() * creature2.properies.body.size.getLength() * creature2.properies.body.size.getWeight() * 100;
                    if(System.currentTimeMillis() - c2.getBornTime() > age){
                        Run.die(creature1, c2);
                        break outer;
                    } else {
                        if(System.currentTimeMillis() - c1.mate.lastMate() > mateWait(creature1.properies.relation.family.getReproduceRate()) &&
                                System.currentTimeMillis() - c2.mate.lastMate() > mateWait(creature2.properies.relation.family.getReproduceRate())){
                            mater = c1;
                            matie = c2;
                            decisionRating = getMate(creature1);
                            re = decisionRating;
                            break outer;
                        } else {
                            re = 0;
                        }
                    }   
                }   
            }
        } else {
            mater = new History(creature1.population.getPollinate());
            decisionRating = getMate(creature1);
            re = decisionRating;
        }
        return re;
    }
    
    /**
     * Returns mills to wait
     * @param frequencyRating
     * @return waitTime
     */
    private static long mateWait(int frequencyRating){
        switch(frequencyRating) {
            case 1:
                return 500_000;
            case 2:
                return 1_000_000;
            case 3:
                return 3_000_000;
            case 4:
                return 4_000_000;
            case 5:
                return 5_000_000;
            case 6:
                return 6_000_000;
            case 7:
                return 7_000_000;
            case 8:
                return 8_000_000;
            case 9:
                return 9_000_000;
            case 10:
                return 10_000_000;
            default:
                return 10_000_000;
        }        
    }
    
    /**
     * Returns matting need
     * @param creature1
     * @return mateRate
     */
    private static int getMate(Creature creature1){
        long mateRate;
        mateRate = (System.currentTimeMillis() - mater.mate.lastMate()) / mateWait(creature1.properies.relation.family.getReproduceRate());
        if(mateRate <= 2){
            return 1;
        } else if(mateRate <= 3){
            return 2;
        } else if(mateRate <= 4){
            return 3;
        } else if(mateRate <= 5){
            return 4;
        } else if(mateRate <= 6){
            return 5;
        } else if(mateRate <= 7){
            return 6;
        } else if(mateRate <= 8){
            return 7;
        } else if(mateRate <= 9){
            return 8;
        } else if(mateRate <= 10){
            return 9;
        } else if(mateRate > 10){
            return 10;
        } else {
            return 0;
        }    
    }    
}
