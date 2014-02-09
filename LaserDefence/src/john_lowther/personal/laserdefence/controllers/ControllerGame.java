package john_lowther.personal.laserdefence.controllers;

import john_lowther.personal.laserdefence.controllers.enums.ControllerEnums;
import john_lowther.personal.laserdefence.controllers.enums.ControllerGameEnums;

/**
 * Directs methods towards the appropriate places in the game model.
 * Doesn't strictly follow MVC since it knows of a few objects.
 * @author John Lowther
 */
public class ControllerGame extends Controller {

	@Override
	protected void switchMethod(ControllerEnums method, Object[] parameters) {
		switch ((ControllerGameEnums) method) {
		case NEW_GAME:
			//TODO set up new game.
			break;
		default:
			break;
		}
	}
}
