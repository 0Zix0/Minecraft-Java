package com.mineclone.gfx.renderer;

import com.mineclone.entity.Entity;
import com.mineclone.entity.Quad;
import com.mineclone.gfx.Display;

public class MasterRenderer {

	private SimpleRenderer simpleRenderer;
	
	public MasterRenderer() {
		simpleRenderer = new SimpleRenderer();
	}
	
	public void clear() {
		Display.clear();
	}
	
	public void update(Entity camera) {
		simpleRenderer.update(camera);
		Display.update();
	}
	
	public void draw(Quad model) {
		simpleRenderer.draw(model);
	}
}
