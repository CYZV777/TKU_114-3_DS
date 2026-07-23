import java.util.ArrayList;
import java.util.Scanner;

public class DynamicScoreManager {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> scores = new ArrayList<>();

        System.out.println("=== 動態成績管理系統 ===");
        System.out.println("請輸入成績 (0-100)，輸入 -1 結束輸入：");

        while (true) {
            System.out.print("請輸入成績: ");
            if (scanner.hasNextInt()) {
                int input = scanner.nextInt();

                if (input == -1) {
                    break; 
                }

                if (input >= 0 && input <= 100) {
                    scores.add(input);
                } else {
                    System.out.println("⚠️ 成績無效！請輸入 0 到 100 之間的數字。");
                }
            } else {
                System.out.println("⚠️ 請輸入有效的整數！");
                scanner.next();
            }
        }

        System.out.println("\n----------------------------------");

        if (scores.isEmpty()) {
            System.out.println("未輸入任何有效成績，無法進行統計。");
        } else {

            printStatistics(scores);
            printPassedScores(scores);
        }

        scanner.close();
    }

    public static void printStatistics(ArrayList<Integer> scores) {
        int count = scores.size();
        int sum = 0;
        int max = scores.get(0);
        int min = scores.get(0);

        for (int score : scores) {
            sum += score;
            if (score > max) max = score;
            if (score < min) min = score;
        }

        double average = (double) sum / count;

        System.out.println("【成績統計】");
        System.out.println("總筆數: " + count + " 筆");
        System.out.printf("平均分數: %.2f\n", average);
        System.out.println("最高分: " + max);
        System.out.println("最低分: " + min);
    }

    public static void printPassedScores(ArrayList<Integer> scores) {
        ArrayList<Integer> passedList = getPassedScores(scores);

        System.out.println("\n【及格名單 (>=60)】");
        System.out.println("及格人數: " + passedList.size() + " 人");
        System.out.println("及格成績: " + passedList);
    }

    public static ArrayList<Integer> getPassedScores(ArrayList<Integer> scores) {
        ArrayList<Integer> passed = new ArrayList<>();
        for (int score : scores) {
            if (score >= 60) {
                passed.add(score);
            }
        }
        return passed;
    }
}