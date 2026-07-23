public class PlaylistSystem {
    public static void main(String[] args) {
        PlaylistLinkedList playlist = new PlaylistLinkedList();

        System.out.println("=== 1. 測試空串列列印與刪除 ===");
        playlist.printPlaylist();
        playlist.removeById("S001");

        System.out.println("\n=== 2. 測試新增歌曲 (尾端新增) ===");
        playlist.addLast("S001", "RUN BTS");
        playlist.addLast("S002", "Spring day");
        playlist.addLast("S003", "NORMAL");
        playlist.addLast("S004", "Into the Sun");
        playlist.printPlaylist();

        System.out.println("\n=== 3. 測試代碼重複新增 (功能要求 3) ===");
        playlist.addLast("S002", "重複的歌曲");

        System.out.println("\n=== 4. 測試依代碼搜尋 ===");
        PlaylistNode song = playlist.searchById("S003");
        if (song != null) {
            System.out.println("搜尋結果: 找到 " + song.id + " - " + song.title);
        } else {
            System.out.println("搜尋結果: 找不到歌曲");
        }

        System.out.println("\n=== 5. 測試刪除第一首歌曲 (S001) ===");
        playlist.removeById("S001");
        playlist.printPlaylist();

        System.out.println("\n=== 6. 測試刪除最後一首歌曲 (S004) ===");
        playlist.removeById("S004");
        playlist.printPlaylist();

        System.out.println("\n=== 7. 測試刪除不存在的歌曲 (S999) ===");
        playlist.removeById("S999");
        playlist.printPlaylist();
    }
}