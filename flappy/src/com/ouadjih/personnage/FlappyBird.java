package com.ouadjih.personnage;

import java.awt.Image;

import javax.swing.ImageIcon;

public class FlappyBird {
	
	//VARIABLES
	private int largeur;
	private int hauteur;
	private int x,y;
	private int dy;
	private String strImage;
	private ImageIcon icoBird;
	private Image imgBird;
	
	//CONSTRUCTOR
	public FlappyBird(int x, int y,String strImage) {
		this.largeur = 34;
		this.hauteur = 24;
		this.x = x;
		this.y = y;
		this.strImage = strImage;
		this.icoBird = new ImageIcon(getClass().getResource(this.strImage));
		this.imgBird = this.icoBird.getImage();
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
		this.dy = 50;
		this.y = this.y-this.dy;
	}
	public void down() {
		this.dy = 80;
		this.y = this.y+this.dy;
	}

	public void setStrImage(String strImage) {
		this.strImage = strImage;
	}
}
