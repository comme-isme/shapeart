package com.example.shapeart;

import android.graphics.Canvas;
import android.graphics.Paint;

public abstract class Diagram {

    public abstract void DrawDiagram(Canvas canvas);
    
    public abstract boolean IsCircle(Diagram diagram);
    
    public abstract void Bigger();
    
    public abstract void Smaller();
    
    public abstract void EmptyChange();
}
