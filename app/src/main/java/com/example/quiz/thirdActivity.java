package com.example.quiz;

import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class thirdActivity extends AppCompatActivity implements View.OnClickListener {

    public static String questions[]={
            "1. Synonym: Idiosyncrasy",
            "2. Synonym: Clandestine",
            "3. Synonym: Ominous",
            "4. Phrasal Verbs: Break in",
            "5. Phrasal Verbs: Drop off",
            "6. Antonym: Hot",
            "7. Antonym: Off",
            "8. Antonym: Exterior",
            "9. American English: Lift",
            "10. British English: Trouser"
    };

    public static String choices[][]={
            {"Stupid","Eccentricity","Peculiar","Bold"},
            {"Secret","Candle Light","Cooperation","Cunning"},
            {"Present Everywhere","Auspicious","Priceless","Sinister"},
            {"Open a news","Interrupt","Enter","Exit"},
            {"Deliver","Reject","Take","Throw"},
            {"Cold","Heat","Energy","Fever"},
            {"On","Turn","Fall","Close"},
            {"Interior","Out","In","Off"},
            {"Elevator","Machine","Staircase","Excalators"},
            {"Pant","Leg shirt","Dress","Shirt"}
    };

    public static String correctAnswers[]={
            "Eccentricity",
            "Secret",
            "Sinister",
            "Enter",
            "Deliver",
            "Cold",
            "On",
            "Interior",
            "Elevator",
            "Pant"
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
