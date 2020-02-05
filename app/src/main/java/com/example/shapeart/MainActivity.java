package com.example.shapeart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageButton WhiteBtn, BlackBtn,back, rndPaint, rndBg, save;
    ConstraintLayout mainlayout;
    int BackgroundColor= Color.WHITE;
    boolean clear=false;
    MyDraw md;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WhiteBtn=(ImageButton)findViewById(R.id.white_paint);
        BlackBtn=(ImageButton)findViewById(R.id.black_paint);
        back=(ImageButton)findViewById(R.id.back);
        rndBg=(ImageButton)findViewById(R.id.random_bg);
        rndPaint=(ImageButton)findViewById(R.id.random_paint);
        save=(ImageButton)findViewById(R.id.save);

        mainlayout=(ConstraintLayout)findViewById(R.id.mainlayout);
        md=(MyDraw)findViewById(R.id.myDraw2);

        WhiteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                md.color=Color.WHITE;
            }
        });
        BlackBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                md.color=Color.BLACK;
            }
        });
        rndPaint.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Random rnd=new Random();
                md.color=Color.rgb(rnd.nextInt(255),rnd.nextInt(255),rnd.nextInt(255));
            }
        });
        rndBg.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Random rnd=new Random();
                BackgroundColor=Color.rgb(rnd.nextInt(255),rnd.nextInt(255),rnd.nextInt(255));
                mainlayout.setBackgroundColor(BackgroundColor);
            }
        });
        back.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                md.Diagrams.clear();
                mainlayout.setBackgroundColor(Color.WHITE);
                md.invalidate();
            }
        });

    }

    public void mOnCaptureClick(View v){
        md.buildDrawingCache();
        Bitmap captureView = md.getDrawingCache();
        FileOutputStream fos;
        try{
            fos = new FileOutputStream(Environment.getExternalStorageDirectory().toString()+"/capture.jpeg");
            captureView.compress(Bitmap.CompressFormat.JPEG, 100, fos);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Toast.makeText(getApplicationContext(), "Captured!", Toast.LENGTH_LONG).show();
    }
}
