import java.util.HashSet;

public class Main {

    public static int artificial_muscle_fibers(int[] arr) {
        byte[] bytes = new byte[4096];
        int index, bit;
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < arr.length; i ++) {
            index = arr[i] / 8;
            bit = arr[i] % 8;
            byte curByte = (byte) (1 << bit);

            if((bytes[index] & curByte) == curByte && ! set.contains(arr[i])) {
                    set.add(arr[i]);
            }
            bytes[index] |= curByte;
        }

        return set.size();
    }

}