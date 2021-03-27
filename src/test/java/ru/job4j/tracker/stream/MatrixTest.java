package ru.job4j.tracker.stream;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MatrixTest {
    @Test
    public void whenMatrixToList() {
        Matrix m = new Matrix();
        Integer[][] mat = new Integer[][]{
                {1, 2},
                {3, 4}
        };
        List<Integer> rsl = m.collect(mat);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4);
        assertThat(rsl, is(expected));
    }
}
