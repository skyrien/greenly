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
import android.widget.TextView;

public class RetailListFragment extends ListFragment implements LoaderManager.LoaderCallbacks<Cursor> {

	public static final String TAG = "ListFragment";
	public static final int LOADER_ID = 1;
	
	// Static variables that I need
	private static GreenlyDb greenlyDb;
	private SimpleCursorAdapter mCursorAdapter;
	private Cursor mCursor;
	private LoaderManager.LoaderCallbacks<Cursor> mCallbacks;
	private int mCurrentPosition = 0;
	
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
		
		// Load the DB for the first time here
		// 1. Requested schema definition for the cursor, based on DB columns
		String[] dataColumns = {RetailDbContract.RetailItem.TRADENAME,
								RetailDbContract.RetailItem.LICENSE,
								RetailDbContract.RetailItem.STREETADDRESS,
								RetailDbContract.RetailItem.SUITE,
								RetailDbContract.RetailItem.CITY,
								RetailDbContract.RetailItem.COUNTY,
								RetailDbContract.RetailItem.LATITUDE,
								RetailDbContract.RetailItem.LONGITUDE
				};
		int[] viewIDs = {	R.id.list_item_name,
							R.id.list_item_license,
							R.id.list_item_address,
							R.id.list_item_address_suite,
							R.id.list_item_address_city,
							R.id.list_item_address_county,
							R.id.list_item_stat1,
							R.id.list_item_stat2};
		
		// 2. Initializing an empty cursorAdapter. This will be populated later
		// 		when we get the Loader to work.
		mCursorAdapter = new SimpleCursorAdapter(getActivity().getApplicationContext(),
												R.layout.list_item, null, dataColumns, viewIDs, 0); 		
		
		// Let's add a footer view here, just for fun -- IT WORKS!!!
		LayoutInflater lf = getActivity().getLayoutInflater();
		getListView().setFooterDividersEnabled(true);
		TextView footerView = (TextView)lf.inflate(R.layout.footer_view, null);
		getListView().addFooterView(footerView);
		
		setListAdapter(mCursorAdapter);
		mCallbacks = this;
		// This gets a SupportLoaderManager from the Activity and starts the Loader
		getActivity().getSupportLoaderManager().initLoader(LOADER_ID, null, this);
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
	
	// THIS SECTION IS IF WE'RE USING CURSORLOADERS.
	@Override
	public Loader<Cursor> onCreateLoader(int id, Bundle args) {
		Log.d(TAG,"onCreateLoader called for loader: " + id);
		
		// TODO
		switch (id) {
		
		// Correct loader, begin loading data from db.
		case LOADER_ID:
			return new CursorLoader(getActivity(),
									RetailDbContract.STORES_URI,
									RetailDbContract.RetailItem.PROJECTION_ALL,
									null,
									null,
									null);
		// Invalid loader
		default:
			return null;
		}
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

}
