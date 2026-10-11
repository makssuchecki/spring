public class Armstrong {
    public static boolean isArmstrong(int n) {
        String s = Integer.toString(n);
        int len = s.length();
        int total = 0;
        for (int i = 0; i < len; i++) {
            int digit = s.charAt(i) - '0';
            total += (int) Math.pow(digit, len);
        }
        return n == total;
    }

    public static void main(String[] args) {
        System.out.println(isArmstrong(10));
        System.out.println(isArmstrong(153));
    }
}