package ru.job4j.tracker.exam;

import java.util.List;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.Comparator;
import java.util.LinkedHashMap;

public class Analyze {
    public static double averageScore(Stream<Pupil> stream) {
        return stream
                .flatMap(sub -> sub.getSubjects().stream())
                .mapToInt(Subject::getScore)
                .average()
                .orElse(0D);
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream
                .map(sub -> {
                    double avScore = sub.getSubjects().stream()
                            .mapToInt(Subject::getScore)
                            .average()
                            .orElse(0D);
                    return new Tuple(sub.getName(), avScore);
                })
                .collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream
                .flatMap(sub -> sub.getSubjects().stream())
                .collect(Collectors.groupingBy(Subject::getName, LinkedHashMap::new, Collectors.averagingDouble(Subject::getScore)))
                .entrySet().stream()
                .map(tup -> new Tuple(tup.getKey(), tup.getValue()))
                .collect(Collectors.toList());
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream
                .map(best -> {
                    double summ = best.getSubjects().stream()
                            .mapToInt(Subject::getScore)
                            .sum();
                    return new Tuple(best.getName(), summ);
                })
                .max(Comparator.comparing(Tuple::getScore))
                .orElse(null);
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream
                .flatMap(sub -> sub.getSubjects().stream())
                .collect(Collectors.groupingBy(Subject::getName, Collectors.summingDouble(Subject::getScore)))
                .entrySet().stream()
                .map(bs -> new Tuple(bs.getKey(), bs.getValue()))
                .max(Comparator.comparingDouble(Tuple::getScore))
                .orElse(null);
    }
}
