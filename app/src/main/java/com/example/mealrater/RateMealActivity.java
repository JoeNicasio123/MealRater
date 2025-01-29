package com.example.mealrater;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.fragment.app.DialogFragment;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.rate_meal, container, false);
        getDialog().setTitle("Rate Meal");

        RatingBar ratingBar = view.findViewById(R.id.ratingBar);
        Button buttonSave = view.findViewById(R.id.buttonSave);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float rating = ratingBar.getRating();

            }
        });
        return view;
    }
}