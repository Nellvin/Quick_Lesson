package pl.fl.quick_lesson;

import androidx.appcompat.app.AppCompatActivity;
import io.paperdb.Paper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button lesson, test, results;
    ImageView img;
    ArrayList ar;
    Boolean less_1_ended,less_2_ended,less_3_ended;
    static public Activity main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Paper.init(this);
        Paper.book().write("test1anwser", false);
        Paper.book().write("test2anwser", false);
        Paper.book().write("test3anwser", false);
        Paper.book().write("test2id",0);
        Paper.book().destroy();
        main = this;
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        Paper.book().write("video", 0);
        Paper.book().write("music", 0);

        ar= new ArrayList();

        lesson = findViewById(R.id.button4);
        test = findViewById(R.id.button5);
        results = findViewById(R.id.button6);

        lesson.setText("Lekcje");
        test.setText("Test1");
        results.setText("Wyniki");

        results.setEnabled(false);

        lesson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, Lesson1.class);
                myIntent.putExtra("key", ar); //Optional parameters
                Paper.book().write("contacts", ar);
                startActivity(myIntent);
//                finish();
            }
        });

        results.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ar = Paper.book().read("contacts");
                Toast toast = Toast.makeText(getApplicationContext(), ""+ar.size(), Toast.LENGTH_SHORT);
                toast.show();
            }
        });
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, Test1.class);
                startActivity(myIntent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        finish();
        System.exit(0);
//        super.onBackPressed();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(Paper.book().read("test1anwser") != null){
            if((boolean)(Paper.book().read("test1anwser")) == true){
                Log.d("IFNULL", String.valueOf(Paper.book().read("test1")));
            results.setEnabled(true);
            }else{
                results.setEnabled(false);
            }
        }
    }
}
