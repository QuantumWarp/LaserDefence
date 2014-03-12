package john_lowther.personal.laserdefence.rendering;

import java.util.Random;

import john_lowther.personal.laserdefence.utilities.Tickable;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class SurfaceViewRenderer extends Renderer implements Tickable {
	SurfaceView surfaceView;
	SurfaceHolder surfaceHolder;
	Random random = new Random();
	
	public SurfaceViewRenderer(SurfaceView surfaceView, int width, int height) {
		super(width, height);
		this.surfaceView = surfaceView;
		this.surfaceHolder = surfaceView.getHolder();
	}

	public void refreshSurfaceHolder() {
		surfaceHolder = surfaceView.getHolder();
	}
	
	private Integer num = 0;
	
	@Override
	public void tick() {
		Log.d("tick", num.toString());
		num++;
		
		if (surfaceHolder.getSurface().isValid()) {
			Canvas canvas = surfaceHolder.lockCanvas();
			canvas.drawColor(Color.BLACK);
			render(canvas);
			surfaceHolder.unlockCanvasAndPost(canvas);
		}
	}
}
