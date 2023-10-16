package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button zero, one, two, three, four, five, six, seven, eight, nine; //Number buttons
    Button clear, minus, plus, dot, equal, divide, multiplication; //Function buttons
    TextView output;

    String[] numArray = {"", ""};

    String outputValue = "";

    //variables to check what mathematical function is chosen
    boolean checkPlus, checkMinus, checkDivide, checkMultiplication = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewsVariablesAssignment();
        setButtonListeners();
    }

    public void viewsVariablesAssignment(){

        //Numbers
        zero = findViewById(R.id.zero);
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);

        //Function buttons
        clear = findViewById(R.id.clear);
        minus = findViewById(R.id.minus);
        plus = findViewById(R.id.plus);
        divide = findViewById(R.id.divide);
        equal = findViewById(R.id.equals);
        dot = findViewById(R.id.dot);
        multiplication = findViewById(R.id.multiplication);

        //Output
        output = findViewById(R.id.OutputTxt);
    }

    private void setButtonListeners(){

        zero.setOnClickListener(this);
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        clear.setOnClickListener(this);
        minus.setOnClickListener(this);
        plus.setOnClickListener(this);
        divide.setOnClickListener(this);
        equal.setOnClickListener(this);
        dot.setOnClickListener(this);
        multiplication.setOnClickListener(this);
    }

    private void outputText(String number){

        outputValue += number;
        output.setText(outputValue);
    }

    private void storeNumbers() {

        if (!numArray[0].isEmpty()) {
            finalizingOutcome();
        }
        else {
            numArray[0] = outputValue;
        }
        outputValue = "";
        output.setText(outputValue);
    }

    private void mathematicalFunctionCheck(String function){

        switch (function) {
            case "+":

                checkPlus = true;
                checkMinus = false;
                checkDivide = false;
                checkMultiplication = false;
                break;

            case "-":

                checkPlus = false;
                checkMinus = true;
                checkDivide = false;
                checkMultiplication = false;
                break;

            case "*":

                checkPlus = false;
                checkMinus = false;
                checkDivide = false;
                checkMultiplication = true;
                break;

            case "/":

                checkPlus = false;
                checkMinus = false;
                checkDivide = true;
                checkMultiplication = false;
                break;
        }
    }

    private void finalizingOutcome(){

        numArray[1] = outputValue;
        float num1, num2;
        String finalNumber;
        num1 = Float.parseFloat(numArray[0]);
        num2 = Float.parseFloat(numArray[1]);

        if (checkMultiplication) {
            finalNumber = Float.toString(num1 * num2);
            output.setText(finalNumber);
            numArray[0] = finalNumber;
            numArray[1] = "";
            checkMultiplication = false;
        }
        else if (checkDivide) {
            finalNumber = Float.toString(num1 / num2);
            output.setText(finalNumber);
            numArray[0] = finalNumber;
            numArray[1] = "";
            checkDivide = false;
        }
        else if (checkPlus) {
            finalNumber = Float.toString(num1 + num2);
            output.setText(finalNumber);
            numArray[0] = finalNumber;
            numArray[1] = "";
            checkPlus = false;
        }
        else if (checkMinus) {
            finalNumber = Float.toString(num1 - num2);
            output.setText(finalNumber);
            numArray[0] = finalNumber;
            numArray[1] = "";
            checkMinus = false;
        }
    }

    @Override
    public void onClick(View v) {

        int keyId = v.getId();

        //Number keys listeners
        if (keyId == R.id.zero){
            outputText("0");
        }
        else if (keyId == R.id.one){
            outputText("1");
        }
        else if (keyId == R.id.two){
            outputText("2");
        }
        else if (keyId == R.id.three){
            outputText("3");
        }
        else if (keyId == R.id.four){
            outputText("4");
        }
        else if (keyId == R.id.five){
            outputText("5");
        }
        else if (keyId == R.id.six){
            outputText("6");
        }
        else if (keyId == R.id.seven){
            outputText("7");
        }
        else if (keyId == R.id.eight){
            outputText("8");
        }
        else if (keyId == R.id.nine){
            outputText("9");
        }

        //Function keys listeners
        if (keyId == R.id.clear){
            outputValue = "";
            numArray[0] = "";
            numArray[1] = "";
            output.setText(outputValue);
        }

        if (keyId == R.id.equals && !numArray[0].isEmpty()){
            finalizingOutcome();
        }
        else if (keyId == R.id.plus){
            storeNumbers();
            mathematicalFunctionCheck("+");
        }
        else if (keyId == R.id.minus){
            storeNumbers();
            mathematicalFunctionCheck("-");
        }
        else if (keyId == R.id.multiplication){
            storeNumbers();
            mathematicalFunctionCheck("*");
        }
        else if (keyId == R.id.divide){
            storeNumbers();
            mathematicalFunctionCheck("/");
        }
        else if (keyId == R.id.dot) {
            if (!outputValue.contains(".") && !outputValue.isEmpty()){
                outputText(".");
            }
        }

    }
}