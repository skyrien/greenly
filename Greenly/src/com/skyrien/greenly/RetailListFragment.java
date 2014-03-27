package com.skyrien.greenly;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.widget.SimpleCursorAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class RetailListFragment extends ListFragment {
					//implements	LoaderManager.LoaderCallbacks<Cursor> 

	public static final String TAG = "ListFragment";
	
	// This is where we will declare some loader variables.
	//private static final int LOADER_ID = 0;
	
	// This adapter binds data to listview
	//private SimpleCursorAdapter mCursorAdapter;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d(TAG,"onCreate() called.");
		
		// Use this to update the app title bar
		//getActivity().setTitle(R.string.app_name);
		
		//getActivity().getSupportLoaderManager().initLoader(LOADER_ID, null, this);
		//mCursorAdapter = new SimpleCursorAdapter(
				//getActivity().getApplicationContext(), R.layout.
	}
	
	public View onCreateView(LayoutInflater inflater, ViewGroup parent,
			Bundle savedInstanceState) {
		Log.d(TAG,"onCreateView() called.");
		View v = inflater.inflate(R.layout.fragment_list, parent, false);
		
		// stuff does here
		
		return v;
	}
	
	/* THIS SECTION IS IF WE'RE USING CURSORLOADERS.
	@Override
	public Loader<Cursor> onCreateLoader(int id, Bundle args) {
		
		// TODO
		return new CursorLoader(getActivity().getApplicationContext());
	}
	
	@Override
	public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
		switch (loader.getId()) {
			case LOADER_ID:
				mCursorAdapter.swapCursor(cursor);
				break;
		}
	}
	
	@Override
	public void onLoaderReset(Loader<Cursor> loader) {
		mCursorAdapter.swapCursor(null);
	}
	 */
	
}
