package com.sprite;

import java.util.List;


public abstract class Brick extends Sprite {
	private boolean isDestroyed;
	public static int BRICK_WIDTH = 40;
	public static int BRICK_HEIGHT = 10;
	public static int BRICK_X_OFFSET = 10;
	public static int BRICK_Y_OFFSET = 50;

	@Override
	protected abstract void loadImage();

	public Brick(int x, int y, char dropId) {
		super();
		this.x = x;
		this.y = y; 

		isDestroyed = false;
	}

	public boolean getIsDestroyed() {
		return isDestroyed;
	}

	public void setIsDestroyed(boolean isDestroyed) {
		this.isDestroyed = isDestroyed;
	}
	
	public void breaks(List<Drop> d) {
		this.setIsDestroyed(true);
	}
}
