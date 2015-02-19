/**
 * 
 */
package com.Gamesareme.nova.utils;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.Gamesareme.nova.input.MouseInput;

/**
 * @author Oliver
 *
 */
@SuppressWarnings("serial")
public class Button extends Rectangle {
	
	private String text;

	/**
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public Button(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}
	
	public Button setText(String text){
		this.text = text;
		return this;
	}
	
	public void drawButton(Graphics g, int offset){
		int xx = x + offset;
		int yy = y + 40;
		if(MouseInput.MOUSE.intersects(this) && MouseInput.MOUSE !=null){
			g.setColor(Color.RED);
		}else {
			g.setColor(Color.YELLOW);
		}
		if(!MouseInput.presses && MouseInput.MOUSE.intersects(this)){
			g.drawRect(x, y, width, height);
		}else if(MouseInput.presses && MouseInput.MOUSE.intersects(this)){
			g.fillRect(x, y, width, height);
		}else{
			g.drawRect(x, y, width, height);
		}
		g.setColor(Color.WHITE);
		g.drawString(text, xx, yy);
	}

}
