package john_lowther.personal.laserdefence.utilities;

/**
 * An object that does something on expiration.
 * @author John Lowther
 */
public interface Expirable {
	
	/**
	 * Calls the operation the class should do on expiration.
	 */
	public void expire();
}
