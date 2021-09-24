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

    private final Gift[] mGifts = new Gift[10];
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

        for(int i=0; i < mGifts.length; i++)
            mGifts[i] = new Gift();

        // Gift 1
        mGifts[0].setName(R.string.damask_rose);
        mGifts[0].setPicture(R.drawable.gift_1);
        // Gift 2
        mGifts[1].setName(R.string.flower);
        mGifts[1].setPicture(R.drawable.gift_2);
        // Gift 3
        mGifts[2].setName(R.string.cake);
        mGifts[2].setPicture(R.drawable.gift_3);
        // Gift 4
        mGifts[3].setName(R.string.laptop);
        mGifts[3].setPicture(R.drawable.gift_4);
        // Gift 5
        mGifts[4].setName(R.string.mobile);
        mGifts[4].setPicture(R.drawable.gift_5);
        // Gift 6
        mGifts[5].setName(R.string.book);
        mGifts[5].setPicture(R.drawable.gift_6);
        // Gift 7
        mGifts[6].setName(R.string.piece_of_cake);
        mGifts[6].setPicture(R.drawable.gift_7);
        // Gift 8
        mGifts[7].setName(R.string.shirt);
        mGifts[7].setPicture(R.drawable.gift_8);
        // Gift 9
        mGifts[8].setName(R.string.shoe);
        mGifts[8].setPicture(R.drawable.gift_9);
        // Gift 10
        mGifts[9].setName(R.string.diamond);
        mGifts[9].setPicture(R.drawable.gift_10);


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
        Drawable giftDrawable = ContextCompat.getDrawable(this, mGifts[currentIndex].getPicture());
        giftImageView.setImageDrawable(giftDrawable);
    }

    private void showGiftName(){
        textView.setText(mGifts[currentIndex].getName());
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