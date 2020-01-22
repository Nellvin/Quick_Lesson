package pl.fl.quick_lesson;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import com.alphamovie.lib.AlphaMovieView;

public class videoTouchListener implements View.OnTouchListener {

    private final GestureDetector gestureDetector;

    Boolean onScreen1;
    AlphaMovieView alphaMovieView;
    Context ctx;


    public videoTouchListener(Context ctx, AlphaMovieView alphaMovieView){
        gestureDetector = new GestureDetector(ctx, new GestureListener());
        this.alphaMovieView=alphaMovieView;
        onScreen1 =true;
        this.ctx=ctx;

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }


    private final class GestureListener extends GestureDetector.SimpleOnGestureListener {

        @Override
        public boolean onDown(MotionEvent e) {
            return true;
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2,
                                float distanceX, float distanceY) {


            return false;
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

            return false;
        }

        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            Log.d("Tap","zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
            if(alphaMovieView.isPlaying()){
                alphaMovieView.pause();
            }else {
                alphaMovieView.start();
            }
            return super.onSingleTapUp(e);
        }
    }

    public void onSwipeRight(float diff) {

    }

    public void onSwipeLeft(float diff) {

    }
    public void changeOnScreen(Boolean bool){
        onScreen1=bool;
    }

}
