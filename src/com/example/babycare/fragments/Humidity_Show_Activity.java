package com.example.babycare.fragments;

import com.hardcopy.btchat.R;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.widget.CompoundButton;
import android.widget.Switch;

public class Humidity_Show_Activity extends Activity {

	Switch swc; 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.humidity_show_layout);
		
		
		final Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE); 
		long millisecond = 10000;  // 1√   
		long[] pattern = {1000, 200, 1000, 2000, 1200};
		vibrator.vibrate(pattern, 0);
		
		swc = (Switch) findViewById(R.id.switch2);
		swc.setOnCheckedChangeListener(new Switch.OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
				// TODO Auto-generated method stub
				String str = String.valueOf(arg1);
				if(arg1){
					vibrator.cancel();
					finish();
				}
			}
			
		});
	}
}
