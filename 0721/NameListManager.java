import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NameListManager {
    private static final List<String> nameList = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            printMenu();
            System.out.print("請選擇操作功能 (1-6): ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    addName();
                    break;
                case "2":
                    searchName();
                    break;
                case "3":
                    editName();
                    break;
                case "4":
                    deleteName();
                    break;
                case "5":
                    listAllNames();
                    break;
                case "6":
                    running = false;
                    System.out.println("\n系統已結束，謝謝使用！");
                    break;
                default:
                    System.out.println("❌ 無效的選擇，請輸入 1 到 6 之間的數字。\n");
            }
        }
        scanner.close();
    }

    // 顯示功能選單
    private static void printMenu() {
        System.out.println("===============================");
        System.out.println("       名單管理系統");
        System.out.println("===============================");
        System.out.println("1. 新增姓名");
        System.out.println("2. 搜尋姓名");
        System.out.println("3. 修改姓名");
        System.out.println("4. 刪除姓名");
        System.out.println("5. 列出全部姓名");
        System.out.println("6. 離開系統");
        System.out.println("-------------------------------");
    }

    private static void addName() {
        System.out.print("請輸入要新增的姓名: ");
        String name = scanner.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println("❌ 錯誤：不能新增空白姓名！\n");
            return;
        }

        nameList.add(name);
        System.out.println("✅ 成功新增姓名：「" + name + "」\n");
    }

    private static void searchName() {
        System.out.print("請輸入要搜尋的姓名: ");
        String query = scanner.nextLine().trim();

        if (query.isEmpty()) {
            System.out.println("❌ 請輸入有效的搜尋名稱！\n");
            return;
        }

        boolean found = false;
        for (int i = 0; i < nameList.size(); i++) {
            if (nameList.get(i).equalsIgnoreCase(query)) {
                System.out.println("🔍 找到符合的姓名：第 " + (i + 1) + " 筆 -> " + nameList.get(i));
                found = true;
            }
        }

        if (!found) {
            System.out.println("❌ 找不到符合「" + query + "」的姓名。\n");
        } else {
            System.out.println();
        }
    }

    private static void editName() {
        System.out.print("請輸入要修改的原姓名: ");
        String oldName = scanner.nextLine().trim();

        int index = findIndexIgnoreCase(oldName);
        if (index == -1) {
            System.out.println("❌ 找不到姓名：「" + oldName + "」，無法修改。\n");
            return;
        }

        System.out.print("請輸入新的姓名: ");
        String newName = scanner.nextLine().trim();

        if (newName.isEmpty()) {
            System.out.println("❌ 錯誤：新姓名不能為空！修改失敗。\n");
            return;
        }

        String originalName = nameList.get(index);
        nameList.set(index, newName);
        System.out.println("✅ 修改成功！已將「" + originalName + "」更新為「" + newName + "」\n");
    }

    private static void deleteName() {
        System.out.print("請輸入要刪除的姓名: ");
        String target = scanner.nextLine().trim();

        int index = findIndexIgnoreCase(target);
        if (index != -1) {
            String removedName = nameList.remove(index);
            System.out.println("✅ 刪除成功！已移除姓名：「" + removedName + "」\n");
        } else {
            System.out.println("❌ 刪除失敗：找不到姓名：「" + target + "」\n");
        }
    }

    private static void listAllNames() {
        if (nameList.isEmpty()) {
            System.out.println("ℹ️ 目前名單中沒有任何資料。\n");
            return;
        }

        System.out.println("📋 目前所有姓名清單：");
        for (int i = 0; i < nameList.size(); i++) {
            System.out.println((i + 1) + ". " + nameList.get(i));
        }
        System.out.println();
    }

    private static int findIndexIgnoreCase(String target) {
        if (target == null || target.trim().isEmpty()) {
            return -1;
        }
        for (int i = 0; i < nameList.size(); i++) {
            if (nameList.get(i).equalsIgnoreCase(target.trim())) {
                return i;
            }
        }
        return -1;
    }
}