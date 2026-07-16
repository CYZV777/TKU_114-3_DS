public class Q01_ParkingFeeFix {
    public static void main(String[] args) {
        int[] testMinutes = {-20, 30, 31, 60, 61, 120, 121, 420};
        for (int minutes : testMinutes) {
            int fee = calculateFee(minutes);
            System.out.println("停車" + minutes + "分鐘,費用:" + fee + "元");
        }
    }

    public static int calculateFee(int minutes) {
        // 1. 停車時間小於0分鐘，回傳 -1
        if (minutes < 0) {
            return -1;
        }
        // 2. 停車時間為 0 ~ 30 分鐘，免費
        if (minutes <= 30) {
            return 0;
        }
        
        int fee = 0;
        // 3. 超過30分鐘但不超過120分鐘
        if (minutes <= 120) {
            int overMinutes = minutes - 30;
            int periods = (overMinutes + 29) / 30;
            fee = periods * 20;
        } else {
            // 4. 超過120分鐘，前120分鐘收費60元
            int overMinutes = minutes - 120;
            // 之後每開始60分鐘加收30元
            int periods = (overMinutes + 59) / 60;
            fee = 60 + (periods * 30);
        }        
        // 5. 單次停車費最高限制為 180 元
        if (fee > 180) {
            fee = 180;
        }
        
        return fee;
    }
}