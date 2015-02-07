package com.skykelsey.rotation.app;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;


public class ChildActivity extends Activity {

	public static final String LOG_TAG = "ROTATION";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_child);
	}

	@Override
	protected void onStart() {
		super.onStart();
		Log.e(LOG_TAG, "ChildActivity.onStart()");
		Log.e(LOG_TAG, "Orientation: " + (getResources().getConfiguration().orientation == android.content.res.Configuration.ORIENTATION_PORTRAIT ? "portrait" : "landscape"));
	}

	@Override
	protected void onStop() {
		super.onStop();
		Log.e(LOG_TAG, "ChildActivity.onStop()");
	}

	@SuppressWarnings("unused")
	public void close(View view) {
		finish();
	}
}
