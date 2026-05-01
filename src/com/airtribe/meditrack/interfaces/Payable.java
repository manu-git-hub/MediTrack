package com.airtribe.meditrack.interfaces;

public interface Payable {
    double calculateTotal();
    default void printReceipt() {
        System.out.println("--- Payment Receipt ---");
        System.out.println("Total Amount: $" + calculateTotal());
        System.out.println("-----------------------");
    }
}