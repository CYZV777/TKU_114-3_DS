public class CourseInfo {
    public static void main(String[] args) {
        
        String courseName = "Programming";
        int credits = 3;
        int hours = 3;
        boolean required = true; // true 是必修，false 是選修

        System.out.println("=== 課程資訊 ===");
        System.out.println("課程名稱: " + courseName);
        System.out.println("學分數: " + credits + " 學分");
        System.out.println("上課時數: " + hours + " 小時");
        System.out.println("是否必修: " + required);
    }
}
