package com.example.finalproject;

import android.app.Dialog;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;

public class Hand {
    ArrayList<Card> hand;//represents the hand
    private int handValue = 0;

    /**
     * @param deck Contains the cards from which the hand is dealt.
     */
    Hand(Deck deck) {
        hand = new ArrayList<Card>();
        for (int i = 0; i < 2; i++) {
            hand.add(deck.drawCard());
        }
    }
    Hand(Deck deck, boolean pokerTruth) {
        hand = new ArrayList<Card>();
        for (int i = 0; i < 5; i++) {
            hand.add(deck.drawCard());
        }
    }

    /**
     * @param deck contains the cards from which the hand is dealt.
     */
    public void hit(Deck deck) {
        if (deck.canDraw()) {
            hand.add(deck.drawCard());
            handValue += hand.get(hand.size() - 1).getValue();
        }
    }

    public int getHandValue() {
        return handValue;
    }


}
