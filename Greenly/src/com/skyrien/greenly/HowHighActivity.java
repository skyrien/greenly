package com.skyrien.greenly;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class HowHighActivity extends Activity {
	
	public static final String TAG = "HowHighActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_howhigh);
		Log.d(TAG, "onCreate() called.");
		
	}
}
