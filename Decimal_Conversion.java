import java.util.Scanner;

public class Decimal_Conversion {
    public static String toBinary(int num) {
        StringBuilder bin = new StringBuilder();
        while (num > 0) {
            int rem = num % 2;
            bin.insert(0, rem); // bin = rem + bin
            num = num / 2;
        }
        return bin.toString();
    }

    public static String toOctal(int num) {
        StringBuilder oct = new StringBuilder();
        while (num > 0) {
            int rem = num % 8;
            oct.insert(0, rem); // oct = rem + oct
            num = num / 8;
        }
        return oct.toString();
    }

    public static String toHexadecimal(int num) {
        StringBuilder hex = new StringBuilder();
        char[] hex_characters = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E'};
        while (num > 0) {
            int rem = num % 16;
            hex.insert(0, hex_characters[rem]); // hex = hex_char[rem] + hex
            num = num / 16;
        }
        return hex.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a Decimal Number : ");
        int n = sc.nextInt();
        System.out.print("Press B for Binary Conversion\nPress O for Octal Conversion\nPress H for Hexadecimal Conversion :");
        char ch = sc.next().charAt(0);
        switch (ch) {
            case 'B', 'b' -> System.out.println(n + " in Binary = " + toBinary(n));
            case 'O', 'o' -> System.out.println(n + " in Octal = " + toOctal(n));
            case 'H', 'h' -> System.out.println(n + " in Hexadecimal = " + toHexadecimal(n));
            default -> System.out.println("Wrong Input!");
        }
    }
}
