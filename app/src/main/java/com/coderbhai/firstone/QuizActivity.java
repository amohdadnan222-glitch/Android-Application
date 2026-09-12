package com.coderbhai.firstone;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class QuizActivity extends AppCompatActivity {

    TextView question, scoreText;
    RadioGroup radioGroup;
    RadioButton option1, option2, option3, option4;
    Button nextBtn;

    String questions[] = {
            "Capital of India?",
            "2 + 2 = ?",
            "Android is developed by?"
    };

    String answers[] = {
            "New Delhi",
            "4",
            "Google"
    };

    String options[][] = {
            {"Delhi","Mumbai","New Delhi","Lucknow"},
            {"3","4","5","6"},
            {"Apple","Google","Microsoft","Meta"}
    };

    int index = 0;
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        question = findViewById(R.id.question);
        scoreText = findViewById(R.id.scoreText);

        radioGroup = findViewById(R.id.radioGroup);

        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);

        nextBtn = findViewById(R.id.nextBtn);

        loadQuestion();

        nextBtn.setOnClickListener(v -> {

            int selectedId =
                    radioGroup.getCheckedRadioButtonId();

            if(selectedId != -1){

                RadioButton selected =
                        findViewById(selectedId);

                if(selected.getText().toString()
                        .equals(answers[index])){

                    score++;
                }
            }

            index++;

            if(index < questions.length){

                loadQuestion();

            } else {

                scoreText.setText(
                        "Quiz Finished\nScore = "
                                + score + "/"
                                + questions.length);

                nextBtn.setEnabled(false);
            }

            radioGroup.clearCheck();
        });
    }

    private void loadQuestion(){

        question.setText(questions[index]);

        option1.setText(options[index][0]);
        option2.setText(options[index][1]);
        option3.setText(options[index][2]);
        option4.setText(options[index][3]);
    }
}