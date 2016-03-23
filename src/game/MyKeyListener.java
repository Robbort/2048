package game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MyKeyListener extends KeyAdapter{
	private Move m = new Move();
	//¼üÅÌÊÂ¼þ
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_UP||e.getKeyCode()==KeyEvent.VK_W){
			m.up(Move.a);
			Display.flag = 1;
			System.out.println("Up");
		}
		if(e.getKeyCode()==KeyEvent.VK_DOWN||e.getKeyCode()==KeyEvent.VK_S){
			m.down(Move.a);
			Display.flag = 1;
			System.out.println("Down");
		}
		if(e.getKeyCode()==KeyEvent.VK_LEFT||e.getKeyCode()==KeyEvent.VK_A){
			m.left(Move.a);
			Display.flag = 1;
			System.out.println("Left");
		}
		if(e.getKeyCode()==KeyEvent.VK_RIGHT||e.getKeyCode()==KeyEvent.VK_D){
			m.right(Move.a);
			Display.flag = 1;
			System.out.println("Right");
		}
	}
}
