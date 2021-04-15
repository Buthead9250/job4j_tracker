package ru.job4j.tracker.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class EasyStream {
    private List<Integer> source;

    private EasyStream() {
    }

    static class Builder {
        private List<Integer> source;

        Builder buildSource(List<Integer> source) {
            this.source = source;
            return this;
        }

        EasyStream build() {
            EasyStream stream = new EasyStream();
            stream.source = source;
            return stream;
        }
    }

    public static EasyStream of(List<Integer> source) {
        return new Builder()
                .buildSource(source)
                .build();
    }

    public EasyStream map(Function<Integer, Integer> fun) {
        List<Integer> result = new ArrayList<>();
        for (Integer one : source) {
            result.add(fun.apply(one));
        }
        return new Builder()
                .buildSource(result)
                .build();
    }

    public EasyStream filter(Predicate<Integer> fun) {
        List<Integer> result = new ArrayList<>();
        for (Integer two : source) {
            if (fun.test(two)) {
                result.add(two);
            }
        }
        return new Builder()
                .buildSource(result)
                .build();
    }

    public List<Integer> collect() {
        return source;
    }
}
