package com.mineclone.gfx;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL30.*;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;

import com.mineclone.util.BufferUtilities;

public class Model {

	private ArrayList<Integer> buffers = new ArrayList<Integer>();
	private int vboCount = 0;
	private int vao;
	private int indicesCount;
	
	public Model(float[] vertexPositions, float[] textureCoordinates, int[] indices) {
		indicesCount = indices.length;
		vao = glGenVertexArrays();
		
		glBindVertexArray(vao);
		
		addVBO(3, vertexPositions);
		addVBO(2, textureCoordinates);
		addEBO(indices);
		
		glBindVertexArray(0);
		glBindBuffer(GL_ARRAY_BUFFER, 0);
	}
	
	public void addVBO(int dim, float[] data) {
		int vbo = glGenBuffers();
		
		glBindBuffer(GL_ARRAY_BUFFER, vbo);
		glBufferData(GL_ARRAY_BUFFER, BufferUtilities.createFloatBuffer(data), GL_STATIC_DRAW);
		glVertexAttribPointer(vboCount, dim, GL_FLOAT, false, 0, 0);
		glEnableVertexAttribArray(vboCount);
		vboCount++;
		buffers.add(vbo);
		glBindBuffer(GL_ARRAY_BUFFER, 0);
	}
	
	public void addEBO(int[] indices) {
		int ebo = glGenBuffers();
		glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ebo);
		glBufferData(GL_ELEMENT_ARRAY_BUFFER, BufferUtilities.createIntBuffer(indices), GL_STATIC_DRAW);
		buffers.add(ebo);
	}
	
	public void bind() {
		glBindVertexArray(vao);
	}
	
	public void unbind() {
		glBindVertexArray(0);
	}
	
	public int getIndicesCount() {
		return indicesCount;
	}
	
	public void delete() {
		glDeleteVertexArrays(vao);
		
		//for(int i : buffers) glDeleteBuffers(i);
		buffers.forEach((Integer i) -> {
			glDeleteBuffers(i);
		});
	}
}
