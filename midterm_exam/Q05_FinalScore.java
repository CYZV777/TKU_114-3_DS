public class Q05_FinalScore {
    public static void main(String[] args) {
        System.out.println(calculateFinalScore(80, 90, 5));     // 91.0
        System.out.println(calculateFinalScore(100, 100, 10));  // 100.0
        System.out.println(calculateFinalScore(-1, 80, 5));     // -1.0
        System.out.println(calculateFinalScore(70, 60, 11));    // -1.0
    }

    public static double calculateFinalScore(int examScore, int assignmentScore, int bonus) {
        // 1. 考試成績與作業成績必須介於0~100
        if (examScore < 0 || examScore > 100 || assignmentScore < 0 || assignmentScore > 100) {
            return -1.0;
        }
        // 2. 加分必須介於0~10
        if (bonus < 0 || bonus > 10) {
            return -1.0;
        }
        
        // 4. 原始成績為考試成績的40%加上作業成績的60%
        double originalScore = (examScore * 0.4) + (assignmentScore * 0.6);
        
        // 5. 加上加分後，最高為 100 分
        double finalScore = originalScore + bonus;
        
        if (finalScore > 100.0) {
            finalScore = 100.0;
        }
        
        return finalScore;
    }
}