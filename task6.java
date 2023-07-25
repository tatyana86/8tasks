public class Main {

    public static void swap(int[] ar, int i, int j) {
        int buf = ar[i];
        ar[i] = ar[j];
        ar[j] = buf;
    }

    public static int splitArray(int[] ar, int start, int end) {
        int curStart = start - 1; // индекс последнего элемента, который оказался меньше опорного значения - ar[end]
        for(int i = start; i < end; i ++) {
            // текущий элемент меньше опорного?
            if(ar[i] < ar[end]) {
                curStart ++;
                // меняем местами элементы так, чтобы под индексом i оказался элемент меньше ar[end]
                swap(ar, curStart, i);
            }
        }
        // располагаем элемент ar[end] так, чтобы слева от него были элементы строго меньше него,
        // а справа - больше или равны ему
        swap(ar, curStart + 1, end);
        return curStart + 1;
    }

    public static int[] sortArray(int[] ar, int start, int end) {
        // выполняем рекурсивно сортировку, пока длина разделенного массива больше 0
        if(start < end) {
            int sepInd = splitArray(ar, start, end); // индекс, по которому делим массив
            sortArray(ar, start, sepInd - 1); // сортируем левую часть
            sortArray(ar, sepInd + 1, end); // сортируем правую часть
        }
        return ar;
    }

    public static int[] TRC_sort(int[] trc) {
        int [] trcSort = new int[trc.length]; // отсортированный массив
        System.arraycopy(trc, 0, trcSort, 0, trc.length);
        return sortArray(trcSort, 0, trcSort.length - 1);
    }

}