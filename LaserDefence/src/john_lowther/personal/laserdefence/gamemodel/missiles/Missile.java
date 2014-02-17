package john_lowther.personal.laserdefence.gamemodel.missiles;

import john_lowther.personal.laserdefence.gamemodel.interfaces.Collidable;
import john_lowther.personal.laserdefence.gamemodel.interfaces.Damagable;
import john_lowther.personal.laserdefence.gamemodel.interfaces.Drawable;
import john_lowther.personal.laserdefence.gamemodel.interfaces.Killable;
import john_lowther.personal.laserdefence.gamemodel.interfaces.Movable;
import john_lowther.personal.laserdefence.gamemodel.interfaces.TrailProducer;
import john_lowther.personal.laserdefence.gamemodel.missiles.modules.Death;
import john_lowther.personal.laserdefence.gamemodel.missiles.modules.FieldModule;
import john_lowther.personal.laserdefence.gamemodel.missiles.modules.Movement;
import john_lowther.personal.laserdefence.gamemodel.missiles.modules.ShieldModule;
import john_lowther.personal.laserdefence.gamemodel.missiles.modules.Teleport;
import john_lowther.personal.laserdefence.utilities.Variable2D;

/**
 * The represents a single missile.
 * @author John Lowther
 */
public abstract class Missile implements TrailProducer, Drawable, Killable, Damagable, Movable, Collidable {
	private Variable2D origin;
	private Variable2D position;
	private Variable2D acceleration;
	
//Mandatory modules
	private Movement movement;
	private Death death;
	
//Optional Modules
	private Teleport teleport;
	private ShieldModule shield;
	private FieldModule field;
	
//================== Getters and Setters ==================//
	
	public Variable2D getOrigin() {
		return origin;
	}
	
	public void setOrigin(Variable2D origin) {
		this.origin = origin;
	}
	
	public Variable2D getPosition() {
		return position;
	}
	
	public void setPosition(Variable2D position) {
		this.position = position;
	}
	
	public Variable2D getAcceleration() {
		return acceleration;
	}
	
	public void setAcceleration(Variable2D acceleration) {
		this.acceleration = acceleration;
	}
}
