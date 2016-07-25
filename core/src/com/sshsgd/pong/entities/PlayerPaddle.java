package com.sshsgd.pong.entities;

import com.sshsgd.pong.managers.input.MyInput;

/**
 * Created by JoseR on 7/25/2016.
 */
public class PlayerPaddle extends Paddle {

    public PlayerPaddle(float width, float height, Side side) {
        super(width, height, side);
    }

    @Override
    public void behave(Ball ball) {
        if(MyInput.keyDown(MyInput.UP)) {
            vel.y = speed;
        } else if(MyInput.keyDown(MyInput.DOWN)) {
            vel.y = -speed;
        } else {
            vel.y = 0;
        }
    }
}
