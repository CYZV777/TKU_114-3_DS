public class TaskLinkedListSystem {
    public static void main(String[] args) {
        TaskLinkedList taskList = new TaskLinkedList();

        System.out.println("=== 1. 測試空串列狀態 ===");
        taskList.printAllAndStats();
        taskList.removeTask("T001");

        System.out.println("\n=== 2. 新增一般與緊急工作 (功能要求 2) ===");
        taskList.addNormalTask("T001", "撰寫報告");
        taskList.addNormalTask("T002", "整理房間");
        taskList.addUrgentTask("T000", "修復系統漏洞");
        taskList.addNormalTask("T003", "準備簡報");
        taskList.printAllAndStats();

        System.out.println("\n=== 3. 測試完成工作 (功能要求 3) ===");
        taskList.completeTask("T000");
        taskList.completeTask("T002");
        taskList.printAllAndStats();

        System.out.println("\n=== 4. 列出未完成工作 (功能要求 3) ===");
        taskList.printPendingTasks();

        System.out.println("\n=== 5. 測試刪除工作 (刪除 head 與中間) ===");
        taskList.removeTask("T000");
        taskList.printAllAndStats();

        System.out.println("\n=== 6. 測試找不到資料與重複代碼防呆 ===");
        taskList.removeTask("T999");
        taskList.completeTask("T999");
        taskList.addNormalTask("T001", "重複的工作");
    }
}