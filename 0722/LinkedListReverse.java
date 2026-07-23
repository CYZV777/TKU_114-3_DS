class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedListReverse {

    public static Node reverse(Node head) {

        if (head == null || head.next == null) {
            return head;
        }

        Node prev = null;
        Node current = head;
        Node next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    public static void printList(Node head) {
        if (head == null) {
            System.out.println("null (空串列)");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.print(current.data + (current.next != null ? " -> " : "\n"));
            current = current.next;
        }
    }

    public static void main(String[] args) {
        System.out.println("=== 測試 1：空串列 ===");
        Node emptyHead = null;
        System.out.print("反轉前: ");
        printList(emptyHead);
        emptyHead = reverse(emptyHead);
        System.out.print("反轉後: ");
        printList(emptyHead);

        System.out.println("\n=== 測試 2：單一節點 ===");
        Node singleHead = new Node(100);
        System.out.print("反轉前: ");
        printList(singleHead);
        singleHead = reverse(singleHead);
        System.out.print("反轉後: ");
        printList(singleHead);

        System.out.println("\n=== 測試 3：多節點 (10 -> 20 -> 30 -> 40) ===");
        Node n1 = new Node(10);
        Node n2 = new Node(20);
        Node n3 = new Node(30);
        Node n4 = new Node(40);

        Node head = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        System.out.print("反轉前: ");
        printList(head);
        
        head = reverse(head);
        
        System.out.print("反轉後: ");
        printList(head);
    }
}