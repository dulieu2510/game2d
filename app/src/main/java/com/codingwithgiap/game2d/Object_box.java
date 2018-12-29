package com.codingwithgiap.game2d;

import android.graphics.Bitmap;
import android.graphics.Canvas;

class Object_box {
    int x;
    int y;
    Bitmap bitmap;
    public Object_box(int x, int y, Bitmap bitmap) {
        this.x ++;
        this.y = y;
        this.bitmap = bitmap;
    }

    public void update() {
        this.x++;
        this.y=30;
    }

    public void draw_box(Canvas canvas) {
        canvas.drawBitmap(bitmap,x,y,null);
        canvas.drawBitmap(bitmap,y,x,null);
    }
}
