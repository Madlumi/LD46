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
import game.disp.Ui;


public class Main extends Canvas implements Runnable{
	public static int W=160,H=144,S = 4;
	private Thread thread;
	private JFrame frame;	
	
	private BufferedImage im = new BufferedImage(W, H, BufferedImage.TYPE_INT_RGB);
	public int[]pixels = ((DataBufferInt)im.getRaster().getDataBuffer()).getData();
	
	public static 	Main m = new Main();
	public static 	Screen sc;
	public static 	Ui ui;
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
		m.run();
		
	}

	public int gamestate = 0;
	
	public void render() {
		
		//render functions here
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
	public void run() {
		boolean running = true;
		
		while(running) {
			render();
		}
	}

}
