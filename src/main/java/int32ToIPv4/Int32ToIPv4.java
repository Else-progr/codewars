package int32ToIPv4;

public class Int32ToIPv4 {

    public static int integerSize = 32;
    public static String binaryBackwards;

    public static String longToIP(long ip){

        binaryBackwards = "";
        calculateBinaryBackwards(ip);
        setZero();

        String binary = reverseOrder();

        return calculateIPV4(binary);
    }

    private static void calculateBinaryBackwards(long ip) {

         binaryBackwards += ip%2;
         long result = ip/2;

         if( result >0 ) calculateBinaryBackwards(result);
         return;
    }

    private static void setZero() {
        for (int i = binaryBackwards.length(); i < integerSize; i++  )
            binaryBackwards += "0";
        return;
    }

    private static String reverseOrder() {
        String str ="";
        for (int i = binaryBackwards.length()-1; i >=0; i-- )
            str += binaryBackwards.charAt(i);
        return str;
    }

    private static String calculateIPV4(String binary) {
        String ipv4 ="";
        int dot = 0;
        for ( int i=0 ; i<integerSize; i=i+8){
            int value = 0;
            String sub = binary.substring(i,i+8);
            for (int k=0; k<sub.length(); k++) {
                int valueOfStringAtIndex = Integer.parseInt(String.valueOf(sub.charAt(sub.length()-1-k)));
                value += (valueOfStringAtIndex * (int) Math.pow(2, k));

            }
            ipv4 += value;

            if (dot<3) {
                ipv4 += ".";
                dot++;
            }
        }

        return ipv4;
    }

}
