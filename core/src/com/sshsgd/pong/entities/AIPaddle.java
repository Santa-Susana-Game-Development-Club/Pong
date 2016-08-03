package com.sshsgd.pong.entities;

import com.badlogic.gdx.math.MathUtils;
import com.sshsgd.pong.MyConstants;

/**
 * Created by JoseR on 8/3/2016.
 */
public class AIPaddle extends Paddle {

    private float destination;

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
            destination = MathUtils.clamp(ball.getY(), 0, MyConstants.WORLD_HEIGHT);
        }
    }
}
