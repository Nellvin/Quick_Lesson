package pl.fl.quick_lesson;

import androidx.appcompat.app.AppCompatActivity;
import io.paperdb.Paper;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.transition.Explode;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Results1 extends AppCompatActivity {

    private RadioGroup radioGroup;
    Button submit;
    RadioButton r1,r2,r3,r4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_results1);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        submit = findViewById(R.id.submit);
        radioGroup = findViewById(R.id.groupradio);

        r1=findViewById(R.id.radia_id1);
        r2=findViewById(R.id.radia_id2);
        r3=findViewById(R.id.radia_id3);
        r4=findViewById(R.id.radia_id4);

        submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {

                Intent intent = new Intent(Results1.this, Results2.class);
                startActivity(intent);
                Results1.this.finish();
            }
        });

        r1.setClickable(false);
        r2.setClickable(false);
        r3.setClickable(false);
        r4.setClickable(false);

    }

    @Override
    protected void onResume() {
        super.onResume();
        r2.setBackgroundColor(Color.GREEN);
        if(Paper.book().read("test1id")!=null){
            radioGroup.check((Integer) Paper.book().read("test1id"));
            if((Integer) Paper.book().read("test1id")!=r2.getId()){
                RadioButton rr = findViewById((Integer) Paper.book().read("test1id"));
                rr.setBackgroundColor(Color.RED);
            }
        }
    }
}
