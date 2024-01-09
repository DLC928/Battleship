
import java.util.Random;

public class Board {

	private int rows;
	private int columns;
	private Square[][] board;
	private Random random = new Random();

	public Board(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		this.board = new Square[rows][columns];
		createBoard();
		createBattleships();
	}

	public void createBoard() {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				this.board[i][j] = new Square(i, j);
			}
		}
	}
	
	public void createSmallBattleship() {
		int shipsCreated = 0;
		while (shipsCreated < SmallBattleship.getAllottedShips()) {
			int row = getRandomRow();
            int column = getRandomColumn();
            // Check if the square does not already have a ship.
			if (!board[row][column].getHasShip()) { 				
				SmallBattleship battleship = new SmallBattleship();
				board[row][column].setHasShip(true); // Mark the square as having a ship.
				board[row][column].setBattleship(battleship); // Set the battleship on the square.
				shipsCreated++;
			}
		}
	}

	public void createMediumBattleship() {
		int shipsCreated = 0;
		while (shipsCreated < MediumBattleship.getAllottedShips()) {
			int row = getRandomRow();
            int column = getRandomColumn();
            boolean vertical = getRandomBoolean();
  
			if (canPlaceShip(row, column, MediumBattleship.getShipSize(), vertical)) {
				MediumBattleship battleship = new MediumBattleship(); 
				placeShip(row, column, MediumBattleship.getShipSize(), vertical, battleship); 
				shipsCreated++;
			}
		}
	}

	public void createLargeBattleship() {
		int shipsCreated = 0;
		while (shipsCreated < LargeBattleship.getAllottedShips()) {
			int row = getRandomRow();
            int column = getRandomColumn();
            boolean vertical = getRandomBoolean();
           
			if (canPlaceShip(row, column, LargeBattleship.getShipSize(), vertical)) {
				LargeBattleship battleship = new LargeBattleship();	
				placeShip(row, column, LargeBattleship.getShipSize(), vertical, battleship); 
				shipsCreated++;
			}
		}
	}
	
	public boolean canPlaceShip(int row, int column, int shipSize, boolean vertical) {
		// Check if the ship can be placed vertically within the bounds of the board
		if (vertical) {
			if (row + shipSize <= rows) {
				// Check each square for ship overlap
				for (int i = 0; i < shipSize; i++) {
					if (board[row + i][column].getHasShip()) {
						return false; // Ship overlap found
					}
				}
				return true; // Ship can be placed
			}
		} else {
			// Horizontal check 
			if (column + shipSize <= columns) {
				for (int i = 0; i < shipSize; i++) {
					if (board[row][column + i].getHasShip()) {
						return false; 
					}
				}
				return true; 
			}
		}
		return false; // Ship would go out of bounds or overlap other ships
	}

	private void placeShip(int row, int column, int shipSize, boolean vertical, Battleship battleship) {
		// If vertical, mark the ship and adjacent squares vertically based on the ship's size
		if (vertical) {
			for (int j = 0; j <= shipSize - 1; j++) {
				board[row + j][column].setHasShip(true);
				board[row + j][column].setBattleship(battleship);
			}
		// If horizontal, mark the ship and adjacent squares horizontally based on the ship's size
		} else {
			for (int j = 0; j <= shipSize - 1; j++) {
				board[row][column + j].setHasShip(true);
				board[row][column + j].setBattleship(battleship);
			}
		}
	}
	
	 // Method to generate a random row for square
    private int getRandomRow() {
        return random.nextInt(rows-1);
    }
    // Method to generate a random column for square 
    private int getRandomColumn() {
        return random.nextInt(columns-1);
    }
    // Method to generate a random boolean (true for vertical, false for horizontal)
    private boolean getRandomBoolean() {
        return random.nextBoolean();
    }

	public void createBattleships() {
		createSmallBattleship();
		createMediumBattleship();
		createLargeBattleship();
	}

	public Square[][] getBoard() {
		return this.board;
	}

	public boolean allShipsSunk() {
		// Loop through each square on the board.
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				
				// Get the battleship on the current square.
				Battleship battleship = this.board[i][j].getBattleship();
			
				 // Check if the square has a ship and if that ship is not yet sunk.
				if (this.board[i][j].getHasShip() && !battleship.isShipSunk()) {
					return false; // If any unsunk ship is found, return false.
				}
			}
		}
		return true; 
	}

	//The below method is for testing purposes to easily see where each ship has been placed. 
	public void printShips() {

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (this.board[i][j].getHasShip()) {
					Battleship battleship = this.board[i][j].getBattleship();
					System.out.println("BATTLESHIP Type: " + battleship.getBattleshipType() + " at " + i + ", " + j);
					System.out.println("IS SHIP SUNK?: " + battleship.isShipSunk());
					System.out.println("SHIP HEALTH: " + battleship.getHealth());
					System.out.println();
				}
			}
		}
	}
	
	@Override
	public String toString() {

		String result = "";
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				result += board[i][j].toString();
			}
			result += "\n";
		}
		return result;
	}
}
