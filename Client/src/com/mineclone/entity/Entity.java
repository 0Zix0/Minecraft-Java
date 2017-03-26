package com.mineclone.entity;

import org.joml.Vector2f;

public abstract class Entity {

	protected Vector2f position = new Vector2f();
	
	public Vector2f getPosition() {
		return position;
	}
	
	public void setPosition(Vector2f position) {
		this.position = position;
	}
}
