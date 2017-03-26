package com.mineclone.state;

import com.mineclone.Application;
import com.mineclone.entity.Entity;
import com.mineclone.entity.Quad;
import com.mineclone.gfx.Model;
import com.mineclone.gfx.renderer.MasterRenderer;
import com.mineclone.gfx.shader.SimpleShader;
import com.mineclone.gfx.texture.BasicTexture;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL20.*;

import org.lwjgl.glfw.GLFW;

public class PlayingState extends GameState {

	private Quad quad;
	private BasicTexture texture;
	
	public PlayingState(Application application) {
		super(application);
		
		quad = new Quad();
		
		texture = new BasicTexture("res/textures/texture.png");
		texture.bind();
		
		quad.getPosition().z = -3;
	}

	public void input(Entity camera) {
		
	}

	public void update(Entity camera) {
		quad.getPosition().x = (float) Math.sin(GLFW.glfwGetTime());
	}

	public void draw(MasterRenderer renderer) {
		renderer.draw(quad);
	}
}
