/*
 * Copyright (C) 2014 Bluetooth Connection Template
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.babycare.fragments;

import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.example.babycare.utils.AppSettings;
import com.hardcopy.btchat.R;

public class ExampleFragment extends Fragment {

	private Context mContext = null;
	private IFragmentListener mFragmentListener = null;
	private Handler mActivityHandler = null;
	TextView test;
	String text;
	char temp;
	ToggleButton temper = null;
	ToggleButton humidity = null;
	ToggleButton crying = null;
	ToggleButton turnover = null;
	AlarmManager mAlarmMgr;
	static int temper_count =0;

	public ExampleFragment(Context c, IFragmentListener l, Handler h) {
		mContext = c;
		mFragmentListener = l;
		mActivityHandler = h;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.setting_layout, container, false);
		
		mAlarmMgr = (AlarmManager)getActivity().getSystemService(mContext.ALARM_SERVICE);
		
		test = (TextView) rootView.findViewById(R.id.test1);
		
		//AppSettings.setSettingsValue(AppSettings.SETTINGS_BACKGROUND_SERVICE, isChecked, 0, null);
		mFragmentListener.OnFragmentCallback(IFragmentListener.CALLBACK_RUN_IN_BACKGROUND, 0, 0, null, null,null);
		
		temper = (ToggleButton) rootView.findViewById(R.id.toggleButton1);
		temper.setChecked(AppSettings.getTpService());
		temper.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				AppSettings.setSettingsValue(AppSettings.SETTINGS_TEMPER_SERVICE, isChecked, 0, null);
				if(isChecked){
					String message = "37";
					 if(message != null && message.length() > 0)
				        	sendMessage(message);
					 TemperDialogRadio();
				}
				else{
					String message = "44";
					 if(message != null && message.length() > 0)
				        	sendMessage(message);
					 
				}
				
			}
		});
		
		humidity = (ToggleButton) rootView.findViewById(R.id.toggleButton2);
		humidity.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if(isChecked){
					String message = "90";
					 if(message != null && message.length() > 0)
				        	sendMessage(message);
				}
				else{
					String message = "91";
					 if(message != null && message.length() > 0)
				        	sendMessage(message);
				}
				
			}
		});
		
		
		crying = (ToggleButton) rootView.findViewById(R.id.toggleButton3);
		crying.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if(isChecked){
					String message = "60";
					 if(message != null && message.length() > 0)
				        	sendMessage(message);
					 CryingDialogRadio();
				}
				else{
					String message = "65";
					 if(message != null && message.length() > 0)
				        	sendMessage(message);
				}
				
			}
		});
		
		turnover = (ToggleButton) rootView.findViewById(R.id.toggleButton4);
		turnover.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if(isChecked){
					String message = "70";
					 if(message != null && message.length() > 0)
				        	sendMessage(message);
					 CryingDialogRadio();
				}
				else{
					String message = "71";
					 if(message != null && message.length() > 0)
				        	sendMessage(message);
				}
				
			}
		});
		
		return rootView;
	}
	
	private void setAlarm(Context context, long second){  
        Log.i("TAG", "setAlarm()"); 
        AlarmManager alarmManager = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
 
        Intent Intent = new Intent(getActivity(), Temper_Show_Activity.class);
        PendingIntent pIntent = PendingIntent.getActivity(getActivity(), 0, Intent, 0);
         
        alarmManager.set(AlarmManager.RTC, System.currentTimeMillis(), pIntent);
        Log.i("TAG", "setAlarm()");
    }
	
	private void TemperDialogRadio(){
		final CharSequence[] temperkind = {"38¡É","38.5¡É","39¡É","39.5¡É","40¡É","40.5¡É"};
		AlertDialog.Builder alt_bld = new AlertDialog.Builder(mContext);
		alt_bld.setSingleChoiceItems(temperkind, -1, new OnClickListener() {
			String message;
			public void onClick(DialogInterface dialog, int which) {
				switch(which) {
				case 0:
					message = "38";
					 if(message != null && message.length() > 0)
				        	sendMessage(message);
					break;
				case 1:
					message = "39";
					 if(message != null && message.length() > 0)
				        	sendMessage(message);
					break;
				case 2:
					message = "40";
					 if(message != null && message.length() > 0)
				        	sendMessage(message);
					break;
				case 3:
					message = "41";
					 if(message != null && message.length() > 0)
				        	sendMessage(message);
					break;
				case 4:
					message = "42";
					 if(message != null && message.length() > 0)
				        	sendMessage(message);
					break;
				case 5:
					message = "43";
					 if(message != null && message.length() > 0)
				        	sendMessage(message);
					break;	
				default:
					break;
				}
				dialog.cancel();
			}
		});
		AlertDialog alert = alt_bld.create();
		alert.show();
	}
	
	
	private void CryingDialogRadio(){
		final CharSequence[] temperkind = {"µÐÇÔ","º¸Åë","¿¹¹Î"};
		AlertDialog.Builder alt_bld = new AlertDialog.Builder(mContext);
		alt_bld.setSingleChoiceItems(temperkind, -1, new OnClickListener() {
			String message;
			
			public void onClick(DialogInterface dialog, int which) {
				switch(which) {
				case 0:
					message = "61";
					 if(message != null && message.length() > 0)
				        	sendMessage(message);
					break;
				case 1:
					message = "62";
					 if(message != null && message.length() > 0)
				        	sendMessage(message);
					break;
				case 2:
					message = "63";
					 if(message != null && message.length() > 0)
				        	sendMessage(message);
					break;
				}
				dialog.cancel();
			}
		});
		AlertDialog alert = alt_bld.create();
		alert.show();
	}
	
 // Sends user message to remote
    private void sendMessage(String message) {
    	if(message == null || message.length() < 1)
    		return;
    	// send to remote
    	if(mFragmentListener != null)
    		mFragmentListener.OnFragmentCallback(IFragmentListener.CALLBACK_SEND_MESSAGE, 0, 0, message, null,null);
    	else
    		return;
    	// show on text view
    	test.setText(message);
    	
    }
    
    private static final int NEW_LINE_INTERVAL = 1000;
    private long mLastReceivedTime = 0L;
    
    // Show messages from remote
    public void showMessage(String message) {
    	
    	if(message != null && message.length() > 0) {
    		long current = System.currentTimeMillis();
    		
    		if(current - mLastReceivedTime > NEW_LINE_INTERVAL) {
    			temp = 0;
    		}
    		
    		if(message.toString().equals("a")||message.toString().equals("b")||message.toString().equals("c")
					||message.toString().equals("d")||message.toString().equals("e")||message.toString().equals("f")){
        		temp = 34;
			}
			else if(message.toString().equals("g")||message.toString().equals("h")||message.toString().equals("i")){
				temp = 60;
			}
			else if(message.toString().equals("j")){
				temp = 70;
			}
			else if(message.toString().equals("k")){
				temp = 90;
			}
    		
			
    		if(temp==34){
    			Intent i = new Intent(getActivity(),Temper_Show_Activity.class);
    			startActivity(i);	
    		}
    		else if(temp==60){
    			Intent i = new Intent(getActivity(),Crying_Show_Activity.class);
				startActivity(i);
    		}
    		else if(temp==70){
    			Intent i = new Intent(getActivity(),TurnOver_Show_Activity.class);
				startActivity(i);
    		}
    		else if(temp==90){
    			Intent i = new Intent(getActivity(),Humidity_Show_Activity.class);
				startActivity(i);
    		}
    		test.setText(message);	
        }
    }
    
}