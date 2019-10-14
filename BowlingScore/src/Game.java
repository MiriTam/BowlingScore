//An object of class Game represents one round of bowling.
public class Game {

	int score; //Score achieved in game.
	String[] results; //Pins knocked down in each frame.
	String name; //Name of game.
	
	public Game(String name, int score, String[] results) {
		this.name = name;
		this.score = score;
		this.results = results;
	}
	
/**
 * Method returns the score achieved in the game.	
 * @return
 */
	public int getCorrectScore() {
		return score;
	}
	
/**
 * Method returns an array with the results for each turn in the game.	
 * @return
 */
	public String[] getGameResults() {
		return results;
	}
	
/**
 * Method returns the name of the game.	
 * @return
 */
	public String getName() {
		return name;
	}
	
}
