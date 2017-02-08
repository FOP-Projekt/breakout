package de.tudarmstadt.informatik.fop.breakout.test.adapter;

import java.util.LinkedList;
import java.util.List;

import de.tudarmstadt.informatik.fop.breakout.interfaces.IHighscoreEntry;

public class AdapterExtended extends Adapter {

  //TODO you probably should declare a highscore object of the "proper type" here...
	
	/**
	 * Use this constructor to set up everything you need.
	 */
	public AdapterExtended() {
		super();
	}
	
	/* *************************************************** 
	 * ********************** Highscore ******************
	 * *************************************************** */	
	
	public void addHighscore(String playerName, int numberOfDesBlocks, long elapesdTime) {
	  // TODO provide the proper mapping to your code here... 
	}	
	
	public void resetHighscore() {
    // TODO provide the proper mapping to your code here... 
	}		
	
	public List<? extends IHighscoreEntry> getHighscores() {
    // TODO provide the proper mapping to your code here...
	  return new LinkedList<IHighscoreEntry>();
	}
	
	public int getHighscoreCount() {
    // TODO provide the proper mapping to your code here...
	  return 0;
	}
	
	public String getNameAtHighscorePosition(int position) {
    // TODO provide the proper mapping to your code here...
	  return "Nobody";
	}
	
	public int getTimeElapsedAtHighscorePosition(int position) {
    // TODO provide the proper mapping to your code here...
	  return 60;
	}
	
	public int getNumberOfDesBlocksAtHighscorePosition(int position) {
    // TODO provide the proper mapping to your code here... 
	  return 1;
	}
	
}
