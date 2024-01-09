
public class LargeBattleship extends Battleship {
	
	private static int allottedShips = 1;
	private static int shipSize = 3; 

	public LargeBattleship() {
		super(3);
	}
	

	public static int getAllottedShips() {
		return allottedShips;
	}

	public static int getShipSize() {
		return shipSize;
	}

	@Override
	public String toString() {
		return "Large Battleship:";
	}
	

}
