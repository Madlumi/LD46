package game.obj;

import game.disp.Sprite;

public class Player extends Entity{

	public Player(int x, int y, Sprite spr) {
		super(x, y, spr);
		// TODO Auto-generated constructor stub
	}

	
	public void tickBehaivour() {
		if(velx==0)move(1,0);
		
	}

}
