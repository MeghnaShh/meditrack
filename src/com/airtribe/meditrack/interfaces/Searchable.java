package com.airtribe.meditrack.interfaces;

import java.util.List;

public interface Searchable<T> {
    List<T> searchByName(String name);
    List<T> searchById(int id);

    default void printResults(List<T> results){
        results.forEach(System.out::println);
    }
}
