package com.mineclone.entity;

import org.joml.Vector3f;

public abstract class Entity {

	protected Vector3f position = new Vector3f();
	protected Vector3f rotation = new Vector3f();
	
	public Vector3f getPosition() {
		return position;
	}
	
	public void setPosition(Vector3f position) {
		this.position = position;
	}
	
	public Vector3f getRotation() {
		return rotation;
	}
	
	public void setRotation(Vector3f rotation) {
		this.rotation = rotation;
	}
}
