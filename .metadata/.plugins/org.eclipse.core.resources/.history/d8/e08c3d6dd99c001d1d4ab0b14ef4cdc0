package com.ouadjih.flappy.util;

import static org.lwjgl.opengl.GL20.*;

public class ShaderUtils {
	private ShaderUtils() {
		
	}
	public static int create(String vert, String frag) {
		int program = glCreateProgram();
		int vertID = glCreateShader(GL_VERTEX_SHADER);
		int fragID = glCreateShader(GL_FRAGMENT_SHADER);
		
		glShaderSource(vertID,vert);
		glShaderSource(fragID,frag);
		
		glCompileShader(vertID);
		glCompileShader(fragID);
		
		glAttachShader(program, vertID);
		glAttachShader(program, fragID);
		
		glLinkProgram(program);
		glValidateProgram(program);
		
		return program;
		
	}
}
