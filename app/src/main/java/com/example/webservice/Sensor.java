package com.example.webservice;

import android.content.Context;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.RequiresApi;

import java.util.List;

public class Sensor extends MainActivity {
    private SensorManager sensorManager;
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        List<android.hardware.Sensor> sensores = sensorManager.getSensorList(android.hardware.Sensor.TYPE_ALL);
        sensores.forEach(sensor -> {
            Log.i("SENSORES", sensor.toString());
        });
    }
}
