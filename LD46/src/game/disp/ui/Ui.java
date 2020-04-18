package game.disp.ui;

import java.util.ArrayList;

import game.Main;
import game.disp.Screen;

public class Ui {
	ArrayList<UiElement> ele = new ArrayList<UiElement>();
	Screen sc;
	public Ui(Screen sc) {
		this.sc=sc;
		ele.add(new UiBox(5, Main.H-45, Main.W-10, 40, "box"));
	}
	public void render() {
		for(int i = 0; i < ele.size(); i++) {
			ele.get(i).render(sc);
		}
	}
	
}
