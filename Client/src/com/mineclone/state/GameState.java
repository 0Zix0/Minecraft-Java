package com.mineclone.state;

import com.mineclone.Application;

public abstract class GameState {

	protected Application application;
	
	public GameState(Application application) {
		this.application = application;
	}
	
	public abstract void input();
	public abstract void update();
	public abstract void draw();
}
