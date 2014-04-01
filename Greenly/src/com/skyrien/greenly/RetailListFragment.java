package com.skyrien.greenly;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.support.v4.widget.SimpleCursorAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class RetailListFragment extends ListFragment {
	int mCurrentPosition = 0;
	private SimpleCursorAdapter mCursorAdapter;
	private Cursor mCursor;
 
	public static final String TAG = "ListFragment";
	private static GreenlyDb greenlyDb;
	
	// This is where we will declare some loader variables.
	//private static final int LOADER_ID = 0;
	
	// This adapter binds data to listview
	//private SimpleCursorAdapter mCursorAdapter;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d(TAG,"onCreate() called.");
		
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		Log.d(TAG,"onActivityCreated() called.");
		
		if (savedInstanceState != null) {
			mCurrentPosition = savedInstanceState.getInt("curChoice", 0);
		}
		
		// Temp List adapter
		//setListAdapter
		
		// Use this to update the app title bar
		//getActivity().setTitle(R.string.app_name);
		
		
		// Load the DB for the first time here
		// This should be async--
		greenlyDb = GreenlyDb.getInstance(getActivity());
		mCursor = greenlyDb.getStores();
		
		// LET'S CREATE A TEST LISTVIEW ADAPTER TO PUT INTO THE LIST
		
		String[] values = new String[] {"Alpha", "Beta", "Gamma", "Delta", "Epsilon"};
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
											android.R.layout.simple_list_item_1, values);
		
		
		
		// Let's add a footer view here, just for fun
		LayoutInflater lf = getActivity().getLayoutInflater();
		getListView().setFooterDividersEnabled(true);
		TextView footerView = (TextView)lf.inflate(R.layout.footer_view, null);
		getListView().addFooterView(footerView);
		
		setListAdapter(adapter);

	}
	
	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		Log.d(TAG,"onSaveInstanceState() called.");
		outState.putInt("curChoice", mCurrentPosition);
		// this saves the current position when needed
	}
	
	public View onCreateView(LayoutInflater inflater, ViewGroup parent,
			Bundle savedInstanceState) {
		Log.d(TAG,"onCreateView() called.");
		View v = inflater.inflate(R.layout.fragment_list, parent, false);
		
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
