public class CartItem {
    public String id;
    public String name;
    public int price;
    public int quantity;

    public CartItem(String id, String name, int price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public int getSubtotal() {
        return price * quantity;
    }

    @Override
    public String toString() {
        return "代碼: " + id + ", 名稱: " + name + ", 單價: " + price + ", 數量: " + quantity + ", 小計: " + getSubtotal();
    }
}