// 定義 Node 類別
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class BuildLinkedList {
    public static void main(String[] args) {
        Node n1 = new Node(10);
        Node n2 = new Node(20);
        Node n3 = new Node(30);
        Node n4 = new Node(40);

        Node head = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        Node current = head;
        int count = 0;
        int sum = 0;

        System.out.print("鏈結串列：");
        while (current != null) {
            System.out.print(current.data + (current.next != null ? " -> " : "\n"));
            
            sum += current.data;
            count++;
            
            current = current.next;
        }

        System.out.println("節點總數：" + count);
        System.out.println("資料總和：" + sum);
    }
}