package com.sshsgd.pong.gamestates;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.sshsgd.pong.managers.GameStateManager;

/**
 * Created by JoseR on 7/31/2016.
 */
public abstract class GameState {

    protected GameStateManager gsm;

    public GameState(GameStateManager gsm) {
        this.gsm = gsm;
        init();
    }

    protected abstract void init();
    public abstract void handleInput();
    public abstract void update(float dt);
    public abstract void draw(float dt, SpriteBatch sb, ShapeRenderer sr);
    public abstract void resize(int width, int height);
    public abstract void dispose();

}
