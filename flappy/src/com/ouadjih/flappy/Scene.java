package com.ouadjih.flappy;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Scene extends JPanel{

	//VARIABLE
	private ImageIcon icoBandeFond;
	private Image imgBandeFond;
	
	private final int LARGEUR_BANDE_FOND = 140;
	
	//CONSTRUCTEUR
	public Scene() {
		super();
		this.icoBandeFond = 
				new ImageIcon(getClass().getResource("/image/bg.jpeg"));
		this.imgBandeFond = this.icoBandeFond.getImage();
	}
	// METHODES
	public void paintComponent(Graphics g) {
		g.drawImage(this.imgBandeFond, 0, 0,null);
		g.drawImage(this.imgBandeFond, this.LARGEUR_BANDE_FOND, 0,null);
	}
}
