package ru.job4j.tracker.singleton;

public class TrackerSinglePSFCFour {
    private TrackerSinglePSFCFour() {
    }

    private static final class Holder {
        private static final TrackerSinglePSFCFour INSTANCE = new TrackerSinglePSFCFour();
    }

    public static TrackerSinglePSFCFour getInstance() {
        return Holder.INSTANCE;
    }

    public static void main(String[] args) {
        TrackerSinglePSFCFour tracker = TrackerSinglePSFCFour.getInstance();
        System.out.println(tracker);
    }
}
