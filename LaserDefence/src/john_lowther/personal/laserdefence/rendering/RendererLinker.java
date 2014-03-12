package john_lowther.personal.laserdefence.rendering;

import john_lowther.personal.laserdefence.gamemodel.GameContainer;
import john_lowther.personal.laserdefence.rendering.specific.MissileRenderer;
import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.SurfaceView;
import android.view.WindowManager;

/**
 * Joins the Game appropriately to renderers. Note that each renderer has a direct link to the 
 * game instance, even though the current game can be statically accessed.
 * @author John Lowther
 */
public class RendererLinker {
	private Point screenSize = new Point();
	
	@SuppressWarnings("deprecation")
	public RendererLinker(Context context) {
		WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
		Display display = windowManager.getDefaultDisplay();
		
	    try {
	        display.getSize(screenSize);
	    } catch (java.lang.NoSuchMethodError ignore) {
	    	screenSize.set(display.getWidth(), display.getHeight());
	    }
	}
	
	/**
	 * Method to set up the renderers.
	 * @param game
	 * @param renderer
	 */
	public SurfaceViewRenderer setUpRenderers(GameContainer game, SurfaceView surfaceView) {
		SurfaceViewRenderer renderer = new SurfaceViewRenderer(surfaceView, screenSize.x, screenSize.y);
		
		MissileRenderer missileRenderer = new MissileRenderer(screenSize.x, screenSize.y);
		missileRenderer.setGame(game);
		
		renderer.addSubrenderer(missileRenderer);
		
		return renderer;	
	}
}
