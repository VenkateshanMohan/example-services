package com.example;

import org.apache.commons.lang3.tuple.MutableTriple;
import org.apache.commons.lang3.tuple.Triple;

public class Test4 {
    public static void main(String... a) {
        triples();
    }

    private static <T, U, V> void triples() {
        Triple<String, String, String> triple = new MutableTriple<>();
        System.out.println(triple);
    }
}