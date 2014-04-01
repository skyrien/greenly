package com.skyrien.greenly;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.util.Log;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class GreenlyDb extends SQLiteAssetHelper {
	public static final String TAG = "GreenlyDb";
	
	// SQLiteAssetHelper required enums
	private static final String DATABASE_NAME = "greenlyDb";
	private static final int DATABASE_VERSION = 1;
	
	// Only one static instance, accessible by getInstance()
	private static GreenlyDb sInstance;
	
	// This ensures that only one static instance is created for the DB.
	public static GreenlyDb getInstance(Context context) {
		Log.d(TAG,"getInstance() called.");
		if (sInstance == null) {
			sInstance = new GreenlyDb(context);
		}
		return sInstance;
	}
	
	// This is the basic constructor -- we've made it private so only
	// GetInstance() can call it
	private GreenlyDb(Context context) {
		super(context,DATABASE_NAME, null, DATABASE_VERSION);
		Log.d(TAG,"GreenlyDb() called.");
		
	}
	
	// Returns all stores -- THIS MUST RETURN A CURSOR LATER, NOT VOID
	public Cursor getStores() {
		SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
		String[] sqlSelect = {"0 _id", "Tradename"};
		String sqlTables = "retail";
		
		qb.setTables(sqlTables);
		Cursor c = qb.query(sInstance.getReadableDatabase(), sqlSelect,null,null,null,null,null);
		c.moveToFirst();
		return c;
	}
	
}
