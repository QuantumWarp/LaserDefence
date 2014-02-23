package john_lowther.personal.laserdefence.rendering;

import java.util.ArrayList;
import java.util.List;

import john_lowther.personal.laserdefence.utilities.Tickable;

/**
 * Renders all subrenderers and renders the composite bitmap onto a SurfaceView.
 * Extends Subrenderer to allow for renderers to be stacked.
 * @author John Lowther
 */
public class Renderer extends Subrenderer implements Tickable {

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

	@Override
	public void tick() {
		render();
		submitBitmap();
		//TODO implement ticker too fast checks.
	}
	
	/**
	 * Submits the bitmap first to keep the framrate steady.
	 */
	private void submitBitmap() {
		
	}

	/**
	 * Renders all the subrenderers.
	 */
	public void render() {
		for (Subrenderer subrenderer : subrendererList) {
			drawSubrenderer(subrenderer);
		}
	}
	
	/**
	 * Renders a single Subrenderer.
	 * @param subrenderer
	 */
	private void drawSubrenderer(Subrenderer subrenderer) {
		canvas.drawBitmap(subrenderer.getBitmap(),
				subrenderer.getPositionX(),
				subrenderer.getPositionY(),
				null);
	}

	

}
