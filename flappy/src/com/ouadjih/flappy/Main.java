package com.ouadjih.flappy;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL30.*;


import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.ContextAttribs;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.PixelFormat;

import com.ouadjih.flappy.util.*;


public class Main implements Runnable{
	private int w = 1280;
	private int h = 720;
	
	private String title = "Flappy";
			
	private boolean running = false;
	private Thread thread;


	public void start() {
		running = true;
		thread = new Thread(this, "Display");
		thread.start();
	}
	private void init() {
	 String version	= glGetString(GL_VERSION);
	 System.out.println("OpenGl " + version);
	 
	 glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
	 
	}
	public void run() {
		try {
			Display.setDisplayMode(new DisplayMode(w, h));
			Display.setTitle(title);
			ContextAttribs context = new ContextAttribs(3, 3);
			Display.create(new PixelFormat(),null, context.withProfileCore(true));
			
		}catch(LWJGLException e) {
			e.printStackTrace();
			System.out.println("this is create display error");
		}
	
		init();
		int vao = glGenVertexArrays();
		glBindVertexArray(vao);
		
		int shader =  ShaderUtils.load("shaders/shader.vert","shaders/shader.frag");
		glUseProgram(shader);
		while(running) {
			render();
			Display.update();
			if(Display.isCloseRequested()) running = false;
		}
		Display.destroy();
		}
	
	private void render() {
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
		glDrawArrays(GL_TRIANGLES,0,3);
	}
	public static void main(String[] args) {
		new Main().start();

	}

}
