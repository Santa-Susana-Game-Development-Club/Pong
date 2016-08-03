package com.sshsgd.pong;

import com.badlogic.gdx.graphics.Color;

/**
 * Created by JoseR on 7/29/2016.
 */
public class MyConstants {

    public static enum States {
        Title, Play
    }

    public static final int WORLD_WIDTH = 1280;
    public static final int WORLD_HEIGHT = 720;

    public static final String TITLE = "Pong";

    public static Color rgba(float r, float g, float b, float a) {
        return new Color(r / 255f, g / 255f, b / 255f, a / 255f);
    }

    public static Color hex(String hex) {
        int r = 0;
        int g = 0;
        int b = 0;
        if(hex.length() == 3) {
            char rC = hex.charAt(0);
            char gC = hex.charAt(1);
            char bC = hex.charAt(2);
            hex = "" + rC + rC + gC + gC + bC + bC;
        } else if(hex.length() == 4 && hex.charAt(0) == '#') {
            char rC = hex.charAt(1);
            char gC = hex.charAt(2);
            char bC = hex.charAt(3);
            hex = "" + rC + rC + gC + gC + bC + bC;
        }
        if(hex.length() == 6) {
            r = Integer.parseInt(hex.substring(0, 2), 16);
            g = Integer.parseInt(hex.substring(2, 4), 16);
            b = Integer.parseInt(hex.substring(4), 16);
        } else if(hex.length() == 7 && hex.charAt(0) == '#') {
            r = Integer.parseInt(hex.substring(1, 3), 16);
            g = Integer.parseInt(hex.substring(3, 5), 16);
            b = Integer.parseInt(hex.substring(5), 16);
        }
        return MyConstants.rgba(r, g, b, 255);
    }

}
