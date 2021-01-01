package ru.job4j.tracker.singleton;

import ru.job4j.tracker.Tracker;

/**
 * Ленивая загрузка (Lazy loading) происходит, когда мы явно обращаемся к объекту.
 * Происходит его загрузка.
 * <p>
 * Для того чтобы закрыть возможность создавать экземпляр класса,
 * нам нужно явно создать конструктор по умолчанию и присвоить ему модификатор private.
 */
public class TrackerSingleLazyLoadTwo {
    private static Tracker instance;

    private TrackerSingleLazyLoadTwo() {
    }

    /**
     * Метод проверяет статическое поле instance,
     * если поле не загружено, оно инициализируется новосозданным объектом.
     */
    public static Tracker getTracker() {
        if (instance == null) {
            instance = new Tracker();
        }
        return instance;
    }

    public static void main(String[] args) {
        Tracker tracker = TrackerSingleLazyLoadTwo.getTracker();
        System.out.println(tracker);
    }
}
