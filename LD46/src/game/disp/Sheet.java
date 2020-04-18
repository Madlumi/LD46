package game.disp;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;



public class Sheet {
	public int w,h;
	public int pix[];
	
	//public Sheet s = new Sheet(32, "test");
	
	public Sheet(int size, String path) {
		this(size,size,path);
	}
	public Sheet(int w, int h, String path) {
		this.w=w;
		this.h=h;
		pix = new int[w*h];
		load(path);
	}
	
	private void load(String path){
		File f = new File(path);
		System.out.println(f.getPath());
		try {
			BufferedImage im = ImageIO.read(f);

			im.getRGB(0,0,w,h,pix,0,w);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
