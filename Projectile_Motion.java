import java.text.DecimalFormat;
import java.util.Scanner;

import static java.lang.Math.*;

public class Projectile_Motion {
    static double g = 9.8;

    public static double[] default_components(double u, double angle_of_projection) {
        double[] dft_comps = new double[4];
        dft_comps[0] = u * cos(toRadians(angle_of_projection));
        dft_comps[1] = u * sin(toRadians(angle_of_projection));
        dft_comps[2] = 0;
        dft_comps[3] = g;
        return dft_comps;
    }

    public static double[] up_incline_components(double u, double angle_of_projection, double angle_of_inclination) {
        double[] up_inc_comps = new double[4];
        up_inc_comps[0] = u * cos(toRadians(angle_of_projection - angle_of_inclination)); // ux
        up_inc_comps[1] = u * sin(toRadians(angle_of_projection - angle_of_inclination)); // uy
        up_inc_comps[2] = -g * sin(toRadians(angle_of_inclination)); // ax
        up_inc_comps[3] = -g * cos(toRadians(angle_of_inclination)); // ay
        return up_inc_comps;
    }

    public static double[] down_incline_components(double u, double angle_of_projection, double angle_of_inclination) {
        double[] down_inc_comps = new double[4];
        down_inc_comps[0] = u * cos(toRadians(angle_of_projection + angle_of_inclination)); // ux
        down_inc_comps[1] = u * sin(toRadians(angle_of_projection + angle_of_inclination)); // uy
        down_inc_comps[2] = g * sin(toRadians(angle_of_inclination)); // ax
        down_inc_comps[3] = -g * cos(toRadians(angle_of_inclination)); // ay
        return down_inc_comps;
    }

    public static double time_of_flight(double uy, double ay) {
        return abs(-2 * uy / ay);
    }

    public static double max_height(double uy, double ay) {
        return abs(-pow(uy, 2) / (2 * ay));
    }

    public static double range(double ux, double ax, double time_of_flight) {
        return abs(ux * time_of_flight + 0.5 * ax * pow(time_of_flight, 2));
    }

    public static double horizontal_position(double ux, double ax, double time_from_launch) {
        return ux * time_from_launch + 0.5 * ax * pow(time_from_launch, 2);
    }

    public static double vertical_position(double uy, double ay, double time_from_launch) {
        return uy * time_from_launch + 0.5 * ay * pow(time_from_launch, 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.00");
        // data acceptance
        System.out.print("Enter Initial Velocity of Projectile : ");
        double u = sc.nextDouble();
        System.out.print("Enter Angle of Projection of Projectile from the Horizontal : ");
        double angle_of_projection = sc.nextDouble();
        double[] dft_comps = default_components(u, angle_of_projection);
        double ux = dft_comps[0];
        double uy = dft_comps[1];
        double ax = dft_comps[2];
        double ay = dft_comps[3];
        System.out.print("Enter Angle of Inclination of Plane from the Horizontal : ");
        double angle_of_inclination = sc.nextDouble();
        if (angle_of_inclination != 0) {
            System.out.print("Projectile moving Up or Down the Incline? : ");
            String incline = sc.next();
            switch (incline) {
                case "up", "UP", "Up", "uP" -> {
                    double[] up_inc_comps = up_incline_components(u, angle_of_projection, angle_of_inclination);
                    ux = up_inc_comps[0];
                    uy = up_inc_comps[1];
                    ax = up_inc_comps[2];
                    ay = up_inc_comps[3];
                }
                case "down", "DOWN", "Down" -> {
                    double[] down_inc_comps = down_incline_components(u, angle_of_projection, angle_of_inclination);
                    ux = down_inc_comps[0];
                    uy = down_inc_comps[1];
                    ax = down_inc_comps[2];
                    ay = down_inc_comps[3];
                }
                default -> System.out.println("Wrong Input! Please enter up or down");
            }
        }
        // data display
        System.out.println();
        System.out.println("Press t to calculate time of flight");
        System.out.println("Press h to calculate maximum height");
        System.out.println("Press r to calculate range");
        System.out.println("Press p to calculate position of projectile after certain time");
        System.out.println("Press s to terminate the program");
        System.out.println("You can calculate different values continuously by pressing the required keys");
        while (true) {
            System.out.print("Enter choice : ");
            String ch = sc.next();
            System.out.println();
            switch (ch) {
                case "t" -> System.out.println("Time of Flight = " + df.format(time_of_flight(uy, ay)));
                case "h" -> System.out.println("Maximum Height = " + df.format(max_height(uy, ay)));
                case "r" -> System.out.println("Range = " + df.format(range(ux, ax, time_of_flight(uy, ay))));
                case "p" -> {
                    System.out.print("Enter time spent since projection : ");
                    double t = sc.nextDouble();
                    System.out.println("Horizontal Displacement from origin = " + horizontal_position(ux, ax, t));
                    System.out.println("Vertical Displacement from origin = " + vertical_position(uy, ay, t));
                }
            }
            if (ch.equals("s"))
                break;
        }
    }
}