package com.partstation.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {
	
	int x = 200, y = 200;
	
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
//		System.out.println("paint");
		g.fillRect(x, y, 50, 50);
		x += 10;
	}
	
	class MyKeyListener extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			x += 200;
			repaint();
			
		}
		
		@Override
		public void keyReleased(KeyEvent e) {
		
		}
	}
}