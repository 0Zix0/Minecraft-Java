package com.mineclone.state;

import com.mineclone.Application;
import com.mineclone.gfx.Model;
import com.mineclone.gfx.shader.SimpleShader;
import com.mineclone.gfx.texture.BasicTexture;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL20.*;

public class PlayingState extends GameState {

	private Model model;
	private BasicTexture texture;
	
	private SimpleShader shader;
	
	private float[] vertices = new float[] {
			 0.5f,  0.5f,
			-0.5f,  0.5f,
			-0.5f, -0.5f,
			 0.5f, -0.5f
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
	
	public PlayingState(Application application) {
		super(application);
		
		model = new Model(vertices, textureCoordinates, indices);
		texture = new BasicTexture("res/textures/texture.png");
		shader = new SimpleShader();
	}

	public void input() {
		
	}

	public void update() {
		
	}

	public void draw() {
		shader.bind();
		model.bind();
		texture.bind();
		
		glDrawArrays(GL_TRIANGLES, 0, 6);
		glDrawElements(GL_TRIANGLES, model.getIndicesCount(), GL_UNSIGNED_INT, 0);
		
		texture.unbind();
		model.unbind();
		shader.unbind();
	}
}
