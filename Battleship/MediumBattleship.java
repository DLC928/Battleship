
public class MediumBattleship extends Battleship {
	

	private static int allottedShips = 2;
	private static int shipSize = 2; 

	public MediumBattleship() {
		super(2);
	}
	

	public static int getAllottedShips() {
		return allottedShips;
	}

	public static int getShipSize() {
		return shipSize;
	}
	
	@Override
	public String toString() {
		return "Medium Battleship:";
	}

}
