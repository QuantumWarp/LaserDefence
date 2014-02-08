package john_lowther.personal.laserdefence.activities;

import john_lowther.personal.laserdefence.R;
import john_lowther.personal.laserdefence.gamemodel.Game;
import john_lowther.personal.laserdefence.gamemodel.GameFactory;
import john_lowther.personal.laserdefence.rendering.Renderer;
import android.app.Activity;
import android.os.Bundle;

/**
 * This is the main game screen. The user will play the game on this screen.
 * @author John Lowther
 */
public class FullScreenGameActivity extends Activity {
	Renderer renderer;
	Game game;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_full_screen_game);
		
		game = new GameFactory().getNewGame();
		
	}


}
