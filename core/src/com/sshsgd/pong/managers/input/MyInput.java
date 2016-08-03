package com.sshsgd.pong.managers.input;

/**
 * Created by JoseR on 7/30/2016.
 */
public class MyInput {

    private static boolean[] keys;
    private static boolean[] pkeys;

    private static final int NUM_KEYS = 5;
    public static final int UP = 0;
    public static final int DOWN = 1;
    public static final int START = 2;
    public static final int BACK = 3;
    public static final int FULLSCREEN = 4;

    static {
        keys = new boolean[NUM_KEYS];
        pkeys = new boolean[NUM_KEYS];
    }

    public static void update() {
        for (int i = 0; i < NUM_KEYS; i++) {
            pkeys[i] = keys[i];
        }
    }

    public static void setKey(int k, boolean b) {
        keys[k] = b;
    }

    public static boolean keyDown(int k) {
        return keys[k];
    }

    public static boolean keyPressed(int k) {
        return keys[k] && !pkeys[k];
    }

}
