package org.example;

import java.util.*;

public class collectionspractice {
    public static void main(String[] args) {
        Map<String, List<String>> country = new HashMap<>();
        country.put("Nepal", new ArrayList<>(Arrays.asList("Kathmandu", "Pokhara", "Chitwan")));
        country.put("India", new ArrayList<>(Arrays.asList("Delhi", "Mumbai", "Goa")));
        for (Map.Entry<String, List<String>> entry : country.entrySet()) {
            String name = entry.getKey();
            List<String> city = entry.getValue();
            System.out.println("Country : " + name + " cities : " + city);
        }

    }
}
