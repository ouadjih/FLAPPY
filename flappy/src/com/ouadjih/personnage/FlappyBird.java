package com.ouadjih.personnage;

import java.awt.Image;

import javax.swing.ImageIcon;

import com.ouadjih.objects.Tuyau;

public class FlappyBird implements Runnable{
	
	//VARIABLES
	private int largeur;
	private int hauteur;
	private int x,y;
	private int dy;
	private String strImage;
	private ImageIcon icoBird;
	private Image imgBird;
	
	private final int PAUSE = 7;
	//CONSTRUCTOR
	public FlappyBird(int x, int y,String strImage) {
		this.largeur = 34;
		this.hauteur = 24;
		this.x = x;
		this.y = y;
		this.strImage = strImage;
		this.icoBird = new ImageIcon(getClass().getResource(this.strImage));
		this.imgBird = this.icoBird.getImage();
		Thread chronoAiles = new Thread(this);
		chronoAiles.start();
	}

	
	
	//GETTERS
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Image getImgBird() {
		return imgBird;
	}

	public void setImgBird(Image imgBird) {
		this.imgBird = imgBird;
	}

	public int getLargeur() {
		return largeur;
	}

	public int getHauteur() {
		return hauteur;
	}
	
	public void up() {
		this.dy = 35;
	}
	private void batDesAiles(int dy) {
		if (dy > 10) {
			this.icoBird = new ImageIcon(getClass().getResource("/image/cr6.png"));
			this.imgBird = this.icoBird.getImage();
			this.y = this.y - 3;
			}else if(dy > 5){this.y = this.y-2;}
			 else if ( dy > 1 ) { this.y = this.y-1;}
		if ( dy == 1 ) { this.icoBird = new ImageIcon(getClass().getResource("/image/cr6.png"));
		this.imgBird = this.icoBird.getImage();}
			
	}
	
	public boolean collision(Tuyau tuyau){
		if(tuyau.getY() < 50){ // d�tecte un tuyau haut
			if(this.y <= tuyau.getY() + tuyau.getHauteur() && this.x + this.largeur >= tuyau.getX() && 
					this.x <= tuyau.getX() + tuyau.getLargeur()){return true;}
			else{return false;}
		}else // sinon test avec tuyau bas
			if(this.y + this.hauteur >= tuyau.getY() && this.x + this.largeur >= tuyau.getX() && 
			this.x <= tuyau.getX() + tuyau.getLargeur()){return true;}
		     else{return false;}
	}
	
	/*public void down() {
		this.dy = 80;
		this.y = this.y+this.dy;
	}*/

	public void setStrImage(String strImage) {
		this.strImage = strImage;
	}



	@Override
	public void run() {
		while(true) {
			this.batDesAiles(dy);
			this.dy--;
			try {
				Thread.sleep(PAUSE);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}
