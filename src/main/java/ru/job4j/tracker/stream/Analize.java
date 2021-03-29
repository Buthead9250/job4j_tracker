package ru.job4j.tracker.stream;

import java.util.List;

public class Analize {
    public Info diff(List<User> previous, List<User> current) {
        Info info = new Info();
        info.added = (int) current.stream().dropWhile(previous::contains).count();
        info.deleted = (int) previous.stream().filter(o -> !current.contains(o)).count();
        info.changed = (int) previous.stream().
                filter(current::contains).
                filter(o -> !o.getName().equals(current.get(current.indexOf(o)).getName())).
                count();
        return info;
    }

    public static class User {
        private int id;
        private String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof User)) {
                return false;
            }
            User user = (User) o;
            return getId() == user.getId();
        }

        @Override
        public int hashCode() {
            return getId();
        }
    }

    public static class Info {
        private int added;
        private int changed;
        private int deleted;

        @Override
        public String toString() {
            return "Info{"
                    + "added=" + added
                    + ", changed=" + changed
                    + ", deleted=" + deleted + '}';
        }
    }

    public static void main(String[] args) {
        User igor = new User(293, "Igorechek");
        User vanya = new User(23, "Vanyushka");
        User petr = new User(107, "Petrucho");
        User grisha = new User(49, "Grishanya");
        User alex = new User(12, "Aleshka");
        User katya = new User(56, "Katyunya");
        User igor1 = new User(293, "Igoryunya");
        List<User> list1 = List.of(igor, vanya, igor, alex, igor, igor);
        List<User> list2 = List.of(petr, igor1, grisha, petr, alex, katya);
        Analize analize = new Analize();
        System.out.println(analize.diff(list1, list2));
    }
}
