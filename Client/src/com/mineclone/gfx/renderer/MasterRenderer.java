package com.mineclone.gfx.renderer;

import com.mineclone.entity.Quad;
import com.mineclone.gfx.Camera;
import com.mineclone.gfx.Display;
import com.mineclone.world.chunk.ChunkSection;

public class MasterRenderer {

	private SimpleRenderer simpleRenderer;
	private ChunkRenderer chunkRenderer;
	
	public MasterRenderer() {
		simpleRenderer = new SimpleRenderer();
		chunkRenderer = new ChunkRenderer();
	}
	
	public void clear() {
		Display.clear();
	}
	
	public void update(Camera camera) {
		simpleRenderer.update(camera);
		chunkRenderer.update(camera);
		Display.update();
	}
	
	public void draw(Quad model) {
		simpleRenderer.draw(model);
	}
	
	public void draw(ChunkSection chunk) {
		chunkRenderer.draw(chunk);
	}
}
