package com.example.finalproject;

public class Card {
    private int rank;
    private int suit;
    private int value;
    private static String[] ranks = {"Joker", "Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
    private static String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};

    /**
     * @param setSuit is used to set the suit of the card.
     * @param setRank is used to set the rank of the card
     */
    Card(int setSuit, int setRank) {
        this.suit = setSuit;
        this.rank = setRank;
    }

    /**
     * @return The card info as a string.
     */
    public String toString() {
        return ranks[rank]+ " of " +suits[suit];
    }
    /**
     * @return the rank of the card.
     */
    public int getRank() {
       return rank;
    }

    /**
     * @return the suit of the cards
     */
    public int getSuit() {
        return suit;
    }

    /**
     * @return the value of the cards
     */
    public int getValue() {
        if (rank > 10) {
            value = 10;
        } else if (rank == 1) {
            value = 11;
        } else {
            value = rank;
        }
        return value;
    }

    /**
     * @param setValue sets the value of the card
     */
    public void setValue(int setValue) {
        value = setValue;
    }
}

