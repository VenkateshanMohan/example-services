package com.example.other;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import com.example.model.Employee;

public class Test2 {
    public static void main(String[] args) {
        Map<Integer, String> mapl = new HashMap<>();
        mapl.put(1, "Arun");
        mapl.put(2, "David");
        mapl.put(3, "Bobby");
        mapl.put(4, "Kate");
        mapl.put(5, "Cynthia");
        mapl.put(6, "Eugene");

        Map<Integer, Employee> map2 = new HashMap<>();
        map2.put(1, new Employee(1, "Faisal", "Istanbul", 700));
        map2.put(2, new Employee(6, "Ben", "Miami", 900));
        map2.put(3, new Employee(5, "Gracy", "Chennai", 800));
        map2.put(4, new Employee(3, "Kumar", "Delhi", 850));
        map2.put(5, new Employee(2, "Yan", "Shanghai", 600));
        map2.put(6, new Employee(4, "Kira", "Beijing", 900));

        map2.entrySet().stream().sorted((e1, e2) -> e1.getValue().getId() - e2.getValue().getId())
                .forEach(System.out::println);
        map2.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.comparing(Employee::getName).reversed()))
                .forEach(System.out::println);

        mapl.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);

    }
}
