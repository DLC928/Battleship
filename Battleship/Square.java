
public class Square {

	private int row;
	private int column;
	private boolean hasShip;
	private Battleship battleship;
	private boolean shotFired;

	public Square(int row, int column) {
		this.row = row;
		this.column = column;
		this.hasShip = false;
	}

	public int getRow() {
		return row;
	}
	
	public int getColumn() {
		return column;
	}
	
	public boolean getHasShip() {

		if (this.battleship == null) {
			return false;
		}
		return true;
	}

	public boolean getShotFired() {
		return shotFired;
	}

	public Battleship getBattleship() {
		return battleship;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public void setHasShip(boolean hasShip) {
		this.hasShip = hasShip;
	}

	public void setShotFired(boolean shotFired) {

		if (hasShip) {
			battleship.reduceHealth();
		}
		this.shotFired = shotFired;
	}

	public void setBattleship(Battleship battleship) {
		this.battleship = battleship;
	}

	@Override
	public String toString() {

		if (getHasShip() && getShotFired() == true) {
			return String.format("%3s", "X"); // Square has a ship and was hit.
		} else if (getShotFired() == true && getHasShip() == false) {
			return String.format("%3s", "O"); // Square was shot at and missed.
		}

		return String.format("%3s", "-"); // Square has not been shot at.
	}

}
