package game.disp;

import java.util.ArrayList;

public class Ui {
	ArrayList<UiElement> ele = new ArrayList<UiElement>();
	Screen sc;
	public Ui(Screen sc) {
		this.sc=sc;
		ele.add(new UiBox(10, 10, 40, 20, "box"));
	}
	public void render() {
		for(int i = 0; i < ele.size(); i++) {
			ele.get(i).render(sc);
		}
	}
	
}
