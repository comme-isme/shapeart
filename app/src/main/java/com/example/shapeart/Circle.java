package com.example.shapeart;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.Random;

public class Circle extends Diagram {
    static int shape=1;
    int cx,cy, CircleSize;
    Paint paintColor=new Paint();


    public Circle(int cx, int cy,int color) {
        this.cx = cx;
        this.cy = cy;
        Random rnd=new Random();
        paintColor.setColor(color);
        if (rnd.nextInt(10) > 4) {
            CircleSize = rnd.nextInt(500) + 30;
            paintColor.setStrokeWidth(3f);//여기가 두께
            paintColor.setStyle(Paint.Style.STROKE);

        } else {
            CircleSize = rnd.nextInt(300) + 30;
            paintColor.setStyle(Paint.Style.FILL);

        }
    }

    public void DrawDiagram(Canvas canvas){

        canvas.drawCircle(cx,cy,CircleSize,paintColor);
    }

}
