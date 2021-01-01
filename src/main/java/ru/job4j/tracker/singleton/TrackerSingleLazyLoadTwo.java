package ru.job4j.tracker.singleton;

import ru.job4j.tracker.Tracker;

public class TrackerSingleLazyLoadTwo {
    private static TrackerSingleLazyLoadTwo instance;

    private TrackerSingleLazyLoadTwo() {
    }

    public static TrackerSingleLazyLoadTwo getInstance() {
        if (instance == null) {
            instance = new TrackerSingleLazyLoadTwo();
        }
        return instance;
    }

    public static void main(String[] args) {
        TrackerSingleLazyLoadTwo tracker = TrackerSingleLazyLoadTwo.getInstance();
        System.out.println(tracker);
    }
}
