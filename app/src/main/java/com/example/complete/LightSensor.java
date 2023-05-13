package com.example.complete;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class LightSensor extends Activity implements SensorEventListener {
	TextView tvx;
	SensorManager sensmgr;
	Sensor accsensor;
	float[] sensorvalues;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lightsensor);

		tvx = findViewById(R.id.textView51);

		sensmgr = (SensorManager) getSystemService(SENSOR_SERVICE);
		accsensor = sensmgr.getDefaultSensor(Sensor.TYPE_LIGHT);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.lightsensor, menu);
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

	@Override
	public void onSensorChanged(SensorEvent event) {
		sensorvalues = event.values;
		float x = sensorvalues[0];

		tvx.setText(getString(R.string.luxes, x));

	}

	@Override
	protected void onResume() {
		sensmgr.registerListener(this, accsensor,SensorManager.SENSOR_DELAY_NORMAL);

		super.onResume();
	}

	@Override
	protected void onPause() {
		sensmgr.unregisterListener(this);
		super.onPause();
	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub

	}
}
