package com.sshsgd.pong;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.controllers.Controllers;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Vector2;
import com.sshsgd.pong.MyConstants.States;
import com.sshsgd.pong.managers.*;
import com.sshsgd.pong.managers.input.*;

public class Game extends ApplicationAdapter {
	
	public static Vector2 SIZE, CENTER;
	
	private GameStateManager gsm;
	
	private int frames, fps;
	private float fpsTime;
	
	public static Content res;
	
	@Override
	public void create () {
		int width = Gdx.graphics.getWidth();
		int height = Gdx.graphics.getHeight();
		SIZE = new Vector2();
		CENTER = new Vector2();
		SIZE.set(width, height);
		CENTER.set(width * .5f, height * .5f);
		
		res = new Content();
		res.loadBitmapFont("font", "prstartk.ttf", "main", 48, Color.WHITE, MyConstants.hex("#555"));
		
		Gdx.input.setInputProcessor(new MyInputProcessor());
		Controllers.addListener(new XBoxListener());
		
		gsm = new GameStateManager(States.Title);
		
		frames = 0;
		fps = 0;
		fpsTime = 0;
		
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		float dt = Gdx.graphics.getDeltaTime();
		
		gsm.handleInput();
		gsm.update(dt);
		gsm.draw(dt);
		
		frames++;
		fpsTime += dt;
		if(fpsTime > 1) {
			fps = frames;
			frames = 0;
			fpsTime = 0;
		}
		Gdx.graphics.setTitle(String.format("%s | %d fps", MyConstants.TITLE, fps));
		
		MyInput.update();
	}

	@Override
	public void resize(int width, int height) {
		SIZE.set(width, height);
		CENTER.set(width * .5f, height * .5f);
		gsm.resize(width, height);
	}

	@Override
	public void dispose() {
		gsm.dispose();
		res.removeAll();
	}
}
