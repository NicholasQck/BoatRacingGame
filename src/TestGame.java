import java.util.InputMismatchException;
import java.util.Scanner;

public class TestGame {

	public static void main(String[] args) {
		int option = 0;
		
		Scanner input = new Scanner(System.in);
		Game g1 = new Game();
		
		
			try {
				while (option != 2) {
					g1.printMenu();
					System.out.print("Your choice?: ");
					option = input.nextInt();
					if (option == 1) {
						g1.startGame();
					}
					else if (option == 2) {
						System.out.println("You have quit the game. Have a nice day!");
						break;
					}
					else {
						System.out.println("Invalid selection! Please try again");
					}
				}
			}
			catch(InputMismatchException e) {
				System.out.println("Incorrect input");
			}
			finally {
				System.out.println("The game has ended :)");
			}

	}

	

}
