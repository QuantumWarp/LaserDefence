package john_lowther.personal.laserdefence.gamemodel;

import john_lowther.personal.laserdefence.gamemodel.bases.BaseContainer;
import john_lowther.personal.laserdefence.gamemodel.explosions.ExplosionContainer;
import john_lowther.personal.laserdefence.gamemodel.fields.FieldContainer;
import john_lowther.personal.laserdefence.gamemodel.interfaces.Factory;
import john_lowther.personal.laserdefence.gamemodel.lasers.LaserContainer;
import john_lowther.personal.laserdefence.gamemodel.missiles.MissileContainer;
import john_lowther.personal.laserdefence.gamemodel.shields.ShieldContainer;
import john_lowther.personal.laserdefence.settings.Settings;

/**
 * Produces game objects based on settings. Only one public method.
 * This class is used to avoid clutter in other classes.
 * @author John Lowther
 */
public class GameFactory implements Factory {
	Settings settings = Settings.getInstance();
	
	/**
	 * Creates game object.
	 * @param settings
	 * @return game
	 */
	public GameContainer getNewGame() {
		GameContainer game = GameContainer.getNewInstance();
		
		MissileContainer missiles = new MissileContainer(settings);
		FieldContainer fields = new FieldContainer(settings);
		BaseContainer bases = new BaseContainer(settings);
		ExplosionContainer explosions = new ExplosionContainer(settings);
		ShieldContainer shields = new ShieldContainer(settings);
		LaserContainer lasers = new LaserContainer(settings);
		
		game.setMissiles(missiles);
		game.setFields(fields);
		game.setBases(bases);
		game.setExplosions(explosions);
		game.setShields(shields);
		game.setLasers(lasers);
		
		return game;
	}
}
