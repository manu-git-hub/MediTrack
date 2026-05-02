package com.airtribe.meditrack.interfaces;

public interface Searchable<T> {
    T searchById(String id);

    default void printSearchMessage() {
        System.out.println("Searching...");
    }
}
