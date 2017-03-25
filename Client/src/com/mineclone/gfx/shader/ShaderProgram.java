package com.mineclone.gfx.shader;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL20.*;

public abstract class ShaderProgram {

	private int programID;
	
	public ShaderProgram(String vertexFile, String fragmentFile) {
		programID = ShaderLoader.loadShader(vertexFile, fragmentFile);
	}
	
	public abstract void bindAttributes();
	
	public void bindAttribute(int location, String name) {
		glBindAttribLocation(programID, location, name);
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
