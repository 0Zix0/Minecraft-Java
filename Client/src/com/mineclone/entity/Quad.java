package com.mineclone.entity;

import com.mineclone.gfx.Model;

public class Quad extends Entity {

	private Model model;
	
	private float[] vertices = new float[] {
			 0.5f,  0.5f, 0,
			-0.5f,  0.5f, 0,
			-0.5f, -0.5f, 0,
			 0.5f, -0.5f, 0
	};
	
	private float[] textureCoordinates = new float[] {
			1, 1,
			0, 1,
			0, 0,
			1, 0
	};
	
	private int[] indices = new int[] {
			0, 1, 2,
			2, 3, 0
	};
	
	public Quad() {
		model = new Model(vertices, textureCoordinates, indices);
	}
	
	public Model getModel() {
		return model;
	}
}
