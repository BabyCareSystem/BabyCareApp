package com.example.babycare.fragments;

import com.example.babycare.utils.AppSettings;
import com.hardcopy.btchat.R;
import com.hardcopy.btchat.R.id;
import com.hardcopy.btchat.R.layout;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.TextView;

public class LLSettingsFragment extends Fragment {

	private Context mContext = null;
	private IFragmentListener mFragmentListener = null;
	
	private CheckBox mCheckBackground;
	private TextView mTextIot;
	

	public LLSettingsFragment(Context c, IFragmentListener l) {
		mContext = c;
		mFragmentListener = l;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		AppSettings.initializeAppSettings(mContext);
		
		View rootView = inflater.inflate(R.layout.fragment_settings, container, false);
		
		// 'Run in background' setting
		mCheckBackground = (CheckBox) rootView.findViewById(R.id.check_background_service);
		mCheckBackground.setChecked(AppSettings.getBgService());
		mCheckBackground.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				AppSettings.setSettingsValue(AppSettings.SETTINGS_BACKGROUND_SERVICE, isChecked, 0, null);
				mFragmentListener.OnFragmentCallback(IFragmentListener.CALLBACK_RUN_IN_BACKGROUND, 0, 0, null, null,null);
			}
		});
		
		mTextIot = (TextView) rootView.findViewById(R.id.text_iot_guide);
		
		return rootView;
	}
	
	
}
