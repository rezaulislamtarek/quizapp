package com.jornaldobrasil.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView tvIndex,tvQsn;
    RadioGroup rgQsn;
    RadioButton rbAns;
    ImageButton ibNext;
    ArrayList<ModelQuiz> quizArrayList = new ArrayList<>();
    int index = 0;

    RadioButton op1,op2,op3,op4;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        quizArrayList.add(new ModelQuiz("Bangladesh er jatio fol ki ?","Kathal","Jam","Pepe","Peyara","Kathal"));
        quizArrayList.add(new ModelQuiz("Bangladesh er jatio ful ki ?","Kathal","Shapla","Pepe","Golap","Shapla"));
        quizArrayList.add(new ModelQuiz("Bangladesh er prodanmontri keda ?","Kathal","Jam","Pepe","Peyara","Kathal"));
        quizArrayList.add(new ModelQuiz("Bangladesh er jatio  kobi ki ?","Kathal","Jam","Pepe","Peyara","Kathal"));


    }

    @Override
    protected void onResume() {
        super.onResume();

        int no = index+1;
        tvIndex.setText(no+"");
        tvQsn.setText(quizArrayList.get(index).getQsn());
        op1.setText(quizArrayList.get(index).getOp1());
        op2.setText(quizArrayList.get(index).getOp2());
        op3.setText(quizArrayList.get(index).getOp3());
        op4.setText(quizArrayList.get(index).getOp4());



        ibNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int rbId = rgQsn.getCheckedRadioButtonId();
                rbAns = findViewById(rbId);
                String userAns = rbAns.getText().toString();
                String correctAns = quizArrayList.get(index).getCorrectAns();

                if (userAns.equals(correctAns)){
                    Toast.makeText(MainActivity.this, "Correct Answer", Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(MainActivity.this, "Wrong!\n correct ans is: "+correctAns, Toast.LENGTH_SHORT).show();
                }


                    index=index+1;


                onResume();
            }
        });


    }




    void init(){
        tvIndex = findViewById(R.id.tv_activity_main_index);
        tvQsn = findViewById(R.id.tv_activity_main_qsn);
        rgQsn = findViewById(R.id.rg_qsn);
        ibNext = findViewById(R.id.ib_activity_main_next);

        op1 = findViewById(R.id.rb_op1);
        op2 = findViewById(R.id.rb_op2);
        op3 = findViewById(R.id.rb_op3);
        op4 = findViewById(R.id.rb_op4);

    }

}
