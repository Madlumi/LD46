package game.disp;

public abstract class UiElement {
	public int x, y, w, h;
	public String type;
	public UiElement(int x, int y, int w, int h, String type) {
		this.x=x;
		this.y=y;
		this.w=w;
		this.h=h;
		this.type=type;
	}

	public void render(Screen s){
		
	}
	
}
