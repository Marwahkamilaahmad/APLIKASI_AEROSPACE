package com.example.mission;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mission.databinding.ActivityTelemetryBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TelemetryActivity extends AppCompatActivity {

    ActivityTelemetryBinding binding;

    ArrayList<String[]> inputanKoma = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTelemetryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.textCode0.setVisibility(View.GONE);
        binding.textCode1.setVisibility(View.GONE);
        binding.textCode2.setVisibility(View.GONE);
        binding.textCode3.setVisibility(View.GONE);
        binding.textCode4.setVisibility(View.GONE);
        binding.textCode5.setVisibility(View.GONE);
        binding.textCode6.setVisibility(View.GONE);
        binding.textCode7.setVisibility(View.GONE);
        binding.textHasil0.setVisibility(View.GONE);
        binding.textHasil1.setVisibility(View.GONE);
        binding.textHasil2.setVisibility(View.GONE);
        binding.textHasil3.setVisibility(View.GONE);
        binding.textHasil4.setVisibility(View.GONE);
        binding.textHasil5.setVisibility(View.GONE);
        binding.textHasil6.setVisibility(View.GONE);
        binding.textHasil7.setVisibility(View.GONE);
        binding.btnHasil.setVisibility(View.GONE);
        binding.btnReset.setVisibility(View.GONE);

        binding.btnApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.textQuantity.getText().toString().equals("")) {
                    Toast.makeText(TelemetryActivity.this, "isi quantity dahulu", Toast.LENGTH_SHORT).show();
                } else {
                    binding.btnHasil.setVisibility(View.VISIBLE);
                    binding.btnReset.setVisibility(View.VISIBLE);
                    int quantity = Integer.parseInt(binding.textQuantity.getText().toString());
                    EditText[] editTexts = new EditText[quantity];
                    for (int i = 0; i < quantity; i++) {
                        int getResourceId = getResources().getIdentifier("textCode" + i, "id", getPackageName());
                        editTexts[i] = findViewById(getResourceId);
                        editTexts[i].setVisibility(View.VISIBLE);
                    }

                }
            }
        });


        binding.btnHasil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = binding.textIdTeam.getText().toString();
                int quantity = Integer.parseInt(binding.textQuantity.getText().toString());
                TextView[] viewTexts1 = new TextView[quantity];
                EditText[] editTexts1 = new EditText[quantity];
                for (int i = 0; i < quantity; i++) {
                    int getResourceId = getResources().getIdentifier("textCode" + i, "id", getPackageName());
                    editTexts1[i] = findViewById(getResourceId);
                    String input = editTexts1[i].getText().toString();

                    String[] parts = input.split(",");
                    inputanKoma.add(parts);

                    int getHasilId = getResources().getIdentifier("textHasil" + i, "id", getPackageName());
                    viewTexts1[i] = findViewById(getHasilId);
                    viewTexts1[i].setVisibility(View.VISIBLE);

                    for (String[] data : inputanKoma) {
                        String idTeam = data[0];
                        String clock = data[1];
                        String latitude = data[2];
                        String longitude = data[3];
                        String altitude = data[4];
                        String voltage = data[5];

                        if (idTeam.equals(id) &&
                                !latitude.trim().isEmpty() &&
                                !longitude.trim().isEmpty() &&
                                !voltage.trim().isEmpty() &&
                                !clock.trim().isEmpty() &&
                                voltage.endsWith(";")) {
                            viewTexts1[i].setText("VALID");
                        } else {
                            viewTexts1[i].setText("TIDAK");
                        }

                    }

                }



            }
        });

        binding.btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                binding.textCode0.setText("00403,12:32:17,7,110,500,12;");
                binding.textCode1.setText("00403,12:33:21,8,109,490,12;");
                binding.textCode2.setText("00404,12:33:49,7,109,490,12;");
                binding.textCode3.setText("00403,12:34:23,6,110,480,12;00");
                binding.textCode4.setText("00403, ,7,110,480,12;");
                binding.textCode5.setText("00403,12:35:32,7,111,480,12,15;");
                binding.textCode6.setText("");
                binding.textCode7.setText("");

                binding.textCode0.setVisibility(View.GONE);
                binding.textCode1.setVisibility(View.GONE);
                binding.textCode2.setVisibility(View.GONE);
                binding.textCode3.setVisibility(View.GONE);
                binding.textCode4.setVisibility(View.GONE);
                binding.textCode5.setVisibility(View.GONE);
                binding.textCode6.setVisibility(View.GONE);
                binding.textCode7.setVisibility(View.GONE);
                binding.btnReset.setVisibility(View.GONE);
                binding.btnHasil.setVisibility(View.GONE);

                binding.textHasil0.setText("");
                binding.textHasil1.setText("");
                binding.textHasil2.setText("");
                binding.textHasil3.setText("");
                binding.textHasil4.setText("");
                binding.textHasil5.setText("");
                binding.textHasil6.setText("");
                binding.textHasil7.setText("");


                inputanKoma.clear();
                binding.textQuantity.setText("");
                binding.textIdTeam.setText("");


            }
        });



}}