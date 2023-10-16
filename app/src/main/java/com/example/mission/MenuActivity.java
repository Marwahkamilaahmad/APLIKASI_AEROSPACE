package com.example.mission;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.mission.databinding.ActivityMenuBinding;

public class MenuActivity extends AppCompatActivity {


    ActivityMenuBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMenuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.buttonAlarm.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, BinaryActivity.class));
            }
        });

        binding.buttonPathfinding.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, MainActivity.class));
            }
        });
        binding.buttonTelemetry.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, TelemetryActivity.class));
            }
        });


    }
}