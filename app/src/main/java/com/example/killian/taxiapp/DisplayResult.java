package com.example.killian.taxiapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.killian.taxiapp.MainActivity.TAX;

public class DisplayResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_result);

        Intent intent = getIntent();

        TextView distanceVal = findViewById(R.id.distance_show);
        TextView timeVal = findViewById(R.id.time_show);
        TextView passengerVal = findViewById(R.id.passenger_show);
        TextView luggageVal = findViewById(R.id.luggage_show);
        TextView grossVal = findViewById(R.id.gross_show);
        TextView taxVal = findViewById(R.id.tax_show);
        TextView fareVal = findViewById(R.id.fare_show);

        distanceVal.setText(intent.getStringExtra("com.example.killian.KMVALUE"));
        timeVal.setText(intent.getStringExtra("com.example.killian.TIMEVALUE"));
        passengerVal.setText(intent.getStringExtra("com.example.killian.PASSENGERVALUE"));
        luggageVal.setText(intent.getStringExtra("com.example.killian.LUGGAGEVALUE"));
        grossVal.setText("€"+intent.getStringExtra("com.example.killian.GROSSCALUE"));
        taxVal.setText(String.valueOf(TAX*100)+"%");
        fareVal.setText("€"+intent.getStringExtra("com.example.killian.FINALFARE"));

    }
}
