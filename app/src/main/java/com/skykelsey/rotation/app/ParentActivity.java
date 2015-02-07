package com.skykelsey.rotation.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class ParentActivity extends Activity {

	public static final String LOG_TAG = "ROTATION";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_parent);
	}

	@Override
	protected void onStart() {
		super.onStart();
		Log.e(LOG_TAG, "ParentActivity.onStart()");
		Log.e(LOG_TAG, "Orientation: " + (getResources().getConfiguration().orientation == android.content.res.Configuration.ORIENTATION_PORTRAIT ? "portrait" : "landscape"));
	}

	@Override
	protected void onStop() {
		super.onStop();
		Log.e(LOG_TAG, "ParentActivity.onStop()");
	}

	@SuppressWarnings("unused")
	public void launchChild(View view) {
		Intent intent = new Intent();
		intent.setClass(this, ChildActivity.class);
		startActivity(intent);
	}
}
