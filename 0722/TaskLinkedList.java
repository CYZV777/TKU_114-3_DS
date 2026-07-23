public class TaskLinkedList {
    private TaskNode head;

    public TaskLinkedList() {
        this.head = null;
    }

    public TaskNode searchById(String id) {
        TaskNode current = head;
        while (current != null) {
            if (current.id.equals(id)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void addUrgentTask(String id, String description) {
        if (searchById(id) != null) {
            System.out.println("【新增失敗】工作代碼 " + id + " 已存在！");
            return;
        }
        TaskNode newNode = new TaskNode(id, description);
        newNode.next = head;
        head = newNode;
        System.out.println("【成功新增緊急工作】[" + id + "] " + description + " (插隊至前端)");
    }

    public void addNormalTask(String id, String description) {
        if (searchById(id) != null) {
            System.out.println("【新增失敗】工作代碼 " + id + " 已存在！");
            return;
        }
        TaskNode newNode = new TaskNode(id, description);
        if (head == null) {
            head = newNode;
        } else {
            TaskNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        System.out.println("【成功新增一般工作】[" + id + "] " + description + " (加入至尾端)");
    }

    public void completeTask(String id) {
        TaskNode task = searchById(id);
        if (task == null) {
            System.out.println("【完成標示失敗】找不到工作代碼: " + id);
            return;
        }
        task.isCompleted = true;
        System.out.println("【成功完成工作】[" + id + "] " + task.description);
    }

    public void removeTask(String id) {
        if (head == null) {
            System.out.println("【刪除失敗】工作列表為空！");
            return;
        }

        if (head.id.equals(id)) {
            System.out.println("【成功刪除工作】[" + head.id + "] " + head.description);
            head = head.next;
            return;
        }

        TaskNode prev = head;
        TaskNode current = head.next;

        while (current != null) {
            if (current.id.equals(id)) {
                prev.next = current.next;
                System.out.println("【成功刪除工作】[" + current.id + "] " + current.description);
                return;
            }
            prev = current;
            current = current.next;
        }

        System.out.println("【刪除失敗】找不到工作代碼: " + id);
    }

    public void printPendingTasks() {
        System.out.println("--- [未完成工作列表] ---");
        if (head == null) {
            System.out.println("(無任何工作)");
            return;
        }

        TaskNode current = head;
        boolean hasPending = false;

        while (current != null) {
            if (!current.isCompleted) {
                System.out.println("- [" + current.id + "] " + current.description);
                hasPending = true;
            }
            current = current.next;
        }

        if (!hasPending) {
            System.out.println("(太棒了！所有工作皆已完成)");
        }
    }

    public void printAllAndStats() {
        System.out.print("當前所有工作: ");
        if (head == null) {
            System.out.println("null (列表為空)");
            System.out.println("【統計結果】工作總數: 0, 未完成數量: 0");
            return;
        }

        TaskNode current = head;
        int totalCount = 0;
        int pendingCount = 0;

        while (current != null) {
            String status = current.isCompleted ? "[已完成]" : "[未完成]";
            System.out.print("[" + current.id + " " + current.description + " " + status + "]" + (current.next != null ? " -> " : "\n"));

            totalCount++;
            if (!current.isCompleted) {
                pendingCount++;
            }

            current = current.next;
        }

        System.out.println("【統計結果】工作總數: " + totalCount + ", 未完成數量: " + pendingCount);
    }
}