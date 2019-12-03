package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class BlackjackActivity extends AppCompatActivity {
    Deck deck = new Deck(); // initializes the deck we use to play.
    Hand playerHand = new Hand(deck);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blackjack);
                TextView textView = (TextView) findViewById(R.id.myFirst);
                textView.setText(playerHand.hand.get(0).getValue());

                textView = (TextView) findViewById(R.id.mySecond);
                textView.setText(playerHand.hand.get(1).getValue());
    }

}

