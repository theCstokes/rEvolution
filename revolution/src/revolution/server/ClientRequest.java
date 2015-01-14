/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package revolution.server;

import java.io.Serializable;
import revolution.game.creature.Creature;

/**
 *
 * @author Chris
 */
public class ClientRequest implements Serializable{
    public String username, password; 
    public Creature creature;
    public boolean newUser;
    public ClientRequest(String username, String password, Creature creature, boolean newUser){
        this.password = password;
        this.username = username;
        this.creature = creature;
        this.newUser = newUser;
    }
    public ClientRequest(String username, String password, boolean newUser){
        this.password = password;
        this.username = username;
        this.creature = creature;
        this.newUser = newUser;
    }
}
