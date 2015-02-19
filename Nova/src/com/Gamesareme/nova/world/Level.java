/**
 * 
 */
package com.Gamesareme.nova.world;

import java.awt.image.BufferedImage;

import com.Gamesareme.nova.Controller;
import com.Gamesareme.nova.Game;
import com.Gamesareme.nova.entity.Player;
import com.Gamesareme.nova.gfx.Textures;
import com.Gamesareme.nova.libs.Identities;
import com.Gamesareme.nova.libs.Images;
import com.Gamesareme.nova.objects.Block;

/**
 * @author Oliver
 *
 */
public class Level {
	
	private BufferedImage image;
	private Controller controller = Game.getInstance().getController();
	private Textures tex = Game.getInstance().getTextureHandler();
	
	public Level(int levelNumber){
		switch(levelNumber){
			case 1:
				image = Images.level1;
				break;
			case 2:
				break;
			default:
				image = Images.level1;
				break;
		}
	}
	
	public void loadLevel(){
		int w = image.getWidth();
		int h =image.getWidth();
		for(int x = 0; x < w; x++){
			for(int y = 0; y < h; y++){
				int pixel = image.getRGB(x, y);
				
				int red = (pixel >> 16) & 0xff;
				int green = (pixel >> 8) & 0xff;
				int blue = (pixel) & 0xff;
				
				if(red == 255 && green == 255 && blue == 0){
					controller.addObject(new Player(x *32, y*32, Identities.PLAYER, tex));
				}else if(red == 255 && green == 255 && blue == 255){
					addBlock(x, y, Identities.BLOCK_GRASS, tex.blockGrass);
				}else if(red == 220 && green == 255 && blue == 255){
					addBlock(x, y, Identities.BLOCK_GRASS_STALK, tex.blockGrassStalk);
				}else{
					if(red == 255)
						addBlock(x, y, Identities.BLOCK_STONE, tex.blockStone);
					if(red == 220)
						addBlock(x, y, Identities.GRAVEL, tex.blockGravel);
					if(green == 220){
						addBlock(x, y, Identities.BLOCK_TREE_TRUNK, tex.blockTreeTrunk);
					}
					if(green == 200)
						addBlock(x, y, Identities.BLOCK_TREE_LEAVES, tex.blockTreeLeaves);
				}
			}
		}
	}
	
	private void addBlock(int x, int y, int id, BufferedImage tex){
		controller.addObject(new Block(x * 32, y *32, id, tex));
		//controller.addObject(new Block(x*(32*2),y*(32*2),id,tex));
		//Use the above code for HD images.
	}
}
