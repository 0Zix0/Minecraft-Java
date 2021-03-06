package com.mineclone.gfx.renderer;

import static org.lwjgl.opengl.GL11.GL_TRIANGLES;
import static org.lwjgl.opengl.GL11.GL_UNSIGNED_INT;
import static org.lwjgl.opengl.GL11.glDrawElements;

import java.util.Vector;

import org.lwjgl.glfw.GLFW;

import com.mineclone.entity.Quad;
import com.mineclone.gfx.Camera;
import com.mineclone.gfx.Display;
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
	
	public void update(Camera camera) {
		Display.recalculateProjection(camera);
		camera.update();
		
		shader.bind();
		shader.setTime((float)GLFW.glfwGetTime());
		
		shader.setViewMatrix(camera.getViewMatrix());
		shader.setProjMatrix(camera.getProjectionMatrix());
		
		quads.forEach((Quad quad) -> {
			prepare(quad);
			glDrawElements(GL_TRIANGLES, quad.getModel().getIndicesCount(), GL_UNSIGNED_INT, 0);
		});
		
		quads.clear();
		shader.unbind();
	}
	
	private void prepare(Quad quad) {
		quad.getModel().bind();
		shader.setModelMatrix(MathUtilities.createModelMatrix(quad));
	}
}
