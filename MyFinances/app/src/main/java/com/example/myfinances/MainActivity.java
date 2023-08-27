package com.example.myfinances;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.*;
import android.widget.*;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    RadioGroup rg;
    private String selectedOptionText;
    private int selectedOptionId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("My Finances");
    }

    public void navigateToDataEntry(View vw) {
        rg = findViewById(R.id.accountTypes);
        selectedOptionId = vw.getId();


        switch (selectedOptionId) {
            case R.id.loan:
                selectedOptionText = "loans";
                break;
            case R.id.cdeposit:
                selectedOptionText = "cd";
                break;
            case R.id.checking:
                selectedOptionText = "checkingAccount";
                break;
            default:
                break;
        }
//        code added for debugging purposes should be deleted before final submission
//        Toast.makeText(this, selectedOptionText, Toast.LENGTH_SHORT).show();

        //navigate to data entry activity
        Intent input = new Intent(this, DataEntry.class);
        input.putExtra("selectedOption", selectedOptionText);
        startActivity(input);
    }
}