/*
 * This Section of Code Detects User Key Input (WASD)
 */

package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class keyHandler implements KeyListener{
	
	public boolean upPressed, downPressed, leftPressed, rightPressed, keyPressed;
	public boolean wLastPressed, aLastPressed, sLastPressed, dLastPressed;
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		
		if (code == KeyEvent.VK_W) {
			upPressed = true;
			
			wLastPressed = true;
			aLastPressed = false;
			sLastPressed = false;
			dLastPressed = false;
		}
		if (code == KeyEvent.VK_S) {
			downPressed = true;
					
			wLastPressed = false;
			aLastPressed = false;
			sLastPressed = true;
			dLastPressed = false;
		}
		if (code == KeyEvent.VK_A) {
			leftPressed = true;
			
			wLastPressed = false;
			aLastPressed = true;
			sLastPressed = false;
			dLastPressed = false;
		}
		if (code == KeyEvent.VK_D) {
			rightPressed = true;
			
			wLastPressed = false;
			aLastPressed = false;
			sLastPressed = false;
			dLastPressed = true;		

		}
		if (code == KeyEvent.VK_D || code == KeyEvent.VK_A|| code == KeyEvent.VK_S || code == KeyEvent.VK_W) {
			keyPressed = true;
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();
		
		if (code == KeyEvent.VK_W) {
			upPressed = false;
			
			wLastPressed = false;
			aLastPressed = true;
			sLastPressed = true;
			dLastPressed = true;
		}
		if (code == KeyEvent.VK_S) {
			downPressed = false;
			
			wLastPressed = true;
			wLastPressed = true;
			aLastPressed = true;
			sLastPressed = false;
			dLastPressed = true;			
		}
		
		if (code == KeyEvent.VK_A) {
			leftPressed = false;
			
			wLastPressed = true;
			wLastPressed = true;
			aLastPressed = false;
			sLastPressed = true;
			dLastPressed = true;			
		}
		
		if (code == KeyEvent.VK_D) {
			rightPressed = false;
			
			wLastPressed = true;
			wLastPressed = true;
			aLastPressed = true;
			sLastPressed = true;
			dLastPressed = false;
		}
		
	if (code == KeyEvent.VK_D || code == KeyEvent.VK_A|| code == KeyEvent.VK_S|| code == KeyEvent.VK_W) {
		keyPressed = false;
	}
	
	}
		
}