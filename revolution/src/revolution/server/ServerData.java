/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package revolution.server;

import java.io.IOException;
import java.io.Serializable;
import java.net.SocketException;
import java.util.HashMap;

/**
 * Information that the server broadcasts. Clients receive this
 * information for their lobbies.
 * @author GeoYS_2
 */
public class ServerData implements Serializable{

    public String hostName;
    public int port;
    
    public ServerData(String hostName, int port){
        this.hostName = hostName;
        this.port = port;
    }
    
}
