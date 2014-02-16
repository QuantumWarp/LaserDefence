package john_lowther.personal.laserdefence.gamemodel;

import john_lowther.personal.laserdefence.gamemodel.interfaces.Factory;
import john_lowther.personal.laserdefence.settings.Settings;

/**
 * Produces game objects based on settings. Only one public method.
 * This class is used to avoid clutter in other classes.
 * @author John Lowther
 */
public class GameFactory implements Factory {
	Settings settings = Settings.getInstance();
	
	/**
	 * Creates game object.
	 * @param settings
	 * @return game
	 */
	public GameContainer getNewGame() {
		GameContainer game = new GameContainer();
		
		return game;
	}
}
