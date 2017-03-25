package com.mineclone;

import java.util.Stack;

import com.mineclone.gfx.Display;
import com.mineclone.state.GameState;
import com.mineclone.state.PlayingState;

public class Application {

	private Stack<GameState> states = new Stack<GameState>();;
	
	public Application() {
		pushState(new PlayingState(this));
	}
	
	public void gameLoop() {
		while(!Display.shouldClose()) {
			Display.clear();

			states.peek().input();
			states.peek().update();
			states.peek().draw();
			
			Display.update();
		}
	}
	
	public void pushState(GameState state) {
		states.push(state);
	}
	
	public void popState() {
		
	}
}
