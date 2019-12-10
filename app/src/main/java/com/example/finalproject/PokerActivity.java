package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

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
    private  int pairs;
    private int playerScore;
    private int dealerScore;
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
        pairs = 0;
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
        TextView finOne = findViewById(R.id.cardOneFinal);
        TextView finTwo = findViewById(R.id.cardTwoFinal);
        TextView finThree = findViewById(R.id.cardThreeFinal);
        TextView finFour = findViewById(R.id.cardFourFinal);
        TextView finFive = findViewById(R.id.cardFiveFinal);
        boolean firstCheck = true;
        String message = "You threw in";
        int j = 1;
        for (int i = 0; i < 4; i++) {
            if (check[i] && firstCheck) {
                System.out.println("i ran");
                message = message + " " + (playerHand.hand.get(i).toString());
                playerHand.hand.set(i, deck.drawCard());
                firstCheck = false;
            } else if (check[i]) {
                System.out.println("i ran too");
                message = message + ", " + (playerHand.hand.get(i).toString());
                playerHand.hand.set(i, deck.drawCard());
            }else {
                j++;
            }
        }
        pairs = pairFinder(playerHand.hand);
        /*if (j > 4) {
            endText.setText("You held your cards.  You have " + pairs +" pairs.");
        } */
        if (fourOfAKind(playerHand.hand)) {
            playerScore = 5;
            endText.setText(message + ". You have four of a kind!.");
        } else if (fullHouse(playerHand.hand)){
            endText.setText(message + ". You have a full house.");
            playerScore = 4;
        } else if (threeOfAKind(playerHand.hand)) {
            endText.setText(message + ". You have three of a kind.");
            playerScore = 3;
        } else if (pairs == 2){
            endText.setText(message + ". You have " + pairs +" pair.");
            playerScore = 2;
        } else if (pairs == 1) {
            endText.setText(message + ". You have " + pairs +" pair.");
            playerScore = 1;
        } else {
            endText.setText(message + ". You have junk.");
            playerScore = 0;
        }
        finOne.setText(playerHand.hand.get(0).toString());
        finTwo.setText(playerHand.hand.get(1).toString());
        finThree.setText(playerHand.hand.get(2).toString());
        finFour.setText(playerHand.hand.get(3).toString());
        finFive.setText(playerHand.hand.get(4).toString());
        dealerMoves(deck);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    /**
     * used to find pair
     * @return
     */
    private int pairFinder(ArrayList<Card> cards) {
        int pears = 0;
        boolean firstPair;
        for (int i = 0; i < 4; i++) {
            firstPair = true;
            for (int k = i + 1; k <= 4; k++) {
                if (cards.get(i).getRank() == cards.get(k).getRank() && firstPair) {
                    pears++;
                    firstPair = false;
                }
            }
        }
        return pears;
    }

    /**
     * Checks for 3 of a kind
     * @param cards is the player's cards
     * @return if three of a kind
     */
    private boolean threeOfAKind(ArrayList<Card> cards) {
        int triple = 0;
        for (int i = 0; i < 2; i++) {
            triple = 0;
            for (int j = i + 1; j < 4; j++) {
                if (cards.get(i).getRank() == cards.get(j).getRank()) {
                    triple++;
                    if (triple == 2) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    private boolean fullHouse(ArrayList<Card> cards) {
        if (threeOfAKind(cards) && pairFinder(cards) == 1) {
            return true;
        }
        return false;
    }
    private boolean fourOfAKind(ArrayList<Card> cards) {
        int k = 0;
        for (int i = 0; i < 1; i++) {
            k = 0;
            for (int j = i + 1; j < 3; j++) {
                if (cards.get(i).getRank() == cards.get(j).getRank()) {
                    k++;
                }
            }
        }
        if (k == 4) {
            return true;
        }
        return false;
    }
    private void dealerMoves(Deck deck) {
        TextView dealerText = findViewById(R.id.dealerText);
        if (fourOfAKind(dealerHand.hand)) {
            dealerScore = 5;
        } else if (fullHouse(dealerHand.hand)) {
            dealerScore = 4;
        } else if (threeOfAKind(dealerHand.hand)) {
            dealerScore = 3;
        } else if (pairFinder(dealerHand.hand) == 2) {
            dealerScore = 2;
        } else if (pairFinder(dealerHand.hand) == 0) {
            dealerScore = 1;
        } else {
            dealerScore = 0;
        }
        if (dealerScore > playerScore) {
            dealerText.setText("Dealer wins");
        } else if (dealerScore == playerScore) {
            dealerText.setText("Tie Game!");
        } else {
            dealerText.setText("You win!");
        }
    }
}
