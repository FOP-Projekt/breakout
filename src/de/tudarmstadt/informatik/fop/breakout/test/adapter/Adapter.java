package de.tudarmstadt.informatik.fop.breakout.test.adapter;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import de.tudarmstadt.informatik.fop.breakout.constants.GameParameters;
import de.tudarmstadt.informatik.fop.breakout.interfaces.IHitable;
import de.tudarmstadt.informatik.fop.breakout.ui.Breakout;
import eea.engine.entity.Entity;
import eea.engine.entity.StateBasedEntityManager;
import eea.engine.test.TestAppGameContainer;

public class Adapter implements GameParameters {

  /*
   * the instance of our game, extends StateBasedGame
   */
	Breakout breakout;
	
	/**
	 * The TestAppGameContainer for running the tests
	 */
	TestAppGameContainer app;

  //TODO you should declare the additional attributes you may require here.

	/**
	 * Use this constructor to initialize everything you need.
	 */
	public Adapter() {
		breakout = null;
	}

	/* ***************************************************
	 * ********* initialize, run, stop the game **********
	 * ***************************************************
	 * 
	 * You can normally leave this code as it is.
	 */

	public StateBasedGame getStateBasedGame() {
		return breakout;
	}

	/**
	 * Diese Methode initialisiert das Spiel im Debug-Modus, d.h. es wird ein
	 * AppGameContainer gestartet, der keine Fenster erzeugt und aktualisiert.
	 * 
	 * Sie müssen diese Methode erweitern
	 */
	public void initializeGame() {

    // Set the library path depending on the operating system
    if (System.getProperty("os.name").toLowerCase().contains("windows")) {
      System.setProperty("org.lwjgl.librarypath",
          System.getProperty("user.dir") + "/native/windows");
    } else if (System.getProperty("os.name").toLowerCase().contains("mac")) {
      System.setProperty("org.lwjgl.librarypath",
          System.getProperty("user.dir") + "/native/macosx");
    } else {
      System.setProperty("org.lwjgl.librarypath",
          System.getProperty("user.dir") + "/native/"
              + System.getProperty("os.name").toLowerCase());
    }

    // Initialize the game in debug mode (no GUI output)
		breakout = new Breakout(true);

		try {
			app = new TestAppGameContainer(breakout);
			app.start(0);
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Stop a running game
	 */
	public void stopGame() {
		if (app != null) {
			app.exit();
			app.destroy();
		}
		StateBasedEntityManager.getInstance().clearAllStates();
		breakout = null;
	}

	public void changeToGameplayState() {
		this.getStateBasedGame().enterState(GAMEPLAY_STATE);
		try {
			app.updateGame(1);
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

	public void changeToHighScoreState() {
		this.getStateBasedGame().enterState(HIGHSCORE_STATE);
		try {
			app.updateGame(1);
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

	/* ***************************************************
	 * ********************** Ball **********************
	 * ***************************************************
	 */
	public Entity createBallInstance(String ballID) {
	  //TODO write code that returns a ball instance with ID 'ballID'
	  return null;
	}

	public IHitable createBlockInstance(String blockID, int hitsUntilDestroyed) {
	  //TODO write code that returns a block instance with ID 'blockID'
	  // and that requires hitsUntilDestroyed "hits" until it vanishes
	  return null;
	}

	public void setRotation(int i) {
	  //TODO write code sets the ball rotation to the value passed in
	}

	public float getRotation() {
    //TODO write code retrieves the ball's rotation
	  return 0.0f; // this is only a dummy value to prevent compilation problems!
	}

	public void setPosition(Vector2f vector2f) {
	  //TODO provide code that sets the position of the ball to the coordinates passed in
	}

	public Vector2f getSize() {
	  //TODO write code that retrieves the size of the ball
	  return new Vector2f(25, 25);
	}

	public float getSpeed() {
    //TODO write code to retrieve the ball speed
	  return 1.0f;
	}

	public void setSpeed(float speed) {
    //TODO write code to set the ball speed
	}

	public boolean collides(Entity otherEntity) {
	  //TODO write code to test if the ball collides with 'otherEntity'
	  return false;
	}

	/* ***************************************************
	 * ********************** Player *********************
	 * ***************************************************
	 */
	public void addLives(int value) {
	  //TODO write code to add the given number to the player's lives
	}

	public void setLives(int playerLives) {
	  //TODO write code to set the number of player's lives to playerLives
	}

	public int getLivesLeft() {
	  //TODO write code to retrieve the number of lives left
	  return 1;
	}

	public boolean hasLivesLeft() {
	  //TODO write code to test if the player has at least one live left
	  return true;
	}

	/* ***************************************************
	 * ********************** Block **********************
	 * ***************************************************
	 */

	/**
	 * Sets a number of necessary hits for degrading this block
	 * 
	 * @param hitsLeft
	 *            number of necessary hits
	 * @param blockID
	 *            blockID ID of the chosen block
	 */
	public void setHitsLeft(int hitsLeft, String blockID) {
	  //TODO write code to set the number of required hits for 'blockID' to hitsLeft
	}

	/**
	 * Returns the number of necessary hits for degrading this block
	 * 
	 * @param blockID
	 *            ID of the chosen block
	 * @return number of hits
	 */
	public int getHitsLeft(String blockID) {
	  //TODO write code to return how many hits 'blockID' needs to vanish
	  return 1;
	}

	/**
	 * Adds a number of necessary hits for degrading this block
	 * 
	 * @param hitsLeft
	 *            number of hits added
	 * @param blockID
	 *            blockID ID of the chosen block
	 */
	public void addHitsLeft(int hitsLeft, String blockID) {
    //TODO write code to add the given number to the block's "hit capacity"
	}

	/**
	 * Returns whether the block has hits left
	 * 
	 * @param blockID
	 *            blockID ID of the chosen block
	 * @return true, if block has hits left, else false
	 */
	public boolean hasHitsLeft(String blockID) {
    //TODO write code to return if the given block still has hits left
	  return false;
	}

	/* ***************************************************
	 * ********************** Stick **********************
	 * ***************************************************
	 */
	public Vector2f getStickPosition() {
	  //TODO write code to return the position of the stick
	  return new Vector2f(0, 200); // these are arbitrary values(!)
	}

	/* ***************************************************
	 * ********************** Input **********************
	 * ***************************************************
	 */

	/**
	 * This Method should emulate the key down event.
	 * 
	 * @param updatetime
	 *            : Zeitdauer bis update-Aufruf
	 * @param input
	 *            : z.B. Input.KEY_K, Input.KEY_L
	 */
	public void handleKeyDown(int updatetime, Integer input) {
	  //TODO write code that handles a "key pressed" event
	  // note: do not forget to call app.updateGame(updatetime);
	}

	/**
	 * This Method should emulate the pressing of the right arrow key.
	 */
	public void handleKeyDownRightArrow() {
	  //TODO write code for handling a "right arrow" key press
	  // hint: you may use the above method.
	}

	/**
	 * This Method should emulate the pressing of the left arrow key.
	 */
	public void handleKeyDownLeftArrow() {
    //TODO write code for handling a "left arrow" key press
    // hint: you may use the above method.
	}
}
