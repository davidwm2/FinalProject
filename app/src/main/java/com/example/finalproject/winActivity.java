package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class winActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);

        //Button creators so we can call them
        Button playBlackjack = findViewById(R.id.playBlackjack);
        Button playPoker = findViewById(R.id.playPoker);

        // Button listener here to launch the blackjack activity when the button is clicked
        playBlackjack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(winActivity.this, BlackjackActivity.class);
                startActivity(intent);
            }
        });
        // Button listener here to launch the poker activity when the button is clicked
        playPoker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(winActivity.this, PokerActivity.class);
                startActivity(intent);
            }
        });
    }
}
