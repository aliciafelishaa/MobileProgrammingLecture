package com.example.session8;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnStartService, btnStopService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStartService = findViewById(R.id.btnStartBasicService);
        btnStartService.setOnClickListener(this);
        btnStopService = findViewById(R.id.btnStopBasicSevice);
        btnStopService.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()== R.id.btnStartBasicService){
            Intent serviceIntent = new Intent(this, CounterService.class);
            startService(serviceIntent);
        }else if(view.getId()== R.id.btnStopBasicSevice){
            Intent serviceIntent = new Intent(this, CounterService.class);
            stopService(serviceIntent);

        }
    }
}