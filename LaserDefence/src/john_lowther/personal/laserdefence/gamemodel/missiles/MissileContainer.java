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
	private int maxNumberOfMissiles;
	private double spawnProbability;
	private int missilesDestroyed = 0;
	private int missilesActive = 0;
	
	private ArrayList<Missile> missiles = new ArrayList<Missile>();
	
	public MissileContainer(Settings settings) {
		// TODO Auto-generated constructor stub
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
		MissileDestroyed();
	}
	
	/**
	 * Increments the missiles destroyed count.
	 */
	public void MissileDestroyed() {
		this.missilesDestroyed++;
		this.missilesActive--;
	}


//================== Getters and Setters ==================//
		
	public int getMaxNumberOfMissiles() {
		return maxNumberOfMissiles;
	}
	

	public void setMaxNumberOfMissiles(int maxNumberOfMissiles) {
		this.maxNumberOfMissiles = maxNumberOfMissiles;
	}


	public double getSpawnProbability() {
		return spawnProbability;
	}
	


	public void setSpawnProbability(double spawnProbability) {
		this.spawnProbability = spawnProbability;
	}

	
	public int getMissilesDestroyed() {
		return missilesDestroyed;
	}

	public int getMissilesActive() {
		return missilesActive;
	}
}
