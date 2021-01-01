package ru.job4j.tracker.singleton;

/**
 * Тоже самое, что и с static field. Lazy loading.
 * Основное отличие, мы сразу создаем и инициализируем объект.
 * Энергичная загрузка (Eager loading) - загружает объект сразу после старта виртуальной машины.
 */
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
