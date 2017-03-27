package com.mineclone.state;

import org.lwjgl.glfw.GLFW;

import com.mineclone.Application;
import com.mineclone.entity.Quad;
import com.mineclone.gfx.Camera;
import com.mineclone.gfx.renderer.MasterRenderer;
import com.mineclone.gfx.texture.BasicTexture;

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

	public void input(Camera camera) {
		
	}

	public void update(Camera camera, float dt) {
		camera.input(dt);
		//quad.getPosition().x = (float) Math.sin(GLFW.glfwGetTime());
	}

	public void draw(MasterRenderer renderer) {
		renderer.draw(quad);
	}
}
