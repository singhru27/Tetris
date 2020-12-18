package app.impl;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import util.Constants;

/*
 * I used this class to delegate the logic for board clearing and completion checking, as well as for new shape completion
 * This could have been implemented in the Game class, but I wanted to delegate some of the logic to another class to make
 * the sequence of logic easier to follow 
 */

public class TetrisBuilder {

	private Pane _tetrisPane;
	private Rectangle[][] _tetrisArray;
	private TetrisShape _tetrisShape;
	private int _score;
	private Label _scoreLabel;

	/*
	 * My TetrisBuilder class takes in a Pane, an Array, and a _tetrisShape as
	 * parameters. The _tetrisShape is initially set to be a null value. This class
	 * also creates a score counter and adds it to the pane
	 */

	public TetrisBuilder(Rectangle[][] array, Pane pane, Label scoreLabel) {

		_tetrisPane = pane;
		_scoreLabel = scoreLabel;
		_tetrisArray = array;
		_tetrisShape = null;
		_score = 0;

	}

	/*
	 * This method randomly generates a new TetrisShape using a random number
	 * generator
	 */

	public void newShape() {

		int random = (int) (Math.random() * 7 + 1);
		switch (random) {

		case 1:
			_tetrisShape = new TetrisShape1(_tetrisArray, _tetrisPane);
			break;

		case 2:
			_tetrisShape = new TetrisShape2(_tetrisArray, _tetrisPane);
			break;

		case 3:
			_tetrisShape = new TetrisShape3(_tetrisArray, _tetrisPane);
			break;

		case 4:
			_tetrisShape = new TetrisShape4(_tetrisArray, _tetrisPane);
			break;

		case 5:
			_tetrisShape = new TetrisShape5(_tetrisArray, _tetrisPane);
			break;

		case 6:
			_tetrisShape = new TetrisShape6(_tetrisArray, _tetrisPane);
			break;

		case 7:
			_tetrisShape = new TetrisShape7(_tetrisArray, _tetrisPane);
			break;

		}

	}

	/*
	 * This method returns the current _tetrisShape variable
	 */

	public TetrisShape getShape() {

		return _tetrisShape;
	}

	/*
	 * This method is used to check if there are any cleared rows on the board. If
	 * there are, it calls the clearBoard method to clear that row graphically and
	 * logically. This method also increases the score by 10 every time a row is
	 * cleared
	 */

	public void checkForRowCompletion() {

		Boolean clear = null;

		for (int i = 2; i < 22; i++) {

			for (int j = 2; j < 14; j++) {

				if (_tetrisArray[i][j] != null) {

					clear = true;
				} else {

					clear = false;
					break;
				}

			}

			if (clear) {

				_score = _score + 10;
				_scoreLabel.setText(Integer.toString(_score));

				this.clearBoard(i);
			}

		}

	}

	/*
	 * This method clears the row of the playable board, taking in the "ith" row as
	 * a parameter. It also shifts the rest of the tetris squares down to fill in
	 * the gaps left by the cleared out rows
	 */

	public void clearBoard(int row) {

		for (int j = 2; j < 14; j++) {

			_tetrisPane.getChildren().remove(_tetrisArray[row][j]);
			_tetrisArray[row][j] = null;
		}

		for (int i = (row - 1); i > 2; i--) {

			for (int j = 2; j < 14; j++) {

				if (_tetrisArray[i][j] == null) {

				} else {

					Rectangle rect = _tetrisArray[i][j];
					rect.setY(i * Constants.RECTANGLE_SIZE + Constants.RECTANGLE_SIZE);
					_tetrisArray[(int) (rect.getY() / Constants.RECTANGLE_SIZE)][j] = rect;
					_tetrisArray[i][j] = null;

				}

			}

		}

	}

}
