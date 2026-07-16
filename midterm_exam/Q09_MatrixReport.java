public class Q09_MatrixReport {
    public static void main(String[] args) {
        int[][] data = {
            {5, 8, 2},
            {9, 4, 7},
            {3, 6, 10}
        };
        System.out.println("第1列總和:" + rowSum(data, 1)); // 20
        System.out.println("第2欄總和:" + columnSum(data, 2)); // 19
        System.out.println("大於等於7的筆數:" + countAtLeast(data, 7)); // 4
        System.out.println("總和最大的列索引:" + findRowWithLargestTotal(data)); // 1
    }

    public static int rowSum(int[][] data, int row) {
        if (data == null || row < 0 || row >= data.length) {
            return -1;
        }
        int sum = 0;
        for (int val : data[row]) {
            sum += val;
        }
        return sum;
    }

    public static int columnSum(int[][] data, int column) {
        if (data == null || data.length == 0 || column < 0) {
            return -1;
        }

        int sum = 0;
        boolean validColumn = false;
        for (int i = 0; i < data.length; i++) {
            if (data[i] != null && column < data[i].length) {
                sum += data[i][column];
                validColumn = true;
            }
        }
        return validColumn ? sum : -1;
    }

    public static int countAtLeast(int[][] data, int target) {
        if (data == null) return 0;
        int count = 0;
        for (int[] row : data) {
            if (row != null) {
                for (int val : row) {
                    if (val >= target) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static int findRowWithLargestTotal(int[][] data) {
        if (data == null || data.length == 0) {
            return -1;
        }
        
        int maxIndex = -1;
        int maxTotal = Integer.MIN_VALUE;
        boolean hasData = false;

        for (int i = 0; i < data.length; i++) {
            if (data[i] != null && data[i].length > 0) {
                hasData = true;
                int currentSum = 0;
                for (int val : data[i]) {
                    currentSum += val;
                }
                if (currentSum > maxTotal) {
                    maxTotal = currentSum;
                    maxIndex = i;
                }
            }
        }
        return hasData ? maxIndex : -1;
    }
}