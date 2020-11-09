import java.util.Scanner;

class Main {
    public static void main(String[] args) {
       Mastermind game = new Mastermind(); 
       Scanner scan = new Scanner(System.in);  // Create a Scanner object
       System.out.println("Welcome to Mastermind!");
       //String userName = scan.nextLine();  // Read user input
       System.out.println("Generated " + game.answer);
       scan.close();
    }
}