import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Banking_Calculator {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of players : ");
        int n = sc.nextInt();
        ArrayList<String> players = new ArrayList<>();
        ArrayList<Integer> balance = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.print("Enter player " + (i + 1) + " : ");
            players.add(i, sc.next());
            balance.add(i, 25000);
        }
        System.out.println("Press C to check Balance");
        System.out.println("Press A to add money");
        System.out.println("Press S to subtract money");
        System.out.println("Press T to transfer money");
        char ch = 0;
        while (ch != 'x') {
            ch = sc.next().charAt(0);
            switch (ch) {
                case 'c', 'C':
                    checkBalance(players, balance);
                    break;
                case 'A', 'a':
                    System.out.print("Enter player : ");
                    String player = sc.next();
                    System.out.print("Enter amount : ");
                    int amount = sc.nextInt();
                    balance.set(players.indexOf(player), addBalance(players, balance, player, amount));
                    System.out.println("New balance of " + player + " = " + balance.get(players.indexOf(player)));
                    break;
                case 'S', 's':
                    System.out.print("Enter player : ");
                    player = sc.next();
                    System.out.print("Enter amount : ");
                    amount = sc.nextInt();
                    balance.set(players.indexOf(player), subBalance(players, balance, player, amount));
                    System.out.println("New balance of " + player + " = " + balance.get(players.indexOf(player)));
                    break;
                case 'T', 't':
                    System.out.print("Enter donor : ");
                    String donor = sc.next();
                    System.out.print("Enter receiver : ");
                    String receiver = sc.next();
                    System.out.print("Enter Amount : ");
                    amount = sc.nextInt();
                    balance = transferBalance(players, balance, donor, receiver, amount);
                    checkBalance(players, balance);
                    break;
                default:
                    System.out.println("Wrong input");
            }
        }
    }

    public static void checkBalance(ArrayList<String> players, ArrayList<Integer> balance) {

        HashMap<String, Integer> playerBalance = new HashMap<>();
        for (int i = 0; i < players.size(); i++) {
            playerBalance.put(players.get(i), balance.get(i));
        }
        System.out.println(playerBalance);
    }

    public static int addBalance(ArrayList<String> players, ArrayList<Integer> balance, String player, int amount) {
        balance.set(players.indexOf(player), balance.get(players.indexOf(player)) + amount);
        return balance.get(players.indexOf(player));
    }

    public static int subBalance(ArrayList<String> players, ArrayList<Integer> balance, String player, int amount) {
        balance.set(players.indexOf(player), balance.get(players.indexOf(player)) - amount);
        return balance.get(players.indexOf(player));
    }

    public static ArrayList<Integer> transferBalance
            (ArrayList<String> players, ArrayList<Integer> balance, String donor, String receiver, int amount) {
        balance.set(players.indexOf(receiver), balance.get(players.indexOf(receiver)) + amount);
        balance.set(players.indexOf(donor), balance.get(players.indexOf(donor)) - amount);
        return balance;
    }
}