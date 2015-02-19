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
	
	private float x, y;//The cameras x and y location.
	private Player player;
	
	
	public Camera(float x, float y){
		this.x =x;
		this.y = y;
		for(CoreObject obj : Game.getInstance().getController().getObjects()){
			if(obj.getId() == Identities.PLAYER){
				player = (Player)obj;
			}
		}
	}
	
	public void tick(){
		x += ((-player.getX() + Game.WIDTH/2) - x) * 0.095f;
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
}
