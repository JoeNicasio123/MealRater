package com.example.mealrater;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        rateMealButton();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void rateMealButton() {
        Button buttonRateMeal = findViewById(R.id.buttonRateMeal);
        buttonRateMeal.setOnClickListener(new View.OnClickListener() {

            EditText editTextDish = findViewById(R.id.editTextDish);
            EditText editTextRestaurant = findViewById(R.id.editTextRestaurant);
            TextView textViewMessage = findViewById(R.id.textViewMessage);
            @Override
            public void onClick(View v) {
                String restaurantString = editTextRestaurant.getText().toString();
                String dishString = editTextDish.getText().toString();

                if(restaurantString.isEmpty() || (dishString.isEmpty())) {
                    textViewMessage.setText("Please enter a restaurant and dish");
                }
                else {
                    openDialog();
                }
            }
        });
    }

    private void openDialog() {
        Dialog dialog = new Dialog(MainActivity.this);
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
