/**
 * 
 */
package com.Gamesareme.nova.core;

import java.awt.Graphics;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.Gamesareme.nova.gfx.Textures;

/**
 * @author Oliver
 *
 */
public abstract class CoreObject {

	protected float x, y, velx, vely;
	protected int id;
	
	protected int width;
	protected int height;
	
	protected Textures tex;
	
	protected BufferedImage image;
	
	//Hello I was here!
	
	public CoreObject(float x, float y, int id, Textures tex){
		this.x = x;
		this.y = y;
		this.id = id;
		this.tex = tex;
	}
	
	public CoreObject(float x, float y, int id, BufferedImage image){
		this.x = x;
		this.y = y;
		this.id = id;
		this.image = image;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	
	
	public Rectangle getTopBounds(){
		return new Rectangle((int)x, (int)y, width, 12);
	}
	
	public Rectangle getBottomBounds(){
		return new Rectangle((int)x, (int)y + (height - 6), 30, 12);
	}
	
	public Rectangle getRightBounds(){
		return new Rectangle((int)x + (width - 6), (int)y, 6, height);
	}
	
	public Rectangle getLeftBounds(){
		return new Rectangle((int)x , (int)y, 6, height);
	}

	/**
	 * @return the x
	 */
	public float getX() {
		return x;
	}

	/**
	 * @return the y
	 */
	public float getY() {
		return y;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(float x) {
		this.x = x;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(float y) {
		this.y = y;
	}

	/**
	 * @param velx the velx to set
	 */
	public void setVelx(float velx) {
		this.velx = velx;
	}

	/**
	 * @param vely the vely to set
	 */
	public void setVely(float vely) {
		this.vely = vely;
	}

	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}
	
	public void setSize(int width, int height){
		this.width = width;
		this.height = height;
	}
	

}
