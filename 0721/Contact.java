public class Contact {
    public String id;
    public String name;
    public String phone;
    public String email;

    public Contact(String id, String name, String phone, String email) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    @Override
    public String toString() {
        return "代碼: " + id + ", 姓名: " + name + ", 電話: " + phone + ", Email: " + email;
    }
}