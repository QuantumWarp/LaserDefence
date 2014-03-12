package john_lowther.personal.laserdefence.controllers;

import john_lowther.personal.laserdefence.commands.CommandTick;
import john_lowther.personal.laserdefence.controllers.enums.ControllerEnums;
import john_lowther.personal.laserdefence.controllers.enums.ControllerGameEnums;
import john_lowther.personal.laserdefence.gamemodel.GameContainer;
import john_lowther.personal.laserdefence.gamemodel.GameFactory;
import john_lowther.personal.laserdefence.rendering.RendererLinker;
import john_lowther.personal.laserdefence.rendering.SurfaceViewRenderer;
import john_lowther.personal.laserdefence.utilities.Timer;
import android.content.Context;
import android.util.Log;
import android.view.SurfaceView;

/**
 * Directs methods towards the appropriate places in the game model.
 * Doesn't strictly follow MVC since it knows of a few objects.
 * @author John Lowther
 */
public class ControllerGame extends Controller {
	private SurfaceViewRenderer renderer;
	private GameContainer game;
	private Timer rendererTimer, gameTimer;
	
	@Override
	protected void switchMethod(ControllerEnums method, Object[] parameters) {

		Log.d("Controller", method.toString());
		switch ((ControllerGameEnums) method) {
		case NEW_GAME:
			newGame((Context) parameters[0],
					(SurfaceView) parameters[1]);
			break;
		case UNPAUSE:
			unpause();
			break;
		case PAUSE:
			pause();
			break;
		case CLEANUP_ACTIVITY:
			cleanupActivity();
			break;
		default:
			break;
		}
	}

	/**
	 * Creates a new game. Does not start the game. The game will begin in a
	 * paused state.
	 */
	private void newGame(Context context, SurfaceView surfaceView) {
		game = new GameFactory().getNewGame();
		
		renderer = new RendererLinker(context).setUpRenderers(game, surfaceView);
		
		rendererTimer = new Timer(10);
		gameTimer = new Timer();
		
		rendererTimer.addCommand(new CommandTick(renderer));
		gameTimer.addCommand(new CommandTick(game));
	}

	/**
	 * Starts/Unpauses the game.
	 */
	private void unpause() {
		renderer.refreshSurfaceHolder();
		rendererTimer.start();
		gameTimer.start();
	}

	/**
	 * Pauses the game.
	 */
	private void pause() {
		gameTimer.stop();
		rendererTimer.stop();
	}
	
	/**
	 * Cleans up all activity resources so that no threads are left running.
	 */
	private void cleanupActivity() {
		gameTimer.stop();
		rendererTimer.stop();
	}
}
