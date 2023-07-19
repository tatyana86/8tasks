import java.util.*;

public class Main {

    public static boolean EEC_help(int [] arr1, int [] arr2) {
        if(arr1.length != arr2.length) {
            return false;
        }

        HashMap<Integer, Integer> numCount = new HashMap<>();
        boolean flag = true;

        for(int i = 0; i < arr1.length; i ++) {
            if(arr1[i] == arr2[i]) {
                continue;
            }
            if(numCount.containsKey(arr1[i])) {
                numCount.put(arr1[i], numCount.get(arr1[i]) - 1);
                flag = true;
            }
            if(! numCount.containsKey(arr1[i])) {
                numCount.put(arr1[i], 1);
                flag = false;
            }
            if(numCount.containsKey(arr2[i])) {
                numCount.put(arr2[i], numCount.get(arr2[i]) - 1);
                flag = true;
            }
            if(! numCount.containsKey(arr2[i])) {
                numCount.put(arr2[i], 1);
                flag = false;
            }
        }
        return flag;
    }

}