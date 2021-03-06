package game.disp;

import java.util.Random;

public class Screen {

	public int[] pix;
	private int W,H;
	public int xo=0, yo=0;
	
	public Screen(int w, int h) {
		pix = new int[w*h];
		W=w;
		H=h;
		xo=0;
		yo=0;
		Random R = new Random();
		for(int i = 0; i < W*H;i++) {
			pix[i]= 
					//R.nextInt(255)<<16+
					R.nextInt(255)<<8;
					//R.nextInt(255);
		}
		
	}
	//check if value is in bounds of pixels array
	private boolean inBounds(int x, int y) {
		if(x<W&&y<H && x>=0 && y>=0) {
			return true;
		}
		return false;
	}
	private void setPix(int x, int y, int col) {
		if(inBounds(x, y))pix[x+y*W]=col;
	}
	private void setPix(int x, int y, int r,int g, int b) {
		if(inBounds(x, y))pix[x+y*W]=r;
	}
	
	public void render(int x, int y) {
		
	}
	
	public void drawBox(int x, int y, int w, int h, int r, int g, int b) {
		for(int xx= 0; xx< w;xx++) {for(int yy= 0; yy< h;yy++) {
				setPix(x+xx,y+yy,r,b,g);
			}	
		}
		
	}
	public void drawSprite(int x, int y, Sprite spr) {
		int w = spr.w;
		int h= spr.h;
		for(int xx= 0; xx< w;xx++) {for(int yy= 0; yy< h;yy++) {
			if(spr.pix[xx+yy*w]!=0xffff00ff)setPix(x+xx,y+yy,spr.pix[xx+yy*w]);
		}	
	}
		
	}
	public void clear() {
		Random R = new Random();
		for(int i = 0; i < W*H;i++) {
			pix[i]= 
					//R.nextInt(255)<<16+
					R.nextInt(255)<<8;
					//R.nextInt(255);
		}
	}
	
}
