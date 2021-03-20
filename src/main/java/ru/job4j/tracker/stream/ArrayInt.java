package ru.job4j.tracker.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayInt {
    public static void main(String[] args) {
        ArrayList<Integer> numberList = new ArrayList<>();
        for (int i = -50; i < 50; i++) {
            numberList.add(i);
        }
        List<Integer> positiveNum = numberList.stream()
                .filter(num -> num > 0).collect(Collectors.toList());
        positiveNum.forEach(System.out::println);
    }
}
