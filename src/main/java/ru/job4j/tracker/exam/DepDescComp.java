package ru.job4j.tracker.exam;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {

    /**
     * Метод сортирует головные подразделения по убыванию,
     * а службы внутри головных подразделений по - по возрастанию
     * @param left  - строка с кодами подразделений
     * @param right - строка с кодами подразделений
     * @return - список подразделений, отсортированный в убывающем порядке
     */
    @Override
    public int compare(String left, String right) {
        int result = right.split("/")[0].compareTo(left.split("/")[0]);
        return result == 0 ? left.compareTo(right) : result;
    }
}
