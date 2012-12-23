package com.luzi82.codeindex.android;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

import android.app.ListActivity;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.luzi82.codeindex.ByteArrayCopy;
import com.luzi82.codeindex.CaseList;

public class MainActivity extends ListActivity {

	private LinkedList<Class<?>> mCaseList;
	private LayoutInflater mInflater;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		configTestCase();
		mCaseList = CaseList.getList();
		Collections.sort(mCaseList, new Comparator<Class<?>>() {
			@Override
			public int compare(Class<?> lhs, Class<?> rhs) {
				return lhs.getName().compareTo(rhs.getName());
			}
		});
		mInflater = LayoutInflater.from(this);
		setListAdapter(new ListAdapter() {

			@Override
			public void unregisterDataSetObserver(DataSetObserver observer) {
			}

			@Override
			public void registerDataSetObserver(DataSetObserver observer) {
			}

			@Override
			public boolean isEmpty() {
				return mCaseList.isEmpty();
			}

			@Override
			public boolean hasStableIds() {
				return true;
			}

			@Override
			public int getViewTypeCount() {
				return 1;
			}

			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				Class<?> c = mCaseList.get(position);
				if (convertView == null) {
					convertView = mInflater.inflate(android.R.layout.simple_list_item_1, parent, false);
				}
				TextView tv = (TextView) convertView.findViewById(android.R.id.text1);
				tv.setText(c.getSimpleName());
				return convertView;
			}

			@Override
			public int getItemViewType(int position) {
				return 0;
			}

			@Override
			public long getItemId(int position) {
				return position;
			}

			@Override
			public Object getItem(int position) {
				return mCaseList.get(position);
			}

			@Override
			public int getCount() {
				return mCaseList.size();
			}

			@Override
			public boolean isEnabled(int position) {
				return true;
			}

			@Override
			public boolean areAllItemsEnabled() {
				return true;
			}
		});
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		Class<?> c = mCaseList.get(position);
		Intent intent = new Intent(this, CastActivity.class);
		intent.putExtra(CastActivity.CASE_CLASS_NAME, c.getName());
		startActivity(intent);
	}

	private void configTestCase() {
		ByteArrayCopy.CASE_DATA = new int[] { 10000, 100000, 1000000 };
	}

}
