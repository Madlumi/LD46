package game.obj;

import game.Main;
import game.disp.Screen;
import game.disp.Sprite;

public abstract class Entity {
	public int x,y;
	
	
	private double dx, dy;
	protected double velx;


	protected double vely;
	private double drag;
	public boolean solid=true;
	
	public Sprite spr;
	public Entity(int x, int y, Sprite spr){
		this.x=x;
		this.y=y;
		this.spr=spr;
	}
	private int movecd;
	public void move(int x, int y) {
		if(velx==0)velx=x;
		if(vely==0)vely=y;
	}
	
	public void tick() {
		dx+=velx;
		dy+=vely;
		
		if(velx>0)velx-=drag;
		else if(velx<0)velx+=drag;
		if(vely>0)vely-=drag;
		else if(vely<0)vely+=drag;
		
		
		while(dx>0) {
			if(!colx(1))x++;
			dx--;
		}
		while(dx<0) {
			if(!colx(-1))x--;
			dx++;
		}
		while(dy>0) {
			if(!coly(1))y++;
			dy--;
		}
		while(dy<0) {
			if(!coly(-1))y--;
			dy++;
		}
		tickBehaivour();
	}
	
	
	public abstract void tickBehaivour();

	private boolean colx(int i) {
		if(!solid) {return false;}
		
		int ts=Main.map.ts;//todo
		//System.out.println(Main.map.getTile(x/ts+i, y/ts));
		if(Main.map.getTile(x/ts+i, y/ts)==0xff000000) {
			
			return true;
			
		}
		return false;
	}
	private boolean coly(int i) {
		if(!solid) {return false;}
		int ts=Main.map.ts;//todo
		if(Main.map.getTile(x/ts, y/ts+i)==1) {
			return true;
		}
		return false;
	}
	public boolean follow=true;
	public void render(Screen sc) {
		if(follow) {sc.xo=x;}
		sc.drawSprite(x-sc.xo, y-sc.yo, spr);
		
	}
}
