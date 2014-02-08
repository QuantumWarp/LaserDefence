package john_lowther.personal.laserdefence.activities;

import john_lowther.personal.laserdefence.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Main menu of the application.
 * @author John Lowther
 */
public class MainMenuActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_menu);
	}
	
	/**
	 * Called on the menu button being clicked. Rederects to the appropriate page.
	 * @param v - the button pressed
	 */
	public void onClick(View v) {
		Intent intent = null;
		
		switch (v.getId()) {
			case R.id.new_game:
				intent = new Intent(this, FullScreenGameActivity.class);
				break;
		}
		
		startActivity(intent);
	}

}
