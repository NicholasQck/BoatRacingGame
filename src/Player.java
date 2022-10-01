import java.util.Random;
import java.util.Scanner;

public class Player {
	//attributes
	private String name;
	private int turn;
	private int position;
	
	//constructors
	public Player() {
		
	}
	
	public Player(String n) {
		name = n;
		turn = 0;
	}

	//setter/getters
	public int getPosition() {
		return position;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String n) {
		this.name = n;
	}

	public int getTurn() {
		return turn;
	}
	
	public void setTurn(int turn) {
		this.turn = turn;
	}
	
	//move the players along the river
	public int move(int step) {
		if (step > (100 - position)) {
			int temp;
			temp = position + step;
			position = 100 - (temp % 100);
		}
		else if ((position + step) < 1) {
			position = 1;
		}
		else {
			position = position + step;
		}
		if (step != 0) {
			System.out.printf("%s is currently at position %d\n", name, position);
			System.out.println();
		}
		return position;
	}
	
	//roll the dice
	public int rollDice() {
		Scanner input = new Scanner(System.in);
		System.out.printf("It is %s's turn!\n",name);
		System.out.print("Press ENTER to roll the dice :)");
		input.nextLine();
		System.out.println();
		Random rand = new Random();
		int dice1 = 1 + rand.nextInt(6);
		int dice2 = 1 + rand.nextInt(6);
		int total = dice1 + dice2;
		System.out.printf("%s rolled: " + dice1 + " and " + dice2 + "\n", name);
		turn++;
		return total;
	}
	

	//toString
	public String toString() {
		return String.format("%-15s turns: %d", name, turn);
	}

	

	

	

}
