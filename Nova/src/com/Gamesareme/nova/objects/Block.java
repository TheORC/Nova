/**
 * 
 */
package com.Gamesareme.nova.objects;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.Gamesareme.nova.core.CoreObject;

/**
 * @author Oliver
 *
 */
public class Block extends CoreObject{

	/**
	 * @param x
	 * @param y
	 * @param id
	 * @param tex
	 */
	public Block(float x, float y, int id, BufferedImage image) {
		super(x, y, id, image);
		// TODO Auto-generated constructor stub
		this.image = image;
		this.setSize(32, 32);
	}

	/* (non-Javadoc)
	 * @see com.blp.frisky.core.CoreObject#tick()
	 */
	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.blp.frisky.core.CoreObject#render(java.awt.Graphics)
	 */
	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(image, (int)x, (int)y, null);
	}
}
