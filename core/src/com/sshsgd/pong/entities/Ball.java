package com.sshsgd.pong.entities;

import com.badlogic.gdx.math.MathUtils;
import com.sshsgd.pong.Game;
import com.sshsgd.pong.MyConstants;

public class Ball extends Entity {

	public enum BounceMode {
		ALL_SIDES, TOP_BOTTOM
	}

	private BounceMode bounceMode;
	
	private float speed, radians;
	
	private final float speedIncrement = 50;
	
	public Ball(float width, float height, BounceMode bounceMode) {
		super();
		bounds.width = width;
		bounds.height = height;
		this.bounceMode = bounceMode;
		reset();
	}
	
	public void reset() {
		speed = 500;
		radians = MathUtils.random(MathUtils.PI * 2);
		vel.x = MathUtils.cos(radians) * speed;
		vel.y = MathUtils.sin(radians) * speed;
		bounds.x = (MyConstants.WORLD_WIDTH * .5f) - (bounds.width * .5f);
		bounds.y = (MyConstants.WORLD_HEIGHT * .5f) - (bounds.height * .5f);
        Game.res.getSound("peep").play();
    }
	
	public void update(float dt) {
		bounds.x += vel.x * dt;
		bounds.y += vel.y * dt;
		switch(bounceMode) {
		case ALL_SIDES:
			updateBounceAllSides();
			break;
		case TOP_BOTTOM:
            updateTopBottom();
			break;
		default:
			break;
		}
	}

    public void collisions(Paddle... paddles) {
        for (Paddle paddle: paddles) {
            if (collidingWith(paddle)) {
                switch (paddle.getSide()) {
                    case LEFT:
                        bounds.x = paddle.getX() + paddle.getWidth() + 1;
                        break;
                    case RIGHT:
                        bounds.x = paddle.getX() - bounds.width - 1;
                        break;
                }
                bounceX();
            }
        }
    }
	
	private void updateBounceAllSides() {
		if(bounds.x <= 0) {
            bounds.x++;
			bounceX();
		}
        if(bounds.x + bounds.width >= MyConstants.WORLD_WIDTH) {
            bounds.x--;
            bounceX();
        }
        updateTopBottom();
	}

    private void updateTopBottom() {
        if(bounds.y <= 0) {
            bounds.y++;
            bounceY();
        }
        if(bounds.y + bounds.height >= MyConstants.WORLD_HEIGHT) {
            bounds.y--;
            bounceY();
        }
    }

	private void bounceX() {
        Game.res.getSound("beep").play();
		vel.x *= -1;
		radians = (float) Math.acos(vel.x / speed);
		speed += speedIncrement;
		vel.x = MathUtils.cos(radians) * speed;
	}
	
	private void bounceY() {
        Game.res.getSound("plop").play();
		vel.y *= -1;
		radians = (float) Math.asin(vel.y / speed);
		speed += speedIncrement;
		vel.y = MathUtils.sin(radians) * speed;
	}
	

}
