package john_lowther.personal.laserdefence.settings;

/**
 * POJO for the settings specifically relating to the game.
 * @author John Lowther
 */
public class GameSettings {
	private int startingMaxMissiles;
	private int startingAverageMissileSpeed;
	
//================== Getters and Setters ==================//

	public int getStartingMaxMissiles() {
		return startingMaxMissiles;
	}
	
	public void setStartingMaxMissiles(int startingMaxMissiles) {
		this.startingMaxMissiles = startingMaxMissiles;
	}
	
	public int getStartingAverageMissileSpeed() {
		return startingAverageMissileSpeed;
	}
	
	public void setStartingAverageMissileSpeed(int startingAverageMissileSpeed) {
		this.startingAverageMissileSpeed = startingAverageMissileSpeed;
	}
	
}
