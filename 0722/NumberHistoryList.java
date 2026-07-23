class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class NumberHistoryList {

    public static Node addFirst(Node head, int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        return newNode;
    }

    public static Node addLast(Node head, int data) {
        Node newNode = new Node(data);
        if (head == null) {
            return newNode;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        return head;
    }

    public static boolean contains(Node head, int target) {
        Node current = head;
        while (current != null) {
            if (current.data == target) return true;
            current = current.next;
        }
        return false;
    }

    public static Node remove(Node head, int target) {
        if (head == null) {
            System.out.println("【刪除失敗】串列為空！");
            return null;
        }

        if (head.data == target) {
            System.out.println("【成功刪除】數值: " + target + " (原 head)");
            return head.next;
        }

        Node prev = head;
        Node current = head.next;

        while (current != null) {
            if (current.data == target) {
                prev.next = current.next;
                System.out.println("【成功刪除】數值: " + target);
                return head;
            }
            prev = current;
            current = current.next;
        }

        System.out.println("【刪除失敗】找不到數值: " + target);
        return head;
    }

    public static void printStatsAndList(Node head) {
        System.out.print("當前串列: ");
        if (head == null) {
            System.out.println("null (空串列)");
            System.out.println("【統計結果】Size: 0, Sum: 0, Max: N/A, Min: N/A");
            return;
        }

        Node current = head;
        int size = 0;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        while (current != null) {
            System.out.print(current.data + (current.next != null ? " -> " : "\n"));

            size++;
            sum += current.data;
            if (current.data > max) max = current.data;
            if (current.data < min) min = current.data;

            current = current.next;
        }

        System.out.println("【統計結果】Size: " + size + ", Sum: " + sum + ", Max: " + max + ", Min: " + min);
    }

    public static void main(String[] args) {
        Node head = null;

        System.out.println("=== 測試 1: 空串列統計 (功能要求 3) ===");
        printStatsAndList(head);

        System.out.println("\n=== 開始測試 8 次以上操作 (功能要求 1 & 4) ===");

        System.out.println("\n[操作 1] addLast(20)");
        head = addLast(head, 20);
        printStatsAndList(head);

        System.out.println("\n[操作 2] addFirst(10)");
        head = addFirst(head, 10);
        printStatsAndList(head);

        System.out.println("\n[操作 3] addLast(30)");
        head = addLast(head, 30);
        printStatsAndList(head);

        System.out.println("\n[操作 4] addFirst(5)");
        head = addFirst(head, 5);
        printStatsAndList(head);

        System.out.println("\n[操作 5] 搜尋測試");
        System.out.println("Contains 30? " + contains(head, 30));
        System.out.println("Contains 99? " + contains(head, 99));

        System.out.println("\n[操作 6] remove(20) - 刪除中間");
        head = remove(head, 20);
        printStatsAndList(head);

        System.out.println("\n[操作 7] remove(5) - 刪除 head");
        head = remove(head, 5);
        printStatsAndList(head);

        System.out.println("\n[操作 8] remove(99) - 刪除不存在資料");
        head = remove(head, 99);
        printStatsAndList(head);

        System.out.println("\n[操作 9] addLast(50)");
        head = addLast(head, 50);
        printStatsAndList(head);
    }
}