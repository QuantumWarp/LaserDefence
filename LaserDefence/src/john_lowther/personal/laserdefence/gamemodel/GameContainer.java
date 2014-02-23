package john_lowther.personal.laserdefence.gamemodel;

import john_lowther.personal.laserdefence.gamemodel.bases.BaseContainer;
import john_lowther.personal.laserdefence.gamemodel.explosions.ExplosionContainer;
import john_lowther.personal.laserdefence.gamemodel.fields.FieldContainer;
import john_lowther.personal.laserdefence.gamemodel.interfaces.Container;
import john_lowther.personal.laserdefence.gamemodel.lasers.LaserContainer;
import john_lowther.personal.laserdefence.gamemodel.missiles.MissileContainer;
import john_lowther.personal.laserdefence.gamemodel.shields.ShieldContainer;
import john_lowther.personal.laserdefence.utilities.Tickable;

//TODO make sure that creatign a new game doesn't called exceptions if currently ticking.
/**
 * Class that is essentially just a POJO for all the subobjects of Game.
 * Has one useful method, tick.
 * @author John Lowther
 */
public class GameContainer implements Tickable, Container {
	private static GameContainer instance;
	
//Sub containers.
	private MissileContainer missiles;
	private LaserContainer lasers;
	private BaseContainer bases;
	private FieldContainer fields; 
	private ExplosionContainer explosions;
	private ShieldContainer shields;
	
//Game values.
	private int score;
	
	private GameContainer(){
		
	}
	
	/**
	 * Static way of getting the current GameContainer so that it can be accessed from anywhere in 
	 * the model
	 * @return current GameContainer
	 */
	public static GameContainer getInstance() {
		if (instance == null) {
			instance = new GameContainer();
		}
		
		return instance;
	}
	
	/**
	 * Gets a new GameContainer.
	 * @return new GameContainer
	 */
	public static GameContainer getNewInstance() {
		instance = new GameContainer();
		return instance;
	}
	
	/**
	 * If no user input is done, this will be the sole method that will be called
	 * during the running of the game.
	 */
	@Override
	public void tick() {
		
	}
	
	/**
	 * Adds a value to the score. Negative number to subtract.
	 * @param number
	 */
	public void addToScore(int number) {
		score += number;
	}
	
//================== Getters and Setters ==================//

	public static MissileContainer getMissiles() {
		return instance.missiles;
	}

	public void setMissiles(MissileContainer missiles) {
		this.missiles = missiles;
	}

	public static LaserContainer getLasers() {
		return instance.lasers;
	}

	public void setLasers(LaserContainer lasers) {
		this.lasers = lasers;
	}

	public static BaseContainer getBases() {
		return instance.bases;
	}

	public void setBases(BaseContainer bases) {
		this.bases = bases;
	}

	public static FieldContainer getFields() {
		return instance.fields;
	}

	public void setFields(FieldContainer fields) {
		this.fields = fields;
	}

	public static ExplosionContainer getExplosions() {
		return instance.explosions;
	}

	public void setExplosions(ExplosionContainer explosions) {
		this.explosions = explosions;
	}
	
	public static ShieldContainer getShields() {
		return instance.shields;
	}
	
	public void setShields(ShieldContainer shields) {
		this.shields = shields;
	}

	public int getScore() {
		return score;
	}
}
