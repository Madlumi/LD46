package game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import game.disp.Screen;
import game.disp.Sprite;
import game.disp.ui.Ui;
import game.in.Keyboard;
import game.in.Mouse;
import game.obj.Player;


public class Main extends Canvas implements Runnable{
	public static int W=160,H=144,S = 4;
	private Thread thread;
	private JFrame frame;	
	
	private BufferedImage im = new BufferedImage(W, H, BufferedImage.TYPE_INT_RGB);
	public int[]pixels = ((DataBufferInt)im.getRaster().getDataBuffer()).getData();
	
	public static 	Main m = new Main();
	public static 	Screen sc;
	public static 	Ui ui;
	public static  	Map map; 
	public static Player pl;
	
	
	public static void main(String[] args) {
		System.out.println("HELLLOOOOOOOO WORRRRRRRRRLD");


		
		
		//Toolkit.getDefaultToolkit().setDynamicLayout(true);
		m.frame = new JFrame("GAME");
		m.frame.setSize(W,H);
		m.frame.setResizable(false);
		m.frame.add(m);
		m.frame.pack();
		m.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		m.frame.setLocationRelativeTo(null);
		//frame.setIcon(icon image url);﻿
		m.frame.setFocusable(true);
		m.frame.setVisible(true);
		//m.frame.getContentPane().setCursor(blank);
		m.frame.setMinimumSize(new Dimension(W*S, H*S));
		sc = new Screen(W,H);
		ui=new Ui(sc);
		pl=new Player(48, 80, Sprite.testspr);
		map=new Map(128, 128, "res/maps/map1.png", 16);
		m.run();
		
	}

	public int gamestate = 0;
	int j=5;
	public void render() {
		sc.clear();
		
		//render functions here
		map.render(sc.xo, sc.yo, sc);
		pl.render(sc);
		ui.render();

		BufferStrategy bs = getBufferStrategy();
		if(bs == null){createBufferStrategy(2);return;}

		
		//System.out.println(((double)frame.getWidth()/(double)frame.getHeight()));
		//frame.setSize(frame.getWidth()-1, frame.getHeight());

		for(int y = 0; y<pixels.length;y++){
			pixels[y] = sc.pix[y];
	    }

		Graphics g = bs.getDrawGraphics();
		g.drawImage(im,0,0,getWidth(),getHeight(),null);
		g.setColor(Color.BLACK);
		
		//g.drawLine(0, 0, frame.getWidth(), frame.getHeight());
		//g.setColor(Color.WHITE);

		g.dispose();
		//Screen.clear();
		bs.show();
		
	}
	public static Keyboard key;
	public static Mouse mouse;
	public void run() {
		boolean running = true;
		long lastTime = System.nanoTime();
		long timer =  System.currentTimeMillis();
		final double ns = 1000000000.0 / 60.0;
		double delta = 0;
		int frames = 0;
		
		mouse = new Mouse();
		addMouseMotionListener(mouse);
		addFocusListener(mouse);
		addMouseListener(mouse);
		addMouseWheelListener(mouse);
		
		key = new Keyboard();
		addKeyListener(key);
		
		while(running) {
			
			
			
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1){
				//tick();
				pl.tick();
				key.tick();
				delta--;
				
			}
			frames++;
			if (System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				
				//System.out.println("Ups" + ticks +"; Fps"+ frames);
				//ups = ticks;
				//fps = frames;
				//ticks = 0;
				frames = 0;
			}
			
			render();
			
		}
	}

}
