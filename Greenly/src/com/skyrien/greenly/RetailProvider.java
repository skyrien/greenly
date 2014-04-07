package com.skyrien.greenly;

import com.skyrien.greenly.RetailDbContract.RetailItem;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;

public class RetailProvider extends ContentProvider {
	public static final String TAG = "RetailProvider";
	
	// Some helper constants
	private static final int RETAIL_LIST = 1;
	private static final int RETAIL_STORE = 2;
	private static UriMatcher URI_MATCHER;
	private static GreenlyDb greenlyDb;
	
	static {
		URI_MATCHER = new UriMatcher(UriMatcher.NO_MATCH);
		URI_MATCHER.addURI(RetailDbContract.AUTHORITY, "stores", RETAIL_LIST);
		URI_MATCHER.addURI(RetailDbContract.AUTHORITY, "stores/#", RETAIL_STORE);
	}

	@Override
	public int delete(Uri arg0, String arg1, String[] arg2) {
		Log.d(TAG,"delete() called");
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getType(Uri uri) {
		Log.d(TAG,"getType() called");
		// TODO Auto-generated method stub
		switch (URI_MATCHER.match(uri)) {
		case RETAIL_LIST:
			return RetailItem.RETAIL_LIST_MIME_TYPE;
		case RETAIL_STORE:
			return RetailItem.RETAIL_STORE_MIME_TYPE;
		default:  
			throw new IllegalArgumentException("Unsupported URI: " + uri);
		}
	}

	@Override
	public Uri insert(Uri arg0, ContentValues arg1) {
		Log.d(TAG,"insert() called");
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean onCreate() {
		Log.d(TAG,"onCreate() called");
		greenlyDb = GreenlyDb.getInstance(getContext());		
		return true;
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs,
			String sortOrder) {
		Log.d(TAG,"query() called with: " + uri.toString());
		greenlyDb = GreenlyDb.getInstance(getContext());
		
		switch (URI_MATCHER.match(uri)) {
		case RETAIL_LIST:
			Log.d(TAG,"query uri was for RETAIL_LIST");
			return greenlyDb.queryDb("stores", projection, selection, selectionArgs, sortOrder);
		case RETAIL_STORE:
			Log.d(TAG,"query uri was for RETAIL_STORE");
			return greenlyDb.queryDb("stores", projection, selection, selectionArgs, sortOrder);
		default: throw new IllegalArgumentException("Unsupported URI: " + uri);
		}

	}

	@Override
	public int update(Uri arg0, ContentValues arg1, String arg2, String[] arg3) {
		Log.d(TAG,"update() called");
		// TODO Auto-generated method stub
		return 0;
	}

}
