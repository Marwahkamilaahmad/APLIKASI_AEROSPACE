package com.example.mission;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.mission.databinding.ActivityBinaryBinding;

import java.util.ArrayList;

public class BinaryActivity extends AppCompatActivity {

    public ArrayList<Integer> biner = new ArrayList<>();

    public void numToBinary(int n) {
        if (n > 0) {
            biner.add(n % 2);
            numToBinary(n / 2);
        }
    }


    ActivityBinaryBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBinaryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.layout3.setVisibility(View.GONE);

        ArrayList<Integer> hasil = new ArrayList<>();

        binding.btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(binding.ambilNumber.getText().toString().equals("")){
                    CharSequence text = "Isi dahulu angkanya!";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(BinaryActivity.this, text, duration);
                    toast.show();
//                    Toast.makeText(getBaseContext(), "Isi dahulu angkanya", Toast.LENGTH_SHORT).show();
                }else{
                    binding.layout3.setVisibility(View.VISIBLE);
                    int number = Integer.parseInt(binding.ambilNumber.getText().toString());
                    numToBinary(number);

                for (int i = biner.size() - 1; i >= 0; i--) {
                    hasil.add(biner.get(i));
                }

                if(hasil.size() < 5){
                    int sisa = 5 - hasil.size();
                    for(int k = 0; k < sisa; k++){
                        hasil.add(k,0);
                    }
                }
//        System.out.print("Biner dari " + number + " adalah: ");

                for (int i = 0; i < hasil.size(); i++) {
                    System.out.print(hasil.get(i));
                }

                System.out.println("\n") ;

                for (int i = 0; i < hasil.size(); i++) {
                    switch (i) {
                        case 0:
                            if (hasil.get(i) == 1) {
                                binding.textAlarm1.setText("1. Terjadi kegagalan pada descent rate Container");
                            }else{
                                binding.textAlarm1.setText("1.");
                            }
                            break;
                        case 1:
                            if (hasil.get(i) == 1) {
                                binding.textAlarm2.setText("2. Terjadi kegagalan pada descent rate Science Payload");
                            }else{
                                binding.textAlarm2.setText("2.");
                            }
                            break;
                        case 2:
                            if (hasil.get(i) == 1) {
                                binding.textAlarm3.setText("3. Terjadi kegagalan data posisi Container");
                            }else{
                                binding.textAlarm3.setText("3.");
                            }
                            break;
                        case 3:
                            if (hasil.get(i) == 1) {
                                binding.textAlarm4.setText("4. Terjadi kegagalan data posisi Science Payload");
                            }else{
                                binding.textAlarm4.setText("4.");
                            }
                            break;
                        case 4:
                            if (hasil.get(i) == 1) {
                                binding.textAlarm5.setText("5. Terjadi kegagalan release/separasi");
                            }else{
                                binding.textAlarm5.setText("5.");
                            }
                            break;
                    }
                }



            } }
        });

        binding.btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.ambilNumber.setText("");
                binding.textAlarm1.setText("");
                binding.textAlarm2.setText("");
                binding.textAlarm3.setText("");
                binding.textAlarm4.setText("");
                binding.textAlarm5.setText("");

                biner.clear();
                hasil.clear();
            }

        });


    }
}