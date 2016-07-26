package com.sshsgd.pong.entities;

import com.sshsgd.pong.MyConstants;

/**
 * Created by JoseR on 7/25/2016.
 */
public class AIPaddle extends Paddle {

    float destination;

    public AIPaddle(float width, float height, Side side) {
        super(width, height, side);
        destination = (MyConstants.WORLD_HEIGHT * .5f) - (height * .5f);
    }

    @Override
    public void behave(Ball ball) {
        if(destination > getY() + getHeight()) {
            vel.y = speed;
        } else if(destination < getY()) {
            vel.y = -speed;
        } else {
            destination = ball.getY();
        }
    }
}
