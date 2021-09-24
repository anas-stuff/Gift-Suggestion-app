package com.barmej.giftsuggestion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private static final String BUNDLE_CURRENT_INDEX = "BUNDLE_CURRENT_INDEX";
    private Random mRandom;

    private TextView textView;
    private ImageView giftImageView;

    private final int[][] giftImages = {
            {R.drawable.gift_1, R.string.damask_rose},
            {R.drawable.gift_2, R.string.flower},
            {R.drawable.gift_3, R.string.cake},
            {R.drawable.gift_4, R.string.laptop},
            {R.drawable.gift_5, R.string.mobile},
            {R.drawable.gift_6, R.string.book},
            {R.drawable.gift_7, R.string.piece_of_cake},
            {R.drawable.gift_8, R.string.shirt},
            {R.drawable.gift_9, R.string.shoe},
            {R.drawable.gift_10, R.string.diamond}

    };
    private int currentIndex = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Look here

        // Get image view
        giftImageView = findViewById(R.id.image_gift);
        // Get Text view
        textView = findViewById(R.id.text_gift_name);

        mRandom = new Random();
        Log.i(TAG, "Created");
    }

    public void display(View view){
//        if(currentIndex <= 8) {
            currentIndex = mRandom.nextInt(10);
            Log.i(TAG, "Random number = " + currentIndex);
            showImage();
            showGiftName();
//        } else
//            Toast.makeText(this, "هذة هيا أخر هدية", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) { // Look here
        super.onSaveInstanceState(outState);
        outState.putInt(BUNDLE_CURRENT_INDEX, currentIndex); // Look here // Save current index value
        Log.i(TAG, "OnSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if(savedInstanceState != null){
            currentIndex = savedInstanceState.getInt(BUNDLE_CURRENT_INDEX) - 1;

            if(currentIndex != -1)
                showImage();
        }
    }
    private void showImage(){
        Drawable giftDrawable = ContextCompat.getDrawable(this, giftImages[currentIndex][0]);
        giftImageView.setImageDrawable(giftDrawable);
    }

    private void showGiftName(){
        textView.setText(giftImages[currentIndex][1]);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "Restarted");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "Started");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "Resumed");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "Paused");
    }


    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "Stopped");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "Destroyed");
    }
}