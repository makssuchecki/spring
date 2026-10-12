public class Fourth {
    public static void Pattern(int n){
        for (int i = 0; i < n; i++){
            for (int j = 0; j <= i; j++){
                System.out.print("x");
            }
            System.out.print('\n');
        }

        for (int i = n; i > 0; i--){
            for (int j = 0; j < i; j++){
                System.out.print("x");
            }
            System.out.print('\n');
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < n - i; k++) {
                System.out.print("x");
            }
            System.out.print('\n');
        }

        for (int i = 0; i < n; i++){
            for (int j = n-1; j > i; j--){
                System.out.print(" ");
            }
            for (int k = n; k > n-i-1; k--){
                System.out.print("x");
            }
            System.out.print('\n');
        }
    }
    public static void main(String[] args){
        Pattern(3);
    }
}
