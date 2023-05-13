package com.example.complete;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class SystemInfo extends Activity {
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.systeminfo, menu);
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
TextView t1,t2,t3,t4,t5,t6,t7,t8,t9;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_systeminfo);
		t1= findViewById(R.id.textView1a);
		t2= findViewById(R.id.textView2a);
		t3= findViewById(R.id.textView3a);
		t4= findViewById(R.id.textView4a);
		t5= findViewById(R.id.textView5a);
		t6= findViewById(R.id.textView6a);
		t7= findViewById(R.id.textView7a);
		t8= findViewById(R.id.textView8a);
		t9= findViewById(R.id.textView9a);
	}
	@Override
		protected void onStart() {
		String release = Build.VERSION.RELEASE;
	    int sdkVersion = Build.VERSION.SDK_INT;
	    String q=Build.VERSION.CODENAME;
	    String t=Build.VERSION.INCREMENTAL;
	    String m=Build.BOARD;
	    
	    String h=Build.BOOTLOADER;
	    String j=Build.BRAND;
	    String k=Build.DEVICE;
	    
	    String z=Build.HARDWARE;
	    
	    String c=Build.MANUFACTURER;
	    String b=Build.SERIAL;
		t3.setText(getString(R.string.board, m));
		t4.setText(getString(R.string.bootloader, h));
		t5.setText(getString(R.string.brand, j));
		t6.setText(getString(R.string.design, k));
		t7.setText(getString(R.string.kernel, z));
		t8.setText(getString(R.string.manufacturer, c));
		t9.setText(getString(R.string.serial, b));

		t2.setText(getString(R.string.build_no, t));
		t1.setText(getString(R.string.sdk, sdkVersion, q, release));
			super.onStart();

	}
}
	
