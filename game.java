import java.util.*;
import java.util.Random;

public class game {
    static String computerchoice(Random random) {
        int n;
        n = random.nextInt(3) + 1;
        String computerChoice = "";
        if (n == 1) {
            computerChoice = "rock";
        } else if (n == 2) {
            computerChoice = "paper";
        } else if (n == 3) {
            computerChoice = "scissors";
        }
        return computerChoice;
    }

    static void menu() {
        System.out.println("Options to choose from :\n1.Rock\n2.Paper\n3.Scissors");
    }

    static void round() {
        System.out.println("Options to choose from :\n1.One \n3.Three \n5.Five");
    }

    static int getUserChoice(Scanner ob) {

        int uchoice;
        System.out.print("\nEnter your choice :");
        uchoice = ob.nextInt();
        if (uchoice == 1 || uchoice == 2 || uchoice == 3) {
            return uchoice;
        } else {
            System.out.println("Invalid choice");
            uchoice = ob.nextInt();
            return uchoice;
        }
    }

    static String chooseWinner(String computerChoice, int userChoice) {
        String winner = "No Winner";
        String customMessage = "";
        String finalMessage = "";
        String user = "";
        if (userChoice == 1) {
            user = "rock";
        } else if (userChoice == 2) {
            user = "paper";
        } else if (userChoice == 3) {
            user = "scissors";
        }
        System.out.println("Computer chooses : " + computerChoice);
        System.out.println("User chooses : " + user);

        if (computerChoice.equals("rock") && userChoice == 2) {

            winner = "You";
            customMessage = "You win this round";
        } else if (userChoice == 1 && computerChoice.equals("paper")) {

            winner = "Computer";
            customMessage = "Bad choice ,computer win this round";
        }

        if (computerChoice.equals("scissors") && userChoice == 2) {

            winner = "Computer";
            customMessage = " Bad choice ,computer win this round";
        } else if (userChoice == 3 && computerChoice.equals("paper")) {

            winner = "You";
            customMessage = " Good choice ,you win this round";
        }

        if (computerChoice.equals("rock") && userChoice == 3) {

            winner = "Computer";
            customMessage = " Bad choice ,Computer win this round";
        } else if (userChoice == 1 && computerChoice.equals("scissors")) {

            winner = "You";
            customMessage = "Good choice ,you win this round";
        }

        finalMessage = winner + " won ( " + customMessage + " )";

        return finalMessage;
    }

    static void counting(int n, Random random, Scanner scanner) {
        int count = 0;
        int count1 = 0;
        String computer;
        int user;
        String winner;
        for (int i = 1; i <= n; i++) {
            menu();
            computer = computerchoice(random);
            user = getUserChoice(scanner);
            winner = chooseWinner(computer, user);
            if (n == 1) {
                System.out.println(winner);
            } else {
                if (winner.equals("Computer")) {
                    count++;
                } else if (winner.equals("You")) {
                    count1++;
                }
            }
        }
        if (count > count1) {
            System.out.println("Computer wins");
        } else if (count1 > count) {
            System.out.println("You wins");
        } else {
            if (n != 1) {
                System.out.println("DRAW");
            }
        }

    }

    public static void main(String args[]) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Rock Paper Scissor");
        System.out.println("How many round you want to play");
        round();
        int n = scanner.nextInt();

        if (n == 1 || n == 3 || n == 5) {
            counting(n, random, scanner);
        } else {
            System.out.println("Invalid choice");
            round();
            int a = scanner.nextInt();
            counting(n, random, scanner);

        }

    }
}
