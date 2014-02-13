package john_lowther.personal.laserdefence.gamemodel.interfaces;

/**
 * An object that can be killed.
 * @author John Lowther
 */
public interface Killable {
	
	/**
	 * Should be called to kill object.
	 */
	public void die(Object o);
}
