public class Q10_RecordParser {
    public static void main(String[] args) {
        String[] records = {
            "A101 | Keyboard |3|850",
            "A102 | Mouse |-1|500",
            "broken data",
            "A103|Monitor|2|4200",
            "A104||1|300"
        };
        for (String record : records) {
            System.out.println(record + " -> " + calculateRecordTotal(record));
        }
        System.out.println("合法筆數:" + countValidRecords(records));
        System.out.println("總金額:" + calculateGrandTotal(records));
    }

    public static boolean isValidRecord(String record) {
        if (record == null || record.trim().isEmpty()) {
            return false;
        }
        
        // 依據 '|' 切割字串，需要用 "\\|"
        String[] fields = record.split("\\|", -1);
        if (fields.length != 4) {
            return false;
        }
        
        String code = fields[0].trim();
        String name = fields[1].trim();
        
        if (code.isEmpty() || name.isEmpty()) {
            return false;
        }
        
        try {
            int quantity = Integer.parseInt(fields[2].trim());
            int price = Integer.parseInt(fields[3].trim());
            
            // 數量必須 > 0 且單價必須 >= 0
            if (quantity <= 0 || price < 0) {
                return false;
            }
        } catch (NumberFormatException e) {
            return false; // 無法轉換成整數
        }
        
        return true;
    }

    public static int calculateRecordTotal(String record) {
        if (!isValidRecord(record)) {
            return -1;
        }
        String[] fields = record.split("\\|", -1);
        int quantity = Integer.parseInt(fields[2].trim());
        int price = Integer.parseInt(fields[3].trim());
        return quantity * price;
    }

    public static int countValidRecords(String[] records) {
        if (records == null) return 0;
        int count = 0;
        for (String record : records) {
            if (isValidRecord(record)) {
                count++;
            }
        }
        return count;
    }

    public static int calculateGrandTotal(String[] records) {
        if (records == null) return 0;
        int grandTotal = 0;
        for (String record : records) {
            if (isValidRecord(record)) {
                grandTotal += calculateRecordTotal(record);
            }
        }
        return grandTotal;
    }
}
