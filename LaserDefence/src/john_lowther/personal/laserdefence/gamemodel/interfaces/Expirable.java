package john_lowther.personal.laserdefence.gamemodel.interfaces;

/**
 * An object that can expire. (Usually times out).
 * @author John Lowther
 */
public interface Expirable {
	
	/**
	 * Should be called to expire the object.
	 */
	public void expire();
}
