package john_lowther.personal.laserdefence.activities;

import john_lowther.personal.laserdefence.controllers.Controller;
import john_lowther.personal.laserdefence.controllers.ControllerGame;
import john_lowther.personal.laserdefence.controllers.enums.ControllerGameEnums;
import android.app.Activity;
import android.os.Bundle;
import android.view.SurfaceView;

/**
 * This is the main game screen. The user will play the game on this screen.
 * @author John Lowther
 */
public class FullScreenGameActivity extends Activity {
	Controller controller = new ControllerGame();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		SurfaceView gameSurfaceView = new SurfaceView(this);
		setContentView(gameSurfaceView);

		controller.start();
		controller.addMethod(ControllerGameEnums.NEW_GAME, 
				this.getBaseContext(), 
				gameSurfaceView);
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		
		controller.addMethod(ControllerGameEnums.UNPAUSE);
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		
		controller.addMethod(ControllerGameEnums.PAUSE);
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		
		controller.addMethod(ControllerGameEnums.CLEANUP_ACTIVITY);
		controller.stop();
	}

}
