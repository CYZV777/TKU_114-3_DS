public class Equipment {
    public String id;
    public String name;
    public boolean isAvailable;

    public Equipment(String id, String name) {
        this.id = id;
        this.name = name;
        this.isAvailable = true;
    }

    @Override
    public String toString() {
        return "代碼: " + id + ", 名稱: " + name + ", 狀態: " + (isAvailable ? "可借用" : "已借出");
    }
}