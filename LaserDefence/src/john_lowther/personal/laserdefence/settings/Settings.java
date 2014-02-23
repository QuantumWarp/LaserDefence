package john_lowther.personal.laserdefence.settings;

/**
 * A singleton class that contains the settings for the application.
 * @author John Lowther
 */
//TODO maybe implement cloneable to create a snapshot of some of the settings so
//that they cant change in-game.
public class Settings {
	private static Settings instance;
	private GameSettings gameSettings;
	
	/**
	 * Default settings should be applied here.
	 */
	private Settings() {
		
	}
	
	public static Settings getInstance() {
		if (instance == null) {
			instance = new Settings();
		}
		
		return instance;
	}

	public void resetToDefault() {
		instance = new Settings();
	}

	
//================== Getters and Setters ==================//
	
	public GameSettings getGameSettings() {
		return gameSettings;
	}
	

	public void setGameSettings(GameSettings gameSettings) {
		this.gameSettings = gameSettings;
	}
	
	
}
