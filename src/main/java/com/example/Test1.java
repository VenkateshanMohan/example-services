package com.example;

import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test1 {
    public static void main(String[] args) {

        var str = "aaabbbbcccccdddddddeeeeeee";
        var charArr = str.toCharArray();
        System.out.printf("\nAs char[]:\n");
        System.out.println(charArr);

        var charList = str.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        System.out.printf("\nAs List:\n");
        System.out.println(charList);

        var charMap = str.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.printf("\nAs Map:\n");
        System.out.println(charMap);

        var eee = Collections.max(charMap.entrySet(), Map.Entry.comparingByValue());
        System.out.printf("\nMax occurring Key:\n");
        System.out.println(eee);

        var fff = charMap.entrySet().stream().filter(entry -> entry.getValue() == Collections.max(charMap.values()))
                .map(entry -> entry.getKey()).collect(Collectors.toList());
        System.out.printf("\nMax occurring Keys:\n");
        System.out.println(fff);

    }
}
