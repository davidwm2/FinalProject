package com.example.finalproject;

import android.widget.TextView;

import java.util.ArrayList;

public class Hand {
    ArrayList<Card> hand;//represents the hand

    /**
     * @param deck Contains the cards from which the hand is dealt.
     */
    Hand(Deck deck) {
        hand = new ArrayList<Card>();
        for (int i = 0; i < 2; i++) {
            hand.add(deck.drawCard());
        }
    }

    /**
     * @param deck contains the cards from which the hand is dealt.
     */
    public void hit (Deck deck) {
        hand.add(deck.drawCard());
    }

}
