package pl.fl.quick_lesson;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Lesson3 extends AppCompatActivity {

    TextView txt_1, txt_2, txt_3;
    ImageView img_1, img_2, img_3;
    OnSwipeTouchListener list;
    public static Activity fa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson3);

        fa=this;

        LinearLayout linlay = findViewById(R.id.linlay);
        list= new OnSwipeTouchListener(this,"lesson3");
        linlay.setOnTouchListener(list);
        txt_1 = findViewById(R.id.textView2);
        txt_2 = findViewById(R.id.textView3);
        txt_3 = findViewById(R.id.textView4);

        img_1 = findViewById(R.id.imageView);
        img_2 = findViewById(R.id.imageView2);
        img_3 = findViewById(R.id.imageView3);

        txt_1.setText("Lesson 3");
        txt_2.setText("laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat");
        txt_3.setText("ulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");

        img_1.setImageResource(R.drawable.bird_view_wroclaw);
        img_2.setImageResource(R.drawable.back_image);
        img_3.setImageResource(R.drawable.bird_view_wroclaw);
    }
    @Override
    protected void onResume() {
        list.changeOnScreen(true);
        super.onResume();
    }
    @Override
    public void onBackPressed() {
        MainActivity.main.getWindow();
        this.finish();
    }

}
