package ru.job4j.tracker.stream;

import java.util.List;
import java.util.stream.Stream;
import java.util.stream.Collectors;

public class Matrix {
    public List<Integer> collect(Integer[][] matrix) {
        return Stream.of(matrix)
                .flatMap(Stream::of)
                .collect(Collectors.toList());
    }
}
