package john_lowther.personal.laserdefence.rendering.specific;

import john_lowther.personal.laserdefence.gamemodel.GameContainer;
import john_lowther.personal.laserdefence.gamemodel.missiles.MissileContainer;
import john_lowther.personal.laserdefence.rendering.Subrenderer;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Handles all the missile rendering.
 * @author John Lowther
 */
public class MissileRenderer extends Subrenderer {
	@SuppressWarnings("unused")
	private GameContainer game;
	@SuppressWarnings("unused")
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

	private int x = 0;
	private int y = 0;
	
	@Override
	public void render(Canvas canvas) {
		canvas.drawColor(Color.BLACK);
		Paint paint = new Paint();
	    paint.setAntiAlias(true);
	    paint.setStrokeWidth(6f);
	    paint.setColor(Color.YELLOW);
	    paint.setStyle(Paint.Style.STROKE);
		canvas.drawLine(x, 0, x, height, paint);
		x+=10;
		if (x > width + 1) x = 0;

	    paint.setColor(Color.BLUE);
		canvas.drawLine(0, y, width, y, paint);
		y+=10;
		if (y > height + 1) y = 0;
	}
}
