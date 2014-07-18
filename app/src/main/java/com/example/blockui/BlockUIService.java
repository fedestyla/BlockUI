package com.example.blockui;

import android.app.Service;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.graphics.Point;
import android.os.IBinder;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import static android.view.WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
import static android.view.WindowManager.LayoutParams.TYPE_PHONE;

public class BlockUIService extends Service {

	private WindowManager mWindowManager;
    private View rootView;

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public void onCreate() {
		super.onCreate();

        // add to the windowManager a transparent view big as the screen
		mWindowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
		LayoutInflater inflater = LayoutInflater.from(this);
        rootView = inflater.inflate(R.layout.linealayout, null);

		final WindowManager.LayoutParams parameters = new WindowManager.LayoutParams(
				MATCH_PARENT,
				MATCH_PARENT,
				TYPE_PHONE,
				FLAG_NOT_FOCUSABLE,
				PixelFormat.TRANSLUCENT
		);

		mWindowManager.addView(rootView, parameters);
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
        // if destroyed launch it again.
        Intent i = new Intent(this, BlockUIService.class);
        startService(i);
	}
}
