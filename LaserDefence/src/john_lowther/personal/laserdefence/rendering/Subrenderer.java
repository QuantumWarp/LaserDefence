package john_lowther.personal.laserdefence.rendering;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Handles the rendering for a specific section of a larger bitmap.
 * @author John Lowther
 */
public abstract class Subrenderer {
	private Bitmap bitmap;
	protected Canvas canvas;
	private int positionX, positionY;
	
	public Subrenderer(int width, int height) {
		this(width, height, 0, 0);
	}
	
	public Subrenderer(int width, int height, int positionX, int positionY) {
		bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
		canvas = new Canvas(bitmap);
		this.setPositionX(positionX);
		this.setPositionY(positionY);
	}
	
	/**
	 * All drawing onto this subrenderer's canvas should be done here.
	 */
	public abstract void render();

//================== Getters and Setters ==================//
	
	/**
	 * @return The image that this subrenderer handles
	 */
	public Bitmap getBitmap() {
		return bitmap;
	}
	
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
