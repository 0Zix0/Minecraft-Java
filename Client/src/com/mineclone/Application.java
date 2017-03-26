package com.mineclone;

import java.util.Stack;

import com.mineclone.entity.Entity;
import com.mineclone.gfx.Display;
import com.mineclone.gfx.renderer.MasterRenderer;
import com.mineclone.state.GameState;
import com.mineclone.state.PlayingState;

public class Application {

	private Stack<GameState> states = new Stack<GameState>();;
	
	private MasterRenderer renderer;
	private Entity camera = new Entity() {
	};
	
	public Application() {
		renderer = new MasterRenderer();
		pushState(new PlayingState(this));
	}
	
	public void gameLoop() {
		while(!Display.shouldClose()) {
			renderer.clear();

			states.peek().input(camera);
			states.peek().update(camera);
			states.peek().draw(renderer);
			
			renderer.update(camera);
		}
	}
	
	public void pushState(GameState state) {
		states.push(state);
	}
	
	public void popState() {
		states.pop();
	}
}
