/**
 * 
 */
package com.Gamesareme.nova.entity;

import java.awt.Graphics;
import java.util.ArrayList;

import com.Gamesareme.nova.Game;
import com.Gamesareme.nova.core.CoreObject;
import com.Gamesareme.nova.gfx.Animation;
import com.Gamesareme.nova.gfx.Textures;
import com.Gamesareme.nova.libs.Identities;
import com.Gamesareme.nova.objects.Block;
import com.sun.javafx.scene.traversal.Direction;

/**
 * @author Oliver
 *
 */
public class Player extends CoreObject{
	
	private static ArrayList<CoreObject> gameObjects = Game.getInstance().getController().getObjects();
	private float gravity = 0.98f;  //This is an float to tell the player how much gravity there is.
	private boolean falling = true;  //This boolean is used to see if the player is falling.
	private boolean jumping = false;  //This boolean is used to see if the player is jumping.
	private boolean moving = false;
	
	private Animation animeRight;
	private Animation animeLeft;
	
	private Direction direction = Direction.RIGHT;
	/**
	 * @param x
	 * @param y
	 * @param id
	 */
	public Player(float x, float y, int id, Textures tex) {
		super(x, y, id, tex);
		this.setSize(32, 32);
		animeRight = new Animation(6, tex.playerRight);
		animeLeft = new Animation(6, tex.playerLeft);
	}

	/* (non-Javadoc)
	 * @see com.blp.frisky.core.CoreObject#tick()
	 */
	@Override
	public void tick() {
		// TODO Auto-generated method stub
		x += velx;
		y += vely;
		fall();
		checkCollision();
		if(moving){
			if(direction == Direction.RIGHT){
				animeRight.runAnimation();
			}else if(direction == Direction.LEFT){
				animeLeft.runAnimation();
			}
		}
	}

	/* (non-Javadoc)
	 * @see com.blp.frisky.core.CoreObject#render(java.awt.Graphics)
	 */
	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		if(!moving){
			if(direction == Direction.RIGHT)
				g.drawImage(tex.playerIdleRight, (int)x, (int)y, null);
			else if(direction == Direction.LEFT)
				g.drawImage(tex.playerIdleLeft, (int)x, (int)y, null);
		}else{
			if(direction == Direction.RIGHT)
				animeRight.drawAnimation(g, x, y);
			else if(direction == Direction.LEFT)
				animeLeft.drawAnimation(g, x, y);
		}
		
		
	}
	
	private void checkCollision(){
		for(CoreObject obj : gameObjects){
			if(obj instanceof Block){
				if(!(obj.getId() == Identities.BLOCK_GRASS_STALK || obj.getId() == Identities.BLOCK_TREE_TRUNK || obj.getId() == Identities.BLOCK_TREE_LEAVES)){
					if(getBottomBounds().intersects(obj.getTopBounds())){
						vely = 0;
						y = obj.getY() - height;
						jumping = false;
					}
					if(getTopBounds().intersects(obj.getBottomBounds())){
						vely = vely + 5;
						y = obj.getY() + obj.getHeight();
					}
					if(getRightBounds().intersects(obj.getLeftBounds())){
						velx = 0;
						x = obj.getX() - width;
					}
					if(getLeftBounds().intersects(obj.getRightBounds())){
						velx = 0;
						x = obj.getX() + obj.getWidth();
					}
				}
			}
		}
	}
	
	public void fall(){
		if(falling)
			vely += gravity;
	}

	/**
	 * @return the jumping
	 */
	public boolean isJumping() {
		return jumping;
	}

	/**
	 * @param jumping the jumping to set
	 */
	public void setJumping(boolean jumping) {
		this.jumping = jumping;
	}

	/**
	 * @return the moving
	 */
	public boolean isMoving() {
		return moving;
	}

	/**
	 * @param moving the moving to set
	 */
	public void setMoving(boolean moving) {
		this.moving = moving;
	}

	/**
	 * @return the direction
	 */
	public Direction getDirection() {
		return direction;
	}

	/**
	 * @param direction the direction to set
	 */
	public void setDirection(Direction direction) {
		this.direction = direction;
	}

}
