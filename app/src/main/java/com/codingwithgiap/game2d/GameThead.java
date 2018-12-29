package com.codingwithgiap.game2d;

import android.graphics.Canvas;
import android.util.Log;
import android.view.SurfaceHolder;

class GameThead extends Thread{
    Boolean isrunning;
    SurfaceHolder surfaceHolder;
    GameSurface gameSurface;

    public GameThead(SurfaceHolder surfaceHolder, GameSurface gameSurface) {
        this.surfaceHolder = surfaceHolder;
        this.gameSurface = gameSurface;
    }

    public void setRunning(boolean isrunning) {
        this.isrunning = isrunning;
    }

    @Override
    public void run() {

        while (isrunning){
            Canvas canvas = null;
            try {
                canvas = surfaceHolder.lockCanvas();
                synchronized (canvas) {
                    this.gameSurface.update();
                    this.gameSurface.draw(canvas);
                    Log.e("check", "run: run" );
                }
            }catch (Exception e){}

            finally{
                if(canvas !=null){
                    this.surfaceHolder.unlockCanvasAndPost(canvas);
                }
            }
            try {
                this.sleep(150);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
