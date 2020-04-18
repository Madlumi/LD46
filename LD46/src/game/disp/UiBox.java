package game.disp;

public class UiBox extends UiElement{

	public UiBox(int x, int y, int w, int h, String type) {
		super(x, y, w, h, type);
	}
	
	public void render(Screen s){
		s.drawBox(x,y,w,h,255,255,255);
		//System.out.println("aaa");
	}

}
