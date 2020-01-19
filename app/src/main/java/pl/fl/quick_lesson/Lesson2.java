package pl.fl.quick_lesson;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alphamovie.lib.AlphaMovieView;

public class Lesson2 extends AppCompatActivity {

    TextView txt_1, txt_2, txt_3;
    ImageView img_1, img_2, img_3;
    OnSwipeTouchListener list;
    public static Activity fa;
    private AlphaMovieView alphaMovieView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson2);

        fa=this;

        LinearLayout linlay = findViewById(R.id.linlay);
        list= new OnSwipeTouchListener(this,"lesson2");
        linlay.setOnTouchListener(list);

        alphaMovieView = (AlphaMovieView) findViewById(R.id.video_player);
        String path = "android.resource://" + getPackageName() + "/" + R.raw.videoplayback;
        Log.d("PATH",path);
        alphaMovieView.setVideoFromUri(this,Uri.parse(path));

        txt_1 = findViewById(R.id.textView2);
        txt_2 = findViewById(R.id.textView3);
        txt_3 = findViewById(R.id.textView4);

        img_1 = findViewById(R.id.imageView);
        img_2 = findViewById(R.id.imageView2);
        img_3 = findViewById(R.id.imageView3);

        txt_1.setText("Lesson 2");
        txt_2.setText("laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat");
        txt_3.setText("ulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");

        img_1.setImageResource(R.drawable.bird_view_wroclaw);
        img_2.setImageResource(R.drawable.back_image);
        img_3.setImageResource(R.drawable.bird_view_wroclaw);
    }

    @Override
    protected void onResume() {
        list.changeOnScreen(true);
        alphaMovieView.onResume();
        super.onResume();
    }

    @Override
    public void onBackPressed() {
        MainActivity.main.getWindow();
        this.finish();
    }

    @Override
    public void onPause() {
        super.onPause();
        alphaMovieView.onPause();
    }
}
