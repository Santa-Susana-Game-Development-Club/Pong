package com.sshsgd.pong.managers.input;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;

/**
 * Created by JoseR on 7/30/2016.
 */
public class MyInputProcessor extends InputAdapter {

    @Override
    public boolean keyDown(int keycode) {
        if(keycode == Keys.UP || keycode == Keys.W) {
            MyInput.setKey(MyInput.UP, true);
        }
        if(keycode == Keys.DOWN || keycode == Keys.S) {
            MyInput.setKey(MyInput.DOWN, true);
        }
        if(keycode == Keys.ENTER) {
            MyInput.setKey(MyInput.START, true);
        }
        if(keycode == Keys.ESCAPE) {
            MyInput.setKey(MyInput.BACK, true);
        }
        if(keycode == Keys.F11) {
            MyInput.setKey(MyInput.FULLSCREEN, true);
        }
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        if(keycode == Keys.UP || keycode == Keys.W) {
            MyInput.setKey(MyInput.UP, false);
        }
        if(keycode == Keys.DOWN || keycode == Keys.S) {
            MyInput.setKey(MyInput.DOWN, false);
        }
        if(keycode == Keys.ENTER) {
            MyInput.setKey(MyInput.START, false);
        }
        if(keycode == Keys.ESCAPE) {
            MyInput.setKey(MyInput.BACK, false);
        }
        if(keycode == Keys.F11) {
            MyInput.setKey(MyInput.FULLSCREEN, false);
        }
        return true;
    }
}
