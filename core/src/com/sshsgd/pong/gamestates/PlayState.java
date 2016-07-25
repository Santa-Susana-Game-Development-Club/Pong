package com.sshsgd.pong.gamestates;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Align;
import com.sshsgd.pong.Game;
import com.sshsgd.pong.MyConstants;
import com.sshsgd.pong.MyConstants.States;
import com.sshsgd.pong.entities.*;
import com.sshsgd.pong.graphics.MyViewport;
import com.sshsgd.pong.managers.GameStateManager;
import com.sshsgd.pong.managers.input.MyInput;

public class PlayState extends GameState {

    private MyViewport myViewport;

    private Ball ball;

    private Paddle playerPaddle, aiPaddle;

    private float resetTime;

    private int rightScore, leftScore;

	public PlayState(GameStateManager gsm) {
		super(gsm);
	}

	@Override
	protected void init() {
        myViewport = new MyViewport(MyConstants.WORLD_WIDTH, MyConstants.WORLD_HEIGHT, true);
		ball = new Ball(25, 25, Ball.BounceMode.TOP_BOTTOM);
        playerPaddle = new PlayerPaddle(25, 100, Paddle.Side.LEFT);
        aiPaddle = new AIPaddle(25, 100, Paddle.Side.RIGHT);
        resetTime = 0;
	}

	@Override
	public void handleInput() {
		if(MyInput.keyPressed(MyInput.BACK)) {
			gsm.setState(States.Title);
		}

	}

	@Override
	public void update(float dt) {
		ball.update(dt);
        playerPaddle.update(ball, dt);
        aiPaddle.update(ball, dt);
        ball.collisions(playerPaddle, aiPaddle);
        if(ball.getX() < -ball.getWidth() || ball.getX() > MyConstants.WORLD_WIDTH ) {
            resetTime += dt;
            if(resetTime > .5f) {
                if(ball.getX() < -ball.getWidth()) {
                    leftScore++;
                } else {
                    rightScore++;
                }
                ball.reset();
            }
        } else {
            resetTime = 0;
        }

	}

	@Override
	public void draw(float dt, SpriteBatch sb, ShapeRenderer sr) {
        sr.begin(ShapeRenderer.ShapeType.Filled);
        sr.setProjectionMatrix(myViewport.getProjectionMatrix());
        ball.draw(sr);
        playerPaddle.draw(sr);
        aiPaddle.draw(sr);
        sr.end();
        sb.begin();
        sb.setProjectionMatrix(myViewport.getProjectionMatrix());
        String left = String.valueOf(leftScore);
        float leftWidth = Game.res.getWidth("main", left, MyConstants.WORLD_WIDTH, Align.left, false);
        float leftHeight = Game.res.getHeight("main", left, MyConstants.WORLD_WIDTH, Align.left, false);
        float leftX = (MyConstants.WORLD_WIDTH * .75f) - (leftWidth * .5f);
        float leftY = (MyConstants.WORLD_HEIGHT * .75f) + (leftHeight * .5f);
        Game.res.getFont("main").draw(sb, left, leftX, leftY);
        String right = String.valueOf(rightScore);
        float rightWidth = Game.res.getWidth("main", right, MyConstants.WORLD_WIDTH, Align.left, false);
        float rightHeight = Game.res.getHeight("main", right, MyConstants.WORLD_WIDTH, Align.left, false);
        float rightX = (MyConstants.WORLD_WIDTH * .25f) - (rightWidth * .5f);
        float rightY = (MyConstants.WORLD_HEIGHT * .75f) + (rightHeight * .5f);
        Game.res.getFont("main").draw(sb, right, rightX, rightY);
        sb.end();
	}

	@Override
	public void resize(int width, int height) {
		myViewport.resize(width, height);
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
