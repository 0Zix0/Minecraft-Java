package com.mineclone.gfx;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL13.*;
import static org.lwjgl.system.MemoryUtil.NULL;

import org.lwjgl.glfw.GLFWCursorPosCallback;
import org.lwjgl.glfw.GLFWFramebufferSizeCallback;
import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.glfw.GLFWMouseButtonCallback;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;

public class Display {

	private static int width;
	private static int height;
	private static String title;
	
	private static long window = NULL;
	
	private static GLFWFramebufferSizeCallback framebufferSizeCallback;
	
	public static boolean initialize(int width, int height, String title) {
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
		
		glfwSetFramebufferSizeCallback(window, framebufferSizeCallback = new GLFWFramebufferSizeCallback() {
			public void invoke(long window, int width, int height) {
				Display.width = width;
				Display.height = height;
				glViewport(0, 0, width, height);
			}
		});
		
		glfwMakeContextCurrent(window);
		glfwShowWindow(window);
		
		GL.createCapabilities();
		
		glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
		
		return true;
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
}
