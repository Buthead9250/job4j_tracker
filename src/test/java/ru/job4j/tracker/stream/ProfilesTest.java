package ru.job4j.tracker.stream;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ProfilesTest {
    @Test
    public void differentCollect() {
        Profiles func = new Profiles();
        List<Profile> start = List.of(
                new Profile(new Address("Барнаул", "Космическая", 13, 67)),
                new Profile(new Address("Заринск", "Строителей", 31, 22)),
                new Profile(new Address("Новосибирск", "Родники", 3, 129))
        );
        List<Address> expect = List.of(
                new Address("Барнаул", "Космическая", 13, 67),
                new Address("Заринск", "Строителей", 31, 22),
                new Address("Новосибирск", "Родники", 3, 129)
        );
        List<Address> rsl = func.collect(start);
        assertThat(rsl, is(expect));
    }

    @Test
    public void collectWithClone() {
        Profiles func = new Profiles();
        List<Profile> start = List.of(
                new Profile(new Address("Новосибирск", "Родники", 3, 129)),
                new Profile(new Address("Барнаул", "Космическая", 13, 67)),
                new Profile(new Address("Заринск", "Строителей", 31, 22)),
                new Profile(new Address("Барнаул", "Космическая", 13, 67))
        );
        List<Address> expect = List.of(
                new Address("Барнаул", "Космическая", 13, 67),
                new Address("Заринск", "Строителей", 31, 22),
                new Address("Новосибирск", "Родники", 3, 129)
        );
        List<Address> rsl = func.collect(start);
        assertThat(rsl, is(expect));
    }
}
