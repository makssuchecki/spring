public class Armstrong {
    public static boolean isArmstrong(int n) {
        int len = 0;
        for (int i = n; i>0; i/=10){
            len++;
        }
        int total = 0;

       for (int i = n; i>0; i/=10){
            total += (int) Math.pow(i % 10, len);
        }
        return total == n;
    }

    public static void main(String[] args) {
        System.out.println(isArmstrong(10));
        System.out.println(isArmstrong(9));
        System.out.println(isArmstrong(153));
    }
}