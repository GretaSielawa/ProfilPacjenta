package com.example.profilpacjenta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class LabTestActivity extends AppCompatActivity {

    private String[][] packages = {
            {"Pakiet 1 : Morfologia","", "", "", "950"},
            {"Pakiet 2 : Glukoza", "", "", "", "177"},
            {"Pakiet 3 : COVID-19 przeciwciała - IgG", "", "", "", "120"},
            {"Pakiet 4 : Funkcja tarczycy", "", "", "", "130"},
            {"Pakiet 5 : Odporność", "", "", "", "375"},
    };

    private String[] package_details = {
            "Glukoza na czczo\n" +
            "Ogólna morfologia\n" +
            "HbA1c\n" +
            "Żelazo\n" +
            "Funkcja nerek\n" +
            "LDH Laktoza Hydroganowa, serum\n" +
            "Profil lipidowy\n" +
            "Funkcja wątroby",
            "Glukoza na czczo",
            "COVID-19 przeciwciała - IgG",
            "Funkcja tarczycy (T3, T4, TSH)",
            "Ogólna morfologia\n" +
            "CRP, serum\n" +
            "Żelazo\n" +
            "Funkcja nerek\n" +
            "Witamina D, poziom\n" +
            "Funkcja wątroby\n" +
            "Profil lipidowy\n"
    };

    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    Button btnGoToCart, btnBack;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test);

        btnGoToCart = findViewById(R.id.buttonBMCardBack);
        btnBack = findViewById(R.id.buttonHADBack);
        listView = findViewById(R.id.listViewBM);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LabTestActivity.this, HomeActivity.class));
            }
        });

        list = new ArrayList();
        for (int i = 0; i < packages.length; i++) {
            item = new HashMap<String,String>();
            item.put("Line1", packages[i][0]);
            item.put("Line2", packages[i][1]);
            item.put("Line3", packages[i][2]);
            item.put("Line4", packages[i][3]);
            item.put("Line5", "Koszt: " + packages[i][4] + " zł");
            list.add(item);
        }

        sa = new SimpleAdapter(this, list, R.layout.multi_lines,
                new String[] {"Line1", "Line2", "Line3", "Line4", "Line5"},
                new int[] {R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e});

        listView.setAdapter(sa);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(LabTestActivity.this, LabTestDetailsActivity.class);
                it.putExtra("text1", packages[i][0]);
                it.putExtra("text2", package_details[i]);
                it.putExtra("text3", packages[i][4]);
                startActivity(it);
            }
        });

        btnGoToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LabTestActivity.this, CartLabActivity.class));
            }
        });

    }
}