package com.ouadjih.objects;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Tuyau {
	
	//VARIABLE
	private int largeur;
	private int hauteur;
	private int x,y;
	private String strImage;
	private ImageIcon icoTuyau;
	private Image imgTuyau;
	
	//CONSTRUCTOR
	public Tuyau(int x, int y, String strImage){
		this.largeur = 50;
		this.hauteur = 300;
		this.x = x;
		this.y = y;
		this.strImage = strImage;
		
		this.icoTuyau = new ImageIcon(getClass().getResource(strImage));
		this.imgTuyau = this.icoTuyau.getImage();
		
	}
	//SETTERS & GETTERS
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

	public int getLargeur() {
		return largeur;
	}

	public int getHauteur() {
		return hauteur;
	}

	public Image getImgTuyau() {
		return imgTuyau;
	}
	
}
