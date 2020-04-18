package game.in;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener{


	public boolean[] keys = new boolean [600];
	public boolean left,right,up,down,space,enter,confirm,esc,shift,
	one,two,three,four,five,six,seven,eight,nine,zero,q,e,plus,minus;
	
	public void tick(){
		left = keys[KeyEvent.VK_A]||keys[KeyEvent.VK_LEFT]||keys[KeyEvent.VK_NUMPAD4]||keys[KeyEvent.VK_NUMPAD7]||keys[KeyEvent.VK_NUMPAD1];
		up = keys[KeyEvent.VK_W]||keys[KeyEvent.VK_UP]||keys[KeyEvent.VK_NUMPAD7]||keys[KeyEvent.VK_NUMPAD8]||keys[KeyEvent.VK_NUMPAD9];
		down = keys[KeyEvent.VK_S]||keys[KeyEvent.VK_DOWN]||keys[KeyEvent.VK_NUMPAD1]||keys[KeyEvent.VK_NUMPAD2]||keys[KeyEvent.VK_NUMPAD3];
		right = keys[KeyEvent.VK_D]||keys[KeyEvent.VK_RIGHT]||keys[KeyEvent.VK_NUMPAD9]||keys[KeyEvent.VK_NUMPAD6]||keys[KeyEvent.VK_NUMPAD3];
		space = keys[KeyEvent.VK_SPACE];
		enter = keys[KeyEvent.VK_ENTER];
		confirm = keys[KeyEvent.VK_ENTER]||keys[KeyEvent.VK_SPACE]||keys[KeyEvent.VK_NUMPAD5];
		esc = keys[KeyEvent.VK_ESCAPE];
		shift = keys[KeyEvent.VK_SHIFT];

		
		one = keys[KeyEvent.VK_1];
		two = keys[KeyEvent.VK_2];
		three = keys[KeyEvent.VK_3];
		four = keys[KeyEvent.VK_4];
		five = keys[KeyEvent.VK_5];
		six = keys[KeyEvent.VK_6];
		seven = keys[KeyEvent.VK_7];
		eight = keys[KeyEvent.VK_8];
		nine = keys[KeyEvent.VK_9];
		zero = keys[KeyEvent.VK_0];
		q = keys[KeyEvent.VK_Q];
		e = keys[KeyEvent.VK_E];

		plus = keys[KeyEvent.VK_PLUS];
		minus = keys[KeyEvent.VK_MINUS];

		
		
		for (int i =0; i < keys.length; i++){
			if (keys[i]);
		}
	}
	public void keyPressed(KeyEvent e) {

		keys[e.getKeyCode()] = true;
	}

	
	public void keyReleased(KeyEvent e) {
		
		keys[e.getKeyCode()] = false;
	}

	
	public void keyTyped(KeyEvent e) {
		
		
	}

}
