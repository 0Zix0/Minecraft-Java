package com.mineclone.gfx.renderer;

import static org.lwjgl.opengl.GL11.GL_TRIANGLES;
import static org.lwjgl.opengl.GL11.GL_UNSIGNED_INT;
import static org.lwjgl.opengl.GL11.glDrawElements;

import java.util.Vector;

import org.lwjgl.glfw.GLFW;

import com.mineclone.entity.Quad;
import com.mineclone.gfx.Model;
import com.mineclone.gfx.shader.SimpleShader;

public class SimpleRenderer {

	private Vector<Quad> quads = new Vector<>();
	
	private SimpleShader shader;
	
	public SimpleRenderer() {
		shader = new SimpleShader();
	}
	
	public void draw(Quad quad) {
		quads.add(quad);
	}
	
	public void update() {
		shader.bind();
		shader.setTime((float)GLFW.glfwGetTime());
		quads.forEach((Quad quad) -> {
			prepare(quad);
			glDrawElements(GL_TRIANGLES, quad.getModel().getIndicesCount(), GL_UNSIGNED_INT, 0);
		});
		
		quads.clear();
	}
	
	private void prepare(Quad quad) {
		quad.getModel().bind();
		shader.setPosition(quad.getPosition());
	}
}
