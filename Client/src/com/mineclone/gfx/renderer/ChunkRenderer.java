package com.mineclone.gfx.renderer;

import java.util.Vector;

import com.mineclone.gfx.Camera;
import com.mineclone.gfx.shader.ChunkShader;
import com.mineclone.world.chunk.ChunkSection;

public class ChunkRenderer {

	private Vector<ChunkSection> chunks = new Vector<>();
	
	private ChunkShader shader;
	
	public ChunkRenderer() {
		shader = new ChunkShader();
	}
	
	public void draw(ChunkSection chunk) {
		chunks.add(chunk);
	}
	
	public void update(Camera camera) {
		shader.bind();
		shader.setViewMatrix(camera.getViewMatrix());
		shader.setProjMatrix(camera.getProjectionMatrix());
		
		chunks.forEach((ChunkSection chunk) -> {
			
		});
		
		chunks.clear();
		shader.unbind();
	}
}
