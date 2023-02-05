package com.rohithmovva.tipcalculator;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    //Declaration of Variables for android widgets
    EditText et_BillAmount;
    TextView tv_TipTotalAmounts;
    Button b_15Percent, b_18Percent, b_20Percent;

    //Declaration of variables used for calculation
    boolean isValidBillAmount = false;
    double billAmount = 0.00;
    double tipAmount = 0.00;
    double totalAmount = 0.00;

    //Declaring and defining formatter for displaying amounts in US currency format ($#,##0.00).
    final NumberFormat formatter = NumberFormat.getCurrencyInstance(new Locale("en", "US"));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_BillAmount = findViewById(R.id.editTextBillAmount);
        tv_TipTotalAmounts = findViewById(R.id.textViewTipTotalAmount);
        b_15Percent = findViewById(R.id.btnFifteenPercent);
        b_18Percent = findViewById(R.id.btnEighteenPercent);
        b_20Percent = findViewById(R.id.btnTwentyPercent);

        //On Click event of button 15%
        b_15Percent.setOnClickListener(view -> {
            try {
                tipAmount = 0.00;
                totalAmount = 0.00;
                isValidBillAmount = CheckEnteredBillAmount();
                if(isValidBillAmount)
                {
                    String billStringAmount = et_BillAmount.getText().toString();
                    billAmount = Double.parseDouble(billStringAmount);
                    billAmount = GetFormattedTwoDecimalValue(billAmount);
                    tipAmount = billAmount * 0.15;
                    tipAmount = GetFormattedTwoDecimalValue(tipAmount);
                    totalAmount = billAmount + tipAmount;
                }

                tv_TipTotalAmounts.setText("Tip: " + formatter.format(tipAmount) + ", Total Bill: " + formatter.format(totalAmount));

            }catch(Exception ex)
            {
                System.out.println(Arrays.toString(ex.getStackTrace()));
            }
        });

        //On Click event of button 18%
        b_18Percent.setOnClickListener(view -> {
            try {
                tipAmount = 0.00;
                totalAmount = 0.00;
                isValidBillAmount = CheckEnteredBillAmount();
                if(isValidBillAmount)
                {
                    String billStringAmount = et_BillAmount.getText().toString();
                    billAmount = Double.parseDouble(billStringAmount);
                    billAmount = GetFormattedTwoDecimalValue(billAmount);
                    tipAmount = billAmount * 0.18;
                    tipAmount = GetFormattedTwoDecimalValue(tipAmount);
                    totalAmount = billAmount + tipAmount;
                }

                tv_TipTotalAmounts.setText("Tip: " + formatter.format(tipAmount) + ", Total Bill: " + formatter.format(totalAmount));

            }catch(Exception ex)
            {
                System.out.println(Arrays.toString(ex.getStackTrace()));
            }
        });

        //On Click event of button 20%
        b_20Percent.setOnClickListener(view -> {
            try {
                tipAmount = 0.00;
                totalAmount = 0.00;
                isValidBillAmount = CheckEnteredBillAmount();
                if(isValidBillAmount)
                {
                    String billStringAmount = et_BillAmount.getText().toString();
                    billAmount = Double.parseDouble(billStringAmount);
                    billAmount = GetFormattedTwoDecimalValue(billAmount);
                    tipAmount = billAmount * 0.20;
                    tipAmount = GetFormattedTwoDecimalValue(tipAmount);
                    totalAmount = billAmount + tipAmount;
                }

                tv_TipTotalAmounts.setText("Tip: " + formatter.format(tipAmount) + ", Total Bill: " + formatter.format(totalAmount));

            }catch(Exception ex)
            {
                System.out.println(Arrays.toString(ex.getStackTrace()));
            }
        });
    }

    //Method to check whether entered bill amount is valid or not
    private boolean CheckEnteredBillAmount(){
        if(et_BillAmount.length() == 0 || et_BillAmount.getText().toString().equals(".")){
            et_BillAmount.setError("Enter valid bill amount");
            return false;
        }
        return true;
    }

    //Format any double value to two decimal value by rounding since these are amount related objects
    private double GetFormattedTwoDecimalValue(double doubleValue)
    {
        doubleValue = doubleValue * 100;
        doubleValue = Math.round(doubleValue);
        doubleValue = doubleValue/100;
        return doubleValue;
    }
}