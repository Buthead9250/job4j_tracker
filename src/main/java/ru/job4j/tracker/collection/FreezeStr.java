package ru.job4j.tracker.collection;

import java.util.*;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        boolean rsl = true;
        char[] leftArray = left.toCharArray();
        char[] rightArray = right.toCharArray();
        Map<Character, Integer> check = new HashMap<>();
        for (Character simbol : leftArray) {
            if (check.containsKey(simbol)) {
                check.compute(simbol, (key, value) -> value + 1);
            } else {
                check.put(simbol, 1);
            }
        }
        for (Character simbol : rightArray) {
            if (!check.containsKey(simbol)) {
                rsl = false;
                break;
            }
            if (check.containsKey(simbol) && check.get(simbol) == 1) {
                check.remove(simbol);
                continue;
            }
            check.compute(simbol, (key, value) -> value - 1);
        }
        return rsl;
    }
}
