package ru.job4j.tracker.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class DiapasonFuncTest {
    @Test
    public void whenLinearFunc() {
        List<Double> result = DiapasonFunc.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunc() {
        List<Double> result = DiapasonFunc.diapason(5, 8, x -> 2 * x * x);
        List<Double> expected = Arrays.asList(50D, 72D, 98D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenExponentialFunc() {
        List<Double> result = DiapasonFunc.diapason(1, 5, x -> Math.pow(x, x));
        List<Double> expected = Arrays.asList(1D, 4D, 27D, 256D);
        assertThat(result, is(expected));
    }
}