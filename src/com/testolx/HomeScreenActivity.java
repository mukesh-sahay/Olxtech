package com.testolx;

import java.io.FileNotFoundException;
import java.io.InputStream;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.testolx.bean.UploadDataBean;

public class HomeScreenActivity extends Activity {

	private View mImageContainer;
	private ImageView mImageView; 
	private static int SELECT_PHOTO = 1001;
    private UploadDataBean mUploadDataBean;
    private Button mSubmitButton = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home_screen);
		mImageContainer = findViewById(R.id.image_container);
		mImageContainer.setOnClickListener(clickListener);
		mImageView = (ImageView) findViewById(R.id.take_photo);
		mImageView.setOnClickListener(clickListener);
		mUploadDataBean = new UploadDataBean();
		
		mSubmitButton  = (Button)findViewById(R.id.submit);
	}

	View.OnClickListener clickListener = new View.OnClickListener() {

		@Override
		public void onClick(View view) {
			android.util.Log.i("LKN", " on click listener  ");
			if (view.getId() == R.id.image_container || mImageView.getId() == R.id.take_photo) {
				Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
				photoPickerIntent.setType("image/*");
				startActivityForResult(photoPickerIntent, SELECT_PHOTO);
			}

		}
	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.home_screen, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		if (requestCode == SELECT_PHOTO && resultCode == RESULT_OK) {
			try {
				android.util.Log.i("LKN", " on Activity Result");
				Intent imageReturnedIntent = data;
				final Uri imageUri = imageReturnedIntent.getData();
				final InputStream imageStream = getContentResolver()
						.openInputStream(imageUri);
				final Bitmap selectedImage = BitmapFactory
						.decodeStream(imageStream);
				mImageView.setImageBitmap(selectedImage);
				mUploadDataBean.setImage(imageUri.toString());	
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
}
