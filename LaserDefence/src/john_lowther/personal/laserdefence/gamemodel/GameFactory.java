package john_lowther.personal.laserdefence.gamemodel;

/**
 * Produces game objects based on settings.
 * @author John Lowther
 */
public class GameFactory {
	
	/**
	 * Only has one method to create game object.
	 * @param settings
	 * @return game
	 */
	public Game getNewGame() {
		Game game = new Game();
		
		return game;
	}
}
