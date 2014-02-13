package john_lowther.personal.laserdefence.gamemodel.interfaces;

/**
 * An object that can be damaged.
 * @author John Lowther
 */
public interface Damagable {
	
	/**
	 * Should be called to damage this object.
	 * @param o - object that is doing the damage
	 * @param amount - the amount of damage taken
	 */
	public void damage(Object o, int amount);
}
