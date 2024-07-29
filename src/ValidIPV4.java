import java.util.Arrays;

public class ValidIPV4 {
//    public static boolean isValidIPv4(String ipAddress) {
//        // write your code here
//        StringBuilder s = new StringBuilder(ipAddress);
//
//        String characters = "abcd";
//        if(ipAddress.contains(characters) || ipAddress.){
//
//        }
//    }
    public static boolean isValidIPv4(String ip) {
        // Split the IP by '.'
        String[] parts = ip.split("\\.");

        // Check if the IP has exactly 4 parts
        System.out.println(Arrays.toString(parts));
        if (parts.length != 4) {
            return false;
        }

        for (String part : parts) {
            // Check if the part is a valid integer and within the range 0 to 255
            try {
                int num = Integer.parseInt(part);
                if (num < 0 || num > 255) {
                    return false;
                }
                // Check for leading zeros in the number
                if (part.length() > 1 && part.charAt(0) == '0') {
                    return false;
                }
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] testIPs = {
                "123.111.12.k",
                "122.0.330.0",
                "1.1.1.250",
                "1.0.0.0.1",
                "1.90.21.1",
                "1.1"
        };

        for (String ip : testIPs) {
            System.out.println(ip + " is valid: " + isValidIPv4(ip));
        }
    }

}
