package john_lowther.personal.laserdefence.rendering;

import john_lowther.personal.laserdefence.gamemodel.GameContainer;
import john_lowther.personal.laserdefence.gamemodel.missiles.MissileContainer;

/**
 * Handles all the missile rendering.
 * @author John Lowther
 */
public class MissileRenderer extends Subrenderer {
	private GameContainer game;
	private MissileContainer missiles;
	
	public MissileRenderer(int width, int height) {
		super(width, height);
	}
	
	public MissileRenderer(int width, int height, int positionX, int positionY) {
		super(width, height, positionX, positionY);
	}

	public void setGame(GameContainer game) {
		this.game = game;
		this.missiles = game.getMissiles();
	}

	@Override
	public void render() {
		
	}
	
}
