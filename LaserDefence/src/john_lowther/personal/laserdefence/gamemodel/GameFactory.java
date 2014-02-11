package john_lowther.personal.laserdefence.gamemodel;

import john_lowther.personal.laserdefence.settings.Settings;

/**
 * Produces game objects based on settings. Only one public method.
 * This class is used to avoid clutter in other classes.
 * @author John Lowther
 */
public class GameFactory {
	Settings settings = Settings.getInstance();
	
	/**
	 * Creates game object.
	 * @param settings
	 * @return game
	 */
	public Game getNewGame() {
		Game game = new Game();
		
		return game;
	}
}
