package com.state;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;

import com.map.Background;

public class LevelSelectState extends State {

	private Background bg;
	private Font levelFont;
	private String[] levelSets = {"Easy", "Normal", "Hard","Back to Menu" };
	static int currLevel = 0;

	public LevelSelectState(StateManager sm) {
		super(sm);

		try {
			bg = new Background("/Backgrounds/selectbg.png", 1);
			bg.setVector(0, 0);

			levelFont = new Font("Chalkboard", Font.PLAIN, 14);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void init() {
	}

	@Override
	public void update() {
	}

	@Override
	public void draw(Graphics2D g2d) {
		bg.draw(g2d);

		g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

		FontMetrics m;
		String text;
		int x;
		int y;


		m = g2d.getFontMetrics(levelFont);
		g2d.setFont(levelFont);

		for (int i = 0; i < levelSets.length; i++) {
			if (i == currLevel) {
				g2d.setColor(Color.red);
			} else {
				g2d.setColor(Color.black);
			}

			y = makeHeight(140 + i * 27, m);

			if (i == 3) {
				y = makeHeight(140 + i * 30, m);
			}

			text = levelSets[i];
			x = makeWidth(text, m);

			g2d.drawString(text, x, y);
		}
	}

	@Override
	public void keyPressed(int k) {
		if (k == KeyEvent.VK_ENTER) {
			select();
		}
		if (k == KeyEvent.VK_UP) {
			currLevel--;
			if (currLevel < 0) {
				currLevel = levelSets.length - 1;
			}
		}
		if (k == KeyEvent.VK_DOWN) {
			currLevel++;
			if (currLevel == levelSets.length) {
				currLevel = 0;
			}
		}

	}

	@Override
	public void keyReleased(int k) {
	}

	private void select() {
		if (currLevel == 0) {
			sm.setState(StateManager.LEVEL1STATE);
		} else if (currLevel == 1) {
			sm.setState(StateManager.LEVEL2STATE);
		} else if (currLevel == 2) {
			sm.setState(StateManager.LEVEL3STATE);
		} else if (currLevel == 3) {
			sm.setState(StateManager.MENUSTATE);
		}
	}
}
