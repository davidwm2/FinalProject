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
    Boolean isOver = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blackjack);

        deck = new Deck();
        deck.shuffle();
        playerHand = new Hand(deck); // makes a two card hand
        dealerHand = new Hand(deck);
        TextView firstCard = findViewById(R.id.myFirst);
        firstCard.setText(playerHand.hand.get(0).toString()); //will display card content to UI
        TextView secondCard = findViewById(R.id.mySecond);
        secondCard.setText(playerHand.hand.get(1).toString()); // ""

        TextView dealerFirst = findViewById(R.id.dealerFirst);
        dealerFirst.setText(dealerHand.hand.get(0).toString()); //will display card content to UI
        TextView dealerSecond = findViewById(R.id.dealerSecond);
        dealerSecond.setText("Card Drawn"); // ""

        findViewById(R.id.myThird).setVisibility(View.GONE);
        findViewById(R.id.myFourth).setVisibility(View.GONE);
        findViewById(R.id.dealerThird).setVisibility(View.GONE);
        findViewById(R.id.dealerFourth).setVisibility(View.GONE);

        findViewById(R.id.split).setVisibility(View.GONE);

        if (playerHand.hand.get(0).getRank() == playerHand.hand.get(1).getRank()) {
            findViewById(R.id.split).setVisibility(View.VISIBLE);
        }

        findViewById(R.id.hit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerHand.hit(deck);
                if (findViewById(R.id.myThird).getVisibility() == View.GONE) {
                    TextView myThird = findViewById(R.id.myThird);
                    myThird.setText(playerHand.hand.get(2).toString());
                    myThird.setVisibility(View.VISIBLE);
                } else if (findViewById(R.id.myFourth).getVisibility() == View.GONE) {
                    TextView myFourth = findViewById(R.id.myFourth);
                    myFourth.setText(playerHand.hand.get(3).toString());
                    myFourth.setVisibility(View.VISIBLE);
                }
                if (playerHand.getHandValue() > 21) {
                    Intent intent = new Intent(BlackjackActivity.this, lostActivity.class);
                    startActivity(intent);
                }

            }
        });

        findViewById(R.id.stand).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                while(!isOver) {
                    dealer();
                }
            }
        });

    }
    public void dealer() {
        if (dealerHand.getHandValue() > 21) {
            isOver = true;
            Intent intent = new Intent(BlackjackActivity.this, winActivity.class);
            startActivity(intent);
        } else if (dealerHand.getHandValue() < 17) {
            dealerHand.hit(deck);
            if (findViewById(R.id.dealerThird).getVisibility() == View.GONE) {
                TextView myThird = findViewById(R.id.dealerThird);
                myThird.setText("Card Drawn");
                myThird.setVisibility(View.VISIBLE);
            } else if (findViewById(R.id.dealerFourth).getVisibility() == View.GONE) {
                TextView myThird = findViewById(R.id.dealerFourth);
                myThird.setText("Card Drawn");
                myThird.setVisibility(View.VISIBLE);
            }
        } else if (dealerHand.getHandValue() >= 17) {
            isOver = true;
            if (playerHand.getHandValue() > dealerHand.getHandValue()) {
                Intent intent = new Intent(BlackjackActivity.this, winActivity.class);
                startActivity(intent);
            } else if (playerHand.getHandValue() < dealerHand.getHandValue()) {
                Intent intent = new Intent(BlackjackActivity.this, lostActivity.class);
                startActivity(intent);
            } else {
                Intent intent = new Intent(BlackjackActivity.this, tieActivity.class);
                startActivity(intent);
            }
        }
    }

}

