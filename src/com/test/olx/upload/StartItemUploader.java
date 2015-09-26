package com.test.olx.upload;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

public class StartItemUploader extends Service{

	Context mStartItemUploaderServiceContext;
	@Override
	public void onCreate() {
		super.onCreate();		
		mStartItemUploaderServiceContext = getApplicationContext();
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Thread newthread = new Thread(new UploaderThread());
		newthread.start();
		return START_STICKY;
	}

	@Override
	public IBinder onBind(Intent arg0) {

		return null;
	}
	
	class UploaderThread implements Runnable{
		public UploaderThread() {

		}
		@Override
		public void run() {
			
			// retrieve the upload item's from the db 
			// upload one by one 
			
			Intent intent = new Intent();
			intent.setClass(mStartItemUploaderServiceContext, StartItemUploader.class);
			mStartItemUploaderServiceContext.stopService(intent);
			
			
		}
	}
}