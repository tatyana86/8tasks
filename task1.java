public class Main {

    public  static boolean white_walkers(String village) {
        int dig = 0;
        int countWalker = 0;
        boolean isWalker = false;

        for(int i = 0; i < village.length(); i ++) {
            char elem = village.charAt(i);
            if(Character.isDigit(elem) && dig == 0) {
                dig = Character.getNumericValue(elem);
                countWalker = 0;
                continue;
            }
            if(elem == '=') {
                countWalker ++;
                continue;
            }
            if(dig + Character.getNumericValue(elem) < 10) {
                dig = Character.getNumericValue(elem);
                countWalker = 0;
                continue;
            }
            if(dig > 0 && dig + Character.getNumericValue(elem) == 10 && countWalker != 3) {
                return false;
            }
            if(dig > 0 && dig + Character.getNumericValue(elem) == 10 && countWalker == 3) {
                isWalker = true;
                dig = Character.getNumericValue(elem);
                countWalker = 0;
            }
        }

        return isWalker;
    }

}