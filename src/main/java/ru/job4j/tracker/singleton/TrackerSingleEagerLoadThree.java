package ru.job4j.tracker.singleton;

public class TrackerSingleEagerLoadThree {
    private static final TrackerSingleEagerLoadThree INSTANCE = new TrackerSingleEagerLoadThree();

    private TrackerSingleEagerLoadThree() {
    }

    public static TrackerSingleEagerLoadThree getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        TrackerSingleEagerLoadThree tracker = TrackerSingleEagerLoadThree.getInstance();
        System.out.println(tracker);
    }
}
