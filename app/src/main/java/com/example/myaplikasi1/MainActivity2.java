package com.example.myaplikasi1;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dua); // Make sure the layout is set here

        // Enable the Up/Back button in the ActionBar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true); // Show the Up button
            getSupportActionBar().setTitle("Second Screen");       // Set title for the screen
        }

        // Handle the Back button in the layout (btn_back)
        Button btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(v -> {
            // Navigate back to the login screen (MainActivity)
            Intent intent = new Intent(MainActivity2.this, MainActivity.class);
            startActivity(intent);
            finish(); // Finish the current activity
        });
    }

    // Handle the Up/Back button behavior in the ActionBar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            // If Up/Back button is pressed, return to the login screen (MainActivity)
            Intent intent = new Intent(MainActivity2.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // Clear the activity stack
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
