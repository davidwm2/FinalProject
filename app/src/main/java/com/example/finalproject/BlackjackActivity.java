package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class BlackjackActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blackjack);

        Deck deck = new Deck(); // initializes the deck we use to play.
        Hand playerHand = new Hand(deck);

        for (int i = 0; i < playerHand.getSize(); i++) {
            if(i == 0) {
                TextView textView = (TextView) findViewById(R.id.myFirst);
                textView.setText(playerHand.hand.get(i).getValue());
            } else if (i == 1) {
                TextView textView = (TextView) findViewById(R.id.mySecond);
                textView.setText(playerHand.hand.get(i).getValue());
            }
        }
    }

}

