package com.fastdev.demo.imageloader;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import com.fastdev.R;

public class AndroidUniversalImageLoader extends AppCompatActivity {

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.image_loader_grid);

		GridView mGridView = (GridView) findViewById(R.id.image_grid);
		mGridView.setAdapter(new GridAdapter(this, getResources()
				.getStringArray(R.array.image_loader)));
		mGridView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				switch (position) {
				case 0:
					intent.setClass(AndroidUniversalImageLoader.this,
							BigImageListActivity.class);
					break;
				case 1:
					intent.setClass(AndroidUniversalImageLoader.this,
							GridImageListActivity.class);
					break;
				case 2:
					intent.setClass(AndroidUniversalImageLoader.this,
							SmallImageListActivity.class);
					break;
				default:
					break;
				}
				startActivity(intent);
			}
		});
	}

	public class GridAdapter extends BaseAdapter {

		LayoutInflater mInflater;
		String[] mData;

		public GridAdapter(Context context, String[] data) {
			// TODO Auto-generated constructor stub
			mData = data;
			mInflater = LayoutInflater.from(context);
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			if (mData == null)
				return 0;

			return mData.length;
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			ViewHolder holder;
			if (convertView == null) {
				holder = new ViewHolder();
				convertView = mInflater.inflate(R.layout.grid_item_one_text,
						null);
				holder.mTextView = (TextView) convertView
						.findViewById(R.id.grid_text);
				convertView.setTag(holder);
			} else {
				holder = (ViewHolder) convertView.getTag();
			}

			holder.mTextView.setText(mData[position]);
			return convertView;
		}
	}

	class ViewHolder {
		TextView mTextView;
	}
}
