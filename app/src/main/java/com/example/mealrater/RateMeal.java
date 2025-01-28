package com.example.mealrater;


import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

public class RateMeal extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        showRatingDialog();
    }
    private void showRatingDialog() {

        Dialog dialog = new Dialog(RateMeal.this);
        dialog.setContentView(R.layout.rate_meal);

        RatingBar ratingBar = dialog.findViewById(R.id.ratingBar);
        Button buttonSave= dialog.findViewById(R.id.buttonSave);
        TextView textViewRate = findViewById(R.id.textViewRate);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float rating = ratingBar.getRating();
                textViewRate.setText("" + rating);
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}



