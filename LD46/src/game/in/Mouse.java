package game.in;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import game.Main;

public class Mouse implements MouseListener,MouseMotionListener,MouseWheelListener,FocusListener{

	public static int mouseX=-1,mouseY=-1,mouseB=-1,mouseW=-1;
	public static boolean mouseON;
	
	public static int getX(){
		return mouseX;
	}
	public static int getY(){
		return mouseY;
	}
	public static int getB(){
		return mouseB;
	}
	public static int getW(){
		return mouseW;
	}
	public static boolean getON(){
		return mouseON;
	}
	public void mouseDragged(MouseEvent arg0) {
		mouseX = arg0.getX();
		mouseY = arg0.getY();
	}

	public void mouseMoved(MouseEvent arg0) {
		mouseX = arg0.getX();
		mouseY = arg0.getY();


		
	}

	public void mouseClicked(MouseEvent arg0) {
		
	}

	public void mouseEntered(MouseEvent arg0) {
		
	}

	public void mouseExited(MouseEvent arg0) {
		
	}

	public void mousePressed(MouseEvent arg0) {
		mouseB = arg0.getButton();


	}


	public void mouseReleased(MouseEvent arg0) {
		mouseB = -1;


	}
	@Override
	public void focusGained(FocusEvent e) {

		mouseON=true;		
	}
	@Override
	public void focusLost(FocusEvent e) {
		for (int i =0; i < Main.key.keys.length; i++){
			Main.key.keys[i]=false;
		}		
		mouseON=false;		
	}
	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
 
		System.out.println("ok");
	}



}
