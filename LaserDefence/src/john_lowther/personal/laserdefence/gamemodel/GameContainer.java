package john_lowther.personal.laserdefence.gamemodel;

import john_lowther.personal.laserdefence.gamemodel.bases.BaseContainer;
import john_lowther.personal.laserdefence.gamemodel.explosions.ExplosionContainer;
import john_lowther.personal.laserdefence.gamemodel.fields.FieldContainer;
import john_lowther.personal.laserdefence.gamemodel.interfaces.Container;
import john_lowther.personal.laserdefence.gamemodel.lasers.LaserContainer;
import john_lowther.personal.laserdefence.gamemodel.missiles.MissileContainer;
import john_lowther.personal.laserdefence.gamemodel.shields.ShieldContainer;
import john_lowther.personal.laserdefence.utilities.Tickable;

/**
 * Class that is essentially just a POJO for all the subobjects of Game.
 * Has one useful method, tick.
 * @author John Lowther
 */
public class GameContainer implements Tickable, Container {
	private MissileContainer missiles;
	private LaserContainer lasers;
	private BaseContainer bases;
	private FieldContainer fields; 
	private ExplosionContainer explosions;
	private ShieldContainer shields;
	
	/**
	 * If no user input is done, this will be the sole method that will be called
	 * during the running of the game.
	 */
	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}
	
//================== Getters and Setters ==================//

	public MissileContainer getMissiles() {
		return missiles;
	}

	public void setMissiles(MissileContainer missiles) {
		this.missiles = missiles;
	}

	public LaserContainer getLasers() {
		return lasers;
	}

	public void setLasers(LaserContainer lasers) {
		this.lasers = lasers;
	}

	public BaseContainer getBases() {
		return bases;
	}

	public void setBases(BaseContainer bases) {
		this.bases = bases;
	}

	public FieldContainer getFields() {
		return fields;
	}

	public void setFields(FieldContainer fields) {
		this.fields = fields;
	}

	public ExplosionContainer getExplosions() {
		return explosions;
	}

	public void setExplosions(ExplosionContainer explosions) {
		this.explosions = explosions;
	}

	
	public ShieldContainer getShields() {
		return shields;
	}

	
	public void setShields(ShieldContainer shields) {
		this.shields = shields;
	}

}
