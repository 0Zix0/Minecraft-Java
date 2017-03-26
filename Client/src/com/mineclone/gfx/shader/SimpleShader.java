package com.mineclone.gfx.shader;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL20.*;

import org.joml.Vector2f;

public class SimpleShader extends ShaderProgram {

	private int locationTime;
	private int locationPosition;
	
	public SimpleShader() {
		super("res/shaders/simple.vert", "res/shaders/simple.frag");
		getUniformLocations();
	}

	public void getUniformLocations() {
		locationTime = glGetUniformLocation(getID(), "time");
		locationPosition = glGetUniformLocation(getID(), "position");
	}
	
	public void setTime(float time) {
		loadFloat(locationTime, time);
	}
	
	public void setPosition(Vector2f position) {
		loadVector2f(locationPosition, position);
	}
}
