import java.util.HashMap;
import java.util.Scanner;

public class RomanToInteger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Roman Number : ");
        String roman = sc.next();
        System.out.println("Integer Equivalent of " + roman.toUpperCase() + " = " + roman_to_int_converter(roman));
    }

    public static int roman_to_int_converter(String roman) {
        roman = roman.toUpperCase();
        HashMap<Character, Integer> conv = new HashMap<>();
        conv.put('I', 1);
        conv.put('V', 5);
        conv.put('X', 10);
        conv.put('L', 50);
        conv.put('C', 100);
        conv.put('D', 500);
        conv.put('M', 1000);
        int inteqv = 0;
        for (int i = 0; i < roman.length() - 1; i++) {
            if (conv.get(roman.charAt(i)) >= conv.get(roman.charAt(i + 1)))
                inteqv += conv.get(roman.charAt(i));
            else
                inteqv -= conv.get(roman.charAt(i));
        }
        inteqv += conv.get(roman.charAt(roman.length() - 1));
        return inteqv;
    }
}
