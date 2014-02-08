package john_lowther.personal.laserdefence.rendering;

import java.util.ArrayList;
import java.util.List;

import john_lowther.personal.laserdefence.utilities.Tickable;
import android.graphics.Bitmap;
import android.graphics.Canvas;

public abstract class Renderer implements Tickable {
	private List<Subrenderer> subrendererList = new ArrayList<Subrenderer>();
	private Bitmap bitmap;
	private Canvas canvas;
	
	public Renderer(int width, int height) {
		bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
		canvas = new Canvas(bitmap);
	}
	
	/**
	 * Adds the specified subrenderer.
	 * @param subrenderer
	 */
	public void addSubrenderer(Subrenderer subrenderer) {
		subrendererList.add(subrenderer);
	}
	
	/**
	 * Removes the specified subrenderer.
	 * @param subrenderer
	 */
	public void removeSubrenderer(Subrenderer subrenderer) {
		subrendererList.remove(subrenderer);
	}

	public void render() {
		for (Subrenderer subrenderer : subrendererList) {
			drawSubrenderer(subrenderer);
		}
	}
	
	private void drawSubrenderer(Subrenderer subrenderer) {
		canvas.drawBitmap(subrenderer.getBitmap(),
				subrenderer.getPositionX(),
				subrenderer.getPositionY(),
				null);
	}
}
