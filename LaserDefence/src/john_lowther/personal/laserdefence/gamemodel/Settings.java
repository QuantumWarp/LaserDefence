package john_lowther.personal.laserdefence.gamemodel;

/**
 * A singleton class that contains the settings for the application.
 * @author John Lowther
 */
public class Settings {
	private static Settings instance;
	
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
	
}
