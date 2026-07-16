public class Q06_CommandValidator {
    public static void main(String[] args) {
        String[] commands = {
            "START",
            new String("stop"),
            " Pause ",
            "RUN",
            null,
            ""
        };
        for (String command : commands) {
            System.out.println(command + " -> " + isValidCommand(command));
        }
    }

    public static boolean isValidCommand(String command) {
        // 1. null 與空字串
        if (command == null) {
            return false;
        }
        
        // 2. 忽略前後空白
        String trimmed = command.trim();
        
        // 3. 忽略英文大小寫
        return trimmed.equalsIgnoreCase("START") || 
               trimmed.equalsIgnoreCase("STOP") || 
               trimmed.equalsIgnoreCase("PAUSE");
    }
}