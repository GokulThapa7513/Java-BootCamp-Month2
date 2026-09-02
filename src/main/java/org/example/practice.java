package org.example;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class practice {
    public static void main(String[] args) {
        String string = "hello";

        Deque<Character> word = new ArrayDeque<>();
        for(int i = 0; i < string.length(); i++) {
            word.push(string.charAt(i));
        }
        System.out.println(word);
        String reversedString = "";
        while(!word.isEmpty()) {
            reversedString += word.pop();
        }




    }
}
