import java.util.Scanner;

public class TicTacToe {

	public static void printBoard(String[][] board) {
		System.out.println("-------------");
		for (int i = 0; i < 3; i++) {
			System.out.print("| ");
			for (int j = 0; j < 3; j++) {

				System.out.print(board[i][j] + " | ");

			}
			System.out.println();
			System.out.println("-------------");
			
		}
		System.out.println();
	}

	public static boolean checkValidInput(int row, int col, String[][] board) {

		if (row < 0 || row > 2) {

			return false;
		} else if (col < 0 || col > 2) {

			return false;
		} else if (board[row][col] != " ") {

			return false;
		} else {
			return true;
		}

	}

	public static void makeMove(String player, String[][] board) {
		Scanner input = new Scanner(System.in);
		int row = 0, col = 0;

		System.out.println("Enter a row (0-2): ");
		row = input.nextInt();
		System.out.println("Enter a column (0-2): ");
		col = input.nextInt();

		if (checkValidInput(row, col, board)) {
			if (player.equals("X")) {
				board[row][col] = "X";
			} else if (player.equals("O")) {
				board[row][col] = "O";

			}

		} else {
			System.out.println("Invalid Input!! \nNext player's turn");
			System.out.println();
		}

	}

	public static boolean checkRow(String[][] board) {

		for (int i = 0; i < 3; i++) {
			if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != " ") {
				return true;
			}
		}

		return false;

	}

	public static boolean checkCol(String[][] board) {

		for (int i = 0; i < 3; i++) {
			if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != " ") {
				return true;
			}
		}

		return false;
	}

	public static boolean checkCross(String[][] board) {

		if ((board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != " ")
				|| (board[2][0] == board[1][1] && board[1][1] == board[0][2] && board[2][0] != " ")) {
			return true;
		}

		return false;
	}

	public static boolean checkWinning(String[][] board) {
		if (checkRow(board) || checkCol(board) || checkCross(board)) {
			System.out.println("Congratulations!! You Win!!");
			return true;
		}
		return false;
	}

	public static void main(String[] args) {

		String[][] board = new String[3][3];

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = " ";
			}
		}
		int i = 0;

		System.out.println("Welcome to Tic-Tac-Toe");
		System.out.println();
		printBoard(board);

		while (i < 9 && checkWinning(board) != true) {
			if (i % 2 == 0) {
				System.out.println("Player 'X' turn, Please make a move: ");
				makeMove("X", board);
				checkWinning(board);
				printBoard(board);
			} else if (i % 2 != 0) {
				System.out.println("Player 'O' turn, Please make a move: ");
				makeMove("O", board);
				checkWinning(board);
				printBoard(board);
			}

			i++;
		}

	}

}