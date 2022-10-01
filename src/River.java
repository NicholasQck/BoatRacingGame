import java.util.ArrayList;

public class River {
	//attributes
	private ArrayList<RiverObject> rlist = new ArrayList<RiverObject>();
	
	//constructors
	public River() {
		ArrayList<Integer> plist = new ArrayList<Integer>();
		for(int i = 0; i < 10; i++) {
			Trap tempTrap;
			if(i == 0) {
				tempTrap = new Trap();
			}
			else {
				tempTrap = new Trap(plist);
			}
			rlist.add(tempTrap);
			plist.add(tempTrap.getPosition());
			
			Current tempCurrent = new Current(plist);
			rlist.add(tempCurrent);
			plist.add(tempCurrent.getPosition());

		}
	}
	
	//print the river
	public void printRiver() {
		System.out.println("Displaying the river!\n");
		System.out.print("|");
		for(int i = 1; i <= 100; i++) {
			boolean found = false;
			for(RiverObject r: rlist) {
				if (r.getPosition() == i) {
					found = true;
					r.printSymbol();
					break;
				}
			}
			if (!found) {
				System.out.print(i + "|");
			}
		}
		System.out.println();
		System.out.println();
	}
	
	//check player position for traps or currents
	public int checkPosition(int pos) {
		for(RiverObject r: rlist) {
			if (r.getPosition() == pos) {
				if (r instanceof Current) {
					System.out.printf("You hit a current! Moving forwards %d spaces\n", r.getEffect());
				}
				else {
					System.out.printf("You hit a trap! Moving backwards %d spaces\n", (r.getEffect() * -1));
				}
			return r.getEffect();
			}
		}
		return 0;
	}

}
