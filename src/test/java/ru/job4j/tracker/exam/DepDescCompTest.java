package ru.job4j.tracker.exam;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;

public class DepDescCompTest {

    @Test
    public void compare() {
        int rsl = new DepDescComp().compare(
                "K2/SK1/SSK2",
                "K2/SK1/SSK1"
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenUpDepartmentGoBefore() {
        int rsl = new DepDescComp().compare(
                "K2",
                "K2/SK1"
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenUpDifDepartments() {
        int rsl = new DepDescComp().compare(
                "K1/SK1/SSK2",
                "K2/SK1/SSK1");
        assertTrue(rsl > 0);
    }

    @Test
    public void whenDownDifDepartments() {
        int rsl = new DepDescComp().compare(
                "K2/SK1",
                "K1/SK1/SSK2");
        assertTrue(rsl < 0);
    }
}
