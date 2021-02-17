package ru.job4j.tracker.collection;

import org.junit.Test;
import org.junit.Ignore;
import java.util.Comparator;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class JobTest {
    @Test
    public void whenComparatorByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName()
                .thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenSortByNameDesc() {
        Comparator<Job> cmpNameDesc = new JobDescByName();
        int rsl = cmpNameDesc.compare(
                new Job("First", 1),
                new Job("Second", 2)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenSortByNameAsc() {
        Comparator<Job> cmpNameDesc = new JobAscByName();
        int rsl = cmpNameDesc.compare(
                new Job("First", 2),
                new Job("Second", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Ignore
    @Test
    public void whenSortByPriorityAsc() {
        Comparator<Job> cmpPriorityAsc = new JobAscByPriority();
        int rsl = cmpPriorityAsc.compare(
                new Job("First", 1),
                new Job("Second", 2)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenSortByPriorityDesc() {
        Comparator<Job> cmpPriorityAsc = new JobDescByPriority();
        int rsl = cmpPriorityAsc.compare(
                new Job("First", 2),
                new Job("Second", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorByPriorityAndName() {
        Comparator<Job> cmpNamePriority = new JobAscByPriority()
                .thenComparing(new JobAscByName());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 1),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, equalTo(3));
    }
}
