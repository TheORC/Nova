/**
 * This is my games main class.
 * This is where I load every thing that I need.
 */
package com.Gamesareme.nova;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

import org.lwjgl.openal.AL;

import com.Gamesareme.nova.enums.GameState;
import com.Gamesareme.nova.gfx.Renderer;
import com.Gamesareme.nova.gfx.Textures;
import com.Gamesareme.nova.input.KeyInput;
import com.Gamesareme.nova.input.MouseInput;
import com.Gamesareme.nova.libs.Audio;
import com.Gamesareme.nova.screens.LoadScreen;
import com.Gamesareme.nova.screens.Menu;
import com.Gamesareme.nova.utils.AudioPlayer;
import com.Gamesareme.nova.utils.ResourceLoader;
import com.Gamesareme.nova.utils.files.TextFile;
import com.Gamesareme.nova.world.Level;


/**
 * @author Oliver
 */
public class Game extends Canvas implements Runnable{

	
	private static final long serialVersionUID = -590962872869808290L;  //My games serial version.
	
	public static final int WIDTH = 1280; //640
	public static final int HEIGHT = WIDTH / 2 * 1;
	public static final String TITLE = "Nova";
	public static GameState state = GameState.LOADING;
	private static Game game = new Game();
	
	private boolean running = false;
	private Thread thread;
	private Renderer gfx;
	private Camera camera;
	private Menu menu;
	private Controller controller = new Controller();
	
	private Textures tex;
	
	public Level level1;
	
	private int time = 100;
	private int counter = 0;
	
	public static Game getInstance(){
		return game;
	}
	
	public Menu getMenu(){
		return menu;
	}
	
	public Controller getController(){
		return controller;
	}
	
	public Textures getTextureHandler(){
		return tex;
	}
	
	public void init(){
		ResourceLoader.preLoad();
		TextFile.writeFile("./test.txt", "test");
		System.out.println(TextFile.readFile("./test.txt"));
	}
	
	private void load(){
		switch(counter){
		case 0:
			ResourceLoader.loadImages();
			counter++;
			LoadScreen.loadMore();
			return;
		case 1:
			ResourceLoader.loadFonts();
			counter++;
			LoadScreen.loadMore();
			return;
		case 2:
			ResourceLoader.loadSounds();
			counter++;
			LoadScreen.loadMore();
			return;
		case 3:
			menu = new Menu();
			tex = new Textures();
			counter++;
			LoadScreen.loadMore();
			return;
		case 4:
			counter++;
			LoadScreen.loadMore();
			return;
		case 5:
			gfx = new Renderer();
			counter++;
			LoadScreen.loadMore();
			return;
		case 6:
			MouseInput m = new MouseInput();
			this.addMouseListener(m);
			this.addMouseMotionListener(m);
			level1 = new Level(1);
			counter++;
			LoadScreen.loadMore();
			return;
		case 7:
//			controller.addObject(new Player(100, HEIGHT - 220, Identities.PLAYER, tex));
//			camera = new Camera(0, 0);
			counter++;
			LoadScreen.loadMore();
			return;
		case 8:
			counter++;
			LoadScreen.loadMore();
			state = GameState.MENU;
			AudioPlayer.playMusic(Audio.MUSIC_FEELING);
			return;
			
		}
		
	}
	
	public void initCamera(){
		camera = new Camera(0, 0);
	}
	
	public void addKeys(){
		this.addKeyListener(new KeyInput());
	}
	
	public void tick(){
		if(state == GameState.LOADING){
			time--;
			if(time <= 0){
				load();
				time = 50;
			}
		}
		if(state == GameState.GAME){
			controller.tick();
			camera.tick();
		}
	}
	
	public void render(){
		BufferStrategy bf = this.getBufferStrategy();
		if(bf == null){
			createBufferStrategy(3);
			return;
		}
		Graphics g = bf.getDrawGraphics();
		Graphics2D g2d = (Graphics2D)g;
		g.setColor(new Color(6, 0, 40));
		g.fillRect(0, 0, WIDTH, HEIGHT);
		//////////////////////////////////////////////////////////
		if(state == GameState.LOADING){
			LoadScreen.render(g);
		}else{
			gfx.renderBackground(g);
			if(state == GameState.GAME)
				g2d.translate(camera.getX(), camera.getY());
			gfx.renderForeground(g);
			if(state == GameState.GAME)
				g2d.translate(-camera.getX(), -camera.getY());
		}
		
		//////////////////////////////////////////////////////////
		g.dispose();
		bf.show();
	}

	@Override
	public void run() {
		init();
		long lastTime = System.nanoTime();
		final double numTicks = 60.0;
		double n = 1000000000 / numTicks;
		double delta = 0;
		double frames = 0;
		int ticks = 0;
		long timer = System.currentTimeMillis();
		
		while(running){
			long currentTime = System.nanoTime();
			delta += (currentTime - lastTime) / n;
			lastTime = currentTime;
			if(delta >= 1){
				ticks++;
				delta--;
				tick();
			}
			render(); 
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000){
				timer +=1000;
				System.out.println(ticks + " Ticks, FPS: " + frames);
				Window.setTile(TITLE + "      FPS: " + frames);
				ticks = 0;
				frames = 0;
			}
		}
		stop();
	}

	
	public static void main(String args[]){
		Window.initWindow(TITLE);
		Window.addGame(game);
		Window.createWindow();
		game.start();
	}
	
	private synchronized void start(){
		if(running)
			return;
		else
			running = true;
		
		thread =new Thread(this);
		thread.start();
	}
	
	private synchronized void stop(){
		if(!running)
			return;
		else
			running = false;
		cleanUp();
		System.exit(0);
	}
	
	private void cleanUp(){
		AL.destroy();
	}
	
	public static void exit(){
		game.stop();
	}
}
