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
	private static final String DATABASE_NAME = "greenly.db";
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
		Log.d(TAG,"GreenlyDb() constructor called.");
		
	}
	
	// Returns all stores -- THIS MUST RETURN A CURSOR LATER, NOT VOID
	public Cursor getStores() {
		Log.d(TAG,"getStores() called.");
		SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
		String[] sqlSelect = {"_id", "Tradename", "License"};
		String sqlTables = "stores";
		
		qb.setTables(sqlTables);
		Cursor c = qb.query(sInstance.getReadableDatabase(), sqlSelect,null,null,null,null,null);
		c.moveToFirst();
		return c;
	}
	
	public Cursor queryDb(String sqlTables, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
		Log.d(TAG,"queryDb() called.");
		SQLiteDatabase theDatabase = sInstance.getReadableDatabase();
		SQLiteQueryBuilder qb = new SQLiteQueryBuilder();			
		qb.setTables(sqlTables);
		Cursor c = qb.query(theDatabase, projection,selection,selectionArgs,null,null,sortOrder);
		c.moveToFirst();
		return c;
	}
	
}
