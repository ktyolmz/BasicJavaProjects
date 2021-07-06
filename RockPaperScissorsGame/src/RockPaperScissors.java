import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		String move;

		System.out.print("Welcome to Rock-Paper-Scissors Game!\n");

		do {

			System.out.println("Please enter your move.To quit the game please enter \"quit\".");
			move = input.next();

			if (!move.equalsIgnoreCase("quit")) {
				System.out.println("Game Initialising... 1, 2, 3 ...");
				System.out.println("Computer's move: " + computerMove());
				System.out.println(result(move, computerMove()));
			} else {
				System.out.println("Have a nice day...");
			}

		} while (!move.equalsIgnoreCase("quit"));
		
		input.close();
	}

	public static String computerMove() {
		Random random = new Random();
		int x = random.nextInt(3);
		String cm;

		if (x == 1) {
			cm = "Rock";
		} else if (x == 2) {
			cm = "Paper";
		} else {
			cm = "Scissors";
		}
		return cm;
	}

	public static String result(String userMove, String computerMove) {
		String r = "";
		if (userMove.equalsIgnoreCase("Rock") && computerMove.equalsIgnoreCase("Scissors")
				|| userMove.equalsIgnoreCase("Paper") && computerMove.equalsIgnoreCase("Rock")
				|| userMove.equalsIgnoreCase("Scissors") && computerMove.equalsIgnoreCase("Paper")) {
			r = "You Win! Congratulations!";
		} else if (userMove.equalsIgnoreCase(computerMove)) {
			r = "Draw. Try again";
		} else if (computerMove.equalsIgnoreCase("Rock") && userMove.equalsIgnoreCase("Scissors")
				|| computerMove.equalsIgnoreCase("Paper") && userMove.equalsIgnoreCase("Rock")
				|| computerMove.equalsIgnoreCase("Scissors") && userMove.equalsIgnoreCase("Paper")) {
			r = "You Lose. Try Again";
		}

		return r;
	}

}
