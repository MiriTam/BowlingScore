public class Tester {

/**
 * Static method used to test if the given BowlingScoreCalculator calculated
 * the correct score for a given Bowling game. The result of the test is
 * printed to the console.	
 * @param game
 * @param calc
 */
	public static void test(Game game, BowlingScoreCalculator calc) {
	 //Calculate score.
	 int score = calc.scoreGame(game);
	 //Print result.
	 System.out.print("Testing game " + game.getName() + ": Score should be " + game.getCorrectScore() + ", score is " + score);
		if (score == game.getCorrectScore()) {
			System.out.print(" => Passed \n");
		} else {
			System.out.print(" => Failed \n");
		}
	}
	
	
	public static void main(String[] args) {
	
	//Create new BowlingScoreCalculator.
	BowlingScoreCalculator calc = new BowlingScoreCalculator();
		
	//Create example games for testing.
	String[] resultsGame1 = {"X", "X", "X", "X", "X", "X", "X", "X", "X", "XXX"};
	Game game1 = new Game("1", 300, resultsGame1);
	
	String[] resultsGame2 = {"9-", "9-", "9-", "9-", "9-", "9-", "9-", "9-", "9-", "9-"};
	Game game2 = new Game("2", 90, resultsGame2);
	
	String[] resultsGame3 = {"5/", "5/", "5/", "5/", "5/", "5/", "5/", "5/", "5/", "5/5"};
	Game game3 = new Game("3", 150, resultsGame3);
	
	String[] resultsGame4 = {"53", "44", "12", "81", "52", "34", "31", "52", "71", "53"};
	Game game4 = new Game("4", 69, resultsGame4);
	
	String[] resultsGame5 = {"5/", "5/", "5/", "5/", "5/", "5/", "5/", "5/", "5/", "5/3"};
	Game game5 = new Game("5", 148, resultsGame5);
	
	//Run tests with example games.
    test(game1, calc);
    test(game2, calc);
    test(game3, calc);
    test(game4, calc);
    test(game5, calc);
 }
}
