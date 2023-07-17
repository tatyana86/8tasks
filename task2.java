public class Main {

    /* Функция принимает строку, индекс, до которого проводится проверка, и целевую разницу '0' и '1'.
       Как только целевая разница достигнута, значит подстрока с одинаковым количеством '0' и '1' найдена.
     */
    public static int findMinIndex(String col, int index, int differ) {
        int count0 = 0;
        int count1 = 0;
        int minIndex = 0;

        if(differ == 0) {
            return minIndex;
        }

        for(int i = 0; i <= index; i ++) {
            int curDiffer;
            char elem = col.charAt(i);
            int dig = Character.getNumericValue(elem);

            if(dig == 0) {
                count0 ++;
            }
            if(dig == 1) {
                count1 ++;
            }

            curDiffer = count0 - count1;
            if(curDiffer == differ) {
                minIndex = i + 1;
                break;
            }
        }

        return minIndex;
    }

    public static String digital_rain(String col) {
        int count0 = 0; // количество '0'
        int count1 = 0; // количество '1'
        String result = "";
        int maxLen = 0; // длина максимальной найденной подстроки

        for(int i = 0; i < col.length(); i ++) {
            int differ; // разница между количеством '0' и '1'
            int minIndex; // индекс, с которого выполняется текущая разница для i-го элемента
            int curLen; // текущая длина найденной подстроки
            char elem = col.charAt(i);
            int dig = Character.getNumericValue(elem);

            if(dig == 0) {
                count0 ++;
            }
            if(dig == 1) {
                count1 ++;
            }

            differ = count0 - count1;
            minIndex = findMinIndex(col, i, differ);
            curLen = i - minIndex + 1;

            if(curLen >= maxLen) { // если найденная подстрока длиннее, чем прошлая, сохраняем ее длину и саму подстроку
                maxLen = curLen;
                result = col.substring(minIndex, i + 1);
            }
        }

        return result;
    }

}