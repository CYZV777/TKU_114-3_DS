import java.util.ArrayList;
import java.util.Scanner;

public class EquipmentManager {
    public static void main(String[] args) {
        ArrayList<Equipment> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1.新增 2.搜尋 3.借出 4.歸還 5.列出可借 6.離開");
            System.out.print("請選擇: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 6) {
                System.out.println("程式結束");
                break;
            }

            switch (choice) {
                case 1:
                    System.out.print("請輸入代碼: ");
                    String id = sc.nextLine();

                    boolean exists = false;
                    for (Equipment eq : list) {
                        if (eq.id.equalsIgnoreCase(id)) {
                            exists = true;
                            break;
                        }
                    }

                    if (exists) {
                        System.out.println("新增失敗：代碼重複！");
                    } else {
                        System.out.print("請輸入名稱: ");
                        String name = sc.nextLine();
                        list.add(new Equipment(id, name));
                        System.out.println("新增成功！");
                    }
                    break;

                case 2:
                    System.out.print("請輸入要搜尋的代碼: ");
                    String searchId = sc.nextLine();
                    boolean found = false;

                    for (Equipment eq : list) {
                        if (eq.id.equalsIgnoreCase(searchId)) {
                            System.out.println("找到設備: " + eq);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("找不到該代碼的設備！");
                    }
                    break;

                case 3:
                    System.out.print("請輸入要借出的代碼: ");
                    String borrowId = sc.nextLine();
                    Equipment borrowEq = null;

                    for (Equipment eq : list) {
                        if (eq.id.equalsIgnoreCase(borrowId)) {
                            borrowEq = eq;
                            break;
                        }
                    }

                    if (borrowEq == null) {
                        System.out.println("找不到此設備！");
                    } else if (!borrowEq.isAvailable) {
                        System.out.println("此設備已被借出！");
                    } else {
                        borrowEq.isAvailable = false;
                        System.out.println("借出成功！");
                    }
                    break;

                case 4:
                    System.out.print("請輸入要歸還的代碼: ");
                    String returnId = sc.nextLine();
                    Equipment returnEq = null;

                    for (Equipment eq : list) {
                        if (eq.id.equalsIgnoreCase(returnId)) {
                            returnEq = eq;
                            break;
                        }
                    }

                    if (returnEq == null) {
                        System.out.println("找不到此設備！");
                    } else if (returnEq.isAvailable) {
                        System.out.println("此設備未被借出！");
                    } else {
                        returnEq.isAvailable = true;
                        System.out.println("歸還成功！");
                    }
                    break;

                case 5:
                    System.out.println("--- 可借用設備清單 ---");
                    for (Equipment eq : list) {
                        if (eq.isAvailable) {
                            System.out.println(eq);
                        }
                    }
                    break;

                default:
                    System.out.println("選項錯誤，請重新輸入！");
            }
        }
        sc.close();
    }
}