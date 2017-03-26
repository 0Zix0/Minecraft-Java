package com.mineclone.gfx.shader;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL20.*;

public class SimpleShader extends ShaderProgram {

	private int locationTime;
	
	public SimpleShader() {
		super("res/shaders/simple.vert", "res/shaders/simple.frag");
		getUniformLocations();
	}

	public void getUniformLocations() {
		locationTime = glGetUniformLocation(getID(), "time");
	}
	
	public void setTime(float time) {
		loadFloat(locationTime, time);
	}
}
