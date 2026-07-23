import java.util.ArrayList;
import java.util.Scanner;

public class ContactBookSystem {
    private static ArrayList<Contact> list = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1.新增 2.搜尋 3.修改電話 4.刪除 5.完整清單 6.離開");
            System.out.print("請選擇功能: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 6) {
                System.out.println("程式結束！");
                break;
            }

            switch (choice) {
                case 1:
                    addContact();      // Method 1
                    break;
                case 2:
                    searchContact();   // Method 2
                    break;
                case 3:
                    updatePhone();     // Method 3
                    break;
                case 4:
                    deleteContact();   // Method 4
                    break;
                case 5:
                    showAll();         // Method 5
                    break;
                default:
                    System.out.println("選項錯誤！");
            }
        }
        sc.close();
    }

    public static void addContact() {
        System.out.print("請輸入代碼: ");
        String id = sc.nextLine().trim();

        for (Contact c : list) {
            if (c.id.equalsIgnoreCase(id)) {
                System.out.println("新增失敗：代碼重複！");
                return;
            }
        }

        System.out.print("請輸入姓名: ");
        String name = sc.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println("新增失敗：姓名不可空白！");
            return;
        }

        System.out.print("請輸入電話: ");
        String phone = sc.nextLine().trim();

        System.out.print("請輸入 Email: ");
        String email = sc.nextLine().trim();

        list.add(new Contact(id, name, phone, email));
        System.out.println("新增成功！");
    }

    public static void searchContact() {
        System.out.print("請輸入要搜尋的代碼: ");
        String id = sc.nextLine().trim();

        for (Contact c : list) {
            if (c.id.equalsIgnoreCase(id)) {
                System.out.println("找到聯絡人: " + c);
                return;
            }
        }
        System.out.println("找不到該聯絡人！");
    }

    public static void updatePhone() {
        System.out.print("請輸入要修改電話的代碼: ");
        String id = sc.nextLine().trim();

        for (Contact c : list) {
            if (c.id.equalsIgnoreCase(id)) {
                System.out.print("請輸入新電話: ");
                c.phone = sc.nextLine().trim();
                System.out.println("修改成功！");
                return;
            }
        }
        System.out.println("找不到該聯絡人！");
    }

    public static void deleteContact() {
        System.out.print("請輸入要刪除的代碼: ");
        String id = sc.nextLine().trim();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).id.equalsIgnoreCase(id)) {
                list.remove(i);
                System.out.println("刪除成功！");
                return;
            }
        }
        System.out.println("刪除失敗：找不到該聯絡人！");
    }

    public static void showAll() {
        if (list.isEmpty()) {
            System.out.println("目前無聯絡人資料。");
            return;
        }

        System.out.println("--- 聯絡人清單 ---");
        for (Contact c : list) {
            System.out.println(c);
        }
    }
}