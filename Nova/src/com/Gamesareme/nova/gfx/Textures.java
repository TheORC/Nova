/**
 * 
 */
package com.Gamesareme.nova.gfx;

import java.awt.image.BufferedImage;

import com.Gamesareme.nova.libs.Images;
import com.Gamesareme.nova.utils.SpriteSheet;

/**
 * @author Oliver
 *
 */
public class Textures {
	
	private SpriteSheet sheetTest;
	private SpriteSheet playerSheet;
	
	//Game Objects
	public BufferedImage blockGrass;
	public BufferedImage blockStone;
	public BufferedImage blockGravel;
	public BufferedImage blockGrassStalk;
	public BufferedImage blockTreeTrunk;
	public BufferedImage blockTreeLeaves;
	
	public BufferedImage playerIdleRight;
	public BufferedImage playerIdleLeft;
	public BufferedImage playerRight[] = new BufferedImage[4];
	public BufferedImage playerLeft[] = new BufferedImage[4];
	

	public Textures(){
		sheetTest = new SpriteSheet(Images.spritesheetBlock,32);
		playerSheet = new SpriteSheet(Images.spritesheetChar, 32, 32);
		
		initTextures();
	}
	
	private void initTextures(){
		blockStone = sheetTest.getSprite(1, 1);
		blockGrass = sheetTest.getSprite(2, 1);
		blockGravel = sheetTest.getSprite(3, 1);
		blockGrassStalk = sheetTest.getSprite(4, 1);
		blockTreeTrunk = sheetTest.getSprite(5, 1);
		blockTreeLeaves = sheetTest.getSprite(6, 1);
		
		playerIdleRight = playerSheet.getSprite(4, 3);
		playerIdleLeft = playerSheet.getSprite(1, 2);
		
		playerRight[0] = playerSheet.getSprite(1, 3);
		playerRight[1] = playerSheet.getSprite(2, 3);
		playerRight[2] = playerSheet.getSprite(3, 3);
		playerRight[3] = playerSheet.getSprite(4, 3);
		
		playerLeft[0] = playerSheet.getSprite(1, 2);
		playerLeft[1] = playerSheet.getSprite(2, 2);
		playerLeft[2] = playerSheet.getSprite(3, 2);
		playerLeft[3] = playerSheet.getSprite(4, 2);
		
	}
}
