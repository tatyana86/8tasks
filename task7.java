public class Main {

    public static void createSpiralMatrix(int [] spiralMatrix, int [][] matrix, int n, int m, int circle) {

        int index = 0; // текущий индекс

        // подсчет первого индекса в "круге"
        for(int c = 0; c < circle; c ++) {
            index += 2 * ((m - 2 * c) + (n - 2 * c) - 2);
        }

        // проходимся по элементам каждой четверти "круга" и записываем элементы
        for(int j = 0 + circle; j < m - circle; j ++) {
            spiralMatrix[index] = matrix[circle][j];
            index ++;
        }

        for(int i = 1 + circle; i < n - circle; i ++) {
            spiralMatrix[index] = matrix[i][m - 1 - circle];
            index ++;
        }

        for(int j = m - 2 - circle; j >= circle; j --) {
            spiralMatrix[index] = matrix[n - 1 - circle][j];
            index ++;
        }

        for(int i = n - 2 - circle; i > circle; i --) {
            spiralMatrix[index] = matrix[i][circle];
            index ++;
        }

    }

    public static int[] matrix(int n, int m, int [][] matrix) {

        int[] spiralMatrix = new int[n * m];

        int minNum = n;
        if(m < minNum) {
            minNum = m;
        }
        int countCircle = minNum / 2 + minNum % 2; // количество "кругов" в матрице

        // проходимся по каждому "кругов"
        for (int circle = 0; circle < countCircle; circle++) {
            // записываем элементы в результирующий массив
            createSpiralMatrix(spiralMatrix, matrix, n, m, circle);
        }

        return spiralMatrix;

    }

}