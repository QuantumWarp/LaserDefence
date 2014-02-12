package john_lowther.personal.laserdefence.controllers;

import john_lowther.personal.laserdefence.commands.CommandTick;
import john_lowther.personal.laserdefence.controllers.enums.ControllerEnums;
import john_lowther.personal.laserdefence.controllers.enums.ControllerGameEnums;
import john_lowther.personal.laserdefence.gamemodel.Game;
import john_lowther.personal.laserdefence.gamemodel.GameFactory;
import john_lowther.personal.laserdefence.rendering.Renderer;
import john_lowther.personal.laserdefence.utilities.Timer;

/**
 * Directs methods towards the appropriate places in the game model.
 * Doesn't strictly follow MVC since it knows of a few objects.
 * @author John Lowther
 */
public class ControllerGame extends Controller {
	private Renderer renderer;
	private Game game;
	private Timer rendererTimer, gameTimer;
	
	@Override
	protected void switchMethod(ControllerEnums method, Object[] parameters) {
		switch ((ControllerGameEnums) method) {
		case NEW_GAME:
			newGame();
			break;
		case UNPAUSE:
			
			break;
		case PAUSE:
			
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
	private void newGame() {
		game = new GameFactory().getNewGame();
		renderer = new Renderer(1, 1); //TODO (1, 1) should be replaced with the screen size.
		
		rendererTimer = new Timer();
		gameTimer = new Timer();
		
		rendererTimer.addCommand(new CommandTick(renderer));
		gameTimer.addCommand(new CommandTick(game));
	}
	
	/**
	 * Cleans up all activity resources so that no threads are left running.
	 */
	private void cleanupActivity() {
		gameTimer.stop();
		rendererTimer.stop();
	}
}
