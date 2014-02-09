package john_lowther.personal.laserdefence.controllers;

import john_lowther.personal.laserdefence.controllers.enums.ControllerEnums;
import john_lowther.personal.laserdefence.controllers.enums.ControllerGameEnums;

/**
 * Directs methods towards the appropriate places in the game model.
 * Doesn't strictly follow MVC since it knows of a few objects.
 * @author John Lowther
 */
public class ControllerGame extends Controller {
	//private Renderer renderer;
	//private Game game;
	//private Timer rendererTimer, gameTimer;
	
	@Override
	protected void switchMethod(ControllerEnums method, Object[] parameters) {
		switch ((ControllerGameEnums) method) {
		case NEW_GAME:
			newGame();
			break;
		case PAUSE:
			
			break;
		case UNPAUSE:
			
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
		// TODO Auto-generated method stub
		
	}
}
