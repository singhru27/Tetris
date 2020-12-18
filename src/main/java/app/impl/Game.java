package app.impl;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import util.Constants;

public class Game {

	/*
	 * I initialize instances of the BorderPane, a Pane, an Array, and my
	 * Tetrisbuilder class. I also create a boolean variable called _steadyState,
	 * and a boolean called pause state. I also make the timeline an instance
	 * variable so that the pause method can unpause and pause the game
	 */

	private BorderPane _root;
	private Pane _tetrisPane;
	private Rectangle[][] _tetrisArray;
	private TetrisBuilder _tetrisBuilder;
	private boolean _steadyState;
	private boolean _pauseState;
	private Timeline _timeline;
	private Label _scoreLabel;

	/*
	 * In the constructor, I have the Game take in a borderPane as a parameter. I
	 * create a new _tetrisPane Pane, and set this to the center of the BorderPane.
	 * I then call methods to set up the initial state of the board, to set up the
	 * quit button, and to set up the animation timeline. My _steadyState variable
	 * is responsible for determining whether or not a piece is currently moving
	 * down the board, and the initial value of this value is set to null
	 */

	public Game(BorderPane borderPane) {

		_root = borderPane;
		_scoreLabel = new Label ("0");
		_steadyState = true;
		_pauseState = false;
		_tetrisPane = new Pane();
		_tetrisPane.setPrefSize(Constants.PANE_SIZE_X, Constants.PANE_SIZE_Y);
		_tetrisArray = new Rectangle[24][16];
		_root.setCenter(_tetrisPane);
		_tetrisBuilder = new TetrisBuilder(_tetrisArray, _tetrisPane, _scoreLabel);
		this.setUpQuitButton();
		this.setUpInitialState();
		this.setUpTimeline();

	}

	/*
	 * This method sets up the timeline which controls the animation for the tetris
	 * game
	 */

	public void setUpTimeline() {

		KeyFrame kf = new KeyFrame(Duration.seconds(Constants.DURATION), new TimeHandler());
		_timeline = new Timeline(kf);
		_timeline.setCycleCount(Animation.INDEFINITE);
		_timeline.play();
	}

	/*
	 * This private inner class contains the logic for the animation of tetris. If
	 * the game is in a "steady state" in which no pieces are moving, the game
	 * checks for row completion, checks for game completion, and then creates a new
	 * piece and sets the _steady state to false. If the game is not in a
	 * "steady state", the game continues to move the current piece downwards.
	 */

	private class TimeHandler implements EventHandler<ActionEvent> {

		public void handle(ActionEvent event) {

			if (_steadyState) {

				_tetrisBuilder.checkForRowCompletion();

				for (int j = 2; j < 12; j++) {

					if (_tetrisArray[2][j] != null) {
						Game.this.endGame();
					}
				}

				if (_tetrisArray[4][8] != null) {
					Game.this.endGame();
				} else {
					_tetrisBuilder.newShape();
					_steadyState = false;
				}

			} else if (_tetrisBuilder.getShape().checkYValidity()) {
				_tetrisBuilder.getShape().moveDown();

			} else {

				_steadyState = true;
			}
		}

	}

	/*
	 * This method contains the logic for creating a new quit button that quits the
	 * application
	 */

	public void setUpQuitButton() {

		VBox UserInputBox = new VBox();
		Button QuitButton = new Button("Quit Tetris");
		QuitButton.setFocusTraversable(false);
		QuitButton.setOnAction(new QuitHandler());
		QuitButton.setFocusTraversable(false);
		UserInputBox.getChildren().add(QuitButton);
		_root.setRight(UserInputBox);

	}

	/*
	 * This private inner class is responsible for moving the current tetris shape
	 * to the right, left, and rotations. It it also responsible for pausing the
	 * game and for dropping the tetris shape onto the ground
	 */

	private class KeyHandler implements EventHandler<KeyEvent> {

		public void handle(KeyEvent e) {
			KeyCode keyPressed = e.getCode();

			switch (keyPressed) {

			/*
			 * The left and right methods check if the square is occupied. If the square is
			 * not occupied, the movement is allowed to proceed. They only work if the game
			 * is unpaused
			 */

			case RIGHT:

				if (_pauseState == false) {

					if (_tetrisBuilder.getShape().checkRightXValidity()) {
						_tetrisBuilder.getShape().moveRight();

					}

				}

				break;

			case LEFT:

				if (_pauseState == false) {
					if (_tetrisBuilder.getShape().checkLeftXValidity()) {
						_tetrisBuilder.getShape().moveLeft();

					}

				}
				break;

			/*
			 * The DOWN method checks if the square below the tetris piece is occupied. If
			 * it isn't occupied, the piece is moved down by one block unit. If the piece is
			 * unable to move further the _steadyState variable is set to true. This only
			 * works if the game is unpaused
			 */

			case DOWN:
				if (_pauseState == false) {
					if (_tetrisBuilder.getShape().checkYValidity()) {
						_tetrisBuilder.getShape().moveDown();

					} else {

						_steadyState = true;
					}

				}
				break;

			/*
			 * The UP method rotates the moving piece if the new squares that it will be
			 * moving into are not occupied. This only works when the game is unpaused
			 */

			case UP:
				if (_pauseState == false) {
					if (_tetrisBuilder.getShape().checkRotationValidity()) {
						_tetrisBuilder.getShape().Rotate();
					}

				}
				break;
			/*
			 * This method moves the shape down as long as there is nothing blocking it.
			 * After the piece hits the bottom, The _steadyState variable is set to true.
			 * This only works when the game is unpaused
			 */

			case SPACE:
				if (_pauseState == false) {

					while (_tetrisBuilder.getShape().checkYValidity()) {
						_tetrisBuilder.getShape().moveDown();
					}

					_steadyState = true;

				}

				break;

			/*
			 * This method pauses and unpauses the game when the P button is pressed. It
			 * also creates and removes a label that informs the user that the game is or
			 * isn't paused
			 */

			case P:
				if (_pauseState == false) {
					_timeline.stop();
					_pauseState = true;
					Label pauseLabel = new Label("Paused Game");
					_root.setTop(pauseLabel);

				} else {
					_timeline.play();
					_pauseState = false;
					_root.setTop(null);
				}
				break;

			default:
				break;

			}
			e.consume();

		}
	}

	/*
	 * This class contains the logic for quitting the game when the button is
	 * pressed
	 */

	private class QuitHandler implements EventHandler<ActionEvent> {

		public void handle(ActionEvent event) {

			System.exit(0);
		}

	}

	/*
	 * This method fills the outside two rows and columns with black rectangles, and
	 * causes the _tetrisPane to respond to key inputs. A series of nested for loops
	 * are used to sequentially fill in the pane with black rectangles, and to add
	 * these rectangles to the _tetrisArray. This method also adds the _scoreLabel
	 * to the screen
	 */

	public void setUpInitialState() {

		_root.setLeft(_scoreLabel);
		// This initial for loop logic fills out the top two rows of the tetris board

		double rectXPosition = Constants.RECTANGLE_INITIAL_X_POSITION;
		double rectYPosition = Constants.RECTANGLE_INITIAL_Y_POSITION;

		for (int i = 0; i < 2; i++) {

			for (int j = 0; j < _tetrisArray[0].length; j++) {
				Rectangle rect = new Rectangle();
				rect.setFill(Color.BLACK);
				rect.setStroke(Color.BLUE);
				rect.setX(rectXPosition);
				rect.setY(rectYPosition);
				rect.setWidth(Constants.RECTANGLE_SIZE);
				rect.setHeight(Constants.RECTANGLE_SIZE);

				rectXPosition = rectXPosition + Constants.RECTANGLE_OFFSET;

				_tetrisArray[i][j] = rect;
				_tetrisPane.getChildren().add(rect);

			}

			rectYPosition = rectYPosition + Constants.RECTANGLE_OFFSET;
			rectXPosition = Constants.RECTANGLE_INITIAL_X_POSITION;

		}

		// This for loop logic fills out the bottom two rows of the tetris board

		rectXPosition = Constants.RECTANGLE_INITIAL_X_POSITION;
		rectYPosition = Constants.RECTANGLE_INITIAL_Y_POSITION + Constants.RECTANGLE_OFFSET * 22;

		for (int i = 22; i < 24; i++) {

			for (int j = 0; j < _tetrisArray[0].length; j++) {
				Rectangle rect = new Rectangle();
				rect.setFill(Color.BLACK);
				rect.setStroke(Color.BLUE);
				rect.setX(rectXPosition);
				rect.setY(rectYPosition);
				rect.setWidth(Constants.RECTANGLE_SIZE);
				rect.setHeight(Constants.RECTANGLE_SIZE);

				rectXPosition = rectXPosition + Constants.RECTANGLE_OFFSET;

				_tetrisArray[i][j] = rect;
				_tetrisPane.getChildren().add(rect);

			}

			rectYPosition = rectYPosition + Constants.RECTANGLE_OFFSET;
			rectXPosition = Constants.RECTANGLE_INITIAL_X_POSITION;

		}

		// This for loop logic fills out the left two rows of the tetris board

		rectXPosition = Constants.RECTANGLE_INITIAL_X_POSITION;
		rectYPosition = Constants.RECTANGLE_INITIAL_Y_POSITION;

		for (int j = 0; j < 2; j++) {

			for (int i = 0; i < _tetrisArray.length; i++) {
				Rectangle rect = new Rectangle();
				rect.setFill(Color.BLACK);
				rect.setStroke(Color.BLUE);
				rect.setX(rectXPosition);
				rect.setY(rectYPosition);
				rect.setWidth(Constants.RECTANGLE_SIZE);
				rect.setHeight(Constants.RECTANGLE_SIZE);

				rectYPosition = rectYPosition + Constants.RECTANGLE_OFFSET;
				_tetrisArray[i][j] = rect;
				_tetrisPane.getChildren().add(rect);
			}

			rectXPosition = rectXPosition + Constants.RECTANGLE_OFFSET;
			rectYPosition = Constants.RECTANGLE_INITIAL_Y_POSITION;

		}

		// This for loop logic fills out the right two rows of the tetris board

		rectXPosition = Constants.RECTANGLE_INITIAL_X_POSITION + Constants.RECTANGLE_OFFSET * 14;
		rectYPosition = Constants.RECTANGLE_INITIAL_Y_POSITION;

		for (int j = 14; j < 16; j++) {

			for (int i = 0; i < _tetrisArray.length; i++) {
				Rectangle rect = new Rectangle();
				rect.setFill(Color.BLACK);
				rect.setStroke(Color.BLUE);
				rect.setX(rectXPosition);
				rect.setY(rectYPosition);
				rect.setWidth(Constants.RECTANGLE_SIZE);
				rect.setHeight(Constants.RECTANGLE_SIZE);

				rectYPosition = rectYPosition + Constants.RECTANGLE_OFFSET;
				_tetrisArray[i][j] = rect;
				_tetrisPane.getChildren().add(rect);
			}

			rectXPosition = rectXPosition + Constants.RECTANGLE_OFFSET;
			rectYPosition = Constants.RECTANGLE_INITIAL_Y_POSITION;

		}

		_tetrisPane.setOnKeyPressed(new KeyHandler());
		_tetrisPane.requestFocus();
		_tetrisPane.setFocusTraversable(true);

	}

	/*
	 * This method ends the game by stopping the animation, removing the ability to
	 * move the tetris pieces, and add a "game over" label
	 */

	public void endGame() {
		_timeline.stop();
		_tetrisPane.setOnKeyPressed(null);
		Label endLabel = new Label("Game Over");
		_root.setCenter(endLabel);
	}

}
