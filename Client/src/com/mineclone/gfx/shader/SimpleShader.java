package com.mineclone.gfx.shader;

public class SimpleShader extends ShaderProgram {

	public SimpleShader() {
		super("res/shaders/simple.vert", "res/shaders/simple.frag");
		bindAttributes();
	}

	public void bindAttributes() {
		bindAttribute(0, "inVertexPosition");
	}
}
