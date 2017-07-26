package com.mineclone.gfx.shader;

import static org.lwjgl.opengl.GL20.*;

import java.nio.FloatBuffer;

import org.joml.Matrix4f;
import org.joml.Vector2f;
import org.lwjgl.BufferUtils;

public abstract class ShaderProgram {

	private int programID;
	
	public ShaderProgram(String vertexFile, String fragmentFile) {
		programID = ShaderLoader.loadShader(vertexFile, fragmentFile);
	}
	
	public abstract void getUniformLocations();
	
	public int getID() {
		return programID;
	}
	
	public void bindAttribute(int location, String name) {
		glBindAttribLocation(programID, location, name);
	}
	
	public void loadFloat(int location, float value) {
		glUniform1f(location, value);
	}
	
	public void loadVector2f(int location, Vector2f vector) {
		glUniform2f(location, vector.x, vector.y);
	}
	
	public void loadMatrix4f(int location, Matrix4f matrix) {
		FloatBuffer fb = BufferUtils.createFloatBuffer(16);
		matrix.get(fb);
		glUniformMatrix4fv(location, false, fb);
	}
	
	public void bind() {
		glUseProgram(programID);
	}
	
	public void unbind() {
		glUseProgram(0);
	}
	
	public void delete() {
		glDeleteProgram(programID);
	}
}
