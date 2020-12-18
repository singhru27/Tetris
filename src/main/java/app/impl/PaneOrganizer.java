package app.impl;

import javafx.scene.layout.BorderPane;

/*
 * In the constructor, I create a new BorderPane, and a new instance of the Game class. I pass in the BorderPane as 
 * a parameter to my game class
 */

public class PaneOrganizer {

	private BorderPane _root;

	public PaneOrganizer() {

		_root = new BorderPane();
		Game _tetrisGame = new Game (_root);

	}

	/*
	 * This method returns the BorderPane _root that was instantiated in the
	 * Constructor
	 */

	public BorderPane getRoot() {

		return _root;
	}

}
