package com.sshsgd.pong.entities;

/**
 * Created by JoseR on 7/25/2016.
 */
public class AIPaddle extends Paddle {

    public AIPaddle(float width, float height, Side side) {
        super(width, height, side);
    }

    @Override
    public void behave(Ball ball) {
        if(ball.getY() > bounds.y + bounds.height) {
            vel.y = speed;
        } else if(ball.getY() + ball.getHeight()  < bounds.y) {
            vel.y = -speed;
        }
    }
}
