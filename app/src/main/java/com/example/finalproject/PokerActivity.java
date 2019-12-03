package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class PokerActivity extends AppCompatActivity {
    private boolean[] check;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poker);
        // Calling all the objects in the 5 hand poker game.
        TextView guide = findViewById(R.id.pokerMoves);
        Button deal = findViewById(R.id.dealButton);
        final CheckBox cardOne = findViewById(R.id.cardOne);
        final CheckBox cardTwo = findViewById(R.id.cardTwo);
        final CheckBox cardThree = findViewById(R.id.cardThree);
        final CheckBox cardFour = findViewById(R.id.cardFour);
        final CheckBox cardFive = findViewById(R.id.cardFive);
        //sets the checkboxes visible for the game.
        cardOne.setVisibility(View.VISIBLE);
        cardTwo.setVisibility(View.VISIBLE);
        cardThree.setVisibility(View.VISIBLE);
        cardFour.setVisibility(View.VISIBLE);
        cardFive.setVisibility(View.VISIBLE);
        guide.setText("Pick the cards you want to throw back");
        //button is clicked, any checks will be swapped out.
        deal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check = new boolean[]{cardOne.isChecked(), cardTwo.isChecked(), cardThree.isChecked(),
                        cardFour.isChecked(), cardFive.isChecked()};
                cardOne.setVisibility(View.GONE);
                cardTwo.setVisibility(View.GONE);
                cardThree.setVisibility(View.GONE);
                cardFour.setVisibility(View.GONE);
                cardFive.setVisibility(View.GONE);
                dealt();
                System.out.println("It's good");
            }
        });
    }
    private void dealt() {
        Button deal = findViewById(R.id.dealButton);
        TextView guide = findViewById(R.id.pokerMoves);
        String message = "You replaced card(s)";
        int j = 1;
        for (int i = 0; i < 5; i++) {
            if (check[i]) {
                message = message + " " + (i+1);
            } else {
                j++;
            }
        }
        if (j > 5) {
            guide.setText("You held your cards.");
        } else {
            guide.setText(message + ".");
        }
        deal.setText("Test again");
        deal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PokerActivity.this, PokerActivity.class);
                finish();
                startActivity(intent);
            }
        });
    }
}
