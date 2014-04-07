package com.skyrien.greenly;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class KnowRulesActivity extends Activity {
	public static final String TAG = "KnowRulesActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_knowrules);
		Log.d(TAG, "onCreate() called.");
		
	}
}
