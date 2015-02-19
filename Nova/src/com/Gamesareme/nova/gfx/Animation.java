/**
 * 
 */
package com.Gamesareme.nova.gfx;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * @author Oliver
 *
 */
public class Animation {
	
	private int count = 0;
	private int index = 0;
	private int speed;
	private int frames;
	
	private BufferedImage currentIm;
	private BufferedImage anim[];
	
	public Animation(int speed, BufferedImage anime[]){
		this.speed = speed;
		this.anim = anime;
		frames = anime.length;
	}
	
	public void runAnimation(){
		index++;
		if(index > speed){
			index = 0;
			nextFrame();
		}
	}

	/**
	 * 
	 */
	public void nextFrame() {
		// TODO Auto-generated method stub
		for(int k = 0; k < frames; k++){
			if(count == k){
				currentIm = anim[k];
			}
		}
		count++;
		if(count > frames){
			count = 0;
		}
	}
	
	public void drawAnimation(Graphics g, float x, float y){
		g.drawImage(currentIm, (int)x, (int)y, null);
	}

}
