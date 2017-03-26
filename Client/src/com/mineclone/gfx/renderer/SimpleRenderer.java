package com.mineclone.gfx.renderer;

import static org.lwjgl.opengl.GL11.*;

import java.util.Vector;

import org.lwjgl.glfw.GLFW;

import com.mineclone.entity.Entity;
import com.mineclone.entity.Quad;
import com.mineclone.gfx.Model;
import com.mineclone.gfx.shader.SimpleShader;
import com.mineclone.util.MathUtilities;

public class SimpleRenderer {

	private Vector<Quad> quads = new Vector<>();
	
	private SimpleShader shader;
	
	public SimpleRenderer() {
		shader = new SimpleShader();
	}
	
	public void draw(Quad quad) {
		quads.add(quad);
	}
	
	public void update(Entity camera) {
		shader.bind();
		shader.setTime((float)GLFW.glfwGetTime());
		
		shader.setViewMatrix(MathUtilities.createViewMatrix(camera));
		
		quads.forEach((Quad quad) -> {
			prepare(quad);
			glDrawElements(GL_TRIANGLES, quad.getModel().getIndicesCount(), GL_UNSIGNED_INT, 0);
		});
		
		quads.clear();
	}
	
	private void prepare(Quad quad) {
		quad.getModel().bind();
		shader.setModelMatrix(MathUtilities.createModelMatrix(quad));
	}
}
