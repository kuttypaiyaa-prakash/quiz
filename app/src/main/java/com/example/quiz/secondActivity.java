package com.example.quiz;

import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class secondActivity extends AppCompatActivity implements View.OnClickListener {

    public static String questions[]={
            "1. How many colors are there in Indian National Flag?",
            "2. How many strokes are there in Ashok Ring?",
            "3. Which is the national animal of India?",
            "4. Which is the national bird of India?",
            "5. Who wrote national Anthem for India?",
            "6. Who is first prime minister of India?",
            "7. Who is first president of India?",
            "8. Who is first vice president of India?",
            "9. What is the National Fruit of India?",
            "10. What is the national tree of India?"
    };

    public static String choices[][]={
            {"1","2","3","4"},
            {"24","25","26","27"},
            {"Tiger","Lion","Cheetah","None of the above"},
            {"Peacock","Crow","Sparrow","Parrot"},
            {"Rabindranath Tagore","Mahakavi Bharathi","Jawaharlal Nehru","None of the above"},
            {"Jawaharlal Nehru","Dr APJ Abdul Kalam","Narendra Modi","Manmohan Singh"},
            {"Jawaharlal Nehru","Dr Radhakrishnan","Dr Rajendira Prasad","Manmohan Singh"},
            {"Jawaharlal Nehru","Dr Radhakrishnan","Dr Rajendira Prasad","Manmohan Singh"},
            {"Mango","Orange","Guava","Jack Fruit"},
            {"Banyan Tree","Fig Tree","Mango Tree","Orange Tree"}
    };

    public static String correctAnswers[]={
            "3",
            "24",
            "Tiger",
            "Peacock",
            "Rabindranath Tagore",
            "Jawaharlal Nehru",
            "Dr Rajendira Prasad",
            "Dr Radhakrishnan",
            "Mango",
            "Banyan Tree"
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
