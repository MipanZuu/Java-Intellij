package com.state;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import com.main.Commons;
import com.main.Main;
import com.map.Background;
import com.sprite.*;
import com.sprite.bricks.MultipleHitBrick;
import com.sprite.bricks.NormalBrick;
import com.sprite.bricks.UnbreakableBrick;

public class LevelState extends State {
	
	private boolean inGame = true;
	private String message = "Sadly, Game Over";
	Background bg;
	private ArrayList<Ball> balls;
	private Paddle paddle;
	protected Brick[] bricks;
	protected int numOfBricks;
	private int allowedBallDrop;
	private int numOfObstacles;
	List<Drop> drops;
	String dropEffect;
	private int score;
	private int addScoreValue;
	protected int[][] bricksConfiguration;
	private int rows;
	private int columns;


	public LevelState(StateManager sm, int rows, int columns) {
		super(sm);
		try {
			bg = new Background("/Backgrounds/levelbg.png", 1);
			bg.setVector(0, 0);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		this.rows = rows;
		this.columns = columns;
		this.numOfBricks = rows * columns;
		this.bricksConfiguration = new int[rows][columns];
		this.numOfObstacles = 0;

		bricks = new Brick[this.numOfBricks];

		balls = new ArrayList<Ball>();
		balls.add(new Ball());
		allowedBallDrop = 0;
		paddle = new Paddle();
		drops = new ArrayList<Drop>();
		dropEffect = null;

		score = 0;
		addScoreValue = 1;
		
		resetEffects();
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}

	public int getNumOfObstacles() {
		return numOfObstacles;
	}

	public void setNumOfObstacles(int numOfObstacles) {
		this.numOfObstacles = numOfObstacles;
	}

	public void fillConfiguration(int x1, int y1, int x2, int y2, int id) {

		if (x1 < 0)
			x1 = 0;
		if (x1 >= this.rows)
			x1 = this.rows - 1;
		if (y1 < 0)
			y1 = 0;
		if (y1 >= this.columns)
			y1 = this.columns - 1;
		if (x2 < 0)
			x2 = 0;
		if (x2 >= this.rows)
			x2 = this.rows - 2;
		if (y2 < 0)
			y2 = 0;
		if (y2 >= this.columns)
			y2 = this.columns - 3;

		for (int i = x1; i <= x2; i++)
			for (int j = y1; j <= y2; j++)
				bricksConfiguration[i][j] = id;

	}

	public void fillConfiguration(int x, int y, int id) {

		if (x < 0)
			x = 0;
		if (x >= this.rows)
			x = this.rows - 1;
		if (y < 0)
			y = 0;
		if (y >= this.columns)
			y = this.columns - 1;

		bricksConfiguration[x][y] = id;
	}

	public void translateConfiguration() {

		int k = 0;

		for (int i = 0; i < this.getRows(); i++) {
			for (int j = 0; j < this.getColumns(); j++) {
				switch (this.bricksConfiguration[i][j]) {
				case 0:
					bricks[k] = new NormalBrick(j * Brick.BRICK_WIDTH + Brick.BRICK_X_OFFSET,
							i * Brick.BRICK_HEIGHT + Brick.BRICK_Y_OFFSET, 'n');
					bricks[k].setIsDestroyed(true);
					break;
				case 1: // normal brick
					bricks[k] = new NormalBrick(j * Brick.BRICK_WIDTH + Brick.BRICK_X_OFFSET,
							i * Brick.BRICK_HEIGHT + Brick.BRICK_Y_OFFSET, 'n');
					break;
				case 10: // normal brick + debuff
					bricks[k] = new MultipleHitBrick(j * Brick.BRICK_WIDTH + Brick.BRICK_X_OFFSET,
							i * Brick.BRICK_HEIGHT + Brick.BRICK_Y_OFFSET, 'd');
					break;
				case 11: // normal brick + buff
					bricks[k] = new NormalBrick(j * Brick.BRICK_WIDTH + Brick.BRICK_X_OFFSET,
							i * Brick.BRICK_HEIGHT + Brick.BRICK_Y_OFFSET, 'b');
					break;
				case 2: // multi-hit brick
					bricks[k] = new MultipleHitBrick(j * Brick.BRICK_WIDTH + Brick.BRICK_X_OFFSET,
							i * Brick.BRICK_HEIGHT + Brick.BRICK_Y_OFFSET, 'n');
					break;
				case 20: // multi-hit brick + debuff
					bricks[k] = new MultipleHitBrick(j * Brick.BRICK_WIDTH + Brick.BRICK_X_OFFSET,
							i * Brick.BRICK_HEIGHT + Brick.BRICK_Y_OFFSET, 'd');
					break;
				case 21: // multi-hit brick + buff
					bricks[k] = new MultipleHitBrick(j * Brick.BRICK_WIDTH + Brick.BRICK_X_OFFSET,
							i * Brick.BRICK_HEIGHT + Brick.BRICK_Y_OFFSET, 'b');
					break;
				case 3: // unbreakable brick
					bricks[k] = new UnbreakableBrick(j * Brick.BRICK_WIDTH + Brick.BRICK_X_OFFSET,
							i * Brick.BRICK_HEIGHT + Brick.BRICK_Y_OFFSET, 'n');
					this.setNumOfObstacles(this.getNumOfObstacles() + 1);
					break;
				}
				k++;
			}
		}
	}

	@Override
	public void init() {
	}

	@Override
	public void update() {
		doGameCycle();
	}

	@Override
	public void draw(Graphics2D g2d) {
		bg.draw(g2d);

		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

		if (inGame) {
			drawObjects(g2d);
		} else {
			gameFinished(g2d);
		}
	}

	// draw every sprite
	private void drawObjects(Graphics2D g2d) {
		// draw ball
		for (Ball ball : balls) {
			g2d.drawImage(ball.getImage(), (int)ball.getX(), (int)ball.getY(), ball.getImageWidth(), ball.getImageHeight(),
					Main.panel);
		}
		// draw paddle
		g2d.drawImage(paddle.getImage(), (int)paddle.getX(), (int)paddle.getY(), paddle.getImageWidth(), paddle.getImageHeight(),
				Main.panel);

		// draw bricks
		for (int i = 0; i < numOfBricks; i++) {
			if (!bricks[i].getIsDestroyed()) {
				g2d.drawImage(bricks[i].getImage(), (int)bricks[i].getX(), (int)bricks[i].getY(), bricks[i].getImageWidth(),
						bricks[i].getImageHeight(), null);
			}
		}

		// draw drops
		try {
			for (Drop drop : drops) {
				g2d.drawImage(drop.getImage(), (int)drop.getX(), (int)drop.getY(), drop.getImageHeight(), drop.getImageWidth(),
						Main.panel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// draw score string
		g2d.setColor(Color.WHITE);
		g2d.setFont(new Font("Chalkboard", Font.BOLD, 25));
		g2d.drawString(String.valueOf(score), 138, 30);
		
		g2d.setColor(Color.BLACK);
		Font notifFont = new Font("Chalkboard", Font.PLAIN, 20);
		g2d.setFont(notifFont);
		FontMetrics fontMetrics = g2d.getFontMetrics(notifFont);
		try {
			if (dropEffect != null) {
				g2d.drawString(dropEffect, (Commons.WIDTH - fontMetrics.stringWidth(dropEffect)) / 2,
						Commons.WIDTH / 2);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	private void gameFinished(Graphics2D g2d) {
		balls = null;
		

		Font font = new Font("Chalkboard", Font.PLAIN, 24);
		FontMetrics fontMetrics = g2d.getFontMetrics(font);

		g2d.setColor(Color.WHITE);
		g2d.setFont(font);
		g2d.drawString(message, (Commons.WIDTH - fontMetrics.stringWidth(message)) / 2, Commons.WIDTH / 2);

		Font bottomFont = new Font("Chalkboard", Font.PLAIN, 10);
		fontMetrics = g2d.getFontMetrics(bottomFont);
		g2d.setColor(Color.RED);
		g2d.setFont(bottomFont);
		fontMetrics = g2d.getFontMetrics(bottomFont);
		String cont = "Press Enter to Continue";
		g2d.drawString(cont, (Commons.WIDTH - fontMetrics.stringWidth(cont)) / 2, 30 + Commons.WIDTH / 2);
	}

	@Override
	public void keyPressed(int k) {
		paddle.keyPressed(k);

		if (!inGame) {
			if (k == KeyEvent.VK_ENTER) {
				sm.setState(StateManager.SELECTSTATE);
			}
		} else if (inGame) {
			if (k == KeyEvent.VK_ESCAPE) {
				sm.setState(StateManager.SELECTSTATE);
			}
		}
	}

	@Override
	public void keyReleased(int k) {
		paddle.keyReleased(k);
	}

	private void doGameCycle() {
		paddle.move();

		for (int i = 0; i < balls.size(); i++) {
			Ball ball = balls.get(i);
			if (ball != null) {
				ball.move();
				checkCollision(ball, i);
			}
		}
		ballCollideWithEachOther();
		updateDrops();
	}

	private void stopGame() {
		inGame = false;
	}

	private void checkCollision(Ball ball, int index) {
		if (ball.getRect().getMaxY() > Commons.BOTTOM_EDGE) {
			if (allowedBallDrop == 0) {
				stopGame();
			} else {
				ball = null;
				allowedBallDrop--;
				balls.remove(index);
				return;
			}
		}

		for (int i = 0, j = 0; i < numOfBricks; i++) {
			if (bricks[i].getIsDestroyed()) {
				j++;
			}

			if (j == numOfBricks - this.getNumOfObstacles()) {
				message = "Victory!!";
				stopGame();
			}
		}

		if ((ball.getRect()).intersects(paddle.getRect())) {

			int paddleLPos = (int) paddle.getRect().getMinX();
			int ballLPos = (int) ball.getRect().getMinX();

			int first = paddleLPos + 8;
			int second = paddleLPos + 16;
			int third = paddleLPos + 24;
			int fourth = paddleLPos + 32;

			if (ballLPos < first) {
				ball.setXDir(-1);
				ball.setYDir(-1);
			}
			if (ballLPos >= first && ballLPos < second) {
				ball.setXDir(-1);
				ball.setYDir(-1 * ball.getYDir());
			}
			if (ballLPos >= second && ballLPos < third) {
				ball.setXDir(0);
				ball.setYDir(-1);
			}
			if (ballLPos >= third && ballLPos < fourth) {
				ball.setXDir(1);
				ball.setYDir(-1 * ball.getYDir());
			}
			if (ballLPos > fourth) {
				ball.setXDir(1);
				ball.setYDir(-1);
			}
		}

		for (int i = 0; i < numOfBricks; i++) {
			if ((ball.getRect()).intersects(bricks[i].getRect())) {

				int ballLeft = (int) ball.getRect().getMinX();
				int ballHeight = (int) ball.getRect().getHeight();
				int ballWidth = (int) ball.getRect().getWidth();
				int ballTop = (int) ball.getRect().getMinY();

				Point pointRight = new Point(ballLeft + ballWidth + 1, ballTop);
				Point pointLeft = new Point(ballLeft - 1, ballTop);
				Point pointTop = new Point(ballLeft, ballTop - 1);
				Point pointBottom = new Point(ballLeft, ballTop + ballHeight + 1);

				if (!bricks[i].getIsDestroyed()) {
					if (bricks[i].getRect().contains(pointRight)) {
						ball.setXDir(-1);
					} else if (bricks[i].getRect().contains(pointLeft)) {
						ball.setXDir(1);
					}
					if (bricks[i].getRect().contains(pointTop)) {
						ball.setYDir(1);
					} else if (bricks[i].getRect().contains(pointBottom)) {
						ball.setYDir(-1);
					}

					if (!(bricks[i] instanceof UnbreakableBrick)) {
						if (bricks[i] instanceof NormalBrick) {

							bricks[i].breaks(this.drops);
							this.score += addScoreValue;

						} else if (bricks[i] instanceof MultipleHitBrick) {

							MultipleHitBrick multipleHitBrick = (MultipleHitBrick) bricks[i];

							multipleHitBrick.setHitCount(multipleHitBrick.getHitCount() + 1);

						
							if (multipleHitBrick.getHitCount() == multipleHitBrick.getMaxHit() - 1) {
								multipleHitBrick.crack();
							}

							
							else if (multipleHitBrick.getHitCount() == multipleHitBrick.getMaxHit()) {
								multipleHitBrick.breaks(this.drops);
								this.score += addScoreValue;
							}

						}
					}
				}
			}
		}
	}

	private void ballCollideWithEachOther() {
		for (Ball b1 : balls) {
			for (Ball b2 : balls) {
				if (b1 != b2) {
					Rectangle rect1 = b1.getRect();
					Rectangle rect2 = b2.getRect();
					if (rect1.intersects(rect2)) {
						int ballLeft = (int) rect1.getMinX();
						int ballHeight = (int) rect1.getHeight();
						int ballWidth = (int) rect1.getWidth();
						int ballTop = (int) rect1.getMinY();

						Point pointRight = new Point(ballLeft + ballWidth + 1, ballTop);
						Point pointLeft = new Point(ballLeft - 1, ballTop);
						Point pointTop = new Point(ballLeft, ballTop - 1);
						Point pointBottom = new Point(ballLeft, ballTop + ballHeight + 1);

						if (rect2.contains(pointRight)) {
							b1.moveWest();
							b2.moveEast();
						} else if (rect2.contains(pointLeft)) {
							b2.moveWest();
							b1.moveEast();
						}

						if (rect2.contains(pointTop)) {
							b1.moveSouth();
							b2.moveNorth();
						} else if (rect2.contains(pointBottom)) {
							b2.moveSouth();
							b1.moveNorth();
						}
					}
				}
			}
		}
	}

	private void updateDrops() {
		for (int i = 0; i < drops.size(); i++) {
			Drop drop = drops.get(i);
			if (drop.isVisible()) {
				drop.move();
			} else {
				drops.remove(i);
			}
		}
	}
	private void resetEffects() {
		paddle.setToNormal();
		paddle.setInverted(false);
		paddle.setMoveSpeed(1);
		balls.get(0).setSpeedMultiplier(setBallSpeed());
		addScoreValue = 1;
	}
	
	private double setBallSpeed() {
		if (LevelSelectState.currLevel == 2) {
			return 3;
		}
		else if (LevelSelectState.currLevel == 1) {
			return 2;
		}
		else {
			return 1;
		}
	}
}