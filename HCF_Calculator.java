import java.util.*;

public class HCF_Calculator {
    public static int HCF_calc(int n1, int n2) {
        int p = 0;
        int[] a = new int[n1];

        for (int i = 1; i <= n1; i++) {
            if (n1 % i == 0) {
                a[p] = i;
                p++;
            }
        }
        int q = 0;
        int[] b = new int[n2];
        for (int i = 1; i <= n2; i++) {
            if (n2 % i == 0) {
                b[q] = i;
                q++;
            }
        }
        int HCF = 0;
        for (int i = 0; i < p; i++) {
            int k = a[i];
            for (int j = 0; j < q; j++) {
                if (k == b[j])
                    HCF = k;
            }
        }
        return HCF;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number : ");
        int n1 = sc.nextInt();
        System.out.print("Enter second number : ");
        int n2 = sc.nextInt();
        System.out.println("HCF of " + n1 + " and " + n2 + " = " + HCF_calc(n1, n2));
    }
}
