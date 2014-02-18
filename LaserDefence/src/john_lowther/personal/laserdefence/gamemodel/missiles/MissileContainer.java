package john_lowther.personal.laserdefence.gamemodel.missiles;

import java.util.ArrayList;

import john_lowther.personal.laserdefence.gamemodel.interfaces.Container;
import john_lowther.personal.laserdefence.settings.Settings;

/**
 * Holds all the data related to Missile objects as a whole.
 * Holds the array of Missile objects.
 * @author John Lowther
 */
public class MissileContainer implements Container {
	//private int maxNumberOfMissiles;
	//private double spawnProbability;
	private ArrayList<Missile> missiles = new ArrayList<Missile>();
	
	public MissileContainer(Settings settings) {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @return number of alive missiles
	 */
	public int missileCount() {
		return missiles.size();
	}
	
	/**
	 * Add missile to the array.
	 * @param missile
	 */
	public void addMissile(Missile missile) {
		missiles.add(missile);
	}
	
	/**
	 * Remove missile from array.
	 * @param missile
	 */
	public void removeMissile(Missile missile) {
		missiles.remove(missile);
	}
}
