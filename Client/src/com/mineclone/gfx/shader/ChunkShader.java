package com.mineclone.gfx.shader;

import static org.lwjgl.opengl.GL20.glGetUniformLocation;

import org.joml.Matrix4f;

public class ChunkShader extends ShaderProgram {
	
	private int locationTime;
	private int locationViewMatrix;
	private int locationModelMatrix;
	private int locationProjMatrix;
	
	public ChunkShader() {
		super("res/shaders/chunk.vert", "res/shaders/chunk.frag");
		getUniformLocations();
	}

	public void getUniformLocations() {
		locationTime = glGetUniformLocation(getID(), "time");
		
		locationViewMatrix = glGetUniformLocation(getID(), "viewMatrix");
		locationModelMatrix = glGetUniformLocation(getID(), "modelMatrix");
		locationProjMatrix = glGetUniformLocation(getID(), "projMatrix");
	}
	
	public void setTime(float time) {
		loadFloat(locationTime, time);
	}

	public void setViewMatrix(Matrix4f matrix) {
		loadMatrix4f(locationViewMatrix, matrix);
	}
	
	public void setModelMatrix(Matrix4f matrix) {
		loadMatrix4f(locationModelMatrix, matrix);
	}
	
	public void setProjMatrix(Matrix4f matrix) {
		loadMatrix4f(locationProjMatrix, matrix);
	}
}
