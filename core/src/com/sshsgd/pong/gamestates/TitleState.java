package com.sshsgd.pong.gamestates;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Align;
import com.sshsgd.pong.Game;
import com.sshsgd.pong.MyConstants;
import com.sshsgd.pong.graphics.MyViewport;
import com.sshsgd.pong.managers.GameStateManager;
import com.sshsgd.pong.managers.input.MyInput;

public class TitleState extends GameState {
	
	private MyViewport view;
	
	private String santa, gameDev, enter;

	private float targetWidth;
	private float textX;
	
	private float santaY, santaH;
	private float titleY, titleH;
	private float gameDevY, gameDevH;
	private float enterY;
	
	public TitleState(GameStateManager gsm) {
		super(gsm);
	}

	@Override
	protected void init() {
		view = new MyViewport();
		titleY = (MyConstants.WORLD_HEIGHT * .5f) + (titleH * .5f);
		setValues();
	}
	
	private void setValues() {
		santa = "Santa Susana High School";
		gameDev = "Game Dev. Club Presents";
		enter = "Press Enter to Begin";
		
		targetWidth = MyConstants.WORLD_WIDTH - 20;
		textX = 10;
		
		titleH = Game.res.getHeight("main", MyConstants.TITLE, targetWidth, Align.center, true);

		gameDevH = Game.res.getHeight("main", gameDev, targetWidth, Align.center, true);
		gameDevY = titleY + (titleH * 2) + gameDevH;
		
		santaH = Game.res.getHeight("main", santa, targetWidth, Align.center, true);
		santaY = gameDevY + gameDevH + santaH;
		
		enterY = titleY - (titleH * 3);
		
	}

	@Override
	public void handleInput() {
		if(MyInput.keyPressed(MyInput.BACK)) {
			Gdx.app.exit();
		}
	}

	@Override
	public void update(float dt) {
		setValues();

	}

	@Override
	public void draw(float dt, SpriteBatch sb, ShapeRenderer sr) {
		sb.begin();
		sb.setProjectionMatrix(view.getProjectionMatrix());
		Game.res.getFont("main").draw(sb, MyConstants.TITLE, textX, titleY, targetWidth, Align.center, true);
		Game.res.getFont("main").draw(sb, gameDev, textX, gameDevY, targetWidth, Align.center, true);
		Game.res.getFont("main").draw(sb, santa, textX, santaY, targetWidth, Align.center, true);
		Game.res.getFont("main").draw(sb, enter, textX, enterY, targetWidth, Align.center, true);
		sb.end();

	}

	@Override
	public void resize(int width, int height) {
		view.resize(width, height);

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
