package ru.job4j.tracker.singleton;

import ru.job4j.tracker.Tracker;
/**
 * Тоже самое, что и с static field. Lazy loading.
 * Основное отличие, мы сразу создаем и инициализируем объект.
 * Энергичная загрузка (Eager loading) - загружает объект сразу после старта виртуальной машины.
 */
public class TrackerSingleEagerLoadThree {
    private static final Tracker INSTANCE = new Tracker();

    private TrackerSingleEagerLoadThree() {
    }

    public static Tracker getTracker() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        Tracker tracker = TrackerSingleEagerLoadThree.getTracker();
        System.out.println(tracker);
    }
}
