package com.example.complete;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class ProximitySensor extends Activity implements SensorEventListener{
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.proximity_sensor, menu);
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
	private SensorManager sensorManager;
	 TextView tVProximity;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_proximity_sensor);
		
	
		 tVProximity = findViewById(R.id.tVProximity);
		  sensorManager= (SensorManager)getSystemService(Context.SENSOR_SERVICE);
		  Sensor proximitySensor= sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
		  if (proximitySensor == null){
		   Toast.makeText(ProximitySensor.this,"No Proximity Sensor Found! ",Toast.LENGTH_LONG).show();
		  }
		 }
		 
		 @Override
		 protected void onResume() {
		  super.onResume();
		  sensorManager.registerListener(this,
		    sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY),
		    SensorManager.SENSOR_DELAY_NORMAL);
		 }
		 @Override
		 protected void onPause() {
		  // unregister listener
		  super.onPause();
		  sensorManager.unregisterListener(this);
		 }
		 @Override
		 public void onAccuracyChanged(Sensor sensor, int accuracy) {
		 
		 }
		 @Override
		 public void onSensorChanged(SensorEvent event) {
		  if(event.sensor.getType()==Sensor.TYPE_PROXIMITY){
			  if(event.values[0]==0){
				  tVProximity.setText(getString(R.string.near, String.valueOf(event.values[0])));
			  } else {
				  tVProximity.setText(getString(R.string.far, String.valueOf(event.values[0])));
			  }
		    
		  }}
		}
