package com.mineclone.state;

import com.mineclone.Application;
import com.mineclone.entity.Entity;
import com.mineclone.gfx.Camera;
import com.mineclone.gfx.renderer.MasterRenderer;

public abstract class GameState {

	protected Application application;
	
	public GameState(Application application) {
		this.application = application;
	}
	
	public abstract void input(Camera camera);
	public abstract void update(Camera camera, float dt);
	public abstract void draw(MasterRenderer renderer);
}
