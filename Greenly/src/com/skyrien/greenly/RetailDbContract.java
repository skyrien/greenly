package com.skyrien.greenly;

import android.provider.BaseColumns;

// INCOMPLETE
public final class RetailDbContract {
	
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
			
	}

	

}
