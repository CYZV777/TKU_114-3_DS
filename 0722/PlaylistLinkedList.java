public class PlaylistLinkedList {
    private PlaylistNode head;

    public PlaylistLinkedList() {
        this.head = null;
    }

    public PlaylistNode searchById(String id) {
        PlaylistNode current = head;
        while (current != null) {
            if (current.id.equals(id)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void addLast(String id, String title) {
        if (searchById(id) != null) {
            System.out.println("【新增失敗】歌曲代碼 " + id + " 已存在，不可重複新增！");
            return;
        }

        PlaylistNode newNode = new PlaylistNode(id, title);

        if (head == null) {
            head = newNode;
            System.out.println("【成功新增】" + id + " - " + title);
            return;
        }
        PlaylistNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        System.out.println("【成功新增】" + id + " - " + title);
    }

    public void removeById(String id) {
        if (head == null) {
            System.out.println("【刪除失敗】播放清單為空！");
            return;
        }

        if (head.id.equals(id)) {
            System.out.println("【成功刪除】" + head.id + " - " + head.title + " (第一首)");
            head = head.next;
            return;
        }

        PlaylistNode prev = head;
        PlaylistNode current = head.next;

        while (current != null) {
            if (current.id.equals(id)) {
                prev.next = current.next;
                System.out.println("【成功刪除】" + current.id + " - " + current.title);
                return;
            }
            prev = current;
            current = current.next;
        }

        System.out.println("【刪除失敗】找不到歌曲代碼: " + id);
    }

    public void printPlaylist() {
        System.out.print("播放順序: ");
        if (head == null) {
            System.out.println("null (目前無歌曲)");
            return;
        }

        PlaylistNode current = head;
        while (current != null) {
            System.out.print("[" + current.id + "] " + current.title + (current.next != null ? " -> " : ""));
            current = current.next;
        }
        System.out.println();
    }
}