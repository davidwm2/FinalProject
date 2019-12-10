package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class PokerActivity extends AppCompatActivity {
    /**
     * to check which card are set to be pulled.
     */
    private boolean[] check;
    /**
     * Deck of cards used.
     */
    Deck deck;
    /**
     * player's hand
     */
    Hand playerHand;
    /**
     * dealer's hand
     */
    Hand dealerHand;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poker0);
        System.out.println("scene set");
        //sets up scene
        TextView guide = findViewById(R.id.pokerMoves);
        Button deal = findViewById(R.id.dealButton);
        final CheckBox cardOne = findViewById(R.id.cardOne);
        final CheckBox cardTwo = findViewById(R.id.cardTwo);
        final CheckBox cardThree = findViewById(R.id.cardThree);
        final CheckBox cardFour = findViewById(R.id.cardFour);
        final CheckBox cardFive = findViewById(R.id.cardFive);
        //hand setup
        deck = new Deck();
        deck.shuffle();
        playerHand = new Hand(deck, true);
        dealerHand = new Hand(deck, false);
        //sets the checkboxes visible for the game.
        cardOne.setVisibility(View.VISIBLE);
        cardOne.setText(playerHand.hand.get(0).toString());
        cardTwo.setVisibility(View.VISIBLE);
        cardTwo.setText(playerHand.hand.get(1).toString());
        cardThree.setVisibility(View.VISIBLE);
        cardThree.setText(playerHand.hand.get(2).toString());
        cardFour.setVisibility(View.VISIBLE);
        cardFour.setText(playerHand.hand.get(3).toString());
        cardFive.setVisibility(View.VISIBLE);
        cardFive.setText(playerHand.hand.get(4).toString());
        guide.setText("Pick the cards you want to throw back");
        //button is clicked, any checks will be swapped out and set open the new screen.
        deal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check = new boolean[]{cardOne.isChecked(), cardTwo.isChecked(), cardThree.isChecked(),
                        cardFour.isChecked(), cardFive.isChecked()};
                setContentView(R.layout.activity_poker1);
                dealt();
                System.out.println("It's good");
            }
        });
    }

    /**
     * This switched the cards you put in with new cards from the deck.
     */
    private void dealt() {
        Button home = findViewById(R.id.homeButton);
        TextView endText = findViewById(R.id.endText);
        boolean firstCheck = true;
        String message = "You threw in";
        int j = 1;
        for (int i = 0; i < 5; i++) {
            if (check[i] && firstCheck) {
                message = message + " " + (playerHand.hand.get(i).toString());
                firstCheck = false;
            } else if (check[i]) {
                message = message + ", " + (playerHand.hand.get(i).toString());
            }else {
                j++;
            }
        }
        if (j > 5) {
            endText.setText("You held your cards.");
        } else {
            endText.setText(message + ".");
        }
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
