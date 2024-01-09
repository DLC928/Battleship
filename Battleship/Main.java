import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int rows = 10;
		int columns = 10;

		// Create the game board
		Board board = new Board(rows, columns);
		
		board.printShips(); 
		
		System.out.println("\nTIME TO PLAY BATTLESHIP!\n");

		// Input player names
		System.out.println("ENTER PLAYER 1:");
		String name1 = scanner.nextLine();
		System.out.println("ENTER PLAYER 2:");
		String name2 = scanner.nextLine();

		// Create players
		Player player1 = new Player(name1, board);
		Player player2 = new Player(name2, board);
		Player currentPlayer = player1;
		
		while (true) {
			
			System.out.println("\n" +currentPlayer.getName() + "'S TURN \n" );
			System.out.println("ENTER ROW:");
			int X = scanner.nextInt();
			System.out.println("ENTER COLUMN:");
			int Y = scanner.nextInt();

			if (currentPlayer.takeTurn(X, Y)) {
				System.out.println(board);
				break;
			}

			System.out.println(board);

			// Switch to the other player
			if (currentPlayer == player1) {
				currentPlayer = player2;
			} else if (currentPlayer == player2) {
				currentPlayer = player1;
			}

		}

		int player1Score = player1.getScore();
		int player2Score = player2.getScore();
		
		// Determine the winner

		if (player1Score > player2Score) {
			System.out.println(player1.getName() + " WON WITH A SCORE OF " + player1Score + "! \nGAME OVER!");
		} else if (player2Score > player1Score) {
			System.out.println(player2.getName() + " WON WITH A SCORE OF " + player2Score + "! \nGAME OVER!");
		} else {
			System.out.println("IT'S A DRAW! GAME OVER!");
		}

		scanner.close();
	}

}
