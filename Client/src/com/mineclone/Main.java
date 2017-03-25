package com.mineclone;

import com.mineclone.gfx.Display;

public class Main {

	public static void main(String[] args) {
		Display.init(1280, 720, "Window");
		Application app = new Application();
		app.gameLoop();
	}
}
