public class BowlingScoreCalculator {
	
	 //Indicates that the previous round was a spare.
	 private boolean wasSpare = false; 
	 //Indicates that the previous round was a strike.
	 private boolean wasStrike = false;
	 //Indicates that the round before the previous round was a strike.
	 private boolean oldStrike = false;

	 
/**
 * Method scores an entire game consisting of a set of frames.	 
 * @param game
 * @return
 */
	public int scoreGame(Game game) {
	 wasSpare = false;
	 wasStrike = false;
	 int totalScore = 0;
	 String[] results = game.getGameResults();
	 
	 //Get score for each frame except the last.
	 for (int i = 0; i < results.length - 1; i++) {
		 totalScore += getScoreForTurn(results[i]);
	 }
	 
	 //If the final frame consists of three characters instead of two
	 //it needs custom treatment.
	 if (results[results.length-1].length() == 2) totalScore += getScoreForTurn(results[results.length-1]);
	 else {
	  String[] temp = results[results.length-1].split("");
	  
	  //If the first throw is a strike, we process this throw separately from the rest of the frame. 
	  if (temp[0].equals("X")) {
		  totalScore += scoreStrike();
		  wasStrike = false;
		  //If the second throw is a strike, we process this throw separately from the rest of the frame.
		  if (temp[1].equals("X")) {
			  totalScore += scoreStrike();
			  wasStrike = false;
			  totalScore += getScoreForTurn(temp[2] + "-");
		  } else {
			  totalScore += getScoreForTurn(temp[1] + temp[2]);
		  }

	  } else {
		//If the first throw is not a strike, then the first two throws must be a spare.
		  totalScore += scoreSpare(temp[0] + temp[1]);
		  wasSpare = false;
		  wasStrike = false;
		  totalScore += getScoreForTurn(temp[2] + "-");
	  }
	 }
	 return totalScore;
	}
	
	
	
/**
 * Method takes a frame from the bowling game and calculates it's score.	
 * @param frame
 * @return
 */
	private int getScoreForTurn(String frame) {
	 int score = 0;
	 //Frame is a spare 
	 if (frame.contains("/")) {
		 score += scoreSpare(frame);	  
	 //Frame is a strike
	 } else if (frame.contains("X")) {
	     score += scoreStrike();
	 //Frame is other
	 } else {
	   score += scoreOther(frame);
	 } 
	 return score;
	}
	
	
/**
 * Method returns the score of a frame containing spare.
 * @param spareFrame
 * @return
 */
	private int scoreSpare(String spareFrame) {
	 int score = 10;  
	 if (wasStrike) score += 10;
	 if (wasSpare) {
		 //Find value of first throw.
		 try {score += Integer.parseInt(spareFrame.split("")[0]);} catch (NumberFormatException e) {}			
		}
			  
	 wasSpare = true;
	 wasStrike = false;
	 return score;	  
    }
	
	
/**
 * Method returns score for a frame containing strike.	
 * @param strikeFrame
 * @return
 */
	private int scoreStrike() {
	 int score = 10;	  
	 if (wasSpare) score += 10;
	 if (oldStrike) score += 10;
   	 if (wasStrike) {
   		 score += 10;
		 oldStrike = true;
	     } else {
		  oldStrike = false;
		}
			  
	 wasStrike = true;
	 wasSpare = false;
	 
	 return score;
	}
	
	
/**
 * Method returns the score of a given frame which doesn't contain spare or strike.
 * @param frame
 * @return
 */
	private int scoreOther(String frame) {
	 String[] temp = frame.split("");
	 int firstInt = 0;
	 int secondInt = 0;
			  
	 //Find results for each throw.
	 try {firstInt = Integer.parseInt(temp[0]);} catch (NumberFormatException e) {}
	 try {secondInt = Integer.parseInt(temp[1]);} catch (NumberFormatException e) {}
			  
	 //Update score.
	 int score = firstInt + secondInt;
	 if (wasSpare) score += firstInt;
	 if (wasStrike) score += score;
			 
	 wasSpare = false;
	 wasStrike = false;
	 
	 return score;
	}

}
