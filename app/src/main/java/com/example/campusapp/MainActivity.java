package com.example.campusapp;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    float azimuth_angle;
    private SensorManager compassSensorManager;
    Sensor accelerometer;
    Sensor magnetometer;
    TextView tv_degrees;
    ImageView iv_compass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        compassSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        accelerometer = compassSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        magnetometer = compassSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);

    }

    protected void onResume() {

        super.onResume();
        mSensorManager.registerListener(this,accelerometer,SensorManager.SENSOR_DELAY_UI);
        mSensorManager.registerListener(this,magnetometer,SensorManager.SENSOR_DELAY_UI);
    }
protected void onPause() {

    super.onPause();
    mSensorManager.unregisterListener(this);
}
    float[] accel_read;
    float[] magnetic_read;

    @Override
    public void onSensorChanged(SensorEvent event) {
        tv_degrees = (TextView)findViewById(R.id.tv_degrees)
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}