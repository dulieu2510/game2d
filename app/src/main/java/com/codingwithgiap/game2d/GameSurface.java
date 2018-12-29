package com.codingwithgiap.game2d;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

class GameSurface extends SurfaceView implements SurfaceHolder.Callback {
    GameThead gamethead;
    Object_box object_box;
    public GameSurface(Context context) {
        super(context);
        this.setFocusable(true);
        this.getHolder().addCallback(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(),R.drawable.chibi1);
        object_box = new Object_box(150,30,bitmap);
        gamethead = new GameThead(holder,this);
        gamethead.setRunning(true);
        gamethead.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        Boolean replly = true;
        while (replly){
            this.gamethead.setRunning(false);
            try {
                this.gamethead.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            replly = true;
        }

    }

    public void update() {
        this.object_box.update();
    }
    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        this.object_box.draw_box(canvas);
    }
}
