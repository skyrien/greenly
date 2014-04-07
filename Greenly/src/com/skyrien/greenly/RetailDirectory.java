/* The RetailDirectory facilitates instantiating
 * the Retail Store data from an entity.
 * It allows for easy adding, searching, removing
 * data from the list.
 */

package com.skyrien.greenly;

import java.util.ArrayList;

import android.content.Context;

public class RetailDirectory {
	private ArrayList<RetailStore> mStores;
	
	private static RetailDirectory sRetailDirectory;
	private Context mAppContext;
	
	// This is the most used Constructor, and will generate
	// test data for now.
	private RetailDirectory(Context appContext) {
		mAppContext = appContext;
		mStores = new ArrayList<RetailStore>();
		
		// TEST DATA -- REMOVE IT LATER
		for (int i = 0; i < 100; i++) {
			RetailStore s = new RetailStore();
			s.setLicenseNum(i);
			s.setStreetAddress("210 E Blaine St");
			s.setCity("Seattle");
			s.setCounty("King");
			s.setTradename("Untitled 420 Store");
			s.setState("WA");
			
			// This adds it to the array
			mStores.add(s);
		}
	}
	
	public static RetailDirectory get(Context c) {
		if (sRetailDirectory == null) {
			sRetailDirectory = new RetailDirectory(c.getApplicationContext());
		}
		return sRetailDirectory;
	}
	
	public ArrayList<RetailStore> getStores() {
		return mStores;
	}
	
	public RetailStore getStore(int licenseNum) {
		for (RetailStore s : mStores) {
			if (s.getLicenseNum() == licenseNum)
				return s;
		}
		return null;
	}
	
}
