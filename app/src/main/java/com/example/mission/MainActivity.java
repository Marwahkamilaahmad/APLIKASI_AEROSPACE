package com.example.mission;

import android.os.Bundle;
        import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
        import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
        import androidx.appcompat.app.AppCompatActivity;

import com.example.mission.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    public  ArrayList<Dictionary> kumpulan = new ArrayList<>();
    public static double totalJarak = 0;
    public double jarakTerdekat1 = Double.MAX_VALUE ;
    public double jarakTerdekat = Double.MAX_VALUE;
    public Dictionary<String, Integer> koordinatTerdekat = null;
    public int indeksJarakTerdekat = -1;
    public String pilihRintangan;



    public double hitungJarak(Dictionary<String,Integer> a, Dictionary<String,Integer> b) {
        int titikX2 = a.get("X");
        int titikY2 = a.get("Y");

        int titikX = b.get("X");
        int titikY = b.get("Y");


        return Math.sqrt(Math.pow(titikX2 - titikX, 2) + Math.pow(titikY2 - titikY, 2));
    }

    public double cekTotalJarak( ArrayList<Dictionary> kumpulan, Dictionary<String,Integer> koordinatTerdekat){
        for (int c = 0; c < kumpulan.size(); c++) {
            double jarakSF = hitungJarak(koordinatTerdekat, kumpulan.get(c));
            if (jarakSF < jarakTerdekat) {
                jarakTerdekat = jarakSF;
                indeksJarakTerdekat = c;
            }
        }

        if (indeksJarakTerdekat != -1) {
            this.koordinatTerdekat = kumpulan.get(indeksJarakTerdekat);
            totalJarak += jarakTerdekat;
        }
        kumpulan.remove(this.koordinatTerdekat);

        return totalJarak;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.layoutA1.setVisibility(View.GONE);
        binding.layoutB1.setVisibility(View.GONE);
        binding.layoutA2.setVisibility(View.GONE);
        binding.layoutB2.setVisibility(View.GONE);

        binding.btnCalculate.setVisibility(View.GONE);

        Spinner spinner = (Spinner) findViewById(R.id.spinner_rintangan);
        ArrayAdapter<CharSequence> adapterRintangan = ArrayAdapter.createFromResource(this,
              R.array.pilihanRintangan   , android.R.layout.simple_spinner_item);
        adapterRintangan.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapterRintangan);

        binding.spinnerRintangan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                pilihRintangan = parent.getItemAtPosition(position).toString();

                if(pilihRintangan.equals("1")){
                    binding.layoutA1.setVisibility(View.VISIBLE);
                    binding.layoutB1.setVisibility(View.VISIBLE);
                    binding.btnCalculate.setVisibility(View.VISIBLE);
                    binding.layoutA2.setVisibility(View.GONE);
                    binding.layoutB2.setVisibility(View.GONE);
                    binding.textA2x.setText("");
                    binding.textA2y.setText("");
                    binding.textB2x.setText("");
                    binding.textB2y.setText("");


                }
                if(pilihRintangan.equals("2")){
                    binding.layoutA1.setVisibility(View.VISIBLE);
                    binding.layoutB1.setVisibility(View.VISIBLE);
                    binding.layoutA2.setVisibility(View.VISIBLE);
                    binding.layoutB2.setVisibility(View.VISIBLE);
                    binding.btnCalculate.setVisibility(View.VISIBLE);
                }
            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        binding.btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int rintangan = Integer.parseInt(pilihRintangan);
                if(rintangan == 1){
                    Dictionary<String, Integer> s= new Hashtable<>();
                    s.put("X", Integer.parseInt(binding.textSx.getText().toString()));
                    s.put("Y", Integer.parseInt(binding.textSy.getText().toString()));

                    Dictionary<String, Integer> a1= new Hashtable<>();
                    a1.put("X", Integer.parseInt(binding.textA1x.getText().toString()));
                    a1.put("Y", Integer.parseInt(binding.textA1y.getText().toString()));

                    Dictionary<String, Integer> b1= new Hashtable<>();
                    b1.put("X", Integer.parseInt(binding.textB1x.getText().toString()));
                    b1.put("Y", Integer.parseInt(binding.textB1y.getText().toString()));

                    Dictionary<String, Integer> f= new Hashtable<>();
                    f.put("X", Integer.parseInt(binding.textFx.getText().toString()));
                    f.put("Y", Integer.parseInt(binding.textFy.getText().toString()));

                    kumpulan.add(a1);
                    kumpulan.add(f);
                    kumpulan.add(b1);


                    totalJarak = cekTotalJarak(kumpulan, s);
                    for (int e = 0; e < rintangan; e++) {
                        totalJarak = cekTotalJarak(kumpulan, koordinatTerdekat);
                    };
                    binding.hasilText.setText(String.valueOf(totalJarak));
                    koordinatTerdekat.remove(a1);
                    koordinatTerdekat.remove(f);
                    koordinatTerdekat.remove(b1);
                    koordinatTerdekat.remove(s);
                    kumpulan.clear();
                }
                else if (rintangan == 2){

                    Dictionary<String, Integer> s= new Hashtable<>();
                    s.put("X", Integer.parseInt(binding.textSx.getText().toString()));
                    s.put("Y", Integer.parseInt(binding.textSy.getText().toString()));

                    Dictionary<String, Integer> a1= new Hashtable<>();
                    a1.put("X", Integer.parseInt(binding.textA1x.getText().toString()));
                    a1.put("Y", Integer.parseInt(binding.textA1y.getText().toString()));

                    Dictionary<String, Integer> b1= new Hashtable<>();
                    b1.put("X", Integer.parseInt(binding.textB1x.getText().toString()));
                    b1.put("Y", Integer.parseInt(binding.textB1y.getText().toString()));

                    Dictionary<String, Integer> a2= new Hashtable<>();
                    a2.put("X", Integer.parseInt(binding.textA2x.getText().toString()));
                    a2.put("Y", Integer.parseInt(binding.textA2y.getText().toString()));

                    Dictionary<String, Integer> b2= new Hashtable<>();
                    b2.put("X", Integer.parseInt(binding.textB2x.getText().toString()));
                    b2.put("Y", Integer.parseInt(binding.textB2y.getText().toString()));

                    Dictionary<String, Integer> f= new Hashtable<>();
                    f.put("X", Integer.parseInt(binding.textFx.getText().toString()));
                    f.put("Y", Integer.parseInt(binding.textFy.getText().toString()));

                    kumpulan.add(a1);
                    kumpulan.add(f);
                    kumpulan.add(b1);
                    kumpulan.add(a2);
                    kumpulan.add(b2);


                    totalJarak = cekTotalJarak(kumpulan, s);
                    for (int e = 0; e < rintangan; e++) {
                        totalJarak = cekTotalJarak(kumpulan, koordinatTerdekat);
                    };
                    binding.hasilText.setText(String.valueOf(totalJarak));

                    koordinatTerdekat.remove(a1);
                    koordinatTerdekat.remove(f);
                    koordinatTerdekat.remove(b1);
                    koordinatTerdekat.remove(a2);
                    koordinatTerdekat.remove(s);
                    koordinatTerdekat.remove(b2);
                    kumpulan.clear();


                }




        }
        }
        );


    };






}
