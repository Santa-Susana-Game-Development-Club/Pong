package com.sshsgd.pong.entities;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by JoseR on 8/2/2016.
 */
public abstract class Entity {

    protected Rectangle bounds;
    protected Vector2 vel;

    public Entity() {
        bounds = new Rectangle();
        vel = new Vector2();
    }

    public void draw(ShapeRenderer sr, Color color, Color shadow) {
        Color c = new Color(sr.getColor());
        sr.setColor(shadow);
        sr.rect(getX() + 3, getY() - 3, getWidth(), getHeight());
        sr.setColor(c);
        draw(sr, color);
    }

    public void draw(ShapeRenderer sr, Color color) {
        Color c = new Color(sr.getColor());
        sr.setColor(color);
        sr.rect(getX(), getY(), getWidth(), getHeight());
        sr.setColor(c);
    }

    public boolean collidingWith(Entity e) {
        return collidingWith(e.getBounds());
    }

    public boolean collidingWith(Rectangle r) {
        return bounds.overlaps(r);
    }

    public float getX() {
        return bounds.x;
    }

    public void setX(float x) {
        bounds.x = x;
    }

    public float getY() {
        return bounds.y;
    }

    public void setY(float y) {
        bounds.y = y;
    }

    public float getWidth() {
        return bounds.width;
    }

    public void setWidth(float width) {
        bounds.width = width;
    }

    public float getHeight() {
        return bounds.height;
    }

    public void setHeight(float height) {
        bounds.height = height;
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public void setBounds(Rectangle bounds) {
        this.bounds = bounds;
    }

    public Vector2 getVel() {
        return vel;
    }

    public void setVel(Vector2 vel) {
        this.vel = vel;
    }
}
