package pl.fl.quick_lesson;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

import io.paperdb.Paper;


public class OnSwipeTouchListener implements OnTouchListener {

    private final GestureDetector gestureDetector;

    Boolean onScreen1;
    String appName;
    Context ctx;


    public OnSwipeTouchListener(Context ctx,String name){
        gestureDetector = new GestureDetector(ctx, new GestureListener());
        onScreen1 =true;
        this.ctx=ctx;
        appName=name;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }


    private final class GestureListener extends SimpleOnGestureListener {

        @Override
        public boolean onDown(MotionEvent e) {
            return true;
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2,
                                float distanceX, float distanceY) {

            if(distanceX*-1>0){
                onSwipeLeft(distanceX);
            }
            if(distanceX*-1<0){
                onSwipeRight(distanceX);
            }
            Log.d("Dist_X:",Float.toString(distanceX));
            return false;
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            Log.d("Vel_X:",Float.toString(velocityX));
            return false;
        }

    }

    public void onSwipeRight(float diff) {
        if(onScreen1 && diff > 20){
            onScreen1=false;
            Intent myIntent;
            if(appName=="lesson1") {
                myIntent =new Intent(ctx, Lesson2.class);
                ctx.startActivity(myIntent);
                Lesson1.fa.overridePendingTransition(R.anim.slide_in_right, android.R.anim.fade_out);
                Lesson1.fa.finish();
            }
            if(appName=="lesson2") {
                myIntent =new Intent(ctx, Lesson3.class);
                ctx.startActivity(myIntent);
                Lesson2.fa.overridePendingTransition(R.anim.slide_in_right, android.R.anim.fade_out);
                Lesson2.fa.finish();
            }
            if(appName=="lesson3") {
                myIntent =new Intent(ctx, Lesson1.class);
                ctx.startActivity(myIntent);
                Lesson3.fa.overridePendingTransition(R.anim.slide_in_right, android.R.anim.fade_out);
                Lesson3.fa.finish();
            }
        }

    }

    public void onSwipeLeft(float diff) {
        if(onScreen1 && diff < -20){
            onScreen1=false;
            Intent myIntent =new Intent(ctx, Lesson1.class);
            if(appName=="lesson1") {
                myIntent =new Intent(ctx, Lesson3.class);
                ctx.startActivity(myIntent);
                Lesson1.fa.overridePendingTransition(R.anim.slide_in_left, android.R.anim.fade_out);
                Lesson1.fa.finish();

            }
            if(appName=="lesson2") {
                myIntent =new Intent(ctx, Lesson1.class);
                ctx.startActivity(myIntent);
                Lesson2.fa.overridePendingTransition(R.anim.slide_in_left, android.R.anim.fade_out);
                Lesson2.fa.finish();
            }
            if(appName=="lesson3") {
                myIntent =new Intent(ctx, Lesson2.class);
                ctx.startActivity(myIntent);
                Lesson3.fa.overridePendingTransition(R.anim.slide_in_left, android.R.anim.fade_out);
                Lesson3.fa.finish();
            }

        }
    }
    public void changeOnScreen(Boolean bool){
        onScreen1=bool;
    }

}
