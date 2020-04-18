package game.disp;

import java.util.Random;

public class Screen {

	public int[] pix;
	private int W,H;
	
	public Screen(int w, int h) {
		pix = new int[w*h];
		W=w;
		H=h;
		
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
	
}
