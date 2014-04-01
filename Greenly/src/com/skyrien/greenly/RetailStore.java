/* This is a RetailStore class for Greenly
 * 
 */
package com.skyrien.greenly;

public class RetailStore {

	public static final String TAG = "RetailStore";
	
	// Variable properties of stores
	//private int mId; // Internal ID, may not be necessary
	private int mLicenseNum;
	private String mTradename;
	private String mStreetAddress;
	private String mSuite;
	private String mCity;
	private String mState;
	private String mCounty;
	private String mZipCode;
	private double mLatitude;
	private double mLongitude;
	private String mPhotoUrl;
	

	// This is the default constructor -- should be fixed later
	public RetailStore() {
		mLicenseNum = 0;
		mTradename = "Untitled";
		mStreetAddress = "";
		mSuite = "";
		mCity = "";
		mState = "";
		mCounty = "";
		mZipCode = "";
		mPhotoUrl = "";
	}
	
	// This is a instantiator constructor
	public RetailStore(
			int licenseNum,
			String tradename,
			String streetAddress,
			String city,
			String state,
			String county,
			String zipCode,
			String photoUrl) {

		setLicenseNum(licenseNum);
		setTradename(tradename);
		setStreetAddress(streetAddress);
		setCity(city);
		setState(state);
		setCounty(county);
		setZipCode(zipCode);
		setPhotoUrl(photoUrl);
	}
	
	// Auto-generated Getter/Setters
	public int getLicenseNum() {
		return mLicenseNum;
	}
	public void setLicenseNum(int licenseNum) {
		mLicenseNum = licenseNum;
	}
	public String getTradename() {
		return mTradename;
	}
	public void setTradename(String tradename) {
		mTradename = tradename;
	}
	public String getStreetAddress() {
		return mStreetAddress;
	}
	public void setStreetAddress(String streetAddress) {
		mStreetAddress = streetAddress;
	}
	public String getCity() {
		return mCity;
	}
	public void setCity(String city) {
		mCity = city;
	}
	public String getState() {
		return mState;
	}
	public void setState(String state) {
		mState = state;
	}
	public String getCounty() {
		return mCounty;
	}
	public void setCounty(String county) {
		mCounty = county;
	}
	public String getZipCode() {
		return mZipCode;
	}
	public void setZipCode(String zipCode) {
		mZipCode = zipCode;
	}
	public String getPhotoUrl() {
		return mPhotoUrl;
	}
	public void setPhotoUrl(String photoUrl) {
		mPhotoUrl = photoUrl;
	}

	public String getmSuite() {
		return mSuite;
	}

	public void setmSuite(String mSuite) {
		this.mSuite = mSuite;
	}

	public double getmLatitude() {
		return mLatitude;
	}

	public void setmLatitude(double mLatitude) {
		this.mLatitude = mLatitude;
	}

	public double getmLongitude() {
		return mLongitude;
	}

	public void setmLongitude(double mLongitude) {
		this.mLongitude = mLongitude;
	}	
	
}
