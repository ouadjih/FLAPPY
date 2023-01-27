package com.ouadjih.personnage;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.ouadjih.flappy.Main;

public class Clavier implements KeyListener{

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			Main.scene.flappybird.up();
		}
		
		/*if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			Main.scene.flappybird.down();
		}*/
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
