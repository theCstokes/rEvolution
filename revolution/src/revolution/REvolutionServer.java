/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package revolution;

import java.awt.Dimension;
import java.awt.Toolkit;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;
import revolution.server.screen.ServerScreenManager;
import revolution.util.SSInfo;

/**
 *
 * @author GeoYS_2
 */
public class REvolutionServer {
    static Dimension screen;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SlickException {   
        screen = Toolkit.getDefaultToolkit().getScreenSize();
        //ScreenSize.init((int) screen.getWidth(), (int) screen.getHeight());
        SSInfo.init(screen.width, screen.width);
        AppGameContainer app = new AppGameContainer(new ServerScreenManager());
        app.setDisplayMode(SSInfo.WIDTH, SSInfo.HEIGHT, true);
        app.setTargetFrameRate(60);
        app.setShowFPS(false);
        app.setUpdateOnlyWhenVisible(false);
        app.setAlwaysRender(true);
        app.start();
    }
}
