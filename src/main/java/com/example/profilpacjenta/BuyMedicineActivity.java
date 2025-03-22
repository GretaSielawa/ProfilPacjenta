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

public class BuyMedicineActivity extends AppCompatActivity {

    private String [][] packages = {

            {"Witamina D3 1000IU capsułki","","","","28"},
            {"Melatonina 5mg tabletki","","","","31"},
            {"Zolpidem 10mg tabletki","","","","448"},
            {"Oksycodon 5mg tabletki","","","","539"},
            {"Pregablina 5mg tabletki","","","","30"},
            {"Duloksetyna 30mg tabletki","","","","50"},
            {"Paracetamol 500mg tabletki","","","","30"},
            {"Ibuprofen 200mg kapsułki","","","","19"},
            {"Witamina C 200mg tabletki musujące","","","","67"}
    };


    private String[] package_details = {
            "Redukuje zmęczenie, wzmacnia odporność organizmu\n" + //vit d
                    "Wzmacnia kości i zęby\n" +
                    "Pomaga w zwalczaniu infekcji organizmu",
            "Ułatwia zasypianie\n" +                              //mel
            "Ułatwia zasypianie\n" +                                //zol
            "Skraca czas zasypiania"+
            "Lek przeciwbólowy" ,             //Oksy
                    "Silny leka przeciwbólowy\n"+
            "Lek na bóle układu nerwowego\n"+  //preg
                    "Lek na padaczkę\n",
            "Lek przzeciwdepresyjny\n" + //dul
                    "Lek przeciwnerwicowy\n"+
            "Lek przeciwbólowy\n" ,//par
                    "Na bóle o natężeniu słabym i średnim\n"+
            "Lek przeciwbólowy i przeciwzapalny\n" , //ibup
                    "Lek zaliczany do grupy leków NLPZ (niesteroidowych leków przeciwzapalnych)\n"+
            "Redukuje zmęczenie, wzmacnia odporność organizmu\n" , //wit c
                    "Ułatwia proces gojenia się ran"
    };

    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    ListView lst;
    Button btnBack, btnGoToCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine);

        lst = findViewById(R.id.listViewBM);
        btnBack = findViewById(R.id.buttonHADBack);
        btnGoToCart = findViewById(R.id.buttonBMCardBack);

        btnGoToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BuyMedicineActivity.this, CartBuyMedicineActivity.class));
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BuyMedicineActivity.this, HomeActivity.class));
            }
        });

        list = new ArrayList();
        for (int i = 0; i < packages.length; i++) {
            item = new HashMap<String,String>();
            item.put("line1", packages[i][0]);
            item.put("line2", packages[i][1]);
            item.put("line3", packages[i][2]);
            item.put("line4", packages[i][3]);
            item.put("line5", "Cena : " +packages[i][4] +"zł");
            list.add(item);
        }

        sa = new SimpleAdapter(this, list, R.layout.multi_lines,
                new String[] {"line1", "line2", "line3", "line4", "line5"},
                new int[] {R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e});

        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(BuyMedicineActivity.this, BuyMedicineDetailsActivity.class);
                it.putExtra("text1", packages[i][0]);
                it.putExtra("text2", package_details[i]);
                it.putExtra("text3", packages[i][4]);
                startActivity(it);
            }
        });
    }
}