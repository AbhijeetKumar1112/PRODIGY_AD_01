package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Objects;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class MainActivity extends AppCompatActivity{
    AppCompatButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btn00, btnPlus, btnMinus, btnMultiply, btnDot, btnSlash, btnEqual, btnAC, btnDE;
    TextView text;
    String CurrentText ="";
    int flag =1, flag1 =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main
        );

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btn0 = findViewById(R.id.btnZero);
        btn00 = findViewById(R.id.btnZeroZero);
        btnPlus = findViewById(R.id.btnPlus);
        btnMinus = findViewById(R.id.btnMinus);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnDot = findViewById(R.id.btnDot);
        btnSlash = findViewById(R.id.btnSlash);
        btnEqual = findViewById(R.id.btnEqual);
        btnAC = findViewById(R.id.btnAC);
        btnDE = findViewById(R.id.btnDE);
        text = findViewById(R.id.text);


        text.setText(CurrentText);
    }

    public void setValue(String givenValue){
        CurrentText = CurrentText + givenValue;
        text.setText(CurrentText);
    }

    public void ClickOne(View view){
        flag = 0;
        setValue("1");
    }
    public void ClickTwo(View view){
        flag = 0;
        setValue("2");
    }
    public void ClickThree(View view){
        flag = 0;
        setValue("3");
    }
    public void ClickFour(View view){
        flag = 0;
        setValue("4");
    }
    public void ClickFive(View view){
        flag = 0;
        setValue("5");
    }
    public void ClickSix(View view){
        flag = 0;
        setValue("6");
    }
    public void ClickSeven(View view){
        flag = 0;
        setValue("7");
    }
    public void ClickEight(View view){
        flag = 0;
        setValue("8");
    }
    public void ClickNine(View view){
        flag = 0;
        setValue("9");
    }

    public void ClickZero(View view){
        flag = 0;
        setValue("0");
    }
    public void ClickDoubleZero(View view) {
        flag = 0;
        flag1 = 1;
        if (Objects.equals(CurrentText, "")) {
            text.setText("");
        } else {
            setValue("00");
        }
    }
    public void ClickPlus(View view){
        if(flag!=1) {
            setValue("+");
            flag = 1;
            flag1 = 0;
        }
        else if(Objects.equals(CurrentText, "")){
            setValue("");
        } else {
            setValue("");
        }
    }
    public void ClickMinus(View view){
        if(flag!=1) {
            setValue("-");
            flag = 1;
            flag1 = 0;
        }
        else if(CurrentText == ""){
            setValue("-");
        }
    }
    public void ClickMultiply(View view){
        if(flag!=1) {
            setValue("*");
            flag = 1;
            flag1 = 0;

        }
        else if(Objects.equals(CurrentText, "")){
            setValue("");
        } else {
            setValue("");
        }
    }
    public void ClickSlash(View view){
        if(flag!=1) {
            setValue("/");
            flag1 = 0;
            flag = 1;
        }
        else if(Objects.equals(CurrentText, "")){
            setValue("");
        }else {
            setValue("");
        }
    }

    public void ClickEqual(View view) throws ScriptException {
        Double result = null;
        if(flag !=1) {
            ScriptEngine engine = new ScriptEngineManager().getEngineByName("rhino");
            result = (double) engine.eval(CurrentText);

            if (result != null) {
                text.setText(String.valueOf(result.doubleValue()));
                CurrentText = "";
            }
        }else{
            setValue("");
        }

    }
    public void ClickDE(View view){
        if(flag == 1){
            flag =0;
        }
        if(flag1 ==1){
            flag1=0;
        }
        if(CurrentText.length()>1){
            CurrentText = CurrentText.substring(0, CurrentText.length()-1);
            text.setText(CurrentText);
        } else if (CurrentText.length() ==1) {
            CurrentText = "";
            text.setText(CurrentText);
        }
    }

    public void ClickAC(View view){
        CurrentText = "";
        text.setText("");
        flag = 1;
        flag1 = 0;
    }
    public void ClickDot(View view){
        if(flag == 1){
            flag1 =1;
        }
        if(flag1 == 1){
            setValue("");
        }else if(flag1 == 0){
            setValue(".");
            flag1 = 1;
            flag = 1;
        }

    }


}