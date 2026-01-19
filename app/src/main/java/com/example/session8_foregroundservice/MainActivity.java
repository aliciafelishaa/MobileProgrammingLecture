package com.example.session8_foregroundservice;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View

        .OnClickListener{

    Button btnStartForeground, btnStopForeground;
    boolean isRunning = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnStartForeground = findViewById(R.id.btnStartForegroundService);
        btnStartForeground.setOnClickListener(this);
        btnStopForeground = findViewById(R.id.btnStopForegroundService);
        btnStopForeground.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnStartForegroundService){
            if(isRunning == false){
                Intent serviceIntent = new Intent(this, MyForegroundService.class);
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                    startForegroundService(serviceIntent);
                    Toast.makeText(this, " Start FG Service on 0 or above", Toast.LENGTH_SHORT).show();
                }else{
                    startService(serviceIntent);
                    Toast.makeText(this, " Start FG Service on below 0", Toast.LENGTH_SHORT).show();
                }

                isRunning = true;
            }
        }else if(view.getId() == R.id.btnStopForegroundService){
            if(isRunning){
                Intent serviceIntent = new Intent(this, MyForegroundService.class);
                stopService(serviceIntent);
                isRunning = false;
                Toast.makeText(this, "FG Service Stopped", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "FG Service is not running", Toast.LENGTH_SHORT).show();
            }
        }
    }
}