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
    private static TrackerSingleLazyLoadTwo instance;

    private TrackerSingleLazyLoadTwo() {
    }

    /**
     * Метод проверяет статическое поле instance,
     * если поле не загружено, оно инициализируется новосозданным объектом.
     */
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
