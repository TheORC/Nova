/**
 * This is my games camera class.
 * This is where I tell the camera where to move.
 */
package com.Gamesareme.nova;

import com.Gamesareme.nova.core.CoreObject;
import com.Gamesareme.nova.entity.Player;
import com.Gamesareme.nova.libs.Identities;

/**
 * @author Oliver
 *
 */
public class Camera {
	
	private float x, y;  //The cameras x and y location.
	private Player player;  //This is my 
	
	
	public Camera(float x, float y){  //This constructor sets the cameras x, y location.
		this.x =x;  //set x location.
		this.y = y;  //set y location.
		for(CoreObject obj : Game.getInstance().getController().getObjects()){  //Loop through all the objects in the game.
			if(obj.getId() == Identities.PLAYER){  //See if the objects id is the same as the player's id.
				player = (Player)obj;  //Set the player to the object with the players id.
			}
		}
	}
	
	public void tick(){  //This runes 60 times a second.
		x += ((-player.getX() + Game.WIDTH/2) - x) * 0.095f;  //Update the camera to the players location.
	}

	/**
	 * @return the cameras x location.
	 */
	public float getX() {
		return x;
	}

	/**
	 * @return the cameras y location.
	 */
	public float getY() {
		return y;
	}
}
