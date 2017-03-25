package com.mineclone.gfx;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL20.*;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class Model {

	private int vertexID;
	
	public Model(float[] vertexPositions) {
		vertexID = glGenBuffers();
		bind();
		glBufferData(GL_ARRAY_BUFFER, createFloatBuffer(vertexPositions), GL_STATIC_DRAW);
		glVertexAttribPointer(0, 2, GL_FLOAT, false, 0, 0);
		glEnableVertexAttribArray(0);
		unbind();
	}
	
	public void bind() {
		glBindBuffer(GL_ARRAY_BUFFER, vertexID);
	}
	
	public void unbind() {
		glBindBuffer(GL_ARRAY_BUFFER, 0);
	}
	
	public void delete() {
		glDeleteBuffers(vertexID);
	}
	
	private static FloatBuffer createFloatBuffer(float[] array) {
		FloatBuffer result = ByteBuffer.allocateDirect(array.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
		result.put(array).flip();
		return result;
	}
}
