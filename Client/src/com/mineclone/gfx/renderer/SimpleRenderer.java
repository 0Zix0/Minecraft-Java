package com.mineclone.gfx.renderer;

import static org.lwjgl.opengl.GL11.GL_TRIANGLES;
import static org.lwjgl.opengl.GL11.GL_UNSIGNED_INT;
import static org.lwjgl.opengl.GL11.glDrawElements;

import java.util.Vector;

import org.lwjgl.glfw.GLFW;

import com.mineclone.gfx.Model;
import com.mineclone.gfx.shader.SimpleShader;

public class SimpleRenderer {

	private Vector<Model> models = new Vector<>();
	
	private SimpleShader shader;
	
	public SimpleRenderer() {
		shader = new SimpleShader();
	}
	
	public void draw(Model model) {
		models.add(model);
	}
	
	public void update() {
		shader.bind();
		shader.setTime((float)GLFW.glfwGetTime());
		models.forEach((Model model) -> {
			prepare(model);
			glDrawElements(GL_TRIANGLES, model.getIndicesCount(), GL_UNSIGNED_INT, 0);
		});
		
		models.clear();
	}
	
	private void prepare(Model model) {
		model.bind();
	}
}
