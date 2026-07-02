import java.util.Scanner;

public class ScoreReport {
    public static void main(String[] args) {
    // 讀取使用者輸入的姓名與三科成績，並計算印出平均分數
        Scanner sc = new Scanner(System.in);

        System.out.print("請輸入姓名：");
        String name = sc.nextLine();

        System.out.print("請輸入 Java 成績：");
        int javaScore = sc.nextInt();

        System.out.print("請輸入 English 成績：");
        int englishScore = sc.nextInt();

        System.out.print("請輸入 Math 成績：");
        int mathScore = sc.nextInt();

        // 計算平均分數
        double average = (javaScore + englishScore + mathScore) / 3.0;

        System.out.println("\n=== 成績報表 ===");
        System.out.println("姓名：" + name);
        System.out.println("Java：" + javaScore);
        System.out.println("English：" + englishScore);
        System.out.println("Math：" + mathScore);
        
        // 輸出計算後的平均分數
        System.out.println("平均：" + average);

        sc.close();
    }
}
