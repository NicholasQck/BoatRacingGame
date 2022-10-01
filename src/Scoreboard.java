import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Formatter;
import java.util.Scanner;

public class Scoreboard {
	//attributes
	private Scanner sinput;
	private Formatter soutput;
	private ArrayList<Player> players = new ArrayList<Player>();
	
	//display scoreboard
	public void displayScoreboard() {
		System.out.println("========Scoreboard========");
		System.out.println("NAME            TURNS");
		readScoreFile("Scoreboard.txt");
		System.out.println();
	}
	
	//update scoreboard
	public void updateScoreboard(Player p) {
		checkWinner(p);
		writeScoreFile("Scoreboard.txt");
		displayScoreboard();
	}
	

	
	//read from file
	public void readScoreFile(String filename) {
		try {
			sinput = new Scanner(new File(filename));
			
			while (sinput.hasNext()) {
				Player player = new Player();
				player.setName(sinput.next());
				player.setTurn(sinput.nextInt());
				
				players.add(player);
				System.out.println(player);
			}
		}
		catch(FileNotFoundException fileNotFoundException) {
			System.out.println("No record found");
		}
		if (sinput != null) {
			sinput.close();	
		}
	}
	
	//write to file
	public void writeScoreFile(String filename) {
		try {
			soutput = new Formatter(new File(filename));
			
			for(int i = 0; i < players.size(); i++) {
				soutput.format("%s %d\n", players.get(i).getName(), players.get(i).getTurn());
			}
		}
		catch(FileNotFoundException fileNotFoundException) {
			System.out.println("Error opening file");
		}
		if (soutput != null) {
			soutput.close();
		}
	}
	
	//check if player made the scoreboard
	public void checkWinner(Player p) {
		players.add(p);
		for(int i = 0; i < players.size(); i++) {
			for (int j = i + 1; j < players.size(); j++) {
				if (players.get(i).getTurn() > players.get(j).getTurn()) {
					Collections.swap(players, i, j);
				}
			}
		}
		
		if (players.size() > 5) {
			players.remove(5);
		}
	}
}
