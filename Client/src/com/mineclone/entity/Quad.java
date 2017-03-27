package com.mineclone.entity;

import com.mineclone.gfx.Model;

public class Quad extends Entity {

	private Model model;
	
	private float[] vertices = new float[] {
		    1, 0, 0,
		    0, 0, 0,
		    0, 1, 0,
		    1, 1, 0,
		 
		    //Right-Side
		    1, 0, 1,
		    1, 0, 0,
		    1, 1, 0,
		    1, 1, 1,
		 
		    //Front
		    0, 0, 1,
		    1, 0, 1,
		    1, 1, 1,
		    0, 1, 1,
		 
		    //Left
		    0, 0, 0,
		    0, 0, 1,
		    0, 1, 1,
		    0, 1, 0,
		 
		    //Top
		    0, 1, 1,
		    1, 1, 1,
		    1, 1, 0,
		    0, 1, 0,
		 
		    //Bottom
		    0, 0, 0,
		    1, 0, 0,
		    1, 0, 1,
		    0, 0, 1
	};
	
	private float[] textureCoordinates = new float[] {
		    1.0f, 1.0f,
		    0.0f, 1.0f,
		    0.0f, 0.0f,
		    1.0f, 0.0f,
		 
		    1.0f, 1.0f,
		    0.0f, 1.0f,
		    0.0f, 0.0f,
		    1.0f, 0.0f,
		 
		    1.0f, 1.0f,
		    0.0f, 1.0f,
		    0.0f, 0.0f,
		    1.0f, 0.0f,
		 
		    1.0f, 1.0f,
		    0.0f, 1.0f,
		    0.0f, 0.0f,
		    1.0f, 0.0f,
		 
		    1.0f, 1.0f,
		    0.0f, 1.0f,
		    0.0f, 0.0f,
		    1.0f, 0.0f,
		 
		    1.0f, 1.0f,
		    0.0f, 1.0f,
		    0.0f, 0.0f,
		    1.0f, 0.0f,
	};
	
	private int[] indices = new int[] {
		    0, 1, 2,
		    2, 3, 0,
		 
		    4, 5, 6,
		    6, 7, 4,
		 
		    8, 9, 10,
		    10, 11, 8,
		 
		    12, 13, 14,
		    14, 15, 12,
		 
		    16, 17, 18,
		    18, 19, 16,
		 
		    20, 21, 22,
		    22, 23, 20
	};
	
	public Quad() {
		model = new Model(vertices, textureCoordinates, indices);
	}
	
	public Model getModel() {
		return model;
	}
}
