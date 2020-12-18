package app.impl;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import util.Constants;

/*
 * This is the abstract superclass that contains all of the methods that the tetris piece subclasses will all need to use
 */
public abstract class TetrisShape {

	/*
	 * Initializing the variables that all TetrisShapes must take in as parameters.
	 * The TetrisShape takes in the _tetrisArray and the _tetrisPane as parameters,
	 * and creates 4 new rectangles to comprise the shape. This method also sets the
	 * initial size of all the rectangles
	 * 
	 */

	private Rectangle _rect1;
	private Rectangle _rect2;
	private Rectangle _rect3;
	private Rectangle _rect4;
	private Rectangle[][] _tetrisArray;
	private Pane _tetrisPane;

	public TetrisShape(Rectangle[][] array, Pane pane) {

		_tetrisArray = array;
		_tetrisPane = pane;
		_rect1 = new Rectangle(Constants.RECTANGLE_SIZE, Constants.RECTANGLE_SIZE);
		_rect1.setStroke(Color.BLACK);
		_rect2 = new Rectangle(Constants.RECTANGLE_SIZE, Constants.RECTANGLE_SIZE);
		_rect2.setStroke(Color.BLACK);
		_rect3 = new Rectangle(Constants.RECTANGLE_SIZE, Constants.RECTANGLE_SIZE);
		_rect3.setStroke(Color.BLACK);
		_rect4 = new Rectangle(Constants.RECTANGLE_SIZE, Constants.RECTANGLE_SIZE);
		_rect4.setStroke(Color.BLACK);

	}

	/*
	 * The following four methods are used to retrieve the rectangles
	 */

	public Rectangle getRectangle1() {

		return _rect1;
	}

	public Rectangle getRectangle2() {

		return _rect2;
	}

	public Rectangle getRectangle3() {

		return _rect3;
	}

	public Rectangle getRectangle4() {

		return _rect4;
	}

	/*
	 * This method is used to translate all the rectangles contained within the
	 * shape down by 1 unit block on the boards
	 */

	public void moveDown() {

		_rect1.setY(_rect1.getY() + Constants.RECTANGLE_SIZE);
		_rect2.setY(_rect2.getY() + Constants.RECTANGLE_SIZE);
		_rect3.setY(_rect3.getY() + Constants.RECTANGLE_SIZE);
		_rect4.setY(_rect4.getY() + Constants.RECTANGLE_SIZE);
	}

	/*
	 * This method moves every rectangle within the tetris shape to the left by one
	 * 1 unit block on the boards
	 */

	public void moveLeft() {
		_rect1.setX(_rect1.getX() - Constants.RECTANGLE_SIZE);
		_rect2.setX(_rect2.getX() - Constants.RECTANGLE_SIZE);
		_rect3.setX(_rect3.getX() - Constants.RECTANGLE_SIZE);
		_rect4.setX(_rect4.getX() - Constants.RECTANGLE_SIZE);
	}

	/*
	 * This method moves every rectangle within the TetrisShape to the right by 1
	 * unit block on the boards
	 */
	
	public void moveRight() {

		_rect1.setX(_rect1.getX() + Constants.RECTANGLE_SIZE);
		_rect2.setX(_rect2.getX() + Constants.RECTANGLE_SIZE);
		_rect3.setX(_rect3.getX() + Constants.RECTANGLE_SIZE);
		_rect4.setX(_rect4.getX() + Constants.RECTANGLE_SIZE);
	}

	/*
	 * This abstract method for determining rotation validity needs to be defined in each of the subclasses
	 */
	
	public abstract boolean checkRotationValidity ();
	
	/*
	 * This abstract method needs to be defined in each of the subclasses
	 */

	public abstract void Rotate();

	/*
	 * This method checks to ensure that the current moving piece cannot enter a 
	 * square that is already occupied by a different piece below it. It converts the 
	 * location of the rectangle to a numerical index in the arrya, and checks if that last
	 * spot in the array is occupied. This method will also add the moving shapes into the main game 
	 * array if it finds that the shapes can no longer move down
	 */
	
	public boolean checkYValidity() {

		if (_tetrisArray[(int) (_rect1.getY() / Constants.RECTANGLE_SIZE) + 1][(int) (_rect1.getX()
				/ Constants.RECTANGLE_SIZE)] == null
				&& _tetrisArray[(int) (_rect2.getY() / Constants.RECTANGLE_SIZE) + 1][(int) (_rect2.getX()
						/ Constants.RECTANGLE_SIZE)] == null
				&& _tetrisArray[(int) (_rect3.getY() / Constants.RECTANGLE_SIZE) + 1][(int) (_rect3.getX()
						/ Constants.RECTANGLE_SIZE)] == null
				&& _tetrisArray[(int) (_rect4.getY() / Constants.RECTANGLE_SIZE) + 1][(int) (_rect4.getX()
						/ Constants.RECTANGLE_SIZE)] == null) {

			return true;

		} else {
			
			_tetrisArray [(int) (_rect1.getY()/Constants.RECTANGLE_OFFSET)][(int) (_rect1.getX()/Constants.RECTANGLE_SIZE)] = _rect1;
			_tetrisArray [(int) (_rect2.getY()/Constants.RECTANGLE_OFFSET)][(int) (_rect2.getX()/Constants.RECTANGLE_SIZE)] = _rect2;
			_tetrisArray [(int) (_rect3.getY()/Constants.RECTANGLE_OFFSET)][(int) (_rect3.getX()/Constants.RECTANGLE_SIZE)] = _rect3;
			_tetrisArray [(int) (_rect4.getY()/Constants.RECTANGLE_OFFSET)][(int) (_rect4.getX()/Constants.RECTANGLE_SIZE)] = _rect4;
			return false;
		}


	}
	/*
	 * This method checks to ensure that the current moving piece cannot enter a
	 * square that is already occupied by a different piece. It converts the
	 * location of the rectangle to a numerical index in the array, and checks if
	 * that spot in the array is occupied.
	 */

	public boolean checkRightXValidity() {

		if (_tetrisArray[(int) (_rect1.getY() / Constants.RECTANGLE_SIZE)][(int) (_rect1.getX()
				/ Constants.RECTANGLE_SIZE) + 1] == null
				&& _tetrisArray[(int) (_rect2.getY() / Constants.RECTANGLE_SIZE)][(int) (_rect2.getX()
						/ Constants.RECTANGLE_SIZE) + 1] == null
				&& _tetrisArray[(int) (_rect3.getY() / Constants.RECTANGLE_SIZE)][(int) (_rect3.getX()
						/ Constants.RECTANGLE_SIZE) + 1] == null
				&& _tetrisArray[(int) (_rect4.getY() / Constants.RECTANGLE_SIZE)][(int) (_rect4.getX()
						/ Constants.RECTANGLE_SIZE) + 1] == null) {

			return true;

		}
		return false;

	}

	/*
	 * This method checks to ensure that the current moving piece cannot enter a
	 * square that is already occupied by a different piece. It converts the
	 * location of the rectangle to a numerical index in the array, and checks if
	 * that spot in the array is occupied.
	 */

	public boolean checkLeftXValidity() {
		
		if (_tetrisArray[(int) (_rect1.getY() / Constants.RECTANGLE_SIZE)][(int) (_rect1.getX()
				/ Constants.RECTANGLE_SIZE) - 1] == null
				&& _tetrisArray[(int) (_rect2.getY() / Constants.RECTANGLE_SIZE)][(int) (_rect2.getX()
						/ Constants.RECTANGLE_SIZE) - 1] == null
				&& _tetrisArray[(int) (_rect3.getY() / Constants.RECTANGLE_SIZE)][(int) (_rect3.getX()
						/ Constants.RECTANGLE_SIZE) - 1] == null
				&& _tetrisArray[(int) (_rect4.getY() / Constants.RECTANGLE_SIZE)][(int) (_rect4.getX()
						/ Constants.RECTANGLE_SIZE) - 1] == null) {

			return true;

		}
		return false;

	}

	/*
	 * This method returns the pane that was passed into the constructor
	 */

	public Pane getPane() {
		return _tetrisPane;
	}
	
	/*
	 * This method returns the array that was passed into the constructor
	 */
	
	public Rectangle [][] getArray () {
		return _tetrisArray;
	}

}
