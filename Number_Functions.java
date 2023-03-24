import java.util.Scanner;

public class Number_Functions {
    public static boolean isPrime(int num) {
        int c = 0;
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0)
                c++;
        }
        return c == 0;
    }

    public static int getDigitCount(int num) {
        int c = 0;
        while (num != 0) {
            c++;
            num /= 10;
        }
        return c;
    }

    public static int getFactorial(int num) {
        int f = 1;
        for (int i = 1; i <= num; i++) {
            f *= i;
        }
        return f;
    }

    public static int getReverse(int num) {
        int rev = 0;
        while (num > 0) {
            rev = rev * 10 + num % 10;
            num /= 10;
        }
        return rev;
    }

    public static int getDigitSum(int num) {
        int s = 0;
        while (num > 0) {
            s += num % 10;
            num /= 10;
        }
        return s;
    }

    public static int getDigitProduct(int num) {
        int p = 1;
        while (num > 0) {
            p *= num % 10;
            num /= 10;
        }
        return p;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int n = sc.nextInt();
        System.out.println("Is " + n + " prime? :" + isPrime(n));
        System.out.println("Number of digits in " + n + " is = " + getDigitCount(n));
        System.out.println("Factorial of " + n + " is = " + getFactorial(n));
        System.out.println("Reverse  of " + n + " is = " + getReverse(n));
        System.out.println("Sum of digits of " + n + " is = " + getDigitSum(n));
        System.out.println("Product of digits of " + n + " is = " + getDigitProduct(n));
    }
}
