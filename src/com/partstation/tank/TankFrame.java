package com.partstation.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {
	//根据面向对向编程思想，此处应该封装
	/*private int x = 200, y = 200;
	Dir dir = Dir.DOWN;
	private static final int SPEED = 10;*/
	
	Tank mainTank = new Tank(200, 200, Dir.DOWN);
	
	public TankFrame() {
		setSize(800, 600);
		setResizable(false);
		setTitle("tank war");
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		this.addKeyListener(new MyKeyListener());
	}
	
	@Override
	public void paint(Graphics g) {
		/*g.fillRect(x, y, 50, 50);
		switch (dir) {
			case LEFT:
				x -= SPEED;
				break;
			case UP:
				y -= SPEED;
				break;
			case RIGHT:
				x += SPEED;
				break;
			case DOWN:
				y += SPEED;
		}*/
		mainTank.paint(g);
	}
	
	class MyKeyListener extends KeyAdapter {
		boolean bL = false, bU = false, bR = false, bD = false;
		
		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			switch (key) {
				case KeyEvent.VK_LEFT:
					bL = true;
					break;
				case KeyEvent.VK_UP:
					bU = true;
					break;
				case KeyEvent.VK_RIGHT:
					bR = true;
					break;
				case KeyEvent.VK_DOWN:
					bD = true;
					break;
				default:
					break;
			}
			setMainTankDir();
			//repaint();
			
		}
		
		@Override
		public void keyReleased(KeyEvent e) {
			int key = e.getKeyCode();
			switch (key) {
				case KeyEvent.VK_LEFT:
					bL = false;
					break;
				case KeyEvent.VK_UP:
					bU = false;
					break;
				case KeyEvent.VK_RIGHT:
					bR = false;
					break;
				case KeyEvent.VK_DOWN:
					bD = false;
					break;
				default:
					break;
			}
			setMainTankDir();
		}
		
		//根据按键状态，确定坦克方向
		private void setMainTankDir() {
			/*if (bL) dir = Dir.LEFT;
			if (bU) dir = Dir.UP;
			if (bR) dir = Dir.RIGHT;
			if (bD) dir = Dir.DOWN;*/
			mainTank.setMoving(true);
			if (bL) mainTank.setDir(Dir.LEFT);
			if (bU) mainTank.setDir(Dir.UP);
			if (bR) mainTank.setDir(Dir.RIGHT);
			if (bD) mainTank.setDir(Dir.DOWN);
		}
	}
}
