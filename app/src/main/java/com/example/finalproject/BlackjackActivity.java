package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class BlackjackActivity extends AppCompatActivity {
    Deck deck; // initializes the deck we use to play.
    Hand playerHand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blackjack);

        deck = new Deck();
        playerHand = new Hand(deck);

        TextView firstCard = findViewById(R.id.myFirst);
        firstCard.setText("Card Drawn");

        TextView secondCard = findViewById(R.id.mySecond);
        secondCard.setText("Card Drawn");
    }

}

