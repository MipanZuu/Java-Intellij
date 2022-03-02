package com.state;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import com.map.Background;

public class MenuState extends State {

	private Background bg;
	private int currentChoice = 0;
	private String[] options = { "Play", "Quit" };
	private Font font;


	public MenuState(StateManager sm) {
		super(sm);
		init();
	}

	@Override
	public void init() {
		try {
			bg = new Background("/Backgrounds/mainbg.png", 1);
			bg.setVector(0, 0);

			font = new Font("Chalkboard", Font.PLAIN, 16);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update() {
	}

	@Override
	public void draw(Graphics2D g2d) {
		bg.draw(g2d);
		g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

		FontMetrics metrics;
		String text;
		int x;
		int y;

		metrics = g2d.getFontMetrics(font);
		g2d.setFont(font);
		for (int i = 0; i < options.length; i++) {
			if (i == currentChoice) {
				g2d.setColor(Color.RED);
			} else {
				g2d.setColor(Color.WHITE);
			}
			text = options[i];
			x = makeWidth(text, metrics);
			y = makeHeight(170 + i * 27, metrics);

			g2d.drawString(text, x, y);
		}
	}

	@Override
	public void keyPressed(int k) {
		if (k == KeyEvent.VK_ENTER) {
			select();
		}
		if (k == KeyEvent.VK_UP) {
			currentChoice--;
			if (currentChoice < 0) {
				currentChoice = options.length - 1;
			}
		}
		if (k == KeyEvent.VK_DOWN) {
			currentChoice++;
			if (currentChoice == options.length) {
				currentChoice = 0;
			}
		}
	}

	@Override
	public void keyReleased(int k) {
	}

	private void select() {
		if (currentChoice == 0) {
			sm.setState(StateManager.SELECTSTATE);
		} else if (currentChoice == 1) {
			int choose = JOptionPane.showConfirmDialog(
						null,
						"Do you really want to quit the game? :(",
						"BreakOut Max G6",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.INFORMATION_MESSAGE
					);
			if (choose == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		}
	}
}
