package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class tieActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tie);
        //Button creators so we can call them
        Button playBlackjack = findViewById(R.id.playBlackjack);
        Button playPoker = findViewById(R.id.playPoker);
        Button playSlots = findViewById(R.id.playSlots);
        // Button listener here to launch the blackjack activity when the button is clicked
        playBlackjack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tieActivity.this, BlackjackActivity.class);
                startActivity(intent);
            }
        });
        // Button listener here to launch the poker activity when the button is clicked
        playPoker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tieActivity.this, PokerActivity.class);
                startActivity(intent);
            }
        });
        // Button listener here to launch the slots activity when the button is clicked
        playSlots.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tieActivity.this, SlotsActivity.class);
                startActivity(intent);
            }
        });

    }
}
