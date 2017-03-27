package com.mineclone.entity;

import java.util.ArrayList;

import com.mineclone.gfx.Model;
import com.mineclone.gfx.texture.TextureAtlas;

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
	
	public Quad(TextureAtlas atlas) {
		ArrayList<Float> coords = new ArrayList<>();
		coords.addAll(atlas.getTextureCoords(1, 0));
		coords.addAll(atlas.getTextureCoords(1, 0));
		coords.addAll(atlas.getTextureCoords(1, 0));
		coords.addAll(atlas.getTextureCoords(1, 0));

		coords.addAll(atlas.getTextureCoords(0, 0));
		
		coords.addAll(atlas.getTextureCoords(2, 0));
		Float[] fa = (Float[]) coords.toArray(new Float[coords.size()]);
		float[] fin = new float[fa.length];
		for(int i = 0; i < fin.length; i++) {
			fin[i] = fa[i];
		}
		model = new Model(vertices, fin, indices);
	}
	
	public Model getModel() {
		return model;
	}
}
