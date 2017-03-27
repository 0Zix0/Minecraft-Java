package com.mineclone.input;

import org.joml.Vector2f;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWCursorPosCallback;
import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.glfw.GLFWMouseButtonCallback;

public class Input {
	
	public static boolean isKeyDown(int keycode) {
		return Keyboard.keys[keycode];
	}
	
	public static boolean isMouseDown(int button) {
		return MouseButton.buttons[button];
	}
	
	public static Vector2f getMousePos() {
		return new Vector2f((float) MousePosition.mouseX, (float) MousePosition.mouseY);
	}
	
	public static class MousePosition extends GLFWCursorPosCallback {
		
		public static double mouseX = -1;
		public static double mouseY = -1;
		
		public void invoke(long window, double xpos, double ypos) {
			mouseX = xpos;
			mouseY = ypos;
		}	
	}
	
	public static class MouseButton extends GLFWMouseButtonCallback {

		public static boolean[] buttons = new boolean[64];
		
		public void invoke(long window, int button, int action, int mods) {
			buttons[button] = action != GLFW.GLFW_RELEASE;
		}		
	}
	
	public static class Keyboard extends GLFWKeyCallback {

		public static boolean[] keys = new boolean[65536];
		
		public void invoke(long window, int key, int scancode, int action, int mods) {
			keys[key] = action != GLFW.GLFW_RELEASE;
		}
	}
}
