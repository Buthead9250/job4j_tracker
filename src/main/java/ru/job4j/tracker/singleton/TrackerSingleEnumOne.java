package ru.job4j.tracker.singleton;

/**
 * enum. Eager loading.
 * Энергичная загрузка (Eager loading) - загружает объект сразу после старта виртуальной машины.
 * Чтобы получить экземпляр класса, нужно напрямую обратиться к полю INSTANCE.
 */
public enum TrackerSingleEnumOne {
    INSTANCE;

    public static void main(String[] args) {
        TrackerSingleEnumOne tracker = TrackerSingleEnumOne.INSTANCE;
        System.out.println(tracker);
    }
}
