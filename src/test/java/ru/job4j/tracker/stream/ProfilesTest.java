package ru.job4j.tracker.stream;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ProfilesTest {
    @Test
    public void collect() {
        Profiles func = new Profiles();
        List<Address> expect = List.of(
                new Address("Новосибирск", "Родники", 3, 129),
                new Address("Барнаул", "Космическая", 13, 67),
                new Address("Заринск", "Строителей", 31, 22)
        );
        List<Profile> input = expect.stream()
                .map(Profile::new)
                .collect(Collectors.toList());
        List<Address> rsl = func.collect(input);
        assertThat(rsl, is(expect));
    }
}
