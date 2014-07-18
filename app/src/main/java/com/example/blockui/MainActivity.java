package com.example.blockui;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

        Intent i = new Intent(this, BlockUIService.class);
        startService(i);
	}

	@Override
	protected void onResume() {
		super.onResume();
        // finish the activity, we don't want to show it. We only want to show the transparent view
		finish();
	}
}
