package ru.job4j.tracker.stream;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ProfilesTest {
    @Test
    public void differentCollect() {
        Profiles func = new Profiles();
        List<Address> expect = List.of(
                new Address("Барнаул", "Космическая", 13, 67),
                new Address("Заринск", "Строителей", 31, 22),
                new Address("Новосибирск", "Родники", 3, 129)
        );
        List<Profile> input = expect.stream()
                .map(Profile::new)
                .collect(Collectors.toList());
        List<Address> rsl = func.collect(input);
        assertThat(rsl, is(expect));
    }

    @Test
    public void collectWithClone() {
        Profiles func = new Profiles();
        List<Address> start = List.of(
                new Address("Новосибирск", "Родники", 3, 129),
                new Address("Барнаул", "Космическая", 13, 67),
                new Address("Заринск", "Строителей", 31, 22),
                new Address("Барнаул", "Космическая", 13, 67)
        );
        List<Profile> input = start.stream()
                .map(Profile::new)
                .collect(Collectors.toList());
        List<Address> expect = List.of(
                new Address("Барнаул", "Космическая", 13, 67),
                new Address("Заринск", "Строителей", 31, 22),
                new Address("Новосибирск", "Родники", 3, 129)
        );
        List<Address> rsl = func.collect(input);
        assertThat(rsl, is(expect));
    }
}
