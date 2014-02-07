package john_lowther.personal.laserdefence.activities;

import john_lowther.personal.laserdefence.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

public class FullScreenGameActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_full_screen_game);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.full_screen_game, menu);
		return true;
	}

}
