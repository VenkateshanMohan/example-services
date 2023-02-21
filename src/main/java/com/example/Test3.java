package com.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.example.model.Employee;

public class Test3 {
    public static void main(String[] args) {

        List<Employee> list = new ArrayList<>();
        list.add(new Employee(1, "Faisal", "Chennai", 700));
        list.add(new Employee(2, "Bala", "Bangalore", 400));
        list.add(new Employee(3, "David", "Chennai", 600));
        list.add(new Employee(4, "Arun", "Pune", 500));
        list.add(new Employee(5, "Chitra", "Pune", 200));
        list.add(new Employee(6, "Elaine", "Pune", 300));
        list.stream()
                .collect(Collectors.groupingBy(obj -> obj.getCity(), Collectors.summarizingInt(obj -> obj.getSalary())))
                .forEach((city, sumSalary2) -> System.out.println(city + ": " + sumSalary2.getSum()));
        list.stream().forEach(emp -> System.out.println(emp.toString()));
        System.out.println(" ");

        list.stream().sorted(Comparator.comparingInt(Employee::getSalary).reversed())
                .forEach(emp -> System.out.println(emp.toString()));

    }
}
