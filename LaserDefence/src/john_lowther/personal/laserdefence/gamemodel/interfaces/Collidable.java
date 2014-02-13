package john_lowther.personal.laserdefence.gamemodel.interfaces;

/**
 * An object that collides with other objects.
 * @author John Lowther
 */
public interface Collidable {
	
	/**
	 * Should be called on colliding.
	 * @param o - the object colliding with, if any
	 */
	public void collide(Object o);
}
