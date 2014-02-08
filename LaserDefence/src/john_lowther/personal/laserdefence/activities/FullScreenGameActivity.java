package john_lowther.personal.laserdefence.activities;

import john_lowther.personal.laserdefence.R;
import android.app.Activity;
import android.os.Bundle;

/**
 * This is the main game screen. The user will play the game on this screen.
 * @author John Lowther
 */
public class FullScreenGameActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_full_screen_game);
	}


}
