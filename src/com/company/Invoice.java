package com.company;

import java.util.ArrayList;

public class Invoice {

    private String item;
    private int quantity;
    private String description;
    private double price;

    public void setItem(String item) {
        this.item = item;
    }

    public String getItem() {
        return item;

    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }




    public double total () {
            double total = getQuantity() * getPrice();
            return total;
        }

        public double taxableSubTotal (ArrayList< Double > subTotal) {
            double taxable = 0.0;
            for (int i = 0; i < subTotal.size(); i++) {
                taxable += subTotal.get(i);
            }
            return taxable;
        }
        public double untaxable () {
            return 0;
        }
        public double tax (ArrayList < Double > subTotal) {
            double taxRate = 6.0;
            double tax = (taxRate * taxableSubTotal(subTotal)) / 100;
            return tax;
        }
        public double grandTotal (ArrayList < Double > subTotal) {
            double total = tax(subTotal) + taxableSubTotal(subTotal);

            return total;
        }
    }


