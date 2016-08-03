package com.sshsgd.pong.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.sshsgd.pong.Game;
import com.sshsgd.pong.MyConstants.States;
import com.sshsgd.pong.gamestates.*;
import com.sshsgd.pong.managers.input.MyInput;

/**
 * Created by JoseR on 7/31/2016.
 */
public class GameStateManager {

    private GameState gameState;
    private SpriteBatch sb;
    private ShapeRenderer sr;

    private Vector2 windowSize;

    public GameStateManager(States defaultState) {
        sb = new SpriteBatch();
        sr = new ShapeRenderer();
        windowSize = new Vector2(Game.SIZE);
        setState(defaultState);
    }

    public void setState(States newState) {
        if(gameState != null) gameState.dispose();
        switch (newState) {
            case Title:
                gameState = new TitleState(this);
                break;
            case Play:
                gameState = new PlayState(this);
                break;
            default:
                Gdx.app.error(getClass().getName(), "State Not Found");
                Gdx.app.exit();
                break;
        }
    }

    public void handleInput() {
        if(MyInput.keyPressed(MyInput.FULLSCREEN)) {
            if(!Gdx.graphics.isFullscreen()) {
                windowSize.set(Game.SIZE);
                Gdx.graphics.setFullscreenMode(Gdx.graphics.getDisplayMode(Gdx.graphics.getMonitor()));
            } else {
                Gdx.graphics.setWindowedMode((int) windowSize.x, (int) windowSize.y);
            }
            Gdx.input.setCursorCatched(Gdx.graphics.isFullscreen());
        }
        gameState.handleInput();
    }

    public void update(float dt) {
        gameState.update(dt);
    }

    public void draw(float dt) {
        gameState.draw(dt, sb, sr);
    }

    public void resize(int width, int height) {
        gameState.resize(width, height);
    }

    public void dispose() {
        gameState.dispose();
        sb.dispose();
        sr.dispose();
    }

}
