class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedListSearchRemove {

    public static boolean contains(Node head, int target) {
        Node current = head;
        while (current != null) {
            if (current.data == target) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public static Node removeValue(Node head, int target) {
 
        if (head == null) {
            System.out.println("串列為空，無法刪除！");
            return null;
        }

        if (head.data == target) {
            System.out.println("已刪除 head 節點: " + target);
            return head.next;
        }
        Node prev = head;
        Node current = head.next;

        while (current != null) {
            if (current.data == target) {
                prev.next = current.next;
                System.out.println("已刪除節點: " + target);
                return head;
            }
            prev = current;
            current = current.next;
        }

        System.out.println("找不到數值: " + target + "，無法刪除！");
        return head;
    }

    public static void printList(Node head) {
        System.out.print("當前串列: ");
        if (head == null) {
            System.out.println("null (空串列)");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.print(current.data + (current.next != null ? " -> " : ""));
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Node n1 = new Node(10);
        Node n2 = new Node(20);
        Node n3 = new Node(30);
        Node n4 = new Node(40);

        Node head = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        System.out.println("=== 初始狀態 ===");
        printList(head);

        System.out.println("\n=== 測試 contains 搜尋 ===");
        System.out.println("是否包含 20？ " + contains(head, 20));
        System.out.println("是否包含 99？ " + contains(head, 99));

        System.out.println("\n=== 測試刪除中間節點 (20) ===");
        head = removeValue(head, 20);
        printList(head);

        System.out.println("\n=== 測試刪除最後節點 (40) ===");
        head = removeValue(head, 40);
        printList(head);

        System.out.println("\n=== 測試刪除 head 節點 (10) ===");
        head = removeValue(head, 10);
        printList(head);

        System.out.println("\n=== 測試找不到資料 (99) ===");
        head = removeValue(head, 99);
        printList(head);
    }
}