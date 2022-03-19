package com.ley.cathcinggame;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView time;
    TextView score;
    int scoreCount = 0;
    ImageView imageView1, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, imageView9;
    ImageView[] imageArray;
    Handler handler;
    Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize
         time = (TextView) findViewById(R.id.time);
         score = (TextView) findViewById(R.id.score);
        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);
        imageView5 = findViewById(R.id.imageView5);
        imageView6 = findViewById(R.id.imageView6);
        imageView7 = findViewById(R.id.imageView7);
        imageView8 = findViewById(R.id.imageView8);
        imageView9 = findViewById(R.id.imageView9);
        imageArray = new ImageView[]{imageView1,imageView2,imageView3,imageView4, imageView5, imageView6, imageView7, imageView8, imageView9};

        hideImages();

         new CountDownTimer(10000,1000){

             @Override
             public void onTick(long l) {
                 time.setText("Time: " + l/1000);
             }

             @Override
             public void onFinish() {
                time.setText("Time Off");
                handler.removeCallbacks(runnable);

                 for (ImageView image : imageArray){
                     image.setVisibility(View.INVISIBLE);
                 }
                 AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                 alert.setTitle("Restart?");
                 alert.setMessage("Are you sure to restart the game?");

                 alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                     @Override
                     public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = getIntent();
                        finish();
                        startActivity(intent);
                     }
                 });
                 alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                     @Override
                     public void onClick(DialogInterface dialogInterface, int i) {
                         Toast.makeText(MainActivity.this,"Game Over!",Toast.LENGTH_LONG).show();
                     }
                 });
                 alert.show();
             }
         }.start();
    }

    public void increaseScore(View view){
        scoreCount++;
        score.setText("Score: " + scoreCount);
    }

    public void hideImages(){
        handler = new Handler();
        runnable = new Runnable(){
            @Override
            public void run(){
                for (ImageView image : imageArray){
                    image.setVisibility(View.INVISIBLE);
                }
                Random random = new Random();
                int i = random.nextInt(9);
                imageArray[i].setVisibility(View.VISIBLE);
                handler.postDelayed(this, 1000/2);
            }
        };
        handler.post(runnable);
    }
}