/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package revolution;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.UnknownHostException;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;
import revolution.client.Client;
import revolution.client.screen.ClientScreenManager;
import revolution.util.CSInfo;

/**
 *
 * @author chsto9228
 */
public class REvolutionClient {
    static Dimension screen;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SlickException, IOException{
        screen = Toolkit.getDefaultToolkit().getScreenSize();
        int port = 1000;
        while(!available(port)){
            port ++;
        }
        Client.session = new Client(port);
        AppGameContainer app = new AppGameContainer(new ClientScreenManager());
        app.setDisplayMode((int) screen.getWidth(), (int) screen.getHeight(), true);
        CSInfo.init((int) screen.getWidth(), (int) screen.getHeight());
        //app.setDisplayMode(1920, 1080, false);
        //CSInfo.init(1920, 1080);
        app.setTargetFrameRate(60);
        app.setShowFPS(true);
        app.setUpdateOnlyWhenVisible(false);
        app.setAlwaysRender(true);
        app.start();
    }
    
    // from Apache camel project
    public static boolean available(int port) {
        if (port < 0 || port > 9999) {
            throw new IllegalArgumentException("Invalid start port: " + port);
        }

        DatagramSocket ds = null;
        try {
            ds = new DatagramSocket(port);
            ds.setReuseAddress(true);
            return true;
        } catch (IOException e) {
        } finally {
            if (ds != null) {
                ds.close();
            }
        }

        return false;
    }
}
