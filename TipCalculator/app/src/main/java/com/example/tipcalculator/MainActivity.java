package com.example.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.widget.*;
import android.view.*;

import java.util.IllegalFormatCodePointException;

public class MainActivity extends AppCompatActivity {

    //declaration
    private TextView tvw;
    private EditText edt;
    private double totalBillAmount; //total bill amount
    private double tipAmount; //tip amount
    private int btnPressed; //tip button pressed
    private Editable enteredBillAmount; //bill amount entered by the user
    private int billAmount;
    private String formattedTipAmount; //tip amount to be displayed only two digits after the decimal
    private String formattedTotalBillAmount; //total bill amount to be display only two digits after the decimal
    private String finalDisplayText; //final text to be displayed to the user

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //function to calculate the total bill amount using the entered bill amount and the tip button pressed
    public void calculateTip(View vw) {
        //fetch the entered bill amount and tip button pressed
        edt = findViewById(R.id.billAmountInput);
        tvw = findViewById(R.id.totalBillView);
        btnPressed = vw.getId();
        enteredBillAmount = edt.getText();

        //convert text to number to perform calculations
        billAmount = Integer.parseInt(String.valueOf(enteredBillAmount));

        //calculate the tip and total amount based on the tip amount
        switch (btnPressed) {
            case R.id.fifteenPercentBtn:
                tipAmount = billAmount * 0.15;
                break;
            case R.id.eighteenPercentBtn:
                tipAmount = billAmount * 0.18;
                break;
            case R.id.twentyPercentBtn:
                tipAmount = billAmount * 0.20;
                break;
            default:
                break;
        }
        formattedTipAmount = String.format("%.2f",tipAmount);
        totalBillAmount = billAmount + tipAmount;
        formattedTotalBillAmount = String.format("%.2f",totalBillAmount);
        finalDisplayText = "Tip: $" + formattedTipAmount + ", " + "Total Bill: $" + formattedTotalBillAmount ;
        tvw.setText(finalDisplayText);
    }
}