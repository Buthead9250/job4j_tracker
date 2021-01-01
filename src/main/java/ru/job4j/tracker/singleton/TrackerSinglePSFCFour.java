package ru.job4j.tracker.singleton;

import ru.job4j.tracker.Tracker;
/**
 * Объект класса находиться в поле внутреннего класса.
 * Ленивая загрузка (Lazy loading) происходит, когда мы явно обращаемся к объекту.
 * Происходит его загрузка.
 */
public class TrackerSinglePSFCFour {
    private TrackerSinglePSFCFour() {
    }

    private static final class Holder {
        private static final Tracker INSTANCE = new Tracker();
    }

    public static Tracker getTracker() {
        return Holder.INSTANCE;
    }

    public static void main(String[] args) {
        Tracker tracker = TrackerSinglePSFCFour.getTracker();
        System.out.println(tracker);
    }
}
