package com.example.quiz;

import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class fourthActivity extends AppCompatActivity implements View.OnClickListener {

    public static String questions[]={
            "1.Find root of equation 3x^2-4x+1=0",
            "2. What is average of first five multiples of 12?",
            "3. Different in place value of 5 in numeral 754853",
            "4. Compound interest of Rs.2500 for 2 years rate of interest 4% per annum",
            "5. Sum of First 5 Numbers",
            "6. Factorial of 6",
            "7. Reverse of 12345",
            "8. Train at speed of 80 km/hr crosses pole in 7 seconds.So, Trains length",
            "9. Value of (5^1/4)x(125)^0.25",
            "10. What is the HCF of 1095 ad 1168"
    };

    public static String choices[][]={
            {"1,3","1,1/3","2,1/3","2,3"},
            {"36","38","40","42"},
            {"49500","49950","45000","49940"},
            {"Rs. 180","Rs. 210","Rs. 210","Rs. 220"},
            {"55","56","57","58"},
            {"120","720","140","740"},
            {"54321","54321","12345","54123"},
            {"150m","165m","175m","170m"},
            {"5","4","3","25"},
            {"37","73","43","83"}
    };

    public static String correctAnswers[]={
            "1,3",
            "36",
            "49950",
            "Rs. 204",
            "55",
            "720",
            "54321",
            "175m",
            "5",
            "73"
    };


    TextView total;
    TextView questionTextView;
    Button ansA,ansB,ansC,ansD;
    Button submit;

    int score=0;
    int totalQuestion=questions.length;
    int currentQuestionIndex=0;
    String selectedAnswer="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        questionTextView=findViewById(R.id.question);
        total=findViewById(R.id.total);
        ansA=findViewById(R.id.ansA);
        ansB=findViewById(R.id.ansB);
        ansC=findViewById(R.id.ansC);
        ansD=findViewById(R.id.ansD);
        submit=(Button) findViewById(R.id.submit);

        ansA.setOnClickListener(this);
        ansB.setOnClickListener(this);
        ansC.setOnClickListener(this);
        ansD.setOnClickListener(this);
        submit.setOnClickListener(this);

        total.setText("Total questions: "+totalQuestion);
        loadNewQuestion();
    }

    @Override

    public void onClick(View view) {

        ansA.setBackgroundColor(Color.GREEN);
        ansB.setBackgroundColor(Color.GREEN);
        ansC.setBackgroundColor(Color.GREEN);
        ansD.setBackgroundColor(Color.GREEN);


        Button clickedButton=(Button) view;
        if(clickedButton.getId()==R.id.submit){
            if(selectedAnswer.equals(correctAnswers[currentQuestionIndex]))
            {
                score++;

            }
            currentQuestionIndex++;
            loadNewQuestion();
        }
        else
        {
            selectedAnswer=clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.RED);
        }
    }

    void loadNewQuestion(){

        if(currentQuestionIndex==totalQuestion)
        {
            finishQuiz();
            return;
        }

        questionTextView.setText(questions[currentQuestionIndex]);
        ansA.setText(choices[currentQuestionIndex][0]);
        ansB.setText(choices[currentQuestionIndex][1]);
        ansC.setText(choices[currentQuestionIndex][2]);
        ansD.setText(choices[currentQuestionIndex][3]);
    }

    void finishQuiz()
    {
        String passStatus="";
        if(score>((totalQuestion*50)/100)){
            passStatus="Passed";
        }
        else
        {
            passStatus="Failed";
        }
        new AlertDialog.Builder(this)
                .setTitle(passStatus)
                .setMessage("score is "+score+"out of"+totalQuestion)
                .setPositiveButton("Restart",(dialogInterface, i) -> reStartQuiz())
                .show();
    }

    void reStartQuiz()
    {
        score=0;
        currentQuestionIndex=0;
        loadNewQuestion();
    }

}
