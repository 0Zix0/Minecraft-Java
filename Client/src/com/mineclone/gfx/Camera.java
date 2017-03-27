package com.mineclone.gfx;

import org.joml.Vector2f;
import org.joml.Vector3f;
import org.lwjgl.glfw.GLFW;

import com.mineclone.entity.Entity;
import com.mineclone.input.Input;

public class Camera extends Entity {

	private Vector2f lastMousePosition = new Vector2f(100, 100);

	public void input(float dt) {
		Vector3f change = new Vector3f();
		float speed = 2;

		if (Input.isKeyDown(GLFW.GLFW_KEY_W)) {
			change.x -= Math.cos(Math.toRadians(rotation.y + 90)) * speed;
			change.z -= Math.sin(Math.toRadians(rotation.y + 90)) * speed;
		}
		if (Input.isKeyDown(GLFW.GLFW_KEY_S)) {
			change.x += Math.cos(Math.toRadians(rotation.y + 90)) * speed;
			change.z += Math.sin(Math.toRadians(rotation.y + 90)) * speed;
		}
		if (Input.isKeyDown(GLFW.GLFW_KEY_A)) {
			change.x += -Math.cos(Math.toRadians(rotation.y)) * speed;
			change.z += -Math.sin(Math.toRadians(rotation.y)) * speed;
		}
		if (Input.isKeyDown(GLFW.GLFW_KEY_D)) {
			change.x += Math.cos(Math.toRadians(rotation.y)) * speed;
			change.z += Math.sin(Math.toRadians(rotation.y)) * speed;
		}

		position.add(change.mul(dt));

		mouseInput();
	}

	public void mouseInput() {
		Vector2f currentMousePos = new Vector2f(Input.getMousePos());
		Vector2f mouseChange = currentMousePos.sub(lastMousePosition);
		rotation.y += mouseChange.x;
		rotation.x += mouseChange.y;

		if(rotation.x > 80) {
			rotation.x = 80;
		} else if(rotation.x < -80) {
			rotation.x = -80;
		}
		
		if(rotation.y < 0) {
			rotation.y = 360;
		} else if(rotation.y > 360) {
			rotation.y = 0;
		}
		
		float centerX = Display.getWidth() / 2;
		float centerY = Display.getHeight() / 2;
		
		//Display.setCursorPos(centerX, centerY);
		
		lastMousePosition = Input.getMousePos();
	}
}
