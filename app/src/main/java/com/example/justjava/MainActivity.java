package com.example.justjava;

import android.os.Bundle;
import android.util.Log;
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
        CheckBox whippedCreamCheckbox= (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckbox.isChecked();
        Log.v("MainActivity", "Has whipped ceram: "+ hasWhippedCream);
        int price =calculatePrice();
        String priceMessage= createOrderSummary(price);
        displayMessage(priceMessage);

    }
    private int calculatePrice(){
        int price=quantity*5;
        return price;
    }
    private String createOrderSummary(int price){
        String priceMessage="Name: S Pranav";
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