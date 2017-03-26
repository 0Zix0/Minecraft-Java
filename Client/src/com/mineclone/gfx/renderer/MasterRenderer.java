package com.mineclone.gfx.renderer;

import com.mineclone.gfx.Display;
import com.mineclone.gfx.Model;

public class MasterRenderer {

	private SimpleRenderer simpleRenderer;
	
	public MasterRenderer() {
		simpleRenderer = new SimpleRenderer();
	}
	
	public void clear() {
		Display.clear();
	}
	
	public void update() {
		simpleRenderer.update();
		Display.update();
	}
	
	public void draw(Model model) {
		simpleRenderer.draw(model);
	}
}
