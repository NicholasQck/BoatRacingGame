import java.util.Scanner;

public class Game {
	//attributes
	private Player p1;
	private Player p2;
	private River river;
	private Scoreboard score;
	
	//starting the game
	public void startGame() {
		river = new River();
		score = new Scoreboard();
		
		score.displayScoreboard();
		
		String name1;
		String name2;
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter player 1 name (one word only!!!): ");
		name1 = input.next();
		System.out.print("Enter player 2 name (one word only!!!): ");
		name2 = input.next();
		
		p1 = new Player(name1);
		p2 = new Player(name2);
		
		river.printRiver();
		
		score.updateScoreboard(play());
	}
	
	// each player plays
	public Player play() {
		boolean finish = false;
		while (!finish) {
			// player 1 turn
			int tempPos1;
			int effect1;
			int bug1 = 0;
			tempPos1 = p1.move(p1.rollDice());
			do {
				effect1 = river.checkPosition(tempPos1);
				tempPos1 = p1.move(effect1);
				bug1++;
			} while (effect1 != 0 && bug1 <= 10);

			if (bug1 > 10) {
				System.out.println("Caught in trap and current too many times! Ending turn...");
			}

			if (p1.getPosition() == 100) {
				finish = true;
				break;
			}

			// player 2 turn
			int tempPos2;
			int effect2;
			int bug2 = 0;
			tempPos2 = p2.move(p2.rollDice());
			do {
				effect2 = river.checkPosition(tempPos2);
				tempPos2 = p2.move(effect2);
				bug2++;
			} while (effect2 != 0 && bug2 <= 10);

			if (bug2 > 10) {
				System.out.println("Caught in trap and current too many times! Ending turn...");
			}

			if (p2.getPosition() == 100) {
				finish = true;
				break;
			}
		}

		if (p1.getPosition() == 100) {
			System.out.printf("Congratulations! %s has won the game with only %d turns!\n\n", p1.getName(),
					p1.getTurn());
			return p1;
		} else {
			System.out.printf("Congratulations! %s has won the game with only %d turns!\n\n", p2.getName(),
					p2.getTurn());
			return p2;
		}
	}
	
	//print out selection menu
	public void printMenu() {
		System.out.println("MENU");
		System.out.println("-Enter '1' to start playing the game");
		System.out.println("-Enter '2' to quit the game");
	}
	

}
