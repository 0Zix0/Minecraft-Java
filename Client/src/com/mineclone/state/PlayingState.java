package com.mineclone.state;

import com.mineclone.Application;
import com.mineclone.gfx.Model;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL20.*;

public class PlayingState extends GameState {

	private Model model;
	
	public PlayingState(Application application) {
		super(application);
		
		model = new Model(new float[] {
				 0.5f,  0.5f,
				-0.5f,  0.5f,
				-0.5f, -0.5f,
				-0.5f, -0.5f,
				 0.5f, -0.5f,
				 0.5f,  0.5f
		});
	}

	public void input() {
		
	}

	public void update() {
		
	}

	public void draw() {
		model.bind();
		
		glDrawArrays(GL_TRIANGLES, 0, 6);
		
		model.unbind();
	}
}
