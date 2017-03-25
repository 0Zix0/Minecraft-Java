package com.mineclone.gfx.shader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL20.*;

public class ShaderLoader {

	public static int loadShader(String vertexFile, String fragmentFile) {
		String vertexSource = getSource(vertexFile);
		String fragmentSource = getSource(fragmentFile);
		
		int vertexID = compileShader(vertexSource, GL_VERTEX_SHADER);
		int fragmentID = compileShader(fragmentSource, GL_FRAGMENT_SHADER);
		
		int programID = createProgram(vertexID, fragmentID);

		glDeleteShader(vertexID);
		glDeleteShader(fragmentID);
		
		return programID;
	}
	
	private static int compileShader(String source, int type) {
		int id = glCreateShader(type);
		
		glShaderSource(id, source);
		glCompileShader(id);
		
		if(glGetShaderi(id, GL_COMPILE_STATUS) == GL_FALSE) {
			System.err.println(glGetShaderInfoLog(id));
			String name = "";
			if(type == GL_VERTEX_SHADER) name = "vertex";
			if(type == GL_FRAGMENT_SHADER) name = "fragment";
			throw new RuntimeException("Failed to compile " + name + " shader.");
		}
		
		return id;
	}
	
	private static int createProgram(int vertexID, int fragmentID) {
		int id = glCreateProgram();
		
		glAttachShader(id, vertexID);
		glAttachShader(id, fragmentID);
		
		glLinkProgram(id);
		
		return id;
	}

	private static String getSource(String file) {
		StringBuilder result = new StringBuilder();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String buffer = "";
			while ((buffer = reader.readLine()) != null) {
				result.append(buffer + "\n");
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Error while opening file: " + file);
		}
		return result.toString();
	}
}
