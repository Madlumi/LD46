package game;

import game.disp.Screen;
import game.disp.Sheet;
import game.disp.Sprite;

public class Map extends Sheet{
	public int ts;
	public int colmap[];
	public Map(int w, int h, String path,int ts) {
		super(w, h, path);
		this.ts=ts;
		colmap= new int[w*h];
	}
	public int getTile(int x, int y) {
		if(x>=0&&y>=0&& x<w && y<h) {
			return pix[x+y*w];
		}
		return -1;
		
	}
	public void render(int x, int y, Screen s) {
		
		for(int xx = -1; xx < Main.W/ts+1;xx++) {
			for(int yy = -1; yy < Main.W/ts+1;yy++) {
				int rx=xx+x/ts;
				int ry=yy;
				
				if(rx>=0&&ry>=0&& rx<w && ry<h) {
					if(getTile(rx,ry)==0xff000000)s.drawSprite(xx*ts-x%ts, yy*ts-y%ts, Sprite.testspr);
				}
				
			}
		}
	}


}
