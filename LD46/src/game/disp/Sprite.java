package game.disp;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sprite {
	public final int w,h;
	private  int x,y;
	public int pix[];
	//sheets
	public static Sheet testsht = new Sheet(128, "res/test.png");
	
	//sprites
	public static Sprite testspr = new Sprite(16,0,0, testsht);
	public static Sprite testgrd = new Sprite(16,16,0, testsht);
	
	
	public Sprite(int size, int x, int y, Sheet s) {
		this(size,size,x,y,s);
	}
	public Sprite(int w, int h, int x, int y, Sheet s) {
		this.x=x;
		this.y=y;
		this.w=w;
		this.h=h;
		pix = new int[w*h];
		getPix(s);
	}
	private void getPix(Sheet s) {
		for(int xx = 0 ; xx < w;xx++) {for(int yy = 0 ; yy < h;yy++) {
			pix[xx+yy*w]=s.pix[(x+xx)+(y+yy)*s.w];
		}}
		
	}
	
}