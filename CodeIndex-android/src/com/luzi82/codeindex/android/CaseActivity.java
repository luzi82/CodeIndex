package com.luzi82.codeindex.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.luzi82.codeindex.Case;

public class CaseActivity extends Activity {

	public static final String CASE_CLASS_NAME = "CASE_CLASS_NAME";

	String mInputCaseClassName;

	Class<?> mCaseClass;
	Case mCase;

	TextView mTextView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		try {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_case);

			mTextView = (TextView) findViewById(R.id.text_view);

			Intent intent = getIntent();
			mInputCaseClassName = intent.getCharSequenceExtra(CASE_CLASS_NAME).toString();

			mCaseClass = Class.forName(mInputCaseClassName);
			mCase = (Case) mCaseClass.newInstance();
			mCase.setListener(new Case.Listener() {
				@Override
				public void msg(final String aMsg) {
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							mTextView.append(aMsg + "\n");
						}
					});
				}
			});

			setTitle(mCaseClass.getSimpleName());

			new Thread(mCase).start();
		} catch (ClassNotFoundException e) {
			throw new Error(e);
		} catch (IllegalAccessException e) {
			throw new Error(e);
		} catch (InstantiationException e) {
			throw new Error(e);
		}
	}
}
