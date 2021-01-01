package ru.job4j.tracker.singleton;

public enum TrackerSingleEnumOne {
    INSTANCE;

    public static void main(String[] args) {
        TrackerSingleEnumOne tracker = TrackerSingleEnumOne.INSTANCE;
        System.out.println(tracker);
    }
}
