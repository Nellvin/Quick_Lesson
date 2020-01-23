package pl.fl.quick_lesson;

import androidx.appcompat.app.AppCompatActivity;
import io.paperdb.Paper;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Test3 extends AppCompatActivity {

    private RadioGroup radioGroup;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test3);
        submit = findViewById(R.id.submit);
        radioGroup = findViewById(R.id.groupradio);

        radioGroup.clearCheck();

        radioGroup.setOnCheckedChangeListener(
                new RadioGroup
                        .OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group,
                                                 int checkedId)
                    {

                        // Get the selected Radio Button
                        RadioButton radioButton= group.findViewById(checkedId);
                        if(radioButton.getText()=="1242"){
                            Paper.book().write("test3",true);

                        }else{
                            Paper.book().write("test3",false);
                        }
                        Paper.book().write("test3id",checkedId);
                        Paper.book().write("test3anwser",true);
                    }
                });
        submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {

                Intent intent = new Intent(Test3.this, Test2.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        if(Paper.book().read("test3id")!=null){
            radioGroup.check((Integer) Paper.book().read("test3id"));
        }
    }
}
