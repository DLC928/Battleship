
public class SmallBattleship extends Battleship{

	private static int allottedShips = 3;
	
	public SmallBattleship() {
		super(1);
	}


	public static int getAllottedShips() {
		return allottedShips;
	}	
	
	@Override
	public String toString() {
		return "Small Battleship:";
	}

	


	
	

}
