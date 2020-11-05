
/*
 *  22-Oct-2020
 *  Copyright (c) 2020 Muthoot Group. All Rights Reserved.
 */

package com.ust;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

/**
 * The Class Java8Demo.
 */
public class Java8Demo {

    /**
     * Check alphabets.
     *
     * @return the string
     */
    public String checkAlphabets() {
        final List<String> names = Arrays.asList("merib", "sherin", "ann", "ciena");
        final boolean a = names.stream().allMatch(name -> name.chars().allMatch(Character::isLetter));
        if (a) {
            return "yes";
        }
        return "no";
    }

    /**
     * Find pattern.
     *
     * @return the list
     */
    public List<String> findPattern() {
        final List<String> names = Arrays.asList("merib", "sherin", "ann", "ciena");
        return names.stream().filter(name -> name.startsWith("M")).collect(Collectors.toList());

    }

    /**
     * Find string format.
     *
     * @return the string
     */
    public String findStringFormat() {
        final List<Integer> numbers = Arrays.asList(10, 20, 1, 5, 4);
        if (numbers.stream().anyMatch(no -> no <= 0)) {
            return "Give proper input not negative values";
        } else {
            return numbers.stream().map(no -> {
                if (no % 2 == 0) {
                    return "even" + no;
                } else {
                    return "odd" + no;
                }
            }).collect(Collectors.joining(","));
        }

    }

    /**
     * Gets the maximum of odd numbers.
     *
     * @return the maximum of odd numbers
     */
    public Integer getMaximumOfOddNumbers() {
        final List<Integer> numbers = Arrays.asList(10, 20, 10, 50, 40);
        if (numbers.stream().anyMatch(n -> n % 2 != 0)) {
            return numbers.stream().filter(n -> n % 2 != 0).max(Integer::compareTo).get();
        } else {
            return 0;
        }

    }

    /**
     * List of employees.
     *
     * @return the list
     */
    public List<Employee> listOfEmployees() {
        final List<Employee> employess = new ArrayList<>();
        final BiFunction<Integer, String, Employee> f = Employee::new;
        // (id,name) -> new Employee(id,name);
        // Arrays.stream(numbers).reduce(1,(x,y)->x*y); numbers is array of integres
        employess.add(f.apply(1, "Merin"));
        employess.add(f.apply(2, "Sherin"));
        employess.add(f.apply(3, "Mrin"));

        final BiConsumer<Employee, Integer> salaryIncrment = (emp, increment) -> emp.setId(emp.getId() + increment);

        for (final Employee e : employess) {
            salaryIncrment.accept(e, 500);
        }
        return employess;

    }

    /**
     * Sorting names.
     *
     * @return the list
     */
    public List<String> sortingNames() {
        final List<String> names = Arrays.asList("merib", "sherin", "ann", "ciena");
        // return
        // names.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        // return names.stream().sorted((n1, n2) ->
        // n2.compareTo(n1)).collect(Collectors.toList());
        return names.stream().sorted((n1, n2) -> {
            if (n1.length() > n2.length()) {
                return 1;
            } else {
                return -1;
            }
        }).collect(Collectors.toList());

    }

    /**
     * Square of N umbers.
     *
     * @return the list
     */
    public List<Integer> squareOfNUmbers() {
        final List<Integer> numbers = Arrays.asList(10, 20, 1, 5, 4);
        return numbers.stream().map(n -> n * n).collect(Collectors.toList());
    }

    /**
     * Square of N umbers 1.
     *
     * @return the integer
     */
    public Integer squareOfNUmbers1() {
        final List<Integer> numbers = Arrays.asList(10, 20, 1, 5, 4);
        return numbers.stream().mapToInt(no -> no * 2).sum();
    }

    /**
     * Sum is even.
     *
     * @return true, if successful
     */
    public boolean sumIsEven() {
        final BiPredicate<Integer, Integer> biPredicate = (a, b) -> (a + b) % 2 == 0;
        return biPredicate.test(5, 10);
    }
}
