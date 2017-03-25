package com.mineclone;

import com.mineclone.gfx.Display;

public class Main {

	public static void main(String[] args) {
		Display.initialize(1280, 720, "Window");
		
		while(!Display.shouldClose()) {
			Display.clear();
			
			Display.update();
		}
	}
}
