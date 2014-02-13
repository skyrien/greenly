package com.skyrien.greenly;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends Activity {

	//Private variables
	private static final String TAG = "HomeActivity";
	
	//UI elements
	private Button mListStoresButton;
	private Button mShowMapButton;
	private Button mBookmarksButton;
	private Button mKnowRulesButton;
	private Button mHowHighButton;
	private Button mAboutAppButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		Log.d(TAG, "onCreate() called");
		
		// Setting up buttons to actual view objects
		mListStoresButton = (Button)findViewById(R.id.button_show_list);
		mShowMapButton = (Button)findViewById(R.id.button_show_map);
		mBookmarksButton = (Button)findViewById(R.id.button_bookmarks);
		mKnowRulesButton = (Button)findViewById(R.id.button_know_rules);
		mHowHighButton = (Button)findViewById(R.id.button_how_high);
		mAboutAppButton = (Button)findViewById(R.id.button_about);
		
		// Setting up listeners on all buttons
		mListStoresButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Log.d(TAG, "LIST button pressed.");
				// IMPLEMENT
				Intent i = new Intent(HomeActivity.this, RetailActivity.class);
				i.putExtra(RetailActivity.LOADFRAGMENT, RetailActivity.LIST);
				Log.d(TAG, "Activity intent created with LIST intent.");
				startActivity(i);
			}
		});
		
		mShowMapButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Log.d(TAG, "MAP button pressed.");
				// IMPLEMENT
				Intent i = new Intent(HomeActivity.this, RetailActivity.class);
				i.putExtra(RetailActivity.LOADFRAGMENT, RetailActivity.MAP);
				Log.d(TAG, "Activity intent created with MAP intent.");
				startActivity(i);
			}
		});
		
		mBookmarksButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Log.d(TAG, "BOOKMARKS button pressed.");
				// IMPLEMENT
				Intent i = new Intent(HomeActivity.this, RetailActivity.class);
				i.putExtra(RetailActivity.LOADFRAGMENT, RetailActivity.BOOKMARKS);
				Log.d(TAG, "Activity intent created with BOOKMARKS intent.");
				startActivity(i);
			}
		});
		
		
		mKnowRulesButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Log.d(TAG, "KNOW RULES button pressed.");
				// IMPLEMENT
				Intent i = new Intent(HomeActivity.this, KnowRulesActivity.class);
				Log.d(TAG, "Activity intent created.");
				startActivity(i);
			}
		});
		
		mHowHighButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Log.d(TAG, "HOW HIGH button pressed.");
				// IMPLEMENT LOADING OF THE NEW ACTIVITY.
				Intent i = new Intent(HomeActivity.this, HowHighActivity.class);
				Log.d(TAG, "Activity intent created.");
				startActivity(i);
			}
		});
		
		mAboutAppButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Log.d(TAG, "ABOUT button pressed.");
				// IMPLEMENT LOADING OF THE NEW ACTIVITY.
				Intent i = new Intent(HomeActivity.this, AboutActivity.class);
				Log.d(TAG, "Activity intent created.");
				startActivity(i);
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home, menu);
		return true;
	}

}
