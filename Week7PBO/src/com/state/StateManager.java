package com.state;

import java.awt.Graphics2D;

import com.state.levels.*;

public class StateManager {
	private State[] states;
	private int currentState;
	public static final int NUMGAMESTATES = 5;
	public static final int MENUSTATE = 0;
	public static final int SELECTSTATE = 1;
	public static final int LEVEL1STATE = 2;
	public static final int LEVEL2STATE = 3;
	public static final int LEVEL3STATE = 4;
	
	public StateManager() {

		states = new State[NUMGAMESTATES];

		currentState = MENUSTATE;
		loadState(currentState);
	}

	private void loadState(int state) {
		switch (state) {
		case MENUSTATE:
			states[state] = new MenuState(this);
			return;
		case SELECTSTATE:
			states[state] = new LevelSelectState(this);
			return;
		case LEVEL1STATE:
			states[state] = new Level_1(this, 7, 7);
			return;
		case LEVEL2STATE:
			states[state] = new Level_2(this, 10,7);
			return;
		case LEVEL3STATE:
			states[state] = new Level_3(this, 15, 7);
			return;
		default:
			throw new IllegalArgumentException("Unexpected value: " + state);
		}
	}

	private void unloadState(int state) {
		states[state] = null;
	}

	public void setState(int state) {
		unloadState(currentState);
		currentState = state;

		loadState(currentState);
	}

	public void update() {
		try {
			states[currentState].update();
		} catch (Exception e) {}
	}

	public void draw(Graphics2D g2d) {
		try {
			states[currentState].draw(g2d);
		} catch (Exception e) {}
	}

	public void keyPressed(int k) {
		states[currentState].keyPressed(k);
	}

	public void keyReleased(int k) {
		states[currentState].keyReleased(k);
	}
}
