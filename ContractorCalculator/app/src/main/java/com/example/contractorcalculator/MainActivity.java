package com.example.contractorcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.view.*;
import android.os.Bundle;
import android.widget.*;
import java.lang.String;

public class MainActivity extends AppCompatActivity {

    public static double TAX_CONST = 0.05;
    public double materialCost, laborCost, subTotal;
    public String materialCostStr, laborCostStr;
    public double taxAmount, totalAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Contractor Calculator");
    }

    public void calculateCosts(View vw) {
        //declaration
        EditText mt = findViewById(R.id.materialAmount);
        EditText lt = findViewById(R.id.laborAmount);
        TextView st = findViewById(R.id.subtotalAmountLabel); //to handle the subtotal amount
        TextView tv = findViewById(R.id.totalAmountLabel); //to handle the total amount
        TextView tx = findViewById(R.id.taxAmountLabel); //to handle the tax amount

        // convert the user input into string for processing
        materialCostStr = mt.getText().toString();
        laborCostStr = lt.getText().toString();


        //check if the user has entered a valid value in the material/labor amount field and return early on empty
        if (materialCostStr.isEmpty() || laborCostStr.isEmpty()) {
                st.setText("Label");
                tv.setText("Label");
                tx.setText("Label");
                return;
        }

        //fetch the entered values and convert them into numbers for calculations
        materialCost = Double.parseDouble(String.valueOf(mt.getText().toString()));
        laborCost = Double.parseDouble(String.valueOf(lt.getText().toString()));

        //check if the user has entered a negative value
        if (materialCost < 0 || laborCost < 0) {
            st.setText("Label");
            tv.setText("Label");
            tx.setText("Label");
            return;
        }

        //calculate subtotal and total
        subTotal = materialCost + laborCost;
        taxAmount = subTotal * TAX_CONST;
        totalAmount = subTotal + taxAmount;

        //needs to be formatted to display with comma and two digits after decimal
        st.setText("$" + subTotal);
        tx.setText("$" + taxAmount);
        tv.setText("$" + totalAmount);
    }

}