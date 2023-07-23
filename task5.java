import java.util.HashMap;

public class Main {

    public static int massdriver(int[] activate) {
        HashMap<Integer, Integer> numCount = new HashMap<>(); // ключ - уникальное число из списка activate
                                                              // значение - индекс первого появления
        int index = activate.length; // текущий минимальный индекс первого вхождения

        for(int i = 0; i < activate.length; i ++) {
            if(index == 0) { // если число встречается впервые на нулевой позиции, то можно прервать цикл и вернуть 0
                return index;
            }
            // проверяем, что число уже есть в словаре и сравниваем индекс его первого вхождения с index
            if(numCount.containsKey(activate[i]) && numCount.get(activate[i]) < index) {
                index =  numCount.get(activate[i]); // если нашли второе вхождение числа с меньшим индексом первого вхождения, запоминаем его индекс
                continue;
            }
            numCount.put(activate[i], i); // если число встречается первый раз, то записываем его в словарь с индексом первого вхождения
        }

        if(index == activate.length) {
            return -1;
        }

        return index;
    }

}