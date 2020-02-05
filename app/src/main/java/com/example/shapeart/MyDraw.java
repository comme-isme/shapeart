package com.example.shapeart;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.util.AttributeSet;

import java.util.ArrayList;

public class MyDraw extends View {
    int sx,sy,ex,ey;	//직선 시작좌표 끝 좌표
    int cx,cy;	//원 좌표
    static ArrayList<Diagram> Diagrams=new ArrayList<Diagram>();
    static Diagram now=null;
    static int color=Color.BLACK;
    static int BgColor=Color.WHITE;

    public MyDraw(Context context,AttributeSet attr){
        super(context,attr);

    }


    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        int i=0;
        int last=Diagrams.size();
        Diagram diagram;
        for(i=0;i<last;++i){
            diagram=Diagrams.get(i);
            diagram.DrawDiagram(canvas);
            if(now !=null) {
                now.DrawDiagram(canvas);
            }
        }
    }




    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            sx = (int) event.getX();
            sy = (int) event.getY();
        }
        else if(event.getAction()==MotionEvent.ACTION_MOVE){
            ex=(int) event.getX();
            ey=(int)event.getY();

            //버그 좆망겜(시작점에서 십자가로 직선이 안생김
            if(Math.abs(sx-ex)>10 && Math.abs(sy-ey)>10) {
                now=new Line(sx,sy,ex,ey,color);
                Diagrams.add(now);
                invalidate();
            }

        }
        else if(event.getAction()==MotionEvent.ACTION_UP){
            ex=(int) event.getX();
            ey=(int) event.getY();

            if(Math.abs(sx-ex)<10 && Math.abs(sy-ey)<10) {
                now = new Circle(ex, ey, color);
                Diagrams.add(now);
                invalidate();
            }
        }

        return true;
    }
}
