package com.example.myfinances;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DataEntry extends AppCompatActivity {

    //declaration
    EditText edt;
    TextView tvw;

    //function to disable fields for corresponding account type
    public void disableFields(String str) {
        switch (str) {
            case "cd":
                edt = findViewById(R.id.paymentAmount);
                edt.setEnabled(false);
                tvw = findViewById(R.id.paymentAmountLabel);
                tvw.setEnabled(false);
                break;
            case "checkingAccount":
                edt = findViewById(R.id.paymentAmount);
                edt.setEnabled(false);
                tvw = findViewById(R.id.paymentAmountLabel);
                tvw.setEnabled(false);
                edt = findViewById(R.id.interestRate);
                edt.setEnabled(false);
                tvw = findViewById(R.id.interestRateLabel);
                tvw.setEnabled(false);
                edt = findViewById(R.id.initialBalance);
                edt.setEnabled(false);
                tvw = findViewById(R.id.initialBalanceLabel);
                tvw.setEnabled(false);
                break;
            default:
                break;
        }
    }

    //function to clear the screen
    public void clearScreen() {
        EditText edt;
        edt = findViewById(R.id.paymentAmount);
        //clear the screen
        for (int i = 0 ; i < 6 ; i++) {
            switch (i) {
                case 1:
                    edt = findViewById(R.id.accountNumberInput);
                    break;
                case 2:
                    edt = findViewById(R.id.currentBalance);
                    break;
                case 3:
                    edt = findViewById(R.id.initialBalance);
                    break;
                case 4:
                    edt = findViewById(R.id.interestRate);
                    break;
                case 5:
                    edt = findViewById(R.id.paymentAmount);
                    break;
            }
            //clear the field
            edt.getText().clear();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_entry);
        Intent ip = getIntent();
        String optionSelected = ip.getStringExtra("selectedOption");
        String displayText = "";
        //code for debugging
        Toast.makeText(this, optionSelected, Toast.LENGTH_LONG).show();
        switch (optionSelected) {
            case "cd":
                displayText = "Certificate of Deposit";
                break;
            case "checkingAccount":
                displayText = "Checking Account";
                break;
            case "loans":
                displayText = "Loan";
                break;
            default:
                break;
        }
        setTitle("Enter " + displayText + " details " );
        disableFields(optionSelected);
    }


    //function to save the user account details
    public void saveDetails(View w) {
        //code for debugging purpose
        Toast.makeText(this, "Your details have been saved successfully!", Toast.LENGTH_LONG).show();

        //clear the screen after displaying saved message
        clearScreen();
    }

    //function to cancel the save activity
    public void cancelActivity(View w) {
        clearScreen();
    }
}