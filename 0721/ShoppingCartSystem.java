import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingCartSystem {
    private static ArrayList<CartItem> cart = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1.加入商品 2.修改數量 3.移除商品 4.購物車與總額 5.離開");
            System.out.print("請選擇功能: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 5) {
                System.out.println("程式結束！");
                break;
            }

            switch (choice) {
                case 1:
                    addToCart();
                    break;
                case 2:
                    updateQuantity();
                    break;
                case 3:
                    removeItem();
                    break;
                case 4:
                    showCart();
                    break;
                default:
                    System.out.println("選項錯誤！");
            }
        }
        sc.close();
    }

    public static void addToCart() {
        System.out.print("請輸入商品代碼: ");
        String id = sc.nextLine().trim();

        System.out.print("請輸入數量: ");
        int quantity = sc.nextInt();
        sc.nextLine();

        if (quantity <= 0) {
            System.out.println("加入失敗：數量必須大於 0！");
            return;
        }

        for (CartItem item : cart) {
            if (item.id.equalsIgnoreCase(id)) {
                item.quantity += quantity;
                System.out.println("商品已存在，已累加數量！目前數量: " + item.quantity);
                return;
            }
        }

        System.out.print("請輸入商品名稱: ");
        String name = sc.nextLine().trim();

        System.out.print("請輸入單價: ");
        int price = sc.nextInt();
        sc.nextLine();

        cart.add(new CartItem(id, name, price, quantity));
        System.out.println("加入成功！");
    }

    public static void updateQuantity() {
        System.out.print("請輸入要修改數量的代碼: ");
        String id = sc.nextLine().trim();

        for (CartItem item : cart) {
            if (item.id.equalsIgnoreCase(id)) {
                System.out.print("請輸入新數量: ");
                int newQty = sc.nextInt();
                sc.nextLine();

                if (newQty <= 0) {
                    System.out.println("修改失敗：數量必須大於 0！");
                    return;
                }

                item.quantity = newQty;
                System.out.println("數量修改成功！");
                return;
            }
        }
        System.out.println("修改失敗：找不到該商品！");
    }

    public static void removeItem() {
        System.out.print("請輸入要移除的代碼: ");
        String id = sc.nextLine().trim();

        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).id.equalsIgnoreCase(id)) {
                cart.remove(i);
                System.out.println("移除成功！");
                return;
            }
        }
        System.out.println("移除失敗：找不到該商品！");
    }

    public static void showCart() {
        if (cart.isEmpty()) {
            System.out.println("購物車目前是空的。");
            return;
        }

        System.out.println("--- 購物車清單 ---");
        int total = 0;
        for (CartItem item : cart) {
            System.out.println(item);
            total += item.getSubtotal();
        }
        System.out.println("----------------");
        System.out.println("總金額: $" + total);
    }
}