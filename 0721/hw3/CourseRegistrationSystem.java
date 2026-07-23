package hw3;

import java.util.ArrayList;
import java.util.Scanner;

public class CourseRegistrationSystem {
    private static ArrayList<Course> courses = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1.新增課程 2.選課 3.退選 4.刪除課程 5.搜尋課程 6.統計資訊 7.離開");
            System.out.print("請選擇功能: ");
            int choice = sc.nextInt();
            sc.nextLine(); // 吃掉換行符號

            if (choice == 7) {
                System.out.println("程式結束！");
                break;
            }

            switch (choice) {
                case 1:
                    addCourse();
                    break;
                case 2:
                    registerCourse();
                    break;
                case 3:
                    dropCourse();
                    break;
                case 4:
                    deleteCourse();
                    break;
                case 5:
                    searchCourse();
                    break;
                case 6:
                    showStats();
                    break;
                default:
                    System.out.println("選項錯誤！");
            }
        }
        sc.close();
    }

    // 1. 新增課程 (代碼不重複、容量 > 0)
    public static void addCourse() {
        System.out.print("請輸入課程代碼: ");
        String id = sc.nextLine().trim();

        for (Course c : courses) {
            if (c.id.equalsIgnoreCase(id)) {
                System.out.println("新增失敗：代碼已存在！");
                return;
            }
        }

        System.out.print("請輸入課程名稱: ");
        String name = sc.nextLine().trim();

        System.out.print("請輸入課程容量: ");
        int capacity = sc.nextInt();
        sc.nextLine();

        if (capacity <= 0) {
            System.out.println("新增失敗：容量必須大於 0！");
            return;
        }

        courses.add(new Course(id, name, capacity));
        System.out.println("新增成功！");
    }

    // 2. 選課 (人數 +1，額滿擋件)
    public static void registerCourse() {
        System.out.print("請輸入要選課的代碼: ");
        String id = sc.nextLine().trim();

        for (Course c : courses) {
            if (c.id.equalsIgnoreCase(id)) {
                if (c.isFull()) {
                    System.out.println("選課失敗：該課程已額滿！");
                } else {
                    c.currentCount++;
                    System.out.println("選課成功！目前人數: " + c.currentCount + "/" + c.capacity);
                }
                return;
            }
        }
        System.out.println("選課失敗：找不到該課程！");
    }

    // 3. 退選 (人數 -1)
    public static void dropCourse() {
        System.out.print("請輸入要退選的代碼: ");
        String id = sc.nextLine().trim();

        for (Course c : courses) {
            if (c.id.equalsIgnoreCase(id)) {
                if (c.currentCount <= 0) {
                    System.out.println("退選失敗：目前無人選修此課程！");
                } else {
                    c.currentCount--;
                    System.out.println("退選成功！目前人數: " + c.currentCount + "/" + c.capacity);
                }
                return;
            }
        }
        System.out.println("退選失敗：找不到該課程！");
    }

    // 4. 刪除課程
    public static void deleteCourse() {
        System.out.print("請輸入要刪除的代碼: ");
        String id = sc.nextLine().trim();

        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).id.equalsIgnoreCase(id)) {
                courses.remove(i);
                System.out.println("刪除成功！");
                return;
            }
        }
        System.out.println("刪除失敗：找不到該課程！");
    }

    // 5. 搜尋課程 (依代碼)
    public static void searchCourse() {
        System.out.print("請輸入要搜尋的代碼: ");
        String id = sc.nextLine().trim();

        for (Course c : courses) {
            if (c.id.equalsIgnoreCase(id)) {
                System.out.println("找到課程: " + c);
                return;
            }
        }
        System.out.println("找不到該課程！");
    }

    // 6. 輸出總課程數、總選課人次與額滿課程
    public static void showStats() {
        if (courses.isEmpty()) {
            System.out.println("目前無任何課程資料。");
            return;
        }

        int totalCourses = courses.size();
        int totalStudents = 0;
        ArrayList<Course> fullCourses = new ArrayList<>();

        for (Course c : courses) {
            totalStudents += c.currentCount;
            if (c.isFull()) {
                fullCourses.add(c);
            }
        }

        System.out.println("--- 統計資訊 ---");
        System.out.println("總課程數: " + totalCourses + " 門");
        System.out.println("總選課人次: " + totalStudents + " 人次");
        System.out.println("額滿課程數量: " + fullCourses.size() + " 門");
        
        if (!fullCourses.isEmpty()) {
            System.out.println("額滿課程清單:");
            for (Course fc : fullCourses) {
                System.out.println(" - " + fc);
            }
        }
    }
}