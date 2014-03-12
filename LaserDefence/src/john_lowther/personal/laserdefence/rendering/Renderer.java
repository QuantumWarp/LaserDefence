package john_lowther.personal.laserdefence.rendering;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Canvas;

/**
 * Renders all subrenderers and renders the composite bitmap.
 * @author John Lowther
 */
public class Renderer extends Subrenderer {
	
	public Renderer(int width, int height) {
		super(width, height);
	}
	
	public Renderer(int width, int height, int positionX, int positionY) {
		super(width, height, positionX, positionY);
	}

	private List<Subrenderer> subrendererList = new ArrayList<Subrenderer>();
	//TODO Add priority of subrenderers. For now subrenderers are added in the appropriate order.
	
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

	/**
	 * Renders all the subrenderers.
	 */
	public void render(Canvas canvas) {
		for (Subrenderer subrenderer : subrendererList) {
			subrenderer.render(canvas);
		}
	}
}
