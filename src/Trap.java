import java.util.ArrayList;
import java.util.Random;

public class Trap extends RiverObject {
	//constructor to create new trap
	public Trap() {
		Random rand = new Random();
		setPosition(1 + rand.nextInt(100));
		setEffect((1 + rand.nextInt(6)) * -1);
	}
	
	//constructor to create new trap and check position
	//to ensure trap cannot be in repeating position
	//or in position 1 or position 100
	public Trap(ArrayList<Integer> a) {
		Random rand = new Random();
		int tempPos = 1 + rand.nextInt(100);
		while (a.contains(tempPos) || tempPos == 1 || tempPos == 100) {
			tempPos = 1 + rand.nextInt(100);
		}
		setPosition(tempPos);
		setEffect((1 + rand.nextInt(6)) * -1);
	}
		
	//print trap symbol on river
	@Override
	public void printSymbol() {
		System.out.print("#|");
	}
	
}
