
public class Player {

	private String name;
	private int score;
	private Board board;

	public Player(String name, Board board) {
		this.name = name.toUpperCase();
		this.board = board;
	}

	public boolean takeTurn(int row, int column) {

		Square square = this.board.getBoard()[row][column];
		
		//Check to see if the square has already been shot at 
		if (square.getShotFired()) {
	        System.out.println("YOU ALREADY FIRED AT THIS SQUARE. YOUR TURN IS SKIPPED.");
	        return false;
	    }

	    square.setShotFired(true);

	    if (square.getHasShip()) {
            Battleship battleship = square.getBattleship(); 
            if (battleship.isShipSunk()) {
                score++; // Increment the player's score for sinking a ship.
                System.out.println("YOU SUNK A " + battleship.getBattleshipType() + " SHIP!"); 
            } else {
                System.out.println("HIT!");
            }
        } else {
            System.out.println("MISSED!");
            System.out.println();
        }
	    System.out.println(this.getName() + "'S CURRENT SCORE: " + score);

	    return this.board.allShipsSunk(); // Will return true if all battleships have been sunk, else will return false. 

	}

	public String getName() {
		return this.name;
	}

	public int getScore() {
		return score;
	}

}
