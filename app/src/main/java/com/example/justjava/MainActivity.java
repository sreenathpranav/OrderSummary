package com.example.justjava;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    int quantity=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


//button
    public void increment(View view){
        quantity= quantity+1;
        display(quantity);
    }
    public void decrement(View view){

        quantity = quantity-1;
        display(quantity);
    }
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_test_view);
        quantityTextView.setText("" + number);
    }
//button

    public void submitOrder(View view) {
        CheckBox whippedCreamCheckbox= (CheckBox) findViewById(R.id.whipped_cream_checkbox);   // checkbox call whipped cream
        boolean hasWhippedCream = whippedCreamCheckbox.isChecked();

        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);  // checkbox call chocolate
        boolean hasChocolate = chocolateCheckBox.isChecked();

        int price =calculatePrice();
        String priceMessage= createOrderSummary(price,hasWhippedCream,hasChocolate);
        displayMessage(priceMessage);

    }
    private int calculatePrice(){
        int price=quantity*5;
        return price;
    }
    private String createOrderSummary(int price,boolean addWhippedCream,boolean addChocolate){
        String priceMessage="Name: S Pranav";
        priceMessage += "\nAdd whipped cream? " + addWhippedCream;
        priceMessage += "\nAdd chocolate? " + addChocolate;
        priceMessage += "\nQuantity: "+ quantity;
        priceMessage += "\nTotal: $"+ (price);
        priceMessage += "\nThank You!";
        return priceMessage;
    }


    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }


}