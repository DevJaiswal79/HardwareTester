package com.example.complete;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MainActivity extends Activity implements OnItemClickListener
{
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
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
    Intent intent;

	ListView lv;
	String[] items ={"Check Version Info","Proximity Sensor","Touch Sensor","Light Sensor","Battery Indicator"};
		@SuppressLint("SuspiciousIndentation")
		@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
        lv= findViewById(R.id.listView1);
	   ArrayAdapter<String> adapt= new ArrayAdapter<>(this, R.layout.extra, items);
            lv.setAdapter(adapt);
	        lv.setOnItemClickListener(this);
	        }
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int pos,long id) {
			// TODO Auto-generated method stub

				 
			 }
			
		}
		