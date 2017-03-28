package com.mineclone.gfx.shader;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL20.*;

import org.joml.Matrix4f;
import org.joml.Vector2f;

import com.mineclone.util.MathUtilities;

public class SimpleShader extends ShaderProgram {

	private Matrix4f projectionMatrix = MathUtilities.createProjMatrix();
	
	private int locationTime;
	private int locationViewMatrix;
	private int locationModelMatrix;
	private int locationProjMatrix;
	
	public SimpleShader() {
		super("res/shaders/simple.vert", "res/shaders/simple.frag");
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
