package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SlotsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slots);
        final TextView slotOne = findViewById(R.id.slotOne);
        final TextView slotTwo = findViewById(R.id.slotTwo);
        final TextView slotOThree = findViewById(R.id.slotThree);
        Button spinButton = findViewById(R.id.slotButton);
        spinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slotOne.setText("temp");
                slotTwo.setText("or");
                slotOThree.setText("ary");
            }
        });
    }
}
