package com.ouadjih.flappy;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.ouadjih.objects.Tuyau;
import com.ouadjih.personnage.Clavier;
import com.ouadjih.personnage.FlappyBird;

public class Scene extends JPanel{

	//VARIABLE
	private ImageIcon icoBandeFond;
	private Image imgBandeFond;
	public int xFond;
	
	public Tuyau tuyauHaut1;
	public Tuyau tuyauBas1;
	public Tuyau tuyauHaut2;
	public Tuyau tuyauBas2;
	public Tuyau tuyauHaut3;
	public Tuyau tuyauBas3;
	
	public FlappyBird flappybird ;
	private final int LARGEUR_BANDE_FOND = 140;
	private final int DISTANCE_Tuyau = 300;
	private final int ECART_Tuyau = 150;
	
	private int xTuyau;
	
	private Random hasar;
	
	private int score;
	private Font police;
	
	
	//CONSTRUCTEUR
	public Scene() {
		super();
		this.icoBandeFond = 
				new ImageIcon(getClass().getResource("/image/bg.jpeg"));
		this.imgBandeFond = this.icoBandeFond.getImage();
		this.xFond = 0;
		this.xTuyau = 100;

		this.tuyauHaut1 = new Tuyau(this.xTuyau,-150,"/image/tuyauHaut.png");
		this.tuyauBas1 =  new Tuyau(this.xTuyau,250,"/image/tuyauBas.png");
		this.tuyauHaut2 =  new Tuyau(this.xTuyau+this.DISTANCE_Tuyau,-150,"/image/tuyauHaut.png");
		this.tuyauBas2 = new Tuyau(this.xTuyau+this.DISTANCE_Tuyau,250,"/image/tuyauBas.png");
		this.tuyauHaut3 = new Tuyau(this.xTuyau+this.DISTANCE_Tuyau*2,-150,"/image/tuyauHaut.png");
		this.tuyauBas3 = new Tuyau(this.xTuyau+this.DISTANCE_Tuyau*2,250,"/image/tuyauBas.png");;
		
		this.flappybird = new FlappyBird(100, 150, "/image/cr6.png");
		 hasar = new Random();
		
		 this.setFocusable(true);
		 this.requestFocusInWindow();
		 this.addKeyListener(new Clavier());
		 
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
	private void deplacementTuyau(Graphics g) {
		
		// tuyau1
	    this.tuyauHaut1.setX(this.tuyauHaut1.getX() - 1);
		this.tuyauBas1.setX(this.tuyauHaut1.getX());
		
		if(this.tuyauHaut1.getX() == -100){
	    	this.tuyauHaut1.setX(this.tuyauHaut3.getX() + this.DISTANCE_Tuyau);
	    	this.tuyauHaut1.setY(-100 - 10 * this.hasar.nextInt(18));
	    	this.tuyauBas1.setY(this.tuyauHaut1.getY() + this.tuyauHaut1.getHauteur() + this.ECART_Tuyau);
	    }		
		g.drawImage(this.tuyauHaut1.getImgTuyau(), this.tuyauHaut1.getX(), this.tuyauHaut1.getY(), null);
		g.drawImage(this.tuyauBas1.getImgTuyau(), this.tuyauBas1.getX(), this.tuyauBas1.getY(), null);
		
		// tuyau2
		this.tuyauHaut2.setX(this.tuyauHaut2.getX() - 1);
		this.tuyauBas2.setX(this.tuyauHaut2.getX());
		
		if(this.tuyauHaut2.getX() == -100){
			this.tuyauHaut2.setX(this.tuyauHaut1.getX() + this.DISTANCE_Tuyau);
			this.tuyauHaut2.setY(-100 - 10 * this.hasar.nextInt(18));
	    	this.tuyauBas2.setY(this.tuyauHaut2.getY() + this.tuyauHaut2.getHauteur() + this.ECART_Tuyau);
		}		
		g.drawImage(this.tuyauHaut2.getImgTuyau(), this.tuyauHaut2.getX(), this.tuyauHaut2.getY(), null);
		g.drawImage(this.tuyauBas2.getImgTuyau(), this.tuyauBas2.getX(), this.tuyauBas2.getY(), null);
		
		// tuyau3
		this.tuyauHaut3.setX(this.tuyauHaut3.getX() - 1);
		this.tuyauBas3.setX(this.tuyauHaut3.getX());
		
		if(this.tuyauHaut3.getX() == -100){
			this.tuyauHaut3.setX(this.tuyauHaut2.getX() + this.DISTANCE_Tuyau);
			this.tuyauHaut3.setY(-100 - 10 * this.hasar.nextInt(18));
	    	this.tuyauBas3.setY(this.tuyauHaut3.getY() + this.tuyauHaut3.getHauteur() + this.ECART_Tuyau);
		}		
		g.drawImage(this.tuyauHaut3.getImgTuyau(), this.tuyauHaut3.getX(), this.tuyauHaut3.getY(), null);
		g.drawImage(this.tuyauBas3.getImgTuyau(), this.tuyauBas3.getX(), this.tuyauBas3.getY(), null);
			
		
		
		
	}
	

	
	
	public void paintComponent(Graphics g) {
		this.deplacementFond(g);
		this.deplacementTuyau(g);
		this.flappybird.setY(this.flappybird.getY()-1);
		g.drawImage(this.flappybird.getImgBird(), this.flappybird.getX(), this.flappybird.getY(),null);

		
	}
}