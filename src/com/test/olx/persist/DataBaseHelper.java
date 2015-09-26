package com.test.olx.persist;

import com.testolx.bean.UploadDataBean;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataBaseHelper extends SQLiteOpenHelper {

	private static int DB_VERSION = 1001;
	private static String DB_NAME = "test_olx.db";

	private static String TABLE_SELL_ITEM = "SELL_ITEM";

	private static String FIELD_TITLE = "tile";
	private static String FIELD_IMAGE = "image_uri";
	private static String FIELD_CATEGORY = "category";
	private static String FIELD_DESCRIPTION = "description";
	private static String FIELD_LOCATION = "location";
	private static String FIELD_LOCALITY = "locality";
	private static String FIELD_NAME = "name";
	private static String FIELD_EMAIL = "email";
	private static String FIELD_PHONE = "phone_number";
	private static String FIELD_UPLOADED = "upload_status";
	
	private static int UPLOADED_STATUS_FALSE = 1001;
	private static int UPLOADED_STATUS_TRUE = 1002;
	private static int UPLOADED_STATUS_SUCCESS = 1003;
	

	final String LIBRARY_DB_CREATE = "CREATE TABLE [" + TABLE_SELL_ITEM + "] ("
			+ "[id] TEXT  UNIQUE NOT NULL PRIMARY KEY,"
			+ "[title] TEXT  NOT NULL," + "[image_uri] teXT  NOT NULL,"
			+ "[category] teXT  NOT NULL," + "[location] teXT  NOT NULL,"
			+ "[locality] teXT  NOT NULL," + "[name] teXT  NOT NULL,"
			+ "[email] TEXT NOT NULL," + "[phone_number] NOT INTEGER  NULL," 
			+ "[upload_status] NOT INTEGER  NULL,"
			+ ")";

	SQLiteDatabase SELL_ITEM_DB = null;

	public DataBaseHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, DB_NAME, null, DB_VERSION);
		SELL_ITEM_DB = getWritableDatabase();
	}

	@Override
	public void onCreate(SQLiteDatabase sqlieDataBase) {

		SELL_ITEM_DB = sqlieDataBase;

		try {
			sqlieDataBase.execSQL(LIBRARY_DB_CREATE);
			Log.d(this.getClass().toString(), "musiclibrary created tables");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		sqlieDataBase.beginTransaction();

	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {

	}

	public boolean addSellItem(UploadDataBean uploadDataBean) {

		ContentValues itemValues = new ContentValues();
		itemValues.put(FIELD_TITLE,uploadDataBean.getTitle());
		itemValues.put(FIELD_IMAGE,uploadDataBean.getImage());
		itemValues.put(FIELD_CATEGORY,uploadDataBean.getCategory());
		itemValues.put(FIELD_DESCRIPTION,uploadDataBean.getDescription());
		itemValues.put(FIELD_LOCATION,uploadDataBean.getLocation());        
        itemValues.put(FIELD_LOCALITY,uploadDataBean.getLocality());
        itemValues.put(FIELD_NAME,uploadDataBean.getName());
        itemValues.put(FIELD_EMAIL,uploadDataBean.getEmail());
        itemValues.put(FIELD_PHONE,uploadDataBean.getPhoneNumber());
        itemValues.put(FIELD_UPLOADED,uploadDataBean.getUploadStatus());
		SELL_ITEM_DB.insertOrThrow(TABLE_SELL_ITEM, "", itemValues);
		return true;
	}
	
	public boolean updateItemUploadStatus(UploadDataBean uploadDataBean){
		
		
		return true;
	}
}