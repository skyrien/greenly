/* Greenly, RetailActivity class
 * 
 * This class is the Activity for the list and map views of Greenly.
 * It hosts the store information data, and supports the list and map views
 * as fragments.
 * 
 */


package com.skyrien.greenly;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.Log;

public class RetailActivity extends FragmentActivity {
	
	public static final String TAG = "RetailActivity";
	
	// these are mappings for the string intent that is passed
	public static final String LOADFRAGMENT = "com.skyrien.greenly.loadfragment";
	public static final int LIST = 1;
	public static final int MAP = 2;
	public static final int BOOKMARKS = 3;
	
	private int requestedFragment;
	
	// The overridden onCreate method is for the activity. It will create
	// the fragment manager, as well as set up the fragment to be loaded.

	// QUESTION: Should we initialize the datastore here or in the fragments?  
	
	@Override
	public void onCreate(Bundle savedStateInstance) {
		super.onCreate(savedStateInstance);
		setContentView(R.layout.activity_retail);
		Log.d(TAG, "OnCreate() called");
		
		// This is the fragment manager for Greenly RetailActivity
		FragmentManager fm = getSupportFragmentManager();
		Fragment fragment = fm.findFragmentById(R.id.fragmentContainer);
		
		// Find the requested fragment in the intent
		// Params include the String key, and a default int return value
		requestedFragment = getIntent().getIntExtra(LOADFRAGMENT, 0);
		Log.d(TAG, "Request for " + requestedFragment + " found");
		
		// Load the fragment as requested
		switch(requestedFragment) {
			case 0: {
				Log.e(TAG, "RetailActivity loaded with no requested fragment.");
				break;
			}
			case LIST: {
				Log.d(TAG, "Attemping to load LIST fragment...");

				if (fragment == null) {
					fragment = new RetailListFragment();
					fm.beginTransaction()
					.add(R.id.fragmentContainer, fragment)
					.commit();
				}
				break;
			}
			case MAP: {
				Log.d(TAG, "Attemping to load MAP fragment...");
				if (fragment == null) {
					fragment = new RetailMapFragment();
					fm.beginTransaction()
					.add(R.id.fragmentContainer, fragment)
					.commit();
				}
				break;
			}
			case BOOKMARKS: {
				Log.d(TAG, "Attemping to load BOOKMARKS fragment...");
				if (fragment == null) {
					fragment = new RetailBookmarksFragment();
					fm.beginTransaction()
					.add(R.id.fragmentContainer, fragment)
					.commit();
				}
				break;
			}

		}
	
	}
	
}