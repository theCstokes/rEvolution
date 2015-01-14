/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package revolution.ui;

import org.newdawn.slick.TrueTypeFont;



/**
 *
 * @author Chris
 */
public class TypeFace {
    public static final String ARIAL = "Arial";
    public static final String VERDANA = "Verdana";
    public static final int PLAIN = 0;
    public static final int BOLD = 1;
    public static final int ITALIC = 2;    
    
    public static TrueTypeFont uni(String fontType, int fontMode, int size){
        java.awt.Font font = new java.awt.Font(fontType, fontMode, size);
        TrueTypeFont ttf = new TrueTypeFont(font, true);
        return ttf;
    }
}
