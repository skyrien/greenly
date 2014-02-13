package com.skyrien.greenly;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class RetailListFragment extends ListFragment {

	public static final String TAG = "ListFragment";
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d(TAG,"onCreate() called.");
		
		// Use this to update the app title bar
		//getActivity().setTitle(R.string.app_name);
		
	}
	
	public View onCreateView(LayoutInflater inflater, ViewGroup parent,
			Bundle savedInstanceState) {
		Log.d(TAG,"onCreateView() called.");
		View v = inflater.inflate(R.layout.fragment_list, parent, false);
		
		// stuff does here
		
		return v;
	}

}
