package com.example.studymore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.studymore.ui.Quiz.Question;
import com.example.studymore.ui.Quiz.QuestionDatabase;

public class QuizActivity extends AppCompatActivity {

    ConstraintLayout questionLayout;
    TextView questionNumber;
    TextView question;
    TextView option1;
    TextView option2;
    TextView option3;
    RadioGroup radioGroup;
    RadioButton radioButton;

    ConstraintLayout questionAnsweredLayout;
    Button checkAnswerBtn;
    Button nextQuestionBtn;


    ConstraintLayout endLayout;
    TextView endScore;
    Button saveScoreBtn;

    //question number
    private Question questionData;
    int i = 1;
    int score = 0;

    String selectedResult;
    TextView result;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        //Main question screen views
        questionLayout = findViewById(R.id.questionLayout);
        questionNumber = findViewById(R.id.questionNumber);
        question = findViewById(R.id.question);
        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        radioGroup = findViewById(R.id.quizRadioGroup);

        //Answered options view
        questionAnsweredLayout = findViewById(R.id.questionAnsweredOptions);
        result = findViewById(R.id.result);
        nextQuestionBtn = findViewById(R.id.nextQuestionBtn);

        //End screen layout views
        endLayout = findViewById(R.id.endLayout);
        endScore = findViewById(R.id.endScore);
        saveScoreBtn = findViewById(R.id.saveScoreBtn);

        questionNumber.setText("Question " + Integer.toString(i));

        questionData = QuestionDatabase.getQuestionById(1);

        question.setText(questionData.getQuestion());
        option1.setText(questionData.getOption1());
        option2.setText(questionData.getOption2());
        option3.setText(questionData.getOption3());

        checkAnswerBtn = findViewById(R.id.checkAnswerBtn);
        checkAnswerBtn.setOnClickListener(new View.OnClickListener(){
            @Override
                public void onClick(View v){
            int radioId = radioGroup.getCheckedRadioButtonId();
            radioButton = findViewById(radioId);

            selectedResult = radioButton.getText().toString();

            questionAnsweredLayout.setVisibility(View.VISIBLE);

            if(selectedResult==questionData.getAnswer()){
                result.setText("Correct");
                score = score + 1;
            }
            else{
                result.setText("Incorrect");
            }

            if(i==10){
                nextQuestionBtn.setText("Finish Quiz :)");
            }

            }
        });

        nextQuestionBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(i<10){
                    setQuestion();
                    questionAnsweredLayout.setVisibility(View.INVISIBLE);
                }
                else{
                    endLayout.setVisibility(View.VISIBLE);
                    questionLayout.setVisibility(View.INVISIBLE);
                    endScore.setText(Integer.toString(score)+"/10");
                }
            }
        });
    }

    public void setQuestion(){
        i = i + 1;
        questionData = QuestionDatabase.getQuestionById(i);
        questionNumber.setText("Question " + Integer.toString(i));
        question.setText(questionData.getQuestion());
        option1.setText(questionData.getOption1());
        option2.setText(questionData.getOption2());
        option3.setText(questionData.getOption3());
    }

    public void checkButton(View v){
        int radioId = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(radioId);
    }
}
