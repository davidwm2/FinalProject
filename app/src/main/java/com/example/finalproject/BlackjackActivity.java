package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class BlackjackActivity extends AppCompatActivity {
    Deck deck; // initializes the deck we use to play.
    Hand playerHand;
    Hand dealerHand;
    Dialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blackjack);

        deck = new Deck();
        playerHand = new Hand(deck); // makes a two card hand
        dealerHand = new Hand(deck);
        TextView firstCard = findViewById(R.id.myFirst);
        firstCard.setText("Card Drawn"); //will display card content to UI
        TextView secondCard = findViewById(R.id.mySecond);
        secondCard.setText("Card Drawn"); // ""

        TextView dealerFirst = findViewById(R.id.dealerFirst);
        dealerFirst.setText("Card Drawn"); //will display card content to UI
        TextView dealerSecond = findViewById(R.id.dealerSecond);
        dealerSecond.setText("Card Drawn"); // ""

        findViewById(R.id.myThird).setVisibility(View.GONE);
        findViewById(R.id.myFourth).setVisibility(View.GONE);
        findViewById(R.id.dealerThird).setVisibility(View.GONE);
        findViewById(R.id.dealerFourth).setVisibility(View.GONE);

        findViewById(R.id.split).setVisibility(View.GONE);
        if (playerHand.hand.get(0) == playerHand.hand.get(1)) {
            findViewById(R.id.split).setVisibility(View.VISIBLE);
        }

        findViewById(R.id.hit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerHand.hit(deck);
                if (findViewById(R.id.myThird).getVisibility() == View.GONE) {
                    TextView myThird = findViewById(R.id.myThird);
                    myThird.setText("Card Drawn");
                    myThird.setVisibility(View.VISIBLE);
                } else if (findViewById(R.id.myFourth).getVisibility() == View.GONE) {
                    TextView myFourth = findViewById(R.id.myFourth);
                    myFourth.setText("Card Drawn");
                    myFourth.setVisibility(View.VISIBLE);
                }
                if (playerHand.getHandValue() > 21) {
                    Intent intent = new Intent(BlackjackActivity.this, lostActivity.class);
                    startActivity(intent);
                }

            }
        });

    }

}

