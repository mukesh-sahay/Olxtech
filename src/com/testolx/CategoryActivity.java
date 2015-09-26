package com.testolx;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;

public class CategoryActivity extends Activity {

	int mLevel;
	ListView mListView;
	static String mArrayItems[];

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.category_activity);

		mLevel = getIntent().getIntExtra("level", -1);
		mListView = (ListView) findViewById(R.id.category_list_view);
		// I will pass each time which type of category I have to show.
		// Pass the category level
        mArrayItems = getResources().getStringArray(R.array.olx_item_list);
        mListView.setAdapter(new ListAdapter());
	}

	class ListAdapter extends BaseAdapter {

		public ListAdapter() {

		}

		@Override
		public int getCount() {
			return mArrayItems.length;
		}

		@Override
		public Object getItem(int position) {
			return mArrayItems[position];
		}

		@Override
		public long getItemId(int arg0) {
			return 0;
		}

		@Override
		public View getView(int arg0, View arg1, ViewGroup arg2) {

			
			return null;
		}
	}
}
