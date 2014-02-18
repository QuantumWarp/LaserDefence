package john_lowther.personal.laserdefence.gamemodel.missiles;

import john_lowther.personal.laserdefence.gamemodel.interfaces.Collidable;
import john_lowther.personal.laserdefence.gamemodel.interfaces.Damagable;
import john_lowther.personal.laserdefence.gamemodel.interfaces.Drawable;
import john_lowther.personal.laserdefence.gamemodel.interfaces.Killable;
import john_lowther.personal.laserdefence.gamemodel.interfaces.Movable;
import john_lowther.personal.laserdefence.gamemodel.interfaces.TrailProducer;
import john_lowther.personal.laserdefence.gamemodel.missiles.modules.DamageModule;
import john_lowther.personal.laserdefence.gamemodel.missiles.modules.DeathModule;
import john_lowther.personal.laserdefence.gamemodel.missiles.modules.FieldModule;
import john_lowther.personal.laserdefence.gamemodel.missiles.modules.MovementModule;
import john_lowther.personal.laserdefence.gamemodel.missiles.modules.ShieldModule;
import john_lowther.personal.laserdefence.gamemodel.missiles.modules.TeleportModule;

/**
 * The represents a single missile.
 * @author John Lowther
 */
public class Missile implements TrailProducer, Drawable, Killable, Damagable, Movable, Collidable {
//Mandatory modules
	private MovementModule movementModule;
	private DeathModule deathModule;
	
//Optional Modules
	private TeleportModule teleportModule;
	private ShieldModule shieldModule;
	private FieldModule fieldModule;
	private DamageModule damageModule;

	@Override
	public void collide(Object o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void move() {
		movementModule.move();
		
		if (teleportModule != null)
			teleportModule.runModule();
	}

	@Override
	public void damage(Object o, int amount) {
		if (damageModule == null) {
			die(o);
			return;
		}
		
		damageModule.damage(o, amount);
	}

	@Override
	public void die(Object o) {
		deathModule.die(o);
	}

	@Override
	public void addToTrail() {
		// TODO Auto-generated method stub
		
	}
	
//================== Getters and Setters ==================//
	
	public MovementModule getMovement() {
		return movementModule;
	}
	
	public void setMovement(MovementModule movement) {
		this.movementModule = movement;
	}
	
	public DeathModule getDeath() {
		return deathModule;
	}
	
	public void setDeath(DeathModule death) {
		this.deathModule = death;
	}
	
	public TeleportModule getTeleport() {
		return teleportModule;
	}
	
	public void setTeleport(TeleportModule teleport) {
		this.teleportModule = teleport;
	}
	
	public ShieldModule getShield() {
		return shieldModule;
	}
	
	public void setShield(ShieldModule shield) {
		this.shieldModule = shield;
	}
	
	public FieldModule getField() {
		return fieldModule;
	}
	
	public void setField(FieldModule field) {
		this.fieldModule = field;
	}

	public DamageModule getDamage() {
		return damageModule;
	}

	public void setDamage(DamageModule damage) {
		this.damageModule = damage;
	}
}
