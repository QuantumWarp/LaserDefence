package john_lowther.personal.laserdefence.gamemodel.bases;

import john_lowther.personal.laserdefence.gamemodel.interfaces.*;

/**
 * This object represents a single base. These take damage when hit by missiles, the point 
 * is to defend them.
 * @author John Lowther
 */
public abstract class Base implements Drawable, Killable, Damagable, Collidable {
	
}
