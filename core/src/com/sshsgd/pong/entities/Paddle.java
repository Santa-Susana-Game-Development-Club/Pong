package com.sshsgd.pong.entities;

import com.sshsgd.pong.MyConstants;

/**
 * Created by JoseR on 8/3/2016.
 */
public abstract class Paddle extends Entity {

    public enum Side {
        LEFT, RIGHT
    }

    protected Side side;
    protected static final float speed = 500;

    public Paddle(float width, float height, Side side) {
        super();
        this.side = side;
        resetX(width);
        bounds.y = (MyConstants.WORLD_HEIGHT * .5f) - (height * .5f);
        bounds.setSize(width, height);
    }

    public abstract void behave(Ball ball);

    public void update(Ball ball, float dt) {
        behave(ball);
        vel.x = 0;
        bounds.y += vel.y * dt;
        if(bounds.y > MyConstants.WORLD_HEIGHT - bounds.height) {
            bounds.y = MyConstants.WORLD_HEIGHT - bounds.height;
        }
        if(bounds.y < 0) {
            bounds.y = 0;
        }
    }


    public void resetX(float width) {
        switch (side) {
            case LEFT:
                bounds.x = (MyConstants.WORLD_WIDTH * .15f) - (width * .5f);
                break;
            case RIGHT:
                bounds.x = (MyConstants.WORLD_WIDTH * .85f) - (width * .5f);
                break;
        }
    }

    public Side getSide() {
        return side;
    }
}
