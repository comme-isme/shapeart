package com.example.shapeart;

import android.graphics.Canvas;
import android.graphics.Paint;

public class Line extends Diagram {
    static int shape=2;
    Paint paintColor=new Paint();

    int sx,sy, ex, ey;
    public Line(int startx, int starty, int endx, int endy,int  color){
        sx=startx;
        sy=starty;
        ex=endx;
        ey=endy;
        paintColor.setStrokeWidth(3f);
        paintColor.setColor(color);
    }
    public void DrawDiagram(Canvas canvas){
        canvas.drawLine(sx,sy,ex,ey,paintColor);
    }
    
    public boolean IsCircle(Diagram diagram){
     
        return false;
    }
    
    public void Bigger(){
    
        원의 크기만 조정 가능합니다;
    }
    
    public void Smaller(){
    
        원의 크기만 조정 가능합니다;
    }
    
    public void EmptyChange(){
    
        원의 색상만 칠할 수 있습니다;
    }
}
