package com.example.profilpacjenta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {

    private String[][] doctor_details1 = {
            {"Lekarz: Jan Kowalski", "Poradnia: rodzinny", "Dośw: 8", "Tel:    5671654", "Płatnik:NFZ/Pryw"},
            {"Lekarz: Anna Mróz", "Poradnia: rodzinny", "Dośw: 12", "Tel:    5671554", "Płatnik:NFZ/Pryw"},
            {"Lekarz: Artiom Serevtienko", "Poradnia: rodzinny", "Dośw: 5", "Tel:    5671658", "Płatnik: NFZ/Pryw"},
            {"Lekarz: Izabela Biel", "Poradnia: rodzinny", "Dośw: 9", "Tel:    5672654", "Płatnik: NFZ"},
            {"Lekarz: Adam Mościński", "Poradnia: rodzinny", "Dośw: 9", "Tel:    5671634", "Płatnik: NFZ/Pryw"}
    };

    private String[][] doctor_details2 = {
            {"Lekarz: Halina Sielawa ", "Poradnia: okulistyczna", "Dośw: 5", "Tel:    5671654", "Płatnik: Pryw"},
            {"Lekarz: Angelika Sołowiej", "Poradnia: okulistyczna", "Dośw: 10", "Tel:    5671554", "Płatnik: NFZ"},
            {"Lekarz: Nina Putyńska", "Poradnia: okulistyczna", "Dośw: 7", "Tel:    5671658", "Płatnik: Pryw"},
            {"Lekarz: Adam Paszko", "Poradnia: okulistyczna", "Dośw: 10", "Tel:    5672654", "Płatnik: Pryw"},
            {"Lekarz: Kamil Kościuszko", "Poradnia: okulistyczna", "Dośw: 11", "Tel:    5671634", "Płatnik: NFZ/Pryw"}
    };

    private String[][] doctor_details3 = {
            {"Lekarz:Stanisaw Wawrzyn", "Poradnia:dentystyczna", "Dośw:5", "Tel:    5671654", "Płatnik: NFZ/Pryw"},
            {"Lekarz:Andrzej Kamiński","Poradnia:dentystyczna", "Dośw: 12","Tel:    5672594", "Płatnik: NFZ/Pryw"},
            {"Lekarz:Aneta Bielicka","Poradnia:dentystyczna", "Dośw: 4","Tel:     5671658", "Płatnik: NFZ"},
            {"Lekarz:Victor Sołowiej","Poradnia:dentystyczna", "Dośw: 17","Tel:     5672614", "Płatnik: NFZ/Pryw"},
            {"Lekarz:Artur Dziemian", "Poradnia: dentystyczna", "Dośw: 11","Tel:    5672634", "Płatnik: NFZ/Pryw"}
    };

    private String[][] doctor_details4 = {
            {"Lekarz: Jan Kowalski", "Poradnia: chirurgiczna", "Dośw: 18", "Tel:    5671654", "Płatnik: NFZ"},
            {"Lekarz: Alina Pawłowicz", "Poradnia: chirurgiczna", "Dośw: 14", "Tel:    5671554", "Płatnik: NFZ/Pryw"},
            {"Lekarz: Halina Krajewska", "Poradnia: chirurgiczna", "Dośw: 12", "Tel:    5671658", "Płatnik: NFZ"},
            {"Lekarz: Henryk Sołowiej", "Poradnia: chirurgiczna", "Dośw: 13", "Tel:    5672654 ", "Płatnik: NFZ"},
            {"Lekarz: Grażyna Zielińska", "Poradnia: chirurgiczna", "Dośw: 11", "Tel:    5671634", "Płatnik: NFZ/Pryw"}
    };

    private String[][] doctor_details5 = {
            {"Lekarz: Krystyna Sołowiej", "Poradnia: kardiologiczna", "Dośw: 12", "Tel:    5671654", "Płatnik: NFZ"},
            {"Lekarz: Paweł Zackiewicz", "Poradnia: kardiologiczna", "Dośw: 10", "Tel:    5671554", "Płatnik: NFZ/Pryw"},
            {"Lekarz: Wojciech Jurewicz", "Poradnia: kardiologiczna", "Dośw: 7", "Tel:    5671658", "Płatnik: NFZ/Pryw"},
            {"Lekarz: Zbigniew Kamiński", "Poradnia: kardiologiczna", "Dośw: 10", "Tel:    5672654", "Płatnik: NFZ"},
            {"Lekarz: Kinga Dudzińska", "Poradnia: kardiologiczna", "Dośw: 11", "Tel:    5671634", "Płatnik: NFZ"}
    };


    TextView tv;
    Button btn;
    String [][] doctor_details = {};
    HashMap<String,String>item;
    ArrayList list;
    SimpleAdapter sa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);


        tv = findViewById(R.id.textViewHADTitle);
        btn = findViewById(R.id.buttonHADBack);

        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);


        if (title.compareTo("Lekarz rodzinny") == 0) {
            doctor_details = doctor_details1;
        } else if (title.compareTo("Okulista") == 0) {
            doctor_details = doctor_details2;
        } else if (title.compareTo("Dentysta") == 0) {
            doctor_details = doctor_details3;
        } else if (title.compareTo("Chirurg") == 0) {
            doctor_details  = doctor_details4;
        } else {
            doctor_details = doctor_details5;
        }




        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsActivity.this, FindDoctorActivity.class));
            }
        });

        list = new ArrayList<>();
        for (int i = 0; i < doctor_details.length; i++) {
            item = new HashMap<String, String>();
            item.put("Line1", doctor_details[i][0]);
            item.put("Line2", doctor_details[i][1]);
            item.put("Line3", doctor_details[i][2]);
            item.put("Line4", doctor_details[i][3]);
            item.put("Line5", doctor_details[i][4]);
            list.add(item);
        }

        sa = new SimpleAdapter(this, list,
                R.layout.multi_lines,
                new String[]{"Line1", "Line2", "Line3", "Line4", "Line5"},
                new int[]{R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e}
        );
        ListView lst = findViewById(R.id.listViewBM);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(DoctorDetailsActivity.this, BookAppointmentActivity.class);
                it.putExtra("text1", title);
                it.putExtra("text2", doctor_details[i][0]);
                it.putExtra("text3", doctor_details[i][1]);
                it.putExtra("text4", doctor_details[i][3]);
                it.putExtra("text5", doctor_details[i][4]);
                startActivity(it);
            }
        });

    }
}