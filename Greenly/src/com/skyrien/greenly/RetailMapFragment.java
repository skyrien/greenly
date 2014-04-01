package com.skyrien.greenly;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class RetailMapFragment extends Fragment {
	private static GreenlyDb greenlyDb;
	private Cursor mCursor;
	int mCurrentPosition = 0;

	public final String TAG = "MapFragment";
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d(TAG,"onCreate() called.");
		
	}
	
	public View onCreateView(LayoutInflater inflater, ViewGroup parent,
			Bundle savedInstanceState) {
		Log.d(TAG,"onCreateView() called.");
		View v = inflater.inflate(R.layout.fragment_map, parent, false);
		
		// stuff does here
		
		return v;
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		Log.d(TAG,"onActivityCreated() called.");
		
		if (savedInstanceState != null) {
			mCurrentPosition = savedInstanceState.getInt("curChoice", 0);
		}
		
		// This gets us the local instance to the DB
		greenlyDb = GreenlyDb.getInstance(getActivity());
		
		// DO THIS ASYNC... LATER
		mCursor = greenlyDb.getStores();
	}
	
	
	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		Log.d(TAG,"onSaveInstanceState() called.");
		outState.putInt("curChoice", mCurrentPosition);
		// this saves the current position when needed
	}
	
	
	
}
