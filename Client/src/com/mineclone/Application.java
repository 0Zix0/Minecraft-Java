package com.mineclone;

import java.util.Stack;

import org.lwjgl.glfw.GLFW;

import com.mineclone.gfx.Camera;
import com.mineclone.gfx.Display;
import com.mineclone.gfx.renderer.MasterRenderer;
import com.mineclone.state.GameState;
import com.mineclone.state.PlayingState;

public class Application {

	private Stack<GameState> states = new Stack<GameState>();;
	
	private MasterRenderer renderer;
	private Camera camera = new Camera();
	
	public Application() {
		renderer = new MasterRenderer();
		pushState(new PlayingState(this));
	}
	
	public void gameLoop() {
		double lastTime = GLFW.glfwGetTime();
		while(!Display.shouldClose()) {
			double now = GLFW.glfwGetTime();
			renderer.clear();

			states.peek().input(camera);
			states.peek().update(camera, (float) lastTime);
			states.peek().draw(renderer);
			
			renderer.update(camera);
			lastTime = GLFW.glfwGetTime() - now;
		}
	}
	
	public void pushState(GameState state) {
		states.push(state);
	}
	
	public void popState() {
		states.pop();
	}
}
