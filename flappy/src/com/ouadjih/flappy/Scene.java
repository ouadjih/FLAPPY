package com.ouadjih.flappy;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.ouadjih.objects.Tuyau;

public class Scene extends JPanel{

	//VARIABLE
	private ImageIcon icoBandeFond;
	private Image imgBandeFond;
	public int xFond;
	
	public Tuyau tuyauHaut1;
	public Tuyau tuyauBat1;
	public Tuyau tuyauHaut2;
	public Tuyau tuyauBat2;
	public Tuyau tuyauHaut3;
	public Tuyau tuyauBat3;
	
	private final int LARGEUR_BANDE_FOND = 140;
	private final int Distance_Tuyau = 300;
	private final int ECART_Tuyau = 150;
	
	
	//CONSTRUCTEUR
	public Scene() {
		super();
		this.icoBandeFond = 
				new ImageIcon(getClass().getResource("/image/bg.jpeg"));
		this.imgBandeFond = this.icoBandeFond.getImage();
		this.xFond = 0;
		
		Thread chronoEcran = new Thread(new Chrono());
		chronoEcran.start();
	}
	
	
	// METHODES
	private void deplacementFond(Graphics g) {
		 if(this.xFond == -this.LARGEUR_BANDE_FOND) {
			 this.xFond=0;
		 }
		 g.drawImage(this.imgBandeFond, this.xFond, 0,null);
		 g.drawImage(this.imgBandeFond, this.xFond+this.LARGEUR_BANDE_FOND, 0,null);
		 g.drawImage(this.imgBandeFond, this.xFond+this.LARGEUR_BANDE_FOND*2, 0,null);
		 g.drawImage(this.imgBandeFond, this.xFond+this.LARGEUR_BANDE_FOND*3, 0,null);
		
		
	}
	public void paintComponent(Graphics g) {
		this.deplacementFond(g);
	}
}
