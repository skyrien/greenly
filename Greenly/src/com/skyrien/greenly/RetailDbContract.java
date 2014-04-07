package com.skyrien.greenly;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

// INCOMPLETE
public final class RetailDbContract {
	
	public static final String AUTHORITY = "com.skyrien.greenly.RetailProvider";
	static String BASE_PATH = "stores";
	public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY);
	public static final Uri STORES_URI = Uri.parse("content://" + AUTHORITY + "/" + BASE_PATH);
	
	
	// Empty constructor that returns itself
	public RetailDbContract() { }
		
	// This RetailItems class defines the column names that can be
	// part of a retail item.
	public static abstract class RetailItem implements BaseColumns {
		public static final String TRADENAME = "Tradename";
		public static final String LICENSE = "License";
		public static final String STREETADDRESS = "StreetAddress";
		public static final String SUITE = "SuiteRm";
		public static final String CITY = "City";
		public static final String COUNTY = "County";
		public static final String ZIPCODE = "ZipCode";
		public static final String LATITUDE = "Latitude";
		public static final String LONGITUDE = "Longitude";
		
		public static final Uri CONTENT_URI = Uri.withAppendedPath(RetailDbContract.CONTENT_URI, "stores");
		public static final String[] PROJECTION_ALL = {_ID, TRADENAME, LICENSE, STREETADDRESS, SUITE, CITY,
																	COUNTY, ZIPCODE, LATITUDE, LONGITUDE};
		
		// MIME TYPES for these items
		public static final String RETAIL_LIST_MIME_TYPE =
				ContentResolver.CURSOR_DIR_BASE_TYPE + "/vnd.com.skyrien.greenly_stores";
		public static final String RETAIL_STORE_MIME_TYPE =
				ContentResolver.CURSOR_ITEM_BASE_TYPE + "/vnd.com.skyrien.greenly_stores";
		
		public static final String SORT_ORDER_DEFAULT = TRADENAME + " ASC";
	}

	

}
