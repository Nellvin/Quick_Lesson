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

public class Test1 extends AppCompatActivity {

    private RadioGroup radioGroup;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        // Bind the components to their respective objects
        // by assigning their IDs
        // with the help of findViewById() method
        submit = findViewById(R.id.submit);
        radioGroup = findViewById(R.id.groupradio);

        // Uncheck or reset the radio buttons initially
        radioGroup.clearCheck();

        // Add the Listener to the RadioGroup
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
                            Paper.book().write("test1",true);

                        }else{
                            Paper.book().write("test1",false);
                        }
                        Paper.book().write("test1id",checkedId);
                        Paper.book().write("test1anwser",true);
                    }
                });
        submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {

                Intent intent = new Intent(Test1.this, Test2.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        if(Paper.book().read("test1id")!=null){
            radioGroup.check((Integer) Paper.book().read("test1id"));
        }
    }
}
