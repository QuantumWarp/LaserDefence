package john_lowther.personal.laserdefence.activities;

import john_lowther.personal.laserdefence.R;
import john_lowther.personal.laserdefence.commands.CommandExpire;
import john_lowther.personal.laserdefence.utilities.Expirable;
import john_lowther.personal.laserdefence.utilities.Timer;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class SplashActivity extends Activity implements Expirable {
	Timer timer;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		
		timer = new Timer(1000);
		timer.addCommand(new CommandExpire(this));
		timer.start();
	}

	@Override
	public void expire() {
		timer.stop();
		
		Intent intent = new Intent(this, MainMenuActivity.class);
		startActivity(intent);
		
		this.finish();
	}
	
}
