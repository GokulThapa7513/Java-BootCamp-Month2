package org.example;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] words = {"apple", "banana", "apple", "cherry", "banana", "apple"};

        Map<String, Integer> counter = new HashMap<>();
        for (String word : words) {
            counter.put(word, counter.getOrDefault(word, 0) + 1);

        }
        for (Map.Entry<String, Integer> entry : counter.entrySet()){
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }





    }