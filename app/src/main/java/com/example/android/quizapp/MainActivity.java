package com.example.android.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity {
    final int QUESTIONNUMBER = 8; //Questions piece
    public int goodScore; //correct answer piece
    public int wrongScore; //wrong answer piece
    public int noScore; // missing answer piece

    //1. Question Group 1. Question RadioButtons
    @BindView(R.id.aDas) RadioButton radioButtonDasA;
    @BindView(R.id.aDer) RadioButton radioButtonDerA;
    @BindView(R.id.aDie) RadioButton radioButtonDieA;
    //1. Question Group 2. Question RadioButtons
    @BindView(R.id.bDas) RadioButton radioButtonDasB;
    @BindView(R.id.bDer) RadioButton radioButtonDerB;
    @BindView(R.id.bDie) RadioButton radioButtonDieB;
    //1. Question Group 3. Question RadioButtons
    @BindView(R.id.cDas) RadioButton radioButtonDasC;
    @BindView(R.id.cDer) RadioButton radioButtonDerC;
    @BindView(R.id.cDie) RadioButton radioButtonDieC;
    //1. Question Group 4. Question RadioButtons
    @BindView(R.id.dDas) RadioButton radioButtonDasD;
    @BindView(R.id.dDer) RadioButton radioButtonDerD;
    @BindView(R.id.dDie) RadioButton radioButtonDieD;
    //1. Question Group 5. Question RadioButtons
    @BindView(R.id.eDas) RadioButton radioButtonDasE;
    @BindView(R.id.eDer) RadioButton radioButtonDerE;
    @BindView(R.id.eDie) RadioButton radioButtonDieE;
    //1. Question Group RadioGroups
    @BindView(R.id.aQuestionRadioGroup) RadioGroup RadioGroupQuizA;
    @BindView(R.id.bQuestionRadioGroup) RadioGroup RadioGroupQuizB;
    @BindView(R.id.cQuestionRadioGroup) RadioGroup RadioGroupQuizC;
    @BindView(R.id.dQuestionRadioGroup) RadioGroup RadioGroupQuizD;
    @BindView(R.id.eQuestionRadioGroup) RadioGroup RadioGroupQuizE;
    //2. Question Group 1. Question CheckBoxes
    @BindView(R.id.checkboxFDer) CheckBox CheckBoxFDer;
    @BindView(R.id.checkboxFDie) CheckBox CheckBoxFDie;
    @BindView(R.id.checkboxFDas) CheckBox CheckBoxFDas;
    @BindView(R.id.checkboxFEin) CheckBox CheckBoxFEin;
    @BindView(R.id.checkboxFEine) CheckBox CheckBoxFEine;
    @BindView(R.id.checkboxFNie) CheckBox CheckBoxFNie;
    //2. Question Group 2. Question CheckBoxes
    @BindView(R.id.checkboxGDer) CheckBox CheckBoxGDer;
    @BindView(R.id.checkboxGDie) CheckBox CheckBoxGDie;
    @BindView(R.id.checkboxGDas) CheckBox CheckBoxGDas;
    @BindView(R.id.checkboxGEin) CheckBox CheckBoxGEin;
    @BindView(R.id.checkboxGEine) CheckBox CheckBoxGEine;
    @BindView(R.id.checkboxGNie) CheckBox CheckBoxGNie;
    //3. Question Group 1. Question EditText
    @BindView(R.id.editTextHText) EditText EditTextHText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
       }

    //result display
    private void display() {
        String messageText;
        messageText = String.format(getResources().getString(R.string.messageText), goodScore, wrongScore, noScore);
        if (goodScore == QUESTIONNUMBER) {
            //flawless answer
            messageText += getString(R.string.good);
        } else {
            //wrong answer
            messageText += getString(R.string.wrong);
        }
        Toast.makeText(getApplicationContext(), messageText, Toast.LENGTH_LONG).show();
    }

    /**
     * @param groupSelectedButtonId //answer radiogrup id
     * @param derButtonId           // answer radioButton id
     * @param dieButtonId           // answer radioButton id
     * @param dasButtonId           // answer radioButton id
     * @param goodAnswer            // correct answer
     */
    private void oneGroupAnswerControl(int groupSelectedButtonId, int derButtonId, int dieButtonId, int dasButtonId, String goodAnswer
    ) {
        // This is checking of RadioButton designation
        if (groupSelectedButtonId == derButtonId) {
            //correct answer verification
            if (goodAnswer.equalsIgnoreCase("der")) {
                goodScore++;
            } else {
                wrongScore++;
            }
        } else if (groupSelectedButtonId == dieButtonId) {
            //correct answer verification
            if (goodAnswer.equalsIgnoreCase("die")) {
                goodScore++;
            } else {
                wrongScore++;
            }
        } else if (groupSelectedButtonId == dasButtonId) {
            //correct answer verification
            if (goodAnswer.equalsIgnoreCase("das")) {
                goodScore++;
            } else {
                wrongScore++;
            }
        } else {
            //no checked answer
            noScore++;
        }
    }

    /**
     * @param CheckBoxDer             // answer checkbox
     * @param CheckBoxDie             // answer checkbox
     * @param CheckBoxDas             // answer checkbox
     * @param CheckBoxEin             // answer checkbox
     * @param CheckBoxEine            // answer checkbox
     * @param CheckBoxNie             // answer checkbox
     * @param goodDefiniteArticle     // good answer definite article
     * @param goodIndefiniteArticle// good answer indefinite article
     */
    private void twoGroupAnswerControl(CheckBox CheckBoxDer, CheckBox CheckBoxDie, CheckBox CheckBoxDas, CheckBox CheckBoxEin, CheckBox CheckBoxEine, CheckBox CheckBoxNie, String goodDefiniteArticle, String goodIndefiniteArticle) {
        int checkedAnswer = 0;
        int answerDb = 0;

        // answer piece counting
        if (CheckBoxDer.isChecked())
            answerDb++;
        if (CheckBoxDie.isChecked())
            answerDb++;
        if (CheckBoxDas.isChecked())
            answerDb++;
        if (CheckBoxEin.isChecked())
            answerDb++;
        if (CheckBoxEine.isChecked())
            answerDb++;
        if (CheckBoxNie.isChecked())
            answerDb++;

        if (answerDb == 0) {
            //no checked answer
            noScore++;
        }
        if (answerDb == 2) {
            //correct answer verification
            if (goodDefiniteArticle.equalsIgnoreCase("die")) {
                if (CheckBoxDie.isChecked()) {
                    checkedAnswer++;
                }
            }

            if (goodDefiniteArticle.equalsIgnoreCase("der")) {
                if (CheckBoxDer.isChecked()) {
                    checkedAnswer++;
                }
            }
            if (goodDefiniteArticle.equalsIgnoreCase("das")) {
                if (CheckBoxDas.isChecked()) {
                    checkedAnswer++;
                }
            }
            if (goodIndefiniteArticle.equalsIgnoreCase("ein")) {
                if (CheckBoxEin.isChecked()) {
                    checkedAnswer++;
                }
            }
            if (goodIndefiniteArticle.equalsIgnoreCase("eine")) {
                if (CheckBoxEine.isChecked()) {
                    checkedAnswer++;
                }
            }
            if (goodIndefiniteArticle.equalsIgnoreCase("nie")) {
                if (CheckBoxNie.isChecked()) {
                    checkedAnswer++;
                }
            }
        }

        if (checkedAnswer == 2) {
            goodScore++;
        } else if (answerDb != 0) {
            wrongScore++;
        }
    }

    /**
     * @param editTextAnswer // answer edittext
     * @param goodAntwort    // good answer
     */
    private void threeGroupAnswerControl(EditText editTextAnswer, String goodAntwort) {
        String gotAnswer;
        int noAntwort = 0;

        gotAnswer = editTextAnswer.getText().toString();
        if (gotAnswer.equalsIgnoreCase(""))
            noAntwort++;
        //correct answer verification
        if (goodAntwort.equalsIgnoreCase(gotAnswer)) {
            goodScore++;
        } else if (noAntwort == 0) {
            wrongScore++;
        } else {
            noScore++;
        }
    }

    /**
     * @param value // enabled value
     */
    private void enabledButton(boolean value) {
        Button buttonEvaluation = (Button) findViewById(R.id.evaluation);
        buttonEvaluation.setEnabled(value);
    }

    /**
     * @param value // enabled value
     */
    private void enableRadioGroupe(boolean value) {

        for (int i = 0; i < RadioGroupQuizA.getChildCount(); i++) {
            //1.Question Radiogroup clear
            RadioGroupQuizA.getChildAt(i).setEnabled(value);
        }
        for (int i = 0; i < RadioGroupQuizB.getChildCount(); i++) {
            //2.Question Radiogroup clear
            RadioGroupQuizB.getChildAt(i).setEnabled(value);
        }
        for (int i = 0; i < RadioGroupQuizC.getChildCount(); i++) {
            //3.Question Radiogroup clear
            RadioGroupQuizC.getChildAt(i).setEnabled(value);
        }
        for (int i = 0; i < RadioGroupQuizD.getChildCount(); i++) {
            //4.Question Radiogroup clear
            RadioGroupQuizD.getChildAt(i).setEnabled(value);
        }
        for (int i = 0; i < RadioGroupQuizE.getChildCount(); i++) {
            //5.Question Radiogroup clear
            RadioGroupQuizE.getChildAt(i).setEnabled(value);
        }
    }

    /**
     * @param value // enabled value
     */
    private void enableCheckBox(boolean value) {
        //2.Question Group 1. Question CheckBoxes enabled giving validity
        CheckBoxFDer.setEnabled(value);
        CheckBoxFDie.setEnabled(value);
        CheckBoxFDas.setEnabled(value);
        CheckBoxFEin.setEnabled(value);
        CheckBoxFEine.setEnabled(value);
        CheckBoxFNie.setEnabled(value);
        //2.Question Group 2. Question CheckBoxes enabled giving validity
        CheckBoxGDer.setEnabled(value);
        CheckBoxGDie.setEnabled(value);
        CheckBoxGDas.setEnabled(value);
        CheckBoxGEin.setEnabled(value);
        CheckBoxGEine.setEnabled(value);
        CheckBoxGNie.setEnabled(value);
    }

    /**
     * @param value // enabled value
     */
    private void enableEditText(boolean value) {
        //3. Question Group 1. Question EditText enabled giving validity
        EditTextHText.setEnabled(value);
    }

    //answer clear
    public void reset(View view) {
        goodScore = 0;
        wrongScore = 0;
        noScore = 0;

        //1. Question Group 1.Question Radiogroup clear
        RadioGroupQuizA.clearCheck();
        //1. Question Group 2.Question Radiogroup clear
        RadioGroupQuizB.clearCheck();
        //1. Question Group 3.Question Radiogroup clear
        RadioGroupQuizC.clearCheck();
        //1. Question Group 4.Question Radiogroup clear
        RadioGroupQuizD.clearCheck();
        //1. Question Group 5.Question Radiogroup clear
        RadioGroupQuizE.clearCheck();
        //2. Question Group 1. Question CheckBoxes clear
        CheckBoxFDer.setChecked(false);
        CheckBoxFDie.setChecked(false);
        CheckBoxFDas.setChecked(false);
        CheckBoxFEin.setChecked(false);
        CheckBoxFEine.setChecked(false);
        CheckBoxFNie.setChecked(false);
        //2. Question Group 2. Question CheckBoxes clear
        CheckBoxGDer.setChecked(false);
        CheckBoxGDie.setChecked(false);
        CheckBoxGDas.setChecked(false);
        CheckBoxGEin.setChecked(false);
        CheckBoxGEine.setChecked(false);
        CheckBoxGNie.setChecked(false);
        //3. QuestionGroup 1. Question EditText clear
        EditTextHText.setText("");
        //RadioGroup enable true
        enableRadioGroupe(true);
        //button enabled true
        enabledButton(true);
        //CheckBox enable true
        enableCheckBox(true);
        //EditText enabled true
        enableEditText(true);
    }

    public void onClick(View v) {
        // 1.Question Group answers control 1-5 questions
        //radioButtonDasA.getId()
        oneGroupAnswerControl(RadioGroupQuizA.getCheckedRadioButtonId(), radioButtonDerA.getId(), radioButtonDieA.getId(), radioButtonDasA.getId() , "der");
        oneGroupAnswerControl(RadioGroupQuizB.getCheckedRadioButtonId(), radioButtonDerB.getId(), radioButtonDieB.getId(), radioButtonDasB.getId(), "der");
        oneGroupAnswerControl(RadioGroupQuizC.getCheckedRadioButtonId(), radioButtonDerC.getId(), radioButtonDieC.getId(), radioButtonDasC.getId(), "der");
        oneGroupAnswerControl(RadioGroupQuizD.getCheckedRadioButtonId(), radioButtonDerD.getId(), radioButtonDieD.getId(), radioButtonDasD.getId(), "der");
        oneGroupAnswerControl(RadioGroupQuizE.getCheckedRadioButtonId(), radioButtonDerE.getId(), radioButtonDieE.getId(), radioButtonDasE.getId(), "der");
        // 2. Question Group answer control
        twoGroupAnswerControl(CheckBoxFDer, CheckBoxFDie, CheckBoxFDas, CheckBoxFEin, CheckBoxFEine, CheckBoxFNie, "das", "ein");
        twoGroupAnswerControl(CheckBoxGDer, CheckBoxGDie, CheckBoxGDas, CheckBoxGEin, CheckBoxGEine, CheckBoxGNie, "die", "eine");
        //3. Question Group answer control
        threeGroupAnswerControl(EditTextHText, "Zimmer");
        // RadioGroup Enable false
        enableRadioGroupe(false);
        // Button Enable false
        enabledButton(false);
        // CheckBox Enabled false
        enableCheckBox(false);
        // EditText Enabled false
        enableEditText(false);
        // result display
        display();
    }
}
