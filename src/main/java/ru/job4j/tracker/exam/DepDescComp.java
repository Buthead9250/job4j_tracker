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
        int result = 0;
        String[] splitLeft = left.split("/");
        String[] splitRight = right.split("/");
        if (splitLeft[0].equals(splitRight[0])) {
            result = left.compareTo(right);
        } else {
            result = right.compareTo(left);
        }
        return result;
    }
}
