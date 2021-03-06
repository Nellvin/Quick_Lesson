package pl.fl.quick_lesson;

import androidx.appcompat.app.AppCompatActivity;
import io.paperdb.Paper;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Test2 extends AppCompatActivity {

    private RadioGroup radioGroup;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        submit = (Button)findViewById(R.id.submit);
        radioGroup = (RadioGroup)findViewById(R.id.groupradio);

        radioGroup.clearCheck();

        radioGroup.setOnCheckedChangeListener(
                new RadioGroup
                        .OnCheckedChangeListener() {
                    @Override

                    // The flow will come here when
                    // any of the radio buttons in the radioGroup
                    // has been clicked

                    // Check which radio button has been clicked
                    public void onCheckedChanged(RadioGroup group,
                                                 int checkedId)
                    {

                        // Get the selected Radio Button
                        RadioButton
                                radioButton
                                = (RadioButton)group
                                .findViewById(checkedId);
                        if(radioButton.getText()=="1242"){
                            Paper.book().write("test2",true);

                        }else{
                            Paper.book().write("test2",false);
                        }
                        Paper.book().write("test2id",checkedId);
                        Paper.book().write("test2anwser",true);
                    }
                });
        submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(Test2.this, Test3.class);
                startActivity(intent);
                Test2.this.finish();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        if(Paper.book().read("test2id")!=null){
            radioGroup.check((Integer) Paper.book().read("test2id"));
        }
    }
}
