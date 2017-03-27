package com.mineclone.gfx;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.NULL;

import org.lwjgl.glfw.GLFWCursorPosCallback;
import org.lwjgl.glfw.GLFWFramebufferSizeCallback;
import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.glfw.GLFWMouseButtonCallback;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;

import com.mineclone.input.Input;

public class Display {

	private static int width;
	private static int height;
	private static String title;
	
	private static long window = NULL;
	
	private static GLFWFramebufferSizeCallback framebufferSizeCallback;
	

	private static GLFWKeyCallback keyCallback;
	private static GLFWMouseButtonCallback mouseButtonCallback;
	private static GLFWCursorPosCallback cursorPosCallback;
	
	public static boolean init(int width, int height, String title) {
		if(window != NULL) return false;
		if(glfwInit() != GL_TRUE) {
			return false; //TODO: Set some error code.
		}
		glfwWindowHint(GLFW_RESIZABLE, GL_TRUE);
		
		window = glfwCreateWindow(width, height, title, NULL, NULL);
		if(window == NULL) {
			return false; //TODO: Set some error code.
		}
		GLFWVidMode vidMode = glfwGetVideoMode(glfwGetPrimaryMonitor());
		glfwSetWindowPos(window, (vidMode.width() - width) / 2, (vidMode.height() - height) / 2);
		
		glfwSetKeyCallback(window, keyCallback = new Input.Keyboard());
		glfwSetMouseButtonCallback(window, mouseButtonCallback = new Input.MouseButton());
		glfwSetCursorPosCallback(window, cursorPosCallback = new Input.MousePosition());
		//glfwSetFramebufferSizeCallback(window, framebufferSizeCallback = new GLFWFramebufferSizeCallback() {
		//	public void invoke(long window, int width, int height) {
		//		Display.width = width;
		//		Display.height = height;
		//		glViewport(0, 0, width, height);
		//	}
		//});
		
		glfwSetInputMode(window, GLFW_CURSOR, GLFW_CURSOR_DISABLED);
		glfwMakeContextCurrent(window);
		glfwShowWindow(window);
		
		GL.createCapabilities();
		
		glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
		
		glEnable(GL_DEPTH_TEST);
		
		Display.width = width;
		Display.height = height;
		
		return true;
	}
	
	public static void setCursorPos(double x, double y) {
		glfwSetCursorPos(window, x, y);
	}
	
	public static boolean shouldClose() {
		return glfwWindowShouldClose(window) == GL_TRUE;
	}
	
	public static void clear() {
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
	}
	
	public static void update() {
		glfwSwapBuffers(window);
		glfwPollEvents();
	}
	
	public static int getWidth() {
		return width;
	}
	
	public static int getHeight() {
		return height;
	}
}
