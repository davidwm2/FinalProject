package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class PokerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poker);
        // Calling all the objects in the 5 hand poker game.
        Button deal = findViewById(R.id.dealButton);
        CheckBox cardOne = findViewById(R.id.cardOne);
        CheckBox cardTwo = findViewById(R.id.cardTwo);
        CheckBox cardThree = findViewById(R.id.cardThree);
        CheckBox cardFour = findViewById(R.id.cardFour);
        CheckBox cardFive = findViewById(R.id.cardFive);
        deal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("It;s good");
            }
        });
    }
}
