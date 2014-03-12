package john_lowther.personal.laserdefence.rendering;

import android.graphics.Canvas;

/**
 * Handles the rendering for a specific section of a larger bitmap.
 * @author John Lowther
 */
public abstract class Subrenderer {
	private int positionX, positionY;
	protected int width, height;
	
	public Subrenderer(int width, int height) {
		this(width, height, 0, 0);
	}
	
	public Subrenderer(int width, int height, int positionX, int positionY) {
		this.width = width;
		this.height = height;
		this.setPositionX(positionX);
		this.setPositionY(positionY);
	}
	
	/**
	 * All drawing onto this subrenderer's canvas should be done here.
	 */
	public abstract void render(Canvas canvas);

//================== Getters and Setters ==================//
	
	public int getPositionX() {
		return positionX;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}
}
