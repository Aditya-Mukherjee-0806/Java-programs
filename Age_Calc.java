import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class Age_Calc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Date of Birth In DD/MM/YYYY : ");
        String DateOfBirth_given_by_user = sc.next();
        int dob = Integer.parseInt(DateOfBirth_given_by_user.substring(0, 2));
        int mob = Integer.parseInt(DateOfBirth_given_by_user.substring(3, 5));
        int yob = Integer.parseInt(DateOfBirth_given_by_user.substring(6, 10));
        LocalDate today = LocalDate.now();
        LocalDate Birthdate = LocalDate.of(yob, mob, dob);
        int years = Period.between(Birthdate, today).getYears();
        int months = Period.between(Birthdate, today).getMonths();
        int days = Period.between(Birthdate, today).getDays();
        System.out.println("Your age = " + years + " years " + months + " months " + days + " days");
    }
}
