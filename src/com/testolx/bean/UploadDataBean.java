package com.testolx.bean;

import java.util.ArrayList;

public class UploadDataBean {

	private String title;
	private String mImage;
	private String mCategory;
	private String mDescription;
	private String mLocation;
	private String mLocality;
	private String mName;
	private String mEmail;
	private String mPhoneNumber;
	private int mUploadStatus;

	public int getUploadStatus() {
		return mUploadStatus;
	}

	public void setUploadStatus(int uploadStatus) {
		this.mUploadStatus = uploadStatus;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImage() {
		return mImage;
	}

	public void setImage(String image) {
		this.mImage = image;
	}

	public String getCategory() {
		return mCategory;
	}

	public void setCategory(String mCategory) {
		this.mCategory = mCategory;
	}

	public String getDescription() {
		return mDescription;
	}

	public void setDescription(String mDescription) {
		this.mDescription = mDescription;
	}

	public String getLocation() {
		return mLocation;
	}

	public void setLocation(String mLocation) {
		this.mLocation = mLocation;
	}

	public String getLocality() {
		return mLocality;
	}

	public void setLocality(String mLocality) {
		this.mLocality = mLocality;
	}

	public String getName() {
		return mName;
	}

	public void setName(String mName) {
		this.mName = mName;
	}

	public String getEmail() {
		return mEmail;
	}

	public void setEmail(String mEmail) {
		this.mEmail = mEmail;
	}

	public String getPhoneNumber() {
		return mPhoneNumber;
	}

	public void setPhoneNumber(String mPhoneNumber) {
		this.mPhoneNumber = mPhoneNumber;
	}
}