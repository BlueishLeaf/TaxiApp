package com.example.killian.taxiapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    public static final Double PRICE_PER_KM = 1.25;
    public static final Double PRICE_PER_MINUTE = 0.25;
    public static final Double PRICE_PER_PASSENGER = 1.00;
    public static final Double PRICE_PER_LUGGAGE = 0.5;
    public static final Double TAX = 0.135;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void readData(View view){
        EditText kmBox = findViewById(R.id.kilometers_travelled);
        EditText timeBox = findViewById(R.id.minutes_taken);
        EditText passengerBox = findViewById(R.id.passenger_amount);
        EditText luggageBox = findViewById(R.id.luggage_amount);

        double kmValue = Double.parseDouble(kmBox.getText().toString());
        double timeValue = Double.parseDouble(timeBox.getText().toString());
        int passengerValue = Integer.parseInt(passengerBox.getText().toString());
        int luggageValue = Integer.parseInt(luggageBox.getText().toString());

        double grossFare = calcFare(kmValue,timeValue,passengerValue,luggageValue);
        double finalFare = grossFare + (grossFare * TAX);
        buildIntent(kmValue,timeValue,passengerValue,luggageValue,grossFare,finalFare);
    }

    private void buildIntent(double kmValue, double timeValue, int passengerValue, int luggageValue, double grossFare, double finalFare) {
        NumberFormat formatter = new DecimalFormat("#0.00");
        Intent intent = new Intent(this,DisplayResult.class);
        intent.putExtra("com.example.killian.KMVALUE", formatter.format(kmValue));
        intent.putExtra("com.example.killian.TIMEVALUE", formatter.format(timeValue));
        intent.putExtra("com.example.killian.PASSENGERVALUE", String.valueOf(passengerValue));
        intent.putExtra("com.example.killian.LUGGAGEVALUE", String.valueOf(luggageValue));
        intent.putExtra("com.example.killian.GROSSCALUE", formatter.format(grossFare));
        intent.putExtra("com.example.killian.FINALFARE", formatter.format(finalFare));
        startActivity(intent);

    }

    private double calcFare(double kmValue, double timeValue, int passengerValue, int luggageValue) {
        return (kmValue * PRICE_PER_KM)+(timeValue*PRICE_PER_MINUTE)+(passengerValue*PRICE_PER_PASSENGER)+(luggageValue*PRICE_PER_LUGGAGE);
    }
}
