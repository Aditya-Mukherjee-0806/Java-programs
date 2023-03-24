import java.util.Scanner;

public class LCM_Calculator {
    public static int LCM_calc(int n1, int n2) {
        int lcm = 0;
        for (int i = n1; i <= n1 * n2; i++) {
            if (i % n1 == 0 && i % n2 == 0) {
                lcm = i;
                break;
            }
        }
        return lcm;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number : ");
        int n1 = sc.nextInt();
        System.out.print("Enter second number : ");
        int n2 = sc.nextInt();
        System.out.println("LCM of " + n1 + " and " + n2 + " = " + LCM_calc(n1, n2));
    }
}
