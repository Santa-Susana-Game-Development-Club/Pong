package com.sshsgd.pong.graphics;

import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.sshsgd.pong.Game;
import com.sshsgd.pong.MyConstants;

/**
 * Created by JoseR on 7/29/2016.
 */
public class MyViewport {

    private MyCamera cam;
    private Viewport view;

    public MyViewport(float worldWidth, float worldHeight, boolean centerCamera) {
        cam = new MyCamera();
        view = new StretchViewport(worldWidth, worldHeight, cam);
        view.apply(centerCamera);
        view.update((int) Game.SIZE.x, (int) Game.SIZE.y, centerCamera);
    }

    public MyViewport(boolean centerCamera) {
        this(MyConstants.WORLD_WIDTH, MyConstants.WORLD_HEIGHT, centerCamera);
    }

    public MyViewport() {
        this(true);
    }

    public void resize(int width, int height) {
        view.update(width, height);
    }

    public Matrix4 getProjectionMatrix() {
        return cam.combined;
    }

    public MyCamera getCam() {
        return cam;
    }

    public void setCam(MyCamera cam) {
        this.cam = cam;
    }

    public Viewport getView() {
        return view;
    }

    public void setView(Viewport view) {
        this.view = view;
    }

}
