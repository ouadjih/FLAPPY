package com.ouadjih.flappy;

public class Chrono implements Runnable{
	
	private final int Pause = 3;
	public void run() {
		while(true) {
			Main.scene.xFond--;
			Main.scene.repaint();
			try {
				Thread.sleep(this.Pause);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
