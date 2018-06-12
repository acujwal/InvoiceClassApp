package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        int quantity =0;
        String description="", item="";
        double price, total;

        Scanner input = new Scanner(System.in);

        ArrayList<Double> totalData = new ArrayList<>();
        ArrayList<Double>priceData = new ArrayList<>();
        ArrayList<String> descriptionData = new ArrayList<>();
        ArrayList<Integer> quantityData = new ArrayList<>();
        ArrayList<String> itemData = new ArrayList<>();


        Invoice invoice = new Invoice();

        System.out.println("Enter the item number or q to exit");
        item = input.nextLine();

        while (!item.equals("q")){

            System.out.println("Enter the Quantity: ");
            quantity=input.nextInt();
            input.nextLine();

            System.out.println("Enter the Description: ");
            description= input.nextLine();

            System.out.println("Enter the Price: ");
            price = input.nextDouble();
            input.nextLine();

            invoice.setItem(item);
            invoice.setQuantity(quantity);
            invoice.setDescription(description);
            invoice.setPrice(price);

            totalData.add(invoice.total());
            quantityData.add(invoice.getQuantity());
            itemData.add(invoice.getItem());
            priceData.add(invoice.getPrice());
            descriptionData.add(invoice.getDescription());

            System.out.println(" * * * * * * * * * *  * * * * * * * ");
            System.out.println("Enter the Next item number or q to exit");
            item = input.nextLine();
        }

        System.out.println("Item\t Quantity\t Description\t Price\t\t  Total");
        for(int i =0; i <totalData.size();i++){
            System.out.println(itemData.get(i)+"\t" + quantityData.get(i)+" \t \t  " + descriptionData.get(i)+"  \t "+
                    priceData.get(i)+"\t\t  " + totalData.get(i));
        }

        System.out.println("Taxable sub-total: " + invoice.taxableSubTotal(totalData));
        System.out.println("Untaxable Subtotal: " + invoice.untaxable());
        System.out.println(String.format("Tax: %.2f ", invoice.tax(totalData)));
        System.out.println(String .format("Grand Total: %.2f ", invoice.grandTotal(totalData)));

    }

}

