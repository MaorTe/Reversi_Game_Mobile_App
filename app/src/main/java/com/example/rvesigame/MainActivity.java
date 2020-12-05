package com.example.rvesigame;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {

    Animation slide;
    Button btn;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamestart);
        btn =findViewById(R.id.playButton);
        imageView = findViewById(R.id.image);
        slide = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_down);
        imageView.startAnimation(slide);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,ReversiMenu.class);
                startActivity(intent);
            }
        });
    }
}
