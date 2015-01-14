/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package revolution.util;

/**
 *
 * @author GeoYS_2
 */
public class Stopwatch {
    private long start, lastTime = 0;
    private boolean isRunning;
    public Stopwatch(){
        start = System.currentTimeMillis();
        isRunning = false;
    }
    public long time(){
        return isRunning ? System.currentTimeMillis() - start : lastTime;
    }    
    public void start(){
        isRunning = true;
    }
    public void stop(){
        isRunning = false;
        lastTime = System.currentTimeMillis() - start;
    }
    public boolean isRunning(){
        return isRunning;
    }
    public void restart(){
        start = System.currentTimeMillis();
        isRunning = true;
    }
}
