package com.sshsgd.pong.graphics;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by JoseR on 7/29/2016.
 */
public class MyCamera extends OrthographicCamera {

    public MyCamera() {
        super();
    }

    public MyCamera(float viewportWidth, float viewportHeight) {
        super(viewportWidth, viewportHeight);
    }

    public MyCamera(Vector2 viewport, boolean center) {
        super(viewport.x, viewport.y);
        if(center) this.position.set(viewport.x * .5f, viewport.y * .5f, 0);
        this.update();
    }

    public boolean inView(float x, float y) {
        return (((x > getLeft()) && (x < getRight())) && ((y < getTop()) && (y > getBottom())));
    }

    public boolean inView(Vector2 point) {
        return inView(point.x, point.y);
    }

    public void resize(int width, int height, boolean center) {
        this.viewportHeight = height;
        this.viewportWidth = width;
        if(center) this.position.set(width * .5f, height * .5f, 0);
        this.update();
    }

    public void resize(Vector2 size, boolean center) {
        this.resize((int) size.x, (int) size.y, center);
    }

    public float getLeft() {
        return this.position.x - (this.viewportWidth * .5f);
    }

    public float getRight() {
        return this.position.x + (this.viewportWidth * .5f);
    }

    public float getBottom() {
        return this.position.y - (this.viewportHeight * .5f);
    }

    public float getTop() {
        return this.position.y + (this.viewportHeight * .5f);
    }

}
