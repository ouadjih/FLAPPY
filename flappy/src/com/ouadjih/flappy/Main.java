package com.ouadjih.flappy;

import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.Display;
import org.lwjgl.LWJGLException;

public class Main implements Runnable{
	private int w = 720;
	private int h = 1280;
	private String title = "Flappy";
			
	private boolean running = false;
	private Thread thread;
	
	public void start() {
		running = true;
		thread = new Thread(this, "Display");
		thread.start();
	}
	public void run() {
		try {
			Display.setDisplayMode(new DisplayMode(h, w));
			Display.setTitle(title);
			Display.create();
		}catch(LWJGLException e) {
			e.printStackTrace();	
		}
		while(running) {
			Display.update();
			if(Display.isCloseRequested()) running = false;
		}
		}
	
	public static void main(String[] args) {
		new Main().start();

	}

}
