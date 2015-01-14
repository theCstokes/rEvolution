/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package revolution.server;

import java.io.Serializable;

/**
 * Information sent from the server to the client about 
 * the game world, once client has connected/logged on.
 * @author GeoYS_2
 */
public class UserData implements Serializable{
    public String message;
    public UserData(){
        this.message = "You are logged in to this server! "
                + "This class contains game world information";
    }
}
