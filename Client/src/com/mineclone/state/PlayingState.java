package com.mineclone.state;

import com.mineclone.Application;
import com.mineclone.entity.Quad;
import com.mineclone.gfx.Camera;
import com.mineclone.gfx.renderer.MasterRenderer;
import com.mineclone.gfx.texture.TextureAtlas;

public class PlayingState extends GameState {

	private Quad quad;
	private TextureAtlas texture;
	
	public PlayingState(Application application) {
		super(application);
		
		texture = new TextureAtlas("res/textures/atlas1.png", 16);
		texture.bind();
		
		quad = new Quad(texture);
		
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
