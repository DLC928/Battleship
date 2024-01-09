
public class Battleship {

	private boolean shipSunk;
	private int healthLevel;
	private int size;

	public Battleship(int size) {
		this.healthLevel = size;
		this.size = size;
	}

	public void reduceHealth() {
		this.healthLevel --;
	
	}
	
	public int getHealth() {
		return this.healthLevel;
	}

	public boolean isShipSunk() {
		if (this.healthLevel == 0) {
			return true;
		}
		
		return false;
	}
	
	  public String getBattleshipType() {
	        if (this instanceof SmallBattleship) {
	            return "SMALL";
	        } else if (this instanceof MediumBattleship) {
	            return "MEDIUM";
	        } else if (this instanceof LargeBattleship) {
	            return "LARGE";
	        } else {
	            return "Unknown";
	        }
	    }

	@Override
	public String toString() {
		return "Battleship:";
	}

	

}
