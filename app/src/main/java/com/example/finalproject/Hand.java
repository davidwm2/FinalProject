package com.example.finalproject;

import android.widget.TextView;

import java.util.ArrayList;

public class Hand {
    ArrayList<Card> hand;//represents the hand
    private int handValue = 0; // stores the value of the hand
    private int size = 0;

    /**
     * @param deck Contains the cards from which the hand is dealt.
     */
    Hand(Deck deck) {
        for (int i = 0; i < 2; i++) {
            hand.add(deck.drawCard());
            handValue += hand.get(i).getValue();
            size++;
        }
    }

    /**
     * @param deck contains the cards from which the hand is dealt.
     */
    public void hit (Deck deck) {
        hand.add(deck.drawCard());
        handValue += hand.get(hand.size() - 1).getValue();
        size++;
    }

    /**
     * @return the size of the hand.
     */
    public int getSize() {
        return size;
    }

}
