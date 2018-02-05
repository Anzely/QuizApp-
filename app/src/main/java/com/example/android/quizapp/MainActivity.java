package com.example.android.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
 public int goodScore =0;
 public int wrongScore =0;
 public int noScore =0;
 RadioGroup RadioGroupQuizA, RadioGroupQuizB, RadioGroupQuizC, RadioGroupQuizD, RadioGroupQuizE;
 RadioButton radioButtonDerA,radioButtonDieA,radioButtonDasA,
             radioButtonDerB, radioButtonDieB, radioButtonDasB,
             radioButtonDerC,radioButtonDieC,radioButtonDasC,
             radioButtonDerD, radioButtonDieD, radioButtonDasD,
             radioButtonDerE,radioButtonDieE,radioButtonDasE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RadioGroupQuizA = findViewById(R.id.aQuestionRadioGroup);
        RadioGroupQuizB = findViewById(R.id.bQuestionRadioGroup);
        RadioGroupQuizC = findViewById(R.id.cQuestionRadioGroup);
        RadioGroupQuizD = findViewById(R.id.dQuestionRadioGroup);
        RadioGroupQuizE = findViewById(R.id.eQuestionRadioGroup);

        radioButtonDerA = findViewById(R.id.aDer);
        radioButtonDieA = findViewById(R.id.aDie);
        radioButtonDasA = findViewById(R.id.aDas);

        radioButtonDerB = findViewById(R.id.bDer);
        radioButtonDieB = findViewById(R.id.bDie);
        radioButtonDasB = findViewById(R.id.bDas);

        radioButtonDerC = findViewById(R.id.cDer);
        radioButtonDieC = findViewById(R.id.cDie);
        radioButtonDasC = findViewById(R.id.cDas);

        radioButtonDerD = findViewById(R.id.dDer);
        radioButtonDieD = findViewById(R.id.dDie);
        radioButtonDasD = findViewById(R.id.dDas);

        radioButtonDerE = findViewById(R.id.eDer);
        radioButtonDieE = findViewById(R.id.eDie);
        radioButtonDasE = findViewById(R.id.eDas);

    }


public void display(){
String messageText ="";

EditText UserName = (EditText) findViewById(R.id.name);
String hasName = UserName.getText().toString();


messageText = hasName;
messageText += "\nCorrect answer:: "+goodScore;
messageText += "\nWrong answer: "+wrongScore;
messageText += "\nMissing answer: " +noScore;

if (goodScore == 5){
    messageText += "\n Flawless Congratulations!";

}
else{
    messageText += "\n Try again.";
}


    Toast.makeText(getApplicationContext(), messageText,
            Toast.LENGTH_LONG).show();

//user name delet
UserName.getText().clear();
}


    /**
     *
     * @param groupSelectedButtonId  //answer radiogrup id
     * @param derButtonId // answer radioButton id
     * @param dieButtonId // answer radioButton id
     * @param dasButtonId // answer radioButton id
     * @param goodAnswer // correct answer
     */
    public void answerControl(int groupSelectedButtonId, int derButtonId, int dieButtonId, int dasButtonId,String goodAnswer
    )
    {
   // This is checking of RadioButton designation

        if(groupSelectedButtonId == derButtonId) {
            //correct answer verification
            if (goodAnswer.equalsIgnoreCase("der")){
                goodScore++;
            } else {
                wrongScore++;
            }
        } else if(groupSelectedButtonId == dieButtonId) {
            //correct answer verification
            if (goodAnswer.equalsIgnoreCase("die")){
                goodScore++;
            }else {
                wrongScore++;
            }
        } else  if(groupSelectedButtonId == dasButtonId){
            //correct answer verification
            if (goodAnswer.equalsIgnoreCase("das")){
                goodScore++;
            }else {
                wrongScore++;
            }

        } else{
            //no checked answer
            noScore++;
        }


    }

    public void enabledButton(boolean value){
        Button buttonEvaluation = (Button) findViewById(R.id.evaluation);
        buttonEvaluation.setEnabled(value);

    }
    public void enableGroupe(boolean value){


     //1.Question Radiogrup clear


        for (int i = 0; i < RadioGroupQuizA.getChildCount(); i++) {
            RadioGroupQuizA.getChildAt(i).setEnabled(value);
        }


//2.Question Radiogrup clear


        for (int i = 0; i < RadioGroupQuizB.getChildCount(); i++) {
            RadioGroupQuizB.getChildAt(i).setEnabled(value);
        }
//3.Question Radiogrup clear


        for (int i = 0; i < RadioGroupQuizC.getChildCount(); i++) {
            RadioGroupQuizC.getChildAt(i).setEnabled(value);
        }

//4.Question Radiogrup clear


        for (int i = 0; i < RadioGroupQuizD.getChildCount(); i++) {
            RadioGroupQuizD.getChildAt(i).setEnabled(value);
        }
//5.Question Radiogrup clear


        for (int i = 0; i < RadioGroupQuizE.getChildCount(); i++) {
            RadioGroupQuizE.getChildAt(i).setEnabled(value);
        }


    }

    //answer clear
    public void reset(View view){

        goodScore = 0;
        wrongScore =0;
        noScore =0;
        //RadioGroup dataRadio;
//1.Question Radiogrup clear
        RadioGroupQuizA.clearCheck();

//2.Question Radiogrup clear

        RadioGroupQuizB.clearCheck();
//3.Question Radiogrup clear

        RadioGroupQuizC.clearCheck();
//4.Question Radiogrup clear

        RadioGroupQuizD.clearCheck();
//5.Question Radiogrup clear

        RadioGroupQuizE.clearCheck();

//RadioGroup enable true
        enableGroupe(true);
//button enabled true
        enabledButton(true);
    }

    public void onClick(View v) {

        //answers control 1-5 questions
        answerControl( RadioGroupQuizA.getCheckedRadioButtonId() ,radioButtonDerA.getId() ,radioButtonDieA.getId(),radioButtonDasA.getId(),"der");
        answerControl( RadioGroupQuizB.getCheckedRadioButtonId() ,radioButtonDerB.getId() ,radioButtonDieB.getId(),radioButtonDasB.getId(),"der");
        answerControl( RadioGroupQuizC.getCheckedRadioButtonId() ,radioButtonDerC.getId() ,radioButtonDieC.getId(),radioButtonDasC.getId(),"der");
        answerControl( RadioGroupQuizD.getCheckedRadioButtonId() ,radioButtonDerD.getId() ,radioButtonDieD.getId(),radioButtonDasD.getId(),"der");
        answerControl( RadioGroupQuizE.getCheckedRadioButtonId() ,radioButtonDerE.getId() ,radioButtonDieE.getId(),radioButtonDasE.getId(),"der");

      //  RadioGroup Enable false
        enableGroupe(false);
        // Button Enable false
        enabledButton(false);
        //result display
        display();

    }




}
