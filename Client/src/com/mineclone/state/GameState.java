package com.mineclone.state;

import com.mineclone.Application;
import com.mineclone.entity.Entity;
import com.mineclone.gfx.renderer.MasterRenderer;

public abstract class GameState {

	protected Application application;
	
	public GameState(Application application) {
		this.application = application;
	}
	
	public abstract void input(Entity camera);
	public abstract void update(Entity camera);
	public abstract void draw(MasterRenderer renderer);
}
