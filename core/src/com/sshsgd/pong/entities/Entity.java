package com.sshsgd.pong.entities;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class Entity {

	protected Rectangle bounds;
	protected Vector2 vel;
	
	public Entity() {
		bounds = new Rectangle();
		vel = new Vector2();
	}
	
	public void draw(ShapeRenderer sr) {
		sr.rect(getX(), getY(), getWidth(), getHeight());
	}
	
	public boolean collidingWith(Entity e) {
		return collidingWith(e.getBounds());
	}
	
	public boolean collidingWith(Rectangle r) {
		return bounds.overlaps(r);
	}

	public float getX() {
		return bounds.getX();
	}

	public Rectangle setX(float x) {
		return bounds.setX(x);
	}

	public float getY() {
		return bounds.getY();
	}

	public Rectangle setY(float y) {
		return bounds.setY(y);
	}

	public float getWidth() {
		return bounds.getWidth();
	}

	public Rectangle setWidth(float width) {
		return bounds.setWidth(width);
	}

	public float getHeight() {
		return bounds.getHeight();
	}

	public Rectangle setHeight(float height) {
		return bounds.setHeight(height);
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
