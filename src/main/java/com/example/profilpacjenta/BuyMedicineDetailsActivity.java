//package com.example.profilpacjenta;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.content.Intent;
//import android.content.SharedPreferences;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.TextView;
//import android.widget.Toast;
//
//public class BuyMedicineDetailsActivity extends AppCompatActivity {
//
//    TextView tvPackageName, tvTotalCost;
//    EditText edDetails;
//    Button btnBack, btnAddToCart;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_buy_medicine_details);
//
//        tvPackageName = findViewById(R.id.textViewBMDPackageName);
//        edDetails = findViewById(R.id.editTextTextBMDMultiLine);
//        edDetails.setKeyListener(null);
//        tvTotalCost = findViewById(R.id.textViewBMDTotalCost);
//        btnBack = findViewById(R.id.buttnBMDBack);
//        btnAddToCart = findViewById(R.id.buttonBMDAddToCard);
//
//        Intent intent = new Intent();
//        tvPackageName.setText(intent.getStringExtra("text1"));
//        edDetails.setText(intent.getStringExtra("text2"));
//        tvTotalCost.setText("Koszt całkowity: " + intent.getStringExtra("text3") + "zł");
//
//        btnBack.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(BuyMedicineDetailsActivity.this, BuyMedicineActivity.class));
//            }
//        });
//
//        btnAddToCart.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", MODE_PRIVATE);
//                String username = sharedPreferences.getString("username", "").toString();
//                String product = tvPackageName.getText().toString();
//                float price = Float.parseFloat(intent.getStringExtra("text3").toString());
//
//                Database db = new Database(getApplicationContext(), "profil pacjenta", null, 1);
//
//                if (db.checkCart(username, product) == 1) {
//                    Toast.makeText(getApplicationContext(), "Produkt już dodany", Toast.LENGTH_SHORT).show();
//                } else {
//                    db.addCart(username, product, price, "medicine");
//                    Toast.makeText(getApplicationContext(), "Dodano do koszyka", Toast.LENGTH_SHORT).show();
//                    startActivity(new Intent(BuyMedicineDetailsActivity.this, BuyMedicineActivity.class));
//                }
//
//            }
//        });
//
//    }
//}

package com.example.profilpacjenta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BuyMedicineDetailsActivity extends AppCompatActivity {

    TextView tvPackageName, tvTotalCost;
    EditText edDetails;

    Button btnAddToCart, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine_details);

        tvPackageName = findViewById(R.id.textViewBMDCartTitle);
        tvTotalCost = findViewById(R.id.textViewBMDTotalCost);
        edDetails = findViewById(R.id.editTextTextBMDMultiLine);
        btnAddToCart = findViewById(R.id.buttonBMCardBack);
        btnBack = findViewById(R.id.buttonHADBack);

        edDetails.setKeyListener(null);
        Intent intent = getIntent();
        tvPackageName.setText(intent.getStringExtra("text1"));
        edDetails.setText(intent.getStringExtra("text2"));
        tvTotalCost.setText("Koszt: "+ intent.getStringExtra("text3"));

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BuyMedicineDetailsActivity.this, BuyMedicineActivity.class));
            }
        });

        btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                String username = sharedPreferences.getString("username", "").toString();
                String product = tvPackageName.getText().toString();
                float price = Float.parseFloat(intent.getStringExtra("text3").toString());

                Database db = new Database(getApplicationContext(), "profil pacjenta", null, 1);

                if (db.checkCart(username, product) == 1) {
                    Toast.makeText(getApplicationContext(), "Produkt już dodany", Toast.LENGTH_SHORT).show();
                } else {
                    db.addCart(username, product, price, "lab");
                    Toast.makeText(getApplicationContext(), "Dodano do koszyka", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(BuyMedicineDetailsActivity.this, BuyMedicineActivity.class));
                }
            }
        });

    }
}